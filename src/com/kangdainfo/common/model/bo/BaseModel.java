package com.kangdainfo.common.model.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * 基本欄位
 */
@MappedSuperclass
public abstract class BaseModel implements Serializable 
{ 

	/**
	 * 
	 */
	private static final long serialVersionUID = 5553460184778194593L;
	
	protected String createId	;
	protected String createDate;	
	protected String createTime;
	protected String updateId;
	protected String updateDate;
	protected String updateTime;
	protected String updateIp;
	protected String updateUnitShortName;

	public BaseModel(){}
	
	public BaseModel(String createId, String createDate, String createTime,
			String updateId, String updateDate, String updateTime,
			String updateIp, String updateUnitShortName) {
		this.createId = createId;
		this.createDate = createDate;
		this.createTime = createTime;
		this.updateId = updateId;
		this.updateDate = updateDate;
		this.updateTime = updateTime;
		this.updateIp = updateIp;
		this.updateUnitShortName = updateUnitShortName;
	}


	@Column(name = "createId", length = 50)
	public String getCreateId() {
		return createId;
	}

	public void setCreateId(String createId) {
		this.createId = createId;
	}
	@Column(name = "createDate", length = 8)
	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	@Column(name = "createTime", length = 6)
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	@Column(name = "updateId", length = 50)
	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}
	@Column(name = "updateDate", length = 8)
	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	@Column(name = "updateTime", length = 6)
	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	@Column(name = "updateIp", length = 40)
	public String getUpdateIp() {
		return updateIp;
	}

	public void setUpdateIp(String updateIp) {
		this.updateIp = updateIp;
	}
	@Column(name = "updateUnitShortName", length = 10)
	public String getUpdateUnitShortName() {
		return updateUnitShortName;
	}

	public void setUpdateUnitShortName(String updateUnitShortName) {
		this.updateUnitShortName = updateUnitShortName;
	}
	
}
