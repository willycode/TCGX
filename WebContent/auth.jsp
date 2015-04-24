<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.kangdainfo.ServiceGetter"%>
<%@ page import="com.kangdainfo.common.model.bo.*"%>
<%@ page import="com.kangdainfo.common.util.*"%>
<%@ page import="com.kangdainfo.web.util.*"%>
<jsp:useBean id="User" scope="session" class="com.kangdainfo.common.model.bo.CommonUser"/>
<jsp:useBean id="Dept" scope="session" class="com.kangdainfo.common.model.bo.CommonDepartment"/>
<jsp:useBean id="UserRole" scope="session" class="com.kangdainfo.common.model.bo.CommonUserRole"/>
<jsp:useBean id="obj" scope="request" class="com.kangdainfo.common.view.sys.ap.Auth1">
	<jsp:setProperty name="obj" property="*"/>
</jsp:useBean>


<%
String loginAccount  = Common.get(request.getParameter("userID"));
String loginPassword  = Common.get(request.getParameter("userPWD"));
String btnSubmit = Common.get(request.getParameter("state"));
String loginIP = request.getRemoteAddr();	//使用者登入的IP

obj.setLoginAccount(loginAccount);
obj.setLoginPassword(loginPassword);
obj.setLoginIP(loginIP);

if (!"".equals(btnSubmit) && btnSubmit.equals("submit") && !"".equals(loginAccount) && !"".equals(loginPassword) && Validate.checkSpecialChar(loginAccount)==false && Validate.checkSpecialChar(loginPassword)==false){	
	String script =obj.loginCheck(request,session);
	if("0".equals(script)){
		response.sendRedirect("home/frame.jsp"); 
	} else if ("7001".equals(script)){

		response.sendRedirect("sysap001f_s.jsp"); 
	} else {
		out.write("登入錯誤，錯誤代碼："+script+"請洽系統管理員，<a href=\"index.jsp\">請重新登入!</a>");
	}
}
%>