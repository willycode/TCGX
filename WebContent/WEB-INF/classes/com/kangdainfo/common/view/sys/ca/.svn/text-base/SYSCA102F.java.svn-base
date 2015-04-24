package com.kangdainfo.common.view.sys.ca;

import java.net.Socket;


import java.util.HashMap;
import java.util.Map;


import com.kangdainfo.ServiceGetter;



import com.kangdainfo.common.model.bo.CommonCode;
import com.kangdainfo.common.model.bo.CommonLunarCalendar;

import com.kangdainfo.common.util.Common;
import com.kangdainfo.common.util.Datetime;
import com.kangdainfo.common.util.SuperBean;
import com.kangdainfo.common.util.View;
import com.kangdainfo.ctis.model.bo.BaseDsaJobDef;
import com.kangdainfo.ctis.model.bo.CenterDsaMemberRecord;



/**
 * 共用代碼檔維護作業
 * 
 * TABLE = CommonCodeKind 
 * @author clive.chang 
 *
 */
public class SYSCA102F extends SuperBean {
	String id;
	String  adDate;//西元日期
	String  lunarDate;//農曆日期
	String  lunarName;//天干地支
	String  isBeforeROC;//民國前
	String  lunarYear;//農曆年
	String  lunarMonth;//農曆月
	String  isLeap;//閏月
	String  lunarDay;//日
	
	
	String q_adDate; 	
	String q_lunarName; 
	String q_isBeforeROC;
	String q_lunarYear;; 	
	String q_lunarMonth; 	
	String q_isLeap;
	String q_lunarDay;
	

	@Override
	public void doCreate() throws Exception {					
		CommonLunarCalendar obj = new CommonLunarCalendar();	
	    obj.setAdDate(adDate);
	    obj.setLunarDate(lunarDate);
	    obj.setLunarDay(lunarDay);
	    obj.setLunarMonth(lunarMonth);
	    obj.setLunarYear(lunarYear);
		obj.setLunarName(lunarName);
		obj.setIsBeforeROC(Boolean.valueOf(isBeforeROC));
		obj.setIsLeap(Boolean.valueOf(isLeap));
		obj.setCreateId(createId);
		obj.setCreateDate(createDate);
		obj.setCreateTime(createTime);
		obj.setUpdateId(updateId);
	    obj.setUpdateDate(updateDate);
		obj.setUpdateTime(updateTime);
		obj.setUpdateIp(updateIp);
		obj.setUpdateUnitShortName(updateUnitShortName);
		ServiceGetter.getInstance().getCommonService().save(obj);
		setId((obj.getId().toString()));		
		
		
	}
	
	@Override
	public void doUpdate() throws Exception {
		CommonLunarCalendar obj = (CommonLunarCalendar) View.getObject("from CommonLunarCalendar where id=" + Common.getInt(getId()));
	     if(obj==null){
	    	 throw new Exception("查無資料");	
	     }else{
	 	    obj.setAdDate(adDate);
		    obj.setLunarDate(lunarDate);
		    obj.setLunarDay(lunarDay);
		    obj.setLunarMonth(lunarMonth);
		    obj.setLunarYear(lunarYear);
			obj.setLunarName(lunarName);
			obj.setIsBeforeROC(Boolean.valueOf(isBeforeROC));
			obj.setIsLeap(Boolean.valueOf(isLeap));
	 		obj.setUpdateId(updateId);
	 	    obj.setUpdateDate(updateDate);
	 		obj.setUpdateTime(updateTime);
	 		obj.setUpdateIp(updateIp);
	 		obj.setUpdateUnitShortName(updateUnitShortName);
		
		ServiceGetter.getInstance().getCommonService().update(obj);
	     }
	}	

	
	
	@Override
	public void doDelete() throws Exception {		
		ServiceGetter.getInstance().getCommonService().delete(CommonLunarCalendar.class, Integer.parseInt(getId()));
	}

	@Override
	public SYSCA102F doQueryOne() throws Exception {	 
		SYSCA102F obj = this;		
		CommonLunarCalendar c = (CommonLunarCalendar)ServiceGetter.getInstance().getCommonService().load(CommonLunarCalendar.class, Integer.parseInt(getId()));
		
		
		if (c!=null) {
			
		    obj.setAdDate(c.getAdDate());
		    obj.setLunarDate(c.getLunarDate());
		    obj.setLunarDay(c.getLunarDay());
		    obj.setLunarMonth(c.getLunarMonth());
		    obj.setLunarYear(c.getLunarYear());
			obj.setIsBeforeROC(Boolean.toString(c.getIsBeforeROC()));
			obj.setIsLeap(Boolean.toString(c.getIsLeap()));
			obj.setLunarName(c.getLunarName());
			obj.setCreateId(c.getCreateId());
			obj.setCreateDate(c.getCreateDate());
			obj.setCreateTime(c.getCreateTime());
			obj.setUpdateId(c.getUpdateId());
			obj.setUpdateDate(c.getUpdateDate());
			obj.setUpdateTime(c.getUpdateTime());
			obj.setUpdateIp(c.getUpdateIp());
			obj.setUpdateUnitShortName(c.getUpdateUnitShortName());
		} else throw new Exception("查無資料");		
		return obj;
	}

	
	@Override
	public java.util.ArrayList<String[]> doQueryAll() throws Exception {		
		Map<String, Object> maps = new HashMap<String, Object>();

		StringBuilder sb = new StringBuilder(300).append("from CommonLunarCalendar where 1=1");
		
		java.util.ArrayList<String[]> arrList = new java.util.ArrayList<String[]>();
		
		if (!"".equals(getQ_adDate()))
		{
			sb.append(" and adDate like :adDate ");
			maps.put("adDate","%" + q_adDate + "%"); 
		}
		if (!"".equals(getQ_lunarName()))
		{
			sb.append(" and lunarName like :lunarName ");
			maps.put("lunarName", "%" + q_lunarName + "%");  
		}
		if (!"".equals(getQ_isBeforeROC()))
		{
			sb.append(" and isBeforeROC = :isBeforeROC ");
			maps.put("isBeforeROC", Boolean.valueOf(q_isBeforeROC));  
		}
		if (!"".equals(getQ_lunarYear()))
		{
			sb.append(" and lunarYear like :lunarYear ");
			maps.put("lunarYear", "%" + q_lunarYear + "%");  
		}
		if (!"".equals(getQ_lunarMonth()))
		{
			sb.append(" and lunarMonth like :lunarMonth ");
			maps.put("lunarMonth", "%" + q_lunarMonth + "%");  
		}
		if (!"".equals(getQ_isLeap()))
		{
			sb.append(" and isLeap = :isLeap ");
			maps.put("isLeap", Boolean.valueOf(q_isLeap));  
		}
		if (!"".equals(getQ_lunarDay()))
		{
			sb.append(" and lunarDay like :lunarDay ");
			maps.put("lunarDay", "%" + q_lunarDay + "%");  
		}
		System.out.println(sb.toString());
		java.util.Map<String, String> map=new java.util.HashMap<String, String>();
	  
		this.processCurrentPageAttribute(ServiceGetter.getInstance().getCommonService().getCommonUserDao().loadCount(sb.toString(), maps));
		if (getTotalRecord() > 0) {
			if (getState().indexOf("query")<0) 
				ServiceGetter.getInstance().getCommonService().clear();				
			java.util.List objList = ServiceGetter.getInstance().getCommonService().getCommonUserDao().load(sb.toString(), this.getRecordStart(), this.getPageSize(), "id", true, maps);	
			java.util.Map<String, String> roleMap = new java.util.HashMap<String, String>();
			
			try {
				if (objList!=null && objList.size()>0) {
					for (int i=0; i<objList.size(); i++) {
						CommonLunarCalendar o = (CommonLunarCalendar) objList.get(i);	
						
						String rowArray[]=new String[6];	
						rowArray[0]=Common.get(o.getId());
						rowArray[1]=Common.get(o.getAdDate());			
						rowArray[2]=Common.get(o.getLunarDate());
				
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

	public String getAdDate() {
		return checkGet(adDate);
	}

	public void setAdDate(String adDate) {
		this.adDate = checkSet(adDate);
	}

	public String getLunarDate() {
		return checkGet(lunarDate);
	}

	public void setLunarDate(String lunarDate) {
		this.lunarDate = checkSet(lunarDate);
	}

	public String getLunarName() {
		return checkGet(lunarName);
	}

	public void setLunarName(String lunarName) {
		this.lunarName = checkSet(lunarName);
	}

	public String getIsBeforeROC() {
		return checkGet(isBeforeROC);
	}

	public void setIsBeforeROC(String isBeforeROC) {
		this.isBeforeROC = checkSet(isBeforeROC);
	}

	public String getLunarYear() {
		return checkGet(lunarYear);
	}

	public void setLunarYear(String lunarYear) {
		this.lunarYear = checkSet(lunarYear);
	}

	public String getLunarMonth() {
		return checkGet(lunarMonth);
	}

	public void setLunarMonth(String lunarMonth) {
		this.lunarMonth = checkSet(lunarMonth);
	}

	public String getIsLeap() {
		return checkGet(isLeap);
	}

	public void setIsLeap(String isLeap) {
		this.isLeap = checkSet(isLeap);
	}

	public String getLunarDay() {
		return checkGet(lunarDay);
	}

	public void setLunarDay(String lunarDay) {
		this.lunarDay = checkSet(lunarDay);
	}

	public String getQ_adDate() {
		return checkGet(q_adDate);
	}

	public void setQ_adDate(String q_adDate) {
		this.q_adDate = checkSet(q_adDate);
	}

	public String getQ_lunarName() {
		return checkGet(q_lunarName);
	}

	public void setQ_lunarName(String q_lunarName) {
		this.q_lunarName = checkSet(q_lunarName);
	}

	public String getQ_isBeforeROC() {
		return checkGet(q_isBeforeROC);
	}

	public void setQ_isBeforeROC(String q_isBeforeROC) {
		this.q_isBeforeROC = checkSet(q_isBeforeROC);
	}

	public String getQ_lunarYear() {
		return checkGet(q_lunarYear);
	}

	public void setQ_lunarYear(String q_lunarYear) {
		this.q_lunarYear = checkSet(q_lunarYear);
	}

	public String getQ_lunarMonth() {
		return checkGet(q_lunarMonth);
	}

	public void setQ_lunarMonth(String q_lunarMonth) {
		this.q_lunarMonth = checkSet(q_lunarMonth);
	}

	public String getQ_isLeap() {
		return checkGet(q_isLeap);
	}

	public void setQ_isLeap(String q_isLeap) {
		this.q_isLeap = checkSet(q_isLeap);
	}

	public String getQ_lunarDay() {
		return checkGet(q_lunarDay);
	}

	public void setQ_lunarDay(String q_lunarDay) {
		this.q_lunarDay = checkSet(q_lunarDay);
	}
	
}
