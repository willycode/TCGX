<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="net.sf.json.*"%>
<%@ include file="../home/head.jsp" %>
<%
response.addHeader("Pragma", "No-cache");
response.addHeader("Cache-Control", "no-cache");
//response.addDateHeader("Expires", 0);

String framePathId = Common.get(request.getParameter("framePathId"));
try {
	if (!"".equals(framePathId)) {
		com.kangdainfo.workflow.model.bo.FramePath c = (com.kangdainfo.workflow.model.bo.FramePath) View.getObject(" from FramePath where id=" + Common.getLong(framePathId));
		if(null!=c){
			out.write(Common.getFramePath(c));	
		}
	}
} catch (Exception e) {
	e.printStackTrace();
}
%>