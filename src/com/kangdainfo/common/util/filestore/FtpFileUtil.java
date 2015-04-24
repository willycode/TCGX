package com.kangdainfo.common.util.filestore;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPFile;

import com.kangdainfo.ServiceGetter;
import com.kangdainfo.common.util.Common;
import com.kangdainfo.util.net.FtpRoutingContext;

public class FtpFileUtil {
	
	private FtpFileUtil() {}
	
	/**
	 * 將路徑過濾掉，只傳回檔名
	 */
	public static String getFilename(String fullname) {
		String filename = null;
		fullname = fullname.replace('\\', '/' );
		StringTokenizer token = new StringTokenizer(fullname, "/");
		while (token.hasMoreTokens()) {
			filename = token.nextToken();
		}
		return filename;
	}
	
	public static byte[] download(String remoteDirName) throws IOException {
		if (!"".equals(Common.get(remoteDirName))) {
			String[] arrFileName = remoteDirName.split(":;:");
			if (arrFileName.length>0) {	
				byte[] b = null;
				String fileName = arrFileName[1];
				com.kangdainfo.util.net.FtpRouter ftp = new com.kangdainfo.util.net.FtpRouter(ServiceGetter.getInstance().getCommonService().getFtpRoutingContext());
				ftp.setDefaultTimeout(3000);
				ftp.openSession();
				String[] fileNames = ftp.listFileNames(arrFileName[0]);
				if (fileNames!=null && fileNames.length>0) {
					fileName = FtpFileUtil.getFilename(fileNames[0]);
					java.io.InputStream ftpStream = ftp.downloadFile(arrFileName[0], fileName);
					b = IOUtils.toByteArray(ftpStream);
					ftpStream.close();       			
				}
				ftp.closeSession();
				return b;
			}
		}
   		return null;
	}
	
	public static byte[] download2(String remoteDirName, String serverType) throws IOException {
		if (!"".equals(Common.get(remoteDirName))) {
			String[] arrFileName = remoteDirName.split(":;:");
			if (arrFileName.length>0) {	
				byte[] b = null;
				String fileName = arrFileName[1];
				com.kangdainfo.util.net.FtpRouter ftp = new com.kangdainfo.util.net.FtpRouter(ServiceGetter.getInstance().getCommonService().getFtpRoutingContext(serverType));
				ftp.setDefaultTimeout(3000);
				ftp.openSession();
				String[] fileNames = ftp.listFileNames(arrFileName[0]);
				if (fileNames!=null && fileNames.length>0) {
					fileName = FtpFileUtil.getFilename(fileNames[0]);
					java.io.InputStream ftpStream = ftp.downloadFile(arrFileName[0], fileName);
					b = IOUtils.toByteArray(ftpStream);
					ftpStream.close();       			
				}
				ftp.closeSession();
				return b;
			}
		}
   		return null;
	}
	
	public static void upload(String remoteDir, String remoteFileName, InputStream uploadFile) throws IOException {
		com.kangdainfo.util.net.FtpRouter ftp = new com.kangdainfo.util.net.FtpRouter(ServiceGetter.getInstance().getCommonService().getFtpRoutingContext());
		ftp.setDefaultTimeout(3000);
		ftp.openSession();
		ftp.makeDirectory(remoteDir);
		ftp.upload(remoteDir, remoteFileName, uploadFile);
		ftp.closeSession(); 		
	}
	
	public static void upload2(String remoteDir, String remoteFileName, InputStream uploadFile, String serverType) throws IOException {
		com.kangdainfo.util.net.FtpRouter ftp = new com.kangdainfo.util.net.FtpRouter(ServiceGetter.getInstance().getCommonService().getFtpRoutingContext(serverType));
		ftp.setDefaultTimeout(3000);
		ftp.openSession();
		ftp.makeDirectory(remoteDir, true);
		for(int i = 0; i < 50; i++){
			if(ftp.upload(remoteDir, remoteFileName, uploadFile)){
				ftp.closeSession();
				return;
			}
		}
		ftp.closeSession();
	}

