package com.kangdainfo.ctis.model.dao.impl;

import java.util.HashMap;


import org.jfree.util.Log;

import com.kangdainfo.common.schedule.dao.ScheduleDao;
import com.kangdainfo.common.schedule.dao.impl.AbstractScheduleDaoImpl;
import com.kangdainfo.common.schedule.model.bo.MsgObject;
import com.kangdainfo.ctis.schedule.action.RestLock;

public class ResetLock1ScheduleDaoImpl extends AbstractScheduleDaoImpl implements	ScheduleDao {

	public MsgObject executeSchedule() throws Exception {		
		MsgObject r = new MsgObject();
		HashMap<String,String> resultMap = new HashMap<String,String>();
		logger.info("======== 啟動XXXX排程 ========");
		try {
			RestLock obj = new RestLock();

			r.setReturnMap(obj.update());
		} catch (Exception e) {
			e.printStackTrace();
			String errorMessage = "解除鎖定失敗" + e.getMessage();
			resultMap.put("2", errorMessage);			
			r.setReturnMap(resultMap);
			r.setReturnMsg(errorMessage);
			Log.info(errorMessage);
		}
		logger.info("======== 結束XXXX排程 ========");
		return r;
	}

}
