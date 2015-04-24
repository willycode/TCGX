package com.kangdainfo.ctis.view.cor.ap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.kangdainfo.ServiceGetter;
import com.kangdainfo.common.util.Common;
import com.kangdainfo.common.util.Datetime;
import com.kangdainfo.common.util.SuperBean;
import com.kangdainfo.common.util.View;
import com.kangdainfo.ctis.model.bo.CtMemberInfo;

public class CORAP006F extends SuperBean {
    private String id;

    /** page 1 show fields **/
    private String ctMemberId; //精舍學員本山ID
//  private String fullName; // 學員的姓名
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
//  private String twIdNumDisplay; //
    private String otherIdNum; // 護照、駕照 … etc 號碼 (外國用)
    private String birthDate; // 身分證生日
    private String birthMMDD; // 身分證生日的 月日format
    private String birthCalendar; //曆法
    private String birthDisplay; //日期顯示方式
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
    private String onBlackList; // 是否特別留意
    private String onNostayList; // 是否不予留單
    private String thisPersonStatus; // 此學員狀態

    /** page 2 show fields **/
    private String nationality; // 國家
    private String ethnicGroup; // 民族/種族/族群 (外國用)
    private String familyProvince; // 籍貫(省)
    private String familyCity; // 籍貫(縣市)
    private String birthProvinceCountry; // 出生地(省)
    private String birthCity; // 出生地(縣市)
    private String email1; // email帳號1
    private String email2; // email帳號2
    private String marriageStatus; // 身分證婚姻狀況
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
    private String okSendEmail; // 是否寄email
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
    private String okSendMagazine; // 是否寄發中台月刊
    private String okSendEletter; // 是否寄發通啟
    private String okSendMessage; // 是否傳簡訊
    private String okToCallType; // 可電話聯絡的時段
    private String zen7Count; // 打七次數
    private String zen7VlntrCount; // 護七次數
    private String summerVlntrConut; // 護夏次數
    private String takeRefuge; // 是否受三皈
    private String refugeDate; // 受三皈日期
    private String refugePlace; // 受三皈地點
    private String takePrecept5; // 是否受五戒
    private String precept5Date; // 受五戒日期
    private String precept5Place; // 受五戒地點
    private String takeBodhiPrecept; // 是否受菩薩戒
    private String bodhiPreceptDate; // 受菩薩戒日期
    private String bodhiPreceptPlace; // 受菩薩戒地點

    /** page 3 show fields **/
    private String carNum1; // 車號1
    private String carNum2; // 車號2
    private String height; // 身高(cm)
    private String weight; // 體重(kg)
    private String after2012Oct; // 是否2012/10/1 後才到
    private String isPiSigned; // 是否簽個資同意書
    private String piDocId; // 本山個資同意書編號
    private String piAggrementPicFileName; // 個資同意書1scan
    private String piParentAggrementPicFileName; // 個資同意書2 scan (家長同意書)
    private String twIdPicFrontFileName; // 照片，身分證正面照
    private String twIdPicBackFileName; // 照片，身分證反面照
    private String[] skills;
    private String otherSkill;
    private String otherSkillName;
    private String[] healths;
    private String otherHealth;
    private String otherHealthName;

    /** 額外功能用 **/
    private String mcRadio;
    private String pcRadio;

    /** 查詢用 **/
    private String q_unitId;
    private String q_centerMemberId;
    private String q_fullName;
    private String q_ctDharmaName;
    private String q_email1;
    private String q_aliasName;
    private String q_twIdNum;
    private String q_birthDisplay;
    private String q_mobileNum1;
    private String q_homePhoneNum1;
    @Override
    public ArrayList doQueryAll() throws Exception {
        java.util.ArrayList<String[]> arrList = new java.util.ArrayList<String[]>();
        java.util.Map<String, Object> maps = new java.util.HashMap<String, Object>();

        StringBuffer hql = new StringBuffer();
        hql.append("from CtMemberInfo where 1=1");
        if(!"".equals(getQ_fullName())){
            hql.append(" and fullName like :fullName");
            maps.put("fullName", "%" + q_fullName + "%");
        }
        if(!"".equals(getQ_twIdNum())){
        	hql.append(" and twIdNum = :twIdNum");
            maps.put("twIdNum", Common.getEncodeString(q_twIdNum));
        }
        if(!"".equals(getQ_birthDisplay())){
        	hql.append(" and birthDisplay = :birthDisplay");
            maps.put("birthDisplay", q_birthDisplay);
        }
        if(!"".equals(getQ_mobileNum1())){
        	hql.append(" and mobileNum1 = :mobileNum1");
            maps.put("mobileNum1", q_mobileNum1);
        }
        if(!"".equals(getQ_homePhoneNum1())){
        	hql.append(" and homePhoneNum1 = :homePhoneNum1");
            maps.put("homePhoneNum1", q_homePhoneNum1);
        }
        if(!"".equals(getQ_email1())){
        	hql.append(" and email1 = :email1");
            maps.put("email1", q_email1);
        }
        System.out.println("CORAP006F 查詢語法 == " + hql.toString());
        System.out.println("maps = " + maps);
        this.processCurrentPageAttribute(ServiceGetter.getInstance().getCommonService().loadCount(hql.toString(), maps));
        if(getTotalRecord() > 0){
            if(getState().indexOf("query") < 0){
                ServiceGetter.getInstance().getCommonService().clear();
            }

            java.util.List objList = ServiceGetter.getInstance().getCommonService().load(hql.toString(), this.getRecordStart(), this.getPageSize(), maps);
            if(objList != null && objList.size() > 0){
                for(Object obj : objList){
                    CtMemberInfo o = (CtMemberInfo)obj;
                    String[] rowArray = new String[9];
                    rowArray[0] = Common.get(o.getId());
                    rowArray[1] = Common.get(o.getFullName());
                    rowArray[2] = Common.get(Common.getIdnumEcode(Common.getDecodeString(o.getTwIdNum())));
                    rowArray[3] = Common.get(o.getBirthDisplay());
                    rowArray[4] = Common.get(o.getCtDharmaName());
                    rowArray[5] = Common.get(o.getEmail1());
                    rowArray[6] = Common.get(o.getMobileNum1());
                    rowArray[7] = Common.get(o.getHomePhoneNum1());
                    rowArray[8] = Common.get(o.getOfficePhoneNum1());
                    arrList.add(rowArray);
                }
            }
        }
        return arrList;
    }

