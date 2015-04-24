<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="head.jsp" %>
<%
	com.kangdainfo.common.util.SuperBean objBean = (com.kangdainfo.common.util.SuperBean)request.getAttribute("objBean");
%>
<fmt:bundle basename="ApplicationResources">
<fmt:message key="update"/>:[
<input class="field_RO" type="text" name="updateUnitShortName" size="10" value="<%= objBean.getUpdateUnitShortName()%>">
/
<input class="field_RO" type="text" name="updateId" size="5" value="<%= objBean.getUpdateId()%>">
/
<input class="field_RO" type="text" name="updateDate" size="5" value="<%= objBean.getUpdateDate()%>">
(
<input class="field_RO" type="text" name="updateIp" size="10" value="<%= objBean.getUpdateIp()%>">
)]&nbsp;<fmt:message key="create"/>:[
<input class="field_RO" type="text" name="createId" size="5" value="<%= objBean.getCreateId()%>">
/
<input class="field_RO" type="text" name="createDate" size="5" value="<%= objBean.getCreateDate()%>">
]
<input class="field_RO" type="hidden" name="createTime" size="5" value="<%= objBean.getCreateTime()%>">
<input class="field_RO" type="hidden" name="updateTime" size="5" value="<%= objBean.getUpdateTime()%>">
</fmt:bundle>