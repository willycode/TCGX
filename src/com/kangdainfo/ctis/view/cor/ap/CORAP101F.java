package com.kangdainfo.ctis.view.cor.ap;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.kangdainfo.ServiceGetter;

import com.kangdainfo.common.util.Common;
import com.kangdainfo.common.util.Datetime;
import com.kangdainfo.common.util.SuperBean;
import com.kangdainfo.common.util.View;
import com.kangdainfo.ctis.model.bo.CenterUsage;

import com.kangdainfo.util.DateUtil;

/**
*<br>程式目的： 精舍使用情形維護作業
*<br>程式代號：CORAP101F
*<br>程式日期：103.09.04
*<br>程式作者：David Chiu
*<br>--------------------------------------------------------
*<br>修改作者　　修改日期　　　修改目的
*<br>--------------------------------------------------------
*/
public class CORAP101F extends SuperBean {
    final static int    DEFAULT_DBTIME_LENGTH = 6;
    final static String DEFAULT_INPUT_TIME    = "000000";
    private String id;
    private String unitId;         // 使用精舍之單位代號
    private String unitShortName;  // 使用精舍之單位簡稱
    private String centerMemberId; // 使用精舍之學員代號【下拉式選單中「文字」顯示 ：精舍學員代號(centerMemberId) + ' ' + 精舍學員化名(aliasName)】
    private String usageDate;      // 精舍之使用日期
    private String usageTime;      // 精舍之使用時間
    private String usageNote;      // 精舍之使用說明

    private String q_unitId;
    private String q_unitShortName;
    private String q_centerMemberId;
    private String q_usageDate;
    private String q_usageTime;

    @Override
    public void doCreate() throws Exception {
        CenterUsage db_obj = new CenterUsage();
        db_obj.setUnitId        (unitId);
        db_obj.setUnitShortName (unitShortName);
        db_obj.setCenterMemberId(centerMemberId);
        db_obj.setAliasName     (getAliasName());
        db_obj.setUsageDate     (usageDate);
        db_obj.setUsageTime     (checkTimeField(usageTime));
        db_obj.setUsageNote     (usageNote);
        db_obj.setCreateId      (createId);
        db_obj.setCreateDate    (createDate);
        db_obj.setCreateTime    (createTime);
        ServiceGetter.getInstance().getCommonService().save(db_obj);
        setId(db_obj.getId().toString());
    }

    @Override
    public void doUpdate() throws Exception {
        CenterUsage db_obj = (CenterUsage)View.getObject(" From CenterUsage Where id = " + Common.getInt(getId()));
        db_obj.setUnitId        (unitId);
        db_obj.setUnitShortName (unitShortName);
        db_obj.setCenterMemberId(centerMemberId);
        db_obj.setAliasName     (getAliasName());
        db_obj.setUsageDate     (usageDate);
        db_obj.setUsageTime     (checkTimeField(usageTime));
        db_obj.setUsageNote     (usageNote);
        db_obj.setUpdateId      (updateId);
        db_obj.setUpdateDate    (updateDate);
        db_obj.setUpdateTime    (updateTime);
        db_obj.setUpdateIp      (updateIp);
        db_obj.setUpdateUnitShortName(updateUnitShortName);
        ServiceGetter.getInstance().getCommonService().save(db_obj);
        setId(db_obj.getId().toString());
    }

    @Override
    public void doDelete() throws Exception {
        ServiceGetter.getInstance().getCommonService().delete(CenterUsage.class, Common.getInt(getId()));
    }

    public String checkTimeField(String time_field) {
        StringBuilder sb_time = new StringBuilder();
        if(time_field == null || "".equals(time_field)) {
            // 若時間欄位為「空白」或「未輸入」，則系統將其預設為【000000】
            sb_time.append(DEFAULT_INPUT_TIME);
        } else {
            // 若時間欄位有「輸入值」，則讀取其值
            sb_time.append(time_field);
            if(time_field.length() < DEFAULT_DBTIME_LENGTH) {
                for(int i = time_field.length() ; i < DEFAULT_DBTIME_LENGTH ; i++) {
                    // 若時間欄位之「輸入值」只輸入部份值，其位數不足，則系統主動補【0】
                    sb_time.append("0");
                }
            }
        }
        return sb_time.toString();
    }

    public String getAliasName() {
        String aliasName, hql;
        hql       = "Select aliasName From CenterMemberInfo Where unitId = " + Common.sqlChar(unitId) +
                    " and centerMemberId = " + Common.sqlChar(centerMemberId);
        aliasName = (String)View.getObject(hql);
        return aliasName;
    }

    /**
     * <br>
     * <br>目的：依主鍵查詢單一資料
     * <br>參數：無
     * <br>傳回：傳回本物件
    */
    @Override
    public CORAP101F doQueryOne() throws Exception {
        CORAP101F querybean_obj = this;
        CenterUsage      db_rec = (CenterUsage)ServiceGetter.getInstance().getCommonService().load(CenterUsage.class, Integer.parseInt(getId()));
        if (db_rec != null) {
            querybean_obj.setUnitId             (db_rec.getUnitId());
            querybean_obj.setUnitShortName      (db_rec.getUnitShortName());
            querybean_obj.setCenterMemberId     (db_rec.getCenterMemberId());
            querybean_obj.setUsageDate          (db_rec.getUsageDate());
            querybean_obj.setUsageTime          (db_rec.getUsageTime());
            querybean_obj.setUsageNote          (db_rec.getUsageNote());
            querybean_obj.setCreateId           (db_rec.getCreateId());
            querybean_obj.setCreateDate         (db_rec.getCreateDate());
            querybean_obj.setCreateTime         (db_rec.getCreateTime());
            querybean_obj.setUpdateId           (db_rec.getUpdateId());
            querybean_obj.setUpdateDate         (db_rec.getUpdateDate());
            querybean_obj.setUpdateTime         (db_rec.getUpdateTime());
            querybean_obj.setUpdateIp           (db_rec.getUpdateIp());
            querybean_obj.setUpdateUnitShortName(db_rec.getUpdateUnitShortName());
        } else throw new Exception("查無該筆資料！");
            return querybean_obj;
    }

