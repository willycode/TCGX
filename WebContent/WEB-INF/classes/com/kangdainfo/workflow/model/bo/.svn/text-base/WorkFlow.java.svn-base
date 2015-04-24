package com.kangdainfo.workflow.model.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "FLOW_WORKFLOW")
public class WorkFlow implements Serializable
{ 
    private static final long serialVersionUID = 1L;
 
    private Long id;						//唯一編號
    private FramePath parent;				//所屬framePath
    private String status;					//流程-狀態
    private String name;
    private FramePath nextFramePath;		//流程-下一節點

	@Id
	@Column(name = "Id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {	return id;	}
    public void setId(Long id) {	this.id = id;	};
    
    @ManyToOne
    public FramePath getParent() { return parent; }
	public void setParent(FramePath parent) { this.parent = parent; }
	
	@Column(length=20)
	public String getStatus() { return status; }
	public void setStatus(String status) { this.status = status; }
	
	@ManyToOne
	public FramePath getNextFramePath() { return nextFramePath; }
	public void setNextFramePath(FramePath nextFramePath) { this.nextFramePath = nextFramePath; }
	
	@Column(length=20)
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
    public static WorkFlow getNullInstance()
    {
    	WorkFlow workFlow = new WorkFlow();
    	workFlow.setId(Long.valueOf(0));
    	workFlow.setNextFramePath(FramePath.getNullInstance());
    	workFlow.setStatus("");
    	workFlow.setName("");
    	workFlow.setParent(FramePath.getNullInstance());
    	
    	return workFlow;
    }
    
	public String toString() {
		return new ToStringBuilder(this)
		.append("id", id)
		.append("parent",parent)
		.append("status", status)
		.append("name", name)
		.toString();
	}

}
