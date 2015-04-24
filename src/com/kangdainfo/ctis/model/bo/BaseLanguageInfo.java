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
@Table(name = "BASE_LANGUAGE_INFO")
public class BaseLanguageInfo extends BaseModel implements Serializable {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5271933352607852329L;
	private Integer id;
	private Short languageId;
	private String languageName; 		

	

	public BaseLanguageInfo() {
	}

	public BaseLanguageInfo(Integer id,String languageName,Short languageId, String createId, String createDate,
			String createTime, String updateId, String updateDate,
			String updateTime, String updateIp, String updateUnitShortName) {

		super(createId, createDate, createTime, updateId, updateDate,
				updateTime, updateIp, updateUnitShortName);

		this.id = id;
        this.languageId=languageId;
        this.languageName=languageName;
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
	@SequenceGenerator(name = "id", sequenceName = "BASE_LANGUAGE_INFO_SEQ")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "languageId")
	public Short getLanguageId() {
		return languageId;
	}
	public void setLanguageId(Short languageId) {
		this.languageId = languageId;
	}
	@Column(name = "languageName" ,length = 20)
	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("BaseLanguageInfo [id=");
		sb.append(id);
		sb.append(", languageId=");
		sb.append(languageId);
		sb.append(", languageName=");
		sb.append(languageName);
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