    @Override
    public Object doQueryOne() throws Exception {
        CORAP006F obj = this;
        CtMemberInfo c = (CtMemberInfo)View.getObject("from CtMemberInfo where id = " + Common.getInt(getId()));
        if(c != null){
        	/** page 1 **/
        	obj.setCtMemberId(Common.get(c.getCtMemberId()));
            obj.setFirstName(Common.get(c.getFirstName()));
            obj.setLastName(Common.get(c.getLastName()));
            obj.setAliasName(Common.get(c.getAliasName()));
            obj.setCtDharmaName(Common.get(c.getCtDharmaName()));
            obj.setCtRefugeMaster(Common.get(c.getCtRefugeMaster()));
            obj.setOtherDharmaName(Common.get(c.getOtherDharmaName()));
            obj.setOtherRefugeMaster(Common.get(c.getOtherRefugeMaster()));
            obj.setPinyinFirstName(Common.get(c.getPinyinFirstName()));
            obj.setPinyinLastName(Common.get(c.getPinyinLastName()));
            obj.setPinyinOtherDharmaName(Common.get(c.getPinyinOtherDharmaName()));
            obj.setOtherFirstName(Common.get(c.getOtherFirstName()));
            obj.setOtherLastName(Common.get(c.getOtherLastName()));
            obj.setGender(Common.get(c.getGender()));
            obj.setTwIdNum(Common.get(Common.getDecodeString(c.getTwIdNum())));
            obj.setBirthDate(Common.get(c.getBirthDate()));
            obj.setBirthMMDD(Common.get(c.getBirthMMDD()));
            obj.setBirthCalendar(Common.get(c.getBirthCalendar()));
            obj.setBirthDisplay(Common.get(c.getBirthDisplay()));
            obj.setPasscode(Common.get(c.getPasscode()));
            obj.setMobileNum1(Common.get(c.getMobileNum1()));
            obj.setMobileNum2(Common.get(c.getMobileNum2()));
            obj.setMobileNum3(Common.get(c.getMobileNum3()));
            obj.setHomePhoneNum1(Common.get(c.getHomePhoneNum1()));
            obj.setHomePhoneNum2(Common.get(c.getHomePhoneNum2()));
            obj.setUrgentContactPersonName1(Common.get(c.getUrgentContactPersonName1()));
            obj.setUrgentContactPersonPhoneNum1(Common.get(c.getUrgentContactPersonPhoneNum1()));
            obj.setUrgentContactPersonRelationship1(Common.get(c.getUrgentContactPersonRelationship1()));
            obj.setUrgentContactPersonName2(Common.get(c.getUrgentContactPersonName2()));
            obj.setUrgentContactPersonPhoneNum2(Common.get(c.getUrgentContactPersonPhoneNum2()));
            obj.setUrgentContactPersonRelationship2(Common.get(c.getUrgentContactPersonRelationship2()));
            obj.setDonationType(Common.get(c.getDonationType()));
            obj.setClassList(Common.get(c.getClassList()));
            obj.setPersonalPhotoFileName(Common.get(c.getPersonalPhotoFileName()));
            obj.setOnBlackList(String.valueOf(c.getOnBlackList()));
            obj.setOnNostayList(String.valueOf(c.getOnNostayList()));
            obj.setThisPersonStatus(Common.get(c.getThisPersonStatus()));

            /** page 2 **/
            obj.setNationality(Common.get(c.getNationality()));
            obj.setEthnicGroup(Common.get(c.getEthnicGroup()));
            obj.setFamilyCity(Common.get(c.getFamilyCity()));
            obj.setFamilyProvince(Common.get(c.getFamilyProvince()));
            obj.setBirthProvinceCountry(Common.get(c.getBirthProvinceCountry()));
            obj.setBirthCity(Common.get(c.getBirthCity()));
            obj.setEmail1(Common.get(c.getEmail1()));
            obj.setEmail2(Common.get(c.getEmail2()));
            obj.setMarriageStatus(String.valueOf(c.getMarriageStatus()));
            obj.setTwIdAddress(Common.get(c.getTwIdAddress()));
            obj.setMailingAddress(Common.get(c.getMailingAddress()));
            obj.setMailingCity(Common.get(c.getMailingCity()));
            obj.setMailingState(Common.get(c.getMailingState()));
            obj.setMailingZip(Common.get(c.getMailingZip()));
            obj.setMailingCountry(Common.get(c.getMailingCountry()));
            obj.setPermanentAddress(Common.get(c.getPermanentAddress()));
            obj.setPermanentCity(Common.get(c.getPermanentCity()));
            obj.setPermanentState(Common.get(c.getPermanentState()));
            obj.setPermanentZip(Common.get(c.getPermanentZip()));
            obj.setPermanentCountry(Common.get(c.getPermanentCountry()));
            obj.setOkSendEmail(String.valueOf(c.getOkSendEmail()));
            obj.setSchoolName(Common.get(c.getSchoolName()));
            obj.setSchoolMajor(Common.get(c.getSchoolMajor()));
            obj.setSchoolDegree(Common.get(c.getSchoolDegree()));
            obj.setCompanyName(Common.get(c.getCompanyName()));
            obj.setCompanyAddress(Common.get(c.getCompanyAddress()));
            obj.setCompanyJobTitle(Common.get(c.getCompanyJobTitle()));
            obj.setOfficePhoneNum1(Common.get(c.getOfficePhoneNum1()));
            obj.setOfficePhoneNum2(Common.get(c.getOfficePhoneNum2()));
            obj.setReferenceId(Common.get(c.getReferenceId()));
            obj.setIntroducerName(Common.get(c.getIntroducerName()));
            obj.setIntroducerRelationship(Common.get(c.getIntroducerRelationship()));
            obj.setIntroducerPhoneNum(Common.get(c.getIntroducerPhoneNum()));
            obj.setOkSendMagazine(String.valueOf(c.getOkSendMagazine()));
            obj.setOkSendEletter(String.valueOf(c.getOkSendEletter()));
            obj.setOkSendMessage(String.valueOf(c.getOkSendMessage()));
            obj.setOkToCallType(Common.get(c.getOkToCallType()));
            obj.setTakeRefuge(String.valueOf(c.getTakeRefuge()));
            obj.setRefugeDate(Common.get(c.getRefugeDate()));
            obj.setRefugePlace(Common.get(c.getRefugePlace()));
            obj.setTakePrecept5(String.valueOf(c.getTakePrecept5()));
            obj.setPrecept5Date(Common.get(c.getPrecept5Date()));
            obj.setPrecept5Place(Common.get(c.getPrecept5Place()));
            obj.setTakeBodhiPrecept(String.valueOf(c.getTakeBodhiPrecept()));
            obj.setBodhiPreceptDate(Common.get(c.getBodhiPreceptDate()));
            obj.setBodhiPreceptPlace(Common.get(c.getBodhiPreceptPlace()));

            /** page 3 **/
            obj.setCarNum1(Common.get(c.getCarNum1()));
            obj.setCarNum2(Common.get(c.getCarNum2()));
            obj.setHeight(String.valueOf(c.getHeight() != null ? c.getHeight() : ""));
            obj.setWeight(String.valueOf(c.getWeight() != null ? c.getWeight() : ""));
            obj.setAfter2012Oct(String.valueOf(c.getAfter2012Oct()));
            obj.setIsPiSigned(String.valueOf(c.getIsPiSigned()));
            obj.setPiDocId(Common.get(c.getPiDocId()));
            obj.setPiAggrementPicFileName(Common.get(c.getPiAggrementPicFileName()));
            obj.setPiParentAggrementPicFileName(Common.get(c.getPiParentAggrementPicFileName()));
            obj.setTwIdPicBackFileName(Common.get(c.getTwIdPicBackFileName()));
            obj.setTwIdPicFrontFileName(Common.get(c.getTwIdPicFrontFileName()));
            
            /** 查詢學員專長 **/
            //TODO jason.kuo
            
            
            /** 查詢學員健康狀況 **/
            //TODO jason.kuo
        }
        return obj;
    }

