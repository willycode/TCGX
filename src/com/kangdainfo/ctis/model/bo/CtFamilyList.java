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
@Table(name = "CT_FAMILY_LIST")
public class CtFamilyList extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2105733238721648329L;
	private Integer id;
	private String ctMemberIdM; 	
	private String aliasNameM;		
	private String appellationIdM;
	private String appellationNameM;	
	private String ctMemberIdS;	
	private String aliasNameS;	
	private String appellationIdS;	
	private String appellationNameS;	

	public CtFamilyList() {
	}

	public CtFamilyList(Integer id, String ctMemberIdM, String aliasNameM,
			String appellationIdM, String appellationNameM, String ctMemberIdS,
			String aliasNameS, String appellationIdS, String appellationNameS,
			String createId, String createDate,	String createTime, String updateId,
			String updateDate, String updateTime, String updateIp, String updateUnitShortName) {

		super(createId, createDate, createTime, updateId, updateDate,
				updateTime, updateIp, updateUnitShortName);

		this.id = id;
		this.ctMemberIdM = ctMemberIdM;
		this.aliasNameM = aliasNameM;
		this.appellationIdM = appellationIdM;
		this.appellationNameM = appellationNameM;
		this.ctMemberIdS = ctMemberIdS;
		this.aliasNameS = aliasNameS;
		this.appellationIdS = appellationIdS;
		this.appellationNameS = appellationNameS;
		
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

	@Column(name = "ctMemberIdM", length = 15)
	public String getCtMemberIdM() {
		return ctMemberIdM;
	}

	public void setCtMemberIdM(String ctMemberIdM) {
		this.ctMemberIdM = ctMemberIdM;
	}

	@Column(name = "aliasNameM", length = 60)
	public String getAliasNameM() {
		return aliasNameM;
	}

	public void setAliasNameM(String aliasNameM) {
		this.aliasNameM = aliasNameM;
	}

	@Column(name = "appellationIdM", length = 5)
	public String getAppellationIdM() {
		return appellationIdM;
	}

	public void setAppellationIdM(String appellationIdM) {
		this.appellationIdM = appellationIdM;
	}
	
	@Column(name = "appellationNameM", length = 10)
	public String getAppellationNameM() {
		return appellationNameM;
	}

	public void setAppellationNameM(String appellationNameM) {
		this.appellationNameM = appellationNameM;
	}
	
	@Column(name = "ctMemberIdS", length = 15)
	public String getCtMemberIdS() {
		return ctMemberIdS;
	}

	public void setCtMemberIdS(String ctMemberIdS) {
		this.ctMemberIdS = ctMemberIdS;
	}

	@Column(name = "aliasNameS", length = 60)
	public String getAliasNameS() {
		return aliasNameS;
	}

	public void setAliasNameS(String aliasNameS) {
		this.aliasNameS = aliasNameS;
	}

	@Column(name = "appellationIdS", length = 5)
	public String getAppellationIdS() {
		return appellationIdS;
	}

	public void setAppellationIdS(String appellationIdS) {
		this.appellationIdS = appellationIdS;
	}
	
	@Column(name = "appellationNameS", length = 10)
	public String getAppellationNameS() {
		return appellationNameS;
	}

	public void setAppellationNameS(String appellationNameS) {
		this.appellationNameS = appellationNameS;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("CtMasterInfo [id=");
		sb.append(id);
		sb.append(", ctMemberIdM=");
		sb.append(ctMemberIdM);
		sb.append(", aliasNameM=");
		sb.append(aliasNameM);
		sb.append(", appellationIdM=");
		sb.append(appellationIdM);
		sb.append(", appellationNameM=");
		sb.append(appellationNameM);
		sb.append(", ctMemberIdS=");
		sb.append(ctMemberIdS);
		sb.append(", aliasNameS=");
		sb.append(aliasNameS);
		sb.append(", appellationIdS=");
		sb.append(appellationIdS);
		sb.append(", appellationNameS=");
		sb.append(appellationNameS);
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
