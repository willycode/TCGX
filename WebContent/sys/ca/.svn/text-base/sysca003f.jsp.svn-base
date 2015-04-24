<!--
程式目的：基本代碼管理
程式代號：sysca001f
撰寫日期：96/04/14
程式作者：clive.chang
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../home/head.jsp" %>
<jsp:useBean id="obj"  scope="request" class="com.kangdainfo.common.view.sys.ca.SYSCA003F">
    <jsp:setProperty name='obj' property='*'/>
</jsp:useBean>
<jsp:useBean id="objList"  scope="page" class="java.util.ArrayList"/>      
<jsp:include page="../../home/secure.jsp">
	<jsp:param name="DTREE_PROGRAM_IDENTIFIER" value="SYSCA003" />
</jsp:include>
<%
if ("queryAll".equals(obj.getState())) {
	if ("false".equals(obj.getQueryAllFlag())){	obj.setQueryAllFlag("true"); }
}else if ("queryOne".equals(obj.getState())) {
	obj = (com.kangdainfo.common.view.sys.ca.SYSCA003F)obj.queryOne();	
}else if ("insert".equals(obj.getState()) || "insertError".equals(obj.getState())) {
	obj.insert();
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
<%@ include file="../../home/meta.jsp" %>
<script type="text/javascript">
var insertDefault;	//二維陣列, 新增時, 設定預設值
function checkField(){
	var alertStr="";
	if(form1.state.value=="queryAll"){
		//alertStr += checkQuery();
	}else if(form1.state.value=="insert"||form1.state.value=="update"){	
		alertStr += checkEmpty(form1.codeKindId,"代碼編號");
		alertStr += checkEmpty(form1.codeKindName,"代碼名稱");
		if(alertStr.length==0) {
			form1.queryAllFlag.value="true";
		}
	}		
	if(alertStr.length!=0){ alert(alertStr); return false; }
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

function init() {

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
			<td class="queryTDLable">代碼編號：</td>
			<td class="queryTDInput">
				<input type="text" class="field_Q" name="q_codeKindId" size="20" maxlength="10" value="<%=obj.getQ_codeKindId()%>">
			</td>
		</tr>
		<tr>
			<td class="queryTDLable">代碼名稱：</td>
			<td class="queryTDInput">
				<input type="text" class="field_Q" name="q_codeKindName" size="20" maxlength="50" value="<%=obj.getQ_codeKindName()%>">
			</td>
		</tr>		
		<tr>
			<td class="queryTDInput" colspan="2" style="text-align:center;">
				<input class="toolbar_default" followPK="false" type="submit" name="querySubmit" value="確　　定" >
				<input class="toolbar_default" followPK="false" type="button" name="queryCannel" value="取　　消" onClick="whatButtonFireEvent(this.name)">
			</td>			
		</tr>
	</table>
</div>

<table width="100%" cellspacing="0" cellpadding="0">
<!--Form區============================================================-->
<tr><td class="bg" >
	<div id="formContainer">
	<table class="table_form" width="100%" height="100%">		
	<tr>		
		<td class="td_form">&nbsp;<font color="red">*</font>代碼編號：</td>
		<td class="td_form_white">
			<input class="field_EP" type="text" name="codeKindId" size="10" maxlength="50" value="<%=obj.getCodeKindId()%>" onChange="toUpper(this);">
		</td>		
	</tr>	
	<tr>		
		<td class="td_form">&nbsp;<font color="red">*</font>代碼名稱：</td>
		<td class="td_form_white">
			<input class="field" type="text" name="codeKindName" size="50" maxlength="100" value="<%=obj.getCodeKindName()%>"></td>		
	</tr>
	<tr>
	  <td class="td_form">代碼長度：</td>
	  <td class="td_form_white"><input class="field_E" type="text" name="codeMaxLen" size="10" maxlength="10" value="<%=obj.getCodeMaxLen()%>"></td>
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
	<input type="hidden" name="userID" value="<%=User.getId()%>">
	<jsp:include page="../../home/toolbar.jsp" />
</td></tr>


<tr><td>
<% request.setAttribute("QueryBean",obj);%>
<jsp:include page="../../home/page.jsp" />
</td></tr>

<!--List區============================================================-->
<tr><td class="bgList" >
<div id="listContainer" >
<table class="table_form" width="100%" cellspacing="0" cellpadding="0">
	<thead id="listTHEAD">
	<tr>
		<th class="listTH"><a class="text_link_w" >NO.</a></th>
		<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',1,false);" href="#" >代碼編號</a></th>
		<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',2,false);" href="#">代碼名稱</a></th>		
	</tr>
	</thead>
	<tbody id="listTBODY">
		<%
		boolean primaryArray[] = {true,  false, false, false, false, false, false, false};
		boolean displayArray[] = {false, true,  true, false, false, false, false, false};
		String[] arrAlign ={"center","center","center","center","center","center","center","center"};
		out.write(View.getQuerylist(primaryArray,displayArray,arrAlign,objList,obj.getQueryAllFlag()));
		%>
	</tbody>
</table>
</div>
</td></tr>
</table>	
</form>

<script language="javascript">
localButtonFireListener.whatButtonFireEvent = function(buttonName){
	switch (buttonName)	{
		case "insert":
			break;	
	}
}
</script>
</body>
</html>