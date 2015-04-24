<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../home/head.jsp" %>
<%
String jsonField = Common.get(request.getParameter("jsonField"));
%>
<%@ include file="../home/meta.jsp" %>
<script type="text/javascript" src="swfobject.js"></script>
<script type="text/javascript">
   // For version detection, set to min. required Flash Player version, or 0 (or 0.0.0), for no version detection. 
   var swfVersionStr = "10.2.0";
   // To use express install, set to playerProductInstall.swf, otherwise the empty string. 
   var xiSwfUrlStr = "playerProductInstall.swf";
   var flashvars = {};
   var params = {};
   params.quality = "high";
   params.bgcolor = "#ffffff";
   params.allowscriptaccess = "sameDomain";
   params.allowfullscreen = "true";
   var attributes = {};
   attributes.id = "Workflow";
   attributes.name = "Workflow";
   attributes.align = "middle";
   swfobject.embedSWF(
       "Workflow.swf", "flashContent", 
       "100%", "100%", 
       swfVersionStr, xiSwfUrlStr, 
       flashvars, params, attributes);
   // JavaScript enabled so display the flashContent div in case it is not replaced with a swf object.
   swfobject.createCSS("#flashContent", "display:block;text-align:left;");
</script>
<script type="text/javascript">
function init(){

}
function setSwfIsReady(isReady){
	if("Y" == isReady){
		var jsonElement = opener.document.all.item("<%=jsonField%>");
		if (isObj(jsonElement) && "" != jsonElement.value) {
			var jsonString = jsonElement.value;
			try {
				form1.Workflow.loadJsonString(jsonString);	
			} catch(ex){
				alert(ex.message);
			}
		}
	}
}
//node double click event
//載入點擊的節點
function queryOne(framePathId){
	if("" != framePathId){
		var q = "1&framePathId=" + framePathId;
		var x = getRemoteData(getVirtualPath() + "ajax/jsonFramePath.jsp",q);
		if(null!=x && 0 < x.length){
			var jsonElement = document.all.item("jsonString");
			jsonElement.value = x;
			form1.Workflow.loadJsonString(x);
		}		
	}
}
</script>
<body topmargin="5"  onLoad="init();">
<form id="form1" name="form1" method="post" autocomplete="off" >
       <div id="flashContent">
           <p>
               To view this page ensure that Adobe Flash Player version 
               10.2.0 or greater is installed. 
           </p>
           <script type="text/javascript"> 
               var pageHost = ((document.location.protocol == "https:") ? "https://" : "http://"); 
               document.write("<a href='http://www.adobe.com/go/getflashplayer'><img src='" 
                               + pageHost + "www.adobe.com/images/shared/download_buttons/get_flash_player.gif' alt='Get Adobe Flash player' /></a>" ); 
           </script> 
       </div>
       
       <noscript>
           <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="100%" height="100%" id="Workflow">
               <param name="movie" value="Workflow.swf" />
               <param name="quality" value="high" />
               <param name="bgcolor" value="#ffffff" />
               <param name="allowScriptAccess" value="sameDomain" />
               <param name="allowFullScreen" value="true" />
               <!--[if !IE]>-->
               <object type="application/x-shockwave-flash" data="Workflow.swf" width="100%" height="100%">
                   <param name="quality" value="high" />
                   <param name="bgcolor" value="#ffffff" />
                   <param name="allowScriptAccess" value="sameDomain" />
                   <param name="allowFullScreen" value="true" />
               <!--<![endif]-->
               <!--[if gte IE 6]>-->
                   <p> 
                       Either scripts and active content are not permitted to run or Adobe Flash Player version
                       10.2.0 or greater is not installed.
                   </p>
               <!--<![endif]-->
                   <a href="http://www.adobe.com/go/getflashplayer">
                       <img src="http://www.adobe.com/images/shared/download_buttons/get_flash_player.gif" alt="Get Adobe Flash Player" />
                   </a>
               <!--[if !IE]>-->
               </object>
               <!--<![endif]-->
           </object>
       </noscript>     
	<input type="hidden" name="jsonField" value="<%=jsonField%>">
	<input type="hidden" name="jsonString" value="">
</form>
</body>