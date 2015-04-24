package com.kangdainfo.common.view.sys.ca;

import java.util.ArrayList;





import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.kangdainfo.ServiceGetter;


import com.kangdainfo.common.model.bo.CommonGroup;
import com.kangdainfo.common.util.Common;
import com.kangdainfo.common.util.Datetime;
import com.kangdainfo.common.util.SuperBean;
import com.kangdainfo.common.util.View;
import com.kangdainfo.ctis.model.bo.BaseDsaJobDef;
import com.kangdainfo.ctis.model.bo.CenterDsaMemberRecord;
import com.kangdainfo.ctis.model.bo.CenterMemberInfo;




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

public class  SYSCA006F extends SuperBean{


String id;
String dsaJobId;//護法會流水號
String dsaJobName;//護法會職稱
String ctDsaYear;//中台護法會年度
String centerDsaYear;//精舍護法會年度
String unitId;//精舍中台代碼
String unitShortName;//精舍簡稱
String centerMemberId;//學員編號
String ctMemberId;//精舍學員編號
String aliasName;//化名


String q_dsaJobId;
String q_dsaJobName;
public String getQ_dsaJobName() {
	return checkGet(q_dsaJobName);
}


public void setQ_dsaJobName(String q_dsaJobName) {
	this.q_dsaJobName = checkSet(q_dsaJobName);
}


String q_ctMemberId;;
String q_aliasName;
String q_ctDsaYear;
String q_centerDsaYear;
@Override
public void doCreate() throws Exception {
	CenterDsaMemberRecord obj = new CenterDsaMemberRecord();
	
    obj.setDsaJobId(Short.parseShort(dsaJobId));
    obj.setDsaJobName(dsaJobName);
    obj.setCtDsaYear(ctDsaYear);
    obj.setCenterDsaYear(centerDsaYear);
    obj.setUnitId(unitId);
    obj.setUnitShortName(unitShortName);
    CenterMemberInfo c =(CenterMemberInfo) View.getObject(" from CenterMemberInfo where ctMemberId="+ctMemberId);
    obj.setCenterMemberId(Common.get(c.getCenterMemberId()));   
    obj.setCtMemberId(ctMemberId);
    obj.setAliasName(aliasName);
    
	obj.setCreateId(createId);
	obj.setCreateDate(createDate);
	obj.setCreateTime(createTime);
	obj.setUpdateId(updateId);
    obj.setUpdateDate(updateDate);
	obj.setUpdateTime(updateTime);
	obj.setUpdateIp(updateIp);
	obj.setUpdateUnitShortName(updateUnitShortName);
	ServiceGetter.getInstance().getCommonService().save(obj);
	setId(obj.getId().toString());
}


@Override
public void doUpdate() throws Exception {
	CenterDsaMemberRecord obj = (CenterDsaMemberRecord) View.getObject(" from CenterDsaMemberRecord where id=" + Common.getInt(getId()));
	obj.setDsaJobId(Short.parseShort(dsaJobId));
    obj.setDsaJobName(dsaJobName);
    obj.setCtDsaYear(ctDsaYear);
    obj.setCenterDsaYear(centerDsaYear);
    obj.setUnitId(unitId);
    obj.setUnitShortName(unitShortName);
    CenterMemberInfo c =(CenterMemberInfo) View.getObject(" from CenterMemberInfo where ctMemberId="+ctMemberId);
    obj.setCenterMemberId(Common.get(c.getCenterMemberId()));
    obj.setCtMemberId(ctMemberId);
    obj.setAliasName(aliasName);
    
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
	ServiceGetter.getInstance().getCommonService().delete(CenterDsaMemberRecord.class, Common.getInt(id));
}


/**
 * <br>
 * <br>目的：依主鍵查詢單一資料
 * <br>參數：無
 * <br>傳回：傳回本物件
*/
@Override
public SYSCA006F  doQueryOne() throws Exception {
	SYSCA006F obj = this;
	CenterDsaMemberRecord c = (CenterDsaMemberRecord)ServiceGetter.getInstance().getCommonService().load(CenterDsaMemberRecord.class,Integer.parseInt(getId()));
	if (c!=null) {
		obj.setDsaJobId(Short.toString(c.getDsaJobId()));
		obj.setDsaJobName(c.getDsaJobName());
		obj.setCtDsaYear(c.getCtDsaYear());
		obj.setCenterDsaYear(c.getCenterDsaYear());
		obj.setUnitId(c.getUnitId());
		obj.setUnitShortName(c.getUnitShortName());
		obj.setCtMemberId(c.getCtMemberId());
		obj.setAliasName(c.getAliasName());
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

	StringBuilder sb = new StringBuilder(300).append("from CenterDsaMemberRecord where 1=1");
	
	java.util.ArrayList<String[]> arrList = new java.util.ArrayList<String[]>();
	
	if (!"".equals(getQ_dsaJobId()))
	{
		sb.append(" and dsaJobId = :dsaJobId ");
		maps.put("dsaJobId",Short.parseShort(q_dsaJobId)); 
	}
	if (!"".equals(getQ_ctMemberId()))
	{
		sb.append(" and ctMemberId = :ctMemberId ");
		maps.put("ctMemberId",q_ctMemberId); 
	}
	if (!"".equals(getQ_aliasName()))
	{
		sb.append(" and aliasName like :aliasName ");
		maps.put("aliasName", "%" + q_aliasName + "%");  
	}
	if (!"".equals(getQ_ctDsaYear()))
	{
		sb.append(" and ctDsaYear like :ctDsaYear ");
		maps.put("ctDsaYear", "%" + q_ctDsaYear + "%");  
	}
	if (!"".equals(getQ_centerDsaYear()))
	{
		sb.append(" and centerDsaYear like :centerDsaYear ");
		maps.put("centerDsaYear", "%" + q_centerDsaYear + "%");  
	}
   
	System.out.println(sb.toString());
	java.util.Map<String, String> map=new java.util.HashMap<String, String>();
  
	this.processCurrentPageAttribute(ServiceGetter.getInstance().getCommonService().getCommonUserDao().loadCount(sb.toString(), maps));
	if (getTotalRecord() > 0) {
		if (getState().indexOf("query")<0) 
			ServiceGetter.getInstance().getCommonService().clear();				
		java.util.List objList = ServiceGetter.getInstance().getCommonService().getCommonUserDao().load(sb.toString(), this.getRecordStart(), this.getPageSize(), "id", true, maps);	
		java.util.List roleList = ServiceGetter.getInstance().getCommonService().load("from BaseDsaJobDef");
		java.util.Map<String, String> roleMap = new java.util.HashMap<String, String>();
		if(roleList != null && roleList.size() > 0){	
			for(Object role : roleList){
				BaseDsaJobDef r = (BaseDsaJobDef)role;
				roleMap.put(r.getDsaJobId().toString(), r.getDsaJobName());
			}
		}
		try {
			if (objList!=null && objList.size()>0) {
				for (int i=0; i<objList.size(); i++) {
					CenterDsaMemberRecord o = (CenterDsaMemberRecord) objList.get(i);	
					
					String rowArray[]=new String[7];	
					rowArray[0]=Common.get(o.getId());
					rowArray[1]=Common.get(o.getCtDsaYear());			
					rowArray[2]=Common.get(o.getUnitShortName());
					rowArray[3]=Common.get(o.getCenterDsaYear());				
					rowArray[4]=Common.get(o.getAliasName());
		
		//			BaseDsaJobDef co =(BaseDsaJobDef) View.getObject(" from BaseDsaJobDef where dsaJobId="+o.getDsaJobName());
		
					rowArray[5]=Common.get(roleMap.get(o.getDsaJobName()));
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


	public String getDsaJobId() {
		return checkGet(dsaJobId);
	}


	public void setDsaJobId(String dsaJobId) {
		this.dsaJobId = checkSet(dsaJobId);
	}


	public String getDsaJobName() {
		return checkGet(dsaJobName);
	}


	public void setDsaJobName(String dsaJobName) {
		this.dsaJobName = checkSet(dsaJobName);
	}


	public String getCtDsaYear() {
		return checkGet(ctDsaYear);
	}


	public void setCtDsaYear(String ctDsaYear) {
		this.ctDsaYear = checkSet(ctDsaYear);
	}


	public String getCenterDsaYear() {
		return checkGet(centerDsaYear);
	}


	public void setCenterDsaYear(String centerDsaYear) {
		this.centerDsaYear = checkSet(centerDsaYear);
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


	public String getCenterMemberId() {
		return checkGet(centerMemberId);
	}


	public void setCenterMemberId(String centerMemberId) {
		this.centerMemberId = checkSet(centerMemberId);
	}


	public String getCtMemberId() {
		return checkGet(ctMemberId);
	}


	public void setCtMemberId(String ctMemberId) {
		this.ctMemberId = checkSet(ctMemberId);
	}


	public String getAliasName() {
		return checkGet(aliasName);
	}


	public void setAliasName(String aliasName) {
		this.aliasName = checkSet(aliasName);
	}


	public String getQ_dsaJobId() {
		return checkGet(q_dsaJobId);
	}


	public void setQ_dsaJobId(String q_dsaJobId) {
		this.q_dsaJobId = checkSet(q_dsaJobId);
	}


	


	public String getQ_ctMemberId() {
		return checkGet(q_ctMemberId);
	}


	public void setQ_ctMemberId(String q_ctMemberId) {
		this.q_ctMemberId = checkSet(q_ctMemberId);
	}


	public String getQ_aliasName() {
		return checkGet(q_aliasName);
	}


	public void setQ_aliasName(String q_aliasName) {
		this.q_aliasName = checkSet(q_aliasName);
	}


	public String getQ_ctDsaYear() {
		return checkGet(q_ctDsaYear);
	}


	public void setQ_ctDsaYear(String q_ctDsaYear) {
		this.q_ctDsaYear = checkSet(q_ctDsaYear);
	}


	public String getQ_centerDsaYear() {
		return checkGet(q_centerDsaYear);
	}


	public void setQ_centerDsaYear(String q_centerDsaYear) {
		this.q_centerDsaYear = checkSet(q_centerDsaYear);
	}


	
	



	
}


