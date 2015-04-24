<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../home/head.jsp" %>
<%@ page import="java.sql.*" %>
<%@page import="com.kangdainfo.persistence.*"%>
<%!
public void excuteSQL(java.sql.Connection conn, String[] sql) throws Exception{
	try {
		conn.setAutoCommit(false);
		java.sql.Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
		for(int i=0; i<sql.length; i++){
		    if(!"".equals(sql[i].toString()))
		        stmt.executeUpdate(sql[i]);
		}
		stmt.close();
		conn.commit();
	} catch (Exception e) {
		conn.rollback();		
		System.out.println(e.getMessage());
		throw new Exception(e);			
	}
}
%>
<%	
	if (UserRole.getRoleId()>2) {	
		String btnSubmit = Common.get(request.getParameter("btnSubmit"));
		String hql = Common.get(request.getParameter("hql"));
		String sType = Common.get(request.getParameter("sType"));		
		if (!"".equals(btnSubmit) && !"".equals(sType) && !"".equals(sType)) {
			if ("2".equals(sType)) {
				String[] sql = hql.split(";");
				for (int i=0; i<sql.length; i++) {
					ServiceGetter.getInstance().getCommonService().bulkUpdate(sql[i]);	
				}
			} else {
				String[] sql = hql.split(";");
				if (sql!=null && sql.length>0) {
					this.excuteSQL(PersistenceServiceGetter.getInstance().getJdbcTemplate().getDataSource().getConnection(),sql);
				}
			}
			out.write("執行完畢！");
		} else sType = "1";
%>

<html>
<head>
<meta http-equiv="pragma" content="no-cache"/>
<meta http-equiv="Cache-control" content="no-cache"/>
<link rel="stylesheet" href="../../js/default.css" type="text/css">
<script type="text/javascript" src="../../js/validate.js"></script>
<script type="text/javascript" src="../../js/function.js"></script>
<script type="text/javascript" src="../../js/tablesoft.js"></script>
<script language="javascript">
var insertDefault;  //二維陣列, 新增時, 設定預設值
function checkField(){
    var alertStr=checkEmpty(form1.hql,"請輸入要更新的SQL");
    var alertStr=checkEmpty(form1.sType,"執行類型");
    if(alertStr.length!=0){ alert(alertStr); return false; }
    return true;
}
</script>
</head>
<body topmargin="0">
<br>
<form id="form1" name="form1" method="post">
<table align="center" cellpadding="0" cellspacing="0">
<!--Form區============================================================-->
<tr><td class="bg">

    <table class="table_form" width="100%" height="100%">
    <tr>
    <td class="td_lable">請輸入要更新的SQL/HQL</td>
    </tr>
    <tr>
    <td class="td_lable" style="text-align:left">執行類別：<input type="text" class="field" name="sType" size="5" maxlength="1" value="<%=sType%>"> (1.SQL, 2.HQL)</td>
    </tr>    
    <tr>
        <td align="center" class="td_form_white" >
            <textarea name="hql" cols="80" rows="4" class="field"><%=hql%></textarea>
        </td>
    </tr>
    <tr>
        <td class="queryTDInput" colspan="3" style="text-align:center;">
            <input class="toolbar_default" followPK="false" type="submit" name="btnSubmit" value="確　　定" >
            　</td>
    </tr>
    </table>

</td></tr>
</table>
</form>
</body>
</html>
<%
}
%>
