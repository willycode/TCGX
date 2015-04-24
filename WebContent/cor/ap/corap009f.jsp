<!--
程式目的：提供匯入精舍所提供的學員名單
程式代號：corap009f
程式日期：
程式作者：
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page contentType = "text/html;charset=UTF-8" %>
<%@ include file = "../../home/head.jsp" %>
<jsp:include page="../../home/secure.jsp">
	<jsp:param name="DTREE_PROGRAM_IDENTIFIER" value="CORAP009F" />
</jsp:include>
<jsp:useBean id = "obj" scope="request" class="com.kangdainfo.ctis.view.cor.ap.CORAP009F">
	<jsp:setProperty name="obj" property="*"/>
</jsp:useBean>
<jsp:useBean id="objList" scope="page" class="java.util.ArrayList"/>
<%
	String importWork = request.getParameter("importWork");
	if (importWork != null){
		obj.doImportProcess();
		obj.setQueryAllFlag("true");
		obj.setFilePath("");
	}
	
	if ("queryAll".equals(obj.getState())) {
		if ("false".equals(obj.getQueryAllFlag())){obj.setQueryAllFlag("true");}
	}
	
	if ("true".equals(obj.getQueryAllFlag())){
		objList = (java.util.ArrayList) obj.queryAll();
	}
%>
<html>
<head>
<%@ include file = "../../home/meta.jsp" %>
<script type="text/javascript">
var insertDefault;
var actionMessage = '<%=obj.getImportMsg()%>';

function checkField(){
	var alertStr = "";
	if(form1.state.value == "importWork"){
		if(form1.filePath.value == ""){
			alertStr += "請先上傳檔案，再匯入作業!";
		}
	}

	if(alertStr.length != 0){
		alert(alertStr);
		return false;
	}

	beforeSubmit();
	return true;
}

function checkAfterAction(){
	alert(actionMessage);
}

function queryOne(id){
	form1.id.value = id;
	form1.state.value = "queryOne";
	beforeSubmit();
	form1.submit();
}

function init(){}
</script>
</head>
<body onLoad="whatButtonFireEvent('<%= obj.getState() %>');">
<fmt:bundle basename="ApplicationResources">
<form id="form1" name="form1" method="post" onSubmit="return checkField()">
<!--Query區============================================================-->
<div id="queryContainer" style="width:500px;height:150px;display:none">
	<iframe id="queryContainerFrame"></iframe>
	<div class="queryTitle">查詢視窗</div>
	<table class="queryTable" border="1">
	
	</table>
</div>
<table width="100%" cellspacing="0" cellpadding="0">
<!--Form區============================================================-->
<tr>
	<td class="bg">
		<div id="formContainer" style="height:auto">
			<table class="table_form" width="100%" height="100%">
				<tr>
					<td class="td_form"><font color="red">*</font>請選擇檔案：
					<td class="td_form_white">
						<%= View.getPopUpload("field_Q","filePath",obj.getFilePath(),true) %>
					</td>	
				</tr>
				<tr>
					<td class="td_form"></td>
					<td class="td_form_white">
						<span id = "spanImportWork">
							
						</span>
					</td>
				</tr>
			</table>
		</div>
	</td>
</tr>
<!--Toolbar區============================================================-->

<tr>
	<td class="bgToolbar" style="text-align:center">
		<input type="hidden" name="id" value="<%=obj.getId()%>">
		<input type="hidden" name="state" value="<%=obj.getState()%>">
		<input type="hidden" name="queryAllFlag" value="<%=obj.getQueryAllFlag()%>">
		<input class="toolbar_default" type="submit" followPK="false" name="importWork" value="匯入作業" onClick="whatButtonFireEvent(this.name)">&nbsp;
	</td>
</tr>

<tr>
	<td>
		<% request.setAttribute("QueryBean",obj);%>
		<jsp:include page="../../home/page.jsp" />
	</td>
</tr>
<!--List區============================================================-->
<tr>
	<td class="bgList">
		<div id="listContainer" style="height:300px">
			<table class="table_form" width="100%" cellspacing="0" cellpadding="0">
				<thead id="listTHEAD">
					<tr>
						<th class="listTH"><a class="text_link_w" >NO.</a></th>
						<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',1,false);" href="#">精舍</a></th>
						<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',2,false);" href="#">姓名</a></th>
						<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',3,false);" href="#">法名</a></th>
						<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',4,false);" href="#">行動電話</a></th>
						<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',5,false);" href="#">E-mail</a></th>
					</tr>
				</thead> 
				<tbody id="listTBODY">
					<%
						boolean primaryArray[] = {true,false,false,false,false,false};
						boolean displayArray[] = {false,true,true,true,true,true};
						out.write(View.getQuerylist(primaryArray,displayArray,objList,obj.getQueryAllFlag()));
					%>
				</tbody>
			</table>
		</div>
	</td>
</tr>
</table>
</form>
<script language="javascript">
var whatButtonFireEvent = function(buttonName){
	switch(buttonName){
		case "importWork":
			form1.state.value = "importWork";
			break;		
		default:
			break;
	}
}
</script>
</fmt:bundle>
</body>
</html>