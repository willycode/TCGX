<!--
程式目的：基本代碼類別管理
程式代號：sysca201f
撰寫日期：103.09.11
程式作者：jason.kuo
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../home/head.jsp" %>
<jsp:include page="../../home/secure.jsp">
	<jsp:param name="DTREE_PROGRAM_IDENTIFIER" value="SYSCA201F" />
</jsp:include>
<jsp:useBean id="obj" scope="request" class="com.kangdainfo.common.view.sys.ca.SYSCA201F">
    <jsp:setProperty name='obj' property='*'/>
</jsp:useBean>
<jsp:useBean id="objList" scope="page" class="java.util.ArrayList"/>
<%
	String qauto = Common.get(request.getParameter("qauto"));
	if ("queryAll".equals(obj.getState())) {
		if ("false".equals(obj.getQueryAllFlag())) {
			obj.setQueryAllFlag("true");
		}
	} else if ("queryOne".equals(obj.getState())) {
		obj = (com.kangdainfo.common.view.sys.ca.SYSCA201F) obj.queryOne();
	} else if ("insert".equals(obj.getState()) || "insertError".equals(obj.getState())) {
		obj.insert();
		obj.setQueryAllFlag("true");
	} else if ("update".equals(obj.getState()) || "updateError".equals(obj.getState())) {
		obj.update();
	} else if ("delete".equals(obj.getState()) || "deleteError".equals(obj.getState())) {
		obj.delete();
	}
	if ("true".equals(obj.getQueryAllFlag())) {
		objList = (java.util.ArrayList) obj.queryAll();
	}
%>
<html>
<head>
<%@ include file="../../home/meta.jsp" %>
<script type="text/javascript">
var insertDefault;	//二維陣列, 新增時, 設定預設值

function checkField(){
	var alertStr="";
	if(form1.state.value=="insert"||form1.state.value=="update"){	
		alertStr += checkEmpty(form1.catalogId,"類別種類");
		alertStr += checkEmpty(form1.codeKindId,"類別編號");
		alertStr += checkEmpty(form1.codeKindName,"類別名稱");
	}		
	if(alertStr.length!=0){ 
		alert(alertStr); 
		return false; 
	}
	else {
		if (checkSpecialChar(form1)) {
			beforeSubmit();
			return true;
		}
		return false;		
	}
}

function queryOne(id){
	form1.state.value="queryOne";
	form1.id.value = id;	
	beforeSubmit();
	form1.submit();
}

function init(){}

function checkURL(url){
	var alertStr = "";
	if(form1.state.value == "insert" || form1.state.value =="insertError"
		|| form1.state.value == "update" || form1.state.value == "updateError"){

		alert("新增或修改狀態無法更換頁標籤，請先點選取消!");
	}
	else{
		if(form1.codeKindId.value == null || form1.codeKindId.value == ""){
			alertStr += "類別編號不得為空";
		}

		if(alertStr.length != 0){
			alert(alertStr);
			return false;
		}
		
		form1.state.value ="queryAll";		
		form1.action = url;
		beforeSubmit();
		form1.submit();
		
	}	
}
</script>
</head>
<body onLoad="whatButtonFireEvent('<%=obj.getState()%>');init();showErrorMsg('<%=obj.getErrorMsg()%>');">
<form id="form1" name="form1" method="post" onSubmit="return checkField()" autocomplete="off" >
<!--Query區============================================================-->
<div id="queryContainer" style="width:400px;height:150px;display:none">
	<iframe id="queryContainerFrame"></iframe>
	<% request.setAttribute("qBean",obj); %>
	<jsp:include page="sysca201q.jsp"/>
</div>

<!--sheet區============================================================-->
<table cellspacing="0" cellpadding="0'" valign="top">
	<tr>
		<td nowrap id="t1" class="tab_border1" width="100">類別基本資料維護</td>
		<td nowrap id="t2" class="tab_border2" width="100"><a href="#" onClick="return checkURL('sysca202f.jsp')">代碼基本資料維護</a></td>
	</tr>
	<tr>
		<td nowrap class="tab_line1"></td>
		<td nowrap class="tab_line2"></td>
	</tr>
</table>

<table width="100%" cellspacing="0" cellpadding="0">
<!--Form區============================================================-->
<tr><td class="bg" >
	<div id="formContainer" style="height:auto">
	<table class="table_form" width="100%" height="100%">		
	<tr>
        <td class="td_form"><font color="red">*</font>類別種類：</td>
		<td class="td_form_white">
			<% if (null!=qauto && "T".equals(qauto)) { %>
			<select class="field_QRO" name="catalogId">
			<% } else { %>
			<select class="field" name="catalogId">
			<% } %>
				<%=View.getOption("select id, catalogId||'-'||catalogName from CommonCatalog order by catalogId", obj.getCatalogId())%>
			</select>
		</td>
	</tr>
	<tr>		
		<td class="td_form"><font color="red">*</font>類別編號：</td>
		<td class="td_form_white">
			<input type="text" class="field" name="codeKindId" size="20" maxlength="10" value="<%=obj.getCodeKindId()%>" onChange="toUpper(this)">
		</td>		
	</tr>	
	<tr>		
		<td class="td_form"><font color="red">*</font>類別名稱：</td>
		<td class="td_form_white">
			<input type="text" class="field" name="codeKindName" size="20" maxlength="50" value="<%=obj.getCodeKindName()%>">
		</td>		
	</tr>
	<tr>
		<td class="td_form">更新資訊：</td>
		<td class="td_form_white">
			<%
				request.setAttribute("objBean", obj);
			%>
			<c:import url="/home/editUser.jsp" />
		</td>
	</tr>
	</table>
	</div>
</td></tr>

<!--Toolbar區============================================================-->
<tr>
	<td class="bgToolbar" style="text-align:center">
		<input type="hidden" name="state" value="<%=obj.getState()%>">
		<input type="hidden" name="id" value="<%=obj.getId()%>">
		<input type="hidden" name="queryAllFlag" value="<%=obj.getQueryAllFlag()%>">
		<jsp:include page="../../home/toolbar.jsp" />
	</td>
</tr>


<tr><td>
<%
	request.setAttribute("QueryBean", obj);
%>
<jsp:include page="../../home/page.jsp" />
</td></tr>

<!--List區============================================================-->
<tr><td class="bgList" >
<div id="listContainer" style="height:300px">
<table class="table_form" width="100%" cellspacing="0" cellpadding="0">
	<thead id="listTHEAD">
	<tr>
		<th class="listTH" width="5%"><a class="text_link_w" >NO.</a></th>
		<th class="listTH" width="10%"><a class="text_link_w" onClick="return sortTable('listTBODY',1,false);" href="#" >類別種類名稱</a></th>
		<th class="listTH" width="10%"><a class="text_link_w" onClick="return sortTable('listTBODY',2,false);" href="#">類別編號</a></th>
		<th class="listTH" width="20%"><a class="text_link_w" onClick="return sortTable('listTBODY',3,false);" href="#">類別名稱</a></th>
	</tr>
	</thead>
	<tbody id="listTBODY">
		<%
			boolean primaryArray[] = { true, false, false, false};
			boolean displayArray[] = { false, true, true, true};
			String[] arrAlign = { "center", "center", "center", "center"};
			out.write(View.getQuerylist(primaryArray, displayArray, arrAlign,objList, obj.getQueryAllFlag()));
		%>
	</tbody>
</table>
</div>
</td></tr>
</table>	
</form>
</body>
</html>