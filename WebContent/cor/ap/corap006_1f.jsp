<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../home/head.jsp" %>
<jsp:useBean id="obj" scope="request" class="com.kangdainfo.common.view.sys.ca.SYSCA004F">
	<jsp:setProperty name="obj" property="*"/>
</jsp:useBean>
<jsp:useBean id="objList" scope="page" class="java.util.ArrayList"/>
<%
String popZipCode = request.getParameter("popZipCode");
String popAddress = request.getParameter("popAddress");
String popState = request.getParameter("popState");
String popCity = request.getParameter("popCity");

if ("queryAll".equals(obj.getState())) {
	if ("false".equals(obj.getQueryAllFlag())){
		obj.setQueryAllFlag("true"); 
	}
}

if ("true".equals(obj.getQueryAllFlag())){
	objList = (java.util.ArrayList) obj.doQueryAll_corap006_1f();
}

%>
<html>
<head>
<title>地址查詢輔助視窗</title>
<%@ include file = "../../home/meta.jsp" %>
<script type="text/javascript">
function checkField(){
	form1.state.value = "queryAll";
	beforeSubmit();
	return true;
}

function queryOne(zipCode,address,state,city)
{
	if (isObj(opener.document.all.item("<%= popZipCode %>")))
	{	
		opener.document.all.item("<%= popZipCode %>").value=zipCode;		
	}
	if (isObj(opener.document.all.item("<%= popAddress %>")))
	{
		opener.document.all.item("<%= popAddress%>").value=address;		
	}
	if (isObj(opener.document.all.item("<%= popState %>")))
	{
		opener.document.all.item("<%= popState%>").value=state;		
	}
	if (isObj(opener.document.all.item("<%= popCity %>")))
	{
		opener.document.all.item("<%= popCity%>").value=city;		
	}
	window.close();
}

function init(){}
</script>
</head>
<body onload="init();">
<fmt:bundle basename="ApplicationResources">
<form id="form1" name="form1" method="post" onSubmit="return checkField()">
<table width="100%" cellspacing="0" cellpadding="0">
<!--Form區============================================================-->
<tr><td class="bg" >
	<div id="formContainer" style="height:auto">
	<table class="table_form" width="100%" height="100%">	
	<tr>
		<td class="td_form"><fmt:message key="CtMemberInfo.address"/>:</td>
		<td class="td_form_white">
			<input class="field_Q" type="text" name="q_zipInfo" size="30" maxlength="80" value="<%=obj.getQ_zipInfo()%>">
		</td>
	</tr>
	</table>
	</div>
</td></tr>

<!--Toolbar區============================================================-->
<tr>
	<td class="bg" style="text-align:center">
		<input class="toolbar_default" type="submit" name="querySubmit" value="查    詢" >
		<input class="toolbar_default" type="button" name="queryCannel" value="取    消" onClick="window.close()">
		<input type="hidden" name="state" value="<%=obj.getState()%>">
    </td>
</tr>

<tr><td>
<% request.setAttribute("QueryBean",obj);%>
<jsp:include page="../../home/page.jsp" />
</td></tr>

<!--List區============================================================-->
<tr>
	<td class="bgList" >
		<div id="listContainer" style="height:auto">
			<table class="table_form" width="100%" cellspacing="0" cellpadding="0">
				<thead id="listTHEAD">
				<tr>
					<th class="listTH" ><a class="text_link_w" >序號</a></th>
					<th class="listTH"><a class="text_link_w" onclick="return sortTable('listTBODY',1,false);" href="#">郵遞區號</a></th>
					<th class="listTH"><a class="text_link_w" onclick="return sortTable('listTBODY',2,false);" href="#">地址</a></th>
				</tr>
				</thead>
				<tbody id="listTBODY">
				<%
					boolean primaryArray[] = {false,true,true,false,true,true};
					boolean displayArray[] = {false,true,false,true,false,false};
					String[] alignArray = {"center","center","center","center"};
					out.write(View.getQuerylist(primaryArray,displayArray,alignArray,objList,obj.getQueryAllFlag()));
				%>
				</tbody>
			</table>
		</div>
	</td>
</tr>
</table>	
</form>
</fmt:bundle>
</body>
</html>
