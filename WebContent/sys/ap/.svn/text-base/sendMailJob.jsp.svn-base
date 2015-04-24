<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.kangdainfo.ServiceGetter"%>
<%
System.out.println("======================= Start sendMailSchedule Job ===========================");
ServiceGetter.getInstance().getScheduleService().getResetLockScheduleDao().parseScheduleAndSaveLog();
System.out.println("======================= End sendMailSchedule Job ===========================");
out.write("執行完畢");
%>