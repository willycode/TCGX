<!--
程式目的：CommonDtreeLocName 匯入作業
程式代號：sysap109f
程式日期：1030826
程式作者：Kang Da
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../home/head.jsp" %>
<jsp:include page="../../home/secure.jsp">
	<jsp:param name="DTREE_PROGRAM_IDENTIFIER" value="SYSAP109" />
</jsp:include>
<jsp:useBean id="obj" scope="request" class="com.kangdainfo.common.view.sys.ap.SYSAP109F">
	<jsp:setProperty name="obj" property="*"/>
</jsp:useBean>
<% 
try{	   
	if (obj.getState().equals("exportTemplate")) { 
		out.clear();	
		obj.templateToHttpResponse(request, response);
		out = pageContext.pushBody();			
		if(!"".equals(obj.getMsg())){
			out.write(obj.getMsg());
		}
	} else if (obj.getState().equals("importTemplate")  && !"".equals(obj.getQ_filePath())) {
		obj.importCommonDtreeLocName();	
		out.write(Common.get(obj.getMsg()));
	}	
	
}catch(Exception e){
	e.printStackTrace();
	out.write("發生未預期錯誤，請連絡管理者 !");
}
%>
<html>
<head>
<meta http-equiv="Expires" content="0"/>
<meta http-equiv="pragma" content="no-cache"/>
<meta http-equiv="Cache-control" content="no-cache"/>
<link rel="stylesheet" href="../../js/default.css" type="text/css"/>
<script type="text/javascript" src="../../js/json.js"></script>
<script type="text/javascript" src="../../js/tablesoft.js"></script>
<script type="text/javascript" src="../../js/validate.js"></script>
<script type="text/javascript" src="../../js/function.js"></script>
<script type="text/javascript">
function checkField(intType){
	var alertStr = "";	
	if(intType == 2){
	    if(form1.q_filePath.value == ""){
			alertStr += "您必需指定檔案";
	    } else {
	    	var extPos = form1.q_filePath.value.lastIndexOf(".");
	    	var ext = form1.q_filePath.value.toLowerCase().substring(extPos+1);
	    	if (extPos == -1) {
	    		alertStr += "無法判斷您上傳的檔案格式，請檢查檔案是否有副檔名並重新輸入!";
	    	} else if (ext!='xls'){
	    		alertStr += "上傳的檔案格式必須是xls格式，請重新輸入!";	    		
	    	}
	    }	
	}	
	if(alertStr.length != 0){ 
		form1.state.value = "";
		alert(alertStr);
		return false;
	}
	
	if(intType == 1){
		form1.state.value = "exportTemplate";
		form1.target = "_self";
	}else{
		form1.state.value = "importTemplate";
		form1.target = "_self";
	}
	
	beforeSubmit();
	form1.submit();
	return true;
}

</script>
</head>

<body onLoad="showErrorMsg('<%=obj.getErrorMsg()%>');">
<form id="form1" name="form1" method="post" onSubmit="return checkField()" autocomplete="off">
<table  border="1" align="center" class="table_form">
<tr>
  	<td class="queryTDLable">匯入檔案路徑：</td>
  	<td class="queryTDInput">
  		<%=View.getPopUpload("field","q_filePath",obj.getQ_filePath(),null,null,true,"false")%>
	</td>
</tr>
<tr>
    <td class="queryTDInput" colspan="2" style="text-align:center;">
		<input class="toolbar_default" followPK="false" type="button" name="btnTemplate" value="產製樣板" onClick="checkField(1);">　
        <input class="toolbar_default" followPK="false" type="button" name="btnImport" value="匯入選單名稱" onClick="checkField(2);" >
	</td>
</tr>
</table>
<input type="hidden" name="state" value="">
</form>
</body>
</html>
