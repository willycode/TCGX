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
<jsp:useBean id="obj" scope="request" class="com.kangdainfo.ctis.view.cor.ap.CORAP006F">
    <jsp:setProperty name="obj" property="*"/>
</jsp:useBean>
<jsp:useBean id="obj2" scope="request" class="com.kangdainfo.ctis.view.cor.ap.CORAP007F">
    <jsp:setProperty name="obj2" property="*"/>
</jsp:useBean>
<jsp:useBean id="objList" scope="page" class="java.util.ArrayList"/>
<%
String unitId            = request.getParameter("unitId");
String popCenterMemberId = request.getParameter("popCenterMemberId");
objList = (java.util.ArrayList) obj2.doQueryAll_corap007_1f(unitId);
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

function checkAll()
{
	var checkItem = document.getElementsByName("fds");
	for(var i=0;i<checkItem.length;i++)
	{
	  if(document.getElementById("cbAll").checked)
	    checkItem[i].checked=true; 
	  else
	    checkItem[i].checked=false;
	}
}

function checktest(){
	console.log(document.getElementById("listTBODY").getElementsByTagName("tr")[1].getElementsByTagName("td")[3].innerText);
	console.log(document.getElementById("listTBODY").getElementsByTagName("tr")[1].getElementsByTagName("td")[4].innerText);
	console.log(document.getElementById("listTBODY").getElementsByTagName("tr")[1].getElementsByTagName("td")[5].innerText);
	
	console.log(document.getElementById("listTBODY").getElementsByTagName("tr")[2].getElementsByTagName("td")[3].innerText);
	console.log(document.getElementById("listTBODY").getElementsByTagName("tr")[2].getElementsByTagName("td")[4].innerText);
	console.log(document.getElementById("listTBODY").getElementsByTagName("tr")[2].getElementsByTagName("td")[5].innerText);
	
	var obj = document.getElementById("listTBODY").getElementsByTagName("tr")[1].getElementsByTagName("td")[3].innerText;
	window.opener.document.getElementById("aliasName1").value = obj;
	
	var obj = document.getElementById("listTBODY").getElementsByTagName("tr")[2].getElementsByTagName("td")[3].innerText;
	window.opener.document.getElementById("aliasName2").value = obj;
	
	window.close();
}

function checkFamilyInfo(){
	var alertStr = "";
	alertStr += checkEmpty(form1.paidUpDate,'核銷日期');
	if(form1.paidUpDate.value != ""){
		alertStr += checkDate(form1.paidUpDate,'核銷日期');
	}
	
	if($('input[name="fds"]:checked').length <= 0){
		alertStr += "請至少勾選一項資料!";
	}

	//有勾選案件已核銷 則取消該筆勾選
	var obj = document.getElementsByName("fds");
	var len = obj.length;
	var fdsStr = "";
	var sumExpense = 0;
	var sumRate = 0;
	for(var i=0; i<len; i++){
		if(document.getElementsByName("fds")[i].checked){
			var paidUpDate = document.getElementById("listContainerRow"+obj[i].value).getElementsByTagName("td")[9].innerText;
			var expense = parseFloat(document.getElementById("listContainerRow"+obj[i].value).getElementsByTagName("td")[6].innerText);
			var rate = parseFloat(document.getElementById("listContainerRow"+obj[i].value).getElementsByTagName("td")[8].innerText);
			if(paidUpDate != ""){
				alertStr += "已核銷的資料無法再核銷，請重新確認勾選的資料!";
				break;
			}
			
			if(fdsStr == ""){
				fdsStr += document.getElementsByName("fds")[i].value;
			}
			else{
				fdsStr += "," + document.getElementsByName("fds")[i].value;
			}

			if(expense > 0){
				sumExpense += expense;
			}

			if(rate > 0){
				sumRate += rate;
			}
		}
	}
	
	if(alertStr.length!=0){ 
		alert(alertStr); 
		return false; 
	}

	var paramStr = "&fdsStr=" + fdsStr + "&paidUpDate=" + form1.paidUpDate.value;
	getRemoteData(getVirtualPath() + "/ajax/jsonFen4001S01.jsp",paramStr);
    
	form1.inspExpense.value = sumExpense;
	form1.rate.value = sumRate;
	for(var i=0; i<len; i++){
		if(document.getElementsByName("fds")[i].checked){
			document.getElementById("listContainerRow"+obj[i].value).getElementsByTagName("td")[9].innerText = form1.paidUpDate.value;
		}
	}
	alert("核銷作業完成!");
}

</script>
</head>
<body onload="">
<form id="form1" name="form1" method="post" onSubmit="return checkField()">
<table width="100%" cellspacing="0" cellpadding="0">
<!--Form區============================================================-->
<tr><td class="bg" >
    <div id="formContainer" style="height:auto">
    <table class="table_form" width="100%" height="100%">
	    <tr>
		    <td class="td_form"></font>主學員：</td>
		    <td class="queryTDInput">
		    	<input class="field_Q" type="text" name="ctMemberId" size="10" maxlength="10"  value="<%=obj2.getCtMemberId()%>">
		    	<input class="field_Q" type="text" name="aliasName " size="10" maxlength="10" value="<%=obj2.getAliasName()%>">
		    	<!-- value="<%=obj2.getCtMemberId()%> -->
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
    <input class="toolbar_default" type="button" id="paidUp" name="paidUp" value="確定選取" onClick="checktest();">
    <!--  
	<span id="spanConfirm">
		<input class="toolbar_default" type="submit" followPK="false" name="confirm" value="確定選取" onClick="test();">&nbsp;
	</span>
	-->
</td></tr>

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
                	<th class="listTH"><input type="checkbox" class="field_Q" name="cbAll" id="cbAll" onClick="checkAll();"></th>
                    <th class="listTH" id='house'><a class="text_link_w" onclick="return sortTable('listTBODY', 1, false);" href="#">精舍</a></th>
                    <th class="listTH"><a class="text_link_w" onclick="return sortTable('listTBODY', 2, false);" href="#">精舍學員編號</a></th>
                    <th class="listTH"><a class="text_link_w" onclick="return sortTable('listTBODY', 3, false);" href="#">學員</a></th>
                    <th class="listTH"><a class="text_link_w" onclick="return sortTable('listTBODY', 4, false);" href="#">親屬身分</a></th>
                   	<th class="listTH"><a class="text_link_w" onclick="return sortTable('listTBODY', 5, false);" href="#">主學員身分</a></th>
                </tr>
                </thead>
                <tbody id="listTBODY">
                <%
                    boolean primaryArray[] = {false, true, false, false, false, false};
                    boolean displayArray[] = {false, true, true, true, true, true};
                    String[] alignArray = {"center", "center", "center", "center", "center", "center"};
                    //out.write(View.getQuerylist(primaryArray, displayArray, alignArray, objList, obj.getQueryAllFlag()));
                    out.write(View.getCheckboxQuerylist(primaryArray,displayArray,alignArray,objList,obj.getQueryAllFlag(),"fds"));
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
