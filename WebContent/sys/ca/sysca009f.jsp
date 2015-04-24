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
<jsp:useBean id="obj" scope="request" class="com.kangdainfo.common.view.sys.ca.SYSCA009F">
	<jsp:setProperty name="obj" property="*"/>
</jsp:useBean>
<jsp:useBean id="objList" scope="page" class="java.util.ArrayList"/>

<%

if ("queryAll".equals(obj.getState())) {
	if ("false".equals(obj.getQueryAllFlag())){obj.setQueryAllFlag("true"); }
}else if ("queryOne".equals(obj.getState())) {
	obj = (com.kangdainfo.common.view.sys.ca.SYSCA009F)obj.queryOne();	
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
		
		new Array("masterPassword","666666")
		);	//二維陣列, 新增時, 設定預設值
function checkField(){
	var alertStr="";
	if(form1.state.value=="queryAll"){
		//alertStr += checkQuery();
	}else if(form1.state.value=="insert"||form1.state.value=="insertError"||form1.state.value=="update"||form1.state.value=="updateError"){
		alertStr += checkButton(form1.healthType,"健康狀況分類");
		alertStr += checkEmpty(form1.healthStatusName,"健康狀況名稱");
		alertStr += checkEmpty(form1.healthStatusDesc,"狀況說明");
		alertStr += checkEmpty(form1.okToEnable,"是否顯示健康狀況");
		
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
		<td class="queryTDLable">健康狀況分類：</td>
		<td class="queryTDInput">
			 <%=View.getRadioBoxTextOption("field_Q","q_healthType","B;body;M;mental",obj.getQ_healthType())%>
		</td>
	</tr>
	<tr>
		<td class="queryTDLable">健康狀況名稱：</td>
		<td class="queryTDInput">
			<input class="field_Q" type="text" name="q_healthStatusName" size="20" maxlength="15" value="<%=obj.getQ_healthStatusName()%>">
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
	  <td class="td_form"><font color="red">*</font>健康狀況分類：</td>
	 <td class="td_form_white"> <%=View.getRadioBoxTextOption("field","healthType","B;body;M;mental",obj.getHealthType())%>	    </td>
	  
	  <td class="td_form"><font color="red">*</font>健康狀況名稱：</td>
	  <td class="td_form_white"><input class="field" type="text" name="healthStatusName" size="20" maxlength="15" value="<%=obj.getHealthStatusName()%>"></td> 
	  </tr>
	  <tr>
	  <td class="td_form"><font color="red">*</font>是否顯示健康狀況：</td>
	  <td class="td_form_white">
	  <select class="field"  name="okToEnable">
				<%=View.getTextOption("true;是;false;否",obj.getOkToEnable(),1) %>
			</select>
	  </td>


	  <td class="td_form"><font color="red">*</font>狀況說明：</td>
	  <td class="td_form_white"><input class="field" type="text" name="healthStatusDesc" size="50" maxlength="40" value="<%=obj.getHealthStatusDesc()%>"></td> 
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
		<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',1,false);" href="#">健康狀況分類</a></th>
		<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',2,false);" href="#">健康狀況名稱</a></th>
	    <th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',3,false);" href="#">狀況說明</a></th>
		<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',4,false);" href="#">是否顯示</a></th>
		
	</tr>
	</thead>
	<tbody id="listTBODY">
	<%
	boolean primaryArray[] = {true,false,false,false,false};
	boolean displayArray[] = {false,true,true,true,true};
	String alignArray[] = {"center","left","left","center","center"};
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
