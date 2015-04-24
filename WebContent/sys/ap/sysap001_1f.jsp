<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../home/head.jsp" %>
<jsp:useBean id="obj" scope="request" class="com.kangdainfo.common.view.sys.ap.SYSAP701F">
	<jsp:setProperty name="obj" property="*"/>
</jsp:useBean>
<jsp:useBean id="objList" scope="page" class="java.util.ArrayList"/>
<%
String popUserId = request.getParameter("popUserId");
String popUserName = request.getParameter("popUserName");
String isMaster = request.getParameter("isMaster");
System.out.println("popUserId = " + popUserId + "," + "popUserName = " + popUserName+",isMaster="+isMaster);

if ("queryAll".equals(obj.getState())) {
	if ("false".equals(obj.getQueryAllFlag())){
		obj.setQueryAllFlag("true"); 
	}
}

if ("true".equals(obj.getQueryAllFlag())){
	objList = (java.util.ArrayList) obj.doQueryAll_sysap001_1f();
}

%>
<html>
<head>
<title>法師帳號查詢輔助視窗</title>
<%@ include file = "../../home/meta.jsp" %>
<script type="text/javascript">
function checkField(){
	form1.state.value = "queryAll";
	beforeSubmit();
	return true;
}

function queryOne(masterId,masterName,isMaster)
{
	if (isObj(opener.document.all.item("<%= popUserId %>")))
	{	
		opener.document.all.item("<%= popUserId %>").value=masterId;		
	}
	if (isObj(opener.document.all.item("<%= popUserName %>")))
	{
		opener.document.all.item("<%= popUserName%>").value=masterName;		
	}
	if (isObj(opener.document.all.item("<%= isMaster %>")))
	{   
		opener.document.all.item("<%= isMaster%>")[0].checked=true;
	}
	
	window.close();
}

function init(){}
</script>
</head>
<body onload="init();">
<form id="form1" name="form1" method="post" onSubmit="return checkField()">
<table width="100%" cellspacing="0" cellpadding="0">
<!--Form區============================================================-->
<tr><td class="bg" >
	<div id="formContainer" style="height:auto">
	<table class="table_form" width="100%" height="100%">	
	<tr>
		<td class="td_form">法師衣編：</td>
		<td class="td_form_white">
			<input class="field_Q" type="text" name="q_masterId" size="20" maxlength="5" value="<%=obj.getQ_masterId()%>">
		</td>
	</tr>
    <tr>
		<td class="td_form">法師法名：</td>
		<td class="td_form_white">
			<input class="field_Q" type="text" name="q_masterName" size="20" maxlength="30" value="<%=obj.getQ_masterName()%>">
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
					<th class="listTH"><a class="text_link_w" onclick="return sortTable('listTBODY',1,false);" href="#">法師衣編</a></th>
					<th class="listTH"><a class="text_link_w" onclick="return sortTable('listTBODY',2,false);" href="#">法師法名</a></th>
				</tr>
				</thead>
				<tbody id="listTBODY">
				<%
					boolean primaryArray[] = {false,true,true};
					boolean displayArray[] = {false,true,true};
					String[] alignArray = {"center","center","center"};
					out.write(View.getQuerylist(primaryArray,displayArray,alignArray,objList,obj.getQueryAllFlag()));
				%>
				</tbody>
			</table>
		</div>
	</td>
</tr>
</table>	
</form>
</body>
</html>
