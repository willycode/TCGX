<!--
程式目的：使用者登出入紀錄查詢
程式代號：SYSDS801F
程式日期：
程式作者：Apple Su
--------------------------------------------------------
修改作者                      修改日期             修改目的
--------------------------------------------------------
David Chiu    103/08/27  新增「查詢」及「取消」功能按鈕
-->

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../home/head.jsp" %>
<jsp:include page="../../home/secure.jsp">
	<jsp:param name="DTREE_PROGRAM_IDENTIFIER" value="SYSDS801" />
</jsp:include>
<jsp:useBean id="obj" scope="request" class="com.kangdainfo.common.view.sys.ds.SYSDS801F">
	<jsp:setProperty name="obj" property="*"/>
</jsp:useBean>
<jsp:useBean id="objList" scope="page" class="java.util.ArrayList"/>

<%
    if("queryAll".equals(obj.getState())){
        if("false".equals(obj.getQueryAllFlag())){
            obj.setQueryAllFlag("true");
        }
    }
    else if("queryOne".equals(obj.getState())){
    }
    else if("insert".equals(obj.getState()) || "insertError".equals(obj.getState())){
    }
    else if("update".equals(obj.getState()) || "updateError".equals(obj.getState())){
    }
    else if("delete".equals(obj.getState()) || "deleteError".equals(obj.getState())){
    }
    if("true".equals(obj.getQueryAllFlag())){
        objList = (java.util.ArrayList)obj.queryAll();
    }
%>

<html>
<head>
<%@ include file="../../home/meta.jsp" %>
<script type="text/javascript">
function checkField(){
	var alertStr="";
	//alertStr += checkEmpty(form1.auditPercentage, "查核百分比");
	alertStr += checkEmpty(form1.q_logDateS, "登入日期起");
	alertStr += checkEmpty(form1.q_logDateE, "登入日期迄");
	alertStr += checkDate(form1.q_logDateS, "登入日期起");
	alertStr += checkDate(form1.q_logDateE, "登入日期迄");
	alertStr += checkDateSE(form1.q_logDateS, form1.q_logDateE, "登入日期");
	if(alertStr.length!=0){ alert(alertStr); return false; }
	beforeSubmit();
	return true;
}

function setValue(centerId, user){
    var obj1         = user;
    var oldUserValue = user.value;
    obj1.options.length = 0;
    obj1.options.add(new Option("請選擇", ""));
    var x = getRemoteData(getVirtualPath() + "/ajax/jsonUserId.jsp?centerId=" + centerId.value, "");
    if(x != null && x.length > 0){
        var json = eval('(' + x + ')');
        var i = 0;
        for(i = 0 ; i < json.length ; i++){
            if(json[i].userId == null)
                continue;
            var astId = json[i].userId;
            var oOption = new Option(json[i].userName, astId);
            obj1.options.add(oOption);
            if(astId == oldUserValue) oOption.selected = true;
        }
    }
    form1.q_userId.disabled = false;
}

function queryOne(id){
    form1.id.value = id;
}

function init(){
	setDisplayItem('spanQueryAll,spanInsert,spanDuplicate,spanUpdate,spanDelete,spanClear,spanConfirm,spanListPrint,spanListHidden','H');
    if(form1.q_centerId.value == ''){
        form1.q_userId.disabled = true;
    }   
    
}

function doQueryAll(){
    form1.state.value = "queryAll";
    if(checkField()){
        form1.submit();
    }
}

function getJasperReportFile() {
    form1.state.value = "listPrint";
    if(checkField()){
        form1.action="sysds801p.jsp";                
        beforeSubmit();
        form1.submit(); 
        form1.action="sysds801r.jsp";                
    }
}

