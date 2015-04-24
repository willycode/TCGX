package com.kangdainfo.common.view.sys.ap;

import com.kangdainfo.ServiceGetter;
import com.kangdainfo.common.model.bo.CommonConfig;
import com.kangdainfo.common.model.bo.CommonUser;
import com.kangdainfo.common.util.Common;
import com.kangdainfo.common.util.SuperBean;
import com.kangdainfo.persistence.hibernate4.query.params.QueryParam;
import com.kangdainfo.persistence.hibernate4.query.params.QueryParams;

public class SYSAP100F extends SuperBean{
	
	String id;
	String field1;
	String field2;
	String field3;
	String field4;
	String field5;
	String field6;
	String field7;
	String field8;
	String field9;
	String field10;
	String field11;
	String field12;
	String editIp;
	
	String q_id;
	
	public String getField1(){ return checkGet(field1); }
	public void setField1(String s){ field1=checkSet(s); }
	public String getField2(){ return checkGet(field2); }
	public void setField2(String s){ field2=checkSet(s); }
	public String getField3(){ return checkGet(field3); }
	public void setField3(String s){ field3=checkSet(s); }
	public String getField4(){ return checkGet(field4); }
	public void setField4(String s){ field4=checkSet(s); }
	public String getField5(){ return checkGet(field5); }
	public void setField5(String s){ field5=checkSet(s); }
	public String getField6(){ return checkGet(field6); }
	public void setField6(String s){ field6=checkSet(s); }
	public String getField7(){ return checkGet(field7); }
	public void setField7(String s){ field7=checkSet(s); }
	public String getField8(){ return checkGet(field8); }
	public void setField8(String s){ field8=checkSet(s); }
	public String getField9(){ return checkGet(field9); }
	public void setField9(String s){ field9=checkSet(s); }
	public String getField10(){ return checkGet(field10); }
	public void setField10(String s){ field10=checkSet(s); }
	public String getField11(){ return checkGet(field11); }
	public void setField11(String s){ field11=checkSet(s); }
	public String getField12(){ return checkGet(field12); }
	public void setField12(String s){ field12=checkSet(s); }
	public String getEditIp() {	return checkGet(editIp);}
	public void setEditIp(String editIp) {this.editIp = checkSet(editIp);}
	
	public String getId() {	return checkGet(id);	}
	public void setId(String id) {this.id = checkSet(id);	}	
	public String getQ_id() {return checkGet(q_id);	}
	public void setQ_id(String s) {q_id = checkSet(s);	}
	
	public void doCreate() throws Exception {
		CommonUser u = ServiceGetter.getInstance().getAuthenticationService().getCurrentUser();
		if (u!=null && !"".equals(getId()) && getId().length()<20) {
			this.setEditID(u.getUserId());
			
			CommonConfig obj = new CommonConfig();
			obj.setId(id);
			obj.setField1(field1);
			obj.setField2(field2);
			obj.setField3(field3);
			obj.setField4(field4);
			obj.setField5(field5);
			obj.setField6(field6);
			obj.setField7(field7);
			obj.setField8(field8);
			obj.setField9(field9);
			obj.setField10(field10);
			obj.setField11(field11);
			obj.setField12(field12);

			obj.setCreateId(createId);
			obj.setCreateDate(createDate);
			obj.setCreateTime(createTime);
			obj.setUpdateId(updateId);
		    obj.setUpdateDate(updateDate);
			obj.setUpdateTime(updateTime);
			obj.setUpdateIp(updateIp);
			obj.setUpdateUnitShortName(updateUnitShortName);
			
			ServiceGetter.getInstance().getCommonService().save(obj);			
		}
	}


	public void doUpdate() throws Exception {
		CommonUser u = ServiceGetter.getInstance().getAuthenticationService().getCurrentUser();		
		CommonConfig obj = (CommonConfig) ServiceGetter.getInstance().getCommonService().load(CommonConfig.class, getId());
		if (obj!=null) {
			obj.setField1(field1);
			obj.setField2(field2);
			obj.setField3(field3);
			obj.setField4(field4);
			obj.setField5(field5);
			obj.setField6(field6);
			obj.setField7(field7);
			obj.setField8(field8);
			obj.setField9(field9);
			obj.setField10(field10);
			obj.setField11(field11);
			obj.setField12(field12);
			if (u!=null) obj.setUserId(u.getUserId());
			
			obj.setUpdateId(updateId);
		    obj.setUpdateDate(updateDate);
			obj.setUpdateTime(updateTime);
			obj.setUpdateIp(updateIp);
			obj.setUpdateUnitShortName(updateUnitShortName);
			
			ServiceGetter.getInstance().getCommonService().update(obj);				
		} else {
			doCreate();
		}
	}


	public void doDelete() throws Exception {
		//
	}


	/**
	 * <br>
	 * <br>目的：依主鍵查詢單一資料
	 * <br>參數：無
	 * <br>傳回：傳回本物件
	*/
	public SYSAP100F doQueryOne() throws Exception {
		SYSAP100F obj = this;
		CommonConfig c = (CommonConfig) ServiceGetter.getInstance().getCommonService().load(CommonConfig.class, getId());
		if (c!=null) {
	        obj.setId(c.getId());
	        obj.setField1(c.getField1());
	        obj.setField2(c.getField2());
	        obj.setField3(c.getField3());
	        obj.setField4(c.getField4());
	        obj.setField5(c.getField5());
	        obj.setField6(c.getField6());
	        obj.setField7(c.getField7());
	        obj.setField8(c.getField8());
	        obj.setField9(c.getField9());
	        obj.setField10(c.getField10());
	        obj.setField11(c.getField11());
	        obj.setField12(c.getField12());
	        obj.setEditID(c.getUserId());
	        obj.setEditDate(c.getModDate());
	        obj.setEditTime(c.getModTime());
		}
		return obj;
	}


	/**
	 * <br>
	 * <br>目的：依查詢欄位查詢多筆資料
	 * <br>參數：無
	 * <br>傳回：傳回ArrayList
	*/
	public java.util.ArrayList<String[]> doQueryAll() throws Exception {
		QueryParams q = new QueryParams();
		java.util.ArrayList<String[]> arrList = new java.util.ArrayList<String[]>();
		if (!"".equals(getQ_id()))
			q.add(new QueryParam("and","id","=",getQ_id()));
		
		this.processCurrentPageAttribute(ServiceGetter.getInstance().getCommonService().loadObjectsCountByParams(CommonConfig.class, q));
		if (getTotalRecord() > 0) {
			if (getState().indexOf("query")<0) 
				ServiceGetter.getInstance().getCommonService().clear();
			
			java.util.List objList = ServiceGetter.getInstance().getCommonService().loadObjectsByParams(CommonConfig.class, q, this.getRecordStart(), this.getPageSize(), "id", true);
			if (objList != null && objList.size() > 0) {
				java.util.Iterator it = objList.iterator();
				while (it.hasNext()) {
					CommonConfig o = (CommonConfig) it.next();
					String rowArray[] = new String[3];
					rowArray[0] = Common.get(o.getField1());
					rowArray[1] = Common.get(o.getField2());
					rowArray[2] = Common.get(o.getField3());						
					arrList.add(rowArray);
				}
			}
		}
		return arrList;
	}	

}