	public static boolean upload(String remoteDir, String remoteFileName, File uploadFile) throws IOException {
		com.kangdainfo.util.net.FtpRouter ftp = new com.kangdainfo.util.net.FtpRouter(ServiceGetter.getInstance().getCommonService().getFtpRoutingContext());
		ftp.setDefaultTimeout(3000);
		ftp.openSession();
		ftp.makeDirectory(remoteDir);
		boolean result = ftp.upload(remoteDir, remoteFileName, uploadFile);
		ftp.closeSession();
		return result;
	}
	
	public static boolean upload2(String remoteDir, String remoteFileName, File uploadFile, String serverType) throws IOException {
		com.kangdainfo.util.net.FtpRouter ftp = new com.kangdainfo.util.net.FtpRouter(ServiceGetter.getInstance().getCommonService().getFtpRoutingContext(serverType));
		ftp.setDefaultTimeout(3000);
		ftp.openSession();
		ftp.makeDirectory(remoteDir, true);
		boolean result = ftp.upload(remoteDir, remoteFileName, uploadFile);
		ftp.closeSession();
		return result;
	}
	
	public static InputStream download(String remoteDir, String fileName) throws IOException {
		java.io.InputStream ftpStream = null;
		com.kangdainfo.util.net.FtpRouter ftp = new com.kangdainfo.util.net.FtpRouter(ServiceGetter.getInstance().getCommonService().getFtpRoutingContext());
		ftp.setDefaultTimeout(3000);
		ftp.openSession();
		ftpStream = ftp.downloadFile(remoteDir, fileName);
		ftp.closeSession();
		return ftpStream;
	}
	
	public static InputStream download2(String remoteDir, String fileName, String serverType) throws IOException {
		java.io.InputStream ftpStream = null;
		com.kangdainfo.util.net.FtpRouter ftp = new com.kangdainfo.util.net.FtpRouter(ServiceGetter.getInstance().getCommonService().getFtpRoutingContext(serverType));
		ftp.setDefaultTimeout(3000);
		ftp.openSession();
		ftpStream = ftp.downloadFile(remoteDir, fileName);
		ftp.closeSession();
		return ftpStream;
	}
	
	public static File download2(String remoteDir,String fileName,String saveFileDir,String serverType) throws IOException {
		com.kangdainfo.util.net.FtpRouter ftp = new com.kangdainfo.util.net.FtpRouter(ServiceGetter.getInstance().getCommonService().getFtpRoutingContext(serverType));
		ftp.setDefaultTimeout(3000);
		ftp.openSession();
		File downloadFile = ftp.downloadAsFile(remoteDir, fileName , new File(saveFileDir));
		ftp.closeSession();
		return downloadFile;
	}
	
	public static boolean removeDirectory(String remoteDirName) throws IOException {
		boolean sFlag = false;		
		if (!"".equals(Common.get(remoteDirName))) {
			String[] arrFileName = remoteDirName.split(":;:");
			if (arrFileName.length>0) {			
				com.kangdainfo.util.net.FtpRouter ftp = new com.kangdainfo.util.net.FtpRouter(ServiceGetter.getInstance().getCommonService().getFtpRoutingContext());
				ftp.setDefaultTimeout(3000);
				ftp.openSession();
				sFlag = ftp.removeDirectory(arrFileName[0],true);
				ftp.closeSession();				
		        //ServletContext context = ServiceGetter.getInstance().getMyServletContext().getServletContext();
				//File filestoreLocation = new File(context.getInitParameter("filestoreLocation"));
				//Common.RemoveDirectory(new File(filestoreLocation+File.separator+arrFileName[0]));				
			}
		}	
		return sFlag;
	}
	
