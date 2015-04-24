package com.kangdainfo.ctis.view.cor.ap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.kangdainfo.ServiceGetter;
import com.kangdainfo.common.util.Common;
import com.kangdainfo.common.util.SuperBean;
import com.kangdainfo.ctis.model.bo.CtMemberInfo;

public class CORAP007F extends SuperBean {
	private String ctMemberId = "103000004";  //測試資料
	private String aliasName = "郭景達";		  //測試資料
	String fds[];                             //取corap007_1f.jsp前端checkbox値

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
	
	public java.util.ArrayList<String[]> doQueryAll_corap007_1f(String unitId) throws Exception {
        java.util.ArrayList<String[]> arrList = new java.util.ArrayList<String[]>();
        Map<String, Object> maps = new HashMap<String, Object>();
        StringBuffer sb = new StringBuffer();
        sb.append("Select id, ctMemberIdS, ctMemberIdS, appellationNameS, appellationIdS, appellationIdM");
        sb.append(" From CtFamilyList Where 1=1");
        
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
        System.out.println("corap007_1f 查詢 == " + sb.toString());
        
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
                    rowArray[0] = Common.get(o[0]); // 
                    rowArray[1] = Common.get(o[1]); // 
                    rowArray[2] = Common.get(o[2]); // 
                    rowArray[3] = Common.get(o[3]); // 
                    rowArray[4] = Common.get(o[4]); //
                    rowArray[5] = Common.get(o[5]); // 
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
	public String[] getFds(){return fds;}
	public void setFds(String[] s){ fds = s;}
	
}