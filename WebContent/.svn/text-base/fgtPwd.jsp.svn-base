<!--
程式目的：忘記密碼維護作業
程式代號：sys0107
撰寫日期：103/08/19
程式作者：jason.kuo
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.kangdainfo.*" %>
<%@ page import="com.kangdainfo.web.util.*" %>
<%@ page import="com.kangdainfo.common.util.*" %>
<%@ page import="com.kangdainfo.common.util.report.*" %>
<%@ page import="com.kangdainfo.common.model.bo.*" %>
<%@ page import="com.kangdainfo.persistence.PersistenceServiceGetter" %>
<jsp:useBean id="obj" scope="request" class="com.kangdainfo.common.view.sys.ap.SYSAP401F">
	<jsp:setProperty name="obj" property="*" />
</jsp:useBean>

<%
	String confirm = request.getParameter("confirm");
	if(Common.get(confirm).equals("確    定")){
		obj.doUpdateForgetPWD();
	}

%>

<html>
<head>
<title>忘記密碼維護作業</title>
<%@ include file="/home/meta.jsp" %>
<script type="text/javascript">
function init(){}

function checkField(){
	var alertStr = "";

	alertStr += checkEmpty(form1.userEmail,"Email");
	alertStr += checkEmpty(form1.userBirthday,"生日");

	if(form1.userEmail.value != ""){
		alertStr += checkEmail(form1.userEmail,"Email");
	}

	if(form1.userBirthday.value != ""){
		alertStr += checkDate(form1.userBirthday,"生日");
	}

	if(alertStr.length != 0){
		alert(alertStr);
		return false;
	}

	form1.submit();
}

function closeWindowForm(){
	//window.close();
	location.href='index.jsp';
}
</script>
</head>
<body onLoad="init();showErrorMsg('<%= obj.getErrorMsg() %>');">
<form id="form1" name="form1" method="post" onSubmit="return checkField()">
	<table width="100%" cellspacing="0" cellpadding="0">
	<tr>
	<td class="bg">
		<table class="table_form" width="100%" height="auto">
			<tr>
				<td class="td_form"><font color="red">*</font>Email:</td>
				<td class="td_form_white">
					<input class="field_Q" type="text" name="userEmail" size="20" maxlength="" value="<%= obj.getUserEmail()%>">
				</td>
			</tr>
			<tr>
				<td class="td_form"><font color="red">*</font>生日:</td>
				<td class="td_form_white">
					<%= View.getPopCalendar("field_Q","userBirthday",obj.getUserBirthday()) %> &nbsp;&nbsp;&nbsp;格式:1030131
				</td>
			</tr>
			<tr>
				<td class="queryTDInput" colspan="2" style="text-align:center">
					<input class="toolbar_default" type="submit" name="confirm" value="確    定">
					<input class="toolbar_default" type="button" name="cancel" value="取    消" onClick="closeWindowForm()">
				</td>
			</tr>
		</table> 
	</td>
	</tr>
	</table>
</form>
</body>
</html>