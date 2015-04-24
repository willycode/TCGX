package com.kangdainfo.ctis.view.can.ca;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;

import com.kangdainfo.ServiceGetter;

import com.kangdainfo.common.util.Common;
import com.kangdainfo.common.util.Datetime;
import com.kangdainfo.common.util.SuperBean;
import com.kangdainfo.common.util.View;
import com.kangdainfo.ctis.model.bo.BaseChanCatDef;

import com.kangdainfo.util.DateUtil;

/**
*<br>程式目的：課程代碼維護作業
*<br>程式代號：CANCA001F
*<br>程式日期：103.09.10
*<br>程式作者：David Chiu
*<br>--------------------------------------------------------
*<br>修改作者　　修改日期　　　修改目的
*<br>--------------------------------------------------------
*/
public class CANCA001F extends SuperBean {
    private String id;
    private String chanCatId;          // 禪修班代碼
    private String chanCatName;        // 禪修班名稱
    private String chanCatEngName;     // 禪修班英文名稱
    private String chanCatBookSeq;     // 指定教材序號
    private String chanCatBookName;    // 指定教材名稱
    private String chanCatBookEngName; // 指定教材英文名稱

    private String q_chanCatId;
    private String q_chanCatName;
    private String q_chanCatEngName;
    private String q_chanCatBookSeq;
    private String q_chanCatBookName;
    private String q_chanCatBookEngName;

    @Override
    public void doCreate() throws Exception {
        BaseChanCatDef db_obj = new BaseChanCatDef();
        db_obj.setChanCatId          (chanCatId);
        db_obj.setChanCatName        (chanCatName);
        db_obj.setChanCatEngName     (chanCatEngName);
        db_obj.setChanCatBookSeq     (chanCatBookSeq);
        db_obj.setChanCatBookName    (chanCatBookName);
        db_obj.setChanCatBookEngName (chanCatBookEngName);
        db_obj.setCreateId           (createId);
        db_obj.setCreateDate         (createDate);
        db_obj.setCreateTime         (createTime);
        ServiceGetter.getInstance().getCommonService().save(db_obj);
        setId(db_obj.getId().toString());
    }

    @Override
    public void doUpdate() throws Exception {
        BaseChanCatDef db_obj = (BaseChanCatDef)View.getObject(" From BaseChanCatDef Where id = " + Common.getInt(getId()));
        db_obj.setChanCatId          (chanCatId);
        db_obj.setChanCatName        (chanCatName);
        db_obj.setChanCatEngName     (chanCatEngName);
        db_obj.setChanCatBookSeq     (chanCatBookSeq);
        db_obj.setChanCatBookName    (chanCatBookName);
        db_obj.setChanCatBookEngName (chanCatBookEngName);
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
        ServiceGetter.getInstance().getCommonService().delete(BaseChanCatDef.class, Common.getInt(getId()));
    }

