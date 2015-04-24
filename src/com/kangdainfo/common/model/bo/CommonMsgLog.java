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
 * CommonMsgLog generated by hbm2java
 */
@Entity
@Table(name = "COMMON_MSG_LOG")
public class CommonMsgLog implements java.io.Serializable {


	private static final long serialVersionUID = -2563012699057046056L;
	private Long id;
	private CommonMsg commonMsg;
	private String userId;
	private String logDate;
	private String logTime;
	private String isSlide;
	private String isRead;

	public CommonMsgLog() {
	}

	public CommonMsgLog(Long id) {
		this.id = id;
	}

	public CommonMsgLog(Long id, CommonMsg commonMsg, String userId,
			String logDate, String logTime, String isSlide, String isRead) {
		this.id = id;
		this.commonMsg = commonMsg;
		this.userId = userId;
		this.logDate = logDate;
		this.logTime = logTime;
		this.isSlide = isSlide;
		this.isRead = isRead;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	@SequenceGenerator(name="id", sequenceName = "COMMON_MSG_LOG_SEQ")	
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

	@Column(name = "userId", length = 50)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "logDate", length = 7)
	public String getLogDate() {
		return this.logDate;
	}

	public void setLogDate(String logDate) {
		this.logDate = logDate;
	}

	@Column(name = "logTime", length = 6)
	public String getLogTime() {
		return this.logTime;
	}

	public void setLogTime(String logTime) {
		this.logTime = logTime;
	}

	@Column(name = "isSlide", length = 1)
	public String getIsSlide() {
		return this.isSlide;
	}

	public void setIsSlide(String isSlide) {
		this.isSlide = isSlide;
	}

	@Column(name = "isRead", length = 1)
	public String getIsRead() {
		return this.isRead;
	}

	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}

}