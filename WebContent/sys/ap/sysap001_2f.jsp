<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../home/head.jsp" %>
<jsp:useBean id="obj" scope="request" class="com.kangdainfo.ctis.view.cor.ap.CORAP006F">
	<jsp:setProperty name="obj" property="*"/>
</jsp:useBean>
<jsp:useBean id="objList" scope="page" class="java.util.ArrayList"/>
<%
String popUserId = request.getParameter("popUserId");
String popUserName = request.getParameter("popUserName");
String popUserBirthday = request.getParameter("popUserBirthday");
String popUserEmail = request.getParameter("popUserEmail");
String popDeptId = request.getParameter("popDeptId");
String popUserPWD = request.getParameter("popUserPWD");
String isMaster = request.getParameter("isMaster");
if ("queryAll".equals(obj.getState())) {
	if ("false".equals(obj.getQueryAllFlag())){
		obj.setQueryAllFlag("true"); 
	}
}

if ("true".equals(obj.getQueryAllFlag())){
	objList = (java.util.ArrayList) obj.doQueryAll_sysap001_2f();
}

%>
<html>
<head>
<title>學員帳號查詢輔助視窗</title>
<%@ include file = "../../home/meta.jsp" %>
<script type="text/javascript">
function checkField(){
	form1.state.value = "queryAll";
	beforeSubmit();
	return true;
}

function queryOne(centerId,centerMemberId,fullName,email1,birthDate,birthMMDD)
{
	if (isObj(opener.document.all.item("<%= popUserId %>")))
	{	
		opener.document.all.item("<%= popUserId %>").value=centerMemberId;		
	}
	
	if (isObj(opener.document.all.item("<%= popUserName %>")))
	{
		opener.document.all.item("<%= popUserName%>").value=fullName;		
	}
	
	if (isObj(opener.document.all.item("<%= popUserBirthday %>")))
	{
		opener.document.all.item("<%= popUserBirthday%>").value=birthDate;		
	}
	
	if (isObj(opener.document.all.item("<%= popUserEmail %>")))
	{
		opener.document.all.item("<%= popUserEmail%>").value=email1;		
	}
	
	if (isObj(opener.document.all.item("<%= popDeptId %>")))
	{
		opener.document.all.item("<%= popDeptId%>").value=centerId;		
	}
	
	if (isObj(opener.document.all.item("<%= popUserPWD %>")))
	{
		opener.document.all.item("<%= popUserPWD%>").value=birthMMDD;		
	}
	if (isObj(opener.document.all.item("<%= isMaster %>")))
	{   
		opener.document.all.item("<%= isMaster%>")[1].checked="false";
	}
	
	window.close();
}

function init(){}
</script>
</head>
<body onload="init();">
<form id="form1" name="form1" method="post" onSubmit="return checkField()">
<table width="100%" cellspacing="0" cellpadding="0">
<!--Form區============================================================-->
<tr><td class="bg" >
	<div id="formContainer" style="height:auto">
	<table class="table_form" width="100%" height="100%">	
	<tr>
		<td class="td_form">精舍：</td>
		<td class="td_form_white" colspan="3">
			<select class="field_Q" name="q_unitId">
				<%= View.getOption("select unitId,unitShortName from CommonDepartment order by unitId",obj.getQ_unitId(),false,1) %>
			</select>
		</td>
	</tr>
    <tr>
		<td class="td_form">學員編號：</td>
		<td class="td_form_white" colspan="3">
			<input class="field_Q" type="text" name="q_centerMemberId" size="20" maxlength="30" value="<%=obj.getQ_centerMemberId()%>">
		</td>
	</tr>
	<tr>
		<td class="td_form">姓名：</td>
		<td class="td_form_white">
			<input class="field_Q" type="text" name="q_fullName" size="20" maxlength="30" value="<%=obj.getQ_fullName()%>">
		</td>
		<td class="td_form">法名：</td>
		<td class="td_form_white">
			<input class="field_Q" type="text" name="q_ctDharmaName" size="20" maxlength="30" value="<%=obj.getQ_ctDharmaName()%>">
		</td>
	</tr>
	<tr>
		<td class="td_form">Email：</td>
		<td class="td_form_white" colspan="3">
			<input class="field_Q" type="text" name="q_email1" size="20" maxlength="30" value="<%=obj.getQ_email1()%>">
		</td>
	</tr>
	</table>
	</div>
</td></tr>

<!--Toolbar區============================================================-->
<tr>
	<td class="bg" style="text-align:center">
		<input class="toolbar_default" type="submit" name="querySubmit" value="查    詢" >
		<input class="toolbar_default" type="button" name="queryCannel" value="取    消" onClick="window.close()">
		<input type="hidden" name="state" value="<%=obj.getState()%>">
    </td>
</tr>

<tr><td>
<% request.setAttribute("QueryBean",obj);%>
<jsp:include page="../../home/page.jsp" />
</td></tr>

<!--List區============================================================-->
<tr>
	<td class="bgList" >
		<div id="listContainer" style="height:auto">
			<table class="table_form" width="100%" cellspacing="0" cellpadding="0">
				<thead id="listTHEAD">
				<tr>
					<th class="listTH" ><a class="text_link_w" >序號</a></th>
					<th class="listTH"><a class="text_link_w" onclick="return sortTable('listTBODY',1,false);" href="#">精舍</a></th>
					<th class="listTH"><a class="text_link_w" onclick="return sortTable('listTBODY',2,false);" href="#">精舍學員編號</a></th>
					<th class="listTH"><a class="text_link_w" onclick="return sortTable('listTBODY',2,false);" href="#">學員</a></th>
					<th class="listTH"><a class="text_link_w" onclick="return sortTable('listTBODY',2,false);" href="#">法名</a></th>
					<th class="listTH"><a class="text_link_w" onclick="return sortTable('listTBODY',2,false);" href="#">Email</a></th>
				</tr>
				</thead>
				<tbody id="listTBODY">
				<%
					boolean primaryArray[] = {true,false,true,true,false,true,true,true};
					boolean displayArray[] = {false,true,true,true,true,true,false,false};
					String[] alignArray = {"center","center","center","center","center","center","center","center"};
					out.write(View.getQuerylist(primaryArray,displayArray,alignArray,objList,obj.getQueryAllFlag()));
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
