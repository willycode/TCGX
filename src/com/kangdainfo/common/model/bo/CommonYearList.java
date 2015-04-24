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
@Table(name = "COMMON_YEAR_LIST")
public class CommonYearList extends BaseModel implements Serializable {


	

	/**
	 * 
	 */
	private static final long serialVersionUID = -118783616710451619L;
	private Integer id;
	private String adYear; 		
	private String twYear; 	
	private String lunarName; 	
	private String jpYear; 	
	private String thYear; 	
	

	public CommonYearList() {
	}

	public CommonYearList(Integer id,String thYear,String jpYear,String lunarName,String twYear, String adYear,String createId, String createDate,
			String createTime, String updateId, String updateDate,
			String updateTime, String updateIp, String updateUnitShortName) {

		super(createId, createDate, createTime, updateId, updateDate,
				updateTime, updateIp, updateUnitShortName);

		this.id = id;
		this.adYear=adYear;
		this.twYear=twYear;
		this.jpYear=jpYear;
		this.thYear= thYear;
		this.lunarName=lunarName;
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
	@SequenceGenerator(name = "id", sequenceName = "COMMON_YEAR_LIST_SEQ")
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "adYear", length =4 )
	public String getAdYear() {
		return adYear;
	}

	public void setAdYear(String adYear) {
		this.adYear = adYear;
	}
	@Column(name = "twYear", length =15 )
	public String getTwYear() {
		return twYear;
	}

	public void setTwYear(String twYear) {
		this.twYear = twYear;
	}
	@Column(name = "lunarName", length =15 )
	public String getLunarName() {
		return lunarName;
	}

	public void setLunarName(String lunarName) {
		this.lunarName = lunarName;
	}
	@Column(name = "jpYear", length =15 )
	public String getJpYear() {
		return jpYear;
	}

	public void setJpYear(String jpYear) {
		this.jpYear = jpYear;
	}
	@Column(name = "thYear", length =15 )
	public String getThYear() {
		return thYear;
	}

	public void setThYear(String thYear) {
		this.thYear = thYear;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CommYearList [id=");
		builder.append(id);
		builder.append(", adYear=");
		builder.append(adYear);
		builder.append(", twYear=");
		builder.append(twYear);
		builder.append(", lunarName=");
		builder.append(lunarName);
		builder.append(", jpYear=");
		builder.append(jpYear);
		builder.append(", thYear=");
		builder.append(thYear);
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
