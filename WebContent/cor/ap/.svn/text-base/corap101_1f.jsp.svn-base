<!--
程式目的：查詢精舍學員資料
程式代號：corap101_1f
程式日期：103.09.04
程式作者：David Chiu
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../home/head.jsp" %>
<jsp:useBean id="obj" scope="request" class="com.kangdainfo.ctis.view.cor.ap.CORAP006F">
    <jsp:setProperty name="obj" property="*"/>
</jsp:useBean>
<jsp:useBean id="objList" scope="page" class="java.util.ArrayList"/>
<%
String unitId            = request.getParameter("unitId");
String popCenterMemberId = request.getParameter("popCenterMemberId");

if ("queryAll".equals(obj.getState())) {
    if ("false".equals(obj.getQueryAllFlag())){
        obj.setQueryAllFlag("true");
    }
}

if ("true".equals(obj.getQueryAllFlag())){
    objList = (java.util.ArrayList) obj.doQueryAll_corap101_1f(unitId);
}

%>
<html>
<head>
<title>精舍學員查詢輔助視窗</title>
<%@ include file = "../../home/meta.jsp" %>
<script type="text/javascript">
function checkField() {
    form1.state.value = "queryAll";
    beforeSubmit();
    return true;
}

function queryOne(centerMemberId) {
    if (isObj(opener.document.all.item("<%=popCenterMemberId%>"))) {
        for (var i = 0 ; i < opener.document.all.item("<%=popCenterMemberId%>").options.length ; i++) {
            if (centerMemberId == opener.document.all.item("<%=popCenterMemberId%>").options[i].value) {
                opener.document.all.item("<%=popCenterMemberId%>").options[i].selected = true;
                break;
            }
        }
    }
    window.close();
}

function init(){}
</script>
</head>
<body onload="init();">
<form id="form1" name="form1" method="post" onSubmit="return checkField()">
<table width="100%" cellspacing="0" cellpadding="0">
<!--Form區============================================================-->
<tr><td class="bg" >
    <div id="formContainer" style="height:auto">
    <table class="table_form" width="100%" height="100%">
    <tr>
        <td class="td_form">精舍學員代號：</td>
        <td class="td_form_white">
            <input class="field_Q" type="text" name="q_centerMemberId" size="20" maxlength="11" value="<%=obj.getQ_centerMemberId()%>">
        </td>
    </tr>
    <tr>
        <td class="td_form">精舍學員化名：</td>
        <td class="td_form_white">
            <input class="field_Q" type="text" name="q_aliasName"      size="70" maxlength="60" value="<%=obj.getQ_aliasName()%>">
        </td>
    </tr>
    </table>
    </div>
</td></tr>

<!--Toolbar區============================================================-->
<tr>
    <td class="bg" style="text-align:center">
        <input class="toolbar_default" type="submit" name="querySubmit" value="查    詢" >
        <input class="toolbar_default" type="button" name="queryCannel" value="取    消" onClick="window.close()">
        <input type="hidden" name="state" value="<%=obj.getState()%>">
    </td>
</tr>

<tr><td>
<% request.setAttribute("QueryBean", obj);%>
<jsp:include page="../../home/page.jsp" />
</td></tr>

<!--List區============================================================-->
<tr>
    <td class="bgList" >
        <div id="listContainer" style="height:auto">
            <table class="table_form" width="100%" cellspacing="0" cellpadding="0">
                <thead id="listTHEAD">
                <tr>
                    <th class="listTH"><a class="text_link_w" >序號</a></th>
                    <th class="listTH"><a class="text_link_w" onclick="return sortTable('listTBODY', 1, false);" href="#">精舍學員代號</a></th>
                    <th class="listTH"><a class="text_link_w" onclick="return sortTable('listTBODY', 2, false);" href="#">精舍學員化名</a></th>
                </tr>
                </thead>
                <tbody id="listTBODY">
                <%
                    boolean primaryArray[] = {false, true, false};
                    boolean displayArray[] = {false, true, true};
                    String[] alignArray = {"center", "center", "center"};
                    out.write(View.getQuerylist(primaryArray, displayArray, alignArray, objList, obj.getQueryAllFlag()));
                %>
                </tbody>
            </table>
        </div>
    </td>
</tr>
</table>
</form>
</body>
</html>
