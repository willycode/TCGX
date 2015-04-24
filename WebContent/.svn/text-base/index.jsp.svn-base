<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.kangdainfo.ServiceGetter"%>
<%@ page import="com.kangdainfo.common.model.bo.*"%>
<%@ page import="com.kangdainfo.common.util.*"%>
<%@ page import="com.kangdainfo.web.util.*"%>
<%
if (Common.get(request.getParameter("logout")).equals("Y")) session.invalidate();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>身份驗證</title>
<style type="text/css">
<!--
body {
	background-image: url(images/side_menu_hover.gif);
	margin-left: 0px;
	margin-right: 0px;
}
-->
</style>
<script type="text/javascript">
function checkField(){
	if (document.getElementById("userID").value==""){ 
		alert("請輸入使用者帳號");
		return false; 
	}	
	if (document.getElementById("userPWD").value==""){ 
		alert("請輸入使用者密碼");
		return false;
	}	
	form1.state.value = "submit";
}

function init() {
	form1.userID.focus();
}
</script>
<script type="text/javascript" src="js/function.js"></script>
</head>
<body onLoad="init();">
<form method="post" name="form1" action="auth.jsp" onSubmit="return checkField()" autocomplete="off">
<table width="100%" height="100%" >
<tr><td align="center" valign="middle" >
  <table width="250" border="0" align="center" cellpadding="2" cellspacing="2" class="Pane">
    <tr>
      <th colspan="2" class="Title" ><%=application.getServletContextName()%></th>
    </tr>
    <tr>
      <td>帳號</td>
      <td><input style="FONT-SIZE: 8pt; width: 100px;" maxlength="100" name="userID" id="userID" tabindex="1">
      </td>
    </tr>
    <tr>
      <td>密碼</td>
      <td><input type="password" style="FONT-SIZE: 8pt; width: 100px;" maxlength="12" size="23" name="userPWD" id="userPWD" tabindex="2" /></td>
    </tr>
    <tr>
      <td><input type="submit" name="Submit" value="登　入"></td>
      <td><input type="button" name="fgtPwd" value="忘記密碼" onclick="location.href='fgtPwd.jsp';"></td>
    </tr>
  </table>
</td></tr></table>  
  <input type="hidden" name="state" />

</form>

</body>
</html>
