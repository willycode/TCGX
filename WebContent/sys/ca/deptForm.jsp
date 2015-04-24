<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../home/head.jsp" %>
<jsp:include page="../../home/secure.jsp">
	<jsp:param name="DTREE_PROGRAM_IDENTIFIER" value="SYSCA002F" />
</jsp:include>
<jsp:useBean id="obj" scope="request" class="com.kangdainfo.common.view.sys.ca.SYSCA002F">
	<jsp:setProperty name="obj" property="*"/>
</jsp:useBean>
<%
obj.setUnitStatus("0");
String btnSave = request.getParameter("btnSave");
String exeKind = Common.checkGet(request.getParameter("exeKind"));
String sid = Common.get(request.getParameter("sid"));
String fid = Common.get(request.getParameter("fid"));
String nodeId = Common.get(request.getParameter("nodeId"));
String js = "";
if (!"".equals(Common.get(btnSave))) {
	if ("insert".equals(obj.getState()) || "insertError".equals(obj.getState())) {
		obj.insert();
	}else if ("update".equals(obj.getState()) || "updateError".equals(obj.getState())) {
		obj.update();
	}else if ("delete".equals(obj.getState()) || "deleteError".equals(obj.getState())) {
		obj.delete();
	}
} else {
	obj.setId(sid);
	obj.setPid(fid);
	obj.setState(exeKind);
	
	if ("insert".equals(exeKind)) {
		obj.setPid(sid);
		if (sid.equals("-97")) obj.setPname("機關單位");
		else {	
			obj = (com.kangdainfo.common.view.sys.ca.SYSCA002F) obj.getParentInfo(sid);
		}
		obj.setId("");
	} else if ("update".equals(exeKind)) {		
		obj = (com.kangdainfo.common.view.sys.ca.SYSCA002F) obj.queryOne();
		obj.setState("update");
	} else if ("delete".equals(exeKind)) {
		obj.delete();
		obj.setErrorMsg("");
	} else {
		if (sid.indexOf('-')!=-1) {
			out.write(Common.MSG_DTREE_LEVEL_LIMIT_FOR_EDIT);
			return ;
		}
		obj = (com.kangdainfo.common.view.sys.ca.SYSCA002F) obj.queryOne();		
		obj.setState("update");		
	}
}
%>
<html>

