package com.kangdainfo.ctis.schedule.action;

import java.util.HashMap;

import com.kangdainfo.ServiceGetter;

public class RestLock {

	private HashMap<String, String> resultMap;

	public HashMap<String, String> update() {
		java.util.HashMap<String, String> resultMap = new java.util.HashMap<String, String>();

		try {

			String hql = "update CommonUser set passwordErrorTimes = 0 where 1=1";

			ServiceGetter.getInstance().getCommonService().bulkUpdate(hql);
			resultMap.put("1", "排程處理成功");
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("2", "排程處理失敗");
		}

		return resultMap;
	}

	public HashMap<String, String> getResultMap() {
		return resultMap;
	}

	public void setResultMap(HashMap<String, String> resultMap) {
		this.resultMap = resultMap;
	}
}
