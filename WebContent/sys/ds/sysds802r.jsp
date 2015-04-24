<!--
程式目的：執行功能查詢
程式代號：sysds802r
程式日期：1030826
程式作者：jason.kuo
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page contentType = "text/html;charset=UTF-8" %>
<%@ include file = "../../home/head.jsp" %>
<jsp:include page="../../home/secure.jsp">
	<jsp:param name="DTREE_PROGRAM_IDENTIFIER" value="SYSDS802R" />
</jsp:include>
<jsp:useBean id = "obj" scope="request" class="com.kangdainfo.common.view.sys.ds.SYSDS802R">
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

function paddingRight(str,lenght){
	if(str.length >= lenght)
		return str;
	else
		return paddingRight(str+"0",lenght);
}

function checkField(){
	var alertStr = "";
	alertStr += checkEmpty(form1.q_begTriggerDate,'使用日期起');
	alertStr += checkEmpty(form1.q_endTriggerDate,'使用日期迄');

	if(form1.q_begTriggerDate.value != ""){
		alertStr += checkDate(form1.q_begTriggerDate,'使用日期起');
	}
	
	if(form1.q_endTriggerDate.value != ""){
		alertStr += checkDate(form1.q_endTriggerDate,'使用日期迄');
	}

	if(form1.q_begTriggerTime.value != ""){
		alertStr += checkInt(form1.q_begTriggerTime,'使用時間起');
	}

	if(form1.q_endTriggerTime.value != ""){
		alertStr += checkInt(form1.q_endTriggerTime,'使用時間迄');
	}

	if(alertStr.length != 0){
		alert(alertStr);
		return false;
	}

	if(form1.q_begTriggerTime.value != ""){
		var begLen = form1.q_begTriggerTime.value.length
		//時間 起 長度小於6碼
		if(begLen < 6){
			if(begLen == 1){
				form1.q_begTriggerTime.value = "0" + form1.q_begTriggerTime.value + "0000";
			}else{
				form1.q_begTriggerTime.value = paddingRight(form1.q_begTriggerTime.value,6);
			}
		}
	}

	if(form1.q_endTriggerTime.value != ""){
		var endLen = form1.q_endTriggerTime.value.length
		//時間 迄 長度小於6碼
		if(endLen < 6){
			if(endLen == 1){ //ex: 1 => 010000
				form1.q_endTriggerTime.value = "0" + form1.q_endTriggerTime.value + "0000";
			}else{	
				form1.q_endTriggerTime.value = paddingRight(form1.q_endTriggerTime.value,6);
			}
		}
	}
	
	form1.state.value = "queryAll";
	beforeSubmit();
	return true;
}

function setValue(centerId,user){
	var obj1 = user;
	var oldUserValue = user.value;
	obj1.options.length = 0;
	obj1.options.add(new Option("請選擇",""));
	var x = getRemoteData(getVirtualPath() + "/ajax/jsonUserId.jsp?centerId=" + centerId.value,"");
	if(x != null && x.length > 0){
		var json = eval('(' + x + ')');
		var i = 0;
		for(i=0; i<json.length; i++){
			if(json[i].userId == null)
				continue;
			var astId = json[i].userId;
			var oOption = new Option(json[i].userName,astId);
			obj1.options.add(oOption);
			if(astId == oldUserValue) oOption.selected=true;
		}
	}
	form1.q_userId.disabled = false;
}

function queryOne(id){
	form1.id.value=id;	
}

function init(){
	if(form1.q_centerId.value == ''){
		form1.q_userId.disabled = true;
	}   
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
					<td class="td_form">使用日期起迄：</td>
					<td class="td_form_white">
						<font color="red">*</font><%= View.getPopCalendar("field_Q","q_begTriggerDate",obj.getQ_begTriggerDate()) %> 
						<input class="field_Q" type="text" name="q_begTriggerTime" size="8" maxlength="6" value="<%= obj.getQ_begTriggerTime()%>">
						&nbsp;~&nbsp;
						<font color="red">*</font><%= View.getPopCalendar("field_Q","q_endTriggerDate",obj.getQ_endTriggerDate()) %>
						<input class="field_Q" type="text" name="q_endTriggerTime" size="8" maxlength="6" value="<%= obj.getQ_endTriggerTime() %>">
					</td>
				</tr>
				<tr>
					<td class="td_form">功能：</td>
					<td class="td_form_white">
						<select class="field_Q" name="q_dtreeId">
							<%= View.getOption("select btnRead,name from CommonDtree where url is not null and url != '' order by pid,sorted",obj.getQ_dtreeId(),false,1) %>
						</select>
					</td>
				</tr>
				<tr>
					<td class="td_form">帳號：</td>
					<td class="td_form_white">精舍：
						<select class="field_Q" name="q_centerId" onChange="setValue(this,form1.q_userId)">
							<%= View.getOption("select centerId,centerShortName from CommonDepartment order by unitId",obj.getQ_centerId(),false,1) %>
						</select>帳號：
						<select class="field_Q" name="q_userId">
							<%= View.getOption("select userId,userName from CommonUser where commonDepartment.unitId = " + Common.sqlChar(obj.getQ_centerId()),obj.getQ_userId(),false,1) %>
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
		<div id="listContainer" style="height:395px">
			<table class="table_form" width="100%" cellspacing="0" cellpadding="0">
				<thead id="listTHEAD">
					<tr>
						<th class="listTH" ><a class="text_link_w" >NO.</a></th>
						<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',1,false);" href="#">精舍</a></th>
						<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',2,false);" href="#">帳號</a></th>
						<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',3,false);" href="#">姓名</a></th>
						<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',4,false);" href="#">功能代號</a></th>
						<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',5,false);" href="#">功能名稱</a></th>
						<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',6,false);" href="#">使用日期時間</a></th>
					</tr>
				</thead> 
				<tbody id="listTBODY">
					<%
						boolean primaryArray[] = {true,false,false,false,false,false,false,false};
						boolean displayArray[] = {false,false,true,true,true,true,true,true};
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