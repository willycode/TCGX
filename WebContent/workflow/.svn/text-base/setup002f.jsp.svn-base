<!--
程式目的：流程維護作業(流程維護)
程式代號：setup002f
撰寫日期：1030725
程式作者：eric.chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../home/head.jsp" %>
<jsp:include page="../home/secure.jsp">
	<jsp:param name="DTREE_PROGRAM_IDENTIFIER" value="SETUP001" />
</jsp:include>
<jsp:useBean id="obj" scope="request" class="com.kangdainfo.workflow.view.SETUP002F">
	<jsp:setProperty name="obj" property="*"/>
</jsp:useBean>
<jsp:useBean id="objList" scope="page" class="java.util.ArrayList"/>
<%
if ("queryAll".equals(obj.getState())) {
	if ("false".equals(obj.getQueryAllFlag())){obj.setQueryAllFlag("true"); }
}else if ("queryOne".equals(obj.getState())) {
	obj = (com.kangdainfo.workflow.view.SETUP002F)obj.queryOne();	
}else if ("insert".equals(obj.getState()) || "insertError".equals(obj.getState())) {
	obj.insert();
	if ("insertSuccess".equals(obj.getState())) {
		obj.setQueryAllFlag("true");
	}
}else if ("update".equals(obj.getState()) || "updateError".equals(obj.getState())) {
	obj.update();
	if ("updateSuccess".equals(obj.getState())) {
		obj.setQueryAllFlag("true");
	}
}else if ("delete".equals(obj.getState()) || "deleteError".equals(obj.getState())) {
	obj.delete();
	if("deleteError".equals(obj.getState())){
		obj = (com.kangdainfo.workflow.view.SETUP002F)obj.queryOne();
	}
}
if ("true".equals(obj.getQueryAllFlag())){
	objList = (java.util.ArrayList) obj.queryAll();
}
%>
<html>
<head>
<meta http-equiv="Expires" content="0"/>
<meta http-equiv="pragma" content="no-cache"/>
<meta http-equiv="Cache-control" content="no-cache"/>
<%@ include file="../home/meta.jsp" %>
<script type="text/javascript" src="../../js/validate.js"></script>
<script type="text/javascript" src="../../js/function.js"></script>
<script type="text/javascript" src="../../js/tablesoft.js"></script>
<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript">
//二維陣列, 新增時, 設定預設值
var insertDefault;
function checkField(){
	var alertStr ="";
	if(form1.state.value=="insert"||form1.state.value=="insertError"||form1.state.value=="update"||form1.state.value=="updateError"){
		alertStr += checkEmpty(form1.status,"流程-狀態");
		alertStr += checkEmpty(form1.name,"流程-名稱");
		//alertStr += checkEmpty(form1.nextFramePath,"流程-下一節點");		
	}
	if(alertStr.length!=0){ alert(alertStr); return false; }
	beforeSubmit();
	return true;
}

function queryOne(id){
	form1.detailId.value = id;
	form1.state.value = "queryOne";
	beforeSubmit();
	form1.submit();
}

function init() {
	setDisplayItem('spanQueryAll,spanListHidden,spanListPrint','H');
}

function checkURL(surl){
	columnTrim(form1.id);
	if(form1.id.value==""){
		alert("請先執行查詢或新增!");
	}else if( (form1.state.value=="insert")||(form1.state.value=="update")){
		alert("新增或修改狀態無法更換頁標籤，請先點選取消!");
	}else{
		form1.action=surl;
		queryOne(form1.id.value);
	}
}
</script>
</head>
<body onLoad="whatButtonFireEvent('<%=obj.getState()%>');init();showErrorMsg('<%=obj.getErrorMsg()%>');">
<form id="form1" name="form1" method="post" onSubmit="return checkField()" autocomplete="off">
<!--Query區============================================================-->
<TABLE CELLPADDING=0 CELLSPACING=0 valign="top">
	<tr>		
		<td ID=t1 CLASS="tab_border2" width="100"><a href="#" onClick="return checkURL('setup001f.jsp');">節點資料</a></td>
		<td ID=t2 CLASS="tab_border1" width="100" HEIGHT="25">流程維護</td>	
	</tr>
	<tr>
		<td class="tab_line1"></td>
		<td class="tab_line2"></td>	
	</tr>
