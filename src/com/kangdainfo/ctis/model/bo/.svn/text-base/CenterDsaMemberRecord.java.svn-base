package com.kangdainfo.ctis.model.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.kangdainfo.common.model.bo.BaseModel;

@Entity
@Table(name = "CENTER_DSA_MEMBER_RECORD")
public class CenterDsaMemberRecord extends BaseModel implements Serializable {

	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5090484580198219969L;
	private Integer id;
	private Short dsaJobId;
	private String dsaJobName;
	private String ctDsaYear;
	private String unitId;
	private String unitShortName;
	private String centerDsaYear;
	private String centerMemberId;
	private String ctMemberId;
	private String aliasName;		
	

	public CenterDsaMemberRecord() {
	}

	public CenterDsaMemberRecord(Integer id,String aliasName,String ctMemberId,String centerMemberId,String centerDsaYear,String unitShortName,String unitId,String ctDsaYear,String dsaJobDesc, String dsaJobName,Short dsaJobId, String createId, String createDate,
			String createTime, String updateId, String updateDate,
			String updateTime, String updateIp, String updateUnitShortName) {

		super(createId, createDate, createTime, updateId, updateDate,
				updateTime, updateIp, updateUnitShortName);

		this.id = id;
		
		this.aliasName=aliasName;
		this.ctDsaYear= ctDsaYear;
		this.unitId=unitId;
		this.unitShortName=unitShortName;
		this.centerDsaYear=centerDsaYear;
		this.centerMemberId=centerMemberId;
		this.ctMemberId=ctMemberId;
		this.dsaJobName=dsaJobName;
		this.dsaJobId=dsaJobId;
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
	@SequenceGenerator(name = "id", sequenceName = "CENTER_DSA_MEMBER_RECORD_SEQ")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "dsaJobId")
	public Short getDsaJobId() {
		return dsaJobId;
	}	
	public void setDsaJobId(Short dsaJobId) {
		this.dsaJobId = dsaJobId;
	}
	@Column(name = "dsaJobName" ,length = 20)
	public String getDsaJobName() {
		return dsaJobName;
	}

	public void setDsaJobName(String dsaJobName) {
		this.dsaJobName = dsaJobName;
	}
	@Column(name = "ctDsaYear" ,length = 4)
	public String getCtDsaYear() {
		return ctDsaYear;
	}
	public void setCtDsaYear(String ctDsaYear) {
		this.ctDsaYear = ctDsaYear;
	}
	@Column(name = "unitId" ,length = 4)
	public String getUnitId() {
		return unitId;
	}
	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}
	@Column(name = "unitShortName" ,length = 10)
	public String getUnitShortName() {
		return unitShortName;
	}
	public void setUnitShortName(String unitShortName) {
		this.unitShortName = unitShortName;
	}
	@Column(name = "centerDsaYear" ,length = 4)
	public String getCenterDsaYear() {
		return centerDsaYear;
	}
	public void setCenterDsaYear(String centerDsaYear) {
		this.centerDsaYear = centerDsaYear;
	}
	@Column(name = "centerMemberId" ,length = 12)
	public String getCenterMemberId() {
		return centerMemberId;
	}
	public void setCenterMemberId(String centerMemberId) {
		this.centerMemberId = centerMemberId;
	}
	@Column(name = "ctMemberId" ,length = 15)
	public String getCtMemberId() {
		return ctMemberId;
	}
	public void setCtMemberId(String ctMemberId) {
		this.ctMemberId = ctMemberId;
	}
	@Column(name = "aliasName" ,length = 60)
	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("CenterDsaMemberRecord [id=");
		sb.append(id);
		sb.append(", aliasName=");
		sb.append(aliasName);
		sb.append(", ctDsaYear=");
		sb.append(ctDsaYear);
		sb.append(", unitId=");
		sb.append(unitId);
		sb.append(", unitShortName=");
		sb.append(unitShortName);
		sb.append(", centerDsaYear=");
		sb.append(centerDsaYear);
		sb.append(", centerMemberId=");
		sb.append(centerMemberId);
		sb.append(", ctMemberId=");
		sb.append(ctMemberId);
		sb.append(", dsaJobId=");
		sb.append(dsaJobId);
		sb.append(", dsaJobName=");
		sb.append(dsaJobName);
		sb.append(", createId=");
		sb.append(createId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", createTime=");
		sb.append(createTime);
		sb.append(", updateId=");
		sb.append(updateId);
		sb.append(", updateIp=");
		sb.append(updateIp);
		sb.append(", updateDate=");
		sb.append(updateDate);
		sb.append(", updateTime=");
		sb.append(updateTime);
		sb.append(", updateUnitShortName=");
		sb.append(updateUnitShortName);
		sb.append("]");

		return sb.toString();
	}	

	
}