</script>
</head>
<body onLoad="whatButtonFireEvent('<%=obj.getState()%>');init();showErrorMsg('<%=obj.getErrorMsg()%>');">
<!-- <form id="form1" name="form1" method="post" action="sysds801p.jsp" onsubmit="return checkField();"> -->
<form id="form1" name="form1" method="post" onSubmit="return checkField()" autocomplete="off">
<table width="100%" cellspacing="0" cellpadding="0">
<!--Form區============================================================-->
<tr><td class="bg">
    <div id="formContainer" style="height:auto">
    <table class="table_form" width="100%" height="100%" border="1">
        <tr>
            <td class="td_form" colspan="2" style="text-align:center">使用者登出入紀錄查詢<font color="red">(A4 直式)</font></td>
        </tr>
        <tr>
            <td class="td_form"><font color="red">*</font>登入日期：</td>
            <td class="td_form_white">
                                         起：<%=View.getPopCalendar("field_Q", "q_logDateS", obj.getQ_logDateS()) %>
                <input class="field_Q" type="text" name="q_logTimeS" size="6" maxlength="6" value="<%= obj.getQ_logTimeS()%>" >
                  ～&nbsp;迄：<%=View.getPopCalendar("field_Q", "q_logDateE", obj.getQ_logDateE()) %>
                <input class="field_Q" type="text" name="q_logTimeE" size="6" maxlength="6" value="<%= obj.getQ_logTimeE()%>" >
            </td>
        </tr>
        <tr>
            <td class="td_form">帳號：</td>
            <td class="td_form_white">
                                                 精舍：
                <select class="field_Q" name="q_centerId" onChange="setValue(this, form1.q_userId)">
                    <%= View.getOption("Select unitId, unitShortName From CommonDepartment Order by unitId", obj.getQ_centerId(), false, 1) %>
                </select>
                                                 帳號：
                <select class="field_Q" name="q_userId">
                    <%= View.getOption("Select userId, userName From CommonUser where commonDepartment.unitId = " + Common.sqlChar(obj.getQ_centerId()), obj.getQ_userId(), false, 1) %>
                </select>
            </td>
        </tr>
        <tr>
            <td class="td_form">姓名：</td>
            <td class="td_form_white"> 
                <input class="field_Q" type="text" name="q_userName" size="12" maxlength="20" value="<%= obj.getQ_userName()%>" >
            </td>
        </tr>
        <tr>
            <td class="td_form">輸出格式：</td>
            <td class="td_form_white">
                <select name="q_outputFormat" id="q_outputFormat" class="field_Q">
                    <%=View.getJasperReportFormatOption(obj.getQ_outputFormat())%>
                    
                </select>
            </td>
        </tr>
    </table>
    </div>
</td></tr>

<!--Toolbar區============================================================-->
    <!-- 
    <tr>
        <td class="queryTDInput" colspan="2" style="text-align:center;">
            <input class="toolbar_default" type="submit" name="querySubmit" value="產生報表檔案" >
        </td>
    </tr>
    -->
<tr><td class="bgToolbar" style="text-align:center">
    <input type="hidden" name="id" value="<%=obj.getId()%>">
    <input type="hidden" name="state" value="<%=obj.getState()%>">
    <input type="hidden" name="queryAllFlag" value="<%=obj.getQueryAllFlag()%>">
    <input type="hidden" name="userID" value="<%=User.getId()%>">
    <jsp:include page="../../home/toolbar.jsp" />
    <span id="QueryAll">
        <input class="toolbar_default" type="button" followPK="false" name="queryAll" value="查　詢" onClick="doQueryAll();">&nbsp;
    </span>
    <span id="Clear">
        <input class="toolbar_default" type="reset" followPK="false" name="cancel" value="取　消" >&nbsp;
    </span>
    <span id="ListPrint">
        <input class="toolbar_default" type="button" followPK="false" name="listPrint" value="產生報表檔案" onClick="getJasperReportFile();">&nbsp;
    </span>
</td></tr>

<tr><td>
<% request.setAttribute("QueryBean",obj);%>
<jsp:include page="../../home/page.jsp" />
</td></tr>

<!--List區============================================================-->
<tr><td class="bgList">
<div id="listContainer" style="height:340px">
<table class="table_form" width="100%" cellspacing="0" cellpadding="0">
    <thead id="listTHEAD">
    <tr>
        <th class="listTH" ><a class="text_link_w" >NO.</a></th>
        <th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',1,false);" href="#">帳號</a></th>
        <th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',2,false);" href="#">登入日期</a></th>
        <th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',3,false);" href="#">登入時間</a></th>
        <th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',4,false);" href="#">IP</a></th>
        <th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',5,false);" href="#">動作</a></th>
        <th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',6,false);" href="#">狀態</a></th>
        <th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',7,false);" href="#">失敗原因</a></th>
    </tr>
    </thead> 
    <tbody id="listTBODY">
    <%
    boolean primaryArray[] = {true,false,false,false,false,false,false,false};
    boolean displayArray[] = {false,true,true,true,true,true,true,true};
    out.write(View.getQuerylist(primaryArray,displayArray,objList,obj.getQueryAllFlag()));
    %>
    </tbody>
</table>
</div>
</td></tr>
</table>
</form>
</body>
</html>
