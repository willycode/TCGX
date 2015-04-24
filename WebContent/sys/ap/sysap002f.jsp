<!--
程式目的：群組資料維護作業
程式代號：sysap002f
程式日期：0960511
程式作者：Kang Da
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../home/head.jsp" %>
<jsp:include page="../../home/secure.jsp">
	<jsp:param name="DTREE_PROGRAM_IDENTIFIER" value="SYSAP002" />
</jsp:include>
<jsp:useBean id="obj" scope="request" class="com.kangdainfo.common.view.sys.ap.SYSAP002F">
	<jsp:setProperty name="obj" property="*"/>
</jsp:useBean>
<jsp:useBean id="objList" scope="page" class="java.util.ArrayList"/>

<%

if ("queryAll".equals(obj.getState())) {
	if ("false".equals(obj.getQueryAllFlag())){obj.setQueryAllFlag("true"); }
}else if ("queryOne".equals(obj.getState())) {
	obj = (com.kangdainfo.common.view.sys.ap.SYSAP002F)obj.queryOne();	
}else if ("insert".equals(obj.getState()) || "insertError".equals(obj.getState())) {
	obj.insert();
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
<meta http-equiv="Expires" content="-1"/>
<meta http-equiv="pragma" content="no-cache"/>
<meta http-equiv="Cache-control" content="no-cache"/>
<link rel="stylesheet" href="../../js/default.css" type="text/css"/>
<script type="text/javascript" src="../../js/validate.js"></script>
<script type="text/javascript" src="../../js/function.js"></script>
<script type="text/javascript" src="../../js/tablesoft.js"></script>
<script type="text/javascript" src="../../js/json.js"></script>
<script language="javascript">
var insertDefault;	//二維陣列, 新增時, 設定預設值
function checkField(){
	var alertStr="";
	if(form1.state.value=="queryAll"){
		//alertStr += checkQuery();
	}else if(form1.state.value=="insert"||form1.state.value=="insertError"||form1.state.value=="update"||form1.state.value=="updateError"){
		alertStr += checkLen(form1.groupName,"身分別名稱",50);	
		alertStr += checkEmpty(form1.groupName,"身分別名稱");
		alertStr += checkEmpty(form1.groupDesc,"身分別描述");
	}
	if(alertStr.length!=0){ alert(alertStr); return false; }
	beforeSubmit();
}
function queryOne(id,groupName,groupDesc,editId,editDate){
	form1.state.value="queryOne";
	form1.id.value=id;
	/**
	form1.groupName.value=groupName;
	form1.groupDesc.value=groupDesc;
	form1.editID.value=editId;
	form1.editDate.value=editDate;	
	form1.state.value="queryOneSuccess";
	whatButtonFireEvent('queryOneSuccess');
	**/	
	beforeSubmit();
	form1.submit();
}

function checkURL(surl){
	columnTrim(form1.id);
	if(form1.id.value==""){
		alert("請先執行查詢!");
	}else if( (form1.state.value=="insert")||(form1.state.value=="update")){
		alert("新增或修改狀態無法更換頁標籤，請先點選取消!");
	}else{
		form1.action=surl;
		beforeSubmit();
		form1.submit();
	}
}
</script>
</head>

<body topmargin="0" onLoad="whatButtonFireEvent('<%=obj.getState()%>');showErrorMsg('<%=obj.getErrorMsg()%>');">
<form id="form1" name="form1" method="post" onSubmit="return checkField()">
<TABLE CELLPADDING=0 CELLSPACING=0 valign="top">
	<tr>
		<td ID=t1 CLASS="tab_border1" width="100" HEIGHT="25">身分別資料</td>
		<td ID=t2 CLASS="tab_border2" width="100"><a href="#" onClick="return checkURL('sysap003f.jsp');">身分別權限</a></td>		
	</tr>
	<tr>
		<td class="tab_line1"></td>
		<td class="tab_line2"></td>	
	</tr>
</TABLE>
<!--Query區============================================================-->
<div id="queryContainer" style="width:400px;height:130px;display:none">
	<iframe id="queryContainerFrame"></iframe>
	<div class="queryTitle">查詢視窗</div>
	<table class="queryTable"  border="1">
	<tr>
		<td class="queryTDLable">身分別名稱：</td>
		<td class="queryTDInput">
			<input class="field_Q" type="text" name="q_groupName" size="25" maxlength="50" value="<%=obj.getQ_groupName()%>">
		</td>
	</tr>
	<tr>
		<td class="queryTDLable">身分別描述：</td>
		<td class="queryTDInput">
			<input class="field_Q" type="text" name="q_groupDesc" size="25" maxlength="50" value="<%=obj.getQ_groupDesc()%>">
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
<tr><td class="bg">
	<div id="formContainer" style="height:200px">
	<table class="table_form" width="100%" height="100%">
	<tr>
		<td class="td_form"><font color="red">*</font>身分別名稱：</td>
		<td class="td_form_white">
			<input class="field_P" type="text" name="groupName" size="35" maxlength="50" value="<%=obj.getGroupName()%>">
		</td>
	</tr>
	<tr>
		<td class="td_form"><font color="red">*</font>身分別描述：</td>
		<td class="td_form_white">
			<input class="field" type="text" name="groupDesc" size="35" maxlength="250" value="<%=obj.getGroupDesc()%>">
		</td>	
	</tr>
	<tr>
	 	<td class="td_form">特殊選項：</td>
	  	<td class="td_form_white" >
	  		<input class="field" type="checkbox" name="forBranch" value="Y" <%=obj.getForBranch().equals("Y")?"checked":""%> >精舍管理者可勾選的身分別 <br />
	  		<input class="field" type="checkbox" name="topManager" value="Y" <%=obj.getTopManager().equals("Y")?"checked":""%> >每家精舍僅有此唯一帳號<br /> 
	  		<input class="field" type="checkbox" name="unlimitUse" value="Y" <%=obj.getUnlimitUse().equals("Y")?"checked":""%> >於不受限網段可以使用
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
	<input type="hidden" name="id" value="<%=obj.getId()%>">
	<input type="hidden" name="state" value="<%=obj.getState()%>">
	<input type="hidden" name="queryAllFlag" value="<%=obj.getQueryAllFlag()%>">
	<input type="hidden" name="userID" value="<%=User.getId()%>">
	<jsp:include page="../../home/toolbar.jsp" />
</td></tr>

<tr><td>
<% request.setAttribute("QueryBean",obj);%>
<jsp:include page="../../home/page.jsp" />
</td></tr>
<!--List區============================================================-->
<tr><td class="bgList">
<div id="listContainer" style="height:260px">
<table class="table_form" width="100%" cellspacing="0" cellpadding="0">
	<thead id="listTHEAD">
	<tr>
		<th class="listTH" ><a class="text_link_w" >NO.</a></th>
		<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',1,false);" href="#">身分別名稱</a></th>
		<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',2,false);" href="#">身分別描述</a></th>
	</tr>
	</thead>
	<tbody id="listTBODY">
	<%
	boolean primaryArray[] = {true,false,false,false,false};
	boolean displayArray[] = {false,true,true,false,false};
	String	alignArray[] = {"center","left","left","center","center"};
	out.write(View.getQuerylist(primaryArray,displayArray,alignArray,objList,obj.getQueryAllFlag()));
	%>
	</tbody>
</table>
</div>
</td></tr>
</table>
</form>
</body>
</html>



