<!--
程式目的：學員資料維護-本山
程式代號：corap006f
程式日期：1030901
程式作者：jason.kuo
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page contentType = "text/html;charset=UTF-8" %>
<%@ include file = "../../home/head.jsp" %>
<jsp:include page="../../home/secure.jsp">
	<jsp:param name="DTREE_PROGRAM_IDENTIFIER" value="CORAP006F" />
</jsp:include>
<jsp:useBean id = "obj" scope="request" class="com.kangdainfo.ctis.view.cor.ap.CORAP006F">
	<jsp:setProperty name="obj" property="*"/>
</jsp:useBean>
<jsp:useBean id="objList" scope="page" class="java.util.ArrayList"/>
<%		
	if ("queryAll".equals(obj.getState())) {
		if ("false".equals(obj.getQueryAllFlag())){
			obj.setQueryAllFlag("true"); 
		}
	}
	else if ("queryOne".equals(obj.getState())) {
		obj = (com.kangdainfo.ctis.view.cor.ap.CORAP006F)obj.queryOne();
	}
	else if ("insert".equals(obj.getState()) || "insertError".equals(obj.getState())) {
		obj.insert();
		obj.setQueryAllFlag("true");
	}
	else if ("update".equals(obj.getState()) || "updateError".equals(obj.getState())) {
		obj.update();
	}
	else if ("delete".equals(obj.getState()) || "deleteError".equals(obj.getState())) {
		obj.delete();
	}
	
	if ("true".equals(obj.getQueryAllFlag())){
		objList = (java.util.ArrayList) obj.queryAll();
	}
%>
<html>
<head>
<%@ include file = "../../home/meta.jsp" %>
<script type="text/javascript">
var insertDefault;

var insertDefault = new Array(
	new Array('mcRadio','1'),
	Array('pcRadio','1'),
	Array('onBlackList','false'),
	Array('onNostayList','false'),
	Array('okSendEmail','false'),
	Array('okSendMagazine','false'),
	Array('okSendEletter','false'),
	Array('okSendMessage','false'),
	Array('takeRefuge','false'),
	Array('takePrecept5','false'),
	Array('takeBodhiPrecept','false'),
	Array('after2012Oct','true'),
	Array('isPiSigned','false')
);

function checkYYYYMMDD(errorColumn, displayColumn, name){
	columnTrim( errorColumn );
    var tDate = errorColumn.value;
  //判斷是否為正確的日期格式
    if ((tDate.length != 8)){
    	displayColumn.style.backgroundColor=errorbg;
        return name + "格式有誤，請重新輸入\n";
    }else{
        var y=Number(tDate.substring(0,4));
        var m=Number(tDate.substring(4,6)) -1;
        var d=Number(tDate.substring(6,8));
        var d1 = new Date(y,m,d);
        var d2 = new Date(d1.valueOf());
        
        if((d1.getMonth() != m) || (d1.getDate() != d)){
        	displayColumn.style.backgroundColor=errorbg;
        	return name + "格式有誤，請重新輸入\n";
        }
    }
    displayColumn.style.backgroundColor="";
    return "";
}

function checkField(){
	var alertStr = "";

	if(form1.state.value == "insert" || form1.state.value == "update"){
		//---- page 1 ----
		alertStr += checkEmpty(form1.lastName,'姓');
		alertStr += checkEmpty(form1.firstName,'名');
		if(form1.birthDisplay.value != ""){alertStr += checkYYYYMMDD(form1.birthDate, form1.birthDisplay, "出生年月日")}
		if(form1.twIdNum.value != ""){alertStr += checkPersonalID(form1.twIdNum,'身分證');}

		//---- page 2 ----
		if(form1.email1.value != ""){alertStr += checkEmail(form1.email1,'Email');}
		if(form1.email2.value != ""){alertStr += checkEmail(form1.email2,'Email');}

		//---- page 3 ----
		if(form1.weight.value != ""){alertStr += checkNumber(form1.weight,'體重');}
		if(form1.height.value != ""){alertStr += checkNumber(form1.height,'身高');}
	}
	
	if(alertStr.length != 0){
		alert(alertStr);
		return false;
	}
	
	//beforeSubmit();
	//return true;
}

function queryOne(id){
	form1.id.value = id;
	form1.state.value ="queryOne";
	beforeSubmit();
	form1.submit();
}

function init(){}

function showMultiField(fieldArea,btnName){
	if(document.all[fieldArea].style.display == ""){
		document.all[fieldArea].style.display ="none";
		document.all[btnName].value ="+";
	}
	else{
		document.all[fieldArea].style.display ="";
		document.all[btnName].value ="-";
	}	
}

function changeTab(tabId){	

	if(isObj(document.all.item("t1"))){
		document.getElementById("t1").className = "tab_border2";
		document.getElementById("aTab1").className = "";
		document.getElementById("Tab1").style.display = "none";
	}
	
	if(isObj(document.all.item("t2"))){
		document.getElementById("t2").className = "tab_border2";
		document.getElementById("aTab2").className = "";
		document.getElementById("Tab2").style.display = "none";
	}

	if(isObj(document.all.item("t3"))){
		document.getElementById("t3").className = "tab_border2";
		document.getElementById("aTab3").className = "";
		document.getElementById("Tab3").style.display = "none";
	}

	if(tabId == 2){
		document.getElementById("t2").className = "tab_border1";
		document.getElementById("aTab2").className = "text_w";
		document.getElementById("Tab2").style.display = "";
	}
	else if(tabId == 3){
		document.getElementById("t3").className = "tab_border1";
		document.getElementById("aTab3").className = "text_w";
		document.getElementById("Tab3").style.display = "";
	}
	else{
		document.getElementById("t1").className = "tab_border1";
		document.getElementById("aTab1").className = "text_w";
		document.getElementById("Tab1").style.display = "";
	}
}

