<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.kangdainfo.common.util.*" %>
<script type="text/javascript">
function toArray(ivForm){  
	var parms = {};
	for(var i in ivForm){
		if(!ivForm[i].name){
			
		}else{
			if(typeof (parms[ivForm[i].name]) == 'undefined'){
				parms[ivForm[i].name] = ivForm[i].value; 
			}else{
				parms[ivForm[i].name] += "," + ivForm[i].value;
			}
		}
	} 
	return parms; 
}
var ivData;
function ajaxGet(className,methodName,parms){	
	var data = toArray($('form').serializeArray()); 
	if (typeof parms !='undefined'){
		for (var prop in parms) { 
			data[prop] = parms[prop];
		} 
	}		
   	var jsonData = JSON.stringify(data);
	$.ajax({type:"POST",
		    url:'<%=Common.getCurrentContextPath()%>/home/ajaxGetUtil.jsp?className='+className + '&methodName=' + methodName,
		    contentType:"application/json; charset=utf-8",
		    dataType:'json', //返回純文字;
		    cache:false,
		    async:false,
		    data:jsonData, //要傳遞的數據
		    beforeSend:function(){},
		    success:function(data){
		    	ivData = data;
		    },
		    error:function(xhr, textStatus, thrownError){
		    	alert(thrownError);
		    },
		    complete:function(){}
		  });
	
	return ivData;
	
}
</script>