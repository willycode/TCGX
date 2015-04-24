<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../home/head.jsp" %>

<jsp:useBean id="objList" scope="page" class="java.util.ArrayList"/>

<html>
<head>
<title>各國曆法彈跳視窗</title>
<%@ include file = "../../home/meta.jsp" %>
<script type="text/javascript">
function checkField()
{		
	var paramStr = "";
	var dateDisplay = "";
	var radioYears = document.getElementsByName("radioYear");
	for(var i=0; i < radioYears.length; i++){
		if(radioYears[i].checked){
			if(radioYears[i].value == "西元"){
				if(form1.adYear.selectedIndex > 0)dateDisplay = document.form1.adYear.options[form1.adYear.selectedIndex].text + "年";
				if(form1.month1.selectedIndex > 0)dateDisplay += document.form1.month1.options[form1.month1.selectedIndex].text + "月";
				if(form1.day1.selectedIndex > 0)dateDisplay += document.form1.day1.options[form1.day1.selectedIndex].text + "日";
							
				paramStr = "&day="+form1.day1.value
						+"&month="+form1.month1.value
						+"&year="+form1.adYear.value;
			}
			if(radioYears[i].value == "民國"){
				if(form1.twYear.selectedIndex > 0)dateDisplay = document.form1.twYear.options[form1.twYear.selectedIndex].text + "年";
				if(form1.month2.selectedIndex > 0)dateDisplay += document.form1.month2.options[form1.month2.selectedIndex].text + "月";
				if(form1.day2.selectedIndex > 0)dateDisplay += document.form1.day2.options[form1.day2.selectedIndex].text + "日";							
				
				paramStr = "&day="+form1.day2.value
						+"&month="+form1.month2.value
						+"&year="+form1.twYear.value;
			}
			if(radioYears[i].value == "農曆"){
				if(form1.lunarName.selectedIndex > 0)dateDisplay = document.form1.lunarName.options[form1.lunarName.selectedIndex].text + "年";
				if(form1.month3.selectedIndex > 0){
					if(form1.isLeap.checked){
						dateDisplay += "閏" + document.form1.month3.options[form1.month3.selectedIndex].text + "月";
					}
					else{
						dateDisplay += document.form1.month3.options[form1.month3.selectedIndex].text + "月";
					}
				}
				if(form1.day3.selectedIndex > 0)dateDisplay += document.form1.day3.options[form1.day3.selectedIndex].text + "日";
				
				if(form1.isLeap.checked){
					paramStr = "&day="+form1.day3.value
							+"&month=閏"+form1.month3.value
							+"&year="+form1.lunarName.value
							+"&isLunar=1";
				}
				else{
					paramStr = "&day="+form1.day3.value
							+"&month="+form1.month3.value
							+"&year="+form1.lunarName.value
							+"&isLunar=1";
				}
			}
			if(radioYears[i].value == "日本"){
				if(form1.jpYear.selectedIndex > 0)dateDisplay = document.form1.jpYear.options[form1.jpYear.selectedIndex].text + "年";
				if(form1.month4.selectedIndex > 0)dateDisplay += document.form1.month4.options[form1.month4.selectedIndex].text + "月";
				if(form1.day4.selectedIndex > 0)dateDisplay += document.form1.day4.options[form1.day4.selectedIndex].text + "日";
				
				paramStr = "&day="+form1.day4.value
						+"&month="+form1.month4.value
						+"&year="+form1.jpYear.value;
			}
			if(radioYears[i].value == "佛曆"){
				if(form1.thYear.selectedIndex > 0)dateDisplay = document.form1.thYear.options[form1.thYear.selectedIndex].text + "年";
				if(form1.month5.selectedIndex > 0)dateDisplay += document.form1.month5.options[form1.month5.selectedIndex].text + "月";
				if(form1.day5.selectedIndex > 0)dateDisplay += document.form1.day5.options[form1.day5.selectedIndex].text + "日";
				
				paramStr = "&day="+form1.day5.value
						+"&month="+form1.month5.value
						+"&year="+form1.thYear.value;
			}
			paramStr = paramStr + "&calendar=" + radioYears[i].value + "&display="+dateDisplay;
			break;
		}
	}
	
	var x = getRemoteData(getVirtualPath() + "/ajax/jsonBirthDay.jsp" ,paramStr);
	var returnObj = new Object();
	if (x!=null && x.length>0) {
		var json = eval('(' + x + ')');
		returnObj.calendar = json.calendar;
		returnObj.display = json.display;
		returnObj.ad = json.ad;
		
		window.returnValue = returnObj;
	}
	
	window.close();
	
}

function init(){}

function changeRadio(){
	document.getElementById("adYear").disabled = true;
	document.getElementById("month1").disabled = true;
	document.getElementById("day1").disabled = true;

	document.getElementById("twYear").disabled = true;
	document.getElementById("month2").disabled = true;
	document.getElementById("day2").disabled = true;

	document.getElementById("lunarName").disabled = true;	
	document.getElementById("isLeap").disabled = true;
	document.getElementById("month3").disabled = true;
	document.getElementById("day3").disabled = true;

	document.getElementById("jpYear").disabled = true;
	document.getElementById("month4").disabled = true;
	document.getElementById("day4").disabled = true;

	document.getElementById("thYear").disabled = true;
	document.getElementById("month5").disabled = true;
	document.getElementById("day5").disabled = true;
	
	var radioYears = document.getElementsByName("radioYear");
	for(var i=0; i < radioYears.length; i++){
		if(radioYears[i].checked){
			if(radioYears[i].value == "西元"){
				document.getElementById("adYear").disabled = false;
				document.getElementById("month1").disabled = false;
				document.getElementById("day1").disabled = false;
			}
			if(radioYears[i].value == "民國"){
				document.getElementById("twYear").disabled = false;
				document.getElementById("month2").disabled = false;
				document.getElementById("day2").disabled = false;
			}
			if(radioYears[i].value == "農曆"){
				document.getElementById("lunarName").disabled = false;	
				document.getElementById("isLeap").disabled = false;
				document.getElementById("month3").disabled = false;
				document.getElementById("day3").disabled = false;
			}
			if(radioYears[i].value == "日本"){
				document.getElementById("jpYear").disabled = false;
				document.getElementById("month4").disabled = false;
				document.getElementById("day4").disabled = false;
			}
			if(radioYears[i].value == "佛曆"){
				document.getElementById("thYear").disabled = false;
				document.getElementById("month5").disabled = false;
				document.getElementById("day5").disabled = false;
			}
			break;
		}
	}
}
</script>
</head>
<base target="_self">
<body onload="">
<form id="form1" name="form1" method="post" onSubmit="return checkField()">
<table width="100%" cellspacing="0" cellpadding="0">
<!--Form區============================================================-->
<tr><td class="bg" >
	<div id="formContainer" style="height:auto">
	<table class="table_form" width="100%" height="100%">	
	<tr>
		<td class="td_form_white">
		 	<input class="field_Q" type="radio" name="radioYear" value="西元" onClick="changeRadio()">西元
			<select class="field_Q"  name="adYear" style="width:100" disabled>
				<%=View.getOption("select adYear, adYear from CommonYearList order by id","")%>
			</select>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  	<select class="field_Q"  name="month1" style="width:100" disabled>
				<%=View.getTextOption("01;01;02;02;03;03;04;04;05;05;06;06;07;07;08;08;09;09;10;10;11;11;12;12;","",1)%>
			</select>月
		 	<select class="field_Q"  name="day1" style="width:100" disabled>
				<%=View.getTextOption("01;01;02;02;03;03;04;04;05;05;06;06;07;07;08;08;09;09;10;10;11;11;12;12;13;13;14;14;15;15;16;16;17;17;18;18;19;19;20;20;21;21;22;22;23;23;24;24;25;25;26;26;27;27;28;28;29;29;30;30;31;31;","",1)%>
			</select>日
		</td>
	</tr>
    <tr>		 
		<td class="td_form_white">		    
		    <input class="field_Q" type="radio" name="radioYear" value="民國" onClick="changeRadio()">民國
			<select class="field_Q"  name="twYear" style="width:100" disabled>
				<%=View.getOption("select adYear, twYear from CommonYearList order by id","")%>
			</select>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<select class="field_Q"  name="month2" style="width:100" disabled>
				<%=View.getTextOption("01;01;02;02;03;03;04;04;05;05;06;06;07;07;08;08;09;09;10;10;11;11;12;12;","",1)%>
			</select>月
			<select class="field_Q"  name="day2" style="width:100" disabled>
				<%=View.getTextOption("01;01;02;02;03;03;04;04;05;05;06;06;07;07;08;08;09;09;10;10;11;11;12;12;13;13;14;14;15;15;16;16;17;17;18;18;19;19;20;20;21;21;22;22;23;23;24;24;25;25;26;26;27;27;28;28;29;29;30;30;31;31;","",1)%>
			</select>日
		</td>
	</tr>
	<tr>		 
		<td class="td_form_white">
		    <input class="field_Q" type="radio" name="radioYear" value="農曆" onClick="changeRadio()">農曆
            <select class="field_Q" name="lunarName" style="width:100" disabled>
				<%=View.getOption("select twYear, twYear from CommonYearList order by id", "")%>				
			</select>年&nbsp;&nbsp;
			<input class="field" type="checkbox" name="isLeap" value="true" disabled>
				 閏月	
			<select class="field_Q" name="month3" style="width:100" disabled>
				<%=View.getTextOption("01;01;02;02;03;03;04;04;05;05;06;06;07;07;08;08;09;09;10;10;11;11;12;12;","")%>
			</select>月
			<select class="field_Q" name="day3" style="width:100" disabled>
				<%=View.getTextOption("01;01;02;02;03;03;04;04;05;05;06;06;07;07;08;08;09;09;10;10;11;11;12;12;13;13;14;14;15;15;16;16;17;17;18;18;19;19;20;20;21;21;22;22;23;23;24;24;25;25;26;26;27;27;28;28;29;29;30;30;31;31;","",1)%>
			</select>日
		</td>
	</tr>
	<tr>		 
		<td class="td_form_white">
		    <input class="field_Q" type="radio" name="radioYear" value="日本" onClick="changeRadio()">日本
			<select class="field_Q"  name="jpYear" style="width:100" disabled>
				<%=View.getOption("select adYear, jpYear from CommonYearList order by id", "")%>
			</select>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<select class="field_Q"  name="month4" style="width:100" disabled>
				<%=View.getTextOption("01;01;02;02;03;03;04;04;05;05;06;06;07;07;08;08;09;09;10;10;11;11;12;12;","",1)%>
			</select>月
			<select class="field_Q"  name="day4" style="width:100" disabled>
				<%=View.getTextOption("01;01;02;02;03;03;04;04;05;05;06;06;07;07;08;08;09;09;10;10;11;11;12;12;13;13;14;14;15;15;16;16;17;17;18;18;19;19;20;20;21;21;22;22;23;23;24;24;25;25;26;26;27;27;28;28;29;29;30;30;31;31;","",1)%>
			</select>日
		</td>
	</tr>
	<tr>		 
		<td class="td_form_white">		    
		    <input class="field_Q" type="radio" name="radioYear" value="佛曆" onClick="changeRadio()">佛曆
			<select class="field_Q"  name="thYear" style="width:100" disabled>
				<%=View.getOption("select adYear, thYear from CommonYearList order by id", "")%>
			</select>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;			
			<select class="field_Q"  name="month5" style="width:100" disabled>
				<%=View.getTextOption("01;01;02;02;03;03;04;04;05;05;06;06;07;07;08;08;09;09;10;10;11;11;12;12;","",1)%>
			</select>月			
			<select class="field_Q"  name="day5" style="width:100" disabled>
				<%=View.getTextOption("01;01;02;02;03;03;04;04;05;05;06;06;07;07;08;08;09;09;10;10;11;11;12;12;13;13;14;14;15;15;16;16;17;17;18;18;19;19;20;20;21;21;22;22;23;23;24;24;25;25;26;26;27;27;28;28;29;29;30;30;31;31;","",1)%>
			</select>日
		</td>
	</tr>
	</table>
	</div>
</td></tr>

<!--Toolbar區============================================================-->
<tr>
	<td class="bg" style="text-align:center">
		<input class="toolbar_default" type="submit" name="querySubmit" value="確     定">
		<input class="toolbar_default" type="button" name="queryCannel" value="取    消" onClick="window.close()">
	
    </td>
</tr>
</table>	
</form>
</body>
</html>
