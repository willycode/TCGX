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
<jsp:useBean id="obj" scope="request" class="com.kangdainfo.common.view.sys.ca.SYSCA101F">
	<jsp:setProperty name="obj" property="*"/>
</jsp:useBean>
<jsp:useBean id="objList" scope="page" class="java.util.ArrayList"/>

<%

if ("queryAll".equals(obj.getState())) {
	if ("false".equals(obj.getQueryAllFlag())){obj.setQueryAllFlag("true"); }
}else if ("queryOne".equals(obj.getState())) {
	obj = (com.kangdainfo.common.view.sys.ca.SYSCA101F)obj.queryOne();	
}else if ("insert".equals(obj.getState()) || "insertError".equals(obj.getState())) {
	obj.insert();
}else if ("update".equals(obj.getState()) || "updateError".equals(obj.getState())) {
	obj.update();
}else if ("delete".equals(obj.getState()) || "deleteError".equals(obj.getState())) {
	obj.delete();
}
//if ("true".equals(obj.getQueryAllFlag())){
	objList = (java.util.ArrayList) obj.queryAll();
//}
%>

<html>
<head>
<%@ include file="../../home/meta.jsp" %>
<script language="javascript">
var insertDefault;	//二維陣列, 新增時, 設定預設值
function checkField(){
	var alertStr="";
	if(form1.state.value=="queryAll"){
		//alertStr += checkQuery();
	}else if(form1.state.value=="insert"||form1.state.value=="insertError"||form1.state.value=="update"||form1.state.value=="updateError"){
		alertStr += checkEmpty(form1.adYear,"西元年");
		alertStr += checkEmpty(form1.twYear,"民國年");
		alertStr += checkEmpty(form1.lunarName,"天干地支");
		alertStr += checkEmpty(form1.jpYear,"日本年");
		alertStr += checkEmpty(form1.thYear,"泰國年");
	
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
</script>
</head>

<body topmargin="0" onLoad="whatButtonFireEvent('<%=obj.getState()%>');showErrorMsg('<%=obj.getErrorMsg()%>');">
<form id="form1" name="form1" method="post" onSubmit="return checkField()" autocomplete="off">

<!--Query區============================================================-->
<div id="queryContainer" style="width:400px;height:150px;display:none">
	<iframe id="queryContainerFrame"></iframe>
	<div class="queryTitle">查詢視窗</div>
	<table class="queryTable"  border="1">
	
	<tr>
		<td class="queryTDLable">西元年：</td>
		<td class="queryTDInput">
			<input class="field_Q" type="text" name="q_adYear" size="15" maxlength="4" value="<%=obj.getQ_adYear()%>">
		</td>
	</tr>
	<tr>
		<td class="queryTDLable">民國年：</td>
		<td class="queryTDInput">
			<input class="field_Q" type="text" name="q_twYear" size="15" maxlength="15" value="<%=obj.getQ_twYear()%>">
		</td>
	</tr>
	<tr>
		<td class="queryTDLable">天干地支：</td>
		<td class="queryTDInput">
			<input class="field_Q" type="text" name="q_lunarName" size="15" maxlength="15" value="<%=obj.getQ_lunarName()%>">
		</td>
	</tr>
	<tr>
		<td class="queryTDLable">日本年：</td>
		<td class="queryTDInput">
			<input class="field_Q" type="text" name="q_jpYear" size="15" maxlength="15" value="<%=obj.getQ_jpYear()%>">
		</td>
	</tr>
	<tr>
		<td class="queryTDLable">泰國年(佛曆)：</td>
		<td class="queryTDInput">
			<input class="field_Q" type="text" name="q_thYear" size="15" maxlength="15" value="<%=obj.getQ_thYear()%>">
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
	  <td class="td_form"><font color="red">*</font>西元年：</td>
	  <td class="td_form_white"colspan="3"><input class="field" type="text" name="adYear" size="15" maxlength="4" value="<%=obj.getAdYear()%>">格式:2014</td>
	  </tr>
	<tr>
	  <td class="td_form"><font color="red">*</font>民國年：</td>
	  <td class="td_form_white"><input class="field" type="text" name="twYear" size="15" maxlength="15" value="<%=obj.getTwYear()%>">格式:民國103</td>
	   <td class="td_form"><font color="red">*</font>天干地支：</td>
	  <td class="td_form_white"width="35%"><input class="field" type="text" name="lunarName" size="20" maxlength="15" value="<%=obj.getLunarName()%>">格式:癸巳</td>
	  </tr>
	  <tr>
	  <td class="td_form"><font color="red">*</font>日本年：</td>
	  <td class="td_form_white"colspan="3"><input class="field" type="text" name="jpYear" size="15" maxlength="15" value="<%=obj.getJpYear()%>">格式:平成25</td>
	  </tr>
	  <tr>
	  <td class="td_form"><font color="red">*</font>泰國年(佛曆)：</td>
	  <td class="td_form_white"colspan="3"><input class="field" type="text" name="thYear" size="15" maxlength="15" value="<%=obj.getThYear()%>">格式:2556</td>
	  </tr>
	
	             <tr>
					<td class="td_form">更新資訊：</td>
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
		<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',1,false);" href="#">西元年</a></th>
		<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',2,false);" href="#">民國年</a></th>
		<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',3,false);" href="#">天干地支</a></th>
		<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',4,false);" href="#">日本年</a></th>
		<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',5,false);" href="#">泰國年(佛曆)</a></th>

	
	</tr>
	</thead>
	<tbody id="listTBODY">
	<%
	boolean primaryArray[] = {true,false,false,false,false,false};
	boolean displayArray[] = {false,true,true,true,true,true};
	String alignArray[] = {"center","left","left","left","left","left"};
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
