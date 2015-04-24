<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.kangdainfo.common.util.*" %>
<%@ page import="java.lang.reflect.Method"%>
<%
String className = Common.get(request.getParameter("className"));
String methodName = Common.get(request.getParameter("methodName"));  //method須指定為public型態。
if(!"".equals(className)){	
	String s = "";
	try{
		Class<?> c = Class.forName(className);
		Method genFile = c.getMethod(methodName, new Class[]{Object[].class});  //Object[].class為指定Method所使用的參數類型
		s = Common.get(genFile.invoke(c.newInstance(), new Object[]{new Object[]{Common.formToJson(request,c)}})); 
	}catch(Exception e){
		e.printStackTrace();
	}
	out.write(!"".equals(s)?s:""); 
}else{
	throw new Exception("className is empty!!");
}
%>