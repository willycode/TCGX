<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../home/head.jsp" %>
<jsp:include page="../../home/secure.jsp">
	<jsp:param name="DTREE_PROGRAM_IDENTIFIER" value="SYSDS805" />
</jsp:include>
<%
com.kangdainfo.common.view.sys.ds.SYSDS805R obj = new com.kangdainfo.common.view.sys.ds.SYSDS805R();
obj.doQueryProcess();
%>

<html>
<head>
<%@ include file="../../home/meta.jsp" %>
<style type="text/css">
<!--
	.text_link_b { 
		color: #000000; 
		text-decoration: none; 
	}
	
	.text_link_b:hover { 		 		
		color: #FF0000; 
		color: #001993;		
		text-decoration: none; 
	}
	
	.table_form {
		border: 0px solid white;
  		border-collapse: collapse;	
		background-color:#FFFFFF;
	}
		
	.td_lable  {
		text-align:center;
		background-color:#ffffd2;
		padding: 2px 5px 2px 2px;
		border-left: 1px solid silver;
		border-bottom: 1px solid silver;
		border-right: 1px solid silver;
		border-top: 1px solid silver;		
	}

	.td_lable_white  {
		text-align:center;
		background-color:#ffffff;
		padding: 2px 5px 2px 2px;
		border-left: 1px solid silver;
		border-bottom: 1px solid silver;
		border-right: 1px solid silver;
		border-top: 1px solid silver;		
	}	
-->
</style>
</head>

<body topmargin="5">
<form id="form1" name="form1" method="post">
  <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
  
  <tr>
  <td>　上線人數總覽</td>
</tr>
  <tr>
  <td><table width="100%" align="center" class="table_form">
  <TR>  
  <TD width="25%" align="center" class="td_lable">本日上線人次</TD>
  <TD width="25%" class="td_lable_white"><%=obj.getVDayCount()%></TD>
  </TR>  
  <TR>  
  <TD align="center" class="td_lable">本月上線人次</TD>
  <TD class="td_lable_white"><%=obj.getVMonthCount()%></TD>
  </TR>  
  <TR>  
  <TD align="center" class="td_lable">年度上線人次</TD>
  <TD class="td_lable_white"><%=obj.getVYearCount() %></TD>
  </TR>  
  <TR>  
  <TD align="center" class="td_lable">累積上線總人次</TD>
  <TD class="td_lable_white"><%=obj.getVTotalCount() %></TD>
  </TR>
  <TR>  
  <TD align="center" class="td_lable">最大日上線人次/日期</TD>
  <TD class="td_lable_white"><%=obj.getVMaxDayCount() + " / " + obj.getVMaxDay()%></TD>
  </TR>
  <TR>  
  <TD align="center" class="td_lable">最大月上線人次/月份</TD>
  <TD class="td_lable_white"><%=obj.getVMaxMonthCount() + " / " + obj.getVMaxMonth()%></TD>
  </TR>
  <TR>  
  <TD align="center" class="td_lable">最大年上線人次/年份</TD>
  <TD class="td_lable_white"><%=obj.getVMaxYearCount() + " / " + obj.getVMaxYear()%></TD>
  </TR>
</table></td>
</tr>
  <tr>
  <td>&nbsp;</td>
</tr>
  <tr>
  <td>&nbsp;</td>
</tr>
  <tr>
  <td>　月份上線人數總覽</td>
</tr>
  <tr>
  <td>
  <table width="100%" align="center" class="table_form">
<thead id="listTHEAD">  
  <TR>
  <TD width="30%" align="center" class="td_lable"><a class="text_link_b" onClick="return sortTable('listTBODY',0,false);" href="#">月份</a></TD>
  <TD width="40%" class="td_lable"><a class="text_link_b" onClick="return sortTable('listTBODY',1,false);" href="#">上線人次</a></TD>
  <TD width="30%" class="td_lable"><a class="text_link_b" onClick="return sortTable('listTBODY',2,false);" href="#">百分比</a></TD>
</TR>
</thead>
<tbody id="listTBODY">
<%=obj.getReportByMonth()%>
</tbody>
</table></td>
</tr>
</table>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
</form>
</body>
</html>



