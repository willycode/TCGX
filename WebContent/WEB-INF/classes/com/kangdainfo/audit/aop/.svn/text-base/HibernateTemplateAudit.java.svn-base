package com.kangdainfo.audit.aop;

import java.lang.reflect.Method;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.ThrowsAdvice;

import com.kangdainfo.ServiceGetter;
import com.kangdainfo.common.model.bo.*;
import com.kangdainfo.common.util.Common;
import com.kangdainfo.common.util.Datetime;
import com.kangdainfo.persistence.PersistenceServiceGetter;

public class HibernateTemplateAudit implements AfterReturningAdvice,
		ThrowsAdvice {

	protected Logger logger = Logger.getLogger(this.getClass());

	private List<String> classNamesForQuery;	
	private boolean saveflagQuery;
	private boolean saveflagInsert;
	private boolean saveflagUpdate;
	private boolean saveflagDelete;	

	private class HibernateLog {		
		String methodName;
		String entity;
		String exceptionMessage;
		String progCode;
		String progName;
		String updateId;
		String updateDate;
		String updateTime;
		String updateIp;
	}

	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {		
		//判斷查詢的className是否需紀錄log
		boolean isSave = false;
		if (null != returnValue && returnValue.getClass().getName().equals("java.util.ArrayList"))
		{
			for (Object obj: (java.util.AbstractCollection)returnValue) {
				if(classNamesForQuery != null && classNamesForQuery.size()>0){
					for(String className : classNamesForQuery){				
						if(obj.getClass().getName().equals(className)){
							isSave = true;
							break;
						}
					}
				}
			}
		}		
		String methodName = Common.get(method.getName());
		if(saveflagQuery && isSave && methodName.equals("load")){			
			HibernateLog hLog = getObjectLogMessage(method, args);
			saveLog(hLog);
			logger.info(toString(hLog));
		}
		else if(saveflagInsert && methodName.startsWith("save")){
			HibernateLog hLog = getObjectLogMessage(method, args);
			saveLog(hLog);
			logger.info(toString(hLog));
		}
		else if(saveflagUpdate && ( methodName.startsWith("update") || methodName.startsWith("bulkUpdate"))){
			HibernateLog hLog = getObjectLogMessage(method, args);
			saveLog(hLog);
			logger.info(toString(hLog));
		}
		else if(saveflagDelete && methodName.startsWith("delete")){
			HibernateLog hLog = getObjectLogMessage(method, args);
			saveLog(hLog);
			logger.info(toString(hLog));
		}
	}

	public void afterThrowing(Method method, Object[] args, Object target,
			Throwable t) {		
		HibernateLog hLog = getObjectLogMessage(method, args);
		hLog.exceptionMessage = t.getMessage();
		saveLog(hLog);
		logger.error(toString(hLog));				
	}

	private HibernateLog getObjectLogMessage(Method method, Object[] args) {
		HibernateLog hLog = new HibernateLog();

		CommonUser currentUser = (CommonUser) ServiceGetter.getInstance().getAuthenticationService().getCurrentUser();
		CommonDtree dtree = (CommonDtree) ServiceGetter.getInstance().getAuthenticationService().getCurrentDtree();

		String methodName = Common.get(method.getName());		
		if (methodName.startsWith("save")
				|| methodName.startsWith("update")
				|| methodName.startsWith("delete")) {
			if (args.length == 1) {
				hLog.entity = args[0].toString();
			} else if (args.length == 2) {
				hLog.entity = args[0].toString();
			} 
		} else if (methodName.startsWith("bulk")) {
			hLog.entity = args[0].toString();			
		} else if (methodName.equals("load")) {
			if (args.length == 1) {				
				hLog.entity = args[0].toString();
			}else if (args.length == 2) {			
				hLog.entity = args[0].toString()+args[1].toString();
			}else if (args.length == 3) {			
				hLog.entity = args[0].toString();
			}else if (args.length == 4) {
				hLog.entity = args[0].toString()+args[3].toString();
			}else if (args.length == 5) {
				hLog.entity = args[0].toString();
			}else if (args.length == 6) {
				hLog.entity = args[0].toString()+args[5].toString();
			}else if (args.length == 7) {
				hLog.entity = args[0].toString();
			}	
		}	
		if (currentUser!=null) {
			hLog.updateId = currentUser.getUserId();
			hLog.updateIp = currentUser.getUserIP();			
		}
		
		if (dtree!=null) {
			hLog.progCode = dtree.getBtnRead();
			hLog.progName = dtree.getName();
		}
		
		hLog.methodName = method.getName();
		hLog.updateDate = Datetime.getYYYYMMDD();
		hLog.updateTime = Datetime.getHHMMSS();
		return hLog;
	}

	private void saveLog(HibernateLog hLog) {
		if (hLog != null) {
			if (hLog.entity==null || "".equals(Common.get(hLog.entity)) || Common.get(hLog.entity).length()<11 || hLog.entity.indexOf("CommonVisitLog")!=-1) {
				return;
			}
			try {
				//long id = Common.getLong(View.getObject("select max(id) from CommonAuditLog"))+1;		
				StringBuilder sb1 = new StringBuilder(1024);
				sb1.append("INSERT INTO COMMON_AuditLog(id,logDate,logTime,updateId,updateDate,updateTime,updateIp,methodName,entity,exceptionMessage,progCode,progName)VALUES(");
				sb1.append("?,");
				sb1.append("?,");
				sb1.append("?,");
				sb1.append("?,");
				sb1.append("?,");
				sb1.append("?,");
				sb1.append("?,");
				sb1.append("?,");
				sb1.append("?,");
				sb1.append("?,");
				sb1.append("?,");
				sb1.append("?)");					
				PersistenceServiceGetter.getInstance().getJdbcTemplate().update(sb1.toString(), new Object[]{Common.getVMID(),Datetime.getYYYMMDD(), Datetime.getHHMMSS(), hLog.updateId, hLog.updateDate, hLog.updateTime, hLog.updateIp, hLog.methodName, hLog.entity, StringUtils.substring(Common.get(hLog.exceptionMessage),0,800), hLog.progCode, hLog.progName});				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private String toString(HibernateLog hLog) {
		if (hLog == null) return null;
		StringBuilder sb = new StringBuilder();
		sb.append('"').append(hLog.updateId).append('"').append(',');
		sb.append('"').append(hLog.updateDate).append('"').append(',');
		sb.append('"').append(hLog.updateTime).append('"').append(',');
		sb.append('"').append(hLog.updateIp).append('"').append(',');
		sb.append('"').append(hLog.methodName).append('"').append(',');
		sb.append('"').append(hLog.entity).append('"').append(',');
		sb.append('"').append(hLog.exceptionMessage).append('"');
		return sb.toString();
	}
	
	public boolean isSaveflagQuery() {
		return saveflagQuery;
	}
	public void setSaveflagQuery(boolean saveflagQuery) {
		this.saveflagQuery = saveflagQuery;
	}
	public boolean isSaveflagInsert() {
		return saveflagInsert;
	}
	public void setSaveflagInsert(boolean saveflagInsert) {
		this.saveflagInsert = saveflagInsert;
	}
	public boolean isSaveflagUpdate() {
		return saveflagUpdate;
	}
	public void setSaveflagUpdate(boolean saveflagUpdate) {
		this.saveflagUpdate = saveflagUpdate;
	}
	public boolean isSaveflagDelete() {
		return saveflagDelete;
	}
	public void setSaveflagDelete(boolean saveflagDelete) {
		this.saveflagDelete = saveflagDelete;
	}
	public List<String> getClassNamesForQuery() {
		return classNamesForQuery;
	}
	public void setClassNamesForQuery(List<String> classNamesForQuery) {
		this.classNamesForQuery = classNamesForQuery;
	}

}