	public static boolean removeDirectory2(String remoteDirName, String serverType) throws IOException {
		boolean sFlag = false;		
		if (!"".equals(Common.get(remoteDirName))) {
			String[] arrFileName = remoteDirName.split(":;:");
			if (arrFileName.length>0) {			
				FtpRoutingContext ftpContext = ServiceGetter.getInstance().getCommonService().getFtpRoutingContext(serverType);
				if (ftpContext!=null) {
					com.kangdainfo.util.net.FtpRouter ftp = new com.kangdainfo.util.net.FtpRouter(ftpContext);
					ftp.setDefaultTimeout(3000);
					ftp.openSession();					
					if (remoteDirName.indexOf(":;:")!=-1 && ftpContext.getDefaultDirectory()!=null && ftpContext.getDefaultDirectory().length()>0) {
						sFlag = ftp.removeDirectory(ftpContext.getDefaultDirectory()+arrFileName[0],true);
					} else {
						sFlag = ftp.removeDirectory(arrFileName[0],true);
					}					
					ftp.closeSession();									
				}
		        //ServletContext context = ServiceGetter.getInstance().getMyServletContext().getServletContext();
				//File filestoreLocation = new File(context.getInitParameter("filestoreLocation"));
				//Common.RemoveDirectory(new File(filestoreLocation+File.separator+arrFileName[0]));				
			}
		}	
		return sFlag;
	}
	
	public static String[] listFileNames(String serverType) throws IOException {
		String[] listNames = null;
		com.kangdainfo.util.net.FtpRouter ftp = new com.kangdainfo.util.net.FtpRouter(ServiceGetter.getInstance().getCommonService().getFtpRoutingContext(serverType));
		ftp.setDefaultTimeout(3000);
		ftp.openSession();
		listNames = ftp.listFileNames();
		ftp.closeSession();			
		return listNames;
	}
	
	public static String[] listFileNames(String serverType,String remoteDir) throws IOException {
		String[] listNames = null;
		com.kangdainfo.util.net.FtpRouter ftp = new com.kangdainfo.util.net.FtpRouter(ServiceGetter.getInstance().getCommonService().getFtpRoutingContext(serverType));
		ftp.setDefaultTimeout(3000);
		ftp.openSession();
		listNames = ftp.listFileNames(remoteDir);
		ftp.closeSession();			
		return listNames;
	}
	
	public static String getCurrentRemoteWorkingDirectory(String serverType) throws IOException {
		String reValue = null;
		com.kangdainfo.util.net.FtpRouter ftp = new com.kangdainfo.util.net.FtpRouter(ServiceGetter.getInstance().getCommonService().getFtpRoutingContext(serverType));
		ftp.setDefaultTimeout(3000);
		ftp.openSession();
		reValue = ftp.getCurrentRemoteWorkingDirectory();
		ftp.closeSession();		
		return reValue;
	}
	
	public static FTPFile[] listFiles(String serverType) throws IOException {
		FTPFile[] listFiles = null;
		com.kangdainfo.util.net.FtpRouter ftp = new com.kangdainfo.util.net.FtpRouter(ServiceGetter.getInstance().getCommonService().getFtpRoutingContext(serverType));
		ftp.setDefaultTimeout(3000);
		ftp.openSession();
		listFiles = ftp.listFiles();
		ftp.closeSession();			
		return listFiles;
	}
	
	public static FTPFile[] listFiles(String serverType,String remoteDir) throws IOException {
		FTPFile[] listFiles = null;
		com.kangdainfo.util.net.FtpRouter ftp = new com.kangdainfo.util.net.FtpRouter(ServiceGetter.getInstance().getCommonService().getFtpRoutingContext(serverType));
		ftp.setDefaultTimeout(3000);
		ftp.openSession();
		listFiles = ftp.listFiles(remoteDir);
		ftp.closeSession();			
		return listFiles;
	}
	
	public static byte[] download(String remoteDir , String fileName , String serverType) throws IOException {
		if (!"".equals(Common.get(remoteDir)) && !"".equals(Common.get(fileName))) {
			byte[] b = null;
			com.kangdainfo.util.net.FtpRouter ftp = new com.kangdainfo.util.net.FtpRouter(ServiceGetter.getInstance().getCommonService().getFtpRoutingContext(serverType));
			ftp.setDefaultTimeout(3000);
			for(int i=0; i<50; i++) {
				try {
					ftp.openSession();
					java.io.InputStream ftpStream = ftp.downloadFile(remoteDir, fileName);
					b = IOUtils.toByteArray(ftpStream);
					ftpStream.close(); 
					ftp.closeSession();
					break;
				}
				catch(IOException e) {
					if(i == 9)
						throw e;
				}
			}
			return b;
		}
   		return null;
	}
	