function popCorap006f_1f(zipcode,address,state,city) {
	//地址查詢視窗
	var prop="";
	var windowTop=180; //(document.body.clientHeight-400)/2+180;
	var windowLeft=250; //(document.body.clientWidth-400)/2+250;
	prop=prop+"resizable=yes,width=600,height=420,";
	prop=prop+"top="+windowTop+",";
	prop=prop+"left="+windowLeft+",";
	prop=prop+"scrollbars=yes";
	
	window.open("corap006_1f.jsp?popZipCode=" + zipcode + "&popAddress=" + address 
								+ "&popState=" + state + "&popCity=" + city,"winExp",prop);
}

function getCommonZipDb(q,state,city){
	if(q != null & q.length > 0){
		var hql = "select zipCode,cityName from CommonZip where zipCode = '" + q + "' group by zipCode,cityName order by zipCode";

		var x = getRemoteData(getVirtualPath() + "/ajax/jsonObjects.jsp", hql);
		
		if(x != null && x.length > 0){
			var json = JSON.parse(x);			
			document.getElementById(state).value = json.obj1.substr(0,3);
			document.getElementById(city).value = json.obj1.substr(3);
		}
		else{
			alert("查無此郵遞區號，請輸入5碼郵遞區號！");
			document.getElementById(state).value = "";
			document.getElementById(city).value = "";			
		}
	}
}

function changRadioState(comboName,inputName,value)
{
	if(value==2){	
	   document.all.item(comboName).disabled = true ;
	   document.getElementById(comboName).value = "";
	   document.all.item(inputName).disabled = false ;
	}
	else{
	   document.all.item(inputName).disabled = true ;
	   document.getElementById(inputName).value = "";
	   document.all.item(comboName).disabled = false ;
	}
}

function changeOtherFieldState(checkBox,fieldName){
	if(document.getElementById(checkBox).checked){
		document.getElementById(fieldName).disabled = false;
	}
	else{
		document.getElementById(fieldName).disabled = true;
		document.getElementById(fieldName).value = "";
	}
}

function popSysca103f() {
	//各國立法彈跳視窗
	var prop="";
	var windowTop=180; //(document.body.clientHeight-400)/2+180;
	var windowLeft=350; //(document.body.clientWidth-400)/2+250;
	prop=prop+"resizable=yes;dialogWidth=600px;dialogHeight=300px;";
	prop=prop+"dialogTop="+windowTop+";";
	prop=prop+"dialogLeft="+windowLeft+";";
	
	var ret = window.showModalDialog("../../sys/ca/sysca103f.jsp",null,prop);

	if(ret != null){
		form1.birthDate.value = ret.ad;
		form1.birthMMDD.value = ret.ad.substr(4);
		form1.birthCalendar.value = ret.calendar;
		form1.birthDisplay.value = ret.display;
	}
}
</script>
</head>
<body onLoad="whatButtonFireEvent('<%= obj.getState() %>');init();showErrorMsg('<%= obj.getErrorMsg()%>');">
<fmt:bundle basename="ApplicationResources">
<form id="form1" name="form1" method="post" onSubmit="return checkField()">

<!--sheet區============================================================-->
<table cellspacing="0" cellpadding="0'" valign="top">
	<tr>
		<td nowrap id="t1" class="tab_border1" width="100"><a id="aTab1" href="#" onClick="changeTab(1)">基本資料一</a></td>
		<td nowrap id="t2" class="tab_border2" width="100"><a id="aTab2" href="#" onClick="changeTab(2)">基本資料二</a></td>
		<td nowrap id="t3" class="tab_border2" width="100"><a id="aTab3" href="#" onClick="changeTab(3)">基本資料三</a></td>
	</tr>
</table>

<!--Query區============================================================-->
<div id="queryContainer" style="width:500px;height:250px;display:none">
	<iframe id="queryContainerFrame"></iframe>
	<div class="queryTitle">查詢視窗</div>
	<table class="queryTable" border="1">
		<tr>
			<td class="queryTDLable"><fmt:message key="CtMemberInfo.fullName"/>:</td>
			<td class="queryTDInput">
				<input class="field_Q" type="text" name="q_fullName" size="20" maxlength="60" value="<%= obj.getQ_fullName() %>">
			</td>
		</tr>
		<tr>
			<td class="queryTDLable"><fmt:message key="CtMemberInfo.twIdNum"/>:</td>
			<td class="queryTDInput">
				<input class="field_Q" type="text" name="q_twIdNum" size="20" maxlength="20" value="<%= obj.getQ_twIdNum() %>" onChange="toUpper(this);">
			</td>
		</tr>
		<tr>
			<td class="queryTDLable"><fmt:message key="CtMemberInfo.birthDate"/>:</td>
			<td class="queryTDInput">
				<input class="field_Q" type="text" name="q_birthDisplay" size="20" maxlength="50" value="<%= obj.getQ_birthDisplay() %>">
			</td>
		</tr>
		<tr>
			<td class="queryTDLable"><fmt:message key="CtMemberInfo.mobile"/>:</td>
			<td class="queryTDInput">
				<input class="field_Q" type="text" name="q_mobileNum1" size="20" maxlength="20" value="<%= obj.getQ_mobileNum1() %>">
			</td>
		</tr>
		<tr>
			<td class="queryTDLable"><fmt:message key="CtMemberInfo.homePhone"/>:</td>
			<td class="queryTDInput">
				<input class="field_Q" type="text" name="q_homePhoneNum1" size="20" maxlength="20" value="<%= obj.getQ_homePhoneNum1() %>">
			</td>
		</tr>
		<tr>
			<td class="queryTDLable"><fmt:message key="CtMemberInfo.email"/>:</td>
			<td class="queryTDInput">
				<input class="field_Q" type="text" name="q_email1" size="50" maxlength="50" value="<%= obj.getQ_email1() %>">
			</td>
		</tr>
		<tr>
			<td class="queryTDInput" colspan="2" style="text-align:center">
				<input class="toolbar_default" followPK="false" type="submit" name="querySubmit" value="確　　定" >
				<input class="toolbar_default" followPK="false" type="button" name="queryCannel" value="取　　消" onClick="whatButtonFireEvent(this.name)">
			</td>		
		</tr>
	</table>
