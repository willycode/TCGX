<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../home/head.jsp" %>
<jsp:useBean id="obj"  scope="request" class="com.kangdainfo.common.view.sys.ex.SYSEX903R">
    <jsp:setProperty name='obj' property='*'/>
</jsp:useBean>
<%
%>   
<html>
<head>
<%@ include file="../../home/meta.jsp" %>
<script type="text/javascript">
function setReportType(intType) {
	form1.state.value = intType;
	form1.submit();
}
</script>

</head>
<body>
<form id="form1" name="form1" method="post" autocomplete="off" action="sysex903p.jsp">
輸出格式:<select name="q_outputFormat">
	<%=View.getJasperReportFormatOption("PDF") %>
</select><BR><BR>
ProcessModel:<select name="state">
	<%=View.getTextOption("1;JDBC;2;Hibernate", "1") %>
</select><br>

<input type="submit" name="btnSubmit" value="輸出報表">
</form>
</body>
</html>