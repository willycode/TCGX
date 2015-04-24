
<!--
程式目的：個人基本資料維護
程式代號：sysap001f_s
程式日期：0950518
程式作者：clive.chang
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../home/head.jsp" %>
<jsp:useBean id="obj" scope="request" class="com.kangdainfo.common.view.sys.ap.SYSAP001F">
	<jsp:setProperty name="obj" property="*"/>
</jsp:useBean>
<%
String actItem = Common.checkGet(request.getParameter("actItem"));
if (User!=null) {
	obj.setId(User.getId().toString());
	String confirm = request.getParameter("confirm");
	if (Common.get(confirm).equals("確　定　更　新")) {
		obj.setEditID(User.getUserId());
		obj.doUpdatePeraonal();
	}	
	obj = (com.kangdainfo.common.view.sys.ap.SYSAP001F)obj.queryOne();
	
%>

<html>
<head>
<title>個人基本資料維護</title>
<%@ include file="../../home/meta.jsp" %>
<script type="text/javascript">

function checkPassword(column){
	var letters = 0;
	var numbers = 0;
	
	if (column.value.length < 8) {		
		column.style.backgroundColor = errorbg;
		return "新密碼長度至少為8碼，請重新輸入！\n";
	}
	else{
		for(var i=0; i<column.value.length; i++){
			if(column.value.charAt(i) >= 'a' && column.value.charAt(i) <= 'z'){
				letters++;
			}

			if(column.value.charAt(i) >= 'A' && column.value.charAt(i) <= 'Z'){
				letters++;
			}

			if(column.value.charAt(i) >= '0' && column.value.charAt(i) <= '9'){
				numbers++;
			} 
		}

		if(letters <= 0 || numbers <= 0){
			column.style.backgroundColor = errorbg;
			return "新密碼必須是英文字母及數字的組合，請重新輸入！\n";
		}
	}

	column.style.backgroundColor = "";
	return "";
}

function checkField(){
    var alertStr="";
    
		alertStr += checkEmpty(form1.userId,"帳號");
		alertStr += checkEmpty(form1.userName,"姓名");
		alertStr += checkEmpty(form1.userBirthday,"生日");
		if(form1.userBirthday.value != ""){alertStr += checkDate(form1.userBirthday,"生日")};
		alertStr += checkEmpty(form1.userPWD,"原密碼");
		/*
		if (form1.userNewPWD.value != "" && form1.userNewPWD.value.length < 8) {
			alertStr += "密碼長度至少為8碼，請重新輸入！\n";
		}
		*/

		if(form1.userNewPWD.value != ""){
			alertStr += checkPassword(form1.userNewPWD);
		}
		//alertStr += checkEmpty(form1.chkUserNewPWD,"確認密碼");	
		if(form1.chkUserNewPWD.value != "" && (form1.chkUserNewPWD.value != form1.userNewPWD.value)){
			form1.chkUserNewPWD.style.backgroundColor = errorbg;
			alertStr += "確認密碼與新密碼不相同，請重新輸入！\n";
		}
		
		alertStr += checkEmpty(form1.deptId,"機關");
		//alertStr += checkEmpty(form1.userTitle,"職稱");
		
		alertStr += checkEmpty(form1.userEmail,"Email");
		if(form1.userEmail.value != ""){alertStr += checkEmail(form1.userEmail,"Email")};
    if(alertStr.length!=0){ alert(alertStr); return false; }
    form1.submit();
}

function init(s) {	
	if ((s!=null) && (s=="修改完成")) {
		/**
		if (confirm("個人基本資料更新完成，是否要關閉視窗？")){
			window.close();
		}	
		**/	
		alert("個人基本資料更新完成");
		closePersonalWindow();		
	} else {
		showErrorMsg(s);
	}

}

function closePersonalWindow() {
	window.close();
}

function activeItem() {
	if (isObj(opener.document.getElementById('<%=actItem%>'))) {
		opener.titleBarButtonClick(opener.document.getElementById('<%=actItem%>'));
		opener.document.getElementById('<%=actItem%>').focus();
	}
}

//onbeforeunload="activeItem();"
</script>

</head>

<body topmargin="5" onLoad="init('<%=obj.getErrorMsg()%>');">
<form id="form1" name="form1" method="post" onSubmit="return checkField()">
<table width="100%" cellspacing="0" cellpadding="0">
<!--Form區============================================================-->
<tr><td class="bg">
	<table class="table_form" width="100%" height="100%">
	<tr>
		<td class="td_form"><font color="red">*</font>帳號：</td>
		<td class="td_form_white" colspan="3">
			<input class="field_RO" type="text" name="userId" size="20" maxlength="20" value="<%=obj.getUserId()%>">
		</td>
	</tr>
	<tr>
	  <td class="td_form"><font color="red">*</font>姓名：</td>
	  <td class="td_form_white" colspan = "3">
			<input class="field" type="text" name="userName" size="20" maxlength="50" value="<%=obj.getUserName()%>">		</td>
	  <td class="td_form" style="display:none">電話：</td>
	  <td class="td_form_white" style="display:none">
			<input class="field" type="text" name="userTel" size="20" maxlength="20" value="<%=obj.getUserTel()%>">		</td>
	</tr>
	<tr>
		<td class="td_form"><font color="red">*</font>生日：</td>
		<td class="td_form_white" colspan = "3">
			<%= View.getPopCalendar("field","userBirthday",obj.getUserBirthday()) %> &nbsp;&nbsp;&nbsp; 格式:1030131
		</td>
		<td class="td_form" style="display:none">傳真：</td>
		<td class="td_form_white" style="display:none">
			<input class="field" type="text" name="userFax" size="20" maxlength="20" value="<%=obj.getUserFax()%>">		</td>
	</tr>
	<tr>
		<td class="td_form"><font color="red">*</font>原密碼：</td>
		<td class="td_form_white" colspan = "3">
			<input class="field" type="password" name="userPWD" size="20" maxlength="50" value="<%=obj.getUserPWD()%>">		
		</td>
	</tr>
	<tr>
		<td class="td_form">新密碼：</td>
		<td class="td_form_white" colspan = "3">
			<input class="field" type="password" name="userNewPWD" size="20" maxlength="50" value="<%= obj.getUserNewPWD() %>">
			P.S.&nbsp;要變更密碼時，才需輸入。
		</td>
	</tr>
	<tr>
		<td class="td_form">確認密碼：</td>
		<td class="td_form_white" colspan = "3">
			<input class="field" type="password" name="chkUserNewPWD" size="20" maxlength="50" value="<%= obj.getChkUserNewPWD()%>">
		</td>
	</tr>
	<tr>
	  <td class="td_form"><font color="red">*</font>單位：</td>
	  <td colspan="3" class="td_form_white">
			<%=View.getPopOrgan("field_PRO","deptId",obj.getDeptId(),obj.getDeptIdName(),"N","accountingYear","manageDept") %>		</td>
	</tr>
	<tr style="display:none">
	  <td class="td_form">手機：</td>
	  <td colspan="3" class="td_form_white">
			<input class="field" type="text" name="userMobile" size="20" maxlength="20" value="<%=obj.getUserMobile()%>">
		</td>
	  </tr>	
	<tr>
	  <td class="td_form"><font color="red">*</font>Email：</td>
	  <td colspan="3" class="td_form_white">
			<input class="field" type="text" name="userEmail" size="60" maxlength="100" value="<%=obj.getUserEmail()%>">		</td>
	  </tr>
	</table>
</td></tr>

<!--Toolbar區============================================================-->
<tr><td class="bg" style="text-align:center">
<span id="spanConfirm">
<input class="toolbar_default" type="submit" followPK="false" name="confirm" value="確　定　更　新" >
</span>
</td></tr>

</table>
</form>

</body>
</html>
<%
} else {
	out.println("<br><br><br><p align=center>對不起，找不到您的個人資料，若問題持續，請洽系統管理者或承辦人員！<br><br></p>");	
}
%>