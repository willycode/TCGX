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
<jsp:useBean id="obj"  scope="request" class="com.kangdainfo.common.view.sys.ca.SYSCA001F">
    <jsp:setProperty name='obj' property='*'/>
</jsp:useBean>
<jsp:useBean id="objList"  scope="page" class="java.util.ArrayList"/>      
<%
//obj.setEditIp(request.getRemoteAddr()); //取取editIp
String qc = Common.get(request.getParameter("qc"));
if (!"".equals(qc)) {
	obj.setQ_codeKindID(qc);	
	obj.setQueryAllFlag("true");
	
	if ("".equals(obj.getQ_id())) {
		CommonCodeKind master = (CommonCodeKind) View.getObject(" from " + CommonCodeKind.class.getCanonicalName() + " where codeKindId='" + qc + "'");
		if (master!=null) {
			obj.setQ_id(master.getId().toString());
			obj.setCodeLabelCon1(master.getCodeLabelCon1());
			obj.setCodeLabelCon2(master.getCodeLabelCon2());
			obj.setCodeLabelCon3(master.getCodeLabelCon3());
			obj.setCodeMaxLen(String.valueOf(master.getCodeMaxLen()));
		}		
	}
}
String progCode = obj.getQ_codeKindID().equals("")?"SYSCA001":("SYSCA001_"+obj.getQ_codeKindID());
%>
<jsp:include page="../../home/secure.jsp">
	<jsp:param name="DTREE_PROGRAM_IDENTIFIER" value="<%=progCode%>" />
