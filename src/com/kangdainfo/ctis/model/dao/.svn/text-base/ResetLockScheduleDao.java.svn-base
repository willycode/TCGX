package com.kangdainfo.ctis.model.dao;

import com.kangdainfo.common.schedule.model.bo.MsgObject;
import com.kangdainfo.persistence.BaseDao;

public interface ResetLockScheduleDao extends BaseDao  {
	
	public String getScheduleName();
	public void setScheduleName(String scheduleName);
	
	public void parseScheduleAndSaveLog();
	
	/**
	 * 執行排程
	 */
	public MsgObject executeSchedule() throws Exception;	
}
