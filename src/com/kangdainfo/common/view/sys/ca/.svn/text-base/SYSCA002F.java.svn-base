package com.kangdainfo.common.view.sys.ca;

import org.apache.commons.lang.StringEscapeUtils;

import com.kangdainfo.ServiceGetter;
import com.kangdainfo.common.model.bo.CommonDepartment;
import com.kangdainfo.common.model.bo.CommonUser;
import com.kangdainfo.common.util.Common;
import com.kangdainfo.common.util.SubjectCodeUtil;
import com.kangdainfo.common.util.SuperBean;
import com.kangdainfo.common.util.View;

/**
*<br>程式目的：機關代碼維護作業
*<br>程式代號：sysca002f
*<br>程式日期：0960415
*<br>程式作者：clive.chang
*<br>--------------------------------------------------------
*<br>修改作者　　修改日期　　　修改目的
*<br>--------------------------------------------------------
*/
public class SYSCA002F extends SuperBean {
	String accountingYear;
	String id;
	String pid;
	String level;
	String zip;
	String departmentCode;
	String fullCode;
	String preFullCode;
	String fullName;
	String department;
	String shortCode, shortName;
	String phone;
	String fax;
	String address;
	String description;
	String email;
	String homepage;
	String chiefTitle;
	String chiefName;
	String isSchool;
	String schoolType;
	String pname;
	String parentLevel;
	String parentFullName;
	String parentFullCode;
	String oldid;
	String oldParentId;
	String editDate;
	String editTime;
	String editId;
	//新增欄位
	private String unitCode;
	private String unitType;
	private String unitId;
	private String fundUnitId;
	private String unitFullName;
	private String unitShortName;
	private String unitZoneId;
	private String unitZoneName;
	private String unitStartIp;
	private String unitEndIp;
	private String unitZip;
	private String unitMailingAddress;
	private String unitPhoneNum;
	private String unitMobileNum;
	private String unitFaxNum;
	private String unitManagerId;
	private String unitManagerName;
	private String unitEmail;
	private String unitWebsite;
	private String unitLanguageId;
	private String unitNote;
	private String unitStatus;
	private String unitEnglishName;
	private String unitCountryId;

	
	String q_centerId;
	
	String q_accountingYear;
	String q_id;
	String q_pid;
	String q_departmentCode;
	String q_fullCode;
	String q_fullName;
	String q_department;
	String q_shortCode, q_shortName;
	
	public String getQ_shortCode() {		return checkGet(q_shortCode);	}
	public void setQ_shortCode(String s) {		q_shortCode = checkSet(s); }
	public String getQ_shortName() {		return checkGet(q_shortName);	}
	public void setQ_shortName(String s) {		q_shortName = checkSet(s); }
	public String getAccountingYear(){ return checkGet(accountingYear); }
	public void setAccountingYear(String s){ accountingYear=checkSet(s); }
	public String getId(){ return checkGet(id); }
	public void setId(String s){ id=checkSet(s); }
	public String getPid(){ return checkGet(pid); }
	public void setPid(String s){ pid=checkSet(s); }
	public String getDepartmentCode(){ return checkGet(departmentCode); }
	public void setDepartmentCode(String s){ departmentCode=checkSet(s); }		
	public String getFullCode(){ return checkGet(fullCode); }	
	public void setFullCode(String s){ fullCode=checkSet(s); }
	public String getPreFullCode(){ return checkGet(preFullCode); }	
	public void setPreFullCode(String s){ preFullCode=checkSet(s); }	
	public String getFullName(){ return checkGet(fullName); }
	public void setFullName(String s){ fullName=checkSet(s); }
	public String getDepartment(){ return checkGet(department); }
	public void setDepartment(String s){ department=checkSet(s); }
	public String getShortCode(){ return checkGet(shortCode); }
	public void setShortCode(String s){ shortCode=checkSet(s); }	
	public String getShortName(){ return checkGet(shortName); }
	public void setShortName(String s){ shortName=checkSet(s); }	
	public String getPhone(){ return checkGet(phone); }
	public void setPhone(String s){ phone=checkSet(s); }
	public String getFax(){ return checkGet(fax); }
	public void setFax(String s){ fax=checkSet(s); }
	public String getAddress(){ return checkGet(address); }
	public void setAddress(String s){ address=checkSet(s); }
	public String getDescription(){ return checkGet(description); }
	public void setDescription(String s){ description=checkSet(s); }
	public String getEmail(){ return checkGet(email); }
	public void setEmail(String s){ email=checkSet(s); }
	public String getHomepage(){ return checkGet(homepage); }
	public void setHomepage(String s){ homepage=checkSet(s); }
	public String getChiefTitle(){ return checkGet(chiefTitle); }
	public void setChiefTitle(String s){ chiefTitle=checkSet(s); }
	public String getChiefName(){ return checkGet(chiefName); }
	public void setChiefName(String s){ chiefName=checkSet(s); }
	