</jsp:include>
<%
if ("queryAll".equals(obj.getState())) {
	if ("false".equals(obj.getQueryAllFlag())){	obj.setQueryAllFlag("true"); }
}else if ("queryOne".equals(obj.getState())) {
	obj = (com.kangdainfo.common.view.sys.ca.SYSCA001F)obj.queryOne();	
}else if ("insert".equals(obj.getState()) || "insertError".equals(obj.getState())) {
	obj.insert();
	obj.setQ_id(obj.getCodeKindID());
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
insertDefault = new Array(
	new Array("codeKindID","<%=obj.getCodeKindID().equals("")?obj.getQ_id():obj.getCodeKindID()%>")
);

function checkField(){
	var alertStr="";
	if(form1.state.value=="queryAll"){
		alertStr += checkQuery();
	}else if(form1.state.value=="insert"||form1.state.value=="update"){	
		alertStr += checkEmpty(form1.codeKindID,"代碼種類");
		alertStr += checkEmpty(form1.codeID,"代碼編號");
		alertStr += checkEmpty(form1.codeName,"代碼名稱");
		alertStr += checkDate(form1.issueDate,"實施日期");
		alertStr += checkDate(form1.endDate,"撤銷日期");
		alertStr += checkDateSE(form1.issueDate,form1.endDate,"撤銷日期大於實施日期");
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

function setCodeMaxLen() {
	if (form1.codeKindID.value!='') {
		var q = "select codeMaxLen from CommonCodeKind where id=" + form1.codeKindID.value + " and codeMaxLen is not null";
		var x = getRemoteData(getVirtualPath() + 'ajax/jsonObjects.jsp', q);
		if (x!=null && x.length>0) {
			var json = eval('(' + x + ')');
			setLength(form1.codeID,json.obj0);
		} else {
			setLength(form1.codeID,10);
		}
	}
}

function queryOne(id){
	form1.state.value="queryOne";
	form1.id.value = id;	
	beforeSubmit();
	form1.submit();
}

function init() {
	if (form1.q_codeKindID.value!="" && form1.q_id.value!="") setFormItem('codeKindID','R');
	if (form1.q_codeKindID.value!="" && form1.q_id.value!="") setFormItem('q_id','R');
	//if (form1.q_codeKindID.value!="" && form1.q_codeKindID.value.length>2) form1.q_code.value = form1.q_codeKindID.value;
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
			<td class="queryTDLable">代碼種類：</td>
			<td class="queryTDInput">
				<select class="field_Q" type="select" name="q_id">
				<%=View.getOption("select id, codeKindId||'-'||codeKindName from " + CommonCodeKind.class.getCanonicalName() + " order by codeKindId", obj.getQ_id())%>
				</select>
			</td>
		</tr>
		<tr>
			<td class="queryTDLable">代碼編號：</td>
			<td class="queryTDInput">
				<input type="text" class="field_QE" name="q_codeId" size="20" maxlength="10" value="<%=obj.getQ_codeId()%>">
			</td>
		</tr>
		<tr>
			<td class="queryTDLable">代碼名稱：</td>
			<td class="queryTDInput">
				<input type="text" class="field_Q" name="q_codeName" size="20" maxlength="50" value="<%=obj.getQ_codeName()%>">
			</td>
		</tr>		
		<tr>
			<td class="queryTDLable">英文名稱：</td>
			<td class="queryTDInput">
				<input type="text" class="field_Q" name="q_codeEngName" size="20" maxlength="50" value="<%=obj.getQ_codeEngName()%>">
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
        <td class="td_form" >&nbsp;<font color="red">*</font>代碼種類：</td>
		<td class="td_form_white">
			<select class="field_P" type="select" name="codeKindID" onChange="setCodeMaxLen();">
				<%=View.getOption("select id, codeKindId||'-'||codeKindName from " + CommonCodeKind.class.getCanonicalName() + " order by codeKindId", obj.getCodeKindID())%>
			</select>
		</td>
	</tr>
	<tr>		
		<td class="td_form">&nbsp;<font color="red">*</font>代碼編號：</td>
		<td class="td_form_white">
			<input class="field_EP" type="text" name="codeID" size="10" maxlength="<%=Common.getInt(obj.getCodeMaxLen())>0?obj.getCodeMaxLen():"10"%>" value="<%=obj.getCodeID()%>" onChange="if (form1.codeKindID.value!=8) toUpper(this);">
		</td>		
	</tr>	
	<tr>		
		<td class="td_form">&nbsp;<font color="red">*</font>代碼名稱：</td>
		<td class="td_form_white">
			<input class="field" type="text" name="codeName" size="50" maxlength="100" value="<%=obj.getCodeName()%>"> 
			簡稱：
			<input name="codeShortName" type="text" class="field" id="codeShortName" value="<%=obj.getCodeShortName()%>" size="20" maxlength="100"></td>		
	</tr>
	<tr>
	  <td class="td_form">&nbsp;英文名稱：</td>
	  <td class="td_form_white"><input class="field_E" type="text" name="codeEngName" size="50" maxlength="100" value="<%=obj.getCodeEngName()%>"></td>
	</tr>	
	<tr>
	  <td class="td_form">實施日期：</td>
	  <td class="td_form_white"><%=View.getPopCalendar("field","issueDate",obj.getIssueDate())%>　撤銷日期：<%=View.getPopCalendar("field","endDate",obj.getEndDate())%></td>
	</tr>		
	<%
	if (!"".equals(obj.getCodeLabelCon1())) {
	%>  
	<tr>		
		<td class="td_form">&nbsp;<%=obj.getCodeLabelCon1().equals("")?"條件一":obj.getCodeLabelCon1()%>：</td>
		<td class="td_form_white">
			<input class="field" type="text" name="codeCon1" size="50" maxlength="100" value="<%=obj.getCodeCon1()%>">
		</td>		
	</tr>	
	<%
	} 
	if (!"".equals(obj.getCodeLabelCon2())) {
	%>
	<tr>		
		<td class="td_form">&nbsp;<%=obj.getCodeLabelCon2().equals("")?"條件二":obj.getCodeLabelCon2()%>：</td>
		<td class="td_form_white">
			<input class="field" type="text" name="codeCon2" size="50" maxlength="100" value="<%=obj.getCodeCon2()%>">
		</td>		
	</tr>
	<%
	} 
	if (!"".equals(obj.getCodeLabelCon3())) {
	%>	
	<tr>		
		<td class="td_form">&nbsp;<%=obj.getCodeLabelCon3().equals("")?"條件三":obj.getCodeLabelCon3()%>：</td>
		<td class="td_form_white">
			<input class="field" type="text" name="codeCon3" size="50" maxlength="100" value="<%=obj.getCodeCon3()%>">
		</td>		
	</tr>
	<%} %>
	<tr>		
		<td class="td_form">&nbsp;<%=obj.getMemoLabel().equals("")?"代碼備註":obj.getMemoLabel()%>：</td>
		<td class="td_form_white">
			<input class="field" type="text" name="memo" size="50" maxlength="250" value="<%=obj.getMemo()%>">			
		</td>		
	</tr>
	<tr>
		<td class="td_form">更新資訊：</td>
		<td class="td_form_white">
			<% request.setAttribute("objBean",obj); %>
			<c:import url="/home/editUser.jsp" />
		</td>
	</tr>
	</table>
	</div>
</td></tr>

<!--Toolbar區============================================================-->
<tr><td class="bgToolbar" style="text-align:center">
	<input type="hidden" name="q_codeKindID" value="<%=obj.getQ_codeKindID()%>">
	<input type="hidden" name="oldCodeKindID" value="<%=obj.getOldCodeKindID()%>">
	<input type="hidden" name="accountingYear" value="<%=obj.getAccountingYear()%>">	
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
		<th class="listTH" width="5%"><a class="text_link_w" >NO.</a></th>
		<th class="listTH" width="10%"><a class="text_link_w" onClick="return sortTable('listTBODY',1,false);" href="#" >代碼種類</a></th>
		<th class="listTH" width="10%"><a class="text_link_w" onClick="return sortTable('listTBODY',2,false);" href="#">代碼編號</a></th>
		<th class="listTH" width="20%"><a class="text_link_w" onClick="return sortTable('listTBODY',3,false);" href="#">代碼名稱</a></th>
		<th class="listTH" width="25%"><a class="text_link_w" onClick="return sortTable('listTBODY',3,false);" href="#">英文名稱</a></th>
		<th class="listTH" width="10%"><a class="text_link_w" onClick="return sortTable('listTBODY',3,false);" href="#">異動人員</a></th>
		<th class="listTH" width="10%"><a class="text_link_w" onClick="return sortTable('listTBODY',3,false);" href="#">異動日期</a></th>
		<th class="listTH" width="10%"><a class="text_link_w" onClick="return sortTable('listTBODY',3,false);" href="#">異動時間</a></th>
	</tr>
	</thead>
	<tbody id="listTBODY">
		<%
		boolean primaryArray[] = {true,  false, false, false, false, false, false, false, false, false, false, false};
		boolean displayArray[] = {false, true,  true, true, true, false, false, false, false, true, true, true};
		//style="table-layout:fixed" 
		//center;height:25px
		String[] arrAlign ={"center","center","center","center","center","center","center","center","center","center","center","center"};
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
			if (form1.oldCodeKindID.value!="") form1.codeKindID.value=form1.oldCodeKindID.value;
			else if(form1.q_id.value!="") form1.codeKindID.value=form1.q_id.value;		

			if (form1.q_codeKindID.value!="" && form1.q_id.value!="") setFormItem('codeKindID','R');	
			break;	
	}
}
</script>
</body>
</html>