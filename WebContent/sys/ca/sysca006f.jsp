<!--
程式目的：機關代碼維護作業_CPA版本
程式代號：sysca002f_cpa
程式日期：0980811
程式作者：shark
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../home/head.jsp" %>
<jsp:useBean id="obj" scope="request" class="com.kangdainfo.common.view.sys.ca.SYSCA006F">
	<jsp:setProperty name="obj" property="*"/>
</jsp:useBean>
<jsp:useBean id="objList" scope="page" class="java.util.ArrayList"/>

<%

if ("queryAll".equals(obj.getState())) {
	if ("false".equals(obj.getQueryAllFlag())){obj.setQueryAllFlag("true"); }
}else if ("queryOne".equals(obj.getState())) {
	obj = (com.kangdainfo.common.view.sys.ca.SYSCA006F)obj.queryOne();	
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
<%@ include file="../../home/meta.jsp" %>
<script language="javascript">
var insertDefault=new Array(
		new Array("ctDsaYear","<%= Datetime.getYYYYMMDD().substring(0,4)%>"),
		new Array("centerDsaYear","<%= Datetime.getYYYYMMDD().substring(0,4)%>"),
		new Array("unitId","<%= Dept.getUnitId()%>"),
		new Array("unitShortName","<%= Dept.getUnitShortName()%>")
		

		);	//二維陣列, 新增時, 設定預設值
function checkField(){
	var alertStr="";
	if(form1.state.value=="queryAll"){
		//alertStr += checkQuery();
	}else if(form1.state.value=="insert"||form1.state.value=="insertError"||form1.state.value=="update"||form1.state.value=="updateError"){
		alertStr += checkEmpty(form1.centerDsaYear,"精舍護法會年度");
		alertStr += checkEmpty(form1.ctDsaYear,"中台護法會年度");
		alertStr += checkEmpty(form1.dsaJobId,"護法會職稱");
		alertStr += checkEmpty(form1.ctMemberId,"精舍學員編號");
		alertStr += checkEmpty(form1.aliasName,"化名");
		
		
		
	}
	if(alertStr.length!=0){ alert(alertStr); return false; }
	beforeSubmit();
}
function queryOne(id){
	form1.id.value=id;
	form1.state.value="queryOne";
	beforeSubmit();
	form1.submit();
}
function init(){
	
}
function setQ_ctMemberId(q_ctMemberId1,q_ctMemberId)
{
	q_ctMemberId.value=q_ctMemberId1.value;
}
function setQ_ctMemberId1(q_ctMemberId,q_ctMemberId1)
{
	q_ctMemberId1.value=q_ctMemberId.value;
}

function setCtMemberId(ctMemberId1,ctMemberId)
{
	ctMemberId.value=ctMemberId1.value;
}
function setCtMemberId1(ctMemberId,ctMemberId1)
{
	ctMemberId1.value=ctMemberId.value;
}
function setDsaJobId(dsaJobName,dsaJobId)
{
	dsaJobId.value=dsaJobName.value;
}
function setDsaJobName(dsaJobId,dsaJobName)
{
	
	dsaJobName.value=form1.dsaJobId.value;
}
function setQ_dsaJobId(q_dsaJobName,q_dsaJobId)
{
	q_dsaJobId.value=q_dsaJobName.value;
}
function setQ_dsaJobName(q_dsaJobId,q_dsaJobName)
{
	
	q_dsaJobName.value=form1.q_dsaJobId.value;
}
</script>
</head>

<body topmargin="0" onLoad="whatButtonFireEvent('<%=obj.getState()%>');init();showErrorMsg('<%=obj.getErrorMsg()%>');">
<form id="form1" name="form1" method="post" onSubmit="return checkField()" autocomplete="off">

<!--Query區============================================================-->
<div id="queryContainer" style="width:550px;height:100px;display:none">
	<iframe id="queryContainerFrame"></iframe>
	<div class="queryTitle">查詢視窗</div>
	<table class="queryTable"  border="1">

	<tr>
		<td class="queryTDLable">護法會職稱：</td>
		<td class="queryTDInput">
			<input class="field_Q" onChange="setQ_dsaJobName(this,q_dsaJobName);" type="text" name="q_dsaJobId" size="20" maxlength="15" value="<%=obj.getQ_dsaJobId()%>">
	      <select class="field_Q"  name="q_dsaJobName" onChange="setQ_dsaJobId(this,q_dsaJobId);">
				<%=View.getOption("select dsaJobId, dsaJobName from BaseDsaJobDef order by dsaJobId", obj.getQ_dsaJobName())%>
			</select>
		</td>
	</tr>
	<tr>
		<td class="queryTDLable">精舍學員編號：</td>
		<td class="queryTDInput"> <input class="field_Q" onChange="setQ_ctMemberId1(this,q_ctMemberId1);" type="text" name="q_ctMemberId" size="15" maxlength="15" value="<%=obj.getQ_ctMemberId()%>">
	 <select class="field_Q"  name="q_ctMemberId1" onChange="setQ_ctMemberId(this,q_ctMemberId);">
				<%=View.getOption("select ctMemberId, aliasName from CenterMemberInfo where unitId ="+Common.sqlChar(Dept.getUnitId()), obj.getCtMemberId())%>
			</select></td>
		
	</tr>
	<tr>
		<td class="queryTDLable">中台護法會年度：</td>
		<td class="queryTDInput">
			<input class="field_Q" type="text" name="q_ctDsaYear" size="5" maxlength="4" value="<%=obj.getQ_ctDsaYear()%>">
		</td>
	</tr>
		<tr>
		<td class="queryTDLable">精舍護法會年度：</td>
		<td class="queryTDInput">
			<input class="field_Q" type="text" name="q_centerDsaYear" size="5" maxlength="4" value="<%=obj.getQ_centerDsaYear()%>">
		</td>
	</tr>
	<tr>
		<td class="queryTDLable">化名：</td>
		<td class="queryTDInput">
			<input class="field_Q" type="text" name="q_aliasName" size="50" maxlength="40" value="<%=obj.getQ_aliasName()%>">
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
	<div id="formContainer"style="height:auto;">
	<table class="table_form" width="100%" height="100%">
	<tr>
	  <td class="td_form">精舍：</td>
	 
	 <td class="td_form_white"> <input class="field_RO" type="hidden" name="unitId" size="5" maxlength="4" value="<%=obj.getUnitId()%>">
	 <input class="field_RO" type="text" name="unitShortName" size="15" maxlength="10" value="<%=obj.getUnitShortName()%>"></td>
	  
	  <td class="td_form"><font color="red">*</font>中台護法會年度：</td>
	  <td class="td_form_white"><input class="field" type="text" name="ctDsaYear" size="5" maxlength="4" value="<%=obj.getCtDsaYear()%>"></td> 
	  </tr>
	  <tr>
	 <td class="td_form"><font color="red">*</font>護法會職稱：</td>
	  <td class="td_form_white" ><input class="field" onChange="setDsaJobName(this,dsaJobName);"type="text" name="dsaJobId" size="20" maxlength="15" value="<%=obj.getDsaJobId()%>">
	  <select class="field"  name="dsaJobName" onChange="setDsaJobId(this,dsaJobId);">
				<%=View.getOption("select dsaJobId, dsaJobName from BaseDsaJobDef order by dsaJobId", obj.getDsaJobName())%>
			</select>
	  </td>
	 <td class="td_form"><font color="red">*</font>精舍護法會年度：</td>
	  <td class="td_form_white"><input class="field" type="text" name="centerDsaYear" size="5" maxlength="4" value="<%=obj.getCenterDsaYear()%>"></td>
	  </tr>
	   <tr>
	  <td class="td_form"><font color="red">*</font>精舍學員編號：</td>
	 <td class="td_form_white"><input class="field" onChange="setCtMemberId1(this,ctMemberId1);" type="text" name="ctMemberId" size="15" maxlength="15" value="<%=obj.getCtMemberId()%>">
	 <select class="field"  name="ctMemberId1" onChange="setCtMemberId(this,ctMemberId);">
				<%=View.getOption("select ctMemberId, aliasName from CenterMemberInfo  where unitId ="+Common.sqlChar(Dept.getUnitId()), obj.getCtMemberId())%>
			</select></td >
	  
	  <td class="td_form"><font color="red">*</font>化名：</td>
	  <td class="td_form_white"><input class="field" type="text" name="aliasName" size="50" maxlength="40" value="<%=obj.getAliasName()%>"></td> 
	  </tr>
	  <tr>
	  
	  </tr>
	 
	             <tr>
					<td class="td_form" >更新資訊：</td>
					<td class="td_form_white"colspan="3">
						<% request.setAttribute("objBean",obj); %>
						<c:import url="/home/editUser.jsp" />
					</td>
				</tr>
	</table>
	</div>
</td></tr>

<!--Toolbar區============================================================-->
<tr><td class="bg" style="text-align:center">
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
<tr><td class="bg">
<div id="listContainer"style="height:400px;">
<table class="table_form" width="100%" cellspacing="0" cellpadding="0">
	<thead id="listTHEAD">
	<tr>
		<th class="listTH" ><a class="text_link_w" >NO.</a></th>		
		<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',1,false);" href="#">中台護法年度</a></th>
		<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',2,false);" href="#">精舍</a></th>
	    <th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',3,false);" href="#">精舍護法年度</a></th>
		<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',4,false);" href="#">學員</a></th>
		<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',5,false);" href="#">護法會職稱</a></th>
	</tr>
	</thead>
	<tbody id="listTBODY">
	<%
	boolean primaryArray[] = {true,false,false,false,false,false};
	boolean displayArray[] = {false,true,true,true,true,true};
	String alignArray[] = {"center","left","left","center","center","center"};
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
