package com.kangdainfo.ctis.model.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.kangdainfo.common.model.bo.BaseModel;

@Entity
@Table(name = "CT_MEMBER_INFO")
public class CtMemberInfo extends BaseModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7141122514914085602L;
	/**
	 * 
	 */

	private Integer id;

	/** page 1 fields **/
	private String ctMemberId; // 精舍學員在本山的ID
	private String fullName; // 學員的姓名
	private String aliasName; // 化名
	private String firstName; // (當地)名
	private String lastName; // (當地)姓
	private String ctDharmaName; // 中台山皈依法名
	private String ctRefugeMaster; // 中台山皈依師德號
	private String otherDharmaName; // 其它道場皈依法名
	private String otherRefugeMaster; // 其它道場皈依師德號
	private String pinyinFirstName; // (拼音)名
	private String pinyinLastName; // (拼音)姓
	private String pinyinOtherDharmaName; // (拼音)法名
	private String otherFirstName; // 輔助性、次要(secondary)名
	private String otherLastName; // 輔助性、次要(secondary)姓
	private String gender; // 性別
	private String twIdNum; // 身分證號碼
	private String twIdNumDisplay; //
	private String otherIdNum; // 護照、駕照 … etc 號碼 (外國用)
	private String birthDate; // 身分證生日
	private String birthMMDD; // 身分證生日的 月日format
	private String birthCalendar; //曆法
	private String birthDisplay; //生日顯示
	private String passcode; // 個人通行密碼
	private String mobileNum1; // 行動電話1
	private String mobileNum2; // 行動電話2
	private String mobileNum3; // 行動電話3
	private String homePhoneNum1; // 住家電話1
	private String homePhoneNum2; // 住家電話2
	private String urgentContactPersonName1; // 緊急聯絡人1
	private String urgentContactPersonRelationship1; // 緊急聯絡人關係1
	private String urgentContactPersonPhoneNum1; // 緊急聯絡人電話1
	private String urgentContactPersonName2; // 緊急聯絡人2
	private String urgentContactPersonRelationship2; // 緊急聯絡人關係2
	private String urgentContactPersonPhoneNum2; // 緊急聯絡人電話2
	private String donationType; // 本山發心
	private String classList; // 學佛經歷
	private String personalPhotoFileName; // 個人照片
	private Boolean onBlackList; // 是否特別留意
	private Boolean onNostayList; // 是否不予留單
	private String thisPersonStatus; // 此學員狀態

	/** page 2 fields **/
	private String nationality; // 國家
	private String ethnicGroup; // 民族/種族/族群 (外國用)
	private String familyProvince; // 籍貫(省)
	private String familyCity; // 籍貫(縣市)
	private String birthProvinceCountry; // 出生地(省)
	private String birthCity; // 出生地(縣市)
	private String email1; // email帳號1
	private String email2; // email帳號2
	private Boolean marriageStatus; // 身分證婚姻狀況
	private String twIdAddress; // 身分證的住址
	private String mailingAddress; // 通訊住址
	private String mailingCity; // 通訊住址-鄉鎮區
	private String mailingState; // 通訊住址-縣市
	private String mailingZip; // 通訊住址-郵遞區號
	private String mailingCountry; // 通訊住址-國家
	private String permanentAddress; // 永久住址
	private String permanentCity; // 永久住址-鄉鎮區
	private String permanentState; // 永久住址-縣市
	private String permanentZip; // 永久住址-郵遞區號
	private String permanentCountry; // 永久住址-國家
	private Boolean okSendEmail; // 是否寄email
	private String schoolName; // 學校
	private String schoolMajor; // 系所
	private String schoolDegree; // 學位
	private String companyName; // 目前工作的公司名稱
	private String companyAddress; // 目前工作的公司地址
	private String companyJobTitle; // 目前公司的頭銜
	private String officePhoneNum1; // 公司電話1
	private String officePhoneNum2; // 公司電話2
	private String referenceId; // 來精舍原因
	private String introducerName; // 介紹人
	private String introducerRelationship; // 介紹人與學員的關係
	private String introducerPhoneNum; // 介紹人聯絡電話
	private Boolean okSendMagazine; // 是否寄發中台月刊
	private Boolean okSendEletter; // 是否寄發通啟
	private Boolean okSendMessage; // 是否傳簡訊
	private String okToCallType; // 可電話聯絡的時段
	private Integer zen7Count; // 打七次數
	private Integer zen7VlntrCount; // 護七次數
	private Integer summerVlntrConut; // 護夏次數
	private Boolean takeRefuge; // 是否受三皈
	private String refugeDate; // 受三皈日期
	private String refugePlace; // 受三皈地點
	private Boolean takePrecept5; // 是否受五戒
	private String precept5Date; // 受五戒日期
	private String precept5Place; // 受五戒地點
	private Boolean takeBodhiPrecept; // 是否受菩薩戒
	private String bodhiPreceptDate; // 受菩薩戒日期
	private String bodhiPreceptPlace; // 受菩薩戒地點

	/** page 3 fields **/
	private String carNum1; // 車號1
	private String carNum2; // 車號2
	private Double height; // 身高(cm)
	private Double weight; // 體重(kg)
	private Boolean after2012Oct; // 是否2012/10/1 後才到
	private Boolean isPiSigned; // 是否簽個資同意書
	private String piDocId; // 本山個資同意書編號
	private String piAggrementPicFileName; // 個資同意書1scan
	private String piParentAggrementPicFileName; // 個資同意書2 scan (家長同意書)
	private String twIdPicFrontFileName; // 照片，身分證正面照
	private String twIdPicBackFileName; // 照片，身分證反面照

	public CtMemberInfo() {
	}

	public CtMemberInfo(Integer id) {
		this.id = id;

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "id", sequenceName = "CT_MEMBER_INFO_SEQ")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/** page 1 fields setter getter **/
	
	@Column(name = "aliasName", length = 60)
	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	@Column(name = "ctMemberId", length = 15)
	public String getCtMemberId() {
		return ctMemberId;
	}

	public void setCtMemberId(String ctMemberId) {
		this.ctMemberId = ctMemberId;
	}

	@Column(name = "fullName", length = 60)
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Column(name = "ctDharmaName", length = 30)
	public String getCtDharmaName() {
		return ctDharmaName;
	}

	public void setCtDharmaName(String ctDharmaName) {
		this.ctDharmaName = ctDharmaName;
	}

	@Column(name = "ctRefugeMaster", length = 30)
	public String getCtRefugeMaster() {
		return ctRefugeMaster;
	}

	public void setCtRefugeMaster(String ctRefugeMaster) {
		this.ctRefugeMaster = ctRefugeMaster;
	}

	@Column(name = "twIdNum", length = 100)
	public String getTwIdNum() {
		return twIdNum;
	}

	public void setTwIdNum(String twIdNum) {
		this.twIdNum = twIdNum;
	}

	@Column(name = "twIdNumDisplay", length = 20)
	public String getTwIdNumDisplay() {
		return twIdNumDisplay;
	}

	public void setTwIdNumDisplay(String twIdNumDisplay) {
		this.twIdNumDisplay = twIdNumDisplay;
	}

	@Column(name = "otherIdNum", length = 25)
	public String getOtherIdNum() {
		return otherIdNum;
	}

	public void setOtherIdNum(String otherIdNum) {
		this.otherIdNum = otherIdNum;
	}

	@Column(name = "gender", length = 1)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "birthDate", length = 100)
	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	@Column(name = "birthMMDD", length = 100)
	public String getBirthMMDD() {
		return birthMMDD;
	}

	public void setBirthMMDD(String birthMMDD) {
		this.birthMMDD = birthMMDD;
	}
	
	@Column(name = "birthCalendar", length = 2)
	public String getBirthCalendar() {
		return birthCalendar;
	}

	public void setBirthCalendar(String birthCalendar) {
		this.birthCalendar = birthCalendar;
	}

	@Column(name = "birthDisplay", length = 50)
	public String getBirthDisplay() {
		return birthDisplay;
	}

	public void setBirthDisplay(String birthDisplay) {
		this.birthDisplay = birthDisplay;
	}

	@Column(name = "firstName", length = 30)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "lastName", length = 30)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "otherDharmaName", length = 30)
	public String getOtherDharmaName() {
		return otherDharmaName;
	}

	public void setOtherDharmaName(String otherDharmaName) {
		this.otherDharmaName = otherDharmaName;
	}

	@Column(name = "otherRefugeMaster", length = 30)
	public String getOtherRefugeMaster() {
		return otherRefugeMaster;
	}

	public void setOtherRefugeMaster(String otherRefugeMaster) {
		this.otherRefugeMaster = otherRefugeMaster;
	}

	@Column(name = "pinyinFirstName", length = 30)
	public String getPinyinFirstName() {
		return pinyinFirstName;
	}

	public void setPinyinFirstName(String pinyinFirstName) {
		this.pinyinFirstName = pinyinFirstName;
	}

	@Column(name = "pinyinLastName", length = 30)
	public String getPinyinLastName() {
		return pinyinLastName;
	}

	public void setPinyinLastName(String pinyinLastName) {
		this.pinyinLastName = pinyinLastName;
	}

	@Column(name = "pinyinOtherDharmaName", length = 30)
	public String getPinyinOtherDharmaName() {
		return pinyinOtherDharmaName;
	}

	public void setPinyinOtherDharmaName(String pinyinOtherDharmaName) {
		this.pinyinOtherDharmaName = pinyinOtherDharmaName;
	}

	@Column(name = "otherFirstName", length = 30)
	public String getOtherFirstName() {
		return otherFirstName;
	}

	public void setOtherFirstName(String otherFirstName) {
		this.otherFirstName = otherFirstName;
	}

	@Column(name = "otherLastName", length = 30)
	public String getOtherLastName() {
		return otherLastName;
	}

	public void setOtherLastName(String otherLastName) {
		this.otherLastName = otherLastName;
	}

	@Column(name = "passcode", length = 4)
	public String getPasscode() {
		return passcode;
	}

	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}

	@Column(name = "mobileNum1", length = 20)
	public String getMobileNum1() {
		return mobileNum1;
	}

	public void setMobileNum1(String mobileNum1) {
		this.mobileNum1 = mobileNum1;
	}

	@Column(name = "mobileNum2", length = 20)
	public String getMobileNum2() {
		return mobileNum2;
	}

	public void setMobileNum2(String mobileNum2) {
		this.mobileNum2 = mobileNum2;
	}

	@Column(name = "mobileNum3", length = 20)
	public String getMobileNum3() {
		return mobileNum3;
	}

	public void setMobileNum3(String mobileNum3) {
		this.mobileNum3 = mobileNum3;
	}

	@Column(name = "homePhoneNum1", length = 20)
	public String getHomePhoneNum1() {
		return homePhoneNum1;
	}

	public void setHomePhoneNum1(String homePhoneNum1) {
		this.homePhoneNum1 = homePhoneNum1;
	}

	@Column(name = "homePhoneNum2", length = 20)
	public String getHomePhoneNum2() {
		return homePhoneNum2;
	}

	public void setHomePhoneNum2(String homePhoneNum2) {
		this.homePhoneNum2 = homePhoneNum2;
	}

	@Column(name = "urgentContactPersonName1", length = 60)
	public String getUrgentContactPersonName1() {
		return urgentContactPersonName1;
	}

	public void setUrgentContactPersonName1(String urgentContactPersonName1) {
		this.urgentContactPersonName1 = urgentContactPersonName1;
	}

	@Column(name = "urgentContactPersonRelationship1", length = 10)
	public String getUrgentContactPersonRelationship1() {
		return urgentContactPersonRelationship1;
	}

	public void setUrgentContactPersonRelationship1(
			String urgentContactPersonRelationship1) {
		this.urgentContactPersonRelationship1 = urgentContactPersonRelationship1;
	}

	@Column(name = "urgentContactPersonPhoneNum1", length = 15)
	public String getUrgentContactPersonPhoneNum1() {
		return urgentContactPersonPhoneNum1;
	}

	public void setUrgentContactPersonPhoneNum1(
			String urgentContactPersonPhoneNum1) {
		this.urgentContactPersonPhoneNum1 = urgentContactPersonPhoneNum1;
	}

	@Column(name = "urgentContactPersonName2", length = 60)
	public String getUrgentContactPersonName2() {
		return urgentContactPersonName2;
	}

	public void setUrgentContactPersonName2(String urgentContactPersonName2) {
		this.urgentContactPersonName2 = urgentContactPersonName2;
	}

	@Column(name = "urgentContactPersonRelationship2", length = 10)
	public String getUrgentContactPersonRelationship2() {
		return urgentContactPersonRelationship2;
	}

	public void setUrgentContactPersonRelationship2(
			String urgentContactPersonRelationship2) {
		this.urgentContactPersonRelationship2 = urgentContactPersonRelationship2;
	}

	@Column(name = "urgentContactPersonPhoneNum2", length = 15)
	public String getUrgentContactPersonPhoneNum2() {
		return urgentContactPersonPhoneNum2;
	}

	public void setUrgentContactPersonPhoneNum2(
			String urgentContactPersonPhoneNum2) {
		this.urgentContactPersonPhoneNum2 = urgentContactPersonPhoneNum2;
	}

	@Column(name = "donationType", length = 30)
	public String getDonationType() {
		return donationType;
	}

	public void setDonationType(String donationType) {
		this.donationType = donationType;
	}

	@Column(name = "classList", length = 20)
	public String getClassList() {
		return classList;
	}

	public void setClassList(String classList) {
		this.classList = classList;
	}

	@Column(name = "personalPhotoFileName", length = 255)
	public String getPersonalPhotoFileName() {
		return personalPhotoFileName;
	}

	public void setPersonalPhotoFileName(String personalPhotoFileName) {
		this.personalPhotoFileName = personalPhotoFileName;
	}

	@Column(name = "onBlackList")
	public Boolean getOnBlackList() {
		return onBlackList;
	}

	public void setOnBlackList(Boolean onBlackList) {
		this.onBlackList = onBlackList;
	}

	@Column(name = "onNostayList")
	public Boolean getOnNostayList() {
		return onNostayList;
	}

	public void setOnNostayList(Boolean onNostayList) {
		this.onNostayList = onNostayList;
	}

	@Column(name = "thisPersonStatus", length = 3)
	public String getThisPersonStatus() {
		return thisPersonStatus;
	}

	public void setThisPersonStatus(String thisPersonStatus) {
		this.thisPersonStatus = thisPersonStatus;
	}
	
	/** page 2 fields setter getter **/
	
	@Column(name = "email1", length = 50)
	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	@Column(name = "email2", length = 50)
	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	@Column(name = "nationality",  length = 10)
	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Column(name = "ethnicGroup",  length = 10)
	public String getEthnicGroup() {
		return ethnicGroup;
	}

	public void setEthnicGroup(String ethnicGroup) {
		this.ethnicGroup = ethnicGroup;
	}

	@Column(name = "familyProvince",  length = 15)
	public String getFamilyProvince() {
		return familyProvince;
	}

	public void setFamilyProvince(String familyProvince) {
		this.familyProvince = familyProvince;
	}

	@Column(name = "familyCity",  length = 15)
	public String getFamilyCity() {
		return familyCity;
	}

	public void setFamilyCity(String familyCity) {
		this.familyCity = familyCity;
	}

	@Column(name = "birthProvinceCountry",  length = 40)
	public String getBirthProvinceCountry() {
		return birthProvinceCountry;
	}

	public void setBirthProvinceCountry(String birthProvinceCountry) {
		this.birthProvinceCountry = birthProvinceCountry;
	}

	@Column(name = "birthCity",  length = 15)
	public String getBirthCity() {
		return birthCity;
	}

	public void setBirthCity(String birthCity) {
		this.birthCity = birthCity;
	}

	@Column(name = "marriageStatus")
	public Boolean getMarriageStatus() {
		return marriageStatus;
	}

	public void setMarriageStatus(Boolean marriageStatus) {
		this.marriageStatus = marriageStatus;
	}

	@Column(name = "twIdAddress",  length = 80)
	public String getTwIdAddress() {
		return twIdAddress;
	}

	public void setTwIdAddress(String twIdAddress) {
		this.twIdAddress = twIdAddress;
	}

	@Column(name = "mailingAddress",  length = 80)
	public String getMailingAddress() {
		return mailingAddress;
	}

	public void setMailingAddress(String mailingAddress) {
		this.mailingAddress = mailingAddress;
	}

	@Column(name = "mailingCity",  length = 30)
	public String getMailingCity() {
		return mailingCity;
	}

	public void setMailingCity(String mailingCity) {
		this.mailingCity = mailingCity;
	}

	@Column(name = "mailingState",  length = 30)
	public String getMailingState() {
		return mailingState;
	}

	public void setMailingState(String mailingState) {
		this.mailingState = mailingState;
	}

	@Column(name = "mailingZip",  length = 15)
	public String getMailingZip() {
		return mailingZip;
	}

	public void setMailingZip(String mailingZip) {
		this.mailingZip = mailingZip;
	}

	@Column(name = "mailingCountry",  length = 10)
	public String getMailingCountry() {
		return mailingCountry;
	}

	public void setMailingCountry(String mailingCountry) {
		this.mailingCountry = mailingCountry;
	}

	@Column(name = "permanentAddress",  length = 80)
	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	@Column(name = "permanentCity",  length = 30)
	public String getPermanentCity() {
		return permanentCity;
	}

	public void setPermanentCity(String permanentCity) {
		this.permanentCity = permanentCity;
	}

	@Column(name = "permanentState",  length = 30)
	public String getPermanentState() {
		return permanentState;
	}

	public void setPermanentState(String permanentState) {
		this.permanentState = permanentState;
	}

	@Column(name = "permanentZip",  length = 15)
	public String getPermanentZip() {
		return permanentZip;
	}

	public void setPermanentZip(String permanentZip) {
		this.permanentZip = permanentZip;
	}

	@Column(name = "permanentCountry",  length = 10)
	public String getPermanentCountry() {
		return permanentCountry;
	}

	public void setPermanentCountry(String permanentCountry) {
		this.permanentCountry = permanentCountry;
	}

	@Column(name = "okSendEmail")
	public Boolean getOkSendEmail() {
		return okSendEmail;
	}

	public void setOkSendEmail(Boolean okSendEmail) {
		this.okSendEmail = okSendEmail;
	}

	@Column(name = "schoolName",  length = 30)
	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	@Column(name = "schoolMajor",  length = 30)
	public String getSchoolMajor() {
		return schoolMajor;
	}

	public void setSchoolMajor(String schoolMajor) {
		this.schoolMajor = schoolMajor;
	}

	@Column(name = "schoolDegree",  length = 5)
	public String getSchoolDegree() {
		return schoolDegree;
	}

	public void setSchoolDegree(String schoolDegree) {
		this.schoolDegree = schoolDegree;
	}

	@Column(name = "companyName",  length = 30)
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "companyAddress",  length = 80)
	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	@Column(name = "companyJobTitle",  length = 30)
	public String getCompanyJobTitle() {
		return companyJobTitle;
	}

	public void setCompanyJobTitle(String companyJobTitle) {
		this.companyJobTitle = companyJobTitle;
	}

	@Column(name = "officePhoneNum1",  length = 20)
	public String getOfficePhoneNum1() {
		return officePhoneNum1;
	}

	public void setOfficePhoneNum1(String officePhoneNum1) {
		this.officePhoneNum1 = officePhoneNum1;
	}

	@Column(name = "officePhoneNum2",  length = 20)
	public String getOfficePhoneNum2() {
		return officePhoneNum2;
	}

	public void setOfficePhoneNum2(String officePhoneNum2) {
		this.officePhoneNum2 = officePhoneNum2;
	}

	@Column(name = "referenceId",  length = 4)
	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	@Column(name = "introducerName",  length = 20)
	public String getIntroducerName() {
		return introducerName;
	}

	public void setIntroducerName(String introducerName) {
		this.introducerName = introducerName;
	}

	@Column(name = "introducerRelationship",  length = 6)
	public String getIntroducerRelationship() {
		return introducerRelationship;
	}

	public void setIntroducerRelationship(String introducerRelationship) {
		this.introducerRelationship = introducerRelationship;
	}

	@Column(name = "introducerPhoneNum",  length = 20)
	public String getIntroducerPhoneNum() {
		return introducerPhoneNum;
	}

	public void setIntroducerPhoneNum(String introducerPhoneNum) {
		this.introducerPhoneNum = introducerPhoneNum;
	}

	@Column(name = "okSendMagazine")
	public Boolean getOkSendMagazine() {
		return okSendMagazine;
	}

	public void setOkSendMagazine(Boolean okSendMagazine) {
		this.okSendMagazine = okSendMagazine;
	}

	@Column(name = "okSendEletter")
	public Boolean getOkSendEletter() {
		return okSendEletter;
	}

	public void setOkSendEletter(Boolean okSendEletter) {
		this.okSendEletter = okSendEletter;
	}

	@Column(name = "okSendMessage")
	public Boolean getOkSendMessage() {
		return okSendMessage;
	}

	public void setOkSendMessage(Boolean okSendMessage) {
		this.okSendMessage = okSendMessage;
	}

	@Column(name = "okToCallType",  length = 10)
	public String getOkToCallType() {
		return okToCallType;
	}

	public void setOkToCallType(String okToCallType) {
		this.okToCallType = okToCallType;
	}

	@Column(name = "zen7Count")
	public Integer getZen7Count() {
		return zen7Count;
	}

	public void setZen7Count(Integer zen7Count) {
		this.zen7Count = zen7Count;
	}

	@Column(name = "zen7VlntrCount")
	public Integer getZen7VlntrCount() {
		return zen7VlntrCount;
	}

	public void setZen7VlntrCount(Integer zen7VlntrCount) {
		this.zen7VlntrCount = zen7VlntrCount;
	}

	@Column(name = "summerVlntrConut")
	public Integer getSummerVlntrConut() {
		return summerVlntrConut;
	}

	public void setSummerVlntrConut(Integer summerVlntrConut) {
		this.summerVlntrConut = summerVlntrConut;
	}

	@Column(name = "takeRefuge")
	public Boolean getTakeRefuge() {
		return takeRefuge;
	}

	public void setTakeRefuge(Boolean takeRefuge) {
		this.takeRefuge = takeRefuge;
	}

	@Column(name = "refugeDate",  length = 8)
	public String getRefugeDate() {
		return refugeDate;
	}

	public void setRefugeDate(String refugeDate) {
		this.refugeDate = refugeDate;
	}

	@Column(name = "refugePlace",  length = 20)
	public String getRefugePlace() {
		return refugePlace;
	}

	public void setRefugePlace(String refugePlace) {
		this.refugePlace = refugePlace;
	}

	@Column(name = "takePrecept5")
	public Boolean getTakePrecept5() {
		return takePrecept5;
	}

	public void setTakePrecept5(Boolean takePrecept5) {
		this.takePrecept5 = takePrecept5;
	}

	@Column(name = "precept5Date",  length = 8)
	public String getPrecept5Date() {
		return precept5Date;
	}

	public void setPrecept5Date(String precept5Date) {
		this.precept5Date = precept5Date;
	}

	@Column(name = "precept5Place",  length = 20)
	public String getPrecept5Place() {
		return precept5Place;
	}

	public void setPrecept5Place(String precept5Place) {
		this.precept5Place = precept5Place;
	}

	@Column(name = "takeBodhiPrecept")
	public Boolean getTakeBodhiPrecept() {
		return takeBodhiPrecept;
	}

	public void setTakeBodhiPrecept(Boolean takeBodhiPrecept) {
		this.takeBodhiPrecept = takeBodhiPrecept;
	}

	@Column(name = "bodhiPreceptDate",  length = 8)
	public String getBodhiPreceptDate() {
		return bodhiPreceptDate;
	}

	public void setBodhiPreceptDate(String bodhiPreceptDate) {
		this.bodhiPreceptDate = bodhiPreceptDate;
	}

	@Column(name = "bodhiPreceptPlace",  length = 20)
	public String getBodhiPreceptPlace() {
		return bodhiPreceptPlace;
	}

	public void setBodhiPreceptPlace(String bodhiPreceptPlace) {
		this.bodhiPreceptPlace = bodhiPreceptPlace;
	}

	/** page 3 fields setter getter **/
	
	@Column(name = "carNum1",  length = 15)
	public String getCarNum1() {
		return carNum1;
	}

	public void setCarNum1(String carNum1) {
		this.carNum1 = carNum1;
	}
	
	@Column(name = "carNum2",  length = 15)
	public String getCarNum2() {
		return carNum2;
	}

	public void setCarNum2(String carNum2) {
		this.carNum2 = carNum2;
	}

	@Column(name = "height")
	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	@Column(name = "weight")
	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	@Column(name = "after2012Oct")
	public Boolean getAfter2012Oct() {
		return after2012Oct;
	}

	public void setAfter2012Oct(Boolean after2012Oct) {
		this.after2012Oct = after2012Oct;
	}

	@Column(name = "isPiSigned")
	public Boolean getIsPiSigned() {
		return isPiSigned;
	}

	public void setIsPiSigned(Boolean isPiSigned) {
		this.isPiSigned = isPiSigned;
	}

	@Column(name = "piDocId",  length = 15)
	public String getPiDocId() {
		return piDocId;
	}

	public void setPiDocId(String piDocId) {
		this.piDocId = piDocId;
	}

	@Column(name = "piAggrementPicFileName",  length = 255)
	public String getPiAggrementPicFileName() {
		return piAggrementPicFileName;
	}

	public void setPiAggrementPicFileName(String piAggrementPicFileName) {
		this.piAggrementPicFileName = piAggrementPicFileName;
	}

	@Column(name = "piParentAggrementPicFileName",  length = 255)
	public String getPiParentAggrementPicFileName() {
		return piParentAggrementPicFileName;
	}

	public void setPiParentAggrementPicFileName(String piParentAggrementPicFileName) {
		this.piParentAggrementPicFileName = piParentAggrementPicFileName;
	}

	@Column(name = "twIdPicFrontFileName",  length = 255)
	public String getTwIdPicFrontFileName() {
		return twIdPicFrontFileName;
	}

	public void setTwIdPicFrontFileName(String twIdPicFrontFileName) {
		this.twIdPicFrontFileName = twIdPicFrontFileName;
	}

	@Column(name = "twIdPicBackFileName",  length = 255)
	public String getTwIdPicBackFileName() {
		return twIdPicBackFileName;
	}

	public void setTwIdPicBackFileName(String twIdPicBackFileName) {
		this.twIdPicBackFileName = twIdPicBackFileName;
	}	
}