<head>
<title>dTree</title>
<meta http-equiv="Expires" content="-1"/>
<meta http-equiv="pragma" content="no-cache"/>
<meta http-equiv="Cache-control" content="no-cache"/>
<link rel="stylesheet" href="../../js/default.css?1=ss" type="text/css">
<script language="javascript" src="../../js/validate.js"></script>
<script language="javascript" src="../../js/function.js"></script>
<script language="javascript" src="../../js/toolbar_mini.js"></script>
<script language="javascript" src="../../js/ZhNumUtil.js"></script>
<script language="javascript">
	var popWin;
	var popWinFlag=false;
	var insertDefault;	//二維陣列, 新增時, 設定預設值
	insertDefault = new Array(
		new Array("unitStatus","1")
	);
	function checkField(){
		//whatButtonFireEvent("update");
		var alertStr="";
		
		alertStr += checkEmpty(form1.pid,"上層單位");
		alertStr += checkEmpty(form1.unitCode,"單位代碼");
		alertStr += checkEmpty(form1.unitType,"單位類別");
		alertStr += checkEmpty(form1.unitShortName,"單位簡稱");
		alertStr += checkEmpty(form1.unitFullName,"單位全名");
		if(alertStr.length!=0){ alert(alertStr); return false; }
		else return checkSpecialChar(form1);		
	}
	
	function popNodeSelectForm() { 	
		popWin = window.open("deptNodeSelect.jsp?popId=pid&popName=pname",'deptNodeSelect','scrollbars=1, resizable=yes, status=yes, toolbar=no,menubar=no,width=350,height=200');
	}
		
	function popWinClose() {
		popWin.close();
	}
	
	function init() {
		
		var s = "<%=obj.getState()%>";
		switch (s) {
			case "deleteSuccess" :
				if (isObj(opener)) {
					opener.reloadTree('<%=obj.getPid()%>','刪除完成');
					opener.reloadForm();
				}
				break;
			case "insertSuccess":
			case "updateSuccess":
			case "update" :
				form1.state.value = "update";
				setFormItem("btnSelectPid","R");
				setUnpkOpen();
				if (s=="insertSuccess" || s=="updateSuccess") 
					window.parent.frames['dTreeManage'].location.href = "deptManage.jsp?openNodeID=<%=obj.getPid()%>";
				break;
		}
		if ("<%=exeKind%>"=="insert") form1.unitId.focus();				
		
		changeDeptCodeLength();
		
		if (form1.parentLevel.value=="4") {
			alert("<%=Common.MSG_DTREE_LEVEL_LIMIT_FOR_ADD%>");
			setAllReadonly();
		}
		
		if(form1.state.value="insert"){
		
		if (isObj(form1.createId)) form1.createId.value = "<%=User.getUserId()%>";
		if (isObj(form1.createDate)) form1.createDate.value = getToday();
		if (isObj(form1.createTime)) form1.createTime.value = getNow();
		if (isObj(form1.updateId)) form1.updateId.value = "<%=User.getUserId()%>";
		if (isObj(form1.updateDate)) form1.updateDate.value = getToday();
		if (isObj(form1.updateTime)) form1.updateTime.value = getNow();
		if (isObj(form1.updateIp)) form1.updateIp.value = "<%= request.getRemoteAddr()%>";
		if (isObj(form1.updateUnitShortName)) form1.updateUnitShortName.value = "<%= Dept.getUnitShortName()%>";
		}else{
		if (isObj(form1.updateId)) form1.updateId.value = "<%=User.getUserId()%>";
		if (isObj(form1.updateDate)) form1.updateDate.value = getToday();
		if (isObj(form1.updateTime)) form1.updateTime.value = getNow();
		if (isObj(form1.updateIp)) form1.updateIp.value = "<%= request.getRemoteAddr()%>";
		if (isObj(form1.updateUnitShortName)) form1.updateUnitShortName.value = "<%= Dept.getUnitShortName()%>";
		}
		
	}
/*		
	function genFullCodeFullName() {
		if (form1.departmentCode.value!="") form1.departmentCode.value = lpad(form1.departmentCode.value,getDeptCodeLenFromParent(form1.parentLevel.value),'0');
		form1.fullCode.value = getDeptFullCode(form1.parentFullCode.value,form1.parentLevel.value,form1.departmentCode.value);
		form1.shortCode.value = getDeptShortCode(form1.parentFullCode.value,form1.parentLevel.value,form1.departmentCode.value);
		if (form1.parentFullName.value!="") {
			form1.fullName.value = form1.parentFullName.value + "-" + form1.department.value;		
		} else form1.fullName.value = form1.department.value;
	}
*/		
	function getNodeName(nId) {
		var x = getRemoteData("deptGetNode.jsp",nId);
		form1.pname.value=x;	
	}
	
	function changeDeptCodeLength() {
		var level = form1.parentLevel.value;
		var obj = form1.unitId;
		try {
			switch(level) {
				case "0": setLength(obj,4); break;
				case "1": setLength(obj,4); break;
				case "2": setLength(obj,4); break;
				default : setLength(obj,4); break;
			}
		} catch(e) {alert(e);}	
		/**		
		var level = form1.parentLevel.value;
		var obj = form1.departmentCode;
		try {
			switch(level) {
				case "0": setLength(obj,3); break;
				case "1": setLength(obj,4); break;
				case "2": setLength(obj,4); break;
				default : setLength(obj,2); break;
			}
		} catch(e) {alert(e)}
		**/		
	}	

	function checkLength(object,leng){
		if(object!=null && leng!=null && object.value.length>leng){
			alert("單元簡介字數超過"+leng+",請修正!!");
			if(object.value.length>0)
				object.focus();
			return false;
		}
		return true;
	}
	function popSysap001_1f(userId,userName) {
		//法師查詢視窗
		var prop="";
		var windowTop=180; //(document.body.clientHeight-400)/2+180;
		var windowLeft=250; //(document.body.clientWidth-400)/2+250;
		prop=prop+"resizable=yes,width=600,height=420,";
		prop=prop+"top="+windowTop+",";
		prop=prop+"left="+windowLeft+",";
		prop=prop+"scrollbars=yes";
		
		window.open("../ap/sysap001_1f.jsp?popUserId=" + userId + "&popUserName=" + userName,"winExp",prop);
	}
	function setUnitId(unitId) {
		unitId.value=form1.unitType.value+form1.unitCode.value;
			
	
	}
