<!--
程式目的：流程維護作業(節點維護)
程式代號：setup001f
撰寫日期：1030725
程式作者：eric.chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../home/head.jsp" %>
<jsp:useBean id="obj"  scope="request" class="com.kangdainfo.workflow.view.SETUP001F">
    <jsp:setProperty name='obj' property='*'/>
</jsp:useBean>
<jsp:useBean id="objList"  scope="page" class="java.util.ArrayList"/>
<jsp:include page="../home/secure.jsp">
	<jsp:param name="DTREE_PROGRAM_IDENTIFIER" value="SETUP001" />
</jsp:include>
<%
if ("queryAll".equals(obj.getState())) {
	if ("false".equals(obj.getQueryAllFlag())){	obj.setQueryAllFlag("true"); }
}else if ("queryOne".equals(obj.getState())) {
	obj = (com.kangdainfo.workflow.view.SETUP001F)obj.queryOne();	
}else if ("insert".equals(obj.getState()) || "insertError".equals(obj.getState())) {
	obj.insert();
	obj.setQ_id(obj.getId());
	obj.setQueryAllFlag("true");	
}else if ("update".equals(obj.getState()) || "updateError".equals(obj.getState())) {
	obj.update();
}else if ("delete".equals(obj.getState()) || "deleteError".equals(obj.getState())) {
	obj.delete();
}
if ("true".equals(obj.getQueryAllFlag())){
	objList = (java.util.ArrayList) obj.queryAll();		
}
%>
<html>
<head>
<%@ include file="../home/meta.jsp" %>
<script type="text/javascript">
var insertDefault;

function checkField(){
	var alertStr="";
	if(form1.state.value=="queryAll"){
		//alertStr += checkQuery();
	}else if(form1.state.value=="insert"||form1.state.value=="update"){		
		alertStr += checkEmpty(form1.codeId,"節點種類");
		alertStr += checkEmpty(form1.taskName,"節點代號");
		alertStr += checkEmpty(form1.taskChName,"節點名稱");		
		if(alertStr.length==0) {
			form1.queryAllFlag.value="true";
		}
	}		
	if(alertStr.length!=0){ alert(alertStr); return false; }
	
	beforeSubmit();
	return true;		
}

function queryOne(id){
	form1.state.value="queryOne";
	form1.id.value = id;	
	beforeSubmit();
	form1.submit();
}

function init() {
	setDisplayItem('spanListHidden,spanListPrint','H');
}

function checkURL(surl){
	columnTrim(form1.id);
	if(form1.id.value==""){
		alert("請先執行查詢!");
	}else if( (form1.state.value=="insert")||(form1.state.value=="update")){
		alert("新增或修改狀態無法更換頁標籤，請先點選取消!");
	}else{
		form1.state.value="queryAll";
		form1.action=surl;
		beforeSubmit();
		form1.submit();
	}
}

function showWorkFlowDialog(){
	window.open('workflow.jsp?jsonField=jsonString','_blank','status=false,toolbar=false,menubar=false,location=false,width=1024;height=768');
}
</script>
</head>
<body topmargin="5" onLoad="whatButtonFireEvent('<%=obj.getState()%>');init();showErrorMsg('<%=obj.getErrorMsg()%>');">
<form id="form1" name="form1" method="post" onSubmit="return checkField()" autocomplete="off" >
<!--Query區============================================================-->
<div id="queryContainer" style="width:400px;height:150px;display:none">
	<iframe id="queryContainerFrame"></iframe>
	<div class="queryTitle">查詢視窗</div>
	<table class="queryTable" border="1">
		<tr>
			<td class="queryTDLable">流程種類：</td>
			<td class="queryTDInput">
				<select class="field_Q" type="select" name="q_codeId">
				<%=View.getOption("select codeId, codeName from CommonCode where commonCodeKind.codeKindId='WF' order by codeId", obj.getQ_codeId())%>
				</select>
			</td>
		</tr>
		<tr>
			<td class="queryTDLable">節點代號：</td>
			<td class="queryTDInput">
				<input type="text" class="field_QE" name="q_taskName" size="20" maxlength="10" value="<%=obj.getQ_taskName()%>">
			</td>
		</tr>
		<tr>
			<td class="queryTDLable">節點名稱：</td>
			<td class="queryTDInput">
				<input type="text" class="field_Q" name="q_taskChName" size="20" maxlength="30" value="<%=obj.getQ_taskChName()%>">
			</td>
		</tr>		
		<tr>
			<td class="queryTDLable">執行角色：</td>
			<td class="queryTDInput">
			    <select class="field_Q" type="select" name="q_roleCode">
				<%=View.getOption("select id, groupName||'-'||groupDesc from CommonGroup order by id", obj.getQ_roleCode())%>
				</select>
			</td>
		</tr>		
		<tr>
			<td class="queryTDInput" colspan="2" style="text-align:center;">
			    <input type="hidden" name="q_id" value="<%=obj.getQ_id()%>">
			    <input type="hidden" name="q_isQuery">
				<input class="toolbar_default" followPK="false" type="submit" name="querySubmit" value="確　　定" onClick="form1.q_isQuery.value='Y'">
				<input class="toolbar_default" followPK="false" type="button" name="queryCannel" value="取　　消" onClick="whatButtonFireEvent(this.name)">
			</td>			
		</tr>
	</table>
</div>
<TABLE CELLPADDING=0 CELLSPACING=0 valign="top">
	<tr>
		<td ID=t1 CLASS="tab_border1" width="100" HEIGHT="25">節點資料</td>
		<td ID=t2 CLASS="tab_border2" width="100"><a href="#" onClick="return checkURL('setup002f.jsp');">流程維護</a></td>		
	</tr>
	<tr>
		<td class="tab_line1"></td>
		<td class="tab_line2"></td>	
	</tr>
