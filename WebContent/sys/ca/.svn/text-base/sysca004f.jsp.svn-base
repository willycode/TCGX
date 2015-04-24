<!--
程式目的：郵遞區號文字檔匯入
程式代號：sys0113
程式日期：1030820
程式作者：jason.kuo
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page contentType = "text/html;charset=UTF-8" %>
<%@ include file = "../../home/head.jsp" %>
<jsp:include page="../../home/secure.jsp">
	<jsp:param name="DTREE_PROGRAM_IDENTIFIER" value="SYSCA004" />
</jsp:include>
<jsp:useBean id = "obj" scope="request" class="com.kangdainfo.common.view.sys.ca.SYSCA004F">
	<jsp:setProperty name="obj" property="*"/>
</jsp:useBean>
<jsp:useBean id="objList" scope="page" class="java.util.ArrayList"/>
<%
	if ("queryAll".equals(obj.getState())) {
		if ("false".equals(obj.getQueryAllFlag())){
			obj.setQueryAllFlag("true"); 
		}
	}
	else if ("queryOne".equals(obj.getState())) {
		obj = (com.kangdainfo.common.view.sys.ca.SYSCA004F)obj.queryOne();	
	}
	else if ("insert".equals(obj.getState()) || "insertError".equals(obj.getState())) {
		obj.insert();
		obj.setQueryAllFlag("true");
	}
	else if ("update".equals(obj.getState()) || "updateError".equals(obj.getState())) {
		obj.update();
	}
	else if ("delete".equals(obj.getState()) || "deleteError".equals(obj.getState())) {
		obj.delete();
	}
	else if ("importWork".equals(obj.getState())){
		obj.doImportProcess();
		obj.setFilePath("");
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

function checkField(){
	var alertStr = "";
	if(form1.state.value == "insert" || form1.state.value == "update"){
		alertStr += checkEmpty(form1.zipCode,"郵遞區號");
		alertStr += checkEmpty(form1.cityName,"鄉鎮城市");
		alertStr += checkEmpty(form1.roadName,"路");
		alertStr += checkEmpty(form1.noName,"門牌號碼");
	}
	else if(form1.state.value == "importWork"){
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

function checkFilePath(){
	var alertStr = "";

	if(form1.filePath.value == ""){
		alertStr += "請先上傳檔案，再匯入作業!";
	}

	if(alertStr.length != 0){
		alert(alertStr);
		return false;
	}
	
	beforeSubmit();
	form1.submit();
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
<body onLoad="whatButtonFireEvent('<%= obj.getState() %>');init();showErrorMsg('<%= obj.getErrorMsg()%>');">
<fmt:bundle basename="ApplicationResources">
<form id="form1" name="form1" method="post" onSubmit="return checkField()">
<!--Query區============================================================-->
<div id="queryContainer" style="width:500px;height:150px;display:none">
	<iframe id="queryContainerFrame"></iframe>
	<div class="queryTitle">查詢視窗</div>
	<table class="queryTable" border="1">
		<tr>
			<td class="queryTDLable"><fmt:message key="CommonZip.zipCode"/>:</td>
			<td class="queryTDInput">
				<input class="field_Q" type="text" name="q_zipCode" size="20" maxlength="5" value="<%= obj.getQ_zipCode() %>">
			</td>
		</tr>
		<tr>
			<td class="queryTDLable"><fmt:message key="CommonZip.cityName"/>:</td>
			<td class="queryTDInput">
				<input class="field_Q" type="text" name="q_cityName" size="20" maxlength="14" value="<%= obj.getQ_cityName() %>">
			</td>
		</tr>
		<tr>
			<td class="queryTDLable"><fmt:message key="CommonZip.roadName"/>:</td>
			<td class="queryTDInput">
				<input class="field_Q" type="text" name="q_roadName" size="20" maxlength="24" value="<%= obj.getQ_roadName() %>">
			</td>
		</tr>
		<tr>
			<td class="queryTDLable"><fmt:message key="CommonZip.noName"/>:</td>
			<td class="queryTDInput">
				<input class="field_Q" type="text" name="q_noName" size="20" maxlength="30" value="<%= obj.getQ_noName() %>">
			</td>
		</tr>
		<tr>
			<td class="queryTDInput" colspan="2" style="text-align:center">
				<input class="toolbar_default" followPK="false" type="submit" name="querySubmit" value="確　　定" >
				<input class="toolbar_default" followPK="false" type="button" name="queryCannel" value="取　　消" onClick="whatButtonFireEvent(this.name)">
			</td>		
		</tr>
	</table>
</div>
<table width="100%" cellspacing="0" cellpadding="0">
<!--Form區============================================================-->
<tr>
	<td class="bg">
		<div id="formContainer" style="height:auto">
			<table class="table_form" width="100%" height="100%">
				<tr>
					<td class="td_form"><font color="red">*</font><fmt:message key="CommonZip.zipCode"/>:</td>
					<td class="td_form_white">
						<input class="field" type="text" name="zipCode" size="20" maxlength="5" value="<%= obj.getZipCode() %>">
					</td>
				</tr>
				<tr>
					<td class="td_form"><font color="red">*</font><fmt:message key="CommonZip.cityName"/>:</td>
					<td class="td_form_white">
						<input class="field" type="text" name="cityName" size="20" maxlength="14" value="<%= obj.getCityName() %>">
					</td>
				</tr>
				<tr>
					<td class="td_form"><font color="red">*</font><fmt:message key="CommonZip.roadName"/>:</td>
					<td class="td_form_white">
						<input class="field" type="text" name="roadName" size="20" maxlength="24" value="<%= obj.getRoadName() %>">
					</td>
				</tr>
				<tr>
					<td class="td_form"><font color="red">*</font><fmt:message key="CommonZip.noName"/>:</td>
					<td class="td_form_white">
						<input class="field" type="text" name="noName" size="20" maxlength="30" value="<%= obj.getNoName() %>">
					</td>
				</tr>
				<tr>
					<td class="td_form"><fmt:message key="updateInformation"/>:</td>
					<td class="td_form_white">
						<% request.setAttribute("objBean",obj); %>
						<c:import url="/home/editUser.jsp" />
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
		<input type="hidden" name="im_userId" value="<%=User.getUserId()%>">
		<input type="hidden" name="im_userIp" value="<%=request.getRemoteAddr()%>">
		<input type="hidden" name="im_userShortName" value="<%=Dept.getShortName()%>">
		<jsp:include page="../../home/toolbar.jsp" />		
		<%= View.getPopUpload("field_Q","filePath",obj.getFilePath(),true) %>
		<span id = "spanImportWork">
			<input class="toolbar_default" type="button" followPK="false" name="importWork" value="匯入作業" onClick="whatButtonFireEvent(this.name)">&nbsp;
		</span>
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
						<th class="listTH" ><a class="text_link_w" >NO.</a></th>
						<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',1,false);" href="#">郵遞區號</a></th>
						<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',2,false);" href="#">中文說明</a></th>
					</tr>
				</thead> 
				<tbody id="listTBODY">
					<%
						boolean primaryArray[] = {true,false,false};
						boolean displayArray[] = {false,true,true};
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
localButtonFireListener.whatButtonFireEvent = function(buttonName){		
	switch(buttonName){
		case "importWork":
			form1.state.value = "importWork";
			checkFilePath();
			break;		
		default:
			break;
	}
}
</script>
</fmt:bundle>
</body>
</html>