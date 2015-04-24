package com.kangdainfo.workflow.model.bo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Formula;

@Entity
@Table(name = "FLOW_HANDLE")
public class Handle implements Serializable
{ 
    private static final long serialVersionUID = 1L;
 
    private Long id;						//唯一編號
    private String processName;	            //流程編號(20)，如process01
    private Integer caseId; 	            //案件序號
    private String initCaseNo; 	            //案件編號(30)
    private Integer seq;	                //序號
    private String stepName;   	            //作業名稱(30
    private String sponsor;	                //主協辦(30)
    private String deptCode;   	            //單位代碼(20)
    private String deptName;   	            //單位名稱(100)
    private String userId; 	                //人員代號 (20)
    private String userName;   	            //人員姓名(50)
    private Date beginTime; 	            //TaskNode開始時間
    private Date receiveTime;	            //TaskNode接收日期
    private Date endTime;	                //TaskNode結束時間
    private String handles;	                //處理情形(255)
    private String comment;	                //處理意見(255)
    private String note;   	                //備註(255)
    private String flowChange; 	            //流程異動(255)
    private CaseNode caseNode;   
	
    @Id
	@Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {	return id;	}
    public void setId(Long id) {	this.id = id;	};    
    
    @Column(length=20)
    public String getProcessName() {	return processName;	}
	public void setProcessName(String processName) {	this.processName = processName;	}
	
	public Integer getCaseId() {	return caseId;	}
	public void setCaseId(Integer caseid) {	this.caseId = caseId;	}
	
	@Column(length=30)
	public String getInitCaseNo() {	return initCaseNo;	}
	public void setInitCaseNo(String initCaseNo) {	this.initCaseNo = initCaseNo;	}
	
	@Column
	public Integer getSeq() {	return seq;	}
	public void setSeq(Integer seq) {	this.seq = seq;	}
	
	@Column(length=30)
	public String getStepName() {	return stepName;	}
	public void setStepName(String stepName) {	this.stepName = stepName;	}
	
	@Column(length=30)
	public String getSponsor() {	return sponsor;	}
	public void setSponsor(String sponsor) {	this.sponsor = sponsor;	}
	
	@Column(length=20)
	public String getDeptCode() {	return deptCode;	}
	public void setDeptCode(String deptCode) {	this.deptCode = deptCode;	}
	
	@Column(length=100)
	public String getDeptName() {	return deptName;	}
	public void setDeptName(String deptName) {	this.deptName = deptName;	}
	
	@Column(length=20)
	public String getUserId() {	return userId;	}
	public void setUserId(String userId) {	this.userId = userId;	}
	
	@Column(length=50)
	public String getUserName() {	return userName;	}
	public void setUserName(String userName) {	this.userName = userName;	}
	
	@Column
	public Date getBeginTime() {	return beginTime;	}	
	public void setBeginTime(Date beginTime) {	this.beginTime = beginTime;	}
	
	@Column
	public Date getReceiveTime() {	return receiveTime;	}
	public void setReceiveTime(Date receiveTime) {	this.receiveTime = receiveTime;	}
	
	@Column
	public Date getEndTime() {	return endTime;	}
	public void setEndTime(Date endTime) {	this.endTime = endTime;	}
	
	@Column(length=255)
	public String getHandles() {	return handles;	}
	public void setHandles(String handles) {	this.handles = handles;	}
	
	@Column(length=255)
	public String getComment() {	return comment;	}
	public void setComment(String comment) {	this.comment = comment;	}
	
	@Column(length=255)
	public String getNote() {	return note;	}
	public void setNote(String note) {	this.note = note;	}
	
	@Column
	public String getFlowChange() {	return flowChange;	}
	public void setFlowChange(String flowChange) {	this.flowChange = flowChange;	}
	
	@ManyToOne
    public CaseNode getCaseNode() { return caseNode; }
	public void setCaseNode(CaseNode caseNode) { this.caseNode = caseNode; }	

	
    public static Handle getNullInstance()
    {
    	Handle handle = new Handle();
    	handle.setId(Long.valueOf(0));
    	handle.setCaseNode(CaseNode.getNullInstance());
    	return handle;
    }
	
    @Override
	public String toString() {
		return "Handle [id=" + id + ", processName=" + processName
				+ ", caseId=" + caseId + ", initCaseNo=" + initCaseNo
				+ ", seq=" + seq + ", stepName=" + stepName + ", sponsor="
				+ sponsor + ", deptCode=" + deptCode + ", deptName=" + deptName
				+ ", userId=" + userId + ", userName=" + userName
				+ ", beginTime=" + beginTime + ", receiveTime=" + receiveTime
				+ ", endTime=" + endTime + ", handles=" + handles
				+ ", comment=" + comment + ", note=" + note + ", flowChange="
				+ flowChange + ", caseNode=" + caseNode + "]";
	}	

}
