package com.kangdainfo.common.view.sys.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.kangdainfo.ServiceGetter;
import com.kangdainfo.common.model.bo.CommonGroup;
import com.kangdainfo.common.model.bo.CommonUserGroupTransLog;
import com.kangdainfo.common.util.Common;
import com.kangdainfo.common.util.Datetime;
import com.kangdainfo.common.util.SuperBean;

public class SYSDS806R extends SuperBean {
	private String id;
	
	private String q_begTransferDate;
	private String q_endTransferDate;
	private String q_unitId;
	private String q_rolesOwnerId;
	private String q_rolesRecipientId;

	@Override
	public ArrayList doQueryAll() throws Exception {
		java.util.ArrayList<String[]> arrList = new java.util.ArrayList<String[]>();
		Map<String, Object> maps = new HashMap<String, Object>();
		
		StringBuffer hql = new StringBuffer();
		hql.append("from CommonUserGroupTransLog where 1=1");
		
		if(!"".equals(getQ_begTransferDate())){			
			hql.append(" and transferDate >= :a");
			maps.put("a", q_begTransferDate);
		}
		
		if(!"".equals(getQ_endTransferDate())){
			hql.append(" and transferDate <= :b");
			maps.put("b", q_endTransferDate);
		}
		
		if(!"".equals(getQ_unitId())){
			hql.append(" and unitId = :unitId");
			maps.put("unitId", q_unitId);
		}
		
		if(!"".equals(getQ_rolesOwnerId())){
			hql.append(" and rolesOwnerId = :rolesOwnerId");
			maps.put("rolesOwnerId", q_rolesOwnerId);
		}
		
		if(!"".equals(getQ_rolesRecipientId())){
			hql.append(" and rolesRecipientId = :rolesRecipientId");
			maps.put("rolesRecipientId", q_rolesRecipientId);
		}

		this.processCurrentPageAttribute(ServiceGetter.getInstance().getCommonService().loadCount(hql.toString(), maps));
		if(getTotalRecord() > 0){
			if(getState().indexOf("query") < 0){
				ServiceGetter.getInstance().getCommonService().clear();
			}
			
			hql.append(" order by transferDate,transferTime desc");
			System.out.println("SYSDS806R查詢條件 == " + hql.toString());
			
			java.util.List objList = ServiceGetter.getInstance().getCommonService().load(hql.toString(), this.getRecordStart(), this.getPageSize(), maps);
			if(objList != null && objList.size() > 0){
				
				java.util.List roleList = ServiceGetter.getInstance().getCommonService().load("from CommonGroup");
				java.util.Map<String, String> roleMap = new java.util.HashMap<String, String>();
				if(roleList != null && roleList.size() > 0){	
					for(Object role : roleList){
						CommonGroup r = (CommonGroup)role;
						roleMap.put(r.getId().toString(), r.getGroupName());
					}
				}
				
				for(Object obj : objList){
					CommonUserGroupTransLog o = (CommonUserGroupTransLog)obj;
					String[] rowArray = new String[8];
					rowArray[0] = Common.get(o.getId());
					rowArray[1] = Common.get(o.getUnitShortName());
					rowArray[2] = Common.get(o.getRolesOwnerName());
					rowArray[3] = Common.get(Datetime.formatDateYYYMMDD(o.getTransferDate()) + " " + Datetime.formatTimeHHMMSS(o.getTransferTime()));
					
					String roleName = "";
					String[] roleArray = Common.get(o.getRoles()).split(",");
					for(String roleStr : roleArray){
						if("".equals(roleName)){
							roleName += roleMap.get(roleStr);
						}
						else{
							roleName += "、" + roleMap.get(roleStr);
						}
					}
					rowArray[4] = Common.get(roleName);
					
					rowArray[5] = Common.get(o.getRolesRecipientName());					
					arrList.add(rowArray);
				}
			}
		}
		return arrList;
	}

	@Override
	public Object doQueryOne() throws Exception {
		// TODO Auto-generated method stub
		return null;
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
	public void doUpdate() throws Exception {
		// TODO Auto-generated method stub

	}

	public String getId() {
		return checkGet(id);
	}

	public void setId(String id) {
		this.id = checkSet(id);
	}

	public String getQ_begTransferDate() {
		return checkGet(q_begTransferDate);
	}

	public void setQ_begTransferDate(String qBegTransferDate) {
		q_begTransferDate = checkSet(qBegTransferDate);
	}

	public String getQ_endTransferDate() {
		return checkGet(q_endTransferDate);
	}

	public void setQ_endTransferDate(String qEndTransferDate) {
		q_endTransferDate = checkSet(qEndTransferDate);
	}



	public String getQ_unitId() {
		return checkGet(q_unitId);
	}

	public void setQ_unitId(String q_unitId) {
		this.q_unitId = checkSet(q_unitId);
	}

	public String getQ_rolesOwnerId() {
		return checkGet(q_rolesOwnerId);
	}

	public void setQ_rolesOwnerId(String qRolesOwnerId) {
		q_rolesOwnerId = checkSet(qRolesOwnerId);
	}

	public String getQ_rolesRecipientId() {
		return checkGet(q_rolesRecipientId);
	}

	public void setQ_rolesRecipientId(String qRolesRecipientId) {
		q_rolesRecipientId = checkSet(qRolesRecipientId);
	}

	
}
