package com.kangdainfo.common.util.filestore;

import java.io.*;

import org.apache.commons.io.FileUtils;

import com.kangdainfo.ServiceGetter;
import com.kangdainfo.common.util.Common;

public class FileStoreUtil {
	private FileStoreUtil() {};
		
	public static boolean upload(String dirName, String fileName, InputStream uploadFile) {
		return upload(dirName, fileName, uploadFile, null);
	}
	
	public static boolean upload(String dirName, String fileName, InputStream uploadFile, String serverType) {
		try {
			if (ServiceGetter.getInstance().getCommonService().getCommonAppSetting()!=null && Common.get(ServiceGetter.getInstance().getCommonService().getCommonAppSetting().getDefaultFileUploadHandler()).equalsIgnoreCase("FTP")) {
				if(serverType != null && !"".equals(serverType))
					FtpFileUtil.upload2(dirName, fileName, uploadFile, serverType);
				else
					FtpFileUtil.upload(dirName, fileName, uploadFile);
			} else {
				String filestoreLocation = ServiceGetter.getInstance().getMyServletContext().getServletContext().getInitParameter("filestoreLocation");
				java.io.File dir = new java.io.File(filestoreLocation, dirName);			
				dir.mkdirs();
	            java.io.File sFile = new java.io.File(dir,fileName);
				FileOutputStream fos = new FileOutputStream(sFile);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				byte[] buff = new byte[2048];
				int bytesRead;
				while (-1 != (bytesRead = uploadFile.read(buff))) {
					bos.write(buff, 0, bytesRead);
				}
				bos.close();
				uploadFile.close();
				fos.close();
			}			
		} catch (Exception e) {			
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static byte[] download(String dirPathAndFileName) {
		return download(dirPathAndFileName, null);
	}
	
	public static byte[] download(String dirPathAndFileName, String serverType) {
		try {
			if (ServiceGetter.getInstance().getCommonService().getCommonAppSetting()!=null && Common.get(ServiceGetter.getInstance().getCommonService().getCommonAppSetting().getDefaultFileUploadHandler()).equalsIgnoreCase("FTP")) {
				if(serverType != null && !"".equals(serverType))
					return FtpFileUtil.download2(dirPathAndFileName, serverType);
				else
					return FtpFileUtil.download(dirPathAndFileName);
			} else {
				String[] arrFileName = Common.get(dirPathAndFileName).split(":;:");
				String filestoreLocation = ServiceGetter.getInstance().getMyServletContext().getServletContext().getInitParameter("filestoreLocation");
				File sFile = null;
				File dir = new File(filestoreLocation+File.separator+arrFileName[0]);
				if (dir.isDirectory()) {
					String[] children = dir.list();
					for (int i=0; i<children.length; i++) {
						sFile = new File(dir, children[i]);
					}
				}		
				if (sFile!=null && sFile.isFile() && sFile.exists()) {					
					return FileUtils.readFileToByteArray(sFile);
				}
			}			
		} catch (Exception e) {			
			e.printStackTrace();			
		}
		return null;
	}
	
	public static boolean removeDirectory(String dirPathAndFileName) {
		return removeDirectory(dirPathAndFileName, null);	
	}
	
	public static boolean removeDirectory(String dirPathAndFileName, String serverType) {
		try {
			if (ServiceGetter.getInstance().getCommonService().getCommonAppSetting()!=null && Common.get(ServiceGetter.getInstance().getCommonService().getCommonAppSetting().getDefaultFileUploadHandler()).equalsIgnoreCase("FTP")) {
				if(serverType != null && !"".equals(serverType))
					FtpFileUtil.removeDirectory2(dirPathAndFileName, serverType);
				else
					FtpFileUtil.removeDirectory(dirPathAndFileName);
			} else {
				String filestoreLocation = ServiceGetter.getInstance().getMyServletContext().getServletContext().getInitParameter("filestoreLocation");
				if (!"".equals(Common.get(dirPathAndFileName))) {
					String[] arrFileName=dirPathAndFileName.split(":;:");
					if (arrFileName.length>1) Common.RemoveDirectory(new File(filestoreLocation+File.separator+arrFileName[0]));					
				}
			}		
		} catch (Exception e) {			
			e.printStackTrace();
			return false;
		}
		return true;		
	}
	
	
	
}