	public static boolean makeDirectory(String serverType,String remoteDirName, boolean isAll) throws IOException {
		com.kangdainfo.util.net.FtpRouter ftp = new com.kangdainfo.util.net.FtpRouter(ServiceGetter.getInstance().getCommonService().getFtpRoutingContext(serverType));
		ftp.setDefaultTimeout(3000);
		ftp.openSession();
		boolean reValue = ftp.makeDirectory(remoteDirName, isAll);
		ftp.closeSession();		
		return reValue;
	}	
	
	public static boolean upload(String remoteDir , String fileName , String serverType ,byte[] fileBs) throws IOException {
		boolean reValue = false;
		if (!"".equals(Common.get(remoteDir)) && !"".equals(Common.get(fileName)) && null != fileBs) {
			com.kangdainfo.util.net.FtpRouter ftp = new com.kangdainfo.util.net.FtpRouter(ServiceGetter.getInstance().getCommonService().getFtpRoutingContext(serverType));
			ftp.setDefaultTimeout(3000);
			ftp.openSession();
			java.io.InputStream ftpStream = new ByteArrayInputStream(fileBs);
			ftp.makeDirectory(remoteDir, true);
			for(int i = 0; i < 50; i ++){
				if(ftp.upload(remoteDir, fileName, ftpStream)){
					ftpStream.close(); 
					ftp.closeSession();
					return true;
				}
			}
			ftpStream.close(); 
			ftp.closeSession();
		}
		return reValue;
	}
	
	public static boolean exists(String serverType,String remoteDir , String remoteFileName) throws IOException {
		boolean reValue = false;
		String[] fileNames = listFileNames(serverType , remoteDir);
		if(null != fileNames && fileNames.length > 0){
			for(String fileName : fileNames){
				if (getFilename(fileName).equals(Common.get(remoteFileName))) {
					reValue = true;
					return true;
				}
				//if(Common.get(remoteDir + Constants.FTP_SEP + remoteDirName).equals(fileName)){
				//	reValue = true;
				//}
			}
		}		
		return reValue;
	}
	
	public static boolean deleteFile(String serverType,String remoteDir,String remoteFileName) throws IOException {
		boolean reValue = false;
		try {
			com.kangdainfo.util.net.FtpRouter ftp = new com.kangdainfo.util.net.FtpRouter(ServiceGetter.getInstance().getCommonService().getFtpRoutingContext(serverType));
			ftp.setDefaultTimeout(3000);
			ftp.openSession();
			String remoteTarget = remoteDir;
			if(!"".equals(remoteFileName)){
				remoteTarget += "/" + remoteFileName;
			}
			ftp.deleteFile(remoteTarget);
			ftp.closeSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reValue;
	}
	
	public static boolean deleteFiles(String serverType,String remoteDir) throws IOException {
		return deleteFiles(serverType, remoteDir, false);
	}
	
	public static boolean deleteFiles(String serverType,String remoteDir,boolean includeSelf) throws IOException {
		boolean reValue = false;
		try {
			com.kangdainfo.util.net.FtpRouter ftp = new com.kangdainfo.util.net.FtpRouter(ServiceGetter.getInstance().getCommonService().getFtpRoutingContext(serverType));
			ftp.setDefaultTimeout(3000);
			ftp.openSession();
			String[] fileNames = ftp.listFileNames(remoteDir);
			for (String fileName : fileNames) {
				reValue = ftp.deleteFile(fileName);
				if(!reValue){
					reValue = deleteFiles(serverType, fileName);
				}
			}
			if(includeSelf)
				ftp.removeDirectory(remoteDir);
			ftp.closeSession();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reValue;
	}
	
	public static boolean removeDirectory3(String serverType,String remoteDir) throws IOException {
		boolean reValue = false;
		try {
			com.kangdainfo.util.net.FtpRouter ftp = new com.kangdainfo.util.net.FtpRouter(ServiceGetter.getInstance().getCommonService().getFtpRoutingContext(serverType));
			ftp.setDefaultTimeout(3000);
			ftp.openSession();
			reValue = ftp.removeDirectory(remoteDir, true);
			ftp.closeSession();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reValue;
	}
}
