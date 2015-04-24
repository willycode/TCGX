package com.kangdainfo.workflow.view;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.kangdainfo.ServiceGetter;
import com.kangdainfo.common.model.bo.CommonGroup;
import com.kangdainfo.common.util.Common;
import com.kangdainfo.common.util.Datetime;
import com.kangdainfo.common.util.SuperBean;
import com.kangdainfo.common.util.View;
import com.kangdainfo.workflow.model.bo.FramePath;
import com.kangdainfo.workflow.model.bo.WorkFlow;

/**
*<br>程式目的：帳號維護作業
*<br>程式代號：sysap001f
*<br>程式日期：0960915
*<br>程式作者：clive.chang
*<br>--------------------------------------------------------
*<br>修改作者　　修改日期　　　修改目的
*<br>--------------------------------------------------------
*/

public class SETUP001F extends SuperBean{


String id;
String codeId;			//流程類型  CodeKind=WF
String taskName;		//節點代號(20)
String taskChName;		//節點名稱(30)
String forwardKind; 	//回應類別(1.action 2.JSP 3.直接導向action，不需要經過TodoList清單)
String actionName;		//Action(100)
String eventName;		//Method(30)
String pagePath;		//JSP(100)
String roleCode;		//可執行角色
String modAccount;		//修改人員(20)
Date modDate;			//修改時間
String casseStatus;		//在本節點的狀態
String jsonString;

String q_isQuery;
String q_id;
String q_codeId;
String q_taskName;
String q_taskChName;
String q_roleCode;

@Override
public void doCreate() throws Exception {
	FramePath obj = (FramePath) View.getObject("from " + FramePath.class.getCanonicalName() + " where taskName =" + Common.sqlChar(getTaskName()));
	if (obj!=null) {
		throw new Exception("新增失敗，節點重覆!");
	} else {
		obj = new FramePath();
		obj.setCodeId(Common.get(codeId));               //流程類型  CodeKind=WF
		obj.setTaskName(Common.get(taskName));           //節點代號(20)
		obj.setTaskChName(Common.get(taskChName));       //節點名稱(30)
		obj.setForwardKind(Common.getInt(forwardKind));  //回應類別(1.action 2.JSP 3.直接導向action，不需要經過TodoList清單)
		obj.setActionName(Common.get(actionName));		  //Action(100)
		obj.setEventName(Common.get(eventName));		  //Method(30)
		obj.setPagePath(Common.get(pagePath));		      //JSP(100)
		obj.setRoleCode(Common.get(roleCode));		      //可執行角色
		obj.setModAccount(Common.get(modAccount));		      //修改人員(20)
		DateFormat df = DateFormat.getDateInstance();
		Date modDate = df.parse(Datetime.formatDateYYYYMMDD(getEditDate()));
		obj.setModDate(modDate);			                  //修改時間
		ServiceGetter.getInstance().getCommonService().save(obj);
		setId(Common.get(obj.getId()));
	}
}


@Override
public void doUpdate() throws Exception {
	FramePath obj = (FramePath) View.getObject("from  " + FramePath.class.getCanonicalName() + " where id=" + Common.getInt(getId()));	
	if(obj != null){
		obj.setCodeId(Common.get(codeId));               //流程類型  CodeKind=WF
		obj.setTaskName(Common.get(taskName));           //節點代號(20)
		obj.setTaskChName(Common.get(taskChName));       //節點名稱(30)
		obj.setForwardKind(Common.getInt(forwardKind));  //回應類別(1.action 2.JSP 3.直接導向action，不需要經過TodoList清單)
		obj.setActionName(Common.get(actionName));		  //Action(100)
		obj.setEventName(Common.get(eventName));		  //Method(30)
		obj.setPagePath(Common.get(pagePath));		      //JSP(100)
		obj.setRoleCode(Common.get(roleCode));		      //可執行角色
		obj.setModAccount(Common.get(modAccount));		      //修改人員(20)
		DateFormat df = DateFormat.getDateInstance();
        Date modDate = df.parse(Datetime.formatDateYYYYMMDD(getEditDate()));
		obj.setModDate(modDate);			                  //修改時間
		ServiceGetter.getInstance().getCommonService().update(obj);
	}else{
		throw new Exception("修改失敗，查無資料!");
	}
}

@Override
public void doDelete() throws Exception {    
    int c1 = ServiceGetter.getInstance().getCommonService().loadCount(" from  " + WorkFlow.class.getCanonicalName() + " where parent.id="+Common.getLong(getId()));
    if(c1 >0){
    	throw new Exception("請先刪除該節點流程資料!");
    }else{
    	int c2 = ServiceGetter.getInstance().getCommonService().loadCount(" from  " + WorkFlow.class.getCanonicalName() + "  where nextFramePath.id="+Common.getLong(getId()));
    	if(c2 >0){
    		throw new Exception("上有流程資料使用該節點，請先刪除流程資料!");
    	}else{
    		ServiceGetter.getInstance().getCommonService().delete(FramePath.class, Common.getLong(getId()));	
    		setId("");
    	}
    }
}


/**
 * <br>
 * <br>目的：依主鍵查詢單一資料
 * <br>參數：無
 * <br>傳回：傳回本物件
*/

public SETUP001F  doQueryOne() throws Exception {
	SETUP001F obj = this;
	FramePath c = (FramePath) View.getObject(" from   " + FramePath.class.getCanonicalName() + "  where id="+Common.sqlChar(getId()));
	if (c!=null) {
		obj.setCodeId(Common.get(c.getCodeId()));               //流程類型  CodeKind=WF
		obj.setTaskName(Common.get(c.getTaskName()));           //節點代號(20)
		obj.setTaskChName(Common.get(c.getTaskChName()));       //節點名稱(30)
		obj.setForwardKind(Common.get(c.getForwardKind()));     //回應類別(1.action 2.JSP 3.直接導向action，不需要經過TodoList清單)
		obj.setActionName(Common.get(c.getActionName()));		//Action(100)
		obj.setEventName(Common.get(c.getEventName()));		    //Method(30)
		obj.setPagePath(Common.get(c.getPagePath()));		    //JSP(100)
		obj.setRoleCode(Common.get(c.getRoleCode()));		    //可執行角色
		obj.setEditID(Common.get(c.getModAccount()));		    //修改人員(20)
		obj.setEditDate(Common.get(c.getModDate()));			//修改時間		
		//將流程全部呈現
		obj.setJsonString(Common.getFramePath(c));
	} else throw new Exception("查無該筆資料！");
	return obj;
}


/**
 * <br>
 * <br>目的：依查詢欄位查詢多筆資料
 * <br>參數：無
 * <br>傳回：傳回ArrayList
*/

	public java.util.ArrayList<String[]> doQueryAll() throws Exception {
		java.util.ArrayList<String[]> arrList = new java.util.ArrayList<String[]>();
		Map<String, Object> maps = new HashMap<String, Object>();
		if (!"".equals(getQ_isQuery())){
			setQ_id("");
		}
		StringBuffer sb = new StringBuffer();
		sb.append("from  ").append(FramePath.class.getCanonicalName()).append(" where 1=1 ");
		if(!"".equals(getQ_id())){
			sb.append(" and id = ").append(Common.getLong(getQ_id()));			
		}else{
			if (!"".equals(getQ_codeId()))
				sb.append(" and codeId = ").append(Common.sqlChar(getQ_codeId()));
			if (!"".equals(getQ_taskName())) {
				sb.append(" and taskName like :taskName ");
				maps.put("taskName", getQ_taskName() + "%");  //Add Ay Apple Su 20140620
			}
			if (!"".equals(getQ_taskChName())) {
				sb.append(" and taskChName like :taskChName ");
				maps.put("taskChName","%"+getQ_taskChName()+"%");  //Add Ay Apple Su 20140620
			}
			if (!"".equals(getQ_roleCode()))
				sb.append("and roleCode = ").append(Common.sqlChar(getQ_roleCode()));
		}
		this.processCurrentPageAttribute(ServiceGetter.getInstance().getCommonService().loadCount(sb.toString(), maps));
		if (getTotalRecord() > 0) {
			if (getState().indexOf("query")<0) 
				ServiceGetter.getInstance().getCommonService().getCommonUserDao().clear();
			
			java.util.List objList = ServiceGetter.getInstance().getCommonService().load(sb.toString(), this.getRecordStart(), this.getPageSize(), "id", true, maps);
			if (objList != null && objList.size() > 0) {
				java.util.Map<String, String> wfMap = ServiceGetter.getInstance().getCommonService().getCommonCodeDao().getCommonCodeNameMap("WF",null);
				java.util.Iterator it = objList.iterator();
				while (it.hasNext()) {
					FramePath o = (FramePath) it.next();		
					
					String rowArray[] = new String[5];
					rowArray[0] = Common.get(o.getId());
					rowArray[1] = Common.get(wfMap.get(o.getCodeId()));
					rowArray[2] = Common.get(o.getTaskName());
					rowArray[3] = Common.get(o.getTaskChName());
					rowArray[4] = Common.get(View.getObject("select groupName||'-'||groupDesc from  " + CommonGroup.class.getCanonicalName()+" where id=" + Common.sqlChar(o.getRoleCode())));
					arrList.add(rowArray);					
				}
			}
		}
		return arrList;
	}
	
	public String getId(){ return checkGet(id); }
	public void setId(String s){ id=checkSet(s); }
	public String getCodeId() {
		return checkGet(codeId);
	}
	public void setCodeId(String codeId) {
		this.codeId =checkSet(codeId);
	}
	public String getTaskName() {
		return checkGet(taskName);
	}
	public void setTaskName(String taskName) {
		this.taskName =checkSet(taskName);
	}
	public String getTaskChName() {
		return checkGet(taskChName);
	}
	public void setTaskChName(String taskChName) {
		this.taskChName =checkSet(taskChName);
	}
	public String getForwardKind() {
		return checkGet(forwardKind);
	}
	public void setForwardKind(String forwardKind) {
		this.forwardKind =checkSet(forwardKind);
	}
	public String getActionName() {
		return checkGet(actionName);
	}
	public void setActionName(String actionName) {
		this.actionName =checkSet(actionName);
	}
	public String getEventName() {
		return checkGet(eventName);
	}
	public void setEventName(String eventName) {
		this.eventName =checkSet(eventName);
	}
	public String getPagePath() {
		return checkGet(pagePath);
	}
	public void setPagePath(String pagePath) {
		this.pagePath =checkSet(pagePath);
	}
	public String getRoleCode() {
		return checkGet(roleCode);
	}
	public void setRoleCode(String roleCode) {
		this.roleCode =checkSet(roleCode);
	}
	public String getModAccount() {
		return checkGet(modAccount);
	}
	public void setModAccount(String modAccount) {
		this.modAccount =checkSet(modAccount);
	}
	public Date getModDate() {
		return modDate;
	}
	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}
	public String getCasseStatus() {
		return checkGet(casseStatus);
	}
	public void setCasseStatus(String casseStatus) {
		this.casseStatus =checkSet(casseStatus);
	}	
	public String getQ_isQuery() {
		return checkGet(q_isQuery);
	}
	public void setQ_isQuery(String q_isQuery) {
		this.q_isQuery = checkSet(q_isQuery);
	}
	public String getQ_id() {
		return checkGet(q_id);
	}
	public void setQ_id(String q_id) {
		this.q_id = checkSet(q_id);
	}
	public String getQ_codeId() {
		return checkGet(q_codeId);
	}
	public void setQ_codeId(String q_codeId) {
		this.q_codeId =checkSet(q_codeId);
	}
	public String getQ_taskName() {
		return checkGet(q_taskName);
	}
	public void setQ_taskName(String q_taskName) {
		this.q_taskName =checkSet(q_taskName);
	}
	public String getQ_taskChName() {
		return checkGet(q_taskChName);
	}
	public void setQ_taskChName(String q_taskChName) {
		this.q_taskChName =checkSet(q_taskChName);
	}
	public String getQ_roleCode() {
		return checkGet(q_roleCode);
	}
	public void setQ_roleCode(String q_roleCode) {
		this.q_roleCode =checkSet(q_roleCode);
	}

	public String getJsonString() {
		return Common.get(jsonString);
	}

	public void setJsonString(String jsonString) {
		this.jsonString = Common.set(jsonString);
	}
	
}