	public String getIsSchool() {return checkGet(isSchool);}
	public void setIsSchool(String isSchool) {this.isSchool = checkSet(isSchool);}
	public String getSchoolType() {return checkGet(schoolType);}
	public void setSchoolType(String schoolType) {this.schoolType = checkSet(schoolType);}
	
	public String getParentLevel() {return checkGet(parentLevel);}
	public void setParentLevel(String level) {this.parentLevel = checkSet(level);}	
	public String getPname() { return checkGet(pname); }
	public void setPname(String s) { pname = checkSet(s); }	
	public String getParentFullName() { return checkGet(parentFullName); }
	public void setParentFullName(String s) { parentFullName = checkSet(s); }	
	public String getParentFullCode() { return checkGet(parentFullCode); }
	public void setParentFullCode(String s) { parentFullCode = checkSet(s); }	
	public String getOldid() { return checkGet(oldid); }
	public void setOldid(String s) { oldid = checkSet(s); }	
	public String getOldParentId() { return checkGet(oldParentId); }
	public void setOldParentId(String s) { oldParentId = checkSet(s); }	
	
	public String getLevel() {return checkGet(level);}
	public void setLevel(String level) {this.level = checkSet(level);}
	public String getZip() {return checkGet(zip);}
	public void setZip(String zip) {this.zip = checkSet(zip);}	
	
	public String getEditDate() {return checkGet(editDate);	}
	public void setEditDate(String editDate) {this.editDate = checkSet(editDate);}
	public String getEditTime() {return checkGet(editTime);	}
	public void setEditTime(String editTime) {this.editTime = checkSet(editTime);}
	public String getEditId() {	return checkGet(editId);}
	public void setEditId(String editId) {this.editId = checkSet(editId);}	
	
		
	public String getUnitCode() {
		return checkGet(unitCode);
	}
	public void setUnitCode(String unitCode) {
		this.unitCode = checkSet(unitCode);
	}
	public String getUnitType() {
		return checkGet(unitType);
	}
	public void setUnitType(String unitType) {
		this.unitType = checkSet(unitType);
	}
	public String getUnitId() {
		return checkGet(unitId);
	}
	public void setUnitId(String unitId) {
		this.unitId = checkSet(unitId);
	}
	public String getFundUnitId() {
		return checkGet(fundUnitId);
	}
	public void setFundUnitId(String fundUnitId) {
		this.fundUnitId = checkSet(fundUnitId);
	}
	public String getUnitFullName() {
		return checkGet(unitFullName);
	}
	public void setUnitFullName(String unitFullName) {
		this.unitFullName = checkSet(unitFullName);
	}
	public String getUnitShortName() {
		return checkGet(unitShortName);
	}
	public void setUnitShortName(String unitShortName) {
		this.unitShortName = checkSet(unitShortName);
	}
	public String getUnitZoneId() {
		return checkGet(unitZoneId);
	}
	public void setUnitZoneId(String unitZoneId) {
		this.unitZoneId = checkSet(unitZoneId);
	}
	public String getUnitZoneName() {
		return checkGet(unitZoneName);
	}
	public void setUnitZoneName(String unitZoneName) {
		this.unitZoneName = checkSet(unitZoneName);
	}
	public String getUnitStartIp() {
		return checkGet(unitStartIp);
	}
	public void setUnitStartIp(String unitStartIp) {
		this.unitStartIp = checkSet(unitStartIp);
	}
	public String getUnitEndIp() {
		return checkGet(unitEndIp);
	}
	public void setUnitEndIp(String unitEndIp) {
		this.unitEndIp = checkSet(unitEndIp);
	}
	public String getUnitZip() {
		return checkGet(unitZip);
	}
	public void setUnitZip(String unitZip) {
		this.unitZip = checkSet(unitZip);
	}
	public String getUnitMailingAddress() {
		return checkGet(unitMailingAddress);
	}
	public void setUnitMailingAddress(String unitMailingAddress) {
		this.unitMailingAddress = checkSet(unitMailingAddress);
	}
	public String getUnitPhoneNum() {
		return checkGet(unitPhoneNum);
	}
	public void setUnitPhoneNum(String unitPhoneNum) {
		this.unitPhoneNum = checkSet(unitPhoneNum);
	}
	public String getUnitMobileNum() {
		return checkGet(unitMobileNum);
	}
	public void setUnitMobileNum(String unitMobileNum) {
		this.unitMobileNum = checkSet(unitMobileNum);
	}
	public String getUnitFaxNum() {
		return checkGet(unitFaxNum);
	}
	public void setUnitFaxNum(String unitFaxNum) {
		this.unitFaxNum = checkSet(unitFaxNum);
	}
	public String getUnitManagerId() {
		return checkGet(unitManagerId);
	}
	public void setUnitManagerId(String unitManagerId) {
		this.unitManagerId = checkSet(unitManagerId);
	}
	public String getUnitManagerName() {
		return checkGet(unitManagerName);
	}
	public void setUnitManagerName(String unitManagerName) {
		this.unitManagerName = checkSet(unitManagerName);
	}
	public String getUnitEmail() {
		return checkGet(unitEmail);
	}
	public void setUnitEmail(String unitEmail) {
		this.unitEmail = checkSet(unitEmail);
	}
	public String getUnitWebsite() {
		return checkGet(unitWebsite);
	}
	public void setUnitWebsite(String unitWebsite) {
		this.unitWebsite = checkSet(unitWebsite);
	}
	public String getUnitLanguageId() {
		return checkGet(unitLanguageId);
	}
	public void setUnitLanguageId(String unitLanguageId) {
		this.unitLanguageId = checkSet(unitLanguageId);
	}
	public String getUnitNote() {
		return checkGet(unitNote);
	}
	public void setUnitNote(String unitNote) {
		this.unitNote = checkSet(unitNote);
	}
	public String getUnitStatus() {
		return checkGet(unitStatus);
	}
	public void setUnitStatus(String unitStatus) {
		this.unitStatus = checkSet(unitStatus);
	}
	public String getUnitEnglishName() {
		return checkGet(unitEnglishName);
	}
	public void setUnitEnglishName(String unitEnglishName) {
		this.unitEnglishName = checkSet(unitEnglishName);
	}
	public String getUnitCountryId() {
		return checkGet(unitCountryId);
	}
	public void setUnitCountryId(String unitCountryId) {
		this.unitCountryId = checkSet(unitCountryId);
	}
	public String getQ_centerId() {
		return checkGet(q_centerId);
	}
	public void setQ_centerId(String qCenterId) {
		q_centerId = checkSet(qCenterId);
	}
	
	public String getQ_accountingYear(){ return checkGet(q_accountingYear); }
	public void setQ_accountingYear(String s){ q_accountingYear=checkSet(s); }
	public String getQ_id(){ return checkGet(q_id); }
	public void setQ_id(String s){ q_id=checkSet(s); }
	public String getQ_pid(){ return checkGet(q_pid); }
	public void setQ_pid(String s){ q_pid=checkSet(s); }
	public String getQ_fullCode(){ return checkGet(q_fullCode); }
	public void setQ_fullCode(String s){ q_fullCode=checkSet(s); }
	public String getQ_fullName(){ return checkGet(q_fullName); }
	public void setQ_fullName(String s){ q_fullName=checkSet(s); }
	public String getQ_department(){ return checkGet(q_department); }
	public void setQ_department(String s){ q_department=checkSet(s); }
	public String getQ_departmentCode() {return checkGet(q_departmentCode); }
	public void setQ_departmentCode(String code) {q_departmentCode = checkSet(code);}
	
	String manageOrgan, popOrganID, popOrganName, popFullCode, isLimit, js;
	public String getManageOrgan() {return checkGet(manageOrgan);}
	public void setManageOrgan(String s) {this.manageOrgan = checkSet(s);}
	public String getPopOrganID() {return checkGet(popOrganID);	}
	public void setPopOrganID(String s) {this.popOrganID = checkSet(s);	}
	public String getPopOrganName() {	return checkGet(popOrganName);	}
	public void setPopOrganName(String s) {	this.popOrganName = checkSet(s);	}
	public String getPopFullCode() {	return checkGet(popFullCode);	}
	public void setPopFullCode(String s) {	this.popFullCode = checkSet(s);	}
	public String getIsLimit() {	return checkGet(isLimit);	}
	public void setIsLimit(String s) {	this.isLimit = checkSet(s);	}
	public String getJs() {	return checkGet(js);	}
	public void setJs(String s) {	this.js = checkSet(s);	}
	
	String popId;
	String popCodeName;
	String popCode;
	String preWord;
	public String getPopId(){ return checkGet(popId); }
	public void setPopId(String s){ popId=checkSet(s); }
	public String getPopCodeName(){ return checkGet(popCodeName); }
	public void setPopCodeName(String s){ popCodeName=checkSet(s); }
	public String getPopCode(){ return checkGet(popCode); }
	public void setPopCode(String s){ popCode=checkSet(s); }
	public String getPreWord(){ return checkGet(preWord); }
	public void setPreWord(String s){ preWord=checkSet(s); }
			
	
	@Override
	public void doCreate() throws Exception {
		CommonDepartment obj = new CommonDepartment();
		obj.setUnitCode(unitCode);
		obj.setUnitType(unitType);
		obj.setUnitId(unitType+unitCode);		
		obj.setUnitShortName(unitShortName);
		obj.setUnitFullName(unitFullName);
		obj.setUnitZoneId(unitZoneId);
		obj.setUnitZoneName(unitZoneName);	
		obj.setLevel(getLevel().equals("")?0:Integer.parseInt(getLevel()));
		if(obj.getUnitStartIp()==null){
		}else{
			obj.setUnitStartIp(Common.formatIPv4(unitStartIp));
		}
	   if(obj.getUnitEndIp()==null){
		}else{
			obj.setUnitEndIp(Common.formatIPv4(unitEndIp));
		}
		obj.setUnitZip(unitZip);
		obj.setUnitMailingAddress(unitMailingAddress);
		obj.setUnitPhoneNum(unitPhoneNum);
		obj.setUnitMobileNum(unitMobileNum);
		obj.setUnitFaxNum(unitFaxNum);
		obj.setUnitManagerId(unitManagerId);
		obj.setUnitManagerName(unitManagerName);
		obj.setUnitEmail(unitEmail);
		obj.setUnitLanguageId(unitLanguageId);	
		obj.setUnitNote(unitNote);
		obj.setUnitStatus(unitStatus);
		obj.setUnitCountryId(unitCountryId);
		obj.setFundUnitId(fundUnitId);
	    obj.setParentId(Integer.parseInt(pid));
       // obj.setLevel(Integer.parseInt(level));
		obj.setCreateId(createId);
		obj.setCreateDate(createDate);
		obj.setCreateTime(createTime);
		obj.setUpdateId(updateId);
	    obj.setUpdateDate(updateDate);
		obj.setUpdateTime(updateTime);
		obj.setUpdateIp(updateIp);
		obj.setUpdateUnitShortName(updateUnitShortName);
		
		ServiceGetter.getInstance().getCommonService().getCommonDepartmentDao().saveCommonDepartment(obj);
		setId(obj.getId().toString());	
		
//		if (ServiceGetter.getInstance().getCommonService().getCommonDepartmentDao().getCommonDepartment(fullCode)!=null) {
//			throw new Exception("該筆資料已經重覆 : 機關全碼需為唯一值！");
//		} else {
//			CommonDepartment obj = null;			
//			if (!"".equals(getShortCode())) obj = (CommonDepartment) View.getObject("from CommonDepartment where shortCode=" + Common.sqlChar(getShortCode()));			
//			if (obj!=null) throw new Exception("該筆資料已經重覆 : 機關簡碼需為唯一值！");
//			else {
//				obj = new CommonDepartment();
//				if (!"".equals(getPid())) obj.setParentId(Integer.parseInt(getPid()));		
//				obj.setLevel(getLevel().equals("")?0:Integer.parseInt(getLevel()));
//				obj.setDepartmentCode(departmentCode);		
//				obj.setDepartment(department);
//				obj.setShortCode(shortCode);
//				obj.setShortName(shortName);
//				obj.setFullCode(fullCode);
//				obj.setPreFullCode(preFullCode);
//				obj.setFullName(fullName);
//				obj.setPhone(phone);
//				obj.setFax(fax);
//				obj.setZip(zip);
//				obj.setAddress(address);
//				obj.setEmail(email);
//				obj.setHomepage(homepage);
//				obj.setChiefName(chiefName);
//				obj.setChiefTitle(chiefTitle);
//				obj.setIsSchool(isSchool);
//				obj.setSchoolType(schoolType);
//				obj.setNotes(description);				
//				/*
//				obj.setEditId(getEditID());
//				obj.setEditDate(getEditDate());
//				obj.setEditTime(getEditTime());
//				obj.setEditIp(getEditIp());
//				*/
//				obj.setCreateId(getCreateId());
//				obj.setCreateDate(getCreateTime());
//				obj.setCreateTime(getCreateTime());
//				obj.setUpdateId(getUpdateId());
//				obj.setUpdateDate(getUpdateDate());
//				obj.setUpdateTime(getUpdateTime());
//				obj.setUpdateIp(getUpdateIp());
//				obj.setUpdateCenterShortName(getUpdateCenterShortName());
//TODO apple Su				
//				ServiceGetter.getInstance().getCommonService().getCommonDepartmentDao().saveCommonDepartment(obj);
//				setId(obj.getId().toString());				
//			}
//		}
	}
	
	@Override
	public void doUpdate() throws Exception {
		System.out.println("DO UPDATE");
		CommonDepartment obj = (CommonDepartment)View.getObject("from CommonDepartment where id = " + Common.getInteger(getId()));
		if(obj != null){
			obj.setUnitCode(unitCode);
			obj.setUnitType(unitType);
        	obj.setUnitId(unitCode+unitType);	
			obj.setUnitShortName(unitShortName);
			obj.setUnitFullName(unitFullName);
			obj.setUnitZoneId(unitZoneId);
			obj.setUnitZoneName(unitZoneName);
			if(obj.getUnitStartIp()==null){
			}else{
				obj.setUnitStartIp(Common.formatIPv4(unitStartIp));
			}
		   if(obj.getUnitEndIp()==null){
			}else{
				obj.setUnitEndIp(Common.formatIPv4(unitEndIp));
			}
			obj.setUnitZip(unitZip);
			obj.setUnitMailingAddress(unitMailingAddress);
			obj.setUnitPhoneNum(unitPhoneNum);
			obj.setUnitMobileNum(unitMobileNum);
			obj.setUnitFaxNum(unitFaxNum);
			obj.setUnitManagerId(unitManagerId);
			obj.setUnitManagerName(unitManagerName);
			obj.setUnitEmail(unitEmail);
			obj.setUnitLanguageId(unitLanguageId);	
			obj.setUnitNote(unitNote);
			obj.setUnitStatus(unitStatus);
			obj.setUnitCountryId(unitCountryId);
			obj.setFundUnitId(fundUnitId);
			obj.setParentId(Integer.parseInt(pid));
			obj.setCreateId(createId);
			obj.setCreateDate(createDate);
			obj.setCreateTime(createTime);
			obj.setUpdateId(updateId);
		    obj.setUpdateDate(updateDate);
			obj.setUpdateTime(updateTime);
			obj.setUpdateIp(updateIp);
			obj.setUpdateUnitShortName(updateUnitShortName);
		
			
			ServiceGetter.getInstance().getCommonService().getCommonDepartmentDao().updateCommonDepartment(obj);	
		}
		else{
			throw new Exception("發生未預期的錯誤,請重新操作！");
		}
		
		
//		CommonDepartment obj = ServiceGetter.getInstance().getCommonService().getCommonDepartmentDao().getCommonDepartment(Integer.parseInt(getId()));
//		if (obj!=null) {
//			obj.setFullName(department);
//			if (obj.getParentId()!=null && obj.getLevel().intValue()>0) {
//				CommonDepartment parent = ServiceGetter.getInstance().getCommonService().getCommonDepartmentDao().getCommonDepartment(obj.getParentId());
//				if (parent!=null) obj.setFullName(parent.getFullName()+"-"+department);
//				else throw new Exception("對不起系統無法判斷上層科目資料，請重新操作！");
//			} else if (obj.getLevel().intValue()==0){
//				obj.setFullName(department);			
//			} else {
//				throw new Exception("對不起系統無法判斷上層科目資料，請重新操作！");
//			}			
//			if (!"".equals(getShortCode()) && Common.getInt(View.getObject("select count(*) from CommonDepartment where shortCode=" + Common.sqlChar(getShortCode())) + " and id!=" + obj.getId())>0) {
//				throw new Exception("機關簡碼重覆 : 機關簡碼需為唯一值！");
//			}
//			
//			/**
//			obj.setAccountingYear(accountingYear);
//			obj.setId(Integer.parseInt(getId()));		
//			if (!"".equals(getPid())) obj.setParentId(Integer.parseInt(getPid()));		
//			obj.setLevel(getLevel().equals("")?0:Integer.parseInt(getLevel()));				
//			obj.setParentId(Integer.parseInt(getPid()));
//			obj.setLevel(Integer.parseInt(getLevel()));
//			obj.setDepartmentCode(departmentCode);
//			obj.setFullCode(fullCode);
//			obj.setFullName(fullName);				
//			**/
//			obj.setDepartment(department);		
//			obj.setShortCode(shortCode);
//			obj.setShortName(shortName);
//			obj.setPreFullCode(preFullCode);
//			obj.setPhone(phone);
//			obj.setFax(fax);
//			obj.setZip(zip);
//			obj.setAddress(address);
//			obj.setEmail(email);
//			obj.setHomepage(homepage);
//			obj.setChiefName(chiefName);
//			obj.setChiefTitle(chiefTitle);
//			obj.setIsSchool(isSchool);
//			obj.setSchoolType(schoolType);
//			obj.setNotes(description);
//			/*
//			obj.setEditId(getEditID());
//			obj.setEditDate(getEditDate());
//			obj.setEditTime(getEditTime());
//			obj.setEditIp(getEditIp());
//			*/
//			obj.setCreateId(getCreateId());
//			obj.setCreateDate(getCreateTime());
//			obj.setCreateTime(getCreateTime());
//			obj.setUpdateId(getUpdateId());
//			obj.setUpdateDate(getUpdateDate());
//			obj.setUpdateTime(getUpdateTime());
//			obj.setUpdateIp(getUpdateIp());
//			obj.setUpdateCenterShortName(getUpdateCenterShortName());
//TODO apple.su
//			ServiceGetter.getInstance().getCommonService().getCommonDepartmentDao().updateCommonDepartment(obj);			
//		} else throw new Exception("發生未預期的錯誤,請重新操作！");
	}	

	@Override
	public void doDelete() throws Exception {
		ServiceGetter.getInstance().getCommonService().getCommonDepartmentDao().deleteCommonDepartmentNode(Integer.parseInt(getId()));
	}

	
	@Override
	public SYSCA002F doQueryOne() throws Exception {
		CommonDepartment dept = ServiceGetter.getInstance().getCommonService().getCommonDepartmentDao().getCommonDepartment(Integer.parseInt(getId()));		
		SYSCA002F obj = this;	
		if(dept != null){
			//obj.setPid(dept.getParentId()!=null?dept.getParentId().toString():"-11");
			obj.setUnitCode(dept.getUnitCode());
			obj.setUnitType(dept.getUnitType());
			obj.setUnitId(dept.getUnitId());		
			obj.setUnitShortName(dept.getUnitShortName());
			obj.setUnitFullName(dept.getUnitFullName());
			obj.setUnitZoneId(dept.getUnitZoneId());
			obj.setUnitZoneName(dept.getUnitZoneName());
			obj.setUnitStartIp(dept.getUnitStartIp());
			obj.setUnitEndIp(dept.getUnitEndIp());
			obj.setUnitZip(dept.getUnitZip());
			obj.setUnitMailingAddress(dept.getUnitMailingAddress());
			obj.setUnitPhoneNum(dept.getUnitPhoneNum());
			obj.setUnitMobileNum(dept.getUnitMobileNum());
			obj.setUnitFaxNum(dept.getUnitFaxNum());
			obj.setUnitManagerId(dept.getUnitManagerId());
			obj.setUnitManagerName(dept.getUnitManagerName());
			obj.setUnitEmail(dept.getUnitEmail());
			obj.setUnitLanguageId(dept.getUnitLanguageId());	
			obj.setUnitNote(dept.getUnitNote());
			obj.setUnitStatus(dept.getUnitStatus());
			obj.setUnitCountryId(dept.getUnitCountryId());
			obj.setFundUnitId(dept.getFundUnitId());
			obj.setCreateId(dept.getCreateId());
			obj.setCreateDate(dept.getCreateTime());
			obj.setCreateTime(dept.getCreateTime());
			obj.setUpdateId(dept.getUpdateId());
			obj.setUpdateDate(dept.getUpdateDate());
			obj.setUpdateTime(dept.getUpdateTime());
			obj.setUpdateIp(dept.getUpdateIp());
			obj.setUpdateUnitShortName(dept.getUpdateUnitShortName());
		}
//		obj.setPid(dept.getParentId()!=null?dept.getParentId().toString():"-11");
//		obj.setLevel(dept.getLevel().toString());
//		obj.setDepartment(dept.getDepartment());		
//		obj.setShortCode(dept.getShortCode());
//		obj.setShortName(dept.getShortName());
//		obj.setDepartmentCode(dept.getDepartmentCode());
//		obj.setFullCode(dept.getFullCode());
//		obj.setPreFullCode(dept.getPreFullCode());
//		obj.setFullName(dept.getFullName());		
//		obj.setPhone(dept.getPhone());
//		obj.setFax(dept.getFax());
//		obj.setZip(dept.getZip());
//		obj.setAddress(dept.getAddress());
//		obj.setEmail(dept.getEmail());
//		obj.setHomepage(dept.getHomepage());
//		obj.setChiefName(dept.getChiefName());
//		obj.setChiefTitle(dept.getChiefTitle());
//		obj.setIsSchool(dept.getIsSchool());
//		obj.setSchoolType(dept.getSchoolType());
//		obj.setDescription(dept.getNotes());
//		/*
//		obj.setEditID(dept.getEditId());
//		obj.setEditDate(dept.getEditDate());
//		obj.setEditTime(dept.getEditTime());
//		*/
//		obj.setOldid(obj.getId()); 
//		obj.setOldParentId(obj.getPid());
//TODO apple Su
//		obj.setIpRange(dept.getIpRange());
//		obj.setCreateId(dept.getCreateId());
//		obj.setCreateDate(dept.getCreateDate());
//TODO apple su
//		obj.setUpdateId(dept.getUpdateId());
//		obj.setUpdateDate(dept.getUpdateDate());
//		obj.setUpdateIp(dept.getUpdateIp());
//		obj.setEditCenterShortName(dept.getEditCenterShortName());
		
		if (dept.getParentId()!=null) {
			CommonDepartment objLookup = ServiceGetter.getInstance().getCommonService().getCommonDepartmentDao().getCommonDepartment(dept.getParentId());
			if (objLookup!=null) {
				obj.setPname(objLookup.getDepartment());
				obj.setParentLevel(objLookup.getLevel().toString());
				obj.setParentFullCode(objLookup.getFullCode());				
				obj.setParentFullName(objLookup.getFullName());				
			} else {
				obj.setPname("單位代碼");
				obj.setParentLevel("-1");
				obj.setParentFullCode("");				
				obj.setParentFullName("");						
			}			
		} else {
			obj.setPname("單位代碼");
			obj.setParentLevel("-1");
			obj.setParentFullCode("");				
			obj.setParentFullName("");			
		}
		return obj;
	}
	
	
	public SYSCA002F getParentInfo(String pid) throws Exception {
		CommonDepartment objLookup = ServiceGetter.getInstance().getCommonService().getCommonDepartmentDao().getCommonDepartment(Integer.parseInt(pid));
		SYSCA002F obj = this;
		System.out.println(objLookup.getLevel());
		if (objLookup!=null) {
			obj.setPname(objLookup.getDepartment());
			obj.setLevel((objLookup.getLevel()+1)+"");
			obj.setParentLevel(objLookup.getLevel().toString());
			obj.setParentFullCode(objLookup.getFullCode());				
			obj.setParentFullName(objLookup.getFullName());				
		} else {
			obj.setPname("單位代碼");
			obj.setParentLevel("-1");
			obj.setParentFullCode("");				
			obj.setParentFullName("");						
		}
		return obj;
	}	
	
//	@Override
//	public Object doQueryAll() throws Exception {
//		return null;
//	}


	/**
	 * 建立功能選單維護作業的樹(可按滑鼠右鍵那一支)<br>要記得先setAccountingYear會計年度值
	 * 
	 * @return 已經組合的dTree Javascript
	 * @throws Exception
	 */
	public String buildManageTree() throws Exception {
		//id, pid, name, url, title, target, icon, iconOpen, open
		CommonDepartment[] dt = ServiceGetter.getInstance().getCommonService().getCommonDepartmentDao().getAllNode();
		if (dt!=null && dt.length>0) {
			StringBuilder sb = new StringBuilder();			
			for (int i=0; i<dt.length; i++) {
				sb.append("d.add(").append(dt[i].getId()).append(",");
								
				if (dt[i].getParentId()!=null) sb.append(dt[i].getParentId()).append(",");
				else sb.append("-97,");
				
				sb.append("'").append(dt[i].getDepartmentCode()).append(" ").append(dt[i].getDepartment()).append("',");					
				sb.append("'").append("deptForm.jsp?level=").append(dt[i].getLevel()).append("&sid=").append(dt[i].getId()).append("&fid=").append(dt[i].getParentId()==null?"-"+Integer.parseInt(getAccountingYear()):dt[i].getParentId()).append("'");
				sb.append(");\n");
			}
			return sb.toString();
		}
		return "";
	}
	
	
	/**
	 * <br>建立功能選單維護作業中有checkbox的選單
	 * <br>要記得先setAccountingYear會計年度值
	 * 
	 * @param treeName : e.g. TreeMenu
	 * @param jsFunctionName : e.g. getNode
	 * @param bUrl : e.g. false
	 * @param bRootCheckBox : e.g. true
	 * @return 已經組合好的dTree Javascript
	 */
	public String buildCheckBoxTree(String treeName, String jsFunctionName, boolean bUrl, boolean bRootCheckBox) throws Exception {
		return buildCheckBoxTree("d",treeName,getAccountingYear(),null,jsFunctionName,bUrl,bRootCheckBox);
	}	
	
	/**
	 * <br>建立功能選單維護作業中有checkbox的選單
	 * <br>要記得先setAccountingYear會計年度值
	 * 
	 * @param treeID : e.g. d
	 * @param treeName : e.g. TreeMenu
	 * @param jsFunctionName : e.g. getNode
	 * @param accountingYear : e.g. 096
	 * @param parentId : e.g. null
	 * @param bUrl : e.g. false
	 * @param bRootCheckBox : e.g. true
	 * @return 已經組合好的dTree Javascript
	 */
	public String buildCheckBoxTree(String treeID, String treeName, String accountingYear, String parentId, String jsFunctionName, boolean bUrl, boolean bRootCheckBox) throws Exception {		
		return buildCheckBoxTree("d",treeName,getAccountingYear(),parentId,jsFunctionName,bUrl,bRootCheckBox, false);
	}		
	
	public String buildCheckBoxTree(String treeID, String treeName, String accountingYear, String parentId, String jsFunctionName, boolean bUrl, boolean bRootCheckBox, boolean isSubDept) throws Exception {		
		StringBuilder sb = new StringBuilder(1024).append("");
		CommonDepartment[] dt = null;
		CommonDepartment parent = null;	
		if (parentId!=null && !"".equals(Common.get(parentId))) {
			parent = ServiceGetter.getInstance().getCommonService().getCommonDepartmentDao().getCommonDepartment(Common.getInt(parentId));
			if (parent!=null) {
				CommonDepartment[] dt1 = ServiceGetter.getInstance().getCommonService().getCommonDepartmentDao().getChildNodes(Integer.parseInt(parentId));
				if (dt1!=null && dt1.length>0) {
					dt = new CommonDepartment[dt1.length+1];
					dt[0] = parent;
					for (int i=0; i<dt1.length; i++) {
						dt[i+1] = dt1[i];						
					}
				} else {
					dt = new CommonDepartment[]{parent};			
				}
				if (parent.getParentId()!=null) {
					parentId = parent.getParentId().toString();
				} else {
					parentId = "-" + Common.getInt(accountingYear);
				}				
			}						
		} else {
			if(isSubDept){
				CommonUser user =  ServiceGetter.getInstance().getAuthenticationService().getCurrentUser();
				if (user!=null && !(Common.getInt(user.getRoleId())>1)) {
					SubjectCodeUtil codeUtil = new SubjectCodeUtil(user.getCommonDepartment().getFullCode());
					java.util.List list = ServiceGetter.getInstance().getCommonService().load("from " + CommonDepartment.class.getCanonicalName() + " where unitId like " + Common.sqlChar(codeUtil.getSqlFullCode()));
					if (list!=null && list.size()>0) {
						CommonDepartment depts[] = new CommonDepartment[list.size()];
						for (int i=0; i<list.size(); i++) {
							depts[i] = (CommonDepartment) list.get(i); 				
						}
						dt = depts;
					}					
				}

			} else {
				dt = ServiceGetter.getInstance().getCommonService().getCommonDepartmentDao().getAllNode();
			}
			parentId = "-" + Common.getInt(accountingYear);
		}
		
		if (Common.get(treeName).equals("")) treeName = "機關單位";		
		
		//建立根節點
		sb.append(treeID).append(".add(");					
		sb.append(parentId).append(",-1,'");		
		if (bRootCheckBox) {
			sb.append("<input type=checkbox id=").append(parentId).append(" name=auth class=checkbox onclick=");
			sb.append(jsFunctionName).append("(this,\"").append(treeName).append("\",\"-1\",\"\",\"\") value=").append(parentId).append(">");			
		}		
		sb.append(treeName).append("'");
		if (bUrl) sb.append(",'").append("deptForm.jsp?sid=").append(parentId).append("&fid=-1'");
		sb.append(");\n");

		//id, pid, name, url, title, target, icon, iconOpen, open
		
		if (dt!=null && dt.length>0) {			
			for (int i=0; i<dt.length; i++) {				
				sb.append(treeID).append(".add(").append(dt[i].getId()).append(",");				
				if (dt[i].getParentId()!=null) sb.append(dt[i].getParentId()).append(",");
				else sb.append(parentId).append(",");
				
				//String js = jsFunctionName+"(this,\""+StringEscapeUtils.escapeJavaScript(dt[i].getDepartment()) + "\",\"" + dt[i].getLevel() + "\",\"" + dt[i].getFullCode() + "\",\"" + StringEscapeUtils.escapeJavaScript(dt[i].getFullName()) + "\") ";
				
				StringBuilder js = new StringBuilder(50);
//				js.append(jsFunctionName).append("(this,\"").append(StringEscapeUtils.escapeJavaScript(dt[i].getDepartment()) ).append( "\",\"" ).append( dt[i].getLevel() ).append( "\",\"" ).append( Common.get(dt[i].getFullCode()) ).append( "\",\"" ).append( StringEscapeUtils.escapeJavaScript(dt[i].getFullName()) ).append( "\") ");
				js.append(jsFunctionName).append("(this,\"").append(StringEscapeUtils.escapeJavaScript(dt[i].getDepartment()) ).append( "\",\"" ).append( "\",\"" ).append( Common.get(dt[i].getFullCode()) ).append( "\",\"" ).append( StringEscapeUtils.escapeJavaScript(dt[i].getFullName()) ).append( "\") ");
				
				sb.append("'<input type=checkbox id=").append(dt[i].getId()).append(" name=auth class=checkbox onclick=").append(js).append(" value=").append(dt[i].getId()).append(">").append(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(dt[i].getDepartment())).append("'");
				if (bUrl) sb.append(",'").append("deptForm.jsp?sid=").append(dt[i].getId()).append("&fid=").append(dt[i].getParentId()).append("'");
				
				sb.append(");\n");
			}			
		}				
		return sb.toString();
	}
	
	public java.util.ArrayList<String[]> doQueryAll() throws Exception 	{
		java.util.ArrayList<String[]> arrList = new java.util.ArrayList<String[]>();	
		String hql = "from CommonDepartment where 1=1 ";
		if(!"".equals(getQ_shortCode())) {
			hql += " and shortCode = " +Common.sqlChar(getQ_shortCode());
		}
//		if(!"".equals(getQ_shortName())) {
//			hql += " and shortCode = " +Common.sqlChar(getQ_shortName());
//		}
		java.util.List objList = ServiceGetter.getInstance().getCommonService().load(hql);
		if(null != objList && !objList.isEmpty()) {
			java.util.Iterator it = objList.iterator();
			while (it.hasNext()) {
				CommonDepartment commonDepartment = (CommonDepartment)it.next();
				String rowArray[] = new String[2];
				rowArray[0] = Common.get(commonDepartment.getShortCode());
				rowArray[1] = Common.get(commonDepartment.getShortName());
				arrList.add(rowArray);	
			}
		}
		return arrList;
	}
}
