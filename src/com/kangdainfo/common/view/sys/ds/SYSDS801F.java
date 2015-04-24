package com.kangdainfo.common.view.sys.ds;

import java.util.HashMap;
import java.util.Map;

import javax.swing.table.DefaultTableModel;

import com.kangdainfo.ServiceGetter;
import com.kangdainfo.common.model.bo.CommonVisitLogDetail;
import com.kangdainfo.common.util.Common;
import com.kangdainfo.common.util.Datetime;
import com.kangdainfo.common.util.SuperBean;
import com.kangdainfo.common.util.View;


/**
程式目的：使用者登出入紀錄查詢
程式代號：SYSDS801F
程式日期：
程式作者：Apple Su
*<br>--------------------------------------------------------
*<br>修改作者                      修改日期             修改目的
*<br>--------------------------------------------------------
*<br>David Chiu    103/08/27  新增「查詢」及「取消」功能按鈕
*/
public class SYSDS801F extends SuperBean {
	final static int    DEFAULT_DBTIME_LENGTH = 6;
	final static String DEFAULT_TIME_START    = "000000";
	final static String DEFAULT_TIME_END      = "999999";
	private String id;
	private String logTimeS;
	private String logTimeE;

	private String q_logDateS;
	private String q_logDateE;
	private String q_logTimeS;	
	private String q_logTimeE;	
	private String q_centerId;
	private String q_userId;
	private String q_userName;
	private String q_outputFormat;
	
	public String getId(){ return Common.get(id); }
	public void setId(String s){ id = checkSet(s); }
	public String getLogTimeS(){ return Common.get(logTimeS); }
	public void setLogTimeS(String s){ logTimeS = checkSet(s); }
	public String getLogTimeE(){ return Common.get(logTimeE); }
	public void setLogTimeE(String s){ logTimeE = checkSet(s); }

	public String getQ_logDateS() { return checkGet(q_logDateS); }
	public void setQ_logDateS(String s) { q_logDateS = checkSet(s); }
	public String getQ_logDateE() { return checkGet(q_logDateE); }
	public void setQ_logDateE(String s) { q_logDateE = checkSet(s); }
	public String getQ_logTimeS() { return checkGet(q_logTimeS); }
	public void setQ_logTimeS(String s) { q_logTimeS = checkSet(s); }
	public String getQ_logTimeE() { return checkGet(q_logTimeE); }
	public void setQ_logTimeE(String s) { q_logTimeE = checkSet(s); }
	public String getQ_centerId() { return checkGet(q_centerId); }
	public void setQ_centerId(String s) { q_centerId = checkSet(s); }
	public String getQ_userId() { return checkGet(q_userId); }
	public void setQ_userId(String s) { q_userId = checkSet(s); }
	public String getQ_userName() { return checkGet(q_userName); }
	public void setQ_userName(String s) { q_userName = checkSet(s); }	
	public String getQ_outputFormat() { return checkGet(q_outputFormat); }
	public void setQ_outputFormat(String s) { q_outputFormat = checkSet(s); }	

	public DefaultTableModel getVisitLogTableModel() throws Exception {
		DefaultTableModel model = new javax.swing.table.DefaultTableModel();
    	String[] cols = new String[] {"userId", "userName", "logDate", "logTime", "userIP", "logStatus", "logMsg", "logAction"};		
    	java.util.ArrayList<String[]> arrList = new java.util.ArrayList<String[]>();
        Map<String, Object> maps = new HashMap<String, Object>();
        StringBuffer hql         = new StringBuffer();
        StringBuffer sb_userName = new StringBuffer();
    	checkTimeField();
		hql.append("From CommonVisitLogDetail Where 1 = 1 ");
		if (!"".equals(getQ_logDateS())) {
            hql.append(" and logDate + logTime >= :logDateTimeStart");
            maps.put("logDateTimeStart", getQ_logDateS() + getLogTimeS());
		}
		if (!"".equals(getQ_logDateE())) {
            hql.append(" and logDate + logTime <= :logDateTimeEnd");
            maps.put("logDateTimeEnd",   getQ_logDateE() + getLogTimeE()); 
		}
		if (!"".equals(getQ_userId())) {
            hql.append(" and userId = :userId");
            maps.put("userId", getQ_userId()); 
		}
		if (!"".equals(getQ_userName())) {
			sb_userName.append("%").append(getQ_userName()).append("%");
            hql.append(" and userName like :userName");
            maps.put("userName", sb_userName.toString()); 
		}

        hql.append(" Order by userId, userName, logDate, logTime");

		java.util.List list = ServiceGetter.getInstance().getCommonService().load(hql.toString(), maps);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				CommonVisitLogDetail obj = (CommonVisitLogDetail) list.get(i);
				String rowArray[]=new String[cols.length];
				rowArray[0]=Common.get(obj.getUserId()); 
				rowArray[1]=Common.get(obj.getUserName()); 
				rowArray[2]=Common.formatYYYMMDD(obj.getLogDate()); 
				rowArray[3]=Common.formatHHMMSS(obj.getLogTime()); 
				rowArray[4]=Common.get(obj.getUserIP());
				rowArray[5]=Common.get(obj.getLogStatus()).equals("N")?"失敗":"成功";
				rowArray[6]=Common.get(obj.getLogMsg());
				rowArray[7]=Common.get(obj.getLogAction()).equals("2")?"登出":"登入";
				arrList.add(rowArray);	
			}
		}		
		if (arrList != null && arrList.size() > 0) {
			String[][] rs = new String[0][0];
			rs = (String[][])arrList.toArray(rs);
			model.setDataVector(rs, cols);
		}			
		return model;
	}

	@Override
	public void doCreate() throws Exception {
	}
	
	@Override
	public void doDelete() throws Exception {
	}	
	
	public void checkTimeField() {
		StringBuilder sb_time_start = new StringBuilder();
	    if(q_logTimeS == null || "".equals(q_logTimeS)) {
			// 若登入時間(起)為「空白」或「未輸入」，則系統將其預設為【000000】
	    	sb_time_start.append(DEFAULT_TIME_START);
	    	setLogTimeS(sb_time_start.toString());
	    } else {
			// 若登入時間(起)有「輸入值」，則讀取其值
	    	sb_time_start.append(getQ_logTimeS());
	    	if(getQ_logTimeS().length() < DEFAULT_DBTIME_LENGTH) {
	    		for(int i = getQ_logTimeS().length() ; i < DEFAULT_DBTIME_LENGTH ; i++) {
	    			// 若登入時間(起)之「輸入值」只輸入部份值，其位數不足，則系統主動補【0】
	    			sb_time_start.append("0");
	    		}
	    	}
	    	setLogTimeS(sb_time_start.toString());
	    }

		StringBuilder sb_time_end   = new StringBuilder();
	    if(q_logTimeE == null || "".equals(q_logTimeE)) {
		    // 若登入時間(迄)為「空白」或「未輸入」，則系統將其預設為【999999】
	    	sb_time_end.append(DEFAULT_TIME_END);
	    	setLogTimeE(sb_time_end.toString());
	    } else {
			// 若登入時間(迄)有「輸入值」，則讀取其值
	    	sb_time_end.append(getQ_logTimeE());
	    	if(getQ_logTimeE().length() < DEFAULT_DBTIME_LENGTH) {
	    		for(int i = getQ_logTimeE().length() ; i < DEFAULT_DBTIME_LENGTH ; i++) {
	    			// 若登入時間(迄)之「輸入值」只輸入部份值，其位數不足，則系統主動補【9】
	    			sb_time_end.append("9");
	    		}
	    	}
	    	setLogTimeE(sb_time_end.toString());
	    }
	}

	@Override
	public java.util.ArrayList<String[]> doQueryAll() throws Exception {
    	java.util.ArrayList<String[]> arrList = new java.util.ArrayList<String[]>();
        Map<String, Object> maps = new HashMap<String, Object>();
        StringBuffer hql         = new StringBuffer();
        StringBuffer sb_userName = new StringBuffer();
    	checkTimeField();
		hql.append("From CommonVisitLogDetail Where 1 = 1 ");
		if (!"".equals(getQ_logDateS())) {
            hql.append(" and logDate + logTime >= :logDateTimeStart");
            maps.put("logDateTimeStart", getQ_logDateS() + getLogTimeS());
		}
		if (!"".equals(getQ_logDateE())) {
            hql.append(" and logDate + logTime <= :logDateTimeEnd");
            maps.put("logDateTimeEnd",   getQ_logDateE() + getLogTimeE()); 
		}
		if (!"".equals(getQ_userId())) {
            hql.append(" and userId = :userId");
            maps.put("userId", getQ_userId()); 
		}
		if (!"".equals(getQ_userName())) {
			sb_userName.append("%").append(getQ_userName()).append("%");
            hql.append(" and userName like :userName");
            maps.put("userName", sb_userName.toString()); 
		}

		this.processCurrentPageAttribute(ServiceGetter.getInstance().getCommonService().loadCount(hql.toString(), maps));

		if (getTotalRecord() > 0) {
			if (getState().indexOf("query") < 0) {
				ServiceGetter.getInstance().getCommonService().clear();
			}

            hql.append(" Order by userId, userName, logDate, logTime");

            java.util.List objList = ServiceGetter.getInstance().getCommonService().load(hql.toString(), this.getRecordStart(), this.getPageSize(), maps);
			if (objList != null && objList.size() > 0) {
				java.util.Iterator it = objList.iterator();
				while (it.hasNext()) {
					CommonVisitLogDetail obj = (CommonVisitLogDetail) it.next();
					String rowArray[] = new String[8];
					rowArray[0] = Common.get(obj.getId()); 
					rowArray[1] = Common.get(obj.getUserId()); 
					rowArray[2] = Common.formatYYYMMDD(obj.getLogDate()); 
					rowArray[3] = Common.formatHHMMSS(obj.getLogTime()); 
					rowArray[4] = Common.get(obj.getUserIP());
					rowArray[5] = Common.get(obj.getLogAction()).equals("2")?"登出":"登入";
					rowArray[6] = Common.get(obj.getLogStatus()).equals("N")?"失敗":"成功";
					rowArray[7] = Common.get(obj.getLogMsg());
					arrList.add(rowArray);
				}
				objList.clear();
			}
		}
		return arrList;
	}

	@Override
	public Object doQueryOne() throws Exception {
		return null;
	}

	@Override
	public void doUpdate() throws Exception {
	}
	
}
