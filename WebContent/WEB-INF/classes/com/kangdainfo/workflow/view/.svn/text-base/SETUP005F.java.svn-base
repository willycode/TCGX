package com.kangdainfo.workflow.view;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.set.ListOrderedSet;
import org.joda.time.DateTime;

import com.kangdainfo.ServiceGetter;
import com.kangdainfo.common.model.bo.CommonDepartment;
import com.kangdainfo.common.model.bo.CommonUser;
import com.kangdainfo.common.model.bo.CommonUserGroup;
import com.kangdainfo.common.util.Common;
import com.kangdainfo.common.util.Datetime;
import com.kangdainfo.common.util.SuperBean;
import com.kangdainfo.common.util.View;
import com.kangdainfo.workflow.model.bo.CaseNode;
import com.kangdainfo.workflow.model.bo.FramePath;
import com.kangdainfo.workflow.model.bo.Handle;
import com.kangdainfo.workflow.model.bo.WorkFlow;

/**
*<br>程式目的：新增caseNode作業
*<br>程式代號：setup005f
*<br>程式日期：1030812
*<br>程式作者：KangDa
*<br>--------------------------------------------------------
*<br>修改作者　　修改日期　　　修改目的
*<br>--------------------------------------------------------
*/

public class SETUP005F extends SuperBean{

String id;					  //唯一編號
String projectCode;	          //專案代號
String caseId; 	              //案件序號ExpSharePiece.Id
String initCaseNo; 	          //案件編號(30)
String status;                //觸發下一關
String processNameId;         //流程編號
String taskName;  	          //節點代號(20)
String taskChName; 	          //節點名稱
String deptCode;   	          //單位代碼(20)
String deptName;   	          //單位名稱(100)
String userId; 	              //人員代號 (20)  可以是角色
String userName;   	          //人員姓名(50)

String deptCode2;   	      //單位代碼(20)
String deptName2;   	      //單位名稱(100)
String userId2; 	          //人員代號 (20)  可以是角色
String userName2;   	      //人員姓名(50)
String comment;               //處理意見
String nextDeptCode;          //下一關使用者單位
String nextDeptName;          //下一關使用者單位名稱
String nextUserId;            //下一關使用者代號
String nextUserName;          //下一關使用者名稱

String q_taskName;

@Override
public void doCreate() throws Exception {
	CaseNode obj = (CaseNode) View.getObject("from CaseNode where projectCode =" +Common.sqlChar(getProjectCode())+
			                                 " and caseId="+Common.getLong(Common.get(getCaseId()))+
			                                 " and initCaseNo="+Common.sqlChar(getInitCaseNo()));
	if (obj!=null) {
		throw new Exception("新增失敗，節點重覆!");
	} else {		
		java.util.List<Handle> dtlHandle = new java.util.ArrayList<Handle>();	
		CommonDepartment dept = (CommonDepartment)View.getObject(" from CommonDepartment where id="+getDeptCode());
		FramePath fpath = (FramePath) View.getObject(" from FramePath where codeId="+Common.sqlChar(getProcessNameId())+
				                                     " and taskName="+Common.sqlChar(getTaskName()));		
		java.util.Map<String, String> wfMap = ServiceGetter.getInstance().getCommonService().getCommonCodeDao().getCommonCodeNameMap("WF",null);
		
		obj = new CaseNode();		
		obj.setProjectCode(Common.get(getProjectCode()));
		obj.setCaseId(Common.getInt(Common.get(getCaseId())));
		obj.setInitCaseNo(Common.get(getInitCaseNo()));
		if(fpath != null){
			obj.setTaskName(Common.get(fpath.getTaskName()));
			obj.setTaskChName(Common.get(fpath.getTaskChName()));
		}		
		obj.setManKind("1");
		if(dept != null){		
			obj.setDeptCode(Common.get(dept.getDepartmentCode()));		
			obj.setDeptName(Common.get(dept.getDepartment()));
		}
		obj.setUserId(Common.get(getUserId()));
		obj.setUserName(Common.get(getUserName()));	
		obj.setBeginTime(new Date());
		obj.setReceiveTime(null);
		
		Handle dtl = new Handle();
		dtl.setCaseNode(obj);
		dtl.setProcessName(wfMap.get(Common.get(getProcessNameId())));
		dtl.setCaseId(Common.getInt(Common.get(getCaseId())));
		dtl.setInitCaseNo(Common.get(getInitCaseNo()));
		dtl.setSeq(1);		
		if(fpath != null){
			dtl.setStepName(Common.get(fpath.getTaskChName()));
		}	
		dtl.setSponsor("1");		
        if(dept != null){
        	dtl.setDeptCode(Common.get(dept.getDepartmentCode()));
    		dtl.setDeptName(Common.get(dept.getDepartment()));
        }		
		dtl.setUserId(Common.get(getUserId()));
		dtl.setUserName(Common.get(getUserName()));
		dtl.setBeginTime(new Date());
		dtl.setReceiveTime(null);
		dtl.setComment("新增啟動流程");		
		dtlHandle.add(dtl);		
		obj.setHandles(dtlHandle);
		
		ServiceGetter.getInstance().getCommonService().save(obj);
		setId(Common.get(obj.getId()));
	}
}

@Override
public void doUpdate() throws Exception {
	CaseNode obj = (CaseNode) View.getObject(" from CaseNode where id="+getId());
	if (obj!=null) {		
		CommonDepartment dept = (CommonDepartment)View.getObject(" from CommonDepartment where id="+getDeptCode());		
		if(dept != null){		
			obj.setDeptCode(Common.get(dept.getDepartmentCode()));		
			obj.setDeptName(Common.get(dept.getDepartment()));
		}
		obj.setUserId(Common.get(getUserId()));
		obj.setUserName(Common.get(getUserName()));
		obj.setReceiveTime(new Date());
		Handle dtl = (Handle)View.getObject(" from Handle where endTime is null and caseNode.id="+Common.getLong(obj.getId()));
		if(dtl != null){
			if(dept != null){
	        	dtl.setDeptCode(Common.get(dept.getDepartmentCode()));
	    		dtl.setDeptName(Common.get(dept.getDepartment()));
	        }		
			dtl.setUserId(Common.get(getUserId()));
			dtl.setUserName(Common.get(getUserName()));
			dtl.setReceiveTime(new Date());
			ServiceGetter.getInstance().getCommonService().update(dtl);
		}
		ServiceGetter.getInstance().getCommonService().update(obj);
	}
	else 
		throw new Exception("查無該筆資料！");
}

public void doUpdateNext() throws Exception {
	CaseNode obj = (CaseNode) View.getObject(" from CaseNode where id="+getId());
	if (obj!=null) {
		CommonDepartment deptNext = null;
		if(!"".equals(Common.get(getNextDeptCode()))){
			deptNext = (CommonDepartment)View.getObject(" from CommonDepartment where id="+getNextDeptCode());
		}				
		WorkFlow wf = (WorkFlow) View.getObject(" from WorkFlow where status="+Common.sqlChar(getStatus())+
				                                " and parent.taskName="+Common.sqlChar(getTaskName()));
		FramePath fpNext = null;
		if(wf != null){
			fpNext = (FramePath) View.getObject(" from FramePath where id="+Common.getLong(wf.getNextFramePath().getId()));
		}
		if(wf != null && fpNext != null){
			obj.setTaskName(Common.get(fpNext.getTaskName()));
			obj.setTaskChName(Common.get(fpNext.getTaskChName()));
			if(deptNext != null){
				obj.setDeptCode(Common.get(deptNext.getDepartmentCode()));		
				obj.setDeptName(Common.get(deptNext.getDepartment()));
			}
			if("".equals(Common.get(getNextUserId()))){
				obj.setManKind("2");
				obj.setUserId(Common.get(fpNext.getRoleCode()));
				obj.setUserName(Common.get(fpNext.getRoleName()));
			}else{
				obj.setManKind("1");
				obj.setUserId(Common.get(getNextUserId()));
				obj.setUserName(Common.get(getNextUserName()));
			}
			obj.setBeginTime(new Date());
			obj.setReceiveTime(null);
			obj.setEndTime(null);
			obj.setLastNote(Common.get(getComment()));
			
			ServiceGetter.getInstance().getCommonService().update(obj);
			
			//更新Handle(E)
			Handle dtl = (Handle)View.getObject(" from Handle where endTime is null and caseNode.id="+Common.getLong(obj.getId()));
			if(dtl != null){
				CommonDepartment dept = null;
				if(!"".equals(Common.get(getDeptCode2()))){
					dept = (CommonDepartment)View.getObject(" from CommonDepartment where id="+getDeptCode2());
				}
				if(dtl.getReceiveTime() == null) 
					dtl.setReceiveTime(dtl.getBeginTime());
				dtl.setEndTime(new Date());
				dtl.setComment(Common.get(getComment()));
				
				if(dept != null){
		        	dtl.setDeptCode(Common.get(dept.getDepartmentCode()));
		    		dtl.setDeptName(Common.get(dept.getDepartment()));
		        }		
				dtl.setUserId(Common.get(getUserId2()));
				dtl.setUserName(Common.get(getUserName2()));
								
				ServiceGetter.getInstance().getCommonService().update(dtl);
				
				//新增Handle
				Handle dtlnew = new Handle();				
				dtlnew.setCaseNode(dtl.getCaseNode());
				dtlnew.setProcessName(dtl.getProcessName());
				dtlnew.setCaseId(dtl.getCaseId());
				dtlnew.setInitCaseNo(dtl.getInitCaseNo());				
				int maxSeq = Common.getInt(View.getLookupField("select max(seq) from Handle where caseid="+dtl.getCaseId()));
				dtlnew.setSeq(maxSeq+1);	//相同caseid的handle的seq最大值+1			
				dtlnew.setStepName(Common.get(fpNext.getTaskChName()));					
				dtlnew.setSponsor(dtl.getSponsor());		
		        
		        dtlnew.setDeptCode(Common.get(obj.getDeptCode()));
		    	dtlnew.setDeptName(Common.get(obj.getDeptName()));		        		
				dtlnew.setUserId(Common.get(obj.getUserId()));
				dtlnew.setUserName(Common.get(obj.getUserName()));
				dtlnew.setBeginTime(new Date());
				dtlnew.setReceiveTime(null);
				
				ServiceGetter.getInstance().getCommonService().save(dtlnew);
			}			
		}	
	}
}

@Override
public void doDelete() throws Exception {
}


/**
 * <br>
 * <br>目的：依主鍵查詢單一資料
 * <br>參數：無
 * <br>傳回：傳回本物件
*/

public SETUP005F  doQueryOne() throws Exception {
	SETUP005F obj = this;
	CaseNode c = (CaseNode) View.getObject(" from CaseNode where id="+getId());
	if (c!=null) {
		java.util.Map<String,String>  wfMap = Common.getMap("select codeName,codeId from CommonCode where commonCodeKind.codeKindId='WF' "); 
		
		obj.setProjectCode(Common.get(c.getProjectCode()));
		obj.setCaseId(Common.get(c.getCaseId()));
		obj.setInitCaseNo(Common.get(c.getInitCaseNo()));
		
		Handle dtl = (Handle)View.getObject(" from Handle where endtime is null and caseNode.id="+Common.getLong(c.getId()));
		if(dtl != null){
			obj.setProcessNameId(wfMap.get(Common.get(dtl.getProcessName())));
		}		
		obj.setTaskName(Common.get(c.getTaskName()));
		obj.setTaskChName(Common.get(c.getTaskChName()));		
		CommonDepartment dept = (CommonDepartment)View.getObject(" from CommonDepartment where departmentCode="+c.getDeptCode());
		if(dept != null){
			obj.setDeptCode(Common.get(dept.getId()));
			obj.setDeptName(Common.get(dept.getDepartment()));
			obj.setDeptCode2(Common.get(dept.getId()));
			obj.setDeptName2(Common.get(dept.getDepartment()));
		}
		if("1".equals(Common.get(c.getManKind()))){
			obj.setUserId(Common.get(c.getUserId()));
			obj.setUserName(Common.get(c.getUserName()));
			obj.setUserId2(Common.get(c.getUserId()));
			obj.setUserName2(Common.get(c.getUserName()));
		}		
	} else 
		throw new Exception("查無該筆資料！");
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
		
		StringBuffer sb = new StringBuffer();
		sb.append("from CaseNode where endtime is null ");

		this.processCurrentPageAttribute(ServiceGetter.getInstance().getCommonService().loadCount(sb.toString(), maps));
		if (getTotalRecord() > 0) {
			if (getState().indexOf("query")<0) 
				ServiceGetter.getInstance().getCommonService().getCommonUserDao().clear();
			
			java.util.List objList = ServiceGetter.getInstance().getCommonService().load(sb.toString(), this.getRecordStart(), this.getPageSize(),  maps);
			if (objList != null && objList.size() > 0) {
				
				java.util.Iterator it = objList.iterator();
				while (it.hasNext()) {
					CaseNode o = (CaseNode) it.next();					
					String rowArray[] = new String[4];
					rowArray[0] = Common.get(o.getId());
					rowArray[1] = Common.get(o.getProjectCode());
					rowArray[2] = Common.get(o.getTaskName());
					rowArray[3] = Common.get(o.getTaskChName());
					arrList.add(rowArray);					
				}
			}
		}
		return arrList;
	}
	
	public String getId(){ return checkGet(id); }
	public void setId(String s){ id=checkSet(s); }

	public String getProjectCode() {
		return checkGet(projectCode);
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = checkSet(projectCode);
	}
	public String getCaseId() {
		return checkGet(caseId);
	}
	public void setCaseId(String caseId) {
		this.caseId = checkSet(caseId);
	}
	public String getInitCaseNo() {
		return checkGet(initCaseNo);
	}
	public void setInitCaseNo(String initCaseNo) {
		this.initCaseNo = checkSet(initCaseNo);
	}
	public String getStatus() {
		return checkGet(status);
	}
	public void setStatus(String status) {
		this.status = checkSet(status);
	}
	public String getProcessNameId() {
		return checkGet(processNameId);
	}
	public void setProcessNameId(String processNameId) {
		this.processNameId = checkSet(processNameId);
	}
	public String getTaskName() {
		return checkGet(taskName);
	}
	public void setTaskName(String taskName) {
		this.taskName = checkSet(taskName);
	}
	public String getTaskChName() {
		return checkGet(taskChName);
	}
	public void setTaskChName(String taskChName) {
		this.taskChName = checkSet(taskChName);
	}
	public String getDeptCode() {
		return checkGet(deptCode);
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = checkSet(deptCode);
	}
	public String getDeptName() {
		return checkGet(deptName);
	}
	public void setDeptName(String deptName) {
		this.deptName = checkSet(deptName);
	}
	public String getUserId() {
		return checkGet(userId);
	}
	public void setUserId(String userId) {
		this.userId = checkSet(userId);
	}
	public String getUserName() {
		return checkGet(userName);
	}
	public void setUserName(String userName) {
		this.userName = checkSet(userName);
	}
	public String getDeptCode2() {
		return checkGet(deptCode2);
	}
	public void setDeptCode2(String deptCode2) {
		this.deptCode2 = checkSet(deptCode2);
	}
	public String getDeptName2() {
		return checkGet(deptName2);
	}
	public void setDeptName2(String deptName2) {
		this.deptName2 = checkSet(deptName2);
	}
	public String getUserId2() {
		return checkGet(userId2);
	}
	public void setUserId2(String userId2) {
		this.userId2 = checkSet(userId2);
	}
	public String getUserName2() {
		return checkGet(userName2);
	}
	public void setUserName2(String userName2) {
		this.userName2 = checkSet(userName2);
	}
	public String getComment() {
		return checkGet(comment);
	}
	public void setComment(String comment) {
		this.comment = checkSet(comment);
	}
	public String getNextDeptCode() {
		return checkGet(nextDeptCode);
	}
	public void setNextDeptCode(String nextDeptCode) {
		this.nextDeptCode = checkSet(nextDeptCode);
	}
	public String getNextDeptName() {
		return checkGet(nextDeptName);
	}
	public void setNextDeptName(String nextDeptName) {
		this.nextDeptName = checkSet(nextDeptName);
	}
	public String getNextUserId() {
		return checkGet(nextUserId);
	}
	public void setNextUserId(String nextUserId) {
		this.nextUserId = checkSet(nextUserId);
	}
	public String getNextUserName() {
		return checkGet(nextUserName);
	}
	public void setNextUserName(String nextUserName) {
		this.nextUserName = checkSet(nextUserName);
	}
	public String getQ_taskName() {
		return checkGet(q_taskName);
	}
	public void setQ_taskName(String q_taskName) {
		this.q_taskName = checkSet(q_taskName);
	}	

}