</script>
</head>

<body topmargin="0" onLoad="init();showErrorMsg('<%=obj.getErrorMsg()%>');">
<form id="form1" name="form1" method="post" onSubmit="return checkField()" autocomplete="off" >
<table width="100%" cellspacing="0" cellpadding="0">
<tr>
 	<td class="td_lable">
		機關代碼維護作業
	</td>
</tr>
<tr><td class="bg">
	<table class="table_form" width="100%" height="100%">
	<tr>
		<td class="td_form"><font color="red">*</font>上層單位：</td>
		<td class="td_form_white" colspan="3">
			<input name="pid" type="hidden" class="field_EP" id="pid" value="<%=obj.getPid()%>" autocomplete="off" onChange="getNodeName(this.value);" size="10" />
	 		<input name="pname" id="pname" type="text" class="field_RO" value="<%=obj.getPname()%>" />
	  		<input name="btnSelectPid" type="button" id="btnSelectPid" value="..." class="toolbar_default" onClick="popNodeSelectForm();" />	
	  	</td>
	</tr>
	<tr>
	  	<td class="td_form"><font color="red">*</font>單位代碼：</td>
	  	<td class="td_form_white">
	  	
	  	 <select class="field"  name="unitType" onChange="setUnitId(unitId);">
				<%=View.getOption("select codeId, codeName from CommonCode where commonCodeKind.codeKindId='UNITTYPE' order by codeId", obj.getUnitType())%>
			</select>
			<input class="field" type="text" onChange="setUnitId(unitId);" name="unitCode" size="3" maxlength="3" value="<%=obj.getUnitCode()%>" />
		<input class="field_RO" type="text" name="unitId" size="5" maxlength="4" value="<%=obj.getUnitId()%>" />		
		</td>		
	  	<td class="td_form">基金會使用代碼：</td>
	  	<td class="td_form_white">
			<input class="field" type="text" name="fundUnitId" size="5" maxlength="4" value="<%=obj.getFundUnitId()%>" />		
		</td>		
	</tr>
	<tr>
		<td class="td_form"><font color="red">*</font>單位簡稱：</td>
		<td class="td_form_white">
			<input class="field" type="text" name="unitShortName" size="15" maxlength="10" value="<%=obj.getUnitShortName()%>" />
	
		</td>	
	    <td class="td_form"><font color="red">*</font>單位全名：</td>
	    <td class="td_form_white">
			<input class="field" type="text" name="unitFullName" size="40" maxlength="50" value="<%=obj.getUnitFullName()%>" />		
		</td>
	</tr>	
	<tr>
		<td class="td_form">單位住持名稱：</td>
		<td class="td_form_white" colspan="3">
			<input class="field" type="hidden" name="unitManagerId" size="15" maxlength="10" value="<%=obj.getUnitManagerId()%>" />
			<input class="field" type="text" name="unitManagerName" size="10" maxlength="10" value="<%=obj.getUnitManagerName()%>" />
			<input class="toolbar_default" type="button" name="btnAddMaster" value="新增法師帳號" onClick="popSysap001_1f('unitManagerId','unitManagerName');">		
		</td>
		
	</tr>
	<tr>
		<td class="td_form">單位電話：</td>
		<td class="td_form_white">
			<input class="field" type="text" name="unitPhoneNum" size="20" maxlength="20" value="<%=obj.getUnitPhoneNum()%>" />
		</td>
		<td class="td_form">單位行動電話：</td>
		<td class="td_form_white">
			<input class="field" type="text" name="unitMobileNum" size="20" maxlength="20" value="<%=obj.getUnitMobileNum()%>" />		
		</td>
	</tr>
	<tr>
		<td class="td_form">單位傳真：</td>
		<td class="td_form_white">
			<input class="field" type="text" name="unitFaxNum" size="20" maxlength="20" value="<%=obj.getUnitFaxNum()%>" />
		</td>
		<td class="td_form">單位Email：</td>
		<td class="td_form_white">
			<input class="field" type="text" name="unitEmail" size="20" maxlength="20" value="<%=obj.getUnitEmail()%>" />		
		</td>
	</tr>
	<tr>
		<td class="td_form">單位所在區域：</td>
		<td class="td_form_white">
			<input class="field" type="text" name="unitZoneId" size="6" maxlength="5" value="<%=obj.getUnitZoneId()%>" />
		</td>
		<td class="td_form">區域名稱：</td>
		<td class="td_form_white">
			<input class="field" type="text" name="unitZoneName" size="20" maxlength="20" value="<%=obj.getUnitZoneName()%>" />		
		</td>
	</tr>
	<tr>
		<td class="td_form">單位地址：</td>
		<td class="td_form_white" colspan="3">
			<input class="field" type="text" name="unitZip" size="6" maxlength="5" value="<%=obj.getUnitZip()%>" />
			<input class="field" type="text" name="unitMailingAddress" size="70" maxlength="140" value="<%=obj.getUnitMailingAddress()%>" />		
		</td>
		
	</tr>
	<tr>
	  	<td class="td_form">單位的網段起訖：</td>
	  	<td class="td_form_white" colspan="3">
			起:<input class="field" type="text" name="unitStartIp" size="20" maxlength="16" value="<%=obj.getUnitStartIp()%>" />
			訖:<input class="field" type="text" name="unitEndIp" size="20" maxlength="16" value="<%=obj.getUnitEndIp()%>" />			
		</td>
	  
	</tr>
	<tr>
	  	<td class="td_form">單位所在地語言代碼：</td>
	  	<td class="td_form_white">
			<input class="field" type="text" name="unitLanguageId" size="10" maxlength="10" value="<%=obj.getUnitLanguageId()%>" />		
		</td>
	  	<td class="td_form">單位所在區域：</td>
	  	<td class="td_form_white">
	  		<input class="field" type="text" name="unitCountryId" size="5" maxlength="2" value="<%=obj.getUnitCountryId() %>">
	  	</td>
	</tr>
	<tr>
	  	<td class="td_form">單位說明：</td>
	  	<td class="td_form_white">
			<input class="field" type="text" name="unitNote" size="40" maxlength="500" value="<%=obj.getUnitNote()%>" />		
		</td>
	  	<td class="td_form">單位狀態：</td>
	  	<td class="td_form_white">
			 <%=View.getRadioBoxOption("field","unitStatus","select codeId, codeName from CommonCode where commonCodeKind.codeKindId='CNT' order by codeId",obj.getUnitStatus())%>

	  	</td>	  	
	</tr>
	<tr>
		<td class="td_form">更新資訊：</td>
		<td class="td_form_white" colspan = "3">
			<% request.setAttribute("objBean",obj); %>
			<c:import url="/home/editUser.jsp" />
		</td>
	</tr>
	</table>
	</td>
</tr>
<!--Toolbar區============================================================-->
<tr><td class="bg" style="text-align:center">
	<input type="hidden" name="state" value="<%=obj.getState()%>">
	<input type="hidden" name="oldid" value="<%=obj.getOldid()%>">
	<input type="hidden" name="id" value="<%=obj.getId()%>">
	<input type="hidden" name="level" value="<%=obj.getLevel()%>">
	<input type="hidden" name="oldParentId" value="<%=obj.getOldParentId()%>">
	<input type="hidden" name="parentLevel" value="<%=obj.getParentLevel()%>">
	<input type="hidden" name="parentFullCode" value="<%=obj.getParentFullCode()%>">
	<input type="hidden" name="parentFullName" value="<%=obj.getParentFullName()%>">	
<span id="spanToolbar">&nbsp;|
<span id="spanInsert">
<input class="toolbar_default" type="submit" name="btnSave"  value="存　檔">&nbsp;|
</span>
</span>	
</td></tr>
</table>
</form>
</body>

</html>
