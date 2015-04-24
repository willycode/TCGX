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
@Table(name = "BASE_DSA_JOB_DEF")
public class BaseDsaJobDef extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6963807245415833119L;
	/**
	 * 
	 */
	
	private Integer id;
	private Short dsaJobId;
	private String dsaJobName; 		
	private String dsaJobDesc;		
	

	public BaseDsaJobDef() {
	}

	public BaseDsaJobDef(Integer id,String dsaJobDesc, String dsaJobName,Short dsaJobId, String createId, String createDate,
			String createTime, String updateId, String updateDate,
			String updateTime, String updateIp, String updateUnitShortName) {

		super(createId, createDate, createTime, updateId, updateDate,
				updateTime, updateIp, updateUnitShortName);

		this.id = id;
		this.dsaJobDesc=dsaJobDesc;
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
	@SequenceGenerator(name = "id", sequenceName = "BASE_DSA_JOB_DEF_SEQ")
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
	@Column(name = "dsaJobDesc" ,length = 50)
	public String getDsaJobDesc() {
		return dsaJobDesc;
	}
	public void setDsaJobDesc(String dsaJobDesc) {
		this.dsaJobDesc = dsaJobDesc;
	}
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("BaseDsaJobDef [id=");
		sb.append(id);
		sb.append(", dsaJobId=");
		sb.append(dsaJobId);
		sb.append(", dsaJobName=");
		sb.append(dsaJobName);
		sb.append(", dsaJobDesc=");
		sb.append(dsaJobDesc);
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
