package com.kangdainfo.ctis.model.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.kangdainfo.common.model.bo.BaseModel;

@Entity
@Table(name = "CENTER_MEMBER_INFO")
public class CenterMemberInfo extends BaseModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5330498430075842669L;
	private Integer id;
	private String ctMemberId;
	private String centerMemberId;
	private String unitId;
	private String unitShortName;
	private String aliasName;

	public CenterMemberInfo() {
	}

	public CenterMemberInfo(Integer id) {
		this.id = id;

	}

	public CenterMemberInfo(String aliasName, String  unitShortName,
			String  unitId, String centerMemberId, String ctMemberId,
			String createTime, String createDate, String createId,
			String updateUnitShortName, String updateTime, String updateDate,
			String updateIp, String updateId, Integer id) {

		this.id = id;
		this.ctMemberId = ctMemberId;
		this.centerMemberId = centerMemberId;
		this.unitId =  unitId;
		this.unitShortName =  unitShortName;
		this.aliasName = aliasName;
		this.updateId = updateId;
		this.updateIp = updateIp;
		this.updateDate = updateDate;
		this.updateTime = updateTime;
		this.updateUnitShortName = updateUnitShortName;
		this.createId = createId;
		this.createDate = createDate;
		this.createTime = createTime;

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "id", sequenceName = "CCENTER_MEMBER_INFO_SEQ")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "ctMemberId", length = 15)
	public String getCtMemberId() {
		return ctMemberId;
	}

	public void setCtMemberId(String ctMemberId) {
		this.ctMemberId = ctMemberId;
	}

	@Column(name = "centerMemberId", length = 12)
	public String getCenterMemberId() {
		return centerMemberId;
	}

	public void setCenterMemberId(String centerMemberId) {
		this.centerMemberId = centerMemberId;
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

	@Column(name = "aliasName", length = 60)
	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CenterMemberInfo [id=");
		builder.append(id);
		builder.append(", ctMemberId=");
		builder.append(ctMemberId);
		builder.append(", centerMemberId=");
		builder.append(centerMemberId);
		builder.append(", unitId=");
		builder.append(unitId);
		builder.append(", unitShortName=");
		builder.append(unitShortName);
		builder.append(", aliasName=");
		builder.append(aliasName);
		builder.append("]");
		return builder.toString();
	}

}
