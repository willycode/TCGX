package com.kangdainfo.util.net;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;

import javax.net.ssl.SSLException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.ftp.FTPSClient;

import com.kangdainfo.common.util.Common;
import com.kangdainfo.util.io.FileIO;

public class FtpRouter {

	private FtpRoutingContext ftpRoutingContext;
	private FTPClient ftpClient;
	boolean useSSL = false;
		
	private String getFilename(String fullname) {
		String filename = null;
		fullname = fullname.replace('\\', '/' );
		StringTokenizer token = new StringTokenizer(fullname, "/");
		while (token.hasMoreTokens()) {
			filename = token.nextToken();
		}
		return filename;
	}	
	
	public FtpRouter(FtpRoutingContext ftpRoutingContext) {
		this.ftpRoutingContext = ftpRoutingContext;
		useSSL = Common.get(this.ftpRoutingContext.getUsingSSL()).equals("Y");		
		if(useSSL){
			ftpClient = new FTPSClient(false);	
		} else {
			ftpClient = new FTPClient();	
		}		
		ftpClient.setControlEncoding((ftpRoutingContext.getEncoding()!=null && ftpRoutingContext.getEncoding().length()>0)?ftpRoutingContext.getEncoding():"MS950");
		ftpClient.setDataTimeout(30*60*1000);
	}
	
	public void connect() throws IOException {
		ftpClient.connect(ftpRoutingContext.getHost(),ftpRoutingContext.getPort());
	}
	

	public boolean login() throws IOException {
		return ftpClient.login(ftpRoutingContext.getUsername(), ftpRoutingContext.getPassword());
	}
	
	public boolean complete() throws IOException {
		int reply = 0;

    	// After connection attempt, you should check the reply code to verify
    	// success.
    	reply = ftpClient.getReplyCode();

    	if(!FTPReply.isPositiveCompletion(reply)) {
    		ftpClient.disconnect();
    		return false;
    	}
    	return true;
	}
	
	public boolean changeWorkingDirectory(String remoteDir) throws IOException {
    	if(remoteDir!=null && remoteDir.length()>0) {
	    	return ftpClient.changeWorkingDirectory(remoteDir);
    	}
    	return false;
	}
	
	public boolean changeToParentDirectory() throws IOException {
		return ftpClient.changeToParentDirectory();
	}

	public boolean logout() throws IOException {
		return ftpClient.logout();
	}
	public void disconnect() throws IOException {
		ftpClient.disconnect();
	}
	
