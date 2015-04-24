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
@Table(name = "COMMON_VISITLOG_FUNCTION")
public class CommonVisitLogFunction  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5030232867660527209L;
	private Integer id;
	private String unitId; 		//精舍中台代碼
	private String unitShortName; //精舍簡稱
	private String userId;			//使用者帳號
	private String userName;		//使用者名稱
	private String dtreeId;			//功能代號
	private String dtreeName;		//功能名稱
	private String triggerDate;		//使用日期
	private String triggerTime;		//使用時間
	
	public CommonVisitLogFunction(){}

	public CommonVisitLogFunction(Integer id, String unitId,
			String unitShortName, String userId, String userName,
			String dtreeId, String dtreeName, String triggerDate,
			String triggerTime) {
		this.id = id;
		this.unitId = unitId;
		this.unitShortName = unitShortName;
		this.userId = userId;
		this.userName = userName;
		this.dtreeId = dtreeId;
		this.dtreeName = dtreeName;
		this.triggerDate = triggerDate;
		this.triggerTime = triggerTime;
	}
	
	@Id
	@Column(name = "Id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "id", sequenceName = "COMMON_VISITLOG_FUNCTION_SEQ")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "unitId", length = 4)
	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	@Column(name = "unitShortName", length = 10)
	public String getUnitShortName() {
		return unitShortName;
	}

	public void setUnitShortName(String unitShortName) {
		this.unitShortName = unitShortName;
	}

	@Column(name = "userId", length = 50)
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "userName", length = 50)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "dtreeId", length = 50)
	public String getDtreeId() {
		return dtreeId;
	}

	public void setDtreeId(String dtreeId) {
		this.dtreeId = dtreeId;
	}

	@Column(name = "dtreeName", length = 255)
	public String getDtreeName() {
		return dtreeName;
	}

	public void setDtreeName(String dtreeName) {
		this.dtreeName = dtreeName;
	}

	@Column(name = "triggerDate", length = 8)
	public String getTriggerDate() {
		return triggerDate;
	}

	public void setTriggerDate(String triggerDate) {
		this.triggerDate = triggerDate;
	}

	@Column(name = "triggerTime", length = 6)
	public String getTriggerTime() {
		return triggerTime;
	}

	public void setTriggerTime(String triggerTime) {
		this.triggerTime = triggerTime;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("CommonVisitLogFunction [id=");
		sb.append(id);
		sb.append(", unitId");
		sb.append(unitId);
		sb.append(", unitShortName");
		sb.append(unitShortName);
		sb.append(", userId");
		sb.append(userId);
		sb.append(", userName");
		sb.append(userName);
		sb.append(", dtreeId");
		sb.append(dtreeId);
		sb.append(", dtreeName");
		sb.append(dtreeName);
		sb.append(", triggerDate");
		sb.append(triggerDate);
		sb.append(", triggerTime");
		sb.append(triggerTime);
		sb.append("]");
		
		return sb.toString();
	}
	
	
	
}
