package com.kangdainfo.common.view.sys.ca;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.kangdainfo.ServiceGetter;

import com.kangdainfo.common.util.Common;
import com.kangdainfo.common.util.Datetime;
import com.kangdainfo.common.util.SuperBean;
import com.kangdainfo.common.util.View;
import com.kangdainfo.common.model.bo.BaseCountryDef;

import com.kangdainfo.util.DateUtil;

/**
*<br>程式目的：國別代碼資料維護作業
*<br>程式代號：SYSCA011F
*<br>程式日期：103.09.05
*<br>程式作者：David Chiu
*<br>--------------------------------------------------------
*<br>修改作者　　修改日期　　　修改目的
*<br>--------------------------------------------------------
*/
public class SYSCA011F extends SuperBean {
    private String id;
    private String countryId;          // 各國之英文國名簡稱
    private String countryChineseName; // 各國之中文國名
    private String countryEnglishName; // 各國之英文國名
    private String countryTelCode;     // 各國之國家電信代碼

    private String q_countryId;
    private String q_countryChineseName;
    private String q_countryEnglishName;
    private String q_countryTelCode;

    @Override
    public void doCreate() throws Exception {
        BaseCountryDef db_obj = new BaseCountryDef();
        db_obj.setCountryId          (countryId);
        db_obj.setCountryChineseName (countryChineseName);
        db_obj.setCountryEnglishName (countryEnglishName);
        db_obj.setCountryTelCode     (countryTelCode);
        db_obj.setCreateId           (createId);
        db_obj.setCreateDate         (createDate);
        db_obj.setCreateTime         (createTime);
        ServiceGetter.getInstance().getCommonService().save(db_obj);
        setId(db_obj.getId().toString());
    }

    @Override
    public void doUpdate() throws Exception {
        BaseCountryDef db_obj = (BaseCountryDef)View.getObject(" From BaseCountryDef Where id = " + Common.getInt(getId()));
        db_obj.setCountryId          (countryId);
        db_obj.setCountryChineseName (countryChineseName);
        db_obj.setCountryEnglishName (countryEnglishName);
        db_obj.setCountryTelCode     (countryTelCode);
        db_obj.setUpdateId           (updateId);
        db_obj.setUpdateDate         (updateDate);
        db_obj.setUpdateTime         (updateTime);
        db_obj.setUpdateIp           (updateIp);
        db_obj.setUpdateUnitShortName(updateUnitShortName);
        ServiceGetter.getInstance().getCommonService().save(db_obj);
        setId(db_obj.getId().toString());
    }

    @Override
    public void doDelete() throws Exception {
        ServiceGetter.getInstance().getCommonService().delete(BaseCountryDef.class, Common.getInt(getId()));
    }

    /**
     * <br>
     * <br>目的：依主鍵查詢單一資料
     * <br>參數：無
     * <br>傳回：傳回本物件
    */
    @Override
    public SYSCA011F doQueryOne() throws Exception {
        SYSCA011F querybean_obj = this;
        BaseCountryDef   db_rec = (BaseCountryDef)ServiceGetter.getInstance().getCommonService().load(BaseCountryDef.class, Integer.parseInt(getId()));
        if (db_rec != null) {
            querybean_obj.setCountryId          (db_rec.getCountryId());
            querybean_obj.setCountryChineseName (db_rec.getCountryChineseName());
            querybean_obj.setCountryEnglishName (db_rec.getCountryEnglishName());
            querybean_obj.setCountryTelCode     (db_rec.getCountryTelCode());
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
        StringBuilder hql = new StringBuilder().append("From BaseCountryDef Where 1=1");
        Map<String, Object> maps = new HashMap<String, Object>();
        if (!"".equals(getQ_countryId())) {
            hql.append(" and countryId like :countryId");
            maps.put("countryId", "%" + q_countryId + "%");
        }
        if (!"".equals(getQ_countryChineseName())) {
            hql.append(" and countryChineseName like :countryChineseName");
            maps.put("countryChineseName", "%" + q_countryChineseName + "%");
        }
        if (!"".equals(getQ_countryEnglishName())) {
            hql.append(" and countryEnglishName like :countryEnglishName");
            maps.put("countryEnglishName", "%" + q_countryEnglishName + "%");
        }
        if (!"".equals(getQ_countryTelCode())) {
            hql.append(" and countryTelCode like :countryTelCode");
            maps.put("countryTelCode", "%" + q_countryTelCode + "%");
        }

        this.processCurrentPageAttribute(ServiceGetter.getInstance().getCommonService().getCommonUserDao().loadCount(hql.toString(), maps));

        if (getTotalRecord() > 0) {
            if (getState().indexOf("query") < 0)
                ServiceGetter.getInstance().getCommonService().clear();
            java.util.List objList = ServiceGetter.getInstance().getCommonService().getCommonUserDao().load(hql.toString(), this.getRecordStart(), this.getPageSize(), "id", true, maps);
            try {
                if (objList != null && objList.size() > 0) {
                    for (int i = 0 ; i < objList.size() ; i++) {
                        BaseCountryDef db_obj = (BaseCountryDef)objList.get(i);
                        String     rowArray[] = new String[5];
                        rowArray[0] = Common.get(db_obj.getId());
                        rowArray[1] = Common.get(db_obj.getCountryId());
                        rowArray[2] = Common.get(db_obj.getCountryTelCode());
                        rowArray[3] = Common.get(db_obj.getCountryChineseName());
                        rowArray[4] = Common.get(db_obj.getCountryEnglishName());
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

    public String getCountryId() {
        return checkGet(countryId);
    }

    public void setCountryId(String countryId) {
        this.countryId = checkSet(countryId);
    }

    public String getCountryChineseName() {
        return checkGet(countryChineseName);
    }

    public void setCountryChineseName(String countryChineseName) {
        this.countryChineseName = checkSet(countryChineseName);
    }

    public String getCountryEnglishName() {
        return checkGet(countryEnglishName);
    }

    public void setCountryEnglishName(String countryEnglishName) {
        this.countryEnglishName = checkSet(countryEnglishName);
    }

    public String getCountryTelCode() {
        return checkGet(countryTelCode);
    }

    public void setCountryTelCode(String countryTelCode) {
        this.countryTelCode = checkSet(countryTelCode);
    }

    public String getQ_countryId() {
        return checkGet(q_countryId);
    }

    public void setQ_countryId(String q_countryId) {
        this.q_countryId = checkSet(q_countryId);
    }

    public String getQ_countryChineseName() {
        return checkGet(q_countryChineseName);
    }

    public void setQ_countryChineseName(String q_countryChineseName) {
        this.q_countryChineseName = checkSet(q_countryChineseName);
    }

    public String getQ_countryEnglishName() {
        return checkGet(q_countryEnglishName);
    }

    public void setQ_countryEnglishName(String q_countryEnglishName) {
        this.q_countryEnglishName = checkSet(q_countryEnglishName);
    }

    public String getQ_countryTelCode() {
        return checkGet(q_countryTelCode);
    }

    public void setQ_countryTelCode(String q_countryTelCode) {
        this.q_countryTelCode = checkSet(q_countryTelCode);
    }

}
