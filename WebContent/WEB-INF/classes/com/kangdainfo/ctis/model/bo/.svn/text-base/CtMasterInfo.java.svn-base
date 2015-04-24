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
@Table(name = "CT_MASTER_INFO")
public class CtMasterInfo extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2105733238721648329L;
	private Integer id;
	private String masterId; 		//法師衣編
	private String masterName;		//法師法名
	private String masterPassword;	//法師密碼

	public CtMasterInfo() {
	}

	public CtMasterInfo(Integer id, String masterId, String masterName,
			String masterPassword, String createId, String createDate,
			String createTime, String updateId, String updateDate,
			String updateTime, String updateIp, String updateUnitShortName) {

		super(createId, createDate, createTime, updateId, updateDate,
				updateTime, updateIp, updateUnitShortName);

		this.id = id;
		this.masterId = masterId;
		this.masterName = masterName;
		this.masterPassword = masterPassword;
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
	@SequenceGenerator(name = "id", sequenceName = "CT_MASTER_INFO_SEQ")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "masterId", length = 5)
	public String getMasterId() {
		return masterId;
	}

	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}

	@Column(name = "masterName", length = 30)
	public String getMasterName() {
		return masterName;
	}

	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}

	@Column(name = "masterPassword", length = 100)
	public String getMasterPassword() {
		return masterPassword;
	}

	public void setMasterPassword(String masterPassword) {
		this.masterPassword = masterPassword;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("CtMasterInfo [id=");
		sb.append(id);
		sb.append(", masterId=");
		sb.append(masterId);
		sb.append(", masterName=");
		sb.append(masterName);
		sb.append(", masterPassword=");
		sb.append(masterPassword);
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
