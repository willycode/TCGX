package com.kangdainfo.common.view.sys.ap;

import java.util.ArrayList;

import com.kangdainfo.ServiceGetter;
import com.kangdainfo.common.model.bo.CommonUser;
import com.kangdainfo.common.model.bo.CommonUserGroup;
import com.kangdainfo.common.model.bo.CommonUserGroupTransLog;
import com.kangdainfo.common.util.Common;
import com.kangdainfo.common.util.SuperBean;
import com.kangdainfo.common.util.View;

public class SYSAP010F extends SuperBean {
	private String id;
	
	private String transferDate;
	private String transferTime;
	private String unitId;
	private String unitShortName;
	private String rolesOwnerId;		//職務交接帳號
	private String rolesOwnerName;		//職務交接名稱
	private String rolesRecipientId;	//職務接收帳號
	private String rolesRecipientName;	//職務接收名稱
	private String[] roles;
	
	@Override
	public Object doQueryOne() throws Exception {
		SYSAP010F obj = this;
		CommonUserGroupTransLog c = (CommonUserGroupTransLog)View.getObject("from CommonUserGroupTransLog where rolesOwnerId = " + Common.sqlChar(getRolesOwnerId()));
		if(c != null){
			obj.setId(Common.get(c.getId()));
			obj.setUnitId(Common.get(c.getUnitId()));
			obj.setUnitShortName(Common.get(c.getUnitShortName()));
//			obj.setRolesOwnerId(Common.get(c.getRolesOwnerId()));
//			obj.setRolesOwnerName(Common.get(c.getRolesOwnerName()));
			obj.setRolesRecipientId(Common.get(c.getRolesRecipientId()));
			obj.setRolesRecipientName(Common.get(c.getRolesRecipientName()));
			obj.setRoles(Common.get(c.getRoles()).split(","));
		}
		return obj;
	}

	@Override
	public void doUpdate() throws Exception {

		System.out.println("SYSAP010F doUpdate == 新增...");
		CommonUserGroupTransLog	obj = new CommonUserGroupTransLog();
		obj.setTransferDate(updateDate);
		obj.setTransferTime(updateTime);
		obj.setUnitId(unitId);
		obj.setUnitShortName(unitShortName);
		obj.setRolesOwnerId(rolesOwnerId);
		obj.setRolesOwnerName(rolesOwnerName);
		obj.setRolesRecipientId(rolesRecipientId);
		obj.setRolesRecipientName(rolesRecipientName);
		
		String roleStr = "";
		for(String str : roles){
			if("".equals(roleStr)){
				roleStr += str;
			}
			else{
				roleStr += "," + str;
			}
		}
		obj.setRoles(roleStr);
		obj.setCreateId(createId);
		obj.setCreateDate(createDate);
		obj.setCreateTime(createTime);
		obj.setUpdateId(updateId);
		obj.setUpdateIp(updateIp);
		obj.setUpdateDate(updateDate);
		obj.setUpdateTime(updateTime);
		obj.setUpdateUnitShortName(updateUnitShortName);
		ServiceGetter.getInstance().getCommonService().save(obj);
		setId(Common.get(obj.getId()));
		
		CommonUser b = (CommonUser)View.getObject("from CommonUser where userId ="+Common.sqlChar(rolesRecipientId));
		for (int i=0;i<roles.length;i++)
		{
			CommonUserGroup cug = (CommonUserGroup)View.getObject("from CommonUserGroup where commonUser.userId="+Common.sqlChar(rolesOwnerId)+" and commonGroup.id="+roles[i]);
			
			System.out.println(roles[i]);
			
			cug.setCommonUser(b);
			cug.setCommonGroup(cug.getCommonGroup());
			cug.setUpdateId(updateId);
			cug.setUpdateIp(updateIp);
			cug.setUpdateDate(updateDate);
			cug.setUpdateTime(updateTime);
			cug.setUpdateUnitShortName(updateUnitShortName);
			ServiceGetter.getInstance().getCommonService().update(cug);
		
		
		
		
		
		
		
		}
		
	}
	
	@Override
	public void doCreate() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void doDelete() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList doQueryAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String getId() {
		return checkGet(id);
	}

	public void setId(String id) {
		this.id = checkSet(id);
	}

	public String getTransferDate() {
		return checkGet(transferDate);
	}

	public void setTransferDate(String transferDate) {
		this.transferDate = checkSet(transferDate);
	}

	public String getTransferTime() {
		return checkGet(transferTime);
	}

	public void setTransferTime(String transferTime) {
		this.transferTime = checkSet(transferTime);
	}

	

	public String getUnitId() {
		return checkGet(unitId);
	}

	public void setUnitId(String unitId) {
		this.unitId = checkSet(unitId);
	}

	public String getUnitShortName() {
		return checkGet(unitShortName);
	}

	public void setUnitShortName(String unitShortName) {
		this.unitShortName = checkSet(unitShortName);
	}

	public String getRolesOwnerId() {
		return checkGet(rolesOwnerId);
	}

	public void setRolesOwnerId(String rolesOwnerId) {
		this.rolesOwnerId = checkSet(rolesOwnerId);
	}

	public String getRolesOwnerName() {
		return checkGet(rolesOwnerName);
	}

	public void setRolesOwnerName(String rolesOwnerName) {
		this.rolesOwnerName = checkSet(rolesOwnerName);
	}

	public String getRolesRecipientId() {
		return checkGet(rolesRecipientId);
	}

	public void setRolesRecipientId(String rolesRecipientId) {
		this.rolesRecipientId = checkSet(rolesRecipientId);
	}

	public String getRolesRecipientName() {
		return checkGet(rolesRecipientName);
	}

	public void setRolesRecipientName(String rolesRecipientName) {
		this.rolesRecipientName = checkSet(rolesRecipientName);
	}

	public String[] getRoles() {
		return roles;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}
	
	

}