    public String[][] getInsertCheckSQL(){
		String[][] checkSQLArray = new String[1][4];
		checkSQLArray[0][0] = "select count(*) from CtMemberInfo where ctMemberId = " + Common.sqlChar(getCtMemberId());
		checkSQLArray[0][1] = ">";
		checkSQLArray[0][2] = "0";
		checkSQLArray[0][3] = "已有相同資料存在，請重新輸入!";
		return checkSQLArray;
	}
    
    @Override
    public void doCreate() throws Exception {
        CtMemberInfo obj = new CtMemberInfo();
        /** page 1 **/
        if(!"".equals(getCtMemberId())){
        	obj.setCtMemberId(ctMemberId);
        }
        else{
        	//流水號
        	String runningNum = String.format("%06d", Integer.parseInt(View.getLookupField("select max(id) as max_num from CtMemberInfo")));
        	String strCtMemberId = Datetime.getYYY() + runningNum;
        	obj.setCtMemberId(strCtMemberId);
        }
        
        obj.setFirstName(firstName);
        obj.setLastName(lastName);

        String strFullName = "";
        if(isChinese(firstName) && isChinese(lastName)){
            strFullName = lastName + firstName;
        }
        else{
            strFullName = firstName + " " + lastName;
        }
        obj.setFullName(strFullName);
        
        if(!"".equals(getAliasName())){
        	obj.setAliasName(aliasName);
        }
        else{
        	obj.setAliasName(strFullName);        	
        }
        
        obj.setCtDharmaName(ctDharmaName);
        obj.setCtRefugeMaster(ctRefugeMaster);
        obj.setOtherDharmaName(otherDharmaName);
        obj.setOtherRefugeMaster(otherRefugeMaster);
        obj.setPinyinFirstName(pinyinFirstName);
        obj.setPinyinLastName(pinyinLastName);
        obj.setPinyinOtherDharmaName(pinyinOtherDharmaName);
        obj.setOtherFirstName(otherFirstName);
        obj.setOtherLastName(otherLastName);
        obj.setGender(gender);
        obj.setTwIdNum(Common.getEncodeString(twIdNum));
        obj.setBirthDate(birthDate);
        obj.setBirthMMDD(birthMMDD);
        obj.setBirthCalendar(birthCalendar);
        obj.setBirthDisplay(birthDisplay);                
        obj.setPasscode(passcode);
        obj.setMobileNum1(mobileNum1);
        obj.setMobileNum2(mobileNum2);
        obj.setMobileNum3(mobileNum3);
        obj.setHomePhoneNum1(homePhoneNum1);
        obj.setHomePhoneNum2(homePhoneNum2);
        obj.setUrgentContactPersonName1(urgentContactPersonName1);
        obj.setUrgentContactPersonPhoneNum1(urgentContactPersonPhoneNum1);
        obj.setUrgentContactPersonRelationship1(urgentContactPersonRelationship1);
        obj.setUrgentContactPersonName2(urgentContactPersonName2);
        obj.setUrgentContactPersonPhoneNum2(urgentContactPersonPhoneNum2);
        obj.setUrgentContactPersonRelationship2(urgentContactPersonRelationship2);
        obj.setDonationType(donationType);
        obj.setClassList(classList);
        obj.setPersonalPhotoFileName(personalPhotoFileName);
        if(!"".equals(onBlackList)){obj.setOnBlackList(Boolean.valueOf(onBlackList));}
        obj.setOnNostayList(Boolean.valueOf(onNostayList));
        obj.setThisPersonStatus(thisPersonStatus);
        obj.setCreateId(createId);
		obj.setCreateDate(createDate);
		obj.setCreateTime(createTime);
		obj.setUpdateId(updateId);
	    obj.setUpdateDate(updateDate);
		obj.setUpdateTime(updateTime);
		obj.setUpdateIp(updateIp);
		obj.setUpdateUnitShortName(updateUnitShortName);

        /** page 2 **/
        obj.setNationality(nationality);
        obj.setEthnicGroup(ethnicGroup);
        obj.setFamilyCity(familyCity);
        obj.setFamilyProvince(familyProvince);
        obj.setBirthProvinceCountry(birthProvinceCountry);
        obj.setBirthCity(birthCity);
        obj.setEmail1(email1);
        obj.setEmail2(email2);
        obj.setMarriageStatus(Boolean.valueOf(marriageStatus));
        obj.setTwIdAddress(twIdAddress);
        obj.setMailingAddress(mailingAddress);
        obj.setMailingCity(mailingCity);
        obj.setMailingState(mailingState);
        obj.setMailingZip(mailingZip);
        obj.setMailingCountry(mailingCountry);
        obj.setPermanentAddress(permanentAddress);
        obj.setPermanentCity(permanentCity);
        obj.setPermanentState(permanentState);
        obj.setPermanentZip(permanentZip);
        obj.setPermanentCountry(permanentCountry);
        obj.setOkSendEmail(Boolean.valueOf(okSendEmail));
        obj.setSchoolName(schoolName);
        obj.setSchoolMajor(schoolMajor);
        obj.setSchoolDegree(schoolDegree);
        obj.setCompanyName(companyName);
        obj.setCompanyAddress(companyAddress);
        obj.setCompanyJobTitle(companyJobTitle);
        obj.setOfficePhoneNum1(officePhoneNum1);
        obj.setOfficePhoneNum2(officePhoneNum2);
        obj.setReferenceId(referenceId);
        obj.setIntroducerName(introducerName);
        obj.setIntroducerRelationship(introducerRelationship);
        obj.setIntroducerPhoneNum(introducerPhoneNum);
        obj.setOkSendMagazine(Boolean.valueOf(okSendMagazine));
        obj.setOkSendEletter(Boolean.valueOf(okSendEletter));
        obj.setOkSendMessage(Boolean.valueOf(okSendMessage));
        obj.setOkToCallType(okToCallType);
        obj.setTakeRefuge(Boolean.valueOf(takeRefuge));
        obj.setRefugeDate(refugeDate);
        obj.setRefugePlace(refugePlace);
        obj.setTakePrecept5(Boolean.valueOf(takePrecept5));
        obj.setPrecept5Date(precept5Date);
        obj.setPrecept5Place(precept5Place);
        obj.setTakeBodhiPrecept(Boolean.valueOf(takeBodhiPrecept));
        obj.setBodhiPreceptDate(bodhiPreceptDate);
        obj.setBodhiPreceptPlace(bodhiPreceptPlace);

        /** page 3 **/
        obj.setCarNum1(carNum1);
        obj.setCarNum2(carNum2);

        if(!"".equals(getHeight())){ obj.setHeight(Double.valueOf(height));}
        if(!"".equals(getWeight())){ obj.setWeight(Double.valueOf(weight));}

        obj.setAfter2012Oct(Boolean.valueOf(after2012Oct));
        obj.setIsPiSigned(Boolean.valueOf(isPiSigned));
        obj.setPiDocId(piDocId);
        obj.setPiAggrementPicFileName(piAggrementPicFileName);
        obj.setPiParentAggrementPicFileName(piParentAggrementPicFileName);
        obj.setTwIdPicBackFileName(twIdPicBackFileName);
        obj.setTwIdPicFrontFileName(twIdPicFrontFileName);

        ServiceGetter.getInstance().getCommonService().save(obj);
        setId(Common.get(obj.getId()));
        
        
        /** 新增學員專長 **/
        //TODO jason.kuo
        
        
        /** 新增學員健康狀況 **/
        //TODO jason.kuo
    }

