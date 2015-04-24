package com.kangdainfo.workflow.model.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FLOW_CASENODE")
public class CaseNode implements Serializable
{ 
    private static final long serialVersionUID = 1L;
 
    private Long id;					  //唯一編號
    private String projectCode;	          //專案代號
    private Integer caseId; 	          //案件序號ExpSharePiece.Id
    private String initCaseNo; 	          //案件編號(30)
    private String initCaseNoInner;	      //案件編號內碼(30)
    private String taskName;  	          //節點代號(20)
    private String taskChName; 	          //節點名稱
    private String manKind;	              //1人員 或 2角色
    private String deptCode;   	          //單位代碼(20)
    private String deptName;   	          //單位名稱(100)
    private String userId; 	              //人員代號 (20)  可以是角色
    private String userName;   	          //人員姓名(50)
    private Date beginTime;  	          //TaskNode開始時間
    private Date receiveTime;	          //TaskNode接收日期
    private Date endTime;	              //TaskNode結束時間
    private String lastNote;   	          //上一關給的說明(為了顯示用，不要重新查詢)
    private List<Handle> handles;	      //一對多

	@Id
	@Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {	return id;	}
    public void setId(Long id) {	this.id = id;	};
    
    @Column(length=30)
	public String getProjectCode() {	return projectCode;	}
	public void setProjectCode(String projectCode) {	this.projectCode = projectCode;	}
    
    @Column
	public Integer getCaseId() {	return caseId;	}
	public void setCaseId(Integer caseid) {	this.caseId = caseId;   }
    
	@Column(length=30)	
    public String getInitCaseNo() { 	return initCaseNo;	}
	public void setInitCaseNo(String initCaseNo) {		this.initCaseNo = initCaseNo;	}
	
	@Column(length=30)	
	public String getInitCaseNoInner() {		return initCaseNoInner;	}
	public void setInitCaseNoInner(String initCaseNoInner) {		this.initCaseNoInner = initCaseNoInner;	}
	
	@Column(length=30)	
	public String getTaskName() {		return taskName;	}
	public void setTaskName(String taskName) {		this.taskName = taskName;	}
	
	@Column(length=30)	
	public String getTaskChName() {		return taskChName;	}
	public void setTaskChName(String taskChName) {		this.taskChName = taskChName;	}
	
	@Column(length=3)	
	public String getManKind() {		return manKind;	}
	public void setManKind(String manKind) {		this.manKind = manKind;	}
	
	@Column(length=20)
	public String getDeptCode() {		return deptCode;	}
	public void setDeptCode(String deptCode) {		this.deptCode = deptCode;	}
	
	@Column(length=100)
	public String getDeptName() {		return deptName;	}
	public void setDeptName(String deptName) {		this.deptName = deptName;	}
	
	@Column(length=20)
	public String getUserId() {		return userId;	}
	public void setUserId(String userId) {		this.userId = userId;	}
	
	@Column(length=50)
	public String getUserName() {	return userName;	}
	public void setUserName(String userName) {		this.userName = userName;	}
	
	@Column
	public Date getBeginTime() {	return beginTime;	}
	public void setBeginTime(Date beginTime) {		this.beginTime = beginTime;	}
	
	@Column
	public Date getReceiveTime() {	return receiveTime;	}
	public void setReceiveTime(Date receiveTime) {		this.receiveTime = receiveTime;	}
	
	@Column
	public Date getEndTime() {	return endTime;	}
	public void setEndTime(Date endTime) {	this.endTime = endTime;	}
	
	@Column(length=254)
	public String getLastNote() {	return lastNote;	}
	public void setLastNote(String lastNote) {	this.lastNote = lastNote;	}
	
	@OneToMany(mappedBy="caseNode", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	public List<Handle> getHandles() {	return handles;	}
	public void setHandles(List<Handle> handles) {	this.handles = handles;	}
	public void addHandles(Handle handle)
	{
		if( null == handles )
		{
			handles = new ArrayList<Handle>();
		}
		handle.setCaseNode(this);
		handles.add(handle);
	}
	public void removeHandles(Handle handle)
	{
		if( null == handles )
		{
			return;
		}
		
		handles.remove(handle);
	}
	
	public static CaseNode getNullInstance()
    {
    	CaseNode caseNode = new CaseNode();
    	caseNode.setId(Long.valueOf(0));
    	
    	return caseNode;
    }
	
	@Override
	public String toString() {
		return "CaseNode [id=" + id + ", projectCode=" + projectCode
				+ ", caseId=" + caseId + ", initCaseNo=" + initCaseNo
				+ ", initCaseNoInner=" + initCaseNoInner + ", taskName="
				+ taskName + ", taskChName=" + taskChName + ", manKind="
				+ manKind + ", deptCode=" + deptCode + ", deptName=" + deptName
				+ ", userId=" + userId + ", userName=" + userName
				+ ", beginTime=" + beginTime + ", receiveTime=" + receiveTime
				+ ", endTime=" + endTime + ", lastNote=" + lastNote
				+ ", handles=" + handles + "]";
	}
    


}
