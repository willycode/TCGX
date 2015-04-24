package com.kangdainfo.common.model.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * CommonVisitLogDetail generated by hbm2java
 */
@Entity
@Table(name = "COMMON_VISITLOG_DETAIL")
public class CommonVisitLogDetail implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8962370486723826014L;
	private Long id;
	private String logDate;
	private String logTime;
	private String userId;
	private String userName;
	private String organId;
	private String organName;
	private String userIP;
	private String logStatus;
	private String logMsg;
	private String logAction;

	public CommonVisitLogDetail() {
	}

	public CommonVisitLogDetail(Long id) {
		this.id = id;
	}

	public CommonVisitLogDetail(Long id, String logDate, String logTime,
			String userId, String userName, String organId, String organName,
			String userIP, String logStatus, String logMsg, String logAction) {
		this.id = id;
		this.logDate = logDate;
		this.logTime = logTime;
		this.userId = userId;
		this.userName = userName;
		this.organId = organId;
		this.organName = organName;
		this.userIP = userIP;
		this.logStatus = logStatus;
		this.logMsg = logMsg;
		this.logAction = logAction;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	@SequenceGenerator(name="id", sequenceName = "COMMON_VisitLogDetail_SEQ")		
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Column(name = "userID", length = 50)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "userName", length = 100)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "organID", length = 20)
	public String getOrganId() {
		return this.organId;
	}

	public void setOrganId(String organId) {
		this.organId = organId;
	}

	@Column(name = "organName", length = 100)
	public String getOrganName() {
		return this.organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	@Column(name = "userIP", length = 50)
	public String getUserIP() {
		return this.userIP;
	}

	public void setUserIP(String userIP) {
		this.userIP = userIP;
	}

	@Column(name = "logStatus", length = 1)
	public String getLogStatus() {
		return this.logStatus;
	}

	public void setLogStatus(String logStatus) {
		this.logStatus = logStatus;
	}

	@Column(name = "logMsg", length = 200)
	public String getLogMsg() {
		return this.logMsg;
	}

	public void setLogMsg(String logMsg) {
		this.logMsg = logMsg;
	}

	@Column(name = "logAction", length = 1)
	public String getLogAction() {
		return this.logAction;
	}

	public void setLogAction(String logAction) {
		this.logAction = logAction;
	}

}
