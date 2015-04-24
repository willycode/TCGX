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
import com.kangdainfo.ctis.model.bo.BaseLanguageInfo;


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

public class  SYSCA007F extends SuperBean{


String id;
String languageId;//精舍所在地語言代碼流水號
String languageName;//精舍所在地語言名稱


String q_languageId; 		
String q_languageName;		

@Override
public void doCreate() throws Exception {
	BaseLanguageInfo obj = new BaseLanguageInfo();
	
    obj.setLanguageId(Short.parseShort(languageId));
    obj.setLanguageName(languageName);
	obj.setCreateId(createId);
	obj.setCreateDate(createDate);
	obj.setCreateTime(createTime);

	ServiceGetter.getInstance().getCommonService().save(obj);
	setId(obj.getId().toString());
}


@Override
public void doUpdate() throws Exception {
	BaseLanguageInfo obj = (BaseLanguageInfo) View.getObject(" from BaseLanguageInfo where id=" + Common.getInt(getId()));
	obj.setLanguageId(Short.parseShort(languageId));
	obj.setLanguageName(languageName);
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
	ServiceGetter.getInstance().getCommonService().delete(BaseLanguageInfo.class, Common.getInt(id));
}


/**
 * <br>
 * <br>目的：依主鍵查詢單一資料
 * <br>參數：無
 * <br>傳回：傳回本物件
*/
@Override
public SYSCA007F  doQueryOne() throws Exception {
	SYSCA007F obj = this;
	BaseLanguageInfo c = (BaseLanguageInfo)ServiceGetter.getInstance().getCommonService().load(BaseLanguageInfo.class,Integer.parseInt(getId()));
	if (c!=null) {
		obj.setLanguageId(Short.toString(c.getLanguageId()));
		obj.setLanguageName(c.getLanguageName());
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

	StringBuilder sb = new StringBuilder(300).append("from BaseLanguageInfo where 1=1");
	
	java.util.ArrayList<String[]> arrList = new java.util.ArrayList<String[]>();
	
	if (!"".equals(getQ_languageId()))
	{
		sb.append(" and languageId = :languageId ");
		maps.put("languageId",Short.parseShort(q_languageId)); 
	}
	if (!"".equals(getQ_languageName()))
	{
		sb.append(" and languageName like :languageName ");
		maps.put("languageName", "%" + q_languageName + "%");  
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
					BaseLanguageInfo o = (BaseLanguageInfo) objList.get(i);	
					
					String rowArray[]=new String[6];	
					rowArray[0]=Common.get(o.getId());
					rowArray[1]=Common.get(o.getLanguageId());			
					rowArray[2]=Common.get(o.getLanguageName());
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
	





	public String getId() {
		return checkGet(id);
	}


	public void setId(String id) {
		this.id = checkSet(id);
	}


	public String getLanguageId() {
		return checkGet(languageId);
	}


	public void setLanguageId(String languageId) {
		this.languageId = checkSet(languageId);
	}


	public String getLanguageName() {
		return checkGet(languageName);
	}


	public void setLanguageName(String languageName) {
		this.languageName = checkSet(languageName);
	}


	public String getQ_languageId() {
		return checkGet(q_languageId);
	}


	public void setQ_languageId(String q_languageId) {
		this.q_languageId = checkSet(q_languageId);
	}


	public String getQ_languageName() {
		return checkGet(q_languageName);
	}


	public void setQ_languageName(String q_languageName) {
		this.q_languageName = checkSet(q_languageName);
	}


	





	


	


	



	
}


