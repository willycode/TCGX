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

<jsp:useBean id="obj" scope="request" class="com.kangdainfo.common.view.sys.ap.SYSAP005F">
	<jsp:setProperty name="obj" property="*"/>
</jsp:useBean>
<jsp:useBean id="objList" scope="page" class="java.util.ArrayList"/>

<%

if ("queryAll".equals(obj.getState())) {
	if ("false".equals(obj.getQueryAllFlag())){obj.setQueryAllFlag("true"); }
}else if ("queryOne".equals(obj.getState())) {
	obj = (com.kangdainfo.common.view.sys.ap.SYSAP005F)obj.queryOne();	
}else if ("insert".equals(obj.getState()) || "insertError".equals(obj.getState())) {
	obj.insert();
}else if ("aclear".equals(obj.getState()) ) {
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
<script type="text/javascript" src="../../js/cbToggle.js"></script>
<%@ include file="../../home/meta.jsp" %>
<script language="javascript">

var insertDefault;	//二維陣列, 新增時, 設定預設值

function checkField(){

	var alertStr="";
	if(form1.state.value=="queryAll"){
		//alertStr += checkQuery();
	}else if(form1.state.value=="insert"||form1.state.value=="insertError"||form1.state.value=="update"||form1.state.value=="updateError"){
		
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
	
	setDisplayItem("spanClear,spanQueryall,spanConfirm,spanInsert,spanDuplicate,spanUpdate,spanDelete,spanListPrint,spanListHidden","H");
   
}

function aclear(id){

	form1.id.value=id;
	form1.state.value='aclear';
	form1.submit();
    
}
function setCenterId(centerShortName,centerId)
{

	centerId.value=form1.centerShortName.value;
}
function setCenterShortName(centerId,centerShortName)
{

	centerShortName.value=form1.centerId.value;
}
</script>
</head>

<body topmargin="0" onLoad="whatButtonFireEvent('<%=obj.getState()%>');init();showErrorMsg('<%=obj.getErrorMsg()%>');">
<form id="form1" name="form1" method="post" onSubmit="return checkField()" autocomplete="off">

<!--Query區============================================================-->

<table width="100%" cellspacing="0" cellpadding="0">
<!--Form區============================================================-->
<tr><td class="bg">
	<div id="formContainer"style="height:auto;">
	<table class="table_form" width="100%" height="100%">
	<tr>
	  <td class="td_form">精舍：</td>
	  <td class="td_form_white">
	  <input class="field_Q" type="text" name="centerId" size="3" maxlength="3" value="<%=obj.getCenterId()%>" onChange="setCenterShortName(this,centerShortName);">
	  <select class="field_Q" type="select" name="centerShortName" onChange="setCenterId(this,centerId);" >
				<%=View.getOption("select unitId, unitShortName from " + CommonDepartment.class.getCanonicalName() + " order by unitid", obj.getCenterShortName())%>
			</select></td>
	  </tr>
	
	  <tr>
	  <td class="td_form">使用者姓名：</td>
	  <td class="td_form_white"><input class="field_Q" type="text" name="userName" size="50" maxlength="100" value="<%=obj.getUserName()%>"></td>
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
	<input class="toolbar_default" followPK="false" type="button" name="querySubmit" value="取   消" onClick="setAllClearQ();">
	<input class="toolbar_default" followPK="false" type="submit" name="querySubmit" value="查　　詢" onClick="form1.state.value='queryAll'">
	<input class="toolbar_default" followPK="false" type="button" name="querySubmit" value="整批解除" onClick="aclear('');">
	
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
	    <th class="listTH"><input type="checkbox" name="cbAll" class="field_Q"></th>
		<th class="listTH" ><a class="text_link_w" >NO.</a></th>		
		<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',1,false);" href="#">精舍</a></th>
		<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',2,false);" href="#">帳號</a></th>
	    <th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',3,false);" href="#">姓名</a></th>
		<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',4,false);" href="#">最近一次登入錯誤時間</a></th>
		<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',5,false);" href="#">錯誤次數</a></th>
		<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',6,false);" href="#">功能</a></th>
	</tr>
	</thead>
	<tbody id="listTBODY">
	<%
	boolean primaryArray[] = {true,false,false,false,false,false,false};
	boolean displayArray[] = {false,true,true,true,true,true,true};
	boolean linkArray[] = {false,false,false,false,false,false,false};
	String alignArray[] = {"center","left","left","center","left","left","left"};
	out.write(obj.getCheckboxQuerylist(primaryArray, displayArray, alignArray,
			objList, obj.getQueryAllFlag(), "fds", linkArray,"","field_Q",-1,false,false));
	%>
	</tbody>
</table>
</div>
</td></tr>
</table>
</form>
<script type="text/javascript">
function checkBtn(){
	document.all.item("clear").disabled = true;
	document.all.item("confirm").disabled = true;
	if(<%=objList.size()<1%>){
  		document.all.item("update").disabled = true;  
  	} else {
  		document.all.item("update").disabled = false;
  	} 	
}
	
var cb = new cbToggle('cb',document.form1,form1.cbAll,'fds');
cb.config.cssTopLevel = true;


</script>
</body>
</html>