</TABLE>
<table width="100%" cellspacing="0" cellpadding="0">
<!--Form區============================================================-->
<tr><td class="bg" >
	<div id="formContainer" style="height:auto;">
	<table class="table_form" width="100%" height="100%">		
	<tr>
        <td class="td_form" >&nbsp;<font color="red">*</font>流程種類：</td>
		<td class="td_form_white">
			<select class="field" type="select" name="codeId">
				<%=View.getOption("select codeId, codeName from CommonCode where commonCodeKind.codeKindId='WF' order by codeId", obj.getCodeId())%>
			</select>
		</td>
	</tr>
	<tr>		
		<td class="td_form">&nbsp;<font color="red">*</font>節點代號：</td>
		<td class="td_form_white">
			<input class="field" type="text" name="taskName" size="15" maxlength="20" value="<%=obj.getTaskName()%>" onChange="toUpper(this);">
		</td>		
	</tr>	
	<tr>		
		<td class="td_form">&nbsp;<font color="red">*</font>節點名稱：</td>
		<td class="td_form_white">
			<input class="field" type="text" name="taskChName" size="30" maxlength="30" value="<%=obj.getTaskChName()%>"> 
		</td>		
	</tr>
	<tr>
	    <td class="td_form">&nbsp;導向類別：</td>
	    <td class="td_form_white">
	        <select class="field" name="forwardKind">
				<%=View.getTextOption("1;action;2;JSP;3;直接導向action，不需要經過TodoList清單;",obj.getForwardKind(),1) %>
			</select>
	    </td>
	</tr>
	<tr>		
		<td class="td_form">&nbsp;執行名稱：</td>
		<td class="td_form_white">
			<input class="field" type="text" name="actionName" size="50" maxlength="100" value="<%=obj.getActionName()%>"> 
		</td>		
	</tr>	
    <tr>		
		<td class="td_form">&nbsp;執行程序：</td>
		<td class="td_form_white">
			<input class="field" type="text" name="eventName" size="20" maxlength="30" value="<%=obj.getEventName()%>"> 
		</td>		
	</tr>
	<tr>		
		<td class="td_form">&nbsp;網頁位置：</td>
		<td class="td_form_white">
			<input class="field" type="text" name="pagePath" size="50" maxlength="100" value="<%=obj.getPagePath()%>"> 
		</td>		
	</tr>
	<tr>
		<td class="td_form">&nbsp;執行角色：</td>
		<td class="td_form_white">
			<select class="field" type="select" name="roleCode">
				<%=View.getOption("select id, groupName||'-'||groupDesc from CommonGroup order by id", obj.getRoleCode())%>
		    </select>
		</td>
	</tr>
	<tr>
		<td class="td_form">異動人員/日期：</td>
		<td class="td_form_white">
			[<input class="field_RO" type="text" name="editID" size="10" value="<%=obj.getEditID()%>">/
			<input class="field_RO" type="text" name="editDate" size="7" value="<%=obj.getEditDate()%>">]
		</td>
	</tr>	
	</table>
	</div>
</td></tr>

<!--Toolbar區============================================================-->
<tr><td class="bgToolbar" style="text-align:center">	
	<input type="hidden" name="state" value="<%=obj.getState()%>">
	<input type="hidden" name="id" value="<%=obj.getId()%>">
	<input type="hidden" name="queryAllFlag" value="<%=obj.getQueryAllFlag()%>">
	<input type="hidden" name="userID" value="<%=User.getUserId()%>">
	<textarea id="jsonString" name="jsonString"  style="display:none;width:100%"><%=obj.getJsonString()%></textarea>
	<jsp:include page="../home/toolbar.jsp" />
	<span id="spanDialog">
		<input class="toolbar_default" type="button" followPK="false" name="dialogShow" value="流程顯示" onClick="showWorkFlowDialog()">&nbsp;
	</span>		
</td></tr>

<tr><td>
<% request.setAttribute("QueryBean",obj);%>
<jsp:include page="../home/page.jsp" />
</td></tr>

<!--List區============================================================-->
<tr><td class="bgList" >
<div id="listContainer" >
<table class="table_form" width="100%" cellspacing="0" cellpadding="0">
	<thead id="listTHEAD">
	<tr>
		<th class="listTH" width="5%"><a class="text_link_w" >NO.</a></th>
		<th class="listTH" width="10%"><a class="text_link_w" onClick="return sortTable('listTBODY',1,false);" href="#" >流程種類</a></th>
		<th class="listTH" width="10%"><a class="text_link_w" onClick="return sortTable('listTBODY',2,false);" href="#">節點代號</a></th>
		<th class="listTH" width="20%"><a class="text_link_w" onClick="return sortTable('listTBODY',3,false);" href="#">節點名稱</a></th>
		<th class="listTH" width="25%"><a class="text_link_w" onClick="return sortTable('listTBODY',3,false);" href="#">執行角色</a></th>
	</tr>
	</thead>
	<tbody id="listTBODY">
		<%
		boolean primaryArray[] = {true, false, false, false, false};
		boolean displayArray[] = {false, true, true, true, true};
		String[] arrAlign ={"center","center","center","center","center"};
		out.write(View.getQuerylist(primaryArray,displayArray,arrAlign,objList,obj.getQueryAllFlag()));

		%>
	</tbody>
</table>
</div>
</td></tr>
</table>	
</form>
<script language="javascript">
</script>
</body>
</html>