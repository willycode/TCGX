<%@ page import="com.kangdainfo.*" %>
<%@ page import="com.kangdainfo.web.util.*" %>
<%@ page import="com.kangdainfo.common.util.*" %>
<%@ page import="com.kangdainfo.common.util.report.*" %>
<%@ page import="com.kangdainfo.common.model.bo.*" %>
<%@ page import="org.owasp.esapi.ESAPI" %>
<%@ page import="com.kangdainfo.persistence.PersistenceServiceGetter" %>
<jsp:useBean id="User" scope="session" class="com.kangdainfo.common.model.bo.CommonUser"/>
<jsp:useBean id="Dept" scope="session" class="com.kangdainfo.common.model.bo.CommonDepartment"/>
<jsp:useBean id="UserRole" scope="session" class="com.kangdainfo.common.model.bo.CommonUserRole"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:set var="loc" value="zh_TW"/>
<c:if test="${! empty (param.locale)}">
	<c:set var="loc" value="${param.locale}"/>
</c:if> 
<fmt:setLocale value="${loc}"/>

<%
if (User==null || Dept==null || UserRole==null || UserRole.getRoleId()==null || UserRole.getRoleId()<1){
	out.println("<script type=\"text/javascript\">");
	out.println("var prop='';");
	out.println("prop=prop+'width=300px,height=120,scrollbars=no'");
	out.println("window.open('" + Common.getCurrentContextPath() + "/home/sessionTimeout.jsp','sessionTimeout',prop);");
	out.println("top.top.location.href='" + Common.getCurrentContextPath() + "/index.jsp';");
	out.println("</script>");
	return;
}
%>
