<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="net.sf.json.*"%>
<%@ include file="../home/head.jsp" %>
<%
response.addHeader("Pragma", "No-cache");
response.addHeader("Cache-Control", "no-cache");

String centerId = Common.get(request.getParameter("centerId"));

JSONArray dsField = new JSONArray();
try {
	CommonUser[] user = null;
	
	String hql = "from CommonUser where 1=1 and commonDepartment.unitId = " + Common.sqlChar(centerId);
	System.out.println("jsonUserId == " + hql);
		
	java.util.List<CommonUser> users = ServiceGetter.getInstance().getCommonService().load(hql);
	if(users != null && users.size() > 0){
		user = new CommonUser[users.size()];
		int i = 0;
		for(CommonUser us : users){
			user[i] = us;
			i++;
		}
	}
	
	if(user != null && user.length > 0){
		for(int i=0; i<user.length; i++){
			JSONObject item = new JSONObject();
			item.put("userId",user[i].getUserId());
			item.put("userName",user[i].getUserName());
			dsField.add(item);
		}
		out.write(dsField.toString());
	}
	
} catch (Exception e) {
	e.printStackTrace();
}
%>