</div>
<table width="100%" cellspacing="0" cellpadding="0">
<!--Form區============================================================-->
<tr>
	<td class="bg">
		<div id="formContainer" style="height:auto">
			
			<!-- page 1 Table============================================================ -->
			<table id="Tab1" class="table_form" width="100%" height="100%">
				<tr>
					<td class="td_form">
						<font color="red">*</font><fmt:message key="CtMemberInfo.fullName"/>:</td>
					<td class="td_form_white">
						<fmt:message key="CtMemberInfo.lastName"/>&nbsp;<input class="field" type="text" name="lastName" size="10" maxlength="30" value="<%= obj.getLastName()%>">
						<fmt:message key="CtMemberInfo.firstName"/>&nbsp;<input class="field" type="text" name="firstName" size="15" maxlength="30" value="<%= obj.getFirstName()%>">
						<input class="toolbar_default" type="button" name="openMultiName" value="+" onClick="showMultiField('nameArea','openMultiName')">
						<div id = "nameArea" style="display:none">							
							<fmt:message key="CtMemberInfo.lastName"/>&nbsp;<input class="field" type="text" name="otherLastName" size="10" maxlength="30" value="<%= obj.getOtherLastName() %>">
							<fmt:message key="CtMemberInfo.firstName"/>&nbsp;<input class="field" type="text" name="otherFirstName" size="15" maxlength="30" value="<%= obj.getOtherFirstName() %>">(<fmt:message key="CtMemberInfo.other"/>)<br>							
							<fmt:message key="CtMemberInfo.lastName"/>&nbsp;<input class="field" type="text" name="pinyinLastName" size="10" maxlength="30" value="<%= obj.getPinyinLastName() %>">							
							<fmt:message key="CtMemberInfo.firstName"/>&nbsp;<input class="field" type="text" name="pinyinFirstName" size="15" maxlength="30" value="<%= obj.getPinyinFirstName() %>">(<fmt:message key="CtMemberInfo.pinyin"/>)<br>
							<fmt:message key="aliasName"/>&nbsp;<input class="field" type="text" name="aliasName" size="20" maxlength="60" value="<%= obj.getAliasName() %>"><br>								
							<fmt:message key="CtMemberInfo.dharmaName"/>&nbsp;<input class="field" type="text" name="pinyinOtherDharmaName" size="20" maxlength="30" value="<%= obj.getPinyinOtherDharmaName() %>">(<fmt:message key="CtMemberInfo.pinyin"/>)
						</div>
					</td>
					<td class="td_form"><fmt:message key="CtMemberInfo.gender"/>:</td>
					<td class="td_form_white">
						<select class="field" name="gender">
							<%= View.getTextOption("M;男;F;女",obj.getGender()) %>
						</select>						
					</td>	
					<td class="td_form"><fmt:message key="CtMemberInfo.password"/>:</td>
					<td class="td_form_white">
						<input class="field" type="password" name="passcode" size="4" maxlength="4" value="<%= obj.getPasscode() %>">
					</td>			
				</tr>
				<tr>
					<td class="td_form"><fmt:message key="ctMemberId"/>:</td>
					<td class="td_form_white">
						<input class="field" type="text" name="ctMemberId" size="9" maxlength="9" value="<%= obj.getCtMemberId()%>" >						
					</td>
					<td class="td_form"><fmt:message key="CtMemberInfo.birthDate"/>:</td>
					<td class="td_form_white">
						<input class="field_RO" type="text" name="birthDisplay" size="20" maxlength="50" value="<%= obj.getBirthDisplay()%>" >
						<input class="field" type="button" name="btnOpenCalendar" value="..." onClick="popSysca103f()">
					</td>
					<td class="td_form"><fmt:message key="CtMemberInfo.twIdNum"/>:</td>
					<td class="td_form_white">
						<input class="field" type="text" name="twIdNum" size="20" maxlength="20" value="<%= obj.getTwIdNum()%>" onChange="toUpper(this);">						
					</td>
				</tr>
				<tr>
					<td class="td_form"><fmt:message key="CtMemberInfo.ctRefugeMaster"/>:</td>
					<td class="td_form_white">
						<input class="field" type="text" name="ctRefugeMaster" size="20" maxlength="30" value="<%= obj.getCtRefugeMaster() %>">
					</td>
					<td class="td_form"><fmt:message key="CtMemberInfo.ctDharmaName"/>:</td>
					<td class="td_form_white" colspan = "3">
						<input class="field" type="text" name="ctDharmaName" size="20" maxlength="30" value="<%= obj.getCtDharmaName() %>">
					</td>
				</tr>
				<tr>
					<td class="td_form"><fmt:message key="CtMemberInfo.otherDharmaName"/>:</td>
					<td class="td_form_white">
						<input class="field" type="text" name="otherDharmaName" size="20" maxlength="30" value="<%= obj.getOtherDharmaName() %>">
					</td>
					<td class="td_form"><fmt:message key="CtMemberInfo.otherRefugeMaster"/>:</td>
					<td class="td_form_white" colspan="3">
						<input class="field" type="text" name="otherRefugeMaster" size="20" maxlength="30" value="<%= obj.getOtherRefugeMaster() %>">
					</td>
				</tr>
				<tr>
					<td class="td_form"><fmt:message key="CtMemberInfo.mobile"/>:</td>
					<td class="td_form_white">
						<fmt:message key="CtMemberInfo.phoneNum"/>1&nbsp;<input class="field" type="text" name="mobileNum1" size="20" maxlength="20" value="<%= obj.getMobileNum1() %>">
						<input class="toolbar_default" type="button" name="openMultiMobile" value="+" onClick="showMultiField('mobileArea','openMultiMobile')">
						<div id = "mobileArea" style="display:none">
							<fmt:message key="CtMemberInfo.phoneNum"/>2&nbsp;<input class="field" type="text" name="mobileNum2" size="20" maxlength="20" value="<%= obj.getMobileNum2() %>"><br>
							<fmt:message key="CtMemberInfo.phoneNum"/>3&nbsp;<input class="field" type="text" name="mobileNum3" size="20" maxlength="20" value="<%= obj.getMobileNum3() %>">
						</div>
					</td>
					<td class="td_form"><fmt:message key="CtMemberInfo.homePhone"/>:</td>
					<td class="td_form_white" colspan = "3">
						<fmt:message key="CtMemberInfo.phoneNum"/>1&nbsp;<input class="field" type="text" name="homePhoneNum1" size="20" maxlength="20" value="<%= obj.getHomePhoneNum1()%>">
						<input class="toolbar_default" type="button" name="openMultiHomePhone" value="+" onClick="showMultiField('homePhoneArea','openMultiHomePhone')">
						<div id = "homePhoneArea" style="display:none">
							<fmt:message key="CtMemberInfo.phoneNum"/>2&nbsp;<input class="field" type="text" name="homePhoneNum2" size="20" maxlength="20" value="<%= obj.getHomePhoneNum2() %>">
						</div>
					</td>					
				</tr>
				<tr>
					<td class="td_form"><fmt:message key="CtMemberInfo.urgentContactPersonName"/>:</td>
					<td class="td_form_white">
						<input class="field" type="text" name="urgentContactPersonName1" size="30" maxlength="60" value="<%= obj.getUrgentContactPersonName1() %>">
					</td>
					<td class="td_form"><fmt:message key="CtMemberInfo.urgentContactPersonRelationship"/>:</td>
					<td class="td_form_white">
						<input class="field" type="text" name="urgentContactPersonRelationship1" size="10" maxlength="10" value="<%= obj.getUrgentContactPersonRelationship1()%>">
					</td>
					<td class="td_form"><fmt:message key="CtMemberInfo.urgentContactPersonPhoneNum"/>:</td>
					<td class="td_form_white">
						<input class="field" type="text" name="urgentContactPersonPhoneNum1" size="15" maxlength="15" value="<%= obj.getUrgentContactPersonPhoneNum1()%>">
						<input class="toolbar_default" type="button" name="openMultiContactArea" value="+" onClick="showMultiField('multiContactArea','openMultiContactArea')">
					</td>
				</tr>
				<tbody id = "multiContactArea" style="display:none">
					<tr>
						<td class="td_form"><fmt:message key="CtMemberInfo.urgentContactPersonName"/>2:</td>
						<td class="td_form_white">
							<input class="field" type="text" name="urgentContactPersonName2" size="30" maxlength="60" value="<%= obj.getUrgentContactPersonName2() %>">
						</td>
						<td class="td_form"><fmt:message key="CtMemberInfo.urgentContactPersonRelationship"/>2:</td>
						<td class="td_form_white">
							<input class="field" type="text" name="urgentContactPersonRelationship2" size="10" maxlength="10" value="<%= obj.getUrgentContactPersonRelationship2()%>">
						</td>
						<td class="td_form"><fmt:message key="CtMemberInfo.urgentContactPersonPhoneNum"/>2:</td>
						<td class="td_form_white">
							<input class="field" type="text" name="urgentContactPersonPhoneNum2" size="15" maxlength="15" value="<%= obj.getUrgentContactPersonPhoneNum2()%>">							
						</td>
					</tr>
				</tbody>
				<tr>
					<td class="td_form"><fmt:message key="CtMemberInfo.donationType"/>:</td>
					<td class="td_form_white">
						<input class="field" type="text" name="donationType" size="20" maxlength="30" value="<%= obj.getDonationType() %>">
					</td>
					<td class="td_form"><fmt:message key="CtMemberInfo.classList"/>:</td>
					<td class="td_form_white" colspan = "3">
						<input class="field" type="text" name="classList" size="20" maxlength="20" value="<%= obj.getClassList()%>">
					</td>
				</tr>
				<tr>
					<td class="td_form"><fmt:message key="CtMemberInfo.onBlackList"/>:</td>
					<td class="td_form_white">
						<select class="field" name="onBlackList">
							<%= View.getTextOption("true;是;false;否",obj.getOnBlackList()) %>
						</select>					
					</td>
					<td class="td_form"><fmt:message key="CtMemberInfo.onNostayList"/>:</td>
					<td class="td_form_white">
						<select class="field" name="onNostayList">
							<%= View.getTextOption("true;是;false;否",obj.getOnNostayList()) %>
						</select>						
					</td>	
					<td class="td_form"><fmt:message key="CtMemberInfo.thisPersonStatus"/>:</td>
					<td class="td_form_white">
						<select class="field" name="thisPersonStatus">
							<%= View.getTextOption("0;正常;1;往生;3;出家;99;已刪除",obj.getThisPersonStatus()) %>
						</select>
					</td>
				</tr>				
				<tr>
					<td class="td_form"><fmt:message key="updateInformation"/>:</td>
					<td class="td_form_white" colspan = "5">
						<% request.setAttribute("objBean",obj); %>
						<c:import url="/home/editUser.jsp" />
					</td>
				</tr>
			</table>
			
			<!-- page 2 Table============================================================ -->
			<table id="Tab2" class="table_form" width="100%" height="100%" style="display:none">
				<tr>
					<td class="td_form"><fmt:message key="CtMemberInfo.nationality"/>:</td>
					<td class="td_form_white">
						<input class="field" type="text" name="nationality" size="10" maxlength="10" value="<%= obj.getNationality() %>">
					</td>
					<td class="td_form"><fmt:message key="CtMemberInfo.birthPlace"/>(<fmt:message key="CtMemberInfo.province"/>):</td>
					<td class="td_form_white">
						<input class="field" type="text" name="birthProvinceCountry" size="20" maxlength="40" value="<%= obj.getBirthProvinceCountry() %>">
					</td>
					<td class="td_form"><fmt:message key="CtMemberInfo.nativePlace"/>(<fmt:message key="CtMemberInfo.province"/>):</td>
					<td class="td_form_white">
						<input class="field" type="text" name="familyProvince" size="15" maxlength="15" value="<%= obj.getFamilyProvince() %>">
					</td>
				</tr>
				<tr>					
					<td class="td_form"><fmt:message key="CtMemberInfo.ethnicGroup"/>:</td>
					<td class="td_form_white">
						<input class="field" type="text" name="ethnicGroup" size="10" maxlength="10" value="<%= obj.getEthnicGroup() %>">
					</td>
					<td class="td_form"><fmt:message key="CtMemberInfo.birthPlace"/>(<fmt:message key="CtMemberInfo.city"/>):</td>
					<td class="td_form_white">
						<input class="field" type="text" name="birthCity" size="15" maxlength="15" value="<%= obj.getBirthCity() %>">
					</td>
					<td class="td_form"><fmt:message key="CtMemberInfo.nativePlace"/>(<fmt:message key="CtMemberInfo.city"/>):</td>
					<td class="td_form_white">
						<input class="field" type="text" name="familyCity" size="15" maxlength="15" value="<%= obj.getFamilyCity() %>">
					</td>
				</tr>
				<tr>
					<td class="td_form"><fmt:message key="CtMemberInfo.marriageStatus"/>:</td>
					<td class="td_form_white">
						<select class="field" name="marriageStatus">
							<%= View.getTextOption("true;已婚;false;未婚",obj.getMarriageStatus())%>
						</select>						
					</td>				
					<td class="td_form"><fmt:message key="CtMemberInfo.email"/>:</td>
					<td class="td_form_white" colspan="3">
						<input class="field" type="text" name="email1" size="50" maxlength="50" value="<%= obj.getEmail1() %>">
						<input class="toolbar_default" type="button" name="openMultiEmail" value="+" onClick="showMultiField('emailArea','openMultiEmail')">
						<div id = "emailArea" style="display:none">
							<input class="field" type="text" name="email2" size="50" maxlength="50" value="<%= obj.getEmail2() %>">
						</div>
					</td>					
				</tr>
				<tr>
					<td class="td_form"><fmt:message key="CtMemberInfo.twIdAddress"/>:</td>
					<td class="td_form_white" colspan="5">
						<input class="field" type="text" name="twIdAddress" size="60" maxlength="80" value="<%= obj.getTwIdAddress() %>">						
					</td>
				</tr>
				<tr>
					<td class="td_form">(<fmt:message key="CtMemberInfo.mailing"/>)<fmt:message key="CtMemberInfo.address"/>:</td>
					<td class="td_form_white" colspan = "5">
						<input class="field" type="text" name="mailingAddress" size="60" maxlength="80" value="<%= obj.getMailingAddress() %>">
						<input class="field" type="button" name="btnPopAdress" value="..." onClick="popCorap006f_1f('mailingZip','mailingAddress','mailingState','mailingCity')">
						<input class="toolbar_default" type="button" name="openMultiAddressInfo" value="+" onClick="showMultiField('multiAddressInfoArea','openMultiAddressInfo')">						
					</td>
				</tr>
				<tbody id = "multiAddressInfoArea" style="display:none">
					<tr>
						<td class="td_form">(<fmt:message key="CtMemberInfo.mailing"/>)<fmt:message key="CtMemberInfo.township"/>:</td>
						<td class="td_form_white">
							<input class="field" type="text" name="mailingCity" size="20" maxlength="30" value="<%= obj.getMailingCity() %>">
						</td>
						<td class="td_form">(<fmt:message key="CtMemberInfo.mailing"/>)<fmt:message key="CtMemberInfo.city"/>:</td>
						<td class="td_form_white" colspan = "3">
							<input class="field" type="text" name="mailingState" size="20" maxlength="30" value="<%= obj.getMailingState()%>">
						</td>
					</tr>
					<tr>
						<td class="td_form">(<fmt:message key="CtMemberInfo.mailing"/>)<fmt:message key="CtMemberInfo.zip"/>:</td>
						<td class="td_form_white">
							<input class="field" type="text" name="mailingZip" size="15" maxlength="15" value="<%= obj.getMailingZip() %>" onBlur="getCommonZipDb(this.value,'mailingState','mailingCity')">
						</td>
						<td class="td_form">(<fmt:message key="CtMemberInfo.mailing"/>)<fmt:message key="CtMemberInfo.country"/>:</td>
						<td class="td_form_white" colspan = "3">
							<input type="radio" class="field" name="mcRadio" value="1" <% if("1".equals(obj.getMcRadio())) out.write("checked"); %> onClick="changRadioState('mailingCountryCombo','mailingCountry',this.value);">
							<select class="field" name="mailingCountryCombo">
								<%= View.getTextOption("1;台灣;2;日本;3;美國",obj.getMailingCountry()) %>
							</select>
							<input type="radio" class="field" name="mcRadio" value="2" <% if("2".equals(obj.getMcRadio())) out.write("checked"); %> onClick="changRadioState('mailingCountryCombo','mailingCountry',this.value);">
							<input class="field" type="text" name="mailingCountry" size="10" maxlength="10" value="<%= obj.getMailingCountry()%>">
						</td>
					</tr>
					<tr>
						<td class="td_form">(<fmt:message key="CtMemberInfo.permanent"/>)<fmt:message key="CtMemberInfo.address"/>:</td>
						<td class="td_form_white" colspan = "5">
							<input class="field" type="text" name="permanentAddress" size="60" maxlength="80" value="<%= obj.getPermanentAddress() %>">													
						</td>
					</tr>
					<tr>
						<td class="td_form">(<fmt:message key="CtMemberInfo.permanent"/>)<fmt:message key="CtMemberInfo.township"/>:</td>
						<td class="td_form_white">
							<input class="field" type="text" name="permanentCity" size="20" maxlength="30" value="<%= obj.getPermanentCity() %>">
						</td>
						<td class="td_form">(<fmt:message key="CtMemberInfo.permanent"/>)<fmt:message key="CtMemberInfo.city"/>:</td>
						<td class="td_form_white" colspan = "3">
							<input class="field" type="text" name="permanentState" size="20" maxlength="30" value="<%= obj.getPermanentState()%>">
						</td>
					</tr>
					<tr>
						<td class="td_form">(<fmt:message key="CtMemberInfo.permanent"/>)<fmt:message key="CtMemberInfo.zip"/>:</td>
						<td class="td_form_white">
							<input class="field" type="text" name="permanentZip" size="15" maxlength="15" value="<%= obj.getPermanentZip() %>" onBlur="getCommonZipDb(this.value,'permanentState','permanentCity')">
						</td>
						<td class="td_form">(<fmt:message key="CtMemberInfo.permanent"/>)<fmt:message key="CtMemberInfo.country"/>:</td>
						<td class="td_form_white" colspan = "3">
							<input type="radio" class="field" name="pcRadio" value="1" <% if("1".equals(obj.getPcRadio())) out.write("checked"); %> onClick="changRadioState('permanentCountryCombo','permanentCountry',this.value);">
							<select class="field" name="permanentCountryCombo">
								<%= View.getTextOption("1;台灣;2;日本;3;美國",obj.getPermanentCountry()) %>
							</select>
							<input type="radio" class="field" name="pcRadio" value="2" <% if("2".equals(obj.getPcRadio())) out.write("checked"); %> onClick="changRadioState('permanentCountryCombo','permanentCountry',this.value);">
							<input class="field" type="text" name="permanentCountry" size="10" maxlength="10" value="<%= obj.getPermanentCountry()%>">
						</td>
					</tr>
				</tbody>
				<tr>
					<td class="td_form"><fmt:message key="CtMemberInfo.school"/>:</td>
					<td class="td_form_white">
					<fmt:message key="CtMemberInfo.schoolName"/>&nbsp;<input class="field" type="text" name="schoolName" size="20" maxlength="30" value="<%= obj.getSchoolName() %>">
						<input class="toolbar_default" type="button" name="openSchoolInfoArea" value="+" onClick="showMultiField('schoolInfoArea','openSchoolInfoArea')">
						<div id="schoolInfoArea" style="display:none">
							<fmt:message key="CtMemberInfo.schoolMajor"/>&nbsp;<input class="field" type="text" name="schoolMajor" size="20" maxlength="30" value="<%= obj.getSchoolMajor() %>"><br>
							<fmt:message key="CtMemberInfo.schoolDegree"/>&nbsp;<input class="field" type="text" name="schoolDegree" size="5" maxlength="5" value="<%= obj.getSchoolDegree() %>">
						</div>				
					</td>
					<td class="td_form"><fmt:message key="CtMemberInfo.company"/>:</td>
					<td class="td_form_white">
						<fmt:message key="CtMemberInfo.companyName"/>&nbsp;<input class="field" type="text" name="companyName" size="20" maxlength="30" value="<%= obj.getCompanyName() %>">
						<input class="toolbar_default" type="button" name="openCompanyInfoArea" value="+" onClick="showMultiField('companyInfoArea','openCompanyInfoArea')">
						<div id="companyInfoArea" style="display:none">
							<fmt:message key="CtMemberInfo.address"/>&nbsp;<input class="field" type="text" name="companyAddress" size="40" maxlength="80" value="<%= obj.getCompanyAddress() %>"><br>
							<fmt:message key="CtMemberInfo.companyJobTitle"/>&nbsp;<input class="field" type="text" name="companyJobTitle" size="20" maxlength="30" value="<%= obj.getCompanyJobTitle() %>"><br>
							<fmt:message key="CtMemberInfo.phoneNum"/>1&nbsp;<input class="field" type="text" name="officePhoneNum1" size="20" maxlength="20" value="<%= obj.getOfficePhoneNum1() %>"><br>
							<fmt:message key="CtMemberInfo.phoneNum"/>2&nbsp;<input class="field" type="text" name="officePhoneNum2" size="20" maxlength="20" value="<%= obj.getOfficePhoneNum2() %>">
						</div>
					</td>
					<td class="td_form"><fmt:message key="CtMemberInfo.referenceId"/>:</td>
					<td class="td_form_white">						
						<select class="field" name="referenceId">
							<%= View.getTextOption("1;親友介紹;2;朋友介紹 ;3;同事介紹",obj.getReferenceId())%>
						</select>
						<input class="toolbar_default" type="button" name="openIntroducerInfoArea" value="+" onClick="showMultiField('introducerInfoArea','openIntroducerInfoArea')">
						<div id="introducerInfoArea" style="display:none">
							<fmt:message key="CtMemberInfo.introducerName"/>&nbsp;<input class="field" type="text" name="introducerName" size="20" maxlength="20" value="<%= obj.getIntroducerName() %>"><br>
							<fmt:message key="CtMemberInfo.introducerRelationship"/>&nbsp;<input class="field" type="text" name="introducerRelationship" size="6" maxlength="6" value="<%= obj.getIntroducerRelationship() %>"><br>
							<fmt:message key="CtMemberInfo.introducerPhoneNum"/>&nbsp;<input class="field" type="text" name="introducerPhoneNum" size="20" maxlength="20" value="<%= obj.getIntroducerPhoneNum() %>">
						</div>					
					</td>
				</tr>
				<tr>
					<td class="td_form"><fmt:message key="CtMemberInfo.refuge"/>:</td>
					<td class="td_form_white">
						<fmt:message key="CtMemberInfo.takeRefuge"/>
						<select class="field" name="takeRefuge">
							<%= View.getTextOption("true;是;false;否",obj.getTakeRefuge())%>
						</select>
						<input class="toolbar_default" type="button" name="openRefugeInfoArea" value="+" onClick="showMultiField('refugeInfoArea','openRefugeInfoArea')">
						<div id="refugeInfoArea" style="display:none">
							<fmt:message key="CtMemberInfo.date"/>&nbsp;<input class="field" type="text" name="refugeDate" size="8" maxlength="8" value="<%= obj.getRefugeDate() %>"><br>
							<fmt:message key="CtMemberInfo.place"/>&nbsp;<input class="field" type="text" name="refugePlace" size="20" maxlength="20" value="<%= obj.getRefugePlace() %>">
						</div>					
					</td>
					<td class="td_form"><fmt:message key="CtMemberInfo.precept5"/>:</td>
					<td class="td_form_white">
						<fmt:message key="CtMemberInfo.takePrecept"/>
						<select class="field" name="takePrecept5">
							<%= View.getTextOption("true;是;false;否",obj.getTakePrecept5())%>
						</select>
						<input class="toolbar_default" type="button" name="openPrecept5InfoArea" value="+" onClick="showMultiField('precept5InfoArea','openPrecept5InfoArea')">
						<div id="precept5InfoArea" style="display:none">
							<fmt:message key="CtMemberInfo.date"/>&nbsp;<input class="field" type="text" name="precept5Date" size="8" maxlength="8" value="<%= obj.getPrecept5Date() %>"><br>
							<fmt:message key="CtMemberInfo.place"/>&nbsp;<input class="field" type="text" name="precept5Place" size="20" maxlength="20" value="<%= obj.getPrecept5Place() %>">
						</div>					
					</td>
					<td class="td_form"><fmt:message key="CtMemberInfo.bodhiPrecept"/>:</td>
					<td class="td_form_white">
						<fmt:message key="CtMemberInfo.takePrecept"/>
						<select class="field" name="takeBodhiPrecept">
							<%= View.getTextOption("true;是;false;否",obj.getTakeBodhiPrecept())%>
						</select>
						<input class="toolbar_default" type="button" name="openBodhiPreceptInfoArea" value="+" onClick="showMultiField('bodhiPreceptInfoArea','openBodhiPreceptInfoArea')">
						<div id="bodhiPreceptInfoArea" style="display:none">
							<fmt:message key="CtMemberInfo.date"/>&nbsp;<input class="field" type="text" name="bodhiPreceptDate" size="8" maxlength="8" value="<%= obj.getBodhiPreceptDate() %>"><br>
							<fmt:message key="CtMemberInfo.place"/>&nbsp;<input class="field" type="text" name="bodhiPreceptPlace" size="20" maxlength="20" value="<%= obj.getBodhiPreceptPlace() %>">
						</div>					
					</td>
				</tr>
				<tr>
					<td class="td_form"><fmt:message key="CtMemberInfo.okSendMagazine"/>:</td>
					<td class="td_form_white">
						<select class="field" name="okSendMagazine">
							<%= View.getTextOption("true;是;false;否",obj.getOkSendMagazine())%>
						</select>											
					</td>
					<td class="td_form"><fmt:message key="CtMemberInfo.okSendEletter"/>:</td>
					<td class="td_form_white">
						<select class="field" name="okSendEletter">
							<%= View.getTextOption("true;是;false;否",obj.getOkSendEletter())%>
						</select>											
					</td>
					<td class="td_form"><fmt:message key="CtMemberInfo.okSendEmail"/>:</td>
					<td class="td_form_white">
						<select class="field" name="okSendEmail">
							<%= View.getTextOption("true;是;false;否",obj.getOkSendEmail())%>
						</select>											
					</td>
				</tr>
				<tr>
					<td class="td_form"><fmt:message key="CtMemberInfo.okSendMessage"/>:</td>
					<td class="td_form_white">
						<select class="field" name="okSendMessage">
							<%= View.getTextOption("true;是;false;否",obj.getOkSendMessage())%>
						</select>											
					</td>
					<td class="td_form"><fmt:message key="CtMemberInfo.okToCallType"/>:</td>
					<td class="td_form_white" colspan="3">
						<input class="field" type="text" name="okToCallType" size="10" maxlength="10" value="<%= obj.getOkToCallType() %>">											
					</td>					
				</tr>
			</table>
			
			<!-- page 3 Table============================================================ -->
			<table id="Tab3" class="table_form" width="100%" height="100%" style="display:none">
				<tr>
					<td class="td_form"><fmt:message key="CtMemberInfo.carNum"/>1:</td>
					<td class="td_form_white">
						<input class="field" type="text" name="carNum1" size="15" maxlength="15" value="<%= obj.getCarNum1() %>">
					</td>
					<td class="td_form"><fmt:message key="CtMemberInfo.carNum"/>2:</td>
					<td class="td_form_white">
						<input class="field" type="text" name="carNum2" size="15" maxlength="15" value="<%= obj.getCarNum2() %>">
					</td>
				</tr>
				<tr>
					<td class="td_form"><fmt:message key="CtMemberInfo.height"/>(cm):</td>
					<td class="td_form_white">
						<input class="field" type="text" name="height" size="10" maxlength="10" value="<%= obj.getHeight() %>">
					</td>
					<td class="td_form"><fmt:message key="CtMemberInfo.weight"/>(kg):</td>
					<td class="td_form_white">
						<input class="field" type="text" name="weight" size="10" maxlength="10" value="<%= obj.getWeight() %>">
					</td>
				</tr>
				<tr>
					<td class="td_form"><fmt:message key="CtMemberInfo.after2012Oct"/>:</td>
					<td class="td_form_white">
						<select class="field" name="after2012Oct">
							<%= View.getTextOption("true;是;false;否",obj.getAfter2012Oct())%>
						</select>	
					</td>			
					<td class="td_form"><fmt:message key="CtMemberInfo.piSigned"/>:</td>
					<td class="td_form_white">
						<fmt:message key="CtMemberInfo.isPiSigned"/>
						<select class="field" name="isPiSigned">
							<%= View.getTextOption("true;是;false;否",obj.getIsPiSigned())%>
						</select>
						<input class="toolbar_default" type="button" name="openPiInfoArea" value="+" onClick="showMultiField('piInfoArea','openPiInfoArea')">
						<div id="piInfoArea" style="display:none">
							<fmt:message key="CtMemberInfo.piDocId"/>&nbsp;<input class="field" type="text" name="piDocId" size="15" maxlength="15" value="<%= obj.getPiDocId() %>"><br>
							<fmt:message key="CtMemberInfo.aggrementPicFileName"/>1&nbsp;<input class="field" type="text" name="piAggrementPicFileName" size="30" maxlength="255" value="<%= obj.getPiAggrementPicFileName() %>"><br>
							<fmt:message key="CtMemberInfo.aggrementPicFileName"/>2&nbsp;<input class="field" type="text" name="piParentAggrementPicFileName" size="30" maxlength="255" value="<%= obj.getPiParentAggrementPicFileName() %>">(<fmt:message key="CtMemberInfo.parentAggrementPicFileName"/>)
						</div>					
					</td>
				</tr>
				<tr>
					<td class="td_form"><fmt:message key="CtMemberInfo.twIdPicFrontFileName"/>:</td>
					<td class="td_form_white">
						<input class="field" type="text" name="twIdPicFrontFileName" size="30" maxlength="255" value="<%= obj.getTwIdPicFrontFileName() %>">
					</td>
					<td class="td_form"><fmt:message key="CtMemberInfo.twIdPicBackFileName"/>:</td>
					<td class="td_form_white">
						<input class="field" type="text" name="twIdPicBackFileName" size="30" maxlength="255" value="<%= obj.getTwIdPicBackFileName() %>">
					</td>
				</tr>
				<tr>
					<td class="td_form"><fmt:message key="CtMemberInfo.skill"/>:</td>
					<td class="td_form_white" colspan="3">
						<%= View.getCheckBoxOption("field","skills","select skillId,skillName from BaseSkillDef",obj.getSkills()) %>
						<input class="field" type="checkbox" name="otherSkill" value="99" onClick="changeOtherFieldState('otherSkill','otherSkillName')" <% if("99".equals(obj.getOtherSkill())) out.write("checked"); %> >其他專長
						<input class="field" type="text" name="otherSkillName" size="10" maxlength="10" value="<%= obj.getOtherSkillName() %>" disabled>
					</td>
				</tr>
				<tr>
					<td class="td_form"><fmt:message key="CtMemberInfo.health"/>:</td>
					<td class="td_form_white" colspan="3">
					
					</td>
				</tr>
			</table>
		</div>
	</td>
</tr>
<!--Toolbar區============================================================-->
<tr>
	<td class="bgToolbar" style="text-align:center">
		<input type="hidden" name="id" value="<%=obj.getId()%>">
		<input type="hidden" name="state" value="<%=obj.getState()%>">
		<input type="hidden" name="queryAllFlag" value="<%=obj.getQueryAllFlag()%>">
		<input type="hidden" name="birthDate" value="<%=obj.getBirthDate()%>">
		<input type="hidden" name="birthMMDD" value="<%=obj.getBirthMMDD()%>">
		<input type="hidden" name="birthCalendar" value="<%=obj.getBirthCalendar()%>">
		<jsp:include page="../../home/toolbar.jsp" />
	</td>
</tr>
<tr>
	<td>
		<% request.setAttribute("QueryBean",obj);%>
		<jsp:include page="../../home/page.jsp" />
	</td>
</tr>
<!--List區============================================================-->
<tr>
	<td class="bgList">
		<div id="listContainer" style="height:auto">
			<table class="table_form" width="100%" cellspacing="0" cellpadding="0">
				<thead id="listTHEAD">
					<tr>
						<th class="listTH" ><a class="text_link_w" >NO.</a></th>
						<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',1,false);" href="#">姓名</a></th>
						<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',2,false);" href="#">身分證</a></th>
						<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',3,false);" href="#">生日</a></th>
						<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',4,false);" href="#">法名</a></th>
						<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',5,false);" href="#">Email</a></th>
						<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',6,false);" href="#">行動電話</a></th>
						<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',7,false);" href="#">住家電話</a></th>
						<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',8,false);" href="#">公司電話</a></th>
					</tr>
				</thead> 
				<tbody id="listTBODY">				
					<%
						boolean primaryArray[] = {true,false,false,false,false,false,false,false,false};
						boolean displayArray[] = {false,true,true,true,true,true,true,true,true};
						out.write(View.getQuerylist(primaryArray,displayArray,objList,obj.getQueryAllFlag()));
					%>				
				</tbody>
			</table>
		</div>
	</td>
</tr>
</table>
</form>
</fmt:bundle>
</body>
</html>