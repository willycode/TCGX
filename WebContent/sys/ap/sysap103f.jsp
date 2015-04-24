<!--
程式目的：登入失敗參數維護
程式代號：sys0103
程式日期：1030818
程式作者：ted.yang
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../home/head.jsp" %>

<jsp:useBean id="obj" scope="request" class="com.kangdainfo.common.view.sys.ap.SYSAP103F">
	<jsp:setProperty name="obj" property="*"/>
</jsp:useBean>
<jsp:useBean id="objList" scope="page" class="java.util.ArrayList"/>

<%

String qt = "1";

if ("".equals(obj.getId()))
	if (!"".equals(qt)) obj.setId(qt);	
	
if ("".equals(obj.getId())) {
	out.write("系統無法判斷參數類別，若問題持續,請洽詢系統管理者或相關承辦人員！");
	return;
} else obj.setId(obj.getId());
if ("queryAll".equals(obj.getState())) {
	if ("false".equals(obj.getQueryAllFlag())){obj.setQueryAllFlag("true"); }
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
obj = (com.kangdainfo.common.view.sys.ap.SYSAP103F)obj.queryOne();
%>

<html>
<head>
<%@ include file="../../home/meta.jsp" %>
<script language="javascript">
var insertDefault;	//二維陣列, 新增時, 設定預設值
function checkField(){
	
	var alertStr="";
	alertStr += checkEmpty(form1.field1,"連續失敗次數");
	alertStr += checkEmpty(form1.field2,"帳號自動解除時間");

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
	
	setDisplayItem("spanInsert,spanDuplicate,spanQueryAll,spanDelete,spanListPrint,spanListHidden","H");

}

</script>
</head>

<body topmargin="0" onLoad="whatButtonFireEvent('<%=obj.getState()%>');init();showErrorMsg('<%=obj.getErrorMsg()%>');">
<form id="form1" name="form1" method="post" onSubmit="return checkField()" autocomplete="off">


<table width="100%" cellspacing="0" cellpadding="0">
<!--Form區============================================================-->
<tr><td class="bg">
	<div id="formContainer" style="height:auto;">
	<table class="table_form" width="100%" height="100%">
	<tr>
	  <td class="td_form"><font color="red">*</font>連續失敗次數：</td>
	  <td class="td_form_white"><input class="field" type="text" name="field1" size="10" maxlength="20" value="<%=obj.getField1()%>">次</td>
	  </tr>
	<tr>
	  <td class="td_form"><font color="red">*</font>帳號自動解除時間：</td>
	  <td class="td_form_white"><input class="field" type="text" name="field2" size="10" maxlength="20" value="<%=obj.getField2()%>">分鐘</td>
	  </tr>
	<tr>
	  <td class="td_form"><font color="red">*</font>是否發送Email：</td>
	  <td class="td_form_white">
	    <%=View.getRadioBoxTextOption("field","field3","Y;是;N;否",obj.getField3())%>
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

</table>
</form>
</body>
</html>
