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
@Table(name = "BASE_HEALTH_DEF")
public class BaseHealthDef extends BaseModel implements Serializable {


	

	/**
	 * 
	 */
	private static final long serialVersionUID = -8441577519982430705L;
	private Integer id;
	private String healthType; 		
	private String healthStatusName; 	
	private String healthStatusDesc; 	
	private Boolean okToEnable; 	
	

	public BaseHealthDef() {
	}

	public BaseHealthDef(Integer id,Boolean okToEnable,String healthStatusDesc,String healthStatusName,String healthType, String createId, String createDate,
			String createTime, String updateId, String updateDate,
			String updateTime, String updateIp, String updateUnitShortName) {

		super(createId, createDate, createTime, updateId, updateDate,
				updateTime, updateIp, updateUnitShortName);

		this.id = id;
		this.okToEnable=okToEnable;
        this.healthType=healthType;
        this.healthStatusName=healthStatusName;
        this.healthStatusDesc=healthStatusDesc;
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
	@SequenceGenerator(name = "id", sequenceName = "BASE_HEALTH_DEF_SEQ")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "healthType" ,length = 1)
	public String getHealthType() {
		return healthType;
	}

	public void setHealthType(String healthType) {
		this.healthType = healthType;
	}
	@Column(name = "healthStatusName" ,length = 20)
	public String getHealthStatusName() {
		return healthStatusName;
	}

	public void setHealthStatusName(String healthStatusName) {
		this.healthStatusName = healthStatusName;
	}
	@Column(name = "healthStatusDesc" ,length = 50)
	public String getHealthStatusDesc() {
		return healthStatusDesc;
	}

	public void setHealthStatusDesc(String healthStatusDesc) {
		this.healthStatusDesc = healthStatusDesc;
	}
	@Column(name = "okToEnable")
	public Boolean getOkToEnable() {
		return okToEnable;
	}

	public void setOkToEnable(Boolean okToEnable) {
		this.okToEnable = okToEnable;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("BaseHealthDef [id=");
		sb.append(id);
		sb.append(", healthType=");
		sb.append(healthType);
		sb.append(", healthStatusName=");
		sb.append(healthStatusName);
		sb.append(", healthStatusDesc=");
		sb.append(healthStatusDesc);
		sb.append(", okToEnable=");
		sb.append(okToEnable);
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
