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
import com.kangdainfo.ctis.model.bo.BaseDsaJobDef;

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

public class  SYSCA005F extends SuperBean{


String id;
String dsaJobId;//護法會流水號
String dsaJobName;//護法會職稱
String dsaJobDesc;//護法會職稱說明

String q_dsaJobId; 		
String q_dsaJobName;		

@Override
public void doCreate() throws Exception {
	BaseDsaJobDef obj = new BaseDsaJobDef();
	
	obj.setDsaJobId(Short.parseShort(dsaJobId));
	obj.setDsaJobName(dsaJobName);
	obj.setDsaJobDesc(dsaJobDesc);
	obj.setCreateId(createId);
	obj.setCreateDate(createDate);
	obj.setCreateTime(createTime);

	ServiceGetter.getInstance().getCommonService().save(obj);
	setId(obj.getId().toString());
}


@Override
public void doUpdate() throws Exception {
	BaseDsaJobDef obj = (BaseDsaJobDef) View.getObject(" from BaseDsaJobDef where id=" + Common.getInt(getId()));
	obj.setDsaJobId(Short.parseShort(dsaJobId));
	obj.setDsaJobName(dsaJobName);
	obj.setDsaJobDesc(dsaJobDesc);
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
	ServiceGetter.getInstance().getCommonService().delete(BaseDsaJobDef.class, Common.getInt(id));
}


/**
 * <br>
 * <br>目的：依主鍵查詢單一資料
 * <br>參數：無
 * <br>傳回：傳回本物件
*/
@Override
public SYSCA005F  doQueryOne() throws Exception {
	SYSCA005F obj = this;
	BaseDsaJobDef c = (BaseDsaJobDef)ServiceGetter.getInstance().getCommonService().load(BaseDsaJobDef.class,Integer.parseInt(getId()));
	if (c!=null) {
		obj.setDsaJobId(Short.toString(c.getDsaJobId()));
		obj.setDsaJobName(c.getDsaJobName());
		obj.setDsaJobDesc(c.getDsaJobDesc());
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

	StringBuilder sb = new StringBuilder(300).append("from BaseDsaJobDef where 1=1");
	
	java.util.ArrayList<String[]> arrList = new java.util.ArrayList<String[]>();
	
	if (!"".equals(getQ_dsaJobId()))
	{
		sb.append(" and dsaJobId = :dsaJobId ");
		maps.put("dsaJobId",Short.parseShort(q_dsaJobId)); 
	}
	if (!"".equals(getQ_dsaJobName()))
	{
		sb.append(" and dsaJobName like :dsaJobName ");
		maps.put("dsaJobName", "%" + q_dsaJobName + "%");  
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
					BaseDsaJobDef o = (BaseDsaJobDef) objList.get(i);	
					
					String rowArray[]=new String[4];	
					rowArray[0]=Common.get(o.getId());
					rowArray[1]=Common.get(o.getDsaJobId());			
					rowArray[2]=Common.get(o.getDsaJobName());
					rowArray[3]=Common.get(o.getDsaJobDesc());
					
					
				
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


	public String getDsaJobDesc() {
		return checkGet(dsaJobDesc);
	}


	public void setDsaJobDesc(String dsaJobDesc) {
		this.dsaJobDesc = checkSet(dsaJobDesc);
	}


	public String getQ_dsaJobId() {
		return checkGet(q_dsaJobId);
	}


	public void setQ_dsaJobId(String q_dsaJobId) {
		this.q_dsaJobId = checkSet(q_dsaJobId);
	}


	public String getQ_dsaJobName() {
		return checkGet(q_dsaJobName);
	}


	public void setQ_dsaJobName(String q_dsaJobName) {
		this.q_dsaJobName = checkSet(q_dsaJobName);
	}



	


	


	



	
}


