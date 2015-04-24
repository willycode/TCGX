package com.kangdainfo.common.model.bo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 系統參數設定檔<br>
 * 1 = 系統參數檔<br>
 * 2 = FTP參數<br>
 * 6 = SMTP Email Server 參數設定<br>
 * 8 = 系統管理者Email設定<br>
 * @author shark
 */
@Entity
@Table(name = "COMMON_CONFIG")
public class CommonConfig extends BaseModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8953715641266018811L;
	private String id;
	private String field1;
	private String field2;
	private String field3;
	private String field4;
	private String field5;
	private String field6;
	private String field7;
	private String field8;
	private String field9;
	private String field10;
	private String field11;
	private String field12;
	private String userId;
	private String modDate;
	private String modTime;

	public CommonConfig() {
	}

	public CommonConfig(String id) {
		this.id = id;
	}

	public CommonConfig(String updateUnitShortName,String updateIp,String updateTime,String updateDate,String updateId,String createTime,String createDate,String createId,String editTime,String editDate,String editIp,String editId,String id, String field1, String field2, String field3,
			String field4, String field5, String field6, String field7,
			String field8, String field9, String field10, String field11,
			String field12, String userId, String modDate, String modTime) {
		this.id = id;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
		this.field6 = field6;
		this.field7 = field7;
		this.field8 = field8;
		this.field9 = field9;
		this.field10 = field10;
		this.field11 = field11;
		this.field12 = field12;
		this.userId = userId;
		this.modDate = modDate;
		this.modTime = modTime;
		this.updateId=updateId;
		this.updateDate=updateDate;
		this.updateTime=updateTime;
		this.updateIp=updateIp;
		this.updateUnitShortName=updateUnitShortName;
		this.createId=createId;
		this.createDate=createDate;
		this.createTime=createTime;

	}

	@Id
	@Column(name = "id", unique = true, nullable = false, length = 50)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "field1", length = 200)
	public String getField1() {
		return this.field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	@Column(name = "field2", length = 200)
	public String getField2() {
		return this.field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	@Column(name = "field3", length = 200)
	public String getField3() {
		return this.field3;
	}

	public void setField3(String field3) {
		this.field3 = field3;
	}

	@Column(name = "field4", length = 200)
	public String getField4() {
		return this.field4;
	}

	public void setField4(String field4) {
		this.field4 = field4;
	}

	@Column(name = "field5", length = 200)
	public String getField5() {
		return this.field5;
	}

	public void setField5(String field5) {
		this.field5 = field5;
	}

	@Column(name = "field6", length = 200)
	public String getField6() {
		return this.field6;
	}

	public void setField6(String field6) {
		this.field6 = field6;
	}

	@Column(name = "field7", length = 200)
	public String getField7() {
		return this.field7;
	}

	public void setField7(String field7) {
		this.field7 = field7;
	}

	@Column(name = "field8", length = 200)
	public String getField8() {
		return this.field8;
	}

	public void setField8(String field8) {
		this.field8 = field8;
	}

	@Column(name = "field9", length = 200)
	public String getField9() {
		return this.field9;
	}

	public void setField9(String field9) {
		this.field9 = field9;
	}

	@Column(name = "field10", length = 200)
	public String getField10() {
		return this.field10;
	}

	public void setField10(String field10) {
		this.field10 = field10;
	}

	@Column(name = "field11", length = 200)
	public String getField11() {
		return this.field11;
	}

	public void setField11(String field11) {
		this.field11 = field11;
	}

	@Column(name = "field12", length = 200)
	public String getField12() {
		return this.field12;
	}

	public void setField12(String field12) {
		this.field12 = field12;
	}

	@Column(name = "USER_ID", length = 50)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "MOD_DATE", length = 7)
	public String getModDate() {
		return this.modDate;
	}

	public void setModDate(String modDate) {
		this.modDate = modDate;
	}

	@Column(name = "MOD_TIME", length = 6)
	public String getModTime() {
		return this.modTime;
	}

	public void setModTime(String modTime) {
		this.modTime = modTime;
	}

}
