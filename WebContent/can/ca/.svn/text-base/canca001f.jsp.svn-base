<!--
程式目的：課程代碼維護作業
程式代號：canca001f
程式日期：103.09.10
程式作者：David Chiu
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../home/head.jsp" %>
<jsp:useBean id="obj" scope="request" class="com.kangdainfo.ctis.view.can.ca.CANCA001F">
    <jsp:setProperty name="obj" property="*"/>
</jsp:useBean>
<jsp:useBean id="objList" scope="page" class="java.util.ArrayList"/>

<%

if ("queryAll".equals(obj.getState())) {
    if ("false".equals(obj.getQueryAllFlag())){obj.setQueryAllFlag("true"); }
} else if ("queryOne".equals(obj.getState())) {
    obj = (com.kangdainfo.ctis.view.can.ca.CANCA001F)obj.queryOne();
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
);  //二維陣列, 新增時, 設定預設值

function checkField() {
    var alertStr = "";
    if(form1.state.value == "queryAll") {
        //alertStr += checkQuery();
    } else if(form1.state.value == "insert" || form1.state.value == "insertError" || form1.state.value == "update" || form1.state.value == "updateError") {
        alertStr += checkEmpty(form1.chanCatId,          "禪修班代碼");
        alertStr += checkEmpty(form1.chanCatName,        "禪修班名稱");
        alertStr += checkEmpty(form1.chanCatEngName,     "禪修班英文名稱");
        alertStr += checkEmpty(form1.chanCatBookSeq,     "指定教材序號");
        alertStr += checkEmpty(form1.chanCatBookName,    "指定教材名稱");
        alertStr += checkEmpty(form1.chanCatBookEngName, "指定教材英文名稱");
    }
    if(alertStr.length != 0) { alert(alertStr); return false; }
    beforeSubmit();
    return true;
}

function queryOne(id) {
    form1.id.value    = id;
    form1.state.value = "queryOne";
    beforeSubmit();
    form1.submit();
}

function init() {}

</script>
</head>

<body topmargin="0" onLoad="whatButtonFireEvent('<%=obj.getState()%>');init();showErrorMsg('<%=obj.getErrorMsg()%>');">
<form id="form1" name="form1" method="post" onSubmit="return checkField()" autocomplete="off">

<!--Query區============================================================-->
<div id="queryContainer" style="width:600px;height:150px;display:none">
    <iframe id="queryContainerFrame"></iframe>
    <div class="queryTitle">查詢視窗</div>
    <table class="queryTable"  border="1">
    <tr>
        <td class="queryTDLable">禪修班代碼：</td>
        <td class="queryTDInput">
            <input class="field_Q" type="text" name="q_chanCatId"          size="10" maxlength="5"  value="<%=obj.getQ_chanCatId()%>">
        </td>
    </tr>
    <tr>
        <td class="queryTDLable">禪修班名稱：</td>
        <td class="queryTDInput">
            <input class="field_Q" type="text" name="q_chanCatName"        size="20" maxlength="10" value="<%=obj.getQ_chanCatName()%>">
        </td>
    </tr>
    <tr>
        <td class="queryTDLable">禪修班英文名稱：</td>
        <td class="queryTDInput">
            <input class="field_Q" type="text" name="q_chanCatEngName"     size="60" maxlength="50" value="<%=obj.getQ_chanCatEngName()%>">
        </td>
    </tr>
    <tr>
        <td class="queryTDLable">指定教材序號：</td>
        <td class="queryTDInput">
            <input class="field_Q" type="text" name="q_chanCatBookSeq"     size="10" maxlength="5"  value="<%=obj.getQ_chanCatBookSeq()%>">
        </td>
    </tr>
    <tr>
        <td class="queryTDLable">指定教材名稱：</td>
        <td class="queryTDInput">
            <input class="field_Q" type="text" name="q_chanCatBookName"    size="30" maxlength="20" value="<%=obj.getQ_chanCatBookName()%>">
        </td>
    </tr>
    <tr>
        <td class="queryTDLable">指定教材英文名稱：</td>
        <td class="queryTDInput">
            <input class="field_Q" type="text" name="q_chanCatBookEngName" size="60" maxlength="50" value="<%=obj.getQ_chanCatBookEngName()%>">
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
            <td class="td_form"><font color="red">*</font>禪修班代碼：</td>
            <td class="td_form_white" colspan="3"><input class="field" type="text" name="chanCatId"          size="10" maxlength="5"  value="<%=obj.getChanCatId()%>"></td>
        </tr>
        <tr>
            <td class="td_form"><font color="red">*</font>禪修班名稱：</td>
            <td class="td_form_white" colspan="3"><input class="field" type="text" name="chanCatName"        size="20" maxlength="10" value="<%=obj.getChanCatName()%>"></td>
        </tr>
        <tr>
            <td class="td_form"><font color="red">*</font>禪修班英文名稱：</td>
            <td class="td_form_white" colspan="3"><input class="field" type="text" name="chanCatEngName"     size="60" maxlength="50" value="<%=obj.getChanCatEngName()%>"></td>
        </tr>
        <tr>
            <td class="td_form"><font color="red">*</font>指定教材序號：</td>
            <td class="td_form_white" colspan="3"><input class="field" type="text" name="chanCatBookSeq"     size="10" maxlength="5"  value="<%=obj.getChanCatBookSeq()%>"></td>
        </tr>
        <tr>
            <td class="td_form"><font color="red">*</font>指定教材名稱：</td>
            <td class="td_form_white" colspan="3"><input class="field" type="text" name="chanCatBookName"    size="30" maxlength="20" value="<%=obj.getChanCatBookName()%>"></td>
        </tr>
        <tr>
            <td class="td_form"><font color="red">*</font>指定教材英文名稱：</td>
            <td class="td_form_white" colspan="3"><input class="field" type="text" name="chanCatBookEngName" size="60" maxlength="50" value="<%=obj.getChanCatBookEngName()%>"></td>
        </tr>
        <tr>
            <td class="td_form" >更新資訊：</td>
            <td class="td_form_white" colspan="3">
              <% request.setAttribute("objBean", obj); %>
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
<% request.setAttribute("QueryBean", obj);%>
<jsp:include page="../../home/page.jsp" />
</td></tr>
<!--List區============================================================-->
<tr><td class="bg">
<div id="listContainer" style="height:400px;">
<table class="table_form" width="100%" cellspacing="0" cellpadding="0">
    <thead id="listTHEAD">
    <tr>
        <th class="listTH"><a class="text_link_w" >NO.</a></th>
        <th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY', 1, false);" href="#">禪修班代碼</a></th>
        <th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY', 2, false);" href="#">禪修班名稱</a></th>
        <th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY', 3, false);" href="#">指定教材序號</a></th>
        <th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY', 4, false);" href="#">指定教材名稱</a></th>
    </tr>
    </thead>
    <tbody id="listTBODY">
    <%
    boolean primaryArray[] = {true, false, false, false, false};
    boolean displayArray[] = {false, true, true, true, true};
    String    alignArray[] = {"center", "center", "center", "center", "center"};
    out.write(View.getQuerylist(primaryArray, displayArray, alignArray, objList, obj.getQueryAllFlag()));
    %>
    </tbody>
</table>
</div>
</td></tr>
</table>
</form>
</body>
</html>
