package com.kangdainfo.common.model.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * CommonMsgGroup generated by hbm2java
 */
@Entity
@Table(name = "COMMON_MSG_GROUP")
public class CommonMsgGroup implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7748375616231583674L;
	private Long id;
	private CommonMsg commonMsg;
	private Integer userId;
	private Integer deptId;
	private Integer groupId;

	public CommonMsgGroup() {
	}

	public CommonMsgGroup(Long id) {
		this.id = id;
	}

	public CommonMsgGroup(Long id, CommonMsg commonMsg, Integer userId,
			Integer deptId, Integer groupId) {
		this.id = id;
		this.commonMsg = commonMsg;
		this.userId = userId;
		this.deptId = deptId;
		this.groupId = groupId;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	@SequenceGenerator(name="id", sequenceName = "COMMON_MSG_GROUP_SEQ")	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "msgId")
	public CommonMsg getCommonMsg() {
		return this.commonMsg;
	}

	public void setCommonMsg(CommonMsg commonMsg) {
		this.commonMsg = commonMsg;
	}

	@Column(name = "userId")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "deptId")
	public Integer getDeptId() {
		return this.deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	@Column(name = "groupId")
	public Integer getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

}