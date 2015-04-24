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
@Table(name = "BASE_SKILL_DEF")
public class BaseSkillDef extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3522091152876278899L;
	private Integer id;

	private String skillTypeId;
	private String skillTypeName;
	private String skillId;
	private String skillName;
	private String skillDesc;

	public BaseSkillDef() {
	}

	public BaseSkillDef(Integer id, String skillTypeId, String skillTypeName,
			String skillId, String skillName, String skillDesc,
			String createId, String createDate, String createTime,
			String updateId, String updateDate, String updateTime,
			String updateIp, String updateUnitShortName) {

		this.id = id;
		this.skillTypeId = skillTypeId;
		this.skillTypeName = skillTypeName;
		this.skillId = skillId;
		this.skillName = skillName;
		this.skillDesc = skillDesc;
		this.createId = createId;
		this.createDate = createDate;
		this.createTime = createTime;
		this.updateId = updateId;
		this.updateDate = updateDate;
		this.updateTime = updateTime;
		this.updateIp = updateIp;
		this.updateUnitShortName = updateUnitShortName;
	}

	@Id
	@Column(name = "Id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "id", sequenceName = "BASE_SKILL_DEF_SEQ")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "skillTypeId" ,length = 4)
	public String getSkillTypeId() {
		return skillTypeId;
	}

	public void setSkillTypeId(String skillTypeId) {
		this.skillTypeId = skillTypeId;
	}

	@Column(name = "skillTypeName" ,length = 10)
	public String getSkillTypeName() {
		return skillTypeName;
	}

	public void setSkillTypeName(String skillTypeName) {
		this.skillTypeName = skillTypeName;
	}

	@Column(name = "skillId" ,length = 4)
	public String getSkillId() {
		return skillId;
	}

	public void setSkillId(String skillId) {
		this.skillId = skillId;
	}

	@Column(name = "skillName" ,length = 10)
	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	@Column(name = "skillDesc" ,length = 50)
	public String getSkillDesc() {
		return skillDesc;
	}

	public void setSkillDesc(String skillDesc) {
		this.skillDesc = skillDesc;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BaseSkillDef [id=");
		builder.append(id);
		builder.append(", skillDesc=");
		builder.append(skillDesc);
		builder.append(", skillId=");
		builder.append(skillId);
		builder.append(", skillName=");
		builder.append(skillName);
		builder.append(", skillTypeId=");
		builder.append(skillTypeId);
		builder.append(", skillTypeName=");
		builder.append(skillTypeName);
		builder.append("]");
		return builder.toString();
	}
}
