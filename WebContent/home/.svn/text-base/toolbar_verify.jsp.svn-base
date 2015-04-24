<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="head.jsp" %>
<%
String progID = Common.get(request.getParameter("progID"));
String authBit = "";
if (User==null || UserRole==null) {
	return;
} else {
	if (UserRole.isUserLevel()) {		
		int auth = 1;		
		if ("".equals(progID)){
			auth = Common.getInt(session.getAttribute("PAU"));
			if (auth==0) auth = 1;
		} else {
			if (User.getPermissionMap()!=null && User.getPermissionMap().size()>0 && Common.getLong(progID)>0) {	
				CommonDtree dt = ServiceGetter.getInstance().getMyServletContext().getFunctionMap().get(progID);
				if (dt==null) {
					dt = (CommonDtree) ServiceGetter.getInstance().getCommonService().getCommonDtreeDao().getNode(Common.getLong(progID));
					if (dt!=null) {
						ServiceGetter.getInstance().getMyServletContext().getFunctionMap().put(dt.getId().toString(), dt);
					}
				}
				if (dt!=null && !"".equals(Common.get(dt.getBtnRead()))) {
					Object[] o = User.getPermissionMap().get(Common.get(dt.getBtnRead()));
					if (o!=null) {
						auth = Common.getInt(o[0]);
					}
				}
			}			
		}		
		authBit = String.valueOf(auth);
	}
}
%>
<input type='hidden' name='permissionField' value='<%=authBit%>'>
<span id="spanToolbar">&nbsp;|
<span id="spanQueryAll" <%if("N".equalsIgnoreCase(Common.get(request.getParameter("btnQueryAll")))){ out.print("style=\"display:none;\""); }%>>
<input class="toolbar_default" type="button" followPK="false" name="queryAll" value="查　詢" onClick="whatButtonFireEvent(this.name);">&nbsp;|
</span>
<span id="spanApprove1" <%if("N".equalsIgnoreCase(Common.get(request.getParameter("btnApprove1")))){ out.print("style=\"display:none;\""); }%>>
<input class="toolbar_default" type="button" followPK="false" name="approve1" value="審核通過" onClick="doApproveProcess(1)">&nbsp;|
</span>
<span id="spanApprove2"  <%if("N".equalsIgnoreCase(Common.get(request.getParameter("btnApprove2")))){ out.print("style=\"display:none;\""); }%>>
<input class="toolbar_default" type="button" followPK="false" name="approve2" value="取消審核" onClick="doApproveProcess(2)">&nbsp;|
</span>
<span id="spanApprove3"  <%if("N".equalsIgnoreCase(Common.get(request.getParameter("btnApprove3")))){ out.print("style=\"display:none;\""); }%>>
<input class="toolbar_default" type="button" followPK="false" name="approve3" value="審核不通過" onClick="doApproveProcess(3)">&nbsp;|
</span>
</span>