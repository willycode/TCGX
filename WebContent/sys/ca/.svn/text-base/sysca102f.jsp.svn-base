<!--
程式目的：機關代碼維護作業_CPA版本
程式代號：sysca002f_cpa
程式日期：0980811
程式作者：shark
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../home/head.jsp" %>
<jsp:useBean id="obj" scope="request" class="com.kangdainfo.common.view.sys.ca.SYSCA102F">
	<jsp:setProperty name="obj" property="*"/>
</jsp:useBean>
<jsp:useBean id="objList" scope="page" class="java.util.ArrayList"/>

<%

if ("queryAll".equals(obj.getState())) {
	if ("false".equals(obj.getQueryAllFlag())){obj.setQueryAllFlag("true"); }
}else if ("queryOne".equals(obj.getState())) {
	obj = (com.kangdainfo.common.view.sys.ca.SYSCA102F)obj.queryOne();	
}else if ("insert".equals(obj.getState()) || "insertError".equals(obj.getState())) {
	obj.insert();
}else if ("update".equals(obj.getState()) || "updateError".equals(obj.getState())) {
	obj.update();
}else if ("delete".equals(obj.getState()) || "deleteError".equals(obj.getState())) {
	obj.delete();
}
//if ("true".equals(obj.getQueryAllFlag())){
	objList = (java.util.ArrayList) obj.queryAll();
//}
%>

<html>
<head>
<%@ include file="../../home/meta.jsp" %>
<script language="javascript">
var insertDefault;	//二維陣列, 新增時, 設定預設值
function checkField(){
	var alertStr="";
	if(form1.state.value=="queryAll"){
		//alertStr += checkQuery();
	}else if(form1.state.value=="insert"||form1.state.value=="insertError"||form1.state.value=="update"||form1.state.value=="updateError"){
		alertStr += checkEmpty(form1.adDate,"西元日期");
		alertStr += checkEmpty(form1.lunarName,"天干地支");
		alertStr += checkEmpty(form1.lunarYear,"農曆年");
		alertStr += checkEmpty(form1.lunarMonth,"農曆月");
		alertStr += checkEmpty(form1.lunarDay,"農曆日");
		if(form1.isBeforeROC.checked){
			if(form1.isLeap.checked){
				form1.lunarDate.value="民國前"+form1.lunarYear.value+"年"+"閏"+form1.lunarMonth.value+"月"+form1.lunarDay.value+"日";
			}else{
				form1.lunarDate.value="民國前"+form1.lunarYear.value+"年"+form1.lunarMonth.value+"月"+form1.lunarDay.value+"日";
			}
			
		}else if(form1.isLeap.checked){
			
				form1.lunarDate.value="民國"+form1.lunarYear.value+"年"+"閏"+form1.lunarMonth.value+"月"+form1.lunarDay.value+"日";
			}else{
				form1.lunarDate.value="民國"+form1.lunarYear.value+"年"+form1.lunarMonth.value+"月"+form1.lunarDay.value+"日";
			}
			
		}
		

	
	if(alertStr.length!=0){ alert(alertStr); return false; }
	beforeSubmit();
}
function queryOne(id){
	form1.id.value=id;
	form1.state.value="queryOne";
	beforeSubmit();
	form1.submit();
}
</script>
</head>

<body topmargin="0" onLoad="whatButtonFireEvent('<%=obj.getState()%>');showErrorMsg('<%=obj.getErrorMsg()%>');">
<form id="form1" name="form1" method="post" onSubmit="return checkField()" autocomplete="off">

<!--Query區============================================================-->
<div id="queryContainer" style="width:400px;height:150px;display:none">
	<iframe id="queryContainerFrame"></iframe>
	<div class="queryTitle">查詢視窗</div>
	<table class="queryTable"  border="1">
	
	<tr>
		<td class="queryTDLable">西元日期：</td>
		<td class="queryTDInput">
			<input class="field_Q" type="text" name="q_adDate" size="10" maxlength="8" value="<%=obj.getQ_adDate()%>">
		</td>
	</tr>
	<tr>
		<td class="queryTDLable">天干地支：</td>
		<td class="queryTDInput">
			<input class="field_Q" type="text" name="q_lunarName" size="15" maxlength="15" value="<%=obj.getQ_lunarName()%>">
		</td>
	</tr>
	<tr>
		<td class="queryTDLable">農曆年：</td>
		<td class="queryTDInput">
		 <input class="field_Q" type="checkbox" name="q_isBeforeROC" value="true" <%=obj.getQ_isBeforeROC().equals("true")?"checked":""%> >
	           民國前<input class="field_Q" type="text" name="q_lunarYear" size="15" maxlength="15" value="<%=obj.getQ_lunarYear()%>">年
		</td>
	</tr>
	<tr>
		<td class="queryTDLable">農曆月：</td>
		<td class="queryTDInput">
		    <input class="field_Q" type="checkbox" name="q_isLeap" value="true" <%=obj.getQ_isLeap().equals("true")?"checked":""%> >閏月
			<input class="field_Q" type="text" name="q_lunarMonth" size="5" maxlength="2" value="<%=obj.getQ_lunarMonth()%>">月
		</td>
	</tr>
	<tr>
		<td class="queryTDLable">農曆日：</td>
		<td class="queryTDInput">
			<input class="field_Q" type="text" name="q_lunarDay" size="5" maxlength="2" value="<%=obj.getQ_lunarDay()%>">
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
	<div id="formContainer"style="height:auto;">
	<table class="table_form" width="100%" height="100%">
	<tr>
	  <td class="td_form"><font color="red">*</font>西元日期：</td>
	  <td class="td_form_white"><input class="field" type="text" name="adDate" size="10" maxlength="8" value="<%=obj.getAdDate()%>">格式:20141221</td>
	  <td class="td_form"><font color="red">*</font>天干地支：</td>
	  <td class="td_form_white"width="35%"><input class="field" type="text" name="lunarName" size="20" maxlength="15" value="<%=obj.getLunarName()%>"></td>
	  </tr>
	<tr>
	  <td class="td_form"><font color="red">*</font>農曆年：</td>
	  <td class="td_form_white"colspan="3">
	  <input class="field" type="checkbox" name="isBeforeROC" value="true" <%=obj.getIsBeforeROC().equals("true")?"checked":""%> >
	  民國前<input class="field" type="text" name="lunarYear" size="15" maxlength="15" value="<%=obj.getLunarYear()%>">
	  年<input class="field" type="checkbox" name="isLeap" value="true" <%=obj.getIsLeap().equals("true")?"checked":""%> >閏月
	 
	<select class="field_Q"  name="lunarMonth" style="width:100">
				<%=View.getTextOption("01;01;02;02;03;03;04;04;05;05;06;06;07;07;08;08;09;09;10;10;11;11;12;12;",obj.getLunarMonth(),1)%>
          </select>月
      <select class="field_Q"  name="lunarDay"" style="width:100">
				<%=View.getTextOption("01;01;02;02;03;03;04;04;05;05;06;06;07;07;08;08;09;09;10;10;11;11;12;12;13;13;14;14;15;15;16;16;17;17;18;18;19;19;20;20;21;21;22;22;23;23;24;24;25;25;26;26;27;27;28;28;29;29;30;30;31;31;",obj.getLunarDay(),1)%>
				</select>日
	 </td>
	   
	  </tr>
	  <tr>
	  <td class="td_form"><font color="red">*</font>農曆日期：</td>
	  <td class="td_form_white"colspan="3"><input class="field_RO" type="text" name="lunarDate" size="30" maxlength="30" value="<%=obj.getLunarDate()%>"></td>
	  </tr>
	
	             <tr>
					<td class="td_form">更新資訊：</td>
					<td class="td_form_white"colspan="3">
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
<!--List區============================================================-->
<tr><td class="bg">
<div id="listContainer"style="height:400px;">
<table class="table_form" width="100%" cellspacing="0" cellpadding="0">
	<thead id="listTHEAD">
	<tr>
		<th class="listTH" ><a class="text_link_w" >NO.</a></th>		
        <th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',1,false);" href="#">西元日期</a></th>
		<th class="listTH"><a class="text_link_w" onClick="return sortTable('listTBODY',2,false);" href="#"></a>農曆日期</th>

	
	</tr>
	</thead>
	<tbody id="listTBODY">
	<%
	boolean primaryArray[] = {true,false,false};
	boolean displayArray[] = {false,true,true};
	String alignArray[] = {"center","left","left"};
	out.write(View.getQuerylist(primaryArray,displayArray,alignArray,objList,obj.getQueryAllFlag()));
	%>
	</tbody>
</table>
</div>
</td></tr>
</table>
</form>
</body>
</html>
