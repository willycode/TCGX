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

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "FLOW_FRAMEPATH")
public class FramePath implements Serializable
{ 
    private static final long serialVersionUID = 1L;
 
    private Long id;				//唯一編號
    private String codeId;			//流程類型  CodeKind=WF
    private String taskName;		//節點代號(20)
    private String taskChName;		//節點名稱(30)
    private Integer forwardKind; 	//回應類別(1.action 2.JSP 3.直接導向action，不需要經過TodoList清單)
    private String actionName;		//Action(100)
    private String eventName;		//Method(30)
    private String pagePath;		//JSP(100)
    private String roleCode;		//可執行角色
    private String roleName;        //角色名稱
	private List<WorkFlow> workFlows;
	private String casseStatus;		//在本節點的狀態

	private String modAccount;		//修改人員(20)
	private Date modDate;			//修改時間
	
	public FramePath(){}
	public FramePath( Long id ){ this.id = id; }

    @Id
    @Column(name = "Id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {	return id;	}
    public void setId(Long id) {	this.id = id;	};

    @Column(length=10)
	public String getCodeId() {		return codeId;	}
	public void setCodeId(String codeId) {		this.codeId = codeId;	}
	
    @Column(length=20)
    public String getTaskName() {	return taskName;	}
    public void setTaskName(String taskName) {	this.taskName = taskName;	}

    @Column(columnDefinition="nvarchar(30)")
    public String getTaskChName() {	return taskChName;	}
    public void setTaskChName(String taskChName) {	this.taskChName = taskChName;	}

    @Column(length=100)
    public String getPagePath() {	return pagePath;	}
    public void setPagePath(String pagePath) {	this.pagePath = pagePath;	}

    @Column(length=100)
    public String getActionName() {		return actionName;	}
	public void setActionName(String actionName) {		this.actionName = actionName;	}
	
	@Column(length=30)
	public String getEventName() {		return eventName;	}
	public void setEventName(String eventName) {		this.eventName = eventName;	}
	
	@Column
	public Integer getForwardKind() {		return forwardKind;	}
	public void setForwardKind(Integer forwardKind) {		this.forwardKind = forwardKind;	}

	@Column(length=20)
	public String getModAccount() {return modAccount;	}
	public void setModAccount(String modAccount) {this.modAccount = modAccount;	}
	
	@Column
	public Date getModDate() {return modDate;	}
	public void setModDate(Date modDate) {this.modDate = modDate;	}
	
	@OneToMany(mappedBy="parent", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	public List<WorkFlow> getWorkFlows() { return workFlows; }
	public void setWorkFlows(List<WorkFlow> workFlows) { this.workFlows = workFlows; }
	public void addWorkFlows(WorkFlow workFlow)
	{
		if( null == workFlows )
		{
			workFlows = new ArrayList<WorkFlow>();
		}
		workFlow.setParent(this);
		workFlows.add(workFlow);
	}
	public void removeWorkFlows(WorkFlow workFlow)
	{
		if( null == workFlows )
		{
			return;
		}
		
		workFlows.remove(workFlow);
	}	

    @Column(length=20)
	public String getRoleCode() {		return roleCode;	}
	public void setRoleCode(String roleCode) {		this.roleCode = roleCode;	}
	
	@Column(length=20)
	public String getRoleName() {		return roleName;	}
	public void setRoleName(String roleName) {		this.roleName = roleName;	}

    @Column(length=5)
	public String getCasseStatus() {return casseStatus;}
	public void setCasseStatus(String casseStatus) {this.casseStatus = casseStatus;}
    
    @Override
	public String toString()
	{
		return new ToStringBuilder(this)
			.append("id", id)
			.append("codeId", codeId)
			.append("roleCode", roleCode)
			.append("taskName", taskName)
			.append("taskChName", taskChName)
			.append("forwardKind", forwardKind)
			.append("actionName", actionName)
			.append("eventName", eventName)
			.append("pagePath", pagePath)
			.append("modAccount", modAccount)
			.append("modDate", modDate)
			.append("casseStatus", casseStatus)
			.toString();
	}
    
    public static FramePath getNullInstance()
    {
    	FramePath framePath = new FramePath();
    	framePath.setId(Long.valueOf(0));
    	
    	return framePath;
    }
    
}
