package com.kangdainfo.common.view.sys.ca;

import java.util.ArrayList;




import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.kangdainfo.ServiceGetter;


import com.kangdainfo.common.util.Common;
import com.kangdainfo.common.util.Datetime;
import com.kangdainfo.common.util.SuperBean;
import com.kangdainfo.common.util.View;
import com.kangdainfo.ctis.model.bo.BaseHealthDef;



import com.kangdainfo.util.DateUtil;


/**
*<br>程式目的：機關代碼維護作業_CPA版本
*<br>程式代號：sysap0701f
*<br>程式日期：103.08.28
*<br>程式作者：ted.yang
*<br>--------------------------------------------------------
*<br>修改作者　　修改日期　　　修改目的
*<br>--------------------------------------------------------
*/

public class  SYSCA009F extends SuperBean{


String id;
String healthType; 		//健康狀況分類
String healthStatusName;//健康狀況名稱
String healthStatusDesc;//狀況說明
String okToEnable; 	    //是否顯示健康狀況



String q_healthType; 		
String q_healthStatusName;		

@Override
public void doCreate() throws Exception {
	BaseHealthDef obj = new BaseHealthDef();
	
    obj.setHealthType(healthType);
    obj.setHealthStatusName(healthStatusName);
    obj.setHealthStatusDesc(healthStatusDesc);
    obj.setOkToEnable(Boolean.valueOf(okToEnable));
	obj.setCreateId(createId);
	obj.setCreateDate(createDate);
	obj.setCreateTime(createTime);

	ServiceGetter.getInstance().getCommonService().save(obj);
	setId(obj.getId().toString());
}


@Override
public void doUpdate() throws Exception {
	BaseHealthDef obj = (BaseHealthDef) View.getObject(" from BaseHealthDef where id=" + Common.getInt(getId()));
	obj.setHealthType(healthType);
	obj.setHealthStatusName(healthStatusName);
	obj.setHealthStatusDesc(healthStatusDesc);
	obj.setOkToEnable(Boolean.valueOf(okToEnable));
	obj.setUpdateId(updateId);
    obj.setUpdateDate(updateDate);
	obj.setUpdateTime(updateTime);
	obj.setUpdateIp(updateIp);
	obj.setUpdateUnitShortName(updateUnitShortName);
	
	ServiceGetter.getInstance().getCommonService().save(obj);
	setId(obj.getId().toString());
}


@Override
public void doDelete() throws Exception {
	ServiceGetter.getInstance().getCommonService().delete(BaseHealthDef.class, Common.getInt(id));
}


/**
 * <br>
 * <br>目的：依主鍵查詢單一資料
 * <br>參數：無
 * <br>傳回：傳回本物件
*/
@Override
public SYSCA009F  doQueryOne() throws Exception {
	SYSCA009F obj = this;
	BaseHealthDef c = (BaseHealthDef)ServiceGetter.getInstance().getCommonService().load(BaseHealthDef.class,Integer.parseInt(getId()));
	if (c!=null) {
		obj.setHealthType(c.getHealthType());
		obj.setHealthStatusName(c.getHealthStatusName());
		obj.setHealthStatusDesc(c.getHealthStatusDesc());
		obj.setOkToEnable(Boolean.toString(c.getOkToEnable()));
		obj.setCreateId(c.getCreateId());
		obj.setCreateDate(c.getCreateDate());
		obj.setCreateTime(c.getCreateTime());
		obj.setUpdateId(c.getUpdateId());
		obj.setUpdateDate(c.getUpdateDate());
		obj.setUpdateTime(c.getUpdateTime());
		obj.setUpdateIp(c.getUpdateIp());
		obj.setUpdateUnitShortName(c.getUpdateUnitShortName());
	} else throw new Exception("查無該筆資料！");
	return obj;
}


@Override
public java.util.ArrayList<String[]> doQueryAll() throws Exception {		
	Map<String, Object> maps = new HashMap<String, Object>();

	StringBuilder sb = new StringBuilder(300).append("from BaseHealthDef where 1=1");
	
	java.util.ArrayList<String[]> arrList = new java.util.ArrayList<String[]>();
	
	if (!"".equals(getQ_healthType()))
	{
		sb.append(" and healthType = :healthType ");
		maps.put("healthType",q_healthType); 
	}
	if (!"".equals(getQ_healthStatusName()))
	{
		sb.append(" and healthStatusName like :healthStatusName ");
		maps.put("healthStatusName", "%" + q_healthStatusName + "%");  
	}
   
	System.out.println(sb.toString());
	java.util.Map<String, String> map=new java.util.HashMap<String, String>();
	java.util.Map<String, String> map1=new java.util.HashMap<String, String>();	
    map1.put("B", "body"); map1.put("M", "mental");
  
	this.processCurrentPageAttribute(ServiceGetter.getInstance().getCommonService().getCommonUserDao().loadCount(sb.toString(), maps));
	if (getTotalRecord() > 0) {
		if (getState().indexOf("query")<0) 
			ServiceGetter.getInstance().getCommonService().clear();				
		java.util.List objList = ServiceGetter.getInstance().getCommonService().getCommonUserDao().load(sb.toString(), this.getRecordStart(), this.getPageSize(), "id", true, maps);	
		try {
			if (objList!=null && objList.size()>0) {
				for (int i=0; i<objList.size(); i++) {
					BaseHealthDef o = (BaseHealthDef) objList.get(i);	
					
					String rowArray[]=new String[5];	
					rowArray[0]=Common.get(o.getId());
					rowArray[1]=Common.get(map1.get(o.getHealthType()));			
					rowArray[2]=Common.get(o.getHealthStatusDesc());
					rowArray[3]=Common.get(o.getHealthStatusDesc());
					String c = Boolean.toString(o.getOkToEnable());					
					rowArray[4]=Common.get("true".equals(c)?"是":"否");
				
					arrList.add(rowArray);					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	return arrList;
}
	





	public String getId() {
		return checkGet(id);
	}


	public void setId(String id) {
		this.id = checkSet(id);
	}


	public String getHealthType() {
		return checkGet(healthType);
	}


	public void setHealthType(String healthType) {
		this.healthType = checkSet(healthType);
	}


	public String getHealthStatusName() {
		return checkGet(healthStatusName);
	}


	public void setHealthStatusName(String healthStatusName) {
		this.healthStatusName = checkSet(healthStatusName);
	}


	public String getHealthStatusDesc() {
		return checkGet(healthStatusDesc);
	}


	public void setHealthStatusDesc(String healthStatusDesc) {
		this.healthStatusDesc = checkSet(healthStatusDesc);
	}


	public String getOkToEnable() {
		return checkGet(okToEnable);
	}


	public void setOkToEnable(String okToEnable) {
		this.okToEnable = checkSet(okToEnable);
	}


	public String getQ_healthType() {
		return checkGet(q_healthType);
	}


	public void setQ_healthType(String q_healthType) {
		this.q_healthType = checkSet(q_healthType);
	}


	public String getQ_healthStatusName() {
		return checkGet(q_healthStatusName);
	}


	public void setQ_healthStatusName(String q_healthStatusName) {
		this.q_healthStatusName = checkSet(q_healthStatusName);
	}


	


	





	


	


	



	
}


