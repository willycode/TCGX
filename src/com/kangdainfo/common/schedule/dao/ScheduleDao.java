package com.kangdainfo.common.schedule.dao;

import com.kangdainfo.common.schedule.model.bo.MsgObject;

public interface ScheduleDao {
	
	public String getScheduleName();
	public void setScheduleName(String scheduleName);
	
	public void parseScheduleAndSaveLog();
	
	/**
	 * 執行排程
	 */
	public MsgObject executeSchedule() throws Exception;	
}
