<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file = "/../../home/head.jsp" %>
<%@ page import="com.kangdainfo.common.view.sys.ca.SYSCA201F" %>
<%
	SYSCA201F qBean = (SYSCA201F)request.getAttribute("qBean");
	String qauto = Common.get(request.getParameter("qauto"));
%>

	<div class="queryTitle">查詢視窗</div>
	<table class="queryTable" border="1">
		<tr>
			<td class="queryTDLable">類別種類：</td>
			<td class="queryTDInput">
				<% if (null!=qauto && "T".equals(qauto)) { %>
				<select class="field_QRO" name="qry_catalogId" id="qry_catalogId">
				<% } else { %>
				<select class="field_Q" name="qry_catalogId" id="qry_catalogId">
				<% } %>
					<%=View.getOption("select id, catalogId||'-'||catalogName from CommonCatalog order by catalogId", qBean.getQry_catalogId())%>
				</select>
			</td>
		</tr>
		<tr>
			<td class="queryTDLable">類別編號：</td>
			<td class="queryTDInput">
				<input type="text" class="field_Q" name="qry_codeKindId" size="20" maxlength="10" value="<%=qBean.getQry_codeKindId()%>">
			</td>
		</tr>
		<tr>
			<td class="queryTDLable">類別名稱：</td>
			<td class="queryTDInput">
				<input type="text" class="field_Q" name="qry_codeKindName" size="20" maxlength="50" value="<%=qBean.getQry_codeKindName()%>">
			</td>
		</tr>		
		<tr>
			<td class="queryTDInput" colspan="2" style="text-align:center;">
				<input class="toolbar_default" followPK="false" type="submit" name="querySubmit" id="querySubmit" value="確　　定" >
				<input class="toolbar_default" followPK="false" type="button" name="queryCannel" value="取　　消" onClick="whatButtonFireEvent(this.name)">
			</td>			
		</tr>
	</table>