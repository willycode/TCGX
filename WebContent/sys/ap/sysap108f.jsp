<!--
程式目的：系統參數設定檔 : 系統管理者Email設定
程式代號：sysap1008f
程式日期：0990420
程式作者：clive.chang
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../home/head.jsp" %>
<jsp:useBean id="obj" scope="request" class="com.kangdainfo.common.view.sys.ap.SYSAP100F">
	<jsp:setProperty name="obj" property="*"/>
</jsp:useBean>
<jsp:useBean id="objList" scope="page" class="java.util.ArrayList"/>
<%
obj.setEditIp(request.getRemoteAddr()); //取editIp 
if (UserRole.isUserLevel()) return;

String qt = "8";

if ("".equals(obj.getQ_id()))
	if (!"".equals(qt)) obj.setQ_id(qt);	
	
if ("".equals(obj.getQ_id())) {
	out.write("系統無法判斷參數類別，若問題持續,請洽詢系統管理者或相關承辦人員！");
	return;
} else obj.setId(obj.getQ_id());

if ("update".equals(obj.getState()) || "updateError".equals(obj.getState())) {
	obj.update();
} else {
	obj = (com.kangdainfo.common.view.sys.ap.SYSAP100F)obj.queryOne();	
}
%>

<html>
<head>
<%@ include file="../../home/meta.jsp" %>
<script type="text/javascript">
var insertDefault;	//二維陣列, 新增時, 設定預設值
function doUpdate(){
	form1.state.value = "update";
	form1.submit();
}
function queryOne(id){
}

function init() {
	//document.getElementById("spanToolbar").style.display = "none";
}
</script>
</head>

<body topmargin="0" onLoad="showErrorMsg('<%=obj.getErrorMsg()%>');">
<form id="form1" name="form1" method="post" autocomplete="off">

<table width="100%" cellspacing="0" cellpadding="0">
<!--Form區============================================================-->
<tr><td class="bg">
	<div id="formContainer" style="height:auto;">
	<table class="table_form" width="100%" height="100%">
	<tr>
		<td class="td_form">Email 1：</td>
		<td colspan="3" class="td_form_white">
			<input class="field_Q" type="text" name="field1" size="50" maxlength="100" value="<%=obj.getField1()%>">
		</td>	
	</tr>
	<tr>
		<td class="td_form">Email 2：</td>
		<td colspan="3" class="td_form_white">
			<input class="field_Q" type="text" name="field2" size="50" maxlength="100" value="<%=obj.getField2()%>">
		</td>	
	</tr>
	<tr>
		<td class="td_form">Email 3：</td>
		<td colspan="3" class="td_form_white">
			<input class="field_Q" type="text" name="field3" size="50" maxlength="100" value="<%=obj.getField3()%>">
		</td>	
	</tr>
	<tr>
		<td class="td_form">Email 4：</td>
		<td colspan="3" class="td_form_white">
			<input class="field_Q" type="text" name="field4" size="50" maxlength="100" value="<%=obj.getField4()%>">
		</td>	
	</tr>	
	<tr>
		<td class="td_form">Email 5：</td>
		<td colspan="3" class="td_form_white">
			<input class="field_Q" type="text" name="field5" size="50" maxlength="100" value="<%=obj.getField5()%>">
		</td>	
	</tr>
	<tr>
		<td class="td_form">Email 6：</td>
		<td colspan="3" class="td_form_white">
			<input class="field_Q" type="text" name="field6" size="50" maxlength="100" value="<%=obj.getField6()%>">
		</td>	
	</tr>
	<tr>
		<td class="td_form">Email 7：</td>
		<td colspan="3" class="td_form_white">
			<input class="field_Q" type="text" name="field7" size="50" maxlength="100" value="<%=obj.getField7()%>">
		</td>	
	</tr>
	<tr>
		<td class="td_form">Email 8：</td>
		<td colspan="3" class="td_form_white">
			<input class="field_Q" type="text" name="field8" size="50" maxlength="100" value="<%=obj.getField8()%>">
		</td>	
	</tr>															
	<tr>
		<td class="td_form">更新資訊：</td>
		<td class="td_form_white">
			<% request.setAttribute("objBean",obj); %>
			<c:import url="/home/editUser.jsp" />
		</td>
	</tr>
	</table>
	</div>
</td></tr>

<!--Toolbar區============================================================-->
<tr><td class="bg" style="text-align:center">
	<input type="hidden" name="state" value="<%=obj.getState()%>">
	<input type="hidden" name="queryAllFlag" value="<%=obj.getQueryAllFlag()%>">
    <input type="hidden" name="id" value="<%=obj.getId()%>">
    <input type="hidden" name="q_id" value="<%=obj.getQ_id()%>">
<span id="spanConfirm">
<input class="toolbar_default" type="button" followPK="false" name="confirm" value="更新參數設定" onClick="doUpdate();">&nbsp;
</span>	
</td></tr>

</table>
</form>
</body>
</html>
