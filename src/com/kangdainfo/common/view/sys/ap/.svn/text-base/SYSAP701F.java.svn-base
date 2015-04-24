package com.kangdainfo.common.view.sys.ap;

import java.util.ArrayList;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.kangdainfo.ServiceGetter;




import com.kangdainfo.common.model.bo.CommonUnlimitIp;
import com.kangdainfo.common.util.Common;
import com.kangdainfo.common.util.Datetime;
import com.kangdainfo.common.util.SuperBean;
import com.kangdainfo.common.util.View;
import com.kangdainfo.ctis.model.bo.CtMasterInfo;
import com.kangdainfo.util.DateUtil;


/**
*<br>程式目的：機關代碼維護作業_CPA版本
*<br>程式代號：sysap0701f
*<br>程式日期：103.08.27
*<br>程式作者：ted.yang
*<br>--------------------------------------------------------
*<br>修改作者　　修改日期　　　修改目的
*<br>--------------------------------------------------------
*/

public class  SYSAP701F extends SuperBean{


String id;
String masterId; 		//法師衣編
String masterName;		//法師法名
String masterPassword;	//法師密碼

String q_masterId; 		
String q_masterName;

@Override
public void doCreate() throws Exception {
	CtMasterInfo obj = new CtMasterInfo();
	
	obj.setMasterId(masterId);
	obj.setMasterName(masterName);
	if (!"".equals(getMasterPassword())) obj.setMasterPassword(Common.getDigestString(masterPassword,"SHA-1"));
	obj.setCreateId(createId);
	obj.setCreateDate(createDate);
	obj.setCreateTime(createTime);

	ServiceGetter.getInstance().getCommonService().save(obj);
	setId(obj.getId().toString());
}


@Override
public void doUpdate() throws Exception {
	CtMasterInfo obj = (CtMasterInfo) View.getObject(" from CtMasterInfo where id=" + Common.get(getId()));
	if (!"".equals(getMasterPassword())) obj.setMasterPassword(Common.getDigestString(masterPassword,"SHA-1"));	
	obj.setMasterId(masterId);
	obj.setMasterName(masterName);
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
	ServiceGetter.getInstance().getCommonService().delete(CtMasterInfo.class, Common.getInt(id));
}


/**
 * <br>
 * <br>目的：依主鍵查詢單一資料
 * <br>參數：無
 * <br>傳回：傳回本物件
*/
@Override
public SYSAP701F  doQueryOne() throws Exception {
	SYSAP701F obj = this;
	CtMasterInfo c = (CtMasterInfo)ServiceGetter.getInstance().getCommonService().load(CtMasterInfo.class,Integer.parseInt(getId()));
	if (c!=null) {
		obj.setMasterId(c.getMasterId());
		obj.setMasterName(c.getMasterName());	
		obj.setMasterPassword("");
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

	StringBuilder sb = new StringBuilder(300).append("from CtMasterInfo where 1=1");
	
	java.util.ArrayList<String[]> arrList = new java.util.ArrayList<String[]>();
	
	if (!"".equals(getQ_masterId()))
	{
		sb.append(" and masterId = :masterId ");
		maps.put("masterId", q_masterId); 
	}
	if (!"".equals(getQ_masterName()))
	{
		sb.append(" and masterName like :masterName ");
		maps.put("masterName", "%" + q_masterName + "%");  
	}
   
	System.out.println(sb.toString());
	java.util.Map<String, String> map=new java.util.HashMap<String, String>();
	

	this.processCurrentPageAttribute(ServiceGetter.getInstance().getCommonService().getCommonUserDao().loadCount(sb.toString(), maps));
	if (getTotalRecord() > 0) {
		if (getState().indexOf("query")<0) 
			ServiceGetter.getInstance().getCommonService().clear();				
		java.util.List objList = ServiceGetter.getInstance().getCommonService().getCommonUserDao().load(sb.toString(), this.getRecordStart(), this.getPageSize(), "id", true, maps);	
		try {
			if (objList!=null && objList.size()>0) {
				for (int i=0; i<objList.size(); i++) {
					CtMasterInfo o = (CtMasterInfo) objList.get(i);	
					
					String rowArray[]=new String[6];	
					rowArray[0]=Common.get(o.getId());
					rowArray[1]=Common.get(o.getMasterId());			
					rowArray[2]=Common.get(o.getMasterName());
					rowArray[3]=Common.get(o.getUpdateId());
					rowArray[4]=Common.get(o.getUpdateDate());
					rowArray[5]=Common.get(o.getUpdateTime());
				
					arrList.add(rowArray);					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	return arrList;
}

public java.util.ArrayList<String[]> doQueryAll_sysap001_1f() throws Exception {		
	
	java.util.ArrayList<String[]> arrList = new java.util.ArrayList<String[]>();
	Map<String, Object> maps = new HashMap<String, Object>();

	StringBuffer sb = new StringBuffer();
	sb.append("from CtMasterInfo where 1=1");	
	
	if (!"".equals(getQ_masterId()))
	{
		sb.append(" and masterId = :masterId ");
		maps.put("masterId", q_masterId); 
	}
	
	if (!"".equals(getQ_masterName()))
	{
		sb.append(" and masterName like :masterName ");
		maps.put("masterName", "%" + q_masterName + "%");  
	}
   
	System.out.println("sysap001_1f 查詢 == " + sb.toString());
	this.processCurrentPageAttribute(ServiceGetter.getInstance().getCommonService().loadCount(sb.toString(), maps));
	if (getTotalRecord() > 0) {
		if (getState().indexOf("query")<0) 
			ServiceGetter.getInstance().getCommonService().clear();				
		java.util.List objList = ServiceGetter.getInstance().getCommonService().load(sb.toString()+" order by masterId", this.getRecordStart(), this.getPageSize(), maps);		
		if (objList!=null && objList.size()>0) {
			for (Object obj : objList) {
				CtMasterInfo o = (CtMasterInfo)obj;	
				
				String rowArray[]=new String[3];	
				rowArray[0]=Common.get(o.getId());
				rowArray[1]=Common.get(o.getMasterId());			
				rowArray[2]=Common.get(o.getMasterName());
				arrList.add(rowArray);					
			}
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
	public String getMasterId() {
		return checkGet(masterId);
	}
	public void setMasterId(String masterId) {
		this.masterId = checkSet(masterId);
	}
	public String getMasterName() {
		return checkGet(masterName);
	}
	public void setMasterName(String masterName) {
		this.masterName = checkSet(masterName);
	}
	public String getMasterPassword() {
		return checkGet(masterPassword);
	}
	public void setMasterPassword(String masterPassword) {
		this.masterPassword = checkSet(masterPassword);
	}


	public String getQ_masterId() {
		return checkGet(q_masterId);
	}


	public void setQ_masterId(String q_masterId) {
		this.q_masterId = checkSet(q_masterId);
	}


	public String getQ_masterName() {
		return checkGet(q_masterName);
	}


	public void setQ_masterName(String q_masterName) {
		this.q_masterName = checkSet(q_masterName);
	}

}
