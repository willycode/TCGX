package com.kangdainfo.common.util.filestore;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

import com.kangdainfo.ServiceGetter;
import com.kangdainfo.common.util.Common;
import com.kangdainfo.util.net.FtpRoutingContext;
import com.kangdainfo.web.util.WebConstants;


public class FileDownloadSimpleServlet extends javax.servlet.http.HttpServlet {

	public final String PARM_FILE_ID = "fileID";
	private static final long serialVersionUID = 1L;

	public FileDownloadSimpleServlet() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		this.doProcess(req,res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		this.doProcess(req,res);
	}

	protected void doProcess(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{

		ServletContext context = ServiceGetter.getInstance().getMyServletContext().getServletContext();
		String filestoreLocation = context.getInitParameter("filestoreLocation");

		String fileID = Common.get(request.getParameter(PARM_FILE_ID));
		String fileName = Common.get(request.getParameter("fileName"));
		String serverType = Common.get(request.getParameter("serverType"));
		String encoding = Common.get(request.getParameter("encoding"));
		
		String[] arrFileName;
		File sFile = null;
		boolean deleteFile = false;
		java.io.File dir = null;
		if(Common.get(fileID).equals("") && Common.get(fileName).equals("")) {
			response.sendError(404,"Parameter Not Found !");
			return;
		} else if (!"".equals(Common.get(fileID))){
			//if (context.getServerInfo().toLowerCase().indexOf("tomcat")>0) fileID = Common.isoToBig5(fileID);
			//fileID = Common.isoToUTF8(fileID);
			fileID = java.net.URLDecoder.decode(fileID,"UTF-8");
			arrFileName = fileID.split(":;:");
			if (arrFileName.length>1) {
				if (ServiceGetter.getInstance().getCommonService().getCommonAppSetting()!=null && Common.get(ServiceGetter.getInstance().getCommonService().getCommonAppSetting().getDefaultFileUploadHandler()).equalsIgnoreCase("FTP")) {					
	        		fileName = arrFileName[1];
	        		/** 這一段中文名稱會有問題,因為fileID的參數是ISO格式 **/
        			deleteFile = true;
        			dir = new java.io.File(Common.getTempDirectory(), arrFileName[0]);
        			dir.mkdirs(); 
        			sFile = new java.io.File(dir,fileName);
        			byte[] data = FileStoreUtil.download(fileID, serverType);
        			if (data!=null && data.length>0) {
        				FileUtils.writeByteArrayToFile(sFile, data);
        			}	        		
	        		/** 這一段中文名稱會有問題,因為fileID的參數是ISO格式
        			deleteFile = true;
        			dir = new java.io.File(Common.getTempDirectory(), arrFileName[0]);
        			dir.mkdirs(); 
        			sFile = new java.io.File(dir,fileName);
        			byte[] data = FileStoreUtil.download(fileID);
        			if (data!=null && data.length>0) {
        				FileUtils.writeByteArrayToFile(sFile, data);
        			}
        			**/	        		
	        		/**
	        		FtpRoutingContext ftpContext = null;
	        		if (!"".equals(Common.get(serverType))) {
	        			ftpContext = ServiceGetter.getInstance().getCommonService().getFtpRoutingContext(serverType);	        			
	        		} else {
	        			ftpContext = ServiceGetter.getInstance().getCommonService().getFtpRoutingContext();
	        		}
	        		if (ftpContext!=null && "".equals(Common.get(encoding)) && !"".equals(Common.get(ftpContext.getEncoding()))) {
	        			encoding = Common.get(ftpContext.getEncoding());
	        		}
	        		com.kangdainfo.util.net.FtpRouter ftp = new com.kangdainfo.util.net.FtpRouter(ftpContext);
	        		if (ftp!=null) {
		        		ftp.openSession();
		        		ftp.setDefaultTimeout(60000);
		        		String[] fileNames = ftp.listFileNames(arrFileName[0]);
		        		if (fileNames!=null && fileNames.length>0) {
		        			fileName = FtpFileUtil.getFilename(fileNames[0]);
		        			java.io.InputStream ftpStream = ftp.downloadFile(arrFileName[0], fileName);
		        			deleteFile = true;
		        			dir = new java.io.File(Common.getTempDirectory(), arrFileName[0]);
		        			dir.mkdirs();        			
		                    sFile = new java.io.File(dir,fileName);
		        			java.io.FileOutputStream fos = new java.io.FileOutputStream(sFile);
		        			java.io.BufferedOutputStream bos = new java.io.BufferedOutputStream(fos);
		        			byte[] buff = new byte[2048];
		        			int bytesRead;
		        			while (-1 != (bytesRead = ftpStream.read(buff))) {
		        				bos.write(buff, 0, bytesRead);
		        			}
		        			bos.close();
		        			ftpStream.close();
		        			fos.close();       			
		        		}
		        		ftp.closeSession();	        			
	        		}
	        		**/
				} else {
	        		dir = new File(filestoreLocation,arrFileName[0]);        		
	                if (dir.isDirectory()) {        	
	                    String[] children = dir.list();
	                    for (int i=0; i<children.length; i++) {            	
	                    	sFile = new File(dir, children[i]);
	                    }
	                } 					
				}
			} else {
				sFile = new File(filestoreLocation,fileID);
			}
		} else {
			if (request.getSession().getAttribute(WebConstants.SessionKeys.CURRENT_USER)==null) {
				response.sendError(404,"Parameter Not Found !");
				return;
			}
			if (context.getServerInfo().toLowerCase().indexOf("tomcat")>0) {
				fileID = Common.isoToBig5(fileName);
				sFile = new File(Common.isoToBig5(fileName));
			} else {
				fileID = fileName;
				sFile = new File(fileName);
			}
			if(!"".equals(encoding)){
				if("UTF-8".equals(encoding)){
					fileID = Common.isoToUTF8(fileName);
					sFile = new File(Common.isoToUTF8(fileName));
				}
			}
		}

		if(sFile!=null && sFile.exists()){
			String ct = ContentTypeConfiguration.getContentType(fileID);
			if(ct!=null){
				response.setContentType(ct);
			}
			int len = new Long(sFile.length()).intValue();
			if (len>0) {
				response.setContentLength(len);
				response.setHeader("Cache-control","");
				response.setHeader("Content-Disposition", "attachment; filename=\"" + Common.big5ToIso(sFile.getName()) + "\"");
				
				if(!"".equals(encoding)){
					if("UTF-8".equals(encoding)){
						response.setHeader("Content-Disposition", "attachment; filename=\"" + sFile.getName() + "\"");
					}
				}
		        OutputStream os = null;
		        java.io.InputStream is = null; 
		        try{
		        	byte b[] = new byte[len];
		        	if (sFile.isFile())
		        	{
		        		response.flushBuffer();
		        	    is = new FileInputStream(sFile);
		        	    os = response.getOutputStream();
		        	    int read = 0;
		        	    while ((read = is.read(b)) != -1)
		        	    {
		        	        os.write(b,0,read);
		        	    }
		        	}
		        }catch(Exception x){
		        	try{
		        		response.sendError(500,"File Output Error!");
		        	}catch(Exception e){}
		        }finally{
					if (os!=null) os.close();
					if (is!=null) is.close();
		        } 		     
		        /**
				FileInputStream is = null;	        
				OutputStream os = response.getOutputStream();		        
				try{
					byte b[] = new byte[len];
					if (sFile.isFile()) {
						response.flushBuffer();
						is = new FileInputStream(sFile);
						os = response.getOutputStream();
						int read = 0;
						while ((read = is.read(b)) != -1){
							os.write(b,0,read);
						}
					}
				}catch(Exception x){
					try{
						response.sendError(500,"File Output Error!");
					}catch(Exception e){}
				}finally{
					if (os!=null) os.close();
					if (is!=null) is.close();
				}
				**/
			} else {
				response.sendError(404,"File Is Empty !");
				return;
			}
			if (deleteFile && dir!=null && dir.isDirectory()) Common.RemoveDirectory(dir);
		} else {
			response.sendError(404,"File Not Found !");
			return;
		}
	}


}