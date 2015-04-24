<%@page import="com.kangdainfo.ServiceGetter"%>
<%
	if (ServiceGetter.getInstance().getAuthenticationService().getCurrentUser()!=null) {
		ServiceGetter.getInstance().getCommonService().saveCommonVisitLog(ServiceGetter.getInstance().getAuthenticationService().getCurrentUser(), request.getRemoteAddr(), "2", "Y", null);	
	}
	ServiceGetter.getInstance().getAuthenticationService().invalidateSession(request);
	//session.invalidate();
	response.sendRedirect("../index.jsp?logout=Y");	
%>
