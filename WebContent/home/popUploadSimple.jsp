<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="org.apache.commons.lang.StringEscapeUtils" %>
<%@ page import="org.apache.commons.fileupload.FileItem" %>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory" %>
<%@ page import="org.apache.commons.fileupload.servlet.*" %>
<%@ page import="com.kangdainfo.common.util.filestore.*" %>
<%@ page import="org.apache.commons.io.FileUtils"%>
<%@ page import="org.apache.commons.io.FileCleaningTracker" %>
<%@ include file="head.jsp" %>
<%
String popFileID = Common.checkGet(request.getParameter("popFileID"));
String popFileName = Common.isoToBig5(Common.checkGet(request.getParameter("popFileName")));
String uploadFtp = Common.checkGet(request.getParameter("uploadFtp"));
String serverType = Common.checkGet(request.getParameter("serverType"));
int maxPostSize = 1024*1024*5; //5 M
if (!"".equals(Common.get(application.getInitParameter("filestoreLimit")))) {
	maxPostSize = Integer.parseInt(Common.get(application.getInitParameter("filestoreLimit")));
}
boolean isMultipart = false;
String contentType = request.getContentType();
if(contentType!=null){
    contentType = contentType.toLowerCase();
    if(contentType.startsWith("multipart/form-data")){
        isMultipart = true;
    }
}
String uploadCaseID = "";
String actionType = "";
String fileName = "";
String actionResult = "noAction";
String actionMessage = "";    
    
if(isMultipart){
	try {
	    uploadCaseID = Common.getVMID();
	    File tempDirectory = new File(Common.get(application.getInitParameter("filestoreLocation")));
	    
	    //FileCleaningTracker fileCleaningTracker = FileCleanerCleanup.getFileCleaningTracker(this.getServletContext());
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//factory.setFileCleaningTracker(fileCleaningTracker);
		factory.setSizeThreshold(4096);
		factory.setRepository(tempDirectory);
		
		ServletFileUpload upload = new ServletFileUpload(factory);		
		upload.setSizeMax(maxPostSize);
		
		List fileItems = upload.parseRequest(request);
		if (fileItems!=null && fileItems.size()>0) {
			for (Object itemObj : fileItems) {
				FileItem fi = (FileItem) itemObj;
				if (fi.isFormField()) {
				    String name = fi.getFieldName();
				    String value = fi.getString();
					if (name.equals("popFileID")) popFileID = value;
					if (name.equals("popFileName")) popFileName = value;
					if (name.equals("actionType")) actionType = value;
				} else if (fi.getSize()>0) {
					boolean sFlag = true;
					fileName = FtpFileUtil.getFilename(fi.getName());
	            	if(!"N".equals(uploadFtp)) {
	            		InputStream is = fi.getInputStream();
	            		sFlag = FileStoreUtil.upload(uploadCaseID, fileName, is, serverType);
	            		is.close();	            		
					} else {		
	            		File dir = new File(tempDirectory, uploadCaseID);
	            		dir.mkdirs();
	            		File f = new File(dir,fileName);
	            		fi.write(f);	            		
					}				
	            	fi.delete();
	                actionResult = "doUploadSuccess";
	                actionMessage = "上傳成功";
				} else {
	                actionResult = "doUploadFail";
	                actionMessage = "上傳失敗，因為上傳的檔案中無任何內容！";					
				}
			}
		} 		
	} catch (org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException e) {
        actionResult = "doUploadFail";
        actionMessage = "上傳失敗，因為上傳的檔案大小超過限制！上傳檔案為" + (e.getActualSize()/(1024*1024)) + "MB超過允許的" + (e.getPermittedSize()/(1024*1024))+"MB";  	
	}
}
String filestoreAllowedExtList=StringEscapeUtils.escapeHtml(application.getInitParameter("filestoreAllowedExtList"));
maxPostSize=(maxPostSize/1048576);
%>
<html>
<head>
<%@ include file="meta.jsp" %>
<script type="text/javascript">
var actionResult = '<%=actionResult%>';
var actionMessage = '<%=actionMessage%>';

function checkAfterAction(){    
    switch(actionResult){
    case 'noAction':
        break;
    case 'doUploadSuccess':
        alert(actionMessage); 
		if (isObj(opener.document.all.item("<%=Common.get(popFileID)%>"))) {
			opener.document.all.item("<%=Common.get(popFileID)%>").value='<%=Common.get(uploadCaseID)%>:;:'+'<%=Common.get(fileName)%>';		
		}
        window.close();
        break;
    case 'doUploadFail':
        alert(actionMessage);
        break;
    }
}

function checkField(){
    if(form1.FILE.value == ""){
            alert("您必需指定檔案");
            return false;
    } else {
    	var extPos = form1.FILE.value.lastIndexOf(".");
    	var ext = form1.FILE.value.toLowerCase().substring(extPos+1);
    	var allowExt = "<%=filestoreAllowedExtList%>";
    	if (extPos==-1) {
    		alert("無法判斷您上傳的檔案格式，請檢查檔案是否有副檔名並重新輸入!");
    		return false;
    	}
    	if (parse(allowExt).length>0) {
    		if (allowExt.search(ext)== -1 ) {
    			alert("上傳的檔案格式必須是"+allowExt+"，請重新輸入!");
    			return false;
    		}
    	}   
    }
    form1.actionType.value = "doUpload";
}

function cancelUpload(){
    window.close();
}
</script>
</head>

<body topmargin="5" onload="checkAfterAction()">
<form id="form1" name="form1"  method="post" enctype="multipart/form-data" onSubmit="return checkField();">
<table width="100%" cellspacing="0" cellpadding="0">
<!--Form區============================================================-->
<tr><td class="bg">
    <table class="table_form" width="100%" height="100%">
    <tr>
      <td colspan="2" class="td_form_white">
        ** 上傳的檔案限制為<%=maxPostSize%>MB，請勿超過。</td>
      </tr>
    <tr>
        <td class="td_form">上載檔案路徑：</td>
        <td class="td_form_white">
           <input class="field" TYPE="file" name="FILE">
        </td>
    </tr>
    </table>
</td></tr>

<!--Toolbar區============================================================-->
<tr><td class="bg" style="text-align:center">
    <input type="hidden" name="uploadCaseID" value="<%=Common.get(uploadCaseID)%>" >
    <input type="hidden" name="popFileID" value="<%=Common.get(popFileID)%>" >    
    <input type="hidden" name="popFileName" value="<%=Common.get(popFileName)%>" >
    <input type="hidden" name="serverType" value="<%=serverType%>" >  
    <input type="hidden" name="uploadFtp" value="<%=uploadFtp%>" >
    <input type="hidden" name="actionType" value="" >
    &nbsp;|
    <input class="toolbar_default" type="submit" name="upload"	value="上傳檔案">&nbsp;|                      
    <input class="toolbar_default" type="button" name="cancel"	value="取消上傳" onClick="cancelUpload()">&nbsp;|                          
</td></tr>

</table>
</form>
</body>
</html>