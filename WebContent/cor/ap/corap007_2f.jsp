<!--
程式目的：查詢精舍學員
程式代號：corap007_2f
程式日期：
程式作者：
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../home/head.jsp" %>
<jsp:useBean id="obj" scope="request" class="com.kangdainfo.ctis.view.cor.ap.CORAP007_2F">
    <jsp:setProperty name="obj" property="*"/>
</jsp:useBean>
<jsp:useBean id="objList" scope="page" class="java.util.ArrayList"/>
<%
String unitId            = request.getParameter("unitId");			 //unitId=B000
String popUnitShortName  = request.getParameter("popUnitShortName"); //popUnitShortName=中台

if ("queryAll".equals(obj.getState())) {
    if ("false".equals(obj.getQueryAllFlag())){
        obj.setQueryAllFlag("true");
    }
}

if ("true".equals(obj.getQueryAllFlag())){
    objList = (java.util.ArrayList) obj.doQueryAll_corap007_2f(unitId);
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
        <td class="td_form">精舍：</td>
        <td class="td_form_white">
            <input class="field_Q" type="text" name="q_centerMemberId" size="10" maxlength="10" value="中台">
        </td>
    </tr>
    <tr>
        <td class="td_form">學員：</td>
        <td class="td_form_white">
            <input class="field_Q" type="text" name="q_aliasName" size="10" maxlength="10" value="<%=obj.getQ_aliasName()%>">
            <select class="field" name="aliasName">
            	<%= View.getOption("Select unitId, aliasName From CenterMemberInfo Where unitId = 'B000' Order by centerMemberId", obj.getAliasName(), false, 1) %>
        	</select>
        </td>
    </tr>
    <tr>
        <td class="td_form" >姓名：</td>
        <td class="td_form_white" width="5%">
        	<!-- 修改 -->
            <input class="field_Q" type="text" name="q_Name" size="10" maxlength="10" value="">
        </td>
        <td class="td_form">法名：</td>
        <td class="td_form_white">
        	<!-- 修改 -->
            <input class="field_Q" type="text" name="q_aliasName" size="10" maxlength="10" value="">
        </td>
    </tr>
    <tr>
        <td class="td_form">Email：</td>
        <td class="td_form_white">
        	<!-- 修改 -->
            <input class="field_Q" type="text" name="q_email" size="25" maxlength="25" value="">
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
                    <th class="listTH"><a class="text_link_w" onclick="return sortTable('listTBODY', 1, false);" href="#">精舍</a></th>
                    <th class="listTH"><a class="text_link_w" onclick="return sortTable('listTBODY', 2, false);" href="#">精舍學員編號</a></th>
                    <th class="listTH"><a class="text_link_w" onclick="return sortTable('listTBODY', 3, false);" href="#">學員</a></th>
                </tr>
                </thead>
                <tbody id="listTBODY">
                <%
                    boolean primaryArray[] = {false, true, false, false};
                    boolean displayArray[] = {false, true, true, true};
                    String[] alignArray = {"center", "center", "center", "center"};
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
