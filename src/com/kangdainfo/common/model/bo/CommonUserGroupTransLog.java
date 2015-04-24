package com.kangdainfo.common.model.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "COMMON_USERGROUP_TRANSLOG")
public class CommonUserGroupTransLog extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2485122693849797714L;
	private Integer id;
	private String transferDate;		//交接日期
	private String transferTime;		//交接時間
	private String unitId;			//精舍中台代碼
	private String unitShortName;		//精舍簡稱
	private String rolesOwnerId;		//職務交接帳號
	private String rolesOwnerName;		//職務交接姓名
	private String rolesRecipientId;	//職務接收帳號
	private String rolesRecipientName;	//職務接收姓名
	private String roles; 				//角色

	public CommonUserGroupTransLog() {
	}

	public CommonUserGroupTransLog(Integer id, String transferDate,
			String transferTime, String unitId, String unitShortName,
			String rolesOwnerId, String rolesOwnerName,
			String rolesRecipientId, String rolesRecipientName, String roles,
			String createId, String createDate, String createTime,
			String updateId, String updateDate, String updateTime,
			String updateIp, String updateUnitShortName) {
		
		super(createId, createDate, createTime, updateId, updateDate,
				updateTime, updateIp, updateUnitShortName);
		
		this.id = id;
		this.transferDate = transferDate;
		this.transferTime = transferTime;
		this.unitId = unitId;
		this.unitShortName = unitShortName;
		this.rolesOwnerId = rolesOwnerId;
		this.rolesOwnerName = rolesOwnerName;
		this.rolesRecipientId = rolesRecipientId;
		this.rolesRecipientName = rolesRecipientName;
		this.roles = roles;
		this.createId = createId;
		this.createDate = createDate;
		this.createTime = createTime;
		this.updateId = updateId;
		this.updateIp = updateIp;
		this.updateDate = updateDate;
		this.updateTime = updateTime;		
		this.updateUnitShortName = updateUnitShortName;
	}

	@Id
	@Column(name = "Id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "id", sequenceName = "COMMON_USERGROUP_TRANSLOG_SEQ")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "transferDate", length = 7)
	public String getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(String transferDate) {
		this.transferDate = transferDate;
	}

	@Column(name = "transferTime", length = 6)
	public String getTransferTime() {
		return transferTime;
	}

	public void setTransferTime(String transferTime) {
		this.transferTime = transferTime;
	}

	@Column(name = "unitId", length = 4)
	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	@Column(name = "unitShortName", length = 10)
	public String getUnitShortName() {
		return unitShortName;
	}

	public void setUnitShortName(String unitShortName) {
		this.unitShortName = unitShortName;
	}

	@Column(name = "rolesOwnerId", length = 50)
	public String getRolesOwnerId() {
		return rolesOwnerId;
	}

	public void setRolesOwnerId(String rolesOwnerId) {
		this.rolesOwnerId = rolesOwnerId;
	}

	@Column(name = "rolesOwnerName", length = 60)
	public String getRolesOwnerName() {
		return rolesOwnerName;
	}

	public void setRolesOwnerName(String rolesOwnerName) {
		this.rolesOwnerName = rolesOwnerName;
	}

	@Column(name = "rolesRecipientId", length = 50)
	public String getRolesRecipientId() {
		return rolesRecipientId;
	}

	public void setRolesRecipientId(String rolesRecipientId) {
		this.rolesRecipientId = rolesRecipientId;
	}

	@Column(name = "rolesRecipientName", length = 60)
	public String getRolesRecipientName() {
		return rolesRecipientName;
	}

	public void setRolesRecipientName(String rolesRecipientName) {
		this.rolesRecipientName = rolesRecipientName;
	}

	@Column(name = "roles", length = 500)
	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CommonUserGroupTransLog [unitId=");
		builder.append(unitId);
		builder.append(", unitShortName=");
		builder.append(unitShortName);
		builder.append(", id=");
		builder.append(id);
		builder.append(", roles=");
		builder.append(roles);
		builder.append(", rolesOwnerId=");
		builder.append(rolesOwnerId);
		builder.append(", rolesOwnerName=");
		builder.append(rolesOwnerName);
		builder.append(", rolesRecipientId=");
		builder.append(rolesRecipientId);
		builder.append(", rolesRecipientName=");
		builder.append(rolesRecipientName);
		builder.append(", transferDate=");
		builder.append(transferDate);
		builder.append(", transferTime=");
		builder.append(transferTime);
		builder.append(", createId=");
		builder.append(createId);
		builder.append(", createDate=");
		builder.append(createDate);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", updateId=");
		builder.append(updateId);
		builder.append(", updateIp=");
		builder.append(updateIp);
		builder.append(", updateDate=");
		builder.append(updateDate);
		builder.append(", updateTime=");
		builder.append(updateTime);
		builder.append(", updateUnitShortName=");
		builder.append(updateUnitShortName);
		builder.append("]");
		return builder.toString();
	}

}
