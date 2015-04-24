<!--
程式目的：系統參數設定檔 : SMTP Email Server 參數設定
程式代號：sysap106f
程式日期：0990420
程式作者：clive.chang
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../home/head.jsp" %>
<jsp:useBean id="obj" scope="request" class="com.kangdainfo.common.view.sys.ap.SYSAP100F">
	<jsp:setProperty name="obj" property="*"/>
</jsp:useBean>
<%
if (UserRole.isUserLevel()) return;

String qt = "6";

if ("".equals(obj.getQ_id()))
	if (!"".equals(qt)) obj.setQ_id(qt);	
	
if ("".equals(obj.getQ_id())) {
	out.write("系統無法判斷參數類別，若問題持續,請洽詢系統管理者或相關承辦人員！");
	return;
} else obj.setId(obj.getQ_id());

if ("update".equals(obj.getState()) || "updateError".equals(obj.getState())) {
	obj.update();
} else {
	obj = (com.kangdainfo.common.view.sys.ap.SYSAP100F)obj.queryOne();	
}
%>
<html>
<head>
<%@ include file="../../home/meta.jsp" %>
<script type="text/javascript">
var insertDefault;	//二維陣列, 新增時, 設定預設值
function doUpdate(){
	form1.state.value = "update";
	form1.submit();
}
function queryOne(id){
}

function init() {
	//document.getElementById("spanToolbar").style.display = "none";
}
</script>
</head>

<body topmargin="0" onLoad="showErrorMsg('<%=obj.getErrorMsg()%>');">
<form id="form1" name="form1" method="post" autocomplete="off">

<table width="100%" cellspacing="0" cellpadding="0">
<!--Form區============================================================-->
<tr><td class="bg">
	<div id="formContainer" style="height:auto;">
	<table class="table_form" width="100%" height="100%">
	<tr>
		<td class="td_form">Host Name：</td>
		<td colspan="3" class="td_form_white">
			<input class="field_Q" type="text" name="field1" size="50" maxlength="100" value="<%=obj.getField1()%>">
		</td>	
	</tr>
	<tr>
		<td class="td_form">SMTP - SSL Port：</td>
		<td colspan="3" class="td_form_white">
			<input class="field_Q" type="text" name="field2" size="50" maxlength="100" value="<%=obj.getField2()%>">
		</td>	
	</tr>
	<tr>
		<td class="td_form">POP3 - SSL Port：</td>
		<td colspan="3" class="td_form_white">
			<input class="field_Q" type="text" name="field3" size="50" maxlength="100" value="<%=obj.getField3()%>">
		</td>	
	</tr>				
	<tr>
		<td class="td_form">SSL：</td>
		<td colspan="3" class="td_form_white">
			<select class="field_Q" name="field4">
				<%=View.getYNOption(obj.getField4())%>			
			</select>
		</td>	
	</tr>	
	<tr>
		<td class="td_form">TLS：</td>
		<td colspan="3" class="td_form_white">
			<select class="field_Q" name="field5">
				<%=View.getYNOption(obj.getField5())%>			
			</select>		
		</td>	
	</tr>
	<tr>
		<td class="td_form">User：</td>
		<td colspan="3" class="td_form_white">
			<input class="field_Q" type="text" name="field6" size="50" maxlength="100" value="<%=obj.getField6()%>">
		</td>	
	</tr>	
	<tr>
		<td class="td_form">PassWord：</td>
		<td colspan="3" class="td_form_white">
			<input class="field_Q" type="password" name="field7" size="50" maxlength="100" value="<%=obj.getField7()%>">
		</td>	
	</tr>
	<tr>
		<td class="td_form">寄件者名稱：</td>
		<td colspan="3" class="td_form_white">
			<input class="field_Q" type="text" name="field8" size="50" maxlength="100" value="<%=obj.getField8()%>">
		</td>	
	</tr>
	<tr>
		<td class="td_form">寄件者EMAIL：</td>
		<td colspan="3" class="td_form_white">
			<input class="field_Q" type="text" name="field9" size="50" maxlength="100" value="<%=obj.getField9()%>">
		</td>	
	</tr>
	<tr>
		<td class="td_form">郵件編碼：</td>
		<td colspan="3" class="td_form_white">
			<select class="field_Q" name="field10">
				<%=View.getTextOption("UTF-8;UTF-8;BIG5;BIG5",obj.getField10())%>			
			</select>		
		</td>	
	</tr>
	<tr>
		<td class="td_form">是否啟用自動寄送Mail：</td>
		<td colspan="3" class="td_form_white">
			<select class="field_Q" name="field11">
				<%=View.getTextOption("Y;是;N;否",obj.getField11())%>			
			</select>		
		</td>	
	</tr>	
	<tr>
		<td class="td_form">異動人員/日期：</td>
		<td colspan="3" class="td_form_white">
			[<input class="field_RO" type="text" name="editID" size="10" value="<%=obj.getEditID()%>">/
			<input class="field_RO" type="text" name="editDate" size="7" value="<%=obj.getEditDate()%>">]		</td>
	</tr>	
	</table>
	</div>
</td></tr>

<!--Toolbar區============================================================-->
<tr><td class="bg" style="text-align:center">
	<input type="hidden" name="state" value="<%=obj.getState()%>">
	<input type="hidden" name="queryAllFlag" value="<%=obj.getQueryAllFlag()%>">
    <input type="hidden" name="id" value="<%=obj.getId()%>">
    <input type="hidden" name="q_id" value="<%=obj.getQ_id()%>">
<span id="spanConfirm">
<input class="toolbar_default" type="button" followPK="false" name="confirm" value="更新參數設定" onClick="doUpdate();">&nbsp;
</span>	
</td></tr>

</table>
</form>
</body>
</html>
