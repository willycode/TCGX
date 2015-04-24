<!--
程式目的： 親眷關係設定-精舍人員設定學員親屬關係
程式代號：corap007f
程式日期：
程式作者：
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../home/head.jsp" %>
<jsp:useBean id="obj" scope="request" class="com.kangdainfo.ctis.view.cor.ap.CORAP101F">
    <jsp:setProperty name="obj" property="*"/>
</jsp:useBean>
<jsp:useBean id="obj2" scope="request" class="com.kangdainfo.ctis.view.cor.ap.CORAP007F">
    <jsp:setProperty name="obj" property="*"/>
</jsp:useBean>
<jsp:useBean id="objList" scope="page" class="java.util.ArrayList"/>

<%
obj.setUnitId         (User.getCommonDepartment().getUnitId());
obj.setUnitShortName  (User.getCommonDepartment().getUnitShortName());
obj.setQ_unitId       (User.getCommonDepartment().getUnitId());
obj.setQ_unitShortName(User.getCommonDepartment().getUnitShortName());
if ("queryAll".equals(obj.getState())) {
    if ("false".equals(obj.getQueryAllFlag())){obj.setQueryAllFlag("true"); }
} else if ("queryOne".equals(obj.getState())) {
    obj = (com.kangdainfo.ctis.view.cor.ap.CORAP101F)obj.queryOne();
} else if ("insert".equals(obj.getState()) || "insertError".equals(obj.getState())) {
    obj.insert();
} else if ("update".equals(obj.getState()) || "updateError".equals(obj.getState())) {
    obj.update();
} else if ("delete".equals(obj.getState()) || "deleteError".equals(obj.getState())) {
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
var insertDefault = new Array(
    new Array("unitId",        "<%=User.getCommonDepartment().getUnitId()%>"),
    new Array("unitShortName", "<%=User.getCommonDepartment().getUnitShortName()%>")
);  //二維陣列, 新增時, 設定預設值

function checkField() {
    var alertStr = "";
    if(form1.state.value == "queryAll") {
        //alertStr += checkQuery();
    } else if(form1.state.value == "insert" || form1.state.value == "insertError" || form1.state.value == "update" || form1.state.value == "updateError") {
        alertStr += checkEmpty                 (form1.unitId,         "精舍之單位代號");
        alertStr += checkEmpty                 (form1.unitShortName,  "精舍之單位簡稱");
        alertStr += checkEmpty                 (form1.centerMemberId, "精舍學員代號");
        alertStr += checkEmpty                 (form1.usageDate,      "使用日期");
        alertStr += checkEmpty                 (form1.usageTime,      "使用時間");
        alertStr += checkNumber                (form1.usageTime,      "使用時間");
        alertStr += checkNumericColumnMinLength(form1.usageTime,      "使用時間", 4);
    }
    if(alertStr.length != 0) { alert(alertStr); return false; }
    beforeSubmit();
    return true;
}

//新增
function popCorap007_1f(unitId, centerMemberId) {
    var prop       = "";
    var windowTop  = 180;
    var windowLeft = 300;
    prop = prop + "resizable=yes, width=700, height=420, ";
    prop = prop + "top="  + windowTop  + ", ";
    prop = prop + "left=" + windowLeft + ", ";
    prop = prop + "scrollbars=yes";

    window.open("corap007_1f.jsp?unitId=" + unitId + "&popCenterMemberId=" + centerMemberId, "winExp", prop);
}

// 新增
function popCorap007_2f(unitId, unitShortName) {
    var prop       = "";
    var windowTop  = 180;
    var windowLeft = 300;
    prop = prop + "resizable=yes, width=700, height=420, ";
    prop = prop + "top="  + windowTop  + ", ";
    prop = prop + "left=" + windowLeft + ", ";
    prop = prop + "scrollbars=yes";

    window.open("corap007_2f.jsp?unitId=" + unitId + "&popUnitShortName=" + unitShortName, "winExp", prop);
}

function queryOne(id) {
    form1.id.value    = id;
    form1.state.value = "queryOne";
    beforeSubmit();
    form1.submit();
}

function init() {
	setDisplayItem("spanQueryAll,spanUpdate,spanDelete,spanListPrint,spanListHidden","H");
	//spanInsert   新增
	//spanQueryAll 查詢
}

</script>
</head>

<body topmargin="0" onLoad="init();showErrorMsg('<%=obj.getErrorMsg()%>');">
<form id="form1" name="form1" method="post" onSubmit="return checkField()" autocomplete="off">

<!--Query區============================================================-->
<div id="queryContainer" style="width:500px;height:150px;display:none">
    <iframe id="queryContainerFrame"></iframe>
    <div class="queryTitle">查詢視窗</div>
    <table class="queryTable"  border="1">
    <tr>
        <td class="queryTDLable">精舍：</td>
        <td class="queryTDInput">
            <input class="field_Q" type="text" name="q_unitId"        size="10" maxlength="4"  value="<%=obj.getQ_unitId()%>">
            <input class="field_Q" type="text" name="q_unitShortName" size="20" maxlength="10" value="<%=obj.getQ_unitShortName()%>">
        </td>
    </tr>
    <tr>
        <td class="queryTDLable">學員：</td>
        <td class="queryTDInput">
            <select class="field_Q" name="q_centerMemberId">
                <%= View.getOption("Select centerMemberId, centerMemberId + ' ' + aliasName As centerMember From CenterMemberInfo Where unitId = '" + obj.getQ_unitId() + "' Order by centerMemberId", obj.getQ_centerMemberId(), false, 1) %>
            </select>
            <input class="toolbar_default" type="button" name="btnInquireCenterMemberQ" value="查詢精舍學員" onClick="popCorap007_2f('<%=obj.getQ_unitId()%>', 'q_centerMemberId');">
        </td>
    </tr>
    <tr>
        <td class="queryTDLable">使用日期時間：</td>
        <td class="queryTDInput">
            <%=View.getPopCalendar("field_Q", "q_usageDate", obj.getQ_usageDate()) %>
            <input class="field_Q" type="text" name="q_usageTime" size="10" maxlength="6" value="<%=obj.getQ_usageTime()%>">
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
    <div id="formContainer" style="height:auto;">
    <table class="table_form" width="100%" height="100%">
        <tr>
            <td class="td_form"></font>主學員：</td>
            <td class="queryTDInput">
            	<input class="field_Q" type="text" name="ctMemberId" size="10" maxlength="10"  value="<%=obj2.getCtMemberId()%>">
            	<input class="field_Q" type="text" name="aliasName " size="10" maxlength="10" value="<%=obj2.getAliasName()%>">
        	</td>
        </tr>
        <tr>
	  		<td class="td_form" width="10%">No.</td>
	  		<td class="td_form_left" width="10%">親屬</td>
	  		<td class="td_form_left" width="10%">親屬身分</td>
	  		<td class="td_form_left" width="10%">主學員身分</td>
		  	<td class="td_form_left" width="10%">功能</td>
		  	<td class="td_form_left" width="10%">功能</td>
	  	</tr>
	  	<tr id = 'aa' name="a">
	  		<td class="td_form" width="10%" id='G'>1</td>
	  		<td class="td_form_left">
	  			<input class="field_Q" type="text" name="aliasName1" size="8" maxlength="5" value="郭兒子">
	  		</td>
  			<td class="td_form_left" width="10%">
            	<select class="field" name="ctMemberIdM">
            		<%=View.getTextOption("01;兒子;","01",1)%>
                </select>
            </td>
            <td class="td_form_left" width="10%">
            	<select class="field" name="centerMemberId">
                	<%=View.getTextOption("01;父親;","01",1)%>
                </select>
            </td>
            <td class="td_form_left" width="10%">
            	<input class="toolbar_default" type="button" name="deleteMemberF" value="刪除鈕" onClick="whatButtonFireEvent('1')">
            </td>
            <td class="td_form_left" width="10%">
            	<input class="toolbar_default" type="button" name="btnInquireCenterMemberF" value="查親屬" onClick="popCorap007_1f('<%=obj.getUnitId()%>', 'centerMemberId');">
            </td>
	  	</tr>
	  	<tr id = 'bb' name="b">
	  		<td class="td_form" width="10%">2</td>
	  		<td class="td_form_left">
	  			<input class="field_Q" type="text" id="aliasName2" name="aliasName2" size="8" maxlength="5" value="郭女兒">
	  		</td>
  			<td class="td_form_left" width="10%">
            	<select class="field" name="ctMemberIdM">
            		<%=View.getTextOption("01;女兒;","01",1)%>
                </select>
            </td>
            <td class="td_form_left" width="10%">
            	<select class="field" id="centerMemberId" name="centerMemberId">
                	<%=View.getTextOption("01;父親;","01",1)%>
                </select>
            </td>
            <td class="td_form_left" width="10%">
            	<input class="toolbar_default" type="button" name="deleteMemberF" value="刪除鈕" onClick="whatButtonFireEvent('2')">
            </td>
            <td class="td_form_left" width="10%">
            	<input class="toolbar_default" type="button" name="btnInquireCenterMemberF" value="查親屬" onClick="popCorap007_1f('<%=obj.getUnitId()%>', 'centerMemberId');">
            </td>
	  	</tr>
		<!-- 
        <tr>
            <td class="td_form"></font>學員：</td>
            <td class="td_form_white" width="70%">
            	<select class="field" name="centerMemberId">
                	<%= View.getOption("Select centerMemberId, centerMemberId + ' ' + aliasName As centerMember From CenterMemberInfo Where unitId = '" + obj.getUnitId() + "' Order by centerMemberId", obj.getCenterMemberId(), false, 1) %>
                </select>
            <input class="toolbar_default" type="button" name="btnInquireCenterMemberF" value="查詢精舍學員" onClick="popCorap007_2f('<%=obj.getUnitId()%>', 'centerMemberId');">
        </tr>
		-->  
    </table>
    </div>
</td></tr>

<!--Toolbar區============================================================-->
<tr><td class="bg" style="text-align:center">
    <input type="hidden" name="id" value="<%=obj.getId()%>">
    <input type="hidden" name="state" value="<%=obj.getState()%>">
    <input type="hidden" name="queryAllFlag" value="<%=obj.getQueryAllFlag()%>">
    <input type="hidden" name="userID" value="<%=User.getId()%>">
    <span id="spanClear">
		<input class="toolbar_default" type="button" followPK="false" name="clear" value="取　消" onClick="whatButtonFireEvent(this.name)">&nbsp;
	</span>
	<span id="spanConfirm">
		<input class="toolbar_default" type="submit" followPK="false" name="confirm" value="確　定" onClick="setBeforePageUnload(false);">&nbsp;
	</span>
    <span id="spanInsert">
		<input class="toolbar_default" type="button" followPK="false" name="insert"  value="新　增" onClick="popCorap007_2f('B000', '中台');">
	</span>
</td></tr>

</table>
</form>
<script language="javascript">
var whatButtonFireEvent = function(buttonName){
    switch(buttonName){
        case "1":
        	document.getElementById("aa").style.visibility  = 'hidden';
            break;
        case "2":
        	document.getElementById("bb").style.visibility  = 'hidden';
            break;
        default:
            break;
    }
}
</script>
</body>
</html>