	public void openSession() throws IOException {
		connect();
		login();		
		complete();
		if(useSSL){
		    try {
		   		// Set protection buffer size		    	
		   		((FTPSClient)ftpClient).execPBSZ(0);
		   		// Set data channel protection to private
		   		((FTPSClient)ftpClient).execPROT("P");
		   	} catch (SSLException e) {
		   		e.printStackTrace();
		   	} catch (IOException e) {
		   		e.printStackTrace();
		   	}
		}				
		
	   	
		try {					
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			if (Common.get(ftpRoutingContext.getEnterLocalPassiveMode()).equals("Y")) {
				ftpClient.enterLocalPassiveMode();
			}
			if (ftpRoutingContext.getDefaultDirectory()!=null && ftpRoutingContext.getDefaultDirectory().length()>0) {
				if(!changeWorkingDirectory(ftpRoutingContext.getDefaultDirectory())){
					makeDirectory(ftpRoutingContext.getDefaultDirectory());
					changeWorkingDirectory(ftpRoutingContext.getDefaultDirectory());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	public void closeSession() {
		try {
			logout();
			disconnect();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean moveFile(String from, String to) throws IOException{
		return ftpClient.rename(from, to);
	}
	
	public boolean makeDirectory(String remoteDirName) throws IOException {
		return ftpClient.makeDirectory(remoteDirName);
	}
	
	public boolean makeDirectory(String remoteDirName, boolean isAll) throws IOException {
		if (!isAll) {   
    		return makeDirectory(remoteDirName);   
    	}
		
		boolean isOk = false;
		try {
			String[] dirs = remoteDirName.split("/");
			for(int i=0; i<dirs.length; i++) {
				String tmpStr = Common.get(dirs[i]);
				if(!"".equals(tmpStr) && !ftpClient.changeWorkingDirectory(tmpStr)) {
					ftpClient.makeDirectory(tmpStr);
					if(!ftpClient.changeWorkingDirectory(tmpStr)) {
						return false;
					}
				}
			}
			
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return isOk;
	}
	
	public boolean removeDirectory(String remoteDirName) throws IOException {
		return ftpClient.removeDirectory(remoteDirName);
	}	
	
    public boolean removeDirectory(String remoteDirName, boolean isAll) throws IOException {   
    	if (!isAll) {   
    		return removeDirectory(remoteDirName);   
    	}   
    	FTPFile[] ftpFileArr = ftpClient.listFiles(remoteDirName);   
    	if (ftpFileArr == null || ftpFileArr.length == 0) {   
    		//有些Ftp Server對於回傳FTPFile[]會無效,所以只好在這裡再加一段
        	String[] fileNames = ftpClient.listNames(remoteDirName);
        	if (fileNames!=null && fileNames.length>0) {
        		for (String fileName : fileNames) {
        			ftpClient.deleteFile(remoteDirName + "/" + getFilename(fileName));
        		}    		
        	}        	
    		return removeDirectory(remoteDirName);   
    	}   
    	for (FTPFile ftpFile : ftpFileArr) {   
    		String name = ftpFile.getName();
    		if (ftpFile.isDirectory()) {                
    			removeDirectory(remoteDirName + "/" + name, true);   
    		} else if (ftpFile.isFile()) {   
    			ftpClient.deleteFile(remoteDirName + "/" + name);   
    		} else if (ftpFile.isSymbolicLink()) {   

    		} else if (ftpFile.isUnknown()) {   

    		}   
    	}   
    	return ftpClient.removeDirectory(remoteDirName);   
    } 	
	
	public boolean upload(String remoteDir, String remoteFileName, InputStream f) throws IOException {
		if (remoteDir!=null && !"".equals(remoteDir)) changeWorkingDirectory(remoteDir);		
		return ftpClient.storeFile(remoteFileName, f);
	}
	
	public boolean upload(String remoteDir, String remoteFileName, File f) throws IOException {
		if (remoteDir!=null && !"".equals(remoteDir)) changeWorkingDirectory(remoteDir);	
		boolean sFlag = false;
		InputStream is = new FileInputStream(f);
		sFlag = ftpClient.storeFile(remoteFileName, is);
		is.close();
		return sFlag;
	}
	
	public boolean upload(String remoteDir, String remoteFileName, String content) throws IOException {
		if (remoteDir!=null && !"".equals(remoteDir)) changeWorkingDirectory(remoteDir);
		return ftpClient.storeFile(remoteFileName, new ByteArrayInputStream(content.getBytes()));
	}
	
	public boolean upload(String remoteDir, String remoteFileName, File localDir, String localFileShortName) throws IOException {
		if (remoteDir!=null && !"".equals(remoteDir)) changeWorkingDirectory(remoteDir);		
		File file = new File(localDir + File.separator + localFileShortName);
		return ftpClient.storeFile(remoteFileName, new FileInputStream(file));
	}
	
	public boolean downloadFile(String remoteDir, String remoteFileName, java.io.OutputStream localStream) throws IOException {
		if (remoteDir!=null && !"".equals(remoteDir)) changeWorkingDirectory(remoteDir);		
		return ftpClient.retrieveFile(remoteFileName, localStream);
	}
	
	public InputStream downloadFile(String remoteDir, String remoteFileName) throws IOException {
		if (remoteDir!=null && !"".equals(remoteDir)) changeWorkingDirectory(remoteDir);		
		return ftpClient.retrieveFileStream(remoteFileName);
	}
	
	public String downloadAsString(String remoteDir, String remoteFileName) throws IOException {
		if (remoteDir!=null && !"".equals(remoteDir)) changeWorkingDirectory(remoteDir);
		InputStream in = ftpClient.retrieveFileStream(remoteFileName);		
		return FileIO.toString(in, ftpClient.getControlEncoding());
	}
	
	public File downloadAsFile(String remoteDir, String remoteFileName, File localDir) throws IOException {
		File outputFile = new File(localDir,remoteFileName);
		java.io.OutputStream ou = new java.io.FileOutputStream(outputFile);
		downloadFile(remoteDir, remoteFileName, ou);
		ou.close();
		return outputFile;
	}
	
	public String[] listFileNames() throws IOException {
		return ftpClient.listNames();
	}
	
	public String[] listFileNames(String remoteDir) throws IOException {
		return ftpClient.listNames(remoteDir);
	}
	
	public String getCurrentRemoteWorkingDirectory() throws IOException {
		return ftpClient.printWorkingDirectory();
	}
	
	public FTPFile[] listFiles() throws IOException {
		return ftpClient.listFiles();
	}
	
	public FTPFile[] listFiles(String remoteDir) throws IOException {
		return ftpClient.listFiles(remoteDir);
	}

	public boolean deleteFile(String remoteFileName) throws IOException {
		return ftpClient.deleteFile(remoteFileName);
	}
	
	public boolean exists(String remoteDir , String remoteFileName) throws IOException {
		boolean reValue = false;
		String[] fileNames = listFileNames(remoteDir);
		if(null != fileNames && fileNames.length > 0){
			for(String fileName : fileNames){
				if (getFilename(fileName).equals(Common.get(remoteFileName))) {
					reValue = true;
					return true;
				}
			}
		}		
		return reValue;
	}
	
	public boolean deleteFile(String remoteDir,String remoteFileName) throws IOException {
		return ftpClient.deleteFile(remoteDir + "/" + remoteFileName);
	}
	
	public void setDefaultTimeout(int timeout) {
		ftpClient.setDefaultTimeout(timeout);
	}
}