    @Override
    public java.util.ArrayList<String[]> doQueryAll() throws Exception {
        java.util.ArrayList<String[]> arrList = new java.util.ArrayList<String[]>();
        StringBuilder hql = new StringBuilder().append("From CenterUsage Where 1=1");
        Map<String, Object> maps = new HashMap<String, Object>();

        if (!"".equals(getQ_unitId())) {
            hql.append(" and unitId = :unitId");
            maps.put("unitId", q_unitId);
        }

        if (!"".equals(getQ_unitShortName())) {
            hql.append(" and unitShortName like :unitShortName");
            maps.put("unitShortName", "%" + q_unitShortName + "%");
        }

        if (!"".equals(getQ_centerMemberId())) {
            hql.append(" and centerMemberId = :centerMemberId");
            maps.put("centerMemberId", q_centerMemberId);
        }

        if (!"".equals(getQ_usageDate())) {
            hql.append(" and usageDate = :usageDate");
            maps.put("usageDate", q_usageDate);
        }

        if (!"".equals(getQ_usageTime())) {
            hql.append(" and usageTime like :usageTime");
            maps.put("usageTime", "%" + q_usageTime + "%");
        }

        this.processCurrentPageAttribute(ServiceGetter.getInstance().getCommonService().getCommonUserDao().loadCount(hql.toString(), maps));

        if (getTotalRecord() > 0) {
            if (getState().indexOf("query") < 0)
                ServiceGetter.getInstance().getCommonService().clear();

            java.util.List objList = ServiceGetter.getInstance().getCommonService().getCommonUserDao().load(hql.toString(), this.getRecordStart(), this.getPageSize(), "id", true, maps);
            try {
                if (objList != null && objList.size() > 0) {
                    for (int i = 0 ; i < objList.size() ; i++) {
                        CenterUsage db_obj = (CenterUsage)objList.get(i);
                        String   rowArray[] = new String[4];
                        rowArray[0] = Common.get(db_obj.getId());
                        rowArray[1] = Common.get(db_obj.getUnitId())         + " " + Common.get(db_obj.getUnitShortName());
                        rowArray[2] = Common.get(db_obj.getCenterMemberId()) + " " + Common.get(db_obj.getAliasName());
                        rowArray[3] = Common.get(db_obj.getUsageDate())      + " " + Common.get(db_obj.getUsageTime());
                        arrList.add(rowArray);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrList;
    }

    public String getId() {
        return checkGet(id);
    }

    public void setId(String id) {
        this.id = checkSet(id);
    }

    public String getUnitId() {
        return checkGet(unitId);
    }

    public void setUnitId(String unitId) {
        this.unitId = checkSet(unitId);
    }

    public String getUnitShortName() {
        return checkGet(unitShortName);
    }

    public void setUnitShortName(String unitShortName) {
        this.unitShortName = checkSet(unitShortName);
    }

    public String getCenterMemberId() {
        return checkGet(centerMemberId);
    }

    public void setCenterMemberId(String centerMemberId) {
        this.centerMemberId = checkSet(centerMemberId);
    }

    public String getUsageDate() {
        return checkGet(usageDate);
    }

    public void setUsageDate(String usageDate) {
        this.usageDate = checkSet(usageDate);
    }

    public String getUsageTime() {
        return checkGet(usageTime);
    }

    public void setUsageTime(String usageTime) {
        this.usageTime = checkSet(usageTime);
    }

    public String getUsageNote() {
        return checkGet(usageNote);
    }

    public void setUsageNote(String usageNote) {
        this.usageNote = checkSet(usageNote);
    }

    public String getQ_unitId() {
        return checkGet(q_unitId);
    }

    public void setQ_unitId(String q_unitId) {
        this.q_unitId = checkSet(q_unitId);
    }

    public String getQ_unitShortName() {
        return checkGet(q_unitShortName);
    }

    public void setQ_unitShortName(String q_unitShortName) {
        this.q_unitShortName = checkSet(q_unitShortName);
    }

    public String getQ_centerMemberId() {
        return checkGet(q_centerMemberId);
    }

    public void setQ_centerMemberId(String q_centerMemberId) {
        this.q_centerMemberId = checkSet(q_centerMemberId);
    }

    public String getQ_usageDate() {
        return checkGet(q_usageDate);
    }

    public void setQ_usageDate(String q_usageDate) {
        this.q_usageDate = checkSet(q_usageDate);
    }

    public String getQ_usageTime() {
        return checkGet(q_usageTime);
    }

    public void setQ_usageTime(String q_usageTime) {
        this.q_usageTime = checkSet(q_usageTime);
    }

}
