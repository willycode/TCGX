package com.kangdainfo.common.model.bo;

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
@Table(name = "COMMON_LUNAR_CALENDAR")
public class CommonLunarCalendar extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1364014626637692945L;
	private Integer id;
	private String adDate;
	private String lunarDate;
	private String lunarName;
	private Boolean isBeforeROC;
	private String lunarYear;
	private String lunarMonth;
	private Boolean isLeap;
	private String lunarDay;

	public CommonLunarCalendar() {
	}

	public CommonLunarCalendar(Integer id, 
			String lunarName,String lunarDay,Boolean isLeap,String lunarMonth,String lunarYear,Boolean isBeforeROC,String lunarDate,String adDate,String createId,
			String createDate, String createTime, String updateId,
			String updateDate, String updateTime, String updateIp,
			String updateUnitShortName) {

		super(createId, createDate, createTime, updateId, updateDate,
				updateTime, updateIp, updateUnitShortName);

		this.id = id;
        this.adDate=adDate;
        this.lunarDay=lunarDay;
        this.isLeap=isLeap;
        this.lunarMonth=lunarMonth;
        this.lunarYear=lunarYear;
        this.isBeforeROC=isBeforeROC;
        this.lunarDate=lunarDate;
		this.lunarName = lunarName;
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
	@SequenceGenerator(name = "id", sequenceName = "COMMON_LUNAR_CALENDAR_SEQ")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	@Column(name = "lunarName", length = 15)
	public String getLunarName() {
		return lunarName;
	}

	public void setLunarName(String lunarName) {
		this.lunarName = lunarName;
	}


	@Column(name = "adDate", length = 8)
	public String getAdDate() {
		return adDate;
	}

	public void setAdDate(String adDate) {
		this.adDate = adDate;
	}
	@Column(name = "lunarDate", length = 50)
	public String getLunarDate() {
		return lunarDate;
	}

	public void setLunarDate(String lunarDate) {
		this.lunarDate =lunarDate;
	}
	@Column(name = "isBeforeROC")
	public Boolean getIsBeforeROC() {
		return isBeforeROC;
	}

	public void setIsBeforeROC(Boolean isBeforeROC) {
		this.isBeforeROC = isBeforeROC;
	}
	@Column(name = "lunarYear", length = 15)
	public String getLunarYear() {
		return lunarYear;
	}

	public void setLunarYear(String lunarYear) {
		this.lunarYear = lunarYear;
	}
	@Column(name = "lunarMonth", length = 2)
	public String getLunarMonth() {
		return lunarMonth;
	}

	public void setLunarMonth(String lunarMonth) {
		this.lunarMonth = lunarMonth;
	}
	@Column(name = "isLeap")
	public Boolean getIsLeap() {
		return isLeap;
	}

	public void setIsLeap(Boolean isLeap) {
		this.isLeap = isLeap;
	}
	@Column(name = "lunarDay", length = 2)
	public String getLunarDay() {
		return lunarDay;
	}

	public void setLunarDay(String lunarDay) {
		this.lunarDay = lunarDay;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CommLunarCalendar [id=");
		builder.append(id);
		builder.append(", adDate=");
		builder.append(adDate);
		builder.append(", lunarDate=");
		builder.append(lunarDate);
		builder.append(", lunarName=");
		builder.append(lunarName);
		builder.append(", isBeforeROC=");
		builder.append(isBeforeROC);
		builder.append(", lunarYear=");
		builder.append(lunarYear);
		builder.append(", lunarMonth=");
		builder.append(lunarMonth);
		builder.append(", isLeap=");
		builder.append(isLeap);
		builder.append(", lunarDay=");
		builder.append(lunarDay);
		builder.append(", createId=");
		builder.append(createId);
		builder.append(", createDate=");
		builder.append(createDate);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", updateId=");
		builder.append(updateId);
		builder.append(", updateDate=");
		builder.append(updateDate);
		builder.append(", updateTime=");
		builder.append(updateTime);
		builder.append(", updateIp=");
		builder.append(updateIp);
		builder.append(", updateUnitShortName=");
		builder.append(updateUnitShortName);
		builder.append("]");
		return builder.toString();
	}

}
