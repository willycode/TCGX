<!--
程式目的：職務角色交接
程式代號：sysap010f
程式日期：1030827
程式作者：jason.kuo
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page contentType = "text/html;charset=UTF-8" %>
<%@ include file = "../../home/head.jsp" %>
<jsp:include page="../../home/secure.jsp">
	<jsp:param name="DTREE_PROGRAM_IDENTIFIER" value="SYSAP010F" />
</jsp:include>
<jsp:useBean id = "obj" scope="request" class="com.kangdainfo.common.view.sys.ap.SYSAP010F">
	<jsp:setProperty name="obj" property="*"/>
</jsp:useBean>
<jsp:useBean id="objList" scope="page" class="java.util.ArrayList"/>
<%
	obj.setRolesOwnerId(User.getUserId());
	obj.setRolesOwnerName(User.getUserName());
	
	if ("queryAll".equals(obj.getState())) {
		
	}
	else if ("queryOne".equals(obj.getState())) {
		
	}
	else if ("insert".equals(obj.getState()) || "insertError".equals(obj.getState())) {
		
	}
	else if ("update".equals(obj.getState()) || "updateError".equals(obj.getState())) {
		obj.update();
	}
	else if ("delete".equals(obj.getState()) || "deleteError".equals(obj.getState())) {

	}
	
	
%>
<html>
<head>
<%@ include file = "../../home/meta.jsp" %>
<script type="text/javascript">
function checkField(){
	var alertStr = "";
	alertStr += checkEmpty(form1.rolesOwnerId,'職務交接帳號');
	alertStr += checkButton(form1.roles,'移交的腳色');
	alertStr += checkEmpty(form1.rolesRecipientId,'職務接收帳號');
	if(alertStr.length != 0){
		alert(alertStr);
		return false;
	}
	
	form1.state.value = "update";
	alert("職務交接成功!");
	beforeSubmit();
	return true;
}

function queryOne(id){
	form1.id.value=id;	
}

function init(){}

function setRolesRecipientNameValue(selected){	
	form1.rolesRecipientName.value = document.form1.rolesRecipientId.options[selected].text;
	
}
</script>
</head>
<body onLoad="init();showErrorMsg('<%= obj.getErrorMsg() %>"');">
<form id="form1" name="form1" method="post" onSubmit="return checkField()">
<table width="100%" cellspacing="0" cellpadding="0">
<!--Form區============================================================-->
<tr>
	<td class="bg">
		<div id="formContainer" style="height:auto">
			<table class="table_form" width="100%" height="100%">
				<tr>
					<td class="td_form"><font color="red">*</font>職務交接帳號：</td>
					<td class="td_form_white">
						<input class="field_QRO" type="text" name="rolesOwnerId" size="10" maxlength="50" value="<%= obj.getRolesOwnerId()%>">
						<input class="field_QRO" type="text" name="rolesOwnerName" size="10" maxlength="60" value="<%= obj.getRolesOwnerName()%>">
					</td>
				</tr>
				<tr>
					<td class="td_form">擁有的角色：</td>
					<td class="td_form_white">
						<%= View.getCheckBoxOption("field_Q","roles","select a.id,a.groupDesc from CommonGroup a,CommonUserGroup b where a.id = b.commonGroup.id and b.commonUser.userId = " + Common.sqlChar(User.getUserId()) + " order by a.groupName",obj.getRoles()) %>						
					</td>
				</tr>
				<tr>
					<td class="td_form">職務接收帳號：</td>
					<td class="td_form_white">
						<select class="field_Q" name="rolesRecipientId" onChange="setRolesRecipientNameValue(this.selectedIndex)">
							<%if(User.getIsMaster()){ %>
								<%= View.getOption("select userId,userName from CommonUser where isMaster = 'True' order by userId",obj.getRolesRecipientId(),false,1) %>
							<%}else{ %>
								<%= View.getOption("select userId,userName from CommonUser where isMaster = 'False' and commonDepartment.unitId = " + Common.sqlChar(Dept.getUnitId()) + " order by userId",obj.getRolesRecipientId(),false,1) %>
							<%} %>							
						</select>
						<input type="hidden" name="rolesRecipientName" value="<%= obj.getRolesRecipientName()%>">
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
		<input type="hidden" name="centerId" value="<%= Dept.getUnitId()%>">
		<input type="hidden" name="centerShortName" value="<%= Dept.getUnitShortName()%>">
		<input type="hidden" name="createId" value="<%= User.getUserId()%>">
		<input type="hidden" name="createDate" value="<%= Datetime.getYYYMMDD()%>">
		<input type="hidden" name="createTime" value="<%= Datetime.getHHMMSS()%>">
		<input type="hidden" name="updateId" value="<%= User.getUserId()%>">
		<input type="hidden" name="updateIp" value="<%= request.getRemoteAddr()%>">
		<input type="hidden" name="updateDate" value="<%= Datetime.getYYYMMDD()%>">
		<input type="hidden" name="updateTime" value="<%= Datetime.getHHMMSS()%>">
		<input type="hidden" name="updateCenterShortName" value="<%= Dept.getUnitShortName()%>">
		<input class="toolbar_default" type="submit" name="confirm" value="確    定">
		<input class="toolbar_default" type="button" name="cancel" value="取    消" onClick="setAllClearQ()"> 
	</td>
</tr>
<tr>
	<td>
		<% request.setAttribute("QueryBean",obj);%>
		<jsp:include page="../../home/page.jsp" />
	</td>
</tr>
</table>
</form>
</body>
</html>