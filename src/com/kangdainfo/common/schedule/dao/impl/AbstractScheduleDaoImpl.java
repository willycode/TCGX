package com.kangdainfo.common.schedule.dao.impl;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kangdainfo.ServiceGetter;
import com.kangdainfo.common.schedule.dao.ScheduleDao;
import com.kangdainfo.common.schedule.model.bo.MsgObject;
import com.kangdainfo.common.schedule.model.bo.Schedulelog;
import com.kangdainfo.common.util.Common;
import com.kangdainfo.common.util.Datetime;

public abstract class AbstractScheduleDaoImpl implements ScheduleDao {

	protected Logger logger = Logger.getLogger(this.getClass());
	private String scheduleName;
	private String saveLogScheduleName;
				
	public String getSaveLogScheduleName() {
		return saveLogScheduleName;
	}

	public void setSaveLogScheduleName(String saveLogScheduleName) {
		this.saveLogScheduleName = saveLogScheduleName;
	}

	public String getScheduleName() {
		return scheduleName;
	}

	public void setScheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
	}
	
	public void parseScheduleAndSaveLog() {
		MsgObject msgObject = null;
		try {
			msgObject = executeSchedule();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			if("Y".equals(Common.get(saveLogScheduleName))){
				//處理排程錯誤訊息
				processSaveSchedulelog(msgObject);
			}
		}
	}
	
	public void processSaveSchedulelog(MsgObject msgObject){
		//若回傳訊息Key為2為失敗存入Log
		if(msgObject != null){
			HashMap<String,Object> returnMap = (HashMap<String, Object>) msgObject.getReturnMap();
			if(returnMap!=null && returnMap.size()>0){
				StringBuilder sb = new StringBuilder().append(scheduleName);
				boolean isError = false;
				for(Object key : returnMap.keySet()){					
					String errorLog = Common.get(returnMap.get(key));
					if("2".equals(Common.get(key)) && !"".equals(errorLog)){					
						isError = true;
					}
					sb.append(errorLog).append("\n");
				}
				if (isError) {
					Schedulelog schedulelog = new Schedulelog();
					schedulelog.setSchedulename(scheduleName);
					schedulelog.setErrorlog(StringUtils.substring(sb.toString(),0,500));
					schedulelog.setEditdate(Datetime.getYYYMMDD());
					schedulelog.setEdittime(Datetime.getHHMMSS());
					ServiceGetter.getInstance().getCommonService().save(schedulelog);					
				}
			}
		}
	}
	
	public abstract MsgObject executeSchedule() throws Exception;	
}