    public String[][] getUpdateCheckSQL(){
		String[][] checkSQLArray = new String[1][4];
		checkSQLArray[0][0] = "select count(*) from CtMemberInfo where id != " + Common.getInt(getId())
									+ "ctMemberId = " + Common.sqlChar(getCtMemberId());
		checkSQLArray[0][1] = ">";
		checkSQLArray[0][2] = "0";
		checkSQLArray[0][3] = "已有相同資料存在，請重新輸入!";
		return checkSQLArray;
	}
    
    @Override
    public void doUpdate() throws Exception {
        CtMemberInfo obj = (CtMemberInfo)View.getObject("from CtMemberInfo where id = " + Common.getInt(getId()));
        if(obj != null){
        	if(!"".equals(getCtMemberId())){
            	obj.setCtMemberId(ctMemberId);
            }
            else{
            	//流水號
            	String runningNum = String.format("%06d", Integer.parseInt(View.getLookupField("select max(id) as max_num from CtMemberInfo")));
            	String strCtMemberId = Datetime.getYYY() + runningNum;
            	obj.setCtMemberId(strCtMemberId);
            }
            obj.setFirstName(firstName);
            obj.setLastName(lastName);

            String strFullName = "";
            if(isChinese(firstName) && isChinese(lastName)){
                strFullName = lastName + firstName;
            }
            else{
                strFullName = firstName + " " + lastName;
            }
            obj.setFullName(strFullName);
            
            if(!"".equals(getAliasName())){
            	obj.setAliasName(aliasName);
            }
            else{
            	obj.setAliasName(strFullName);        	
            }
            
            obj.setCtDharmaName(ctDharmaName);
            obj.setCtRefugeMaster(ctRefugeMaster);
            obj.setOtherDharmaName(otherDharmaName);
            obj.setOtherRefugeMaster(otherRefugeMaster);
            obj.setPinyinFirstName(pinyinFirstName);
            obj.setPinyinLastName(pinyinLastName);
            obj.setPinyinOtherDharmaName(pinyinOtherDharmaName);
            obj.setOtherFirstName(otherFirstName);
            obj.setOtherLastName(otherLastName);
            obj.setGender(gender);
            obj.setTwIdNum(Common.getEncodeString(twIdNum));
            obj.setBirthDate(birthDate);
            obj.setBirthMMDD(birthMMDD);
            obj.setBirthCalendar(birthCalendar);
            obj.setBirthDisplay(birthDisplay);
            obj.setPasscode(passcode);
            obj.setMobileNum1(mobileNum1);
            obj.setMobileNum2(mobileNum2);
            obj.setMobileNum3(mobileNum3);
            obj.setHomePhoneNum1(homePhoneNum1);
            obj.setHomePhoneNum2(homePhoneNum2);
            obj.setUrgentContactPersonName1(urgentContactPersonName1);
            obj.setUrgentContactPersonPhoneNum1(urgentContactPersonPhoneNum1);
            obj.setUrgentContactPersonRelationship1(urgentContactPersonRelationship1);
            obj.setUrgentContactPersonName2(urgentContactPersonName2);
            obj.setUrgentContactPersonPhoneNum2(urgentContactPersonPhoneNum2);
            obj.setUrgentContactPersonRelationship2(urgentContactPersonRelationship2);
            obj.setDonationType(donationType);
            obj.setClassList(classList);
            obj.setPersonalPhotoFileName(personalPhotoFileName);
            obj.setOnBlackList(Boolean.valueOf(onBlackList));
            obj.setOnNostayList(Boolean.valueOf(onNostayList));
            obj.setThisPersonStatus(thisPersonStatus);
            obj.setUpdateId(updateId);
    	    obj.setUpdateDate(updateDate);
    		obj.setUpdateTime(updateTime);
    		obj.setUpdateIp(updateIp);
    		obj.setUpdateUnitShortName(updateUnitShortName);
    		
            /** page 2 **/
            obj.setNationality(nationality);
            obj.setEthnicGroup(ethnicGroup);
            obj.setFamilyCity(familyCity);
            obj.setFamilyProvince(familyProvince);
            obj.setBirthProvinceCountry(birthProvinceCountry);
            obj.setBirthCity(birthCity);
            obj.setEmail1(email1);
            obj.setEmail2(email2);
            obj.setMarriageStatus(Boolean.valueOf(marriageStatus));
            obj.setTwIdAddress(twIdAddress);
            obj.setMailingAddress(mailingAddress);
            obj.setMailingCity(mailingCity);
            obj.setMailingState(mailingState);
            obj.setMailingZip(mailingZip);
            obj.setMailingCountry(mailingCountry);
            obj.setPermanentAddress(permanentAddress);
            obj.setPermanentCity(permanentCity);
            obj.setPermanentState(permanentState);
            obj.setPermanentZip(permanentZip);
            obj.setPermanentCountry(permanentCountry);
            obj.setOkSendEmail(Boolean.valueOf(okSendEmail));
            obj.setSchoolName(schoolName);
            obj.setSchoolMajor(schoolMajor);
            obj.setSchoolDegree(schoolDegree);
            obj.setCompanyName(companyName);
            obj.setCompanyAddress(companyAddress);
            obj.setCompanyJobTitle(companyJobTitle);
            obj.setOfficePhoneNum1(officePhoneNum1);
            obj.setOfficePhoneNum2(officePhoneNum2);
            obj.setReferenceId(referenceId);
            obj.setIntroducerName(introducerName);
            obj.setIntroducerRelationship(introducerRelationship);
            obj.setIntroducerPhoneNum(introducerPhoneNum);
            obj.setOkSendMagazine(Boolean.valueOf(okSendMagazine));
            obj.setOkSendEletter(Boolean.valueOf(okSendEletter));
            obj.setOkSendMessage(Boolean.valueOf(okSendMessage));
            obj.setOkToCallType(okToCallType);
            obj.setTakeRefuge(Boolean.valueOf(takeRefuge));
            obj.setRefugeDate(refugeDate);
            obj.setRefugePlace(refugePlace);
            obj.setTakePrecept5(Boolean.valueOf(takePrecept5));
            obj.setPrecept5Date(precept5Date);
            obj.setPrecept5Place(precept5Place);
            obj.setTakeBodhiPrecept(Boolean.valueOf(takeBodhiPrecept));
            obj.setBodhiPreceptDate(bodhiPreceptDate);
            obj.setBodhiPreceptPlace(bodhiPreceptPlace);

            /** page 3 **/
            obj.setCarNum1(carNum1);
            obj.setCarNum2(carNum2);
            
            if(!"".equals(getHeight())){ obj.setHeight(Double.valueOf(height));}
            if(!"".equals(getWeight())){ obj.setWeight(Double.valueOf(weight));}
            
            obj.setAfter2012Oct(Boolean.valueOf(after2012Oct));
            obj.setIsPiSigned(Boolean.valueOf(isPiSigned));
            obj.setPiDocId(piDocId);
            obj.setPiAggrementPicFileName(piAggrementPicFileName);
            obj.setPiParentAggrementPicFileName(piParentAggrementPicFileName);
            obj.setTwIdPicBackFileName(twIdPicBackFileName);
            obj.setTwIdPicFrontFileName(twIdPicFrontFileName);

            ServiceGetter.getInstance().getCommonService().update(obj);
            setId(Common.get(obj.getId()));
            
            /** 修改學員專長 **/
            //TODO jason.kuo
            
            
            /** 修改學員健康狀況 **/
            //TODO jason.kuo
        }
    }

    @Override
    public void doDelete() throws Exception {
        CtMemberInfo obj = (CtMemberInfo)View.getObject("from CtMemberInfo where id = " + Common.getInt(getId()));
        if(obj != null){
            ServiceGetter.getInstance().getCommonService().delete(obj);
        }
        
        /** 刪除學員專長 **/
        //TODO jason.kuo
        
        
        /** 刪除學員健康狀況 **/
        //TODO jason.kuo
    }

    public java.util.ArrayList<String[]> doQueryAll_sysap001_2f() throws Exception {

        java.util.ArrayList<String[]> arrList = new java.util.ArrayList<String[]>();
        Map<String, Object> maps = new HashMap<String, Object>();

        StringBuffer sb = new StringBuffer();
        //TODO 其他查詢欄位也要加  jason.kuo
        sb.append("select a.unitId,a.unitShortName,a.centerMemberId,b.fullName,b.ctDharmaName,b.email1,b.birthDate,b.birthMMDD");
        sb.append(" from CenterMemberInfo a ,CtMemberInfo b where 1=1");
        sb.append(" and a.ctMemberId = b.ctMemberId");
        if (!"".equals(getQ_unitId()))
        {
            sb.append(" and a.unitId = :unitId ");
            maps.put("unitId", q_unitId);
        }

        if (!"".equals(getQ_centerMemberId()))
        {
            sb.append(" and a.centerMemberId = :centerMemberId ");
            maps.put("centerMemberId", q_centerMemberId);
        }

        if (!"".equals(getQ_fullName()))
        {
            sb.append(" and b.fullName like :fullName ");
            maps.put("b.fullName", "%" + q_fullName + "%");
        }

        if (!"".equals(getQ_ctDharmaName()))
        {
            sb.append(" and b.ctDharmaName like :ctDharmaName ");
            maps.put("ctDharmaName", "%" + q_ctDharmaName + "%");
        }

        if (!"".equals(getQ_email1()))
        {
            sb.append(" and b.email1 like :email1 ");
            maps.put("email1", q_email1 + "%");
        }

        System.out.println("sysap001_2f 查詢 == " + sb.toString());
        java.util.List objList = ServiceGetter.getInstance().getCommonService().load(sb.toString(), maps);
        this.processCurrentPageAttribute(objList != null ? objList.size() : 0);
        if (getTotalRecord() > 0) {
            if (getState().indexOf("query")<0)
                ServiceGetter.getInstance().getCommonService().clear();
            objList = ServiceGetter.getInstance().getCommonService().load(sb.toString(), this.getRecordStart(), this.getPageSize(), maps);
            if (objList!=null && objList.size()>0) {
                for (Object obj : objList) {
                    Object[] o = (Object[])obj;
                    String rowArray[] = new String[o.length];
                    rowArray[0] = Common.get(o[0]); //unitId
                    rowArray[1] = Common.get(o[1]); //unitShortName
                    rowArray[2] = Common.get(o[2]); //centerMemberId
                    rowArray[3] = Common.get(o[3]); //fullName
                    rowArray[4] = Common.get(o[4]); //ctDharmaName
                    rowArray[5] = Common.get(o[5]); //email1
                    rowArray[6] = Common.get(o[6]); //birthDate
                    rowArray[7] = Common.get(o[7]); //birthMMDD
                    //TODO 其他欄位也要加  jason.kuo
                    arrList.add(rowArray);
                }
            }
        }
        return arrList;
    }

    public java.util.ArrayList<String[]> doQueryAll_corap101_1f(String unitId) throws Exception {
        java.util.ArrayList<String[]> arrList = new java.util.ArrayList<String[]>();
        Map<String, Object> maps = new HashMap<String, Object>();
        StringBuffer sb = new StringBuffer();
        sb.append("Select id, centerMemberId, aliasName");
        sb.append(" From CenterMemberInfo Where 1=1");
        if (!"".equals(unitId)) {
            sb.append(" and unitId = :unitId");
            maps.put("unitId", unitId);
        }
        if (!"".equals(getQ_centerMemberId())) {
            sb.append(" and centerMemberId = :centerMemberId");
            maps.put("centerMemberId", q_centerMemberId);
        }
        if (!"".equals(getQ_aliasName())) {
            sb.append(" and aliasName like :aliasName");
            maps.put("aliasName", "%" + q_aliasName + "%");
        }
        sb.append(" Order by centerMemberId");
        System.out.println("corap101_1f 查詢 == " + sb.toString());
        java.util.List objList = ServiceGetter.getInstance().getCommonService().load(sb.toString(), maps);
        this.processCurrentPageAttribute(objList != null ? objList.size() : 0);
        if (getTotalRecord() > 0) {
            if (getState().indexOf("query") < 0)
                ServiceGetter.getInstance().getCommonService().clear();
            objList = ServiceGetter.getInstance().getCommonService().load(sb.toString(), this.getRecordStart(), this.getPageSize(), maps);
            if (objList != null && objList.size() > 0) {
                for (Object obj : objList) {
                    Object[] o = (Object[])obj;
                    String rowArray[] = new String[o.length];
                    rowArray[0] = Common.get(o[0]); // id
                    rowArray[1] = Common.get(o[1]); // centerMemberId
                    rowArray[2] = Common.get(o[2]); // aliasName
                    arrList.add(rowArray);
                }
            }
        }
        return arrList;
    }