</TABLE>
<table width="100%" cellspacing="0" cellpadding="0">
<!--Form區============================================================-->
<tr><td nowrap class="bg">
	<div id="formContainer" style="height:auto">
	<table class="table_form" width="100%" height="100%">	
	<tr>		
		<td class="td_form" width="30%">節點代號：</td>
		<td class="td_form_white">
		    <font color="black"><%=obj.getTaskName()%></font>			
		</td>		
	</tr>	
	<tr>		
		<td class="td_form">節點名稱：</td>
		<td class="td_form_white">
		    <font color="black"><%=obj.getTaskChName()%></font>
		</td>		
	</tr>	
	<tr>		
		<td class="td_form" width="30%"><font color="red">*</font>流程-狀態：</td>
		<td class="td_form_white">
			<input class="field" type="text" name="status" size="15" maxlength="20" value="<%=obj.getStatus()%>" onChange="toUpper(this);">
		</td>		
	</tr>
	<tr>		
		<td class="td_form"><font color="red">*</font>流程-名稱：</td>
		<td class="td_form_white">
			<input class="field" type="text" name="name" size="15" maxlength="20" value="<%=obj.getName()%>">
		</td>		
	</tr>
	<tr>		
		<td class="td_form"><font color="red">*</font>流程-下一節點：</td>
		<td class="td_form_white">
			<select class="field" type="select" name="nextFramePath">
				<%=View.getOption("select id, '('||taskName||')'||'-'||taskChName from FramePath where id <>"+Common.getLong(obj.getId())+" order by id ", obj.getNextFramePath())%>
			</select>
		</td>		
	</tr>
	</table>
	</div>
</td></tr>

<!--Toolbar區============================================================-->
<tr><td nowrap class="bgToolbar" style="text-align:center">
	<input type="hidden" name="id" value="<%=obj.getId()%>">
	<input type="hidden" name="detailId" value="<%=obj.getDetailId()%>">
	<input type="hidden" name="state" value="<%=obj.getState()%>">
	<input type="hidden" name="queryAllFlag" value="<%=obj.getQueryAllFlag()%>">
	<input type="hidden" name="userID" value="<%=User.getId()%>">
	<input type="hidden" name="taskName" value="<%=obj.getTaskName()%>">
	<input type="hidden" name="taskChName" value="<%=obj.getTaskChName()%>">
	<jsp:include page="../home/toolbar.jsp" />
</td></tr>

<tr><td nowrap class="bgPagging">
<% request.setAttribute("QueryBean",obj);%>
<jsp:include page="../home/page.jsp" />
</td></tr>

<!--List區============================================================-->
<tr><td nowrap class="bgList">
<div id="listContainer">
<table class="table_form" width="99%" cellspacing="0" cellpadding="0">
	<thead id="listTHEAD">
	<tr>
		<th class="listTH" ><a class="text_link_w" >NO.</a></th>
		<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',1,false);" href="#">流程-狀態</a></th>
		<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',2,false);" href="#">流程-名稱</a></th>
		<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',3,false);" href="#">流程-下一節點</a></th>
	</tr>
	</thead>
	<tbody id="listTBODY">
	<%
	boolean primaryArray[] = {true, false, false, true};
	boolean displayArray[] = {false, true, true, true};
	boolean linkArray[] = {true, true, true, true};
	String[] alignArray = {"center", "center", "center", "center"};	
	out.write(View.getQuerylist(primaryArray, displayArray,alignArray, objList, obj.getQueryAllFlag()));
	%>
	</tbody>
</table>
</div>
</td></tr>
</table>
</form>
</body>
</html>