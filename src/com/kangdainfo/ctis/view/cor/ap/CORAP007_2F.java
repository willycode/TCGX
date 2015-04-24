package com.kangdainfo.ctis.view.cor.ap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.kangdainfo.ServiceGetter;
import com.kangdainfo.common.util.Common;
import com.kangdainfo.common.util.SuperBean;
import com.kangdainfo.ctis.model.bo.CtMemberInfo;

public class CORAP007_2F extends SuperBean {
	private String ctMemberId = "103000004";  //測試資料
	private String aliasName = "郭景達";		  //測試資料
	private String q_centerMemberId;
	private String unitId;
	private String q_refugePlace;
	private String q_ctMemberId;
	private String q_aliasName;
	
	@Override
	public ArrayList doQueryAll() throws Exception {
		java.util.ArrayList<String[]> arrList = new java.util.ArrayList<String[]>();		
		StringBuffer hql = new StringBuffer().append("from CtMemberInfo where 1=1");
		//System.out.println("CORAP007F 查詢語法  == " + hql.toString());
		
		this.processCurrentPageAttribute(ServiceGetter.getInstance().getCommonService().loadCount(hql.toString()));
		if(getTotalRecord() > 0){
			if(getState().indexOf("query") < 0){
				ServiceGetter.getInstance().getCommonService().clear();
			}
			
			java.util.List objList = ServiceGetter.getInstance().getCommonService().load(hql.toString() + "order by id",this.getRecordStart(),this.getPageSize());
			if(objList != null && objList.size() > 0){
				for(Object obj : objList){
					CtMemberInfo o = (CtMemberInfo)obj;
					String[] rowArray = new String[6];
					rowArray[0] = Common.get(o.getCtMemberId());
					rowArray[1] = Common.get(o.getAliasName());
				}
			}			
		}
		return arrList;
	}
	
	public java.util.ArrayList<String[]> doQueryAll_corap007_2f(String unitId) throws Exception {
        java.util.ArrayList<String[]> arrList = new java.util.ArrayList<String[]>();
        Map<String, Object> maps = new HashMap<String, Object>();
        StringBuffer sb = new StringBuffer();
        //精舍                               精舍學員編號          學員
        //refugePlace  ctMemberId aliasName
        //select id, refugePlace, ctMemberId, aliasName from CT_MEMBER_INFO
        sb.append("Select id, refugePlace, ctMemberId, aliasName");
        sb.append(" From CtMemberInfo Where 1=1");     
//==================================================================        
//        sb.append("Select id, centerMemberId, aliasName");
//        sb.append(" From CenterMemberInfo Where 1=1");
//        if (!"".equals(unitId)) {
//            sb.append(" and unitId = :unitId");
//            maps.put("unitId", unitId);
//        }
//        if (!"".equals(getQ_centerMemberId())) {
//            sb.append(" and centerMemberId = :centerMemberId");
//            maps.put("centerMemberId", q_centerMemberId);
//        }
//        if (!"".equals(getQ_aliasName())) {
//            sb.append(" and aliasName like :aliasName");
//            maps.put("aliasName", "%" + q_aliasName + "%");
//        }
//        sb.append(" Order by centerMemberId");
//====================================================================        
        System.out.println("corap007_2f 查詢 == " + sb.toString());
        java.util.List objList = ServiceGetter.getInstance().getCommonService().load(sb.toString(), maps);
        this.processCurrentPageAttribute(objList != null ? objList.size() : 0);
        if (getTotalRecord() > 0) {
            if (getState().indexOf("query") < 0)
                ServiceGetter.getInstance().getCommonService().clear();
            objList = ServiceGetter.getInstance().getCommonService().load(sb.toString(), this.getRecordStart(), this.getPageSize(), maps);
            if (objList != null && objList.size() > 0) {
                for (Object obj : objList) {
                    Object[] o = (Object[])obj;
                    String rowArray[] = new String[o.length];
                    rowArray[0] = Common.get(o[0]); // id
                    rowArray[1] = Common.get(o[1]); // 
                    rowArray[2] = Common.get(o[2]); //
                    rowArray[3] = Common.get(o[3]); // 
                    arrList.add(rowArray);
                }
            }
        }
        return arrList;
    }

	@Override
	public Object doQueryOne() throws Exception {
		return null;
	}
	
	@Override
	public void doCreate() throws Exception {}

	@Override
	public void doUpdate() throws Exception {}

	@Override
	public void doDelete() throws Exception {}

	public String getCtMemberId() {return checkGet(ctMemberId);}
	public void setCtMemberId(String ctMemberId) {this.ctMemberId = checkSet(ctMemberId);}
	public String getAliasName() {return checkGet(aliasName);}
	public void setAliasName(String aliasName) {this.aliasName = checkSet(aliasName);}
	
	public String getQ_centerMemberId() {
		return checkGet(q_centerMemberId);
	}

	public void setQ_centerMemberId(String qCenterMemberId) {
		q_centerMemberId = checkSet(qCenterMemberId);
	}

	public String getUnitId() {
		return checkGet(unitId);
	}

	public void setUnitId(String unitId) {
		unitId = checkSet(unitId);
	}
	
	public String getQ_refugePlace() {
		return checkGet(q_refugePlace);
	}

	public void setQ_refugePlace(String q_refugePlace) {
		q_refugePlace = checkSet(q_refugePlace);
	}

	public String getQ_ctMemberId() {
		return checkGet(q_ctMemberId);
	}

	public void setQ_ctMemberId(String q_ctMemberId) {
		q_ctMemberId = checkSet(q_ctMemberId);
	}

	public String getQ_aliasName() {
		return checkGet(q_aliasName);
	}

	public void setQ_aliasName(String qAliasName) {
		q_aliasName = checkSet(qAliasName);
	}
}