    private static boolean chkChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if(ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
            || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS)
        {
                return true;
        }
        return false;
    }

    private static boolean isChinese(String strName) {
        char[] ch = strName.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (chkChinese(c)) {
                return true;
            }
        }
        return false;
    }

    public String getId() {
        return checkGet(id);
    }

    public void setId(String id) {
        this.id = checkSet(id);
    }

    /** page 1 fields setter getter **/
    
    public String getCtMemberId() {
		return checkGet(ctMemberId);
	}
    
    public void setCtMemberId(String ctMemberId) {
		this.ctMemberId = checkSet(ctMemberId);
	}	
	
    public String getAliasName() {
        return checkGet(aliasName);
    }

    public void setAliasName(String aliasName) {
        this.aliasName = checkSet(aliasName);
    }    	

    public String getFirstName() {
        return checkGet(firstName);
    }

    public void setFirstName(String firstName) {
        this.firstName = checkSet(firstName);
    }

    public String getLastName() {
        return checkGet(lastName);
    }

    public void setLastName(String lastName) {
        this.lastName = checkSet(lastName);
    }

    public String getCtDharmaName() {
        return checkGet(ctDharmaName);
    }

    public void setCtDharmaName(String ctDharmaName) {
        this.ctDharmaName = checkSet(ctDharmaName);
    }

    public String getCtRefugeMaster() {
        return checkGet(ctRefugeMaster);
    }

    public void setCtRefugeMaster(String ctRefugeMaster) {
        this.ctRefugeMaster = checkSet(ctRefugeMaster);
    }

    public String getGender() {
        return checkGet(gender);
    }

    public void setGender(String gender) {
        this.gender = checkSet(gender);
    }

    public String getTwIdNum() {
        return checkGet(twIdNum);
    }

    public void setTwIdNum(String twIdNum) {
        this.twIdNum = checkSet(twIdNum);
    }

    public String getOtherIdNum() {
        return checkGet(otherIdNum);
    }

    public void setOtherIdNum(String otherIdNum) {
        this.otherIdNum = checkSet(otherIdNum);
    }

    public String getBirthDate() {
        return checkGet(birthDate);
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = checkSet(birthDate);
    }

    public String getBirthMMDD() {
        return checkGet(birthMMDD);
    }

    public void setBirthMMDD(String birthMMDD) {
        this.birthMMDD = checkSet(birthMMDD);
    }

    public String getBirthCalendar() {
		return checkGet(birthCalendar);
	}

	public void setBirthCalendar(String birthCalendar) {
		this.birthCalendar = checkSet(birthCalendar);
	}

	public String getBirthDisplay() {
		return checkGet(birthDisplay);
	}

	public void setBirthDisplay(String birthDisplay) {
		this.birthDisplay = checkSet(birthDisplay);
	}

	public String getPasscode() {
        return checkGet(passcode);
    }

    public void setPasscode(String passcode) {
        this.passcode = checkSet(passcode);
    }

    public String getMobileNum1() {
        return checkGet(mobileNum1);
    }

    public void setMobileNum1(String mobileNum1) {
        this.mobileNum1 = checkSet(mobileNum1);
    }

    public String getMobileNum2() {
        return checkGet(mobileNum2);
    }

    public void setMobileNum2(String mobileNum2) {
        this.mobileNum2 = checkSet(mobileNum2);
    }

    public String getMobileNum3() {
        return checkGet(mobileNum3);
    }

    public void setMobileNum3(String mobileNum3) {
        this.mobileNum3 = checkSet(mobileNum3);
    }

    public String getHomePhoneNum1() {
        return checkGet(homePhoneNum1);
    }

    public void setHomePhoneNum1(String homePhoneNum1) {
        this.homePhoneNum1 = checkSet(homePhoneNum1);
    }

    public String getHomePhoneNum2() {
        return checkGet(homePhoneNum2);
    }

    public void setHomePhoneNum2(String homePhoneNum2) {
        this.homePhoneNum2 = checkSet(homePhoneNum2);
    }

    public String getUrgentContactPersonName1() {
        return checkGet(urgentContactPersonName1);
    }

    public void setUrgentContactPersonName1(String urgentContactPersonName1) {
        this.urgentContactPersonName1 = checkSet(urgentContactPersonName1);
    }

    public String getUrgentContactPersonRelationship1() {
        return checkGet(urgentContactPersonRelationship1);
    }

    public void setUrgentContactPersonRelationship1(
            String urgentContactPersonRelationship1) {
        this.urgentContactPersonRelationship1 = checkSet(urgentContactPersonRelationship1);
    }

    public String getUrgentContactPersonPhoneNum1() {
        return checkGet(urgentContactPersonPhoneNum1);
    }

    public void setUrgentContactPersonPhoneNum1(String urgentContactPersonPhoneNum1) {
        this.urgentContactPersonPhoneNum1 = checkSet(urgentContactPersonPhoneNum1);
    }

    public String getUrgentContactPersonName2() {
        return checkGet(urgentContactPersonName2);
    }

    public void setUrgentContactPersonName2(String urgentContactPersonName2) {
        this.urgentContactPersonName2 = checkSet(urgentContactPersonName2);
    }

    public String getUrgentContactPersonRelationship2() {
        return checkGet(urgentContactPersonRelationship2);
    }

    public void setUrgentContactPersonRelationship2(
            String urgentContactPersonRelationship2) {
        this.urgentContactPersonRelationship2 = checkSet(urgentContactPersonRelationship2);
    }

    public String getUrgentContactPersonPhoneNum2() {
        return checkGet(urgentContactPersonPhoneNum2);
    }

    public void setUrgentContactPersonPhoneNum2(String urgentContactPersonPhoneNum2) {
        this.urgentContactPersonPhoneNum2 = checkSet(urgentContactPersonPhoneNum2);
    }

    public String getDonationType() {
        return checkGet(donationType);
    }

    public void setDonationType(String donationType) {
        this.donationType = checkSet(donationType);
    }

    public String getClassList() {
        return checkGet(classList);
    }

    public void setClassList(String classList) {
        this.classList = checkSet(classList);
    }

    public String getPersonalPhotoFileName() {
        return checkGet(personalPhotoFileName);
    }

    public void setPersonalPhotoFileName(String personalPhotoFileName) {
        this.personalPhotoFileName = checkSet(personalPhotoFileName);
    }

    public String getOnBlackList() {
        return checkGet(onBlackList);
    }

    public void setOnBlackList(String onBlackList) {
        this.onBlackList = checkSet(onBlackList);
    }

    public String getOnNostayList() {
        return checkGet(onNostayList);
    }

    public void setOnNostayList(String onNostayList) {
        this.onNostayList = checkSet(onNostayList);
    }

    public String getThisPersonStatus() {
        return checkGet(thisPersonStatus);
    }

    public void setThisPersonStatus(String thisPersonStatus) {
        this.thisPersonStatus = checkSet(thisPersonStatus);
    }

    public String getOtherDharmaName() {
        return checkGet(otherDharmaName);
    }

    public void setOtherDharmaName(String otherDharmaName) {
        this.otherDharmaName = checkSet(otherDharmaName);
    }

    public String getOtherRefugeMaster() {
        return checkGet(otherRefugeMaster);
    }

    public void setOtherRefugeMaster(String otherRefugeMaster) {
        this.otherRefugeMaster = checkSet(otherRefugeMaster);
    }

    public String getPinyinFirstName() {
        return checkGet(pinyinFirstName);
    }

    public void setPinyinFirstName(String pinyinFirstName) {
        this.pinyinFirstName = checkSet(pinyinFirstName);
    }

    public String getPinyinLastName() {
        return checkGet(pinyinLastName);
    }

    public void setPinyinLastName(String pinyinLastName) {
        this.pinyinLastName = checkSet(pinyinLastName);
    }

    public String getPinyinOtherDharmaName() {
        return checkGet(pinyinOtherDharmaName);
    }

    public void setPinyinOtherDharmaName(String pinyinOtherDharmaName) {
        this.pinyinOtherDharmaName = checkSet(pinyinOtherDharmaName);
    }

    public String getOtherFirstName() {
        return checkGet(otherFirstName);
    }

    public void setOtherFirstName(String otherFirstName) {
        this.otherFirstName = checkSet(otherFirstName);
    }

    public String getOtherLastName() {
        return checkGet(otherLastName);
    }

    public void setOtherLastName(String otherLastName) {
        this.otherLastName = checkSet(otherLastName);
    }


    /** page 2 fields setter getter **/

    public String getNationality() {
        return checkGet(nationality);
    }

    public void setNationality(String nationality) {
        this.nationality = checkSet(nationality);
    }

    public String getFamilyProvince() {
        return checkGet(familyProvince);
    }

    public void setFamilyProvince(String familyProvince) {
        this.familyProvince = checkSet(familyProvince);
    }

    public String getFamilyCity() {
        return checkGet(familyCity);
    }

    public void setFamilyCity(String familyCity) {
        this.familyCity = checkSet(familyCity);
    }

    public String getBirthProvinceCountry() {
        return checkGet(birthProvinceCountry);
    }

    public void setBirthProvinceCountry(String birthProvinceCountry) {
        this.birthProvinceCountry = checkSet(birthProvinceCountry);
    }

    public String getBirthCity() {
        return checkGet(birthCity);
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = checkSet(birthCity);
    }

    public String getEmail1() {
        return checkGet(email1);
    }

    public void setEmail1(String email1) {
        this.email1 = checkSet(email1);
    }

    public String getEmail2() {
        return checkGet(email2);
    }

    public void setEmail2(String email2) {
        this.email2 = checkSet(email2);
    }

    public String getMarriageStatus() {
        return checkGet(marriageStatus);
    }

    public void setMarriageStatus(String marriageStatus) {
        this.marriageStatus = checkSet(marriageStatus);
    }

    public String getTwIdAddress() {
        return checkGet(twIdAddress);
    }

    public void setTwIdAddress(String twIdAddress) {
        this.twIdAddress = checkSet(twIdAddress);
    }

    public String getMailingAddress() {
        return checkGet(mailingAddress);
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = checkSet(mailingAddress);
    }

    public String getMailingCity() {
        return checkGet(mailingCity);
    }

    public void setMailingCity(String mailingCity) {
        this.mailingCity = checkSet(mailingCity);
    }

    public String getMailingState() {
        return checkGet(mailingState);
    }

    public void setMailingState(String mailingState) {
        this.mailingState = checkSet(mailingState);
    }

    public String getMailingZip() {
        return checkGet(mailingZip);
    }

    public void setMailingZip(String mailingZip) {
        this.mailingZip = checkSet(mailingZip);
    }

    public String getMailingCountry() {
        return checkGet(mailingCountry);
    }

    public void setMailingCountry(String mailingCountry) {
        this.mailingCountry = checkSet(mailingCountry);
    }

    public String getPermanentAddress() {
        return checkGet(permanentAddress);
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = checkSet(permanentAddress);
    }

    public String getPermanentCity() {
        return checkGet(permanentCity);
    }

    public void setPermanentCity(String permanentCity) {
        this.permanentCity = checkSet(permanentCity);
    }

    public String getPermanentState() {
        return checkGet(permanentState);
    }

    public void setPermanentState(String permanentState) {
        this.permanentState = checkSet(permanentState);
    }

    public String getPermanentZip() {
        return checkGet(permanentZip);
    }

    public void setPermanentZip(String permanentZip) {
        this.permanentZip = checkSet(permanentZip);
    }

    public String getPermanentCountry() {
        return checkGet(permanentCountry);
    }

    public void setPermanentCountry(String permanentCountry) {
        this.permanentCountry = checkSet(permanentCountry);
    }

    public String getOkSendEmail() {
        return checkGet(okSendEmail);
    }

    public void setOkSendEmail(String okSendEmail) {
        this.okSendEmail = checkSet(okSendEmail);
    }

    public String getSchoolName() {
        return checkGet(schoolName);
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = checkSet(schoolName);
    }

    public String getSchoolMajor() {
        return checkGet(schoolMajor);
    }

    public void setSchoolMajor(String schoolMajor) {
        this.schoolMajor = checkSet(schoolMajor);
    }

    public String getSchoolDegree() {
        return checkGet(schoolDegree);
    }

    public void setSchoolDegree(String schoolDegree) {
        this.schoolDegree = checkSet(schoolDegree);
    }

    public String getCompanyName() {
        return checkGet(companyName);
    }

    public void setCompanyName(String companyName) {
        this.companyName = checkSet(companyName);
    }

    public String getCompanyAddress() {
        return checkGet(companyAddress);
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = checkSet(companyAddress);
    }

    public String getCompanyJobTitle() {
        return checkGet(companyJobTitle);
    }

    public void setCompanyJobTitle(String companyJobTitle) {
        this.companyJobTitle = checkSet(companyJobTitle);
    }

    public String getOfficePhoneNum1() {
        return checkGet(officePhoneNum1);
    }

    public void setOfficePhoneNum1(String officePhoneNum1) {
        this.officePhoneNum1 = checkSet(officePhoneNum1);
    }

    public String getOfficePhoneNum2() {
        return checkGet(officePhoneNum2);
    }

    public void setOfficePhoneNum2(String officePhoneNum2) {
        this.officePhoneNum2 = checkSet(officePhoneNum2);
    }

    public String getReferenceId() {
        return checkGet(referenceId);
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = checkSet(referenceId);
    }

    public String getIntroducerName() {
        return checkGet(introducerName);
    }

    public void setIntroducerName(String introducerName) {
        this.introducerName = checkSet(introducerName);
    }

    public String getIntroducerRelationship() {
        return checkGet(introducerRelationship);
    }

    public void setIntroducerRelationship(String introducerRelationship) {
        this.introducerRelationship = checkSet(introducerRelationship);
    }

    public String getIntroducerPhoneNum() {
        return checkGet(introducerPhoneNum);
    }

    public void setIntroducerPhoneNum(String introducerPhoneNum) {
        this.introducerPhoneNum = checkSet(introducerPhoneNum);
    }

    public String getOkSendMagazine() {
        return checkGet(okSendMagazine);
    }

    public void setOkSendMagazine(String okSendMagazine) {
        this.okSendMagazine = checkSet(okSendMagazine);
    }

    public String getOkSendEletter() {
        return checkGet(okSendEletter);
    }

    public void setOkSendEletter(String okSendEletter) {
        this.okSendEletter = checkSet(okSendEletter);
    }

    public String getOkSendMessage() {
        return checkGet(okSendMessage);
    }

    public void setOkSendMessage(String okSendMessage) {
        this.okSendMessage = checkSet(okSendMessage);
    }

    public String getOkToCallType() {
        return checkGet(okToCallType);
    }

    public void setOkToCallType(String okToCallType) {
        this.okToCallType = checkSet(okToCallType);
    }

    public String getTakeRefuge() {
        return checkGet(takeRefuge);
    }

    public void setTakeRefuge(String takeRefuge) {
        this.takeRefuge = checkSet(takeRefuge);
    }

    public String getRefugeDate() {
        return checkGet(refugeDate);
    }

    public void setRefugeDate(String refugeDate) {
        this.refugeDate = checkSet(refugeDate);
    }

    public String getRefugePlace() {
        return checkGet(refugePlace);
    }

    public void setRefugePlace(String refugePlace) {
        this.refugePlace = checkSet(refugePlace);
    }

    public String getTakePrecept5() {
        return checkGet(takePrecept5);
    }

    public void setTakePrecept5(String takePrecept5) {
        this.takePrecept5 = checkSet(takePrecept5);
    }

    public String getPrecept5Date() {
        return checkGet(precept5Date);
    }

    public void setPrecept5Date(String precept5Date) {
        this.precept5Date = checkSet(precept5Date);
    }

    public String getPrecept5Place() {
        return checkGet(precept5Place);
    }

    public void setPrecept5Place(String precept5Place) {
        this.precept5Place = checkSet(precept5Place);
    }

    public String getTakeBodhiPrecept() {
        return checkGet(takeBodhiPrecept);
    }

    public void setTakeBodhiPrecept(String takeBodhiPrecept) {
        this.takeBodhiPrecept = checkSet(takeBodhiPrecept);
    }

    public String getBodhiPreceptDate() {
        return checkGet(bodhiPreceptDate);
    }

    public void setBodhiPreceptDate(String bodhiPreceptDate) {
        this.bodhiPreceptDate = checkSet(bodhiPreceptDate);
    }

    public String getBodhiPreceptPlace() {
        return checkGet(bodhiPreceptPlace);
    }

    public void setBodhiPreceptPlace(String bodhiPreceptPlace) {
        this.bodhiPreceptPlace = checkSet(bodhiPreceptPlace);
    }

    public String getEthnicGroup() {
        return checkGet(ethnicGroup);
    }

    public void setEthnicGroup(String ethnicGroup) {
        this.ethnicGroup = checkSet(ethnicGroup);
    }

    public String getZen7Count() {
        return checkGet(zen7Count);
    }

    public void setZen7Count(String zen7Count) {
        this.zen7Count = checkSet(zen7Count);
    }

    public String getZen7VlntrCount() {
        return checkGet(zen7VlntrCount);
    }

    public void setZen7VlntrCount(String zen7VlntrCount) {
        this.zen7VlntrCount = checkSet(zen7VlntrCount);
    }

    public String getSummerVlntrConut() {
        return checkGet(summerVlntrConut);
    }

    public void setSummerVlntrConut(String summerVlntrConut) {
        this.summerVlntrConut = checkSet(summerVlntrConut);
    }

    /** page 3 fields setter getter **/

    public String getCarNum1() {
        return checkGet(carNum1);
    }

    public void setCarNum1(String carNum1) {
        this.carNum1 = checkSet(carNum1);
    }

    public String getCarNum2() {
        return checkGet(carNum2);
    }

    public void setCarNum2(String carNum2) {
        this.carNum2 = checkSet(carNum2);
    }

    public String getHeight() {
        return checkGet(height);
    }

    public void setHeight(String height) {
        this.height = checkSet(height);
    }

    public String getWeight() {
        return checkGet(weight);
    }

    public void setWeight(String weight) {
        this.weight = checkSet(weight);
    }

    public String getAfter2012Oct() {
        return checkGet(after2012Oct);
    }

    public void setAfter2012Oct(String after2012Oct) {
        this.after2012Oct = checkSet(after2012Oct);
    }

    public String getIsPiSigned() {
        return checkGet(isPiSigned);
    }

    public void setIsPiSigned(String isPiSigned) {
        this.isPiSigned = checkSet(isPiSigned);
    }

    public String getPiDocId() {
        return checkGet(piDocId);
    }

    public void setPiDocId(String piDocId) {
        this.piDocId = checkSet(piDocId);
    }

    public String getPiAggrementPicFileName() {
        return checkGet(piAggrementPicFileName);
    }

    public void setPiAggrementPicFileName(String piAggrementPicFileName) {
        this.piAggrementPicFileName = checkSet(piAggrementPicFileName);
    }

    public String getPiParentAggrementPicFileName() {
        return checkGet(piParentAggrementPicFileName);
    }

    public void setPiParentAggrementPicFileName(String piParentAggrementPicFileName) {
        this.piParentAggrementPicFileName = checkSet(piParentAggrementPicFileName);
    }

    public String getTwIdPicFrontFileName() {
        return checkGet(twIdPicFrontFileName);
    }

    public void setTwIdPicFrontFileName(String twIdPicFrontFileName) {
        this.twIdPicFrontFileName = checkSet(twIdPicFrontFileName);
    }

    public String getTwIdPicBackFileName() {
        return checkGet(twIdPicBackFileName);
    }

    public void setTwIdPicBackFileName(String twIdPicBackFileName) {
        this.twIdPicBackFileName = checkSet(twIdPicBackFileName);
    }

    /** 額外功能用 **/

    public String getMcRadio() {
        return checkGet(mcRadio);
    }

    public void setMcRadio(String mcRadio) {
        this.mcRadio = checkSet(mcRadio);
    }

    public String getPcRadio() {
        return checkGet(pcRadio);
    }

    public void setPcRadio(String pcRadio) {
        this.pcRadio = checkSet(pcRadio);
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    public String[] getHealths() {
        return healths;
    }

    public void setHealths(String[] healths) {
        this.healths = healths;
    }

    public String getOtherSkill() {
        return checkGet(otherSkill);
    }

    public void setOtherSkill(String otherSkill) {
        this.otherSkill = checkSet(otherSkill);
    }

    public String getOtherHealth() {
        return checkGet(otherHealth);
    }

    public void setOtherHealth(String otherHealth) {
        this.otherHealth = checkSet(otherHealth);
    }

    public String getOtherSkillName() {
        return checkGet(otherSkillName);
    }

    public void setOtherSkillName(String otherSkillName) {
        this.otherSkillName = checkSet(otherSkillName);
    }

    public String getOtherHealthName() {
        return checkGet(otherHealthName);
    }

    public void setOtherHealthName(String otherHealthName) {
        this.otherHealthName = checkSet(otherHealthName);
    }

    /** 查詢用 **/

    public String getQ_unitId() {
        return checkGet(q_unitId);
    }

    public void setQ_unitId(String qUnitId) {
        q_unitId = checkSet(qUnitId);
    }

    public String getQ_centerMemberId() {
        return checkGet(q_centerMemberId);
    }

    public void setQ_centerMemberId(String qCenterMemberId) {
        q_centerMemberId = checkSet(qCenterMemberId);
    }

    public String getQ_fullName() {
        return checkGet(q_fullName);
    }

    public void setQ_fullName(String qFullName) {
        q_fullName = checkSet(qFullName);
    }

    public String getQ_ctDharmaName() {
        return checkGet(q_ctDharmaName);
    }

    public void setQ_ctDharmaName(String qCtDharmaName) {
        q_ctDharmaName = checkSet(qCtDharmaName);
    }

    public String getQ_email1() {
        return checkGet(q_email1);
    }

    public void setQ_email1(String qEmail1) {
        q_email1 = checkSet(qEmail1);
    }

    public String getQ_aliasName() {
        return checkGet(q_aliasName);
    }

    public void setQ_aliasName(String qAliasName) {
        q_aliasName = checkSet(qAliasName);
    }

	public String getQ_twIdNum() {
		return checkGet(q_twIdNum);
	}

	public void setQ_twIdNum(String qTwIdNum) {
		q_twIdNum = checkSet(qTwIdNum);
	}

	public String getQ_birthDisplay() {
		return checkGet(q_birthDisplay);
	}

	public void setQ_birthDisplay(String qBirthDisplay) {
		q_birthDisplay = checkSet(qBirthDisplay);
	}

	public String getQ_mobileNum1() {
		return checkGet(q_mobileNum1);
	}

	public void setQ_mobileNum1(String qMobileNum1) {
		q_mobileNum1 = checkSet(qMobileNum1);
	}

	public String getQ_homePhoneNum1() {
		return checkGet(q_homePhoneNum1);
	}

	public void setQ_homePhoneNum1(String qHomePhoneNum1) {
		q_homePhoneNum1 = checkSet(qHomePhoneNum1);
	}
    
}