    /**
     * <br>
     * <br>目的：依主鍵查詢單一資料
     * <br>參數：無
     * <br>傳回：傳回本物件
    */
    @Override
    public CANCA001F doQueryOne() throws Exception {
        CANCA001F querybean_obj = this;
        BaseChanCatDef db_rec = (BaseChanCatDef)ServiceGetter.getInstance().getCommonService().load(BaseChanCatDef.class, Integer.parseInt(getId()));
        if (db_rec != null) {
            querybean_obj.setChanCatId          (db_rec.getChanCatId());
            querybean_obj.setChanCatName        (db_rec.getChanCatName());
            querybean_obj.setChanCatEngName     (db_rec.getChanCatEngName());
            querybean_obj.setChanCatBookSeq     (db_rec.getChanCatBookSeq());
            querybean_obj.setChanCatBookName    (db_rec.getChanCatBookName());
            querybean_obj.setChanCatBookEngName (db_rec.getChanCatBookEngName());
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
        StringBuilder hql = new StringBuilder().append("From BaseChanCatDef Where 1=1");
        Map<String, Object> maps = new HashMap<String, Object>();
        if (!"".equals(getQ_chanCatId())) {
            hql.append(" and chanCatId = :chanCatId");
            maps.put("chanCatId", q_chanCatId);
        }
        if (!"".equals(getQ_chanCatName())) {
            hql.append(" and chanCatName like :chanCatName");
            maps.put("chanCatName", "%" + q_chanCatName + "%");
        }
        if (!"".equals(getQ_chanCatEngName())) {
            hql.append(" and chanCatEngName like :chanCatEngName");
            maps.put("chanCatEngName", "%" + q_chanCatEngName + "%");
        }
        if (!"".equals(getQ_chanCatBookSeq())) {
            hql.append(" and chanCatBookSeq = :chanCatBookSeq");
            maps.put("chanCatBookSeq", q_chanCatBookSeq);
        }
        if (!"".equals(getQ_chanCatBookName())) {
            hql.append(" and chanCatBookName like :chanCatBookName");
            maps.put("chanCatBookName", "%" + q_chanCatBookName + "%");
        }
        if (!"".equals(getQ_chanCatBookEngName())) {
            hql.append(" and chanCatBookEngName like :chanCatBookEngName");
            maps.put("chanCatBookEngName", "%" + q_chanCatBookEngName + "%");
        }

        this.processCurrentPageAttribute(ServiceGetter.getInstance().getCommonService().getCommonUserDao().loadCount(hql.toString(), maps));

        if (getTotalRecord() > 0) {
            if (getState().indexOf("query") < 0)
                ServiceGetter.getInstance().getCommonService().clear();
            java.util.List objList = ServiceGetter.getInstance().getCommonService().getCommonUserDao().load(hql.toString(), this.getRecordStart(), this.getPageSize(), "id", true, maps);
            try {
                if (objList != null && objList.size() > 0) {
                    for (int i = 0 ; i < objList.size() ; i++) {
                        BaseChanCatDef db_obj = (BaseChanCatDef)objList.get(i);
                        String       rowArray[] = new String[5];
                        rowArray[0] = Common.get(db_obj.getId());
                        rowArray[1] = Common.get(db_obj.getChanCatId());
                        rowArray[2] = Common.get(db_obj.getChanCatName());
                        rowArray[3] = Common.get(db_obj.getChanCatBookSeq());
                        rowArray[4] = Common.get(db_obj.getChanCatBookName());
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

    public String getChanCatId() {
        return checkGet(chanCatId);
    }

    public void setChanCatId(String chanCatId) {
        this.chanCatId = checkSet(chanCatId);
    }

    public String getChanCatName() {
        return checkGet(chanCatName);
    }

    public void setChanCatName(String chanCatName) {
        this.chanCatName = checkSet(chanCatName);
    }

    public String getChanCatEngName() {
        return checkGet(chanCatEngName);
    }

    public void setChanCatEngName(String chanCatEngName) {
        this.chanCatEngName = checkSet(chanCatEngName);
    }

    public String getChanCatBookSeq() {
        return checkGet(chanCatBookSeq);
    }

    public void setChanCatBookSeq(String chanCatBookSeq) {
        this.chanCatBookSeq = checkSet(chanCatBookSeq);
    }

    public String getChanCatBookName() {
        return checkGet(chanCatBookName);
    }

    public void setChanCatBookName(String chanCatBookName) {
        this.chanCatBookName = checkSet(chanCatBookName);
    }

    public String getChanCatBookEngName() {
        return checkGet(chanCatBookEngName);
    }

    public void setChanCatBookEngName(String chanCatBookEngName) {
        this.chanCatBookEngName = checkSet(chanCatBookEngName);
    }

    public String getQ_chanCatId() {
        return checkGet(q_chanCatId);
    }

    public void setQ_chanCatId(String q_chanCatId) {
        this.q_chanCatId = checkSet(q_chanCatId);
    }

    public String getQ_chanCatName() {
        return checkGet(q_chanCatName);
    }

    public void setQ_chanCatName(String q_chanCatName) {
        this.q_chanCatName = checkSet(q_chanCatName);
    }

    public String getQ_chanCatEngName() {
        return checkGet(q_chanCatEngName);
    }

    public void setQ_chanCatEngName(String q_chanCatEngName) {
        this.q_chanCatEngName = checkSet(q_chanCatEngName);
    }

    public String getQ_chanCatBookSeq() {
        return checkGet(q_chanCatBookSeq);
    }

    public void setQ_chanCatBookSeq(String q_chanCatBookSeq) {
        this.q_chanCatBookSeq = checkSet(q_chanCatBookSeq);
    }

    public String getQ_chanCatBookName() {
        return checkGet(q_chanCatBookName);
    }

    public void setQ_chanCatBookName(String q_chanCatBookName) {
        this.q_chanCatBookName = checkSet(q_chanCatBookName);
    }

    public String getQ_chanCatBookEngName() {
        return checkGet(q_chanCatBookEngName);
    }

    public void setQ_chanCatBookEngName(String q_chanCatBookEngName) {
        this.q_chanCatBookEngName = checkSet(q_chanCatBookEngName);
    }

}
