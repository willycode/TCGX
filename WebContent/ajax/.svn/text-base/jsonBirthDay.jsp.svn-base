
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../home/head.jsp" %>
<%@ page import="net.sf.json.*"%>
<%
response.addHeader("Pragma", "No-cache");
response.addHeader("Cache-Control", "no-cache");

String day = ESAPI.encoder().decodeForHTML(Common.get(request.getParameter("day")));
String month = ESAPI.encoder().decodeForHTML(Common.get(request.getParameter("month")));
String year = ESAPI.encoder().decodeForHTML(Common.get(request.getParameter("year")));
String isLunar = Common.get(request.getParameter("isLunar"));
String calendar = ESAPI.encoder().decodeForHTML(Common.get(request.getParameter("calendar")));
String display = ESAPI.encoder().decodeForHTML(Common.get(request.getParameter("display")));

try {
	String ad="";
	if("1".equals(isLunar)){
		
		String hql = "from CommonLunarCalendar where lunarDate="+"'"+year+"年"+month+"月"+day+"日"+"'" ;
		System.out.println(hql);
		CommonLunarCalendar dt = (CommonLunarCalendar) View.getObject(hql);
		if(dt != null){
			ad=dt.getAdDate();
		}		
	}else{
		ad=year+month+day;
	}

	if (calendar != null) {
		JSONObject item=new JSONObject();			
		item.put("ad",ad);
		item.put("calendar",calendar);
		item.put("display",display);
		out.write(item.toString());
	}
} catch (Exception e) {
	e.printStackTrace();
}
%>
