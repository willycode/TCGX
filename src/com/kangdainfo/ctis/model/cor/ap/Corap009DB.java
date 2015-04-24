package com.kangdainfo.ctis.model.cor.ap;

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
@Table(name = "TMP_MEMBER_RECORD")
public class Corap009DB extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 210573323872164832L;
	private Integer id;
	private String center;
    private String fullName;
    private String ctDharmaName;
    private String gender;
    private String homePhoneNum1;
    private String officePhoneNum1;
    private String mobileNum1;
    private String birthDate;
    private String twIdNum;
    private String familyProvince;
    private String familyCity;
    private String companyName;
    private String companyJobTitle;
    private String introducerName;
    private String introducerRelationship;
    private String donationType;
    private String urgentContactPersonName1;
    private String urgentContactPersonRelationship1;
    private String urgentContactPersonPhoneNum1;
    private String schoolDegree;
    private String schoolName;
    private String school_major;
    private String mailingAddress;
    private String email1;
    private String okSendMagazine;
    private String okSendEletter;
    private String birthProvinceCountry;

	public Corap009DB() {
	}

	public Corap009DB(
			Integer id,
			String center,
			String fullName, 
			String ctDharmaName, 
			String gender,
            String homePhoneNum1,
            String officePhoneNum1,
            String mobileNum1,
            String birthDate,
            String twIdNum,
            String familyProvince,
            String familyCity,
            String companyName,
            String companyJobTitle,
            String introducerName,
            String introducerRelationship,
            String donationType,
            String urgentContactPersonName1,
            String urgentContactPersonRelationship1,
            String urgentContactPersonPhoneNum1,
            String schoolDegree,
            String schoolName,
            String school_major,
            String mailingAddress,
            String email1,
            String okSendMagazine,
            String okSendEletter,
            String birthProvinceCountry
           ) {

				this.id = id;
				this.center = center;
	    		this.fullName = fullName; 
	            this.ctDharmaName = ctDharmaName; 
	            this.gender = gender; 
	            this.homePhoneNum1 = homePhoneNum1;
	            this.officePhoneNum1 = officePhoneNum1;
	            this.mobileNum1 = mobileNum1;
	            this.birthDate = birthDate;
	            this.twIdNum = twIdNum;
	            this.familyProvince = familyProvince;
	            this.familyCity = familyCity;
	            this.companyName = companyName;
	            this.companyJobTitle = companyJobTitle;
	            this.introducerName = introducerName;
	            this.introducerRelationship = introducerRelationship;
	            this.donationType = donationType;
	            this.urgentContactPersonName1 = urgentContactPersonName1;
	            this.urgentContactPersonRelationship1 = urgentContactPersonRelationship1;
	            this.urgentContactPersonPhoneNum1 = urgentContactPersonPhoneNum1;
	            this.schoolDegree = schoolDegree;
	            this.schoolName = schoolName;
	            this.school_major = school_major;
	            this.mailingAddress = mailingAddress;
	            this.email1 = email1;
	            this.okSendMagazine = okSendMagazine;
	            this.okSendEletter = okSendEletter;
	            this.birthProvinceCountry = birthProvinceCountry;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "id", sequenceName = "TMP_MEMBER_RECORD_SEQ")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	// 精舍
	@Column(name = "center", length = 10)
	public String getCenter() {
		return center;
	}

	public void setCenter(String center) {
		this.center = center;
	}

	// 姓名
	@Column(name = "fullName", length = 60)
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	// 法名
	@Column(name = "ctDharmaName", length = 30)
	public String getCtDharmaName() {
		return ctDharmaName;
	}

	public void setCtDharmaName(String ctDharmaName) {
		this.ctDharmaName = ctDharmaName;
	}
	
	@Column(name = "gender", length = 1)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Column(name = "homePhoneNum1", length = 20)
	public String getHomePhoneNum1() {
		return homePhoneNum1;
	}

	public void setHomePhoneNum1(String homePhoneNum1) {
		this.homePhoneNum1 = homePhoneNum1;
	}
	
	@Column(name = "officePhoneNum1", length = 20)
	public String getOfficePhoneNum1() {
		return officePhoneNum1;
	}

	public void setOfficePhoneNum1(String officePhoneNum1) {
		this.officePhoneNum1 = officePhoneNum1;
	}
	
	@Column(name = "mobileNum1", length = 20)
	public String getMobileNum1() {
		return mobileNum1;
	}

	public void setMobileNum1(String mobileNum1) {
		this.mobileNum1 = mobileNum1;
	}
	
	@Column(name = "birthDate", length = 8)
	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	@Column(name = "twIdNum", length = 20)
	public String getTwIdNum() {
		return twIdNum;
	}

	public void setTwIdNum(String twIdNum) {
		this.twIdNum = twIdNum;
	}
	
	@Column(name = "familyProvince", length = 15)
	public String getFamilyProvince() {
		return familyProvince;
	}

	public void setFamilyProvince(String familyProvince) {
		this.familyProvince = familyProvince;
	}
	
	@Column(name = "familyCity", length = 15)
	public String getFamilyCity() {
		return familyCity;
	}

	public void setFamilyCity(String familyCity) {
		this.familyCity = familyCity;
	}
	
	@Column(name = "companyName", length = 30)
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	@Column(name = "companyJobTitle", length = 30)
	public String getCompanyJobTitle() {
		return companyJobTitle;
	}

	public void setCompanyJobTitle(String companyJobTitle) {
		this.companyJobTitle = companyJobTitle;
	}
	
	@Column(name = "introducerName", length = 20)
	public String getIntroducerName() {
		return introducerName;
	}

	public void setIntroducerName(String introducerName) {
		this.introducerName = introducerName;
	}
	
	@Column(name = "introducerRelationship", length = 6)
	public String getIntroducerRelationship() {
		return introducerRelationship;
	}

	public void setIntroducerRelationship(String introducerRelationship) {
		this.introducerRelationship = introducerRelationship;
	}
	
	@Column(name = "donationType", length = 30)
	public String getDonationType() {
		return donationType;
	}

	public void setDonationType(String donationType) {
		this.donationType = donationType;
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

	public void setUrgentContactPersonRelationship1(String urgentContactPersonRelationship1) {
		this.urgentContactPersonRelationship1 = urgentContactPersonRelationship1;
	}
	
	@Column(name = "urgentContactPersonPhoneNum1", length = 15)
	public String getUrgentContactPersonPhoneNum1() {
		return urgentContactPersonPhoneNum1;
	}

	public void setUrgentContactPersonPhoneNum1(String urgentContactPersonPhoneNum1) {
		this.urgentContactPersonPhoneNum1 = urgentContactPersonPhoneNum1;
	}
	
	@Column(name = "schoolDegree", length = 8)
	public String getSchoolDegree() {
		return schoolDegree;
	}

	public void setSchoolDegree(String schoolDegree) {
		this.schoolDegree = schoolDegree;
	}
	
	@Column(name = "schoolName", length = 30)
	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	@Column(name = "school_major", length = 30)
	public String getSchool_major() {
		return school_major;
	}

	public void setSchool_major(String school_major) {
		this.school_major = school_major;
	}
	
	@Column(name = "mailingAddress", length = 80)
	public String getMailingAddress() {
		return mailingAddress;
	}

	public void setMailingAddress(String mailingAddress) {
		this.mailingAddress = mailingAddress;
	}
	
	@Column(name = "email1", length = 50)
	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	
	@Column(name = "okSendMagazine", length = 1)
	public String getOkSendMagazine() {
		return okSendMagazine;
	}

	public void setOkSendMagazine(String okSendMagazine) {
		this.okSendMagazine = okSendMagazine;
	}
	
	@Column(name = "okSendEletter", length = 1)
	public String getOkSendEletter() {
		return okSendEletter;
	}

	public void setOkSendEletter(String okSendEletter) {
		this.okSendEletter = okSendEletter;
	}
	
	@Column(name = "birthProvinceCountry", length = 15)
	public String getBirthProvinceCountry() {
		return birthProvinceCountry;
	}

	public void setBirthProvinceCountry(String birthProvinceCountry) {
		this.birthProvinceCountry = birthProvinceCountry;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Corap009DB [id=");
		sb.append(id);
		sb.append(", center=");
		sb.append(center);
		sb.append(", fullName=");
		sb.append(fullName);
		sb.append(", ctDharmaName=");
		sb.append(ctDharmaName);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", homePhoneNum1=");
		sb.append(homePhoneNum1);
		sb.append(", officePhoneNum1=");
		sb.append(officePhoneNum1);
		sb.append(", mobileNum1=");
		sb.append(mobileNum1);
		sb.append(", birthDate=");
		sb.append(birthDate);
		sb.append(", twIdNum=");
		sb.append(twIdNum);
		sb.append(", familyProvince=");
		sb.append(familyProvince);
		sb.append(", familyCity=");
		sb.append(familyCity);
		sb.append(", companyName=");
		sb.append(companyName);
		sb.append(", companyJobTitle=");
		sb.append(companyJobTitle);
		sb.append(", introducerName=");
		sb.append(introducerName);
		sb.append(", introducerRelationship=");
		sb.append(introducerRelationship);
		sb.append(", donationType=");
		sb.append(donationType);
		sb.append(", urgentContactPersonName1=");
		sb.append(urgentContactPersonName1);
		sb.append(", urgentContactPersonRelationship1=");
		sb.append(urgentContactPersonRelationship1);
		sb.append(", urgentContactPersonPhoneNum1=");
		sb.append(urgentContactPersonPhoneNum1);
		sb.append(", schoolDegree=");
		sb.append(schoolDegree);
		sb.append(", schoolName=");
		sb.append(schoolName);
		sb.append(", school_major=");
		sb.append(school_major);
		sb.append(", mailingAddress=");
		sb.append(mailingAddress);
		sb.append(", email1=");
		sb.append(email1);
		sb.append(", okSendMagazine=");
		sb.append(okSendMagazine);
		sb.append(", okSendEletter=");
		sb.append(okSendEletter);
		sb.append(", birthProvinceCountry=");
		sb.append(birthProvinceCountry);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", createId=");
		sb.append(createId);
		sb.append(", createTime=");
		sb.append(createTime);
		sb.append(", updateDate=");
		sb.append(updateDate);
		sb.append(", updateId=");
		sb.append(updateId);
		sb.append(", updateIp=");
		sb.append(updateIp);
		sb.append(", updateTime=");
		sb.append(updateTime);
		sb.append(", updateUnitShortName=");
		sb.append(updateUnitShortName);
		sb.append("]");

		return sb.toString();
	}

}
