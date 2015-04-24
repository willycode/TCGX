<!--
程式目的：精舍帳號維護作業
程式代號：sysap011f
程式日期：
程式作者：
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../home/head.jsp" %>
<jsp:include page="../../home/secure.jsp">
	<jsp:param name="DTREE_PROGRAM_IDENTIFIER" value="SYSAP001" />
</jsp:include>
<jsp:useBean id="obj" scope="request" class="com.kangdainfo.common.view.sys.ap.SYSAP011F">
	<jsp:setProperty name="obj" property="*"/>
</jsp:useBean>
<jsp:useBean id="objList" scope="page" class="java.util.ArrayList"/>

<%
if ("queryAll".equals(obj.getState())) {
	if ("false".equals(obj.getQueryAllFlag())){obj.setQueryAllFlag("true"); }
}else if ("queryOne".equals(obj.getState())) {
	obj = (com.kangdainfo.common.view.sys.ap.SYSAP011F)obj.queryOne();	
}else if ("insert".equals(obj.getState()) || "insertError".equals(obj.getState())) {
	obj.insert();
	if (!"queryAll".equals(obj.getState()) || "false".equals(obj.getQueryAllFlag())) {
	//	if (obj.getQ_deptId().equals("") || (!obj.getQ_deptId().equals(obj.getDeptId()))) {
//			obj.setQ_deptId(obj.getDeptId());
	//		obj.setQ_deptIdName(obj.checkGetReverse(obj.getDeptIdName(), false));
	//	}
		obj.setQueryAllFlag("true");
	}
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
<meta http-equiv="pragma" content="no-cache"/>
<meta http-equiv="Cache-control" content="no-cache"/>
<link rel="stylesheet" href="../../js/default.css" type="text/css"/>
<script type="text/javascript" src="../../js/validate.js"></script>
<script type="text/javascript" src="../../js/function.js"></script>
<script type="text/javascript" src="../../js/tablesoft.js"></script>
<script type="text/javascript" src="../../js/json.js"></script>
<script type="text/javascript">
var insertDefault = new Array(
	new Array("deptId", "<%=User.getCommonDepartment().getId()%>"),
	new Array("deptIdName", "<%=User.getCommonDepartment().getFullName()%>"),
	new Array("roleId", "1"),
	new Array("isMgr", "N"),
	new Array("isStop", "N"),
	new Array("userPWD","666666"),
	new Array("isMaster","false")
);

function checkField() {
	var alertStr="";
	if(form1.state.value=="queryAll"){
		alertStr += checkQuery();
	}else if(form1.state.value=="insert"||form1.state.value=="insertError"||form1.state.value=="update"||form1.state.value=="updateError"){
		alertStr += checkEmpty(form1.userId,"帳號");		
		//alertStr += checkAlphaInt(form1.userId,"帳號",0);
	//	alertStr +=checkDate(form1.userBirthday,"生日")
		alertStr +=checkEmpty(form1.userBirthday,"生日")
		alertStr += checkEmpty(form1.userName,"姓名");
		if (form1.userPWD.value!="" && form1.userPWD.value.length<6) {
			alertStr += "密碼長度至少為6碼，請重新輸入！\n";
		}
		alertStr += checkEmpty(form1.deptId,"單位");				
		alertStr += checkEmail(form1.userEmail,"Email");
		//alertStr += checkEmpty(form1.groupId,"所屬群組");		
		//alertStr += checkEmpty(form1.roleId,"使用者類別");
		//alertStr += checkEmpty(form1.isMgr,"超級使用者");			
		alertStr += checkEmpty(form1.isStop,"是否停用");	
	}
	if(alertStr.length!=0){ alert(alertStr); return false; }
	beforeSubmit();
	return true;
}

function popAuthWin() {
	var alertStr = "";
	if (form1.state.value=="insert" || form1.state.value=="insertError" || form1.state.value=="update" || form1.state.value=="updateError") {
		alert("新增或修改狀態無查詢授權資料，請先點選取消!");
	}else{
		var s = "";
		alertStr += checkEmpty(form1.id,"帳號");
		alertStr += checkEmpty(form1.userId,"帳號");	
		if(alertStr.length!=0){
			alert(alertStr);
			return;
		} else {
			var prop="";
			var windowTop=180; //(document.body.clientHeight-400)/2+180;
			var windowLeft=250; //(document.body.clientWidth-400)/2+250;
			prop=prop+"resizable=yes,width=600,height=420,";
			prop=prop+"top="+windowTop+",";
			prop=prop+"left="+windowLeft+",";
			prop=prop+"scrollbars=yes";
			window.open("sysap003r_user.jsp?userId=" + form1.id.value,"winExp",prop);			
		}
	}	

}

function popSysap001_1f(userId,userName,isMaster) {
	//法師查詢視窗
	var prop="";
	var windowTop=180; //(document.body.clientHeight-400)/2+180;
	var windowLeft=250; //(document.body.clientWidth-400)/2+250;
	prop=prop+"resizable=yes,width=600,height=420,";
	prop=prop+"top="+windowTop+",";
	prop=prop+"left="+windowLeft+",";
	prop=prop+"scrollbars=yes";
	
	window.open("sysap001_1f.jsp?popUserId=" + userId + "&popUserName=" + userName+"&isMaster="+isMaster,"winExp",prop);
}

function popSysap001_2f(userId,userName,userBirthday,userEmail,deptId,userPWD,isMaster) {
	//學員查詢視窗
	var prop="";
	var windowTop=180; //(document.body.clientHeight-400)/2+180;
	var windowLeft=250; //(document.body.clientWidth-400)/2+250;
	prop=prop+"resizable=yes,width=600,height=420,";
	prop=prop+"top="+windowTop+",";
	prop=prop+"left="+windowLeft+",";
	prop=prop+"scrollbars=yes";
	window.open("sysap001_2f.jsp?popUserId=" + userId + "&popUserName=" + userName 
			 	+ "&popUserBirthday=" + userBirthday + "&popUserEmail=" + userEmail  
			 	+ "&popDeptId=" + deptId + "&popUserPWD=" + userPWD +"&isMaster="+isMaster,"winExp",prop);
}

function queryOne(id){
	form1.id.value=id;
	form1.state.value="queryOne";
	beforeSubmit();
	form1.submit();
}

function init(){
	//setDisplayItem("spanInsert,spanDelete","H");	
}
function popSysca103f(userBirthday) {
	//各國立法彈跳視窗
	var prop="";
	var windowTop=180; //(document.body.clientHeight-400)/2+180;
	var windowLeft=250; //(document.body.clientWidth-400)/2+250;
	prop=prop+"resizable=yes,width=600,height=420,";
	prop=prop+"top="+windowTop+",";
	prop=prop+"left="+windowLeft+",";
	prop=prop+"scrollbars=yes";
	
	window.open("../ca/sysca103f.jsp?userBirthday="+userBirthday,"winExp",prop);
}
</script>
</head>

<body topmargin="0" onLoad="whatButtonFireEvent('<%=obj.getState()%>');init();showErrorMsg('<%=obj.getErrorMsg()%>');">
<fmt:bundle basename="ApplicationResources">
<form id="form1" name="form1" method="post" onSubmit="return checkField()" autocomplete="off">

<!--Query區============================================================-->
<div id="queryContainer" style="width:700px;height:300px;display:none">
	<iframe id="queryContainerFrame"></iframe>
	<div class="queryTitle">查詢視窗</div>
	<table class="queryTable"  border="1">
	<tr>
		<td class="queryTDLable"><fmt:message key="CommonUser.userId"/>：</td>
		<td class="queryTDInput">
			<input class="field_Q" type="text" name="q_userId" size="20" maxlength="20" value="<%=obj.getQ_userId()%>">
		</td>
	</tr>
	<tr>
		<td class="queryTDLable"><fmt:message key="CommonUser.userName"/>：</td>
		<td class="queryTDInput">
			<input class="field_Q" type="text" name="q_userName" size="20" maxlength="50" value="<%=obj.getQ_userName()%>">
		</td>
	</tr>
	<tr>
		<td class="queryTDLable"><fmt:message key="CommonUser.deptId"/>：</td>
		<td class="queryTDInput">
			<input class="field_QRO" type="hidden" name="q_deptId" id="q_deptId" value="<%=User.getCommonDepartment().getId()%>">
			<input class="field_QRO" type="text" name="q_deptIdName" id="q_deptIdName" size="26" maxlength="60" value="<%=User.getCommonDepartment().getFullName()%>">
		</td>
	</tr>
	<tr style="display:none">
		<td class="queryTDLable"><fmt:message key="CommonUser.groupIds"/>：</td>
		<td class="queryTDInput">
			<%=View.getCheckBoxOption("field_Q","q_groupIds","select id, groupDesc from CommonGroup where forBranch = null or forBranch ='False' order by groupName", obj.getQ_groupIds())%>
		</td>
	</tr>	
	<tr>
		<td class="queryTDLable"><fmt:message key="CommonUser.groupIds"/>(精舍)：</td>
		<td class="queryTDInput">
			<%=View.getCheckBoxOption("field_Q","q_groupIds","select id, groupDesc from CommonGroup where  forBranch ='True' order by groupName", obj.getQ_groupIds())%>
		</td>
	</tr>	
	<tr>
		<td class="queryTDLable"><fmt:message key="CommonUser.userTitle"/>：</td>
		<td class="queryTDInput">
			<%=View.getPopCode("field_Q","q_userTitle",obj.getQ_userTitle(),obj.getQ_userTitleName(),"","TIT","q_userTitleCodeId",obj.getQ_userTitleCodeId())%>
		</td>
	</tr>
	<tr>
		<td class="queryTDLable">Email：</td>
		<td class="queryTDInput">
			<input class="field_Q" type="text" name="q_userEmail" size="20" maxlength="100" value="<%=obj.getQ_userEmail()%>">
		</td>
	</tr>
	<tr>
		<td class="queryTDLable"><fmt:message key="isStop"/>：</td>
		<td class="queryTDInput">
			<select class="field_Q" type="select" name="q_isStop">
			<%=View.getYNOption(obj.getQ_isStop())%>
			</select>
		</td>
	</tr>
	<tr style="display:none">
		<td class="queryTDLable"><fmt:message key="CommonUser.isMgr"/>：</td>
		<td class="queryTDInput">			
			<select name="q_isMgr" class="field_Q">
	    		<%=View.getYNOption(obj.getQ_isMgr())%>
	    	</select>		
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
	<div id="formContainer"style="height:auto">
	<table class="table_form" width="100%" height="100%">
	<tr>
		<td class="td_form"><font color="red">*</font><fmt:message key="CommonUser.userId"/>：</td>		
		<td class="td_form_white">
		  	<input class="field_P" type="text" name="userId" size="20" maxlength="20" value="<%=obj.getUserId()%>"> 
		  	<input class="toolbar_default" type="button" value="授權資訊"  onClick="popAuthWin();">		  	
			<input class="toolbar_default" type="button" name="btnAddMaster" value="新增法師帳號" onClick="popSysap001_1f('userId','userName','isMaster');">
			<input class="toolbar_default" type="button" name="btnAddMember" value="新增學員帳號" onClick="popSysap001_2f('userId','userName','userBirthday','userEmail','deptId','userPWD','isMaster');">
		</span>
		</td>
		<td class="td_form"><fmt:message key="CommonUser.userTel"/>：</td>
		<td class="td_form_white">
			<input class="field" type="text" name="userTel" size="20" maxlength="20" value="<%=obj.getUserTel()%>">
		</td>
	</tr>
	<tr>
	  	<td class="td_form"><font color="red">*</font><fmt:message key="CommonUser.userName"/>：</td>
	  	<td class="td_form_white">
	    	<input class="field_P" type="text" name="userName" size="20" maxlength="50" value="<%=obj.getUserName()%>">
	    	身分別：&nbsp;<%=View.getRadioBoxTextOption("field","isMaster","true;法師;false;學員",obj.getIsMaster())%>
	  	</td>
	  	<td class="td_form"><fmt:message key="CommonUser.userMobile"/>：</td>
	  	<td class="td_form_white">
	  		<input class="field" type="text" name="userMobile" size="20" maxlength="20" value="<%=obj.getUserMobile()%>">
	  	</td>
	</tr>
	<tr>
	  	<td class="td_form"><font color="red">*</font><fmt:message key="CommonUser.userPWD"/>：</td>
	  	<td class="td_form_white">
	  		<input class="field" type="password" name="userPWD" size="20" maxlength="50" value="<%=obj.getUserPWD()%>">
	  	</td>
	  	<td class="td_form"><font color="red">*</font><fmt:message key="CommonUser.userBirthday"/>：</td>
	  	<td class="td_form_white">
	  		<%= View.getPopCalendar("field","userBirthday",obj.getUserBirthday()) %> &nbsp;&nbsp;&nbsp; 格式:1030131
	  	</td>
	</tr>
	
	<tr>
	  	<td class="td_form"><font color="red">*</font><fmt:message key="CommonUser.deptId"/>：</td>
	  	<td colspan="3" class="td_form_white">	  	  
	    	<%=View.getPopOrgan("field_RO","deptId",obj.getDeptId(),obj.getDeptIdName(),"N","accountingYear","manageDept")%>		
	  	</td>
	</tr>
	<tr style="display:none">
		
	  	<td class="td_form"><fmt:message key="CommonUser.groupIds"/>：</td>
	  	<td colspan="3" class="td_form_white">
	  		<%=View.getCheckBoxOption("field","groupIds","select id, groupDesc from CommonGroup where forBranch = null or forBranch ='False' order by groupName", obj.getGroupIds())%>
	  	</td>
	  	
	</tr>
	<tr>
	  	<td class="td_form"><fmt:message key="CommonUser.groupIds"/>(精舍)：</td>
	  	<td colspan="3" class="td_form_white">
	  		<%=View.getCheckBoxOption("field","groupIds","select id, groupDesc from CommonGroup where  forBranch ='True' order by groupName", obj.getGroupIds())%>
	  	</td>
	</tr>
	
	
	<tbody id="formIsMgr" style="display:none">
	<tr>
	  	<td class="td_form"><font color="red">*</font></font><fmt:message key="CommonUser.isMgr"/>：</td>
	  	<td class="td_form_white">
	  		<select name="isMgr" class="<%=UserRole.getCssClass("field")%>">
	    		<%=View.getYNOption(obj.getIsMgr())%>
	    	</select>
	    </td>
	    </tr>
	    </tbody>
	  
 <tr>
	  	<td class="td_form">Email：</td>
	  	<td class="td_form_white" colspan="3">
	  		<input class="field" type="text" name="userEmail" size="30" maxlength="100" value="<%=obj.getUserEmail()%>">
	  	</td>
	</tr>
	<tr>
	  	<td class="td_form"><fmt:message key="CommonUser.userTitle"/>：</td>
	  	<td class="td_form_white"><%=View.getPopCode("field","userTitle",obj.getUserTitle(),obj.getUserTitleName(),"","TIT","userTitleCodeId",obj.getUserTitleCodeId())%></td>
	  	<td class="td_form"><font color="red">*</font><fmt:message key="isStop"/>：</td>
	  	<td class="td_form_white">
	  		<select class="field" name="isStop">
	    		<%=View.getYNOption(obj.getIsStop())%>
	    	</select>
	   	</td>
	</tr>
	<tr>
		<td class="td_form"><fmt:message key="updateInformation"/>：</td>
		<td class="td_form_white" colspan="3">
			<% request.setAttribute("objBean",obj); %>
			<c:import url="/home/editUser.jsp" />
		</td>
	</tr>
	</table>
	</div>
</td></tr>

<!--Toolbar區============================================================-->
<tr><td class="bgToolbar" style="text-align:center">
	<input type="hidden" name="id" value="<%=obj.getId()%>">
	<input type="hidden" name="state" value="<%=obj.getState()%>">
	<input type="hidden" name="queryAllFlag" value="<%=obj.getQueryAllFlag()%>">
	<jsp:include page="../../home/toolbar.jsp" />
</td></tr>

<tr><td>
<% request.setAttribute("QueryBean",obj);%>
<jsp:include page="../../home/page.jsp" />
</td></tr>
<!--List區============================================================-->
<tr><td class="bgList">
<div id="listContainer">
<table class="table_form" width="100%" cellspacing="0" cellpadding="0">
	<thead id="listTHEAD">
	<tr>
		<th class="listTH" ><a class="text_link_w" >NO.</a></th>
		<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',1,false);" href="#">帳號</a></th>
		<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',2,false);" href="#">姓名</a></th>
		<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',3,false);" href="#">角色</a></th>
		<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',4,false);" href="#">單位</a></th>
		<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',5,false);" href="#">電話</a></th>
		<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',6,false);" href="#">超級使用者</a></th>
	</tr>
	</thead> 
	<tbody id="listTBODY">
	<%
	boolean primaryArray[] = {true,false,false,false,false,false,false};
	boolean displayArray[] = {false,true,true,true,true,true,true};
	out.write(View.getQuerylist(primaryArray,displayArray,objList,obj.getQueryAllFlag()));
	%>
	</tbody>
</table>
</div>
</td></tr>
</table>
</form>
<script language="javascript">
localButtonFireListener.whatButtonFireEvent = function(buttonName){
	switch(buttonName){
		case "insert":
			document.all.item("btnAddMaster").disabled = false;
			document.all.item("btnAddMember").disabled = false;
			break;
		default:
			document.all.item("btnAddMaster").disabled = true;
			document.all.item("btnAddMember").disabled = true;
			break;
	}
}
</script>
</fmt:bundle> 
</body>
</html>

