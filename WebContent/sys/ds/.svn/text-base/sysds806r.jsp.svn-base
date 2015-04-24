<!--
程式目的：職務角色交接查詢
程式代號：sysds806r
程式日期：1030827
程式作者：jason.kuo
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page contentType = "text/html;charset=UTF-8" %>
<%@ include file = "../../home/head.jsp" %>
<jsp:include page="../../home/secure.jsp">
	<jsp:param name="DTREE_PROGRAM_IDENTIFIER" value="SYSDS806R" />
</jsp:include>
<jsp:useBean id = "obj" scope="request" class="com.kangdainfo.common.view.sys.ds.SYSDS806R">
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
		
	}
	else if ("insert".equals(obj.getState()) || "insertError".equals(obj.getState())) {
		
	}
	else if ("update".equals(obj.getState()) || "updateError".equals(obj.getState())) {

	}
	else if ("delete".equals(obj.getState()) || "deleteError".equals(obj.getState())) {

	}
	
	if ("true".equals(obj.getQueryAllFlag())){
		objList = (java.util.ArrayList) obj.queryAll();
	}
%>
<html>
<head>
<%@ include file = "../../home/meta.jsp" %>
<script type="text/javascript">
function checkField(){
	var alertStr = "";
	alertStr += checkEmpty(form1.q_begTransferDate,'使用日期起');
	alertStr += checkEmpty(form1.q_endTransferDate,'使用日期迄');

	if(form1.q_begTransferDate.value != ""){
		alertStr += checkDate(form1.q_begTransferDate,'使用日期起');
	}
	
	if(form1.q_endTransferDate.value != ""){
		alertStr += checkDate(form1.q_endTransferDate,'使用日期迄');
	}

	if(alertStr.length != 0){
		alert(alertStr);
		return false;
	}
	
	form1.state.value = "queryAll";
	beforeSubmit();
	return true;
}

function queryOne(id){
	form1.id.value=id;	
}

function init(){
}

</script>
</head>
<body onLoad="init();showErrorMsg('<%= obj.getErrorMsg() %>');">
<form id="form1" name="form1" method="post" onSubmit="return checkField()">
<table width="100%" cellspacing="0" cellpadding="0">
<!--Form區============================================================-->
<tr>
	<td class="bg">
		<div id="formContainer" style="height:auto">
			<table class="table_form" width="100%" height="100%">
				<tr>
					<td class="td_form"><font color="red">*</font>使用日期起迄：</td>
					<td class="td_form_white">
						<%= View.getPopCalendar("field_Q","q_begTransferDate",obj.getQ_begTransferDate()) %>
						&nbsp;~&nbsp;
						<%= View.getPopCalendar("field_Q","q_endTransferDate",obj.getQ_endTransferDate()) %>
					</td>
				</tr>
				<tr>
					<td class="td_form">精舍：</td>
					<td class="td_form_white">
						<select class="field_Q" name="q_unitId">
							<%= View.getOption("select unitId,unitShortName from CommonDepartment order by unitId",obj.getQ_unitId(),false,1) %>
						</select>
					</td>
				</tr>
				<tr>
					<td class="td_form">職務交接帳號：</td>
					<td class="td_form_white">
						<select class="field_Q" name="q_rolesOwnerId">
							<%= View.getOption("select userId,userName from CommonUser order by userId",obj.getQ_rolesOwnerId(),false,1) %>
						</select>
					</td>
				</tr>
				<tr>
					<td class="td_form">職務接收帳號：</td>
					<td class="td_form_white">
						<select class="field_Q" name="q_rolesRecipientId">
							<%= View.getOption("select userId,userName from CommonUser order by userId",obj.getQ_rolesRecipientId(),false,1) %>
						</select>
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
		<input class="toolbar_default" type="submit" name="query" value="查    詢">
		<input class="toolbar_default" type="button" name="cancel" value="取    消" onClick="setAllClearQ()"> 
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
		<div id="listContainer" style="height:370px">
			<table class="table_form" width="100%" cellspacing="0" cellpadding="0">
				<thead id="listTHEAD">					
					<tr>
						<th class="listTH"><a class="text_link_w">NO.</a></th>
						<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',1,false);" href="#">精舍</a></th>
						<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',2,false);" href="#">職務交接帳號</a></th>
						<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',3,false);" href="#">交接日期時間</a></th>
						<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',4,false);" href="#">交接角色</a></th>
						<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',5,false);" href="#">職務接收帳號</a></th>
					
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
</body>
</html>