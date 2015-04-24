package com.kangdainfo.common.view.sys.ca;

import java.net.Socket;

import java.util.HashMap;
import java.util.Map;


import com.kangdainfo.ServiceGetter;



import com.kangdainfo.common.model.bo.CommonCode;
import com.kangdainfo.common.model.bo.CommonYearList;
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
public class SYSCA101F extends SuperBean {
	String id;
	String adYear; 	//西元年	
	String twYear; 	//民國年
	String lunarName;//天干地支
	String jpYear; 	//日本年
	String thYear; 	//泰國年
	
	
	String q_adYear; 	
	String q_twYear; 
	String q_lunarName;
	String q_jpYear; 	
	String q_thYear; 	
	
	
	

	@Override
	public void doCreate() throws Exception {					
		CommonYearList obj = new CommonYearList();	
		obj.setAdYear(adYear);
		obj.setTwYear(twYear);
		obj.setThYear(thYear);
		obj.setJpYear(jpYear);
		obj.setLunarName(lunarName);
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
		CommonYearList obj = (CommonYearList) View.getObject("from CommonYearList where id=" + Common.getInt(getId()));
	     if(obj==null){
	    	 throw new Exception("查無資料");	
	     }else{
	    	obj.setAdYear(adYear);
	 		obj.setTwYear(twYear);
	 		obj.setThYear(thYear);
	 		obj.setJpYear(jpYear);
	 		obj.setLunarName(lunarName);
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
		ServiceGetter.getInstance().getCommonService().delete(CommonYearList.class, Integer.parseInt(getId()));
	}

	@Override
	public SYSCA101F doQueryOne() throws Exception {	 
		SYSCA101F obj = this;		
		CommonYearList c = (CommonYearList)ServiceGetter.getInstance().getCommonService().load(CommonYearList.class, Integer.parseInt(getId()));
		
		
		if (c!=null) {
			obj.setAdYear(c.getAdYear());
			obj.setTwYear(c.getTwYear());
			obj.setThYear(c.getThYear());
			obj.setJpYear(c.getJpYear());
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

		StringBuilder sb = new StringBuilder(300).append("from CommonYearList where 1=1");
		
		java.util.ArrayList<String[]> arrList = new java.util.ArrayList<String[]>();
		
		if (!"".equals(getQ_adYear()))
		{
			sb.append(" and adYear like :adYear ");
			maps.put("adYear","%" + q_adYear + "%"); 
		}
		if (!"".equals(getQ_twYear()))
		{
			sb.append(" and twYear like :twYear ");
			maps.put("twYear", "%" + q_twYear + "%");  
		}
		if (!"".equals(getQ_lunarName()))
		{
			sb.append(" and lunarName like :lunarName ");
			maps.put("lunarName", "%" + q_lunarName + "%");  
		}
		if (!"".equals(getQ_jpYear()))
		{
			sb.append(" and jpYear like :jpYear ");
			maps.put("jpYear", "%" + q_jpYear + "%");  
		}
		if (!"".equals(getQ_thYear()))
		{
			sb.append(" and thYear like :thYear ");
			maps.put("thYear", "%" + q_thYear + "%");  
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
						CommonYearList o = (CommonYearList) objList.get(i);	
						
						String rowArray[]=new String[6];	
						rowArray[0]=Common.get(o.getId());
						rowArray[1]=Common.get(o.getAdYear());			
						rowArray[2]=Common.get(o.getTwYear());
						rowArray[3]=Common.get(o.getLunarName());				
						rowArray[4]=Common.get(o.getJpYear());
						rowArray[5]=Common.get(o.getThYear());
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
	public String getAdYear() {
		return checkGet(adYear);
	}
	public void setAdYear(String adYear) {
		this.adYear = checkSet(adYear);
	}
	public String getTwYear() {
		return checkGet(twYear);
	}
	public void setTwYear(String twYear) {
		this.twYear = checkSet(twYear);
	}
	public String getLunarName() {
		return checkGet(lunarName);
	}
	public void setLunarName(String lunarName) {
		this.lunarName = checkSet(lunarName);
	}
	public String getJpYear() {
		return checkGet(jpYear);
	}
	public void setJpYear(String jpYear) {
		this.jpYear = checkSet(jpYear);
	}
	public String getThYear() {
		return checkGet(thYear);
	}
	public void setThYear(String thYear) {
		this.thYear = checkSet(thYear);
	}
	public String getQ_adYear() {
		return checkGet(q_adYear);
	}
	public void setQ_adYear(String q_adYear) {
		this.q_adYear = checkSet(q_adYear);
	}
	public String getQ_twYear() {
		return checkGet(q_twYear);
	}
	public void setQ_twYear(String q_twYear) {
		this.q_twYear = checkSet(q_twYear);
	}
	public String getQ_lunarName() {
		return checkGet(q_lunarName);
	}
	public void setQ_lunarName(String q_lunarName) {
		this.q_lunarName = checkSet(q_lunarName);
	}
	public String getQ_jpYear() {
		return checkGet(q_jpYear);
	}
	public void setQ_jpYear(String q_jpYear) {
		this.q_jpYear = checkSet(q_jpYear);
	}
	public String getQ_thYear() {
		return checkGet(q_thYear);
	}
	public void setQ_thYear(String q_thYear) {
		this.q_thYear = checkSet(q_thYear);
	}
}
