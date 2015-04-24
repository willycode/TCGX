package com.kangdainfo.common.view.sys.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.kangdainfo.ServiceGetter;
import com.kangdainfo.common.util.Common;
import com.kangdainfo.common.util.SuperBean;

public class SYSDS803R extends SuperBean {
	private String id;
	
	private String q_begTriggerDate;
	private String q_endTriggerDate;
	private String q_centerId;
	private String q_isGroupCenterId;
	
	@Override
	public ArrayList doQueryAll() throws Exception {
		java.util.ArrayList<String[]> arrList = new java.util.ArrayList<String[]>();
		Map<String, Object> maps = new HashMap<String, Object>();
		
		StringBuffer hql = new StringBuffer();
		//依精舍統計 有勾選
		if("Y".equals(getQ_isGroupCenterId())){
			hql.append("select centerId,dtreeId,count(centerId) as ct_centerId");
		}
		else{
			hql.append("select dtreeId,count(dtreeId) as ct_dtreeId");
		}		
		hql.append(" from CommonVisitLogFunction where 1=1");
		
		if(!"".equals(getQ_begTriggerDate())){			
			hql.append(" and triggerDate >= :a");
			maps.put("a", q_begTriggerDate);			
		}
		
		if(!"".equals(getQ_endTriggerDate())){			
			hql.append(" and triggerDate <= :b");
			maps.put("b", q_endTriggerDate);
		}
		
		if(!"".equals(getQ_centerId())){
			hql.append(" and centerId = :centerId");
			maps.put("centerId", q_centerId);
		}
		
		//依精舍統計 有勾選
		if("Y".equals(getQ_isGroupCenterId())){
			hql.append(" group by centerId,dtreeId");
		}
		else{
			hql.append(" group by dtreeId");
		}
		
		System.out.println("SYSDS803R查詢條件 == " + hql.toString());
		System.out.println("maps = " + maps);
		
		java.util.List objList = ServiceGetter.getInstance().getCommonService().load(hql.toString(), maps);
		this.processCurrentPageAttribute(objList != null ? objList.size() : 0);
		if(getTotalRecord() > 0){
			if(getState().indexOf("query") < 0){
				ServiceGetter.getInstance().getCommonService().clear();
			}
			
			objList = ServiceGetter.getInstance().getCommonService().load(hql.toString(), this.getRecordStart(), this.getPageSize(), maps);
			if(objList != null && objList.size() > 0){
				for(Object obj : objList){
					Object[] o = (Object[])obj;
					//依精舍統計 有勾選
					if("Y".equals(getQ_isGroupCenterId())){
						String[] rowArray = new String[3];
						rowArray[0] = Common.get(o[0]); //centerId
						rowArray[1] = Common.get(o[1]);	//dtreeId
						rowArray[2] = Common.get(o[2]); //count(centerId)
						arrList.add(rowArray);
					}
					else{
						String[] rowArray = new String[2];
						rowArray[0] = Common.get(o[0]);	//dtreeId
						rowArray[1] = Common.get(o[1]); //count(dtreeId)
						arrList.add(rowArray);
					}					
				}
			}
		}
		return arrList;
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
	public Object doQueryOne() throws Exception {
		// TODO Auto-generated method stub
		return null;
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

	public String getQ_begTriggerDate() {
		return checkGet(q_begTriggerDate);
	}

	public void setQ_begTriggerDate(String qBegTriggerDate) {
		q_begTriggerDate = checkSet(qBegTriggerDate);
	}

	public String getQ_endTriggerDate() {
		return checkGet(q_endTriggerDate);
	}

	public void setQ_endTriggerDate(String qEndTriggerDate) {
		q_endTriggerDate = checkSet(qEndTriggerDate);
	}

	public String getQ_centerId() {
		return checkGet(q_centerId);
	}

	public void setQ_centerId(String qCenterId) {
		q_centerId = checkSet(qCenterId);
	}

	public String getQ_isGroupCenterId() {
		return checkGet(q_isGroupCenterId);
	}

	public void setQ_isGroupCenterId(String qIsGroupCenterId) {
		q_isGroupCenterId = checkSet(qIsGroupCenterId);
	}
	
}
