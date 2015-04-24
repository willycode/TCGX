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
import com.kangdainfo.common.model.bo.BaseReferenceDef;

import com.kangdainfo.util.DateUtil;

/**
*<br>程式目的：來精舍原因代碼維護作業
*<br>程式代號：SYSCA012F
*<br>程式日期：103.09.05
*<br>程式作者：David Chiu
*<br>--------------------------------------------------------
*<br>修改作者　　修改日期　　　修改目的
*<br>--------------------------------------------------------
*/
public class SYSCA012F extends SuperBean {
    private String id;
    private String referenceId;   // 來精舍之原因代碼
    private String referenceDesc; // 來精舍之原因說明

    private String q_referenceId;
    private String q_referenceDesc;

    @Override
    public void doCreate() throws Exception {
        BaseReferenceDef db_obj = new BaseReferenceDef();
        db_obj.setReferenceId        (referenceId);
        db_obj.setReferenceDesc      (referenceDesc);
        db_obj.setCreateId           (createId);
        db_obj.setCreateDate         (createDate);
        db_obj.setCreateTime         (createTime);
        ServiceGetter.getInstance().getCommonService().save(db_obj);
        setId(db_obj.getId().toString());
    }

    @Override
    public void doUpdate() throws Exception {
        BaseReferenceDef db_obj = (BaseReferenceDef)View.getObject(" From BaseReferenceDef Where id = " + Common.getInt(getId()));
        db_obj.setReferenceId        (referenceId);
        db_obj.setReferenceDesc      (referenceDesc);
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
        ServiceGetter.getInstance().getCommonService().delete(BaseReferenceDef.class, Common.getInt(getId()));
    }

    /**
     * <br>
     * <br>目的：依主鍵查詢單一資料
     * <br>參數：無
     * <br>傳回：傳回本物件
    */
    @Override
    public SYSCA012F doQueryOne() throws Exception {
        SYSCA012F querybean_obj = this;
        BaseReferenceDef db_rec = (BaseReferenceDef)ServiceGetter.getInstance().getCommonService().load(BaseReferenceDef.class, Integer.parseInt(getId()));
        if (db_rec != null) {
            querybean_obj.setReferenceId        (db_rec.getReferenceId());
            querybean_obj.setReferenceDesc      (db_rec.getReferenceDesc());
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
        StringBuilder hql = new StringBuilder().append("From BaseReferenceDef Where 1=1");
        Map<String, Object> maps = new HashMap<String, Object>();
        if (!"".equals(getQ_referenceId())) {
            hql.append(" and referenceId = :referenceId");
            maps.put("referenceId", q_referenceId);
        }
        if (!"".equals(getQ_referenceDesc())) {
            hql.append(" and referenceDesc like :referenceDesc");
            maps.put("referenceDesc", "%" + q_referenceDesc + "%");
        }

        this.processCurrentPageAttribute(ServiceGetter.getInstance().getCommonService().getCommonUserDao().loadCount(hql.toString(), maps));

        if (getTotalRecord() > 0) {
            if (getState().indexOf("query") < 0)
                ServiceGetter.getInstance().getCommonService().clear();
            java.util.List objList = ServiceGetter.getInstance().getCommonService().getCommonUserDao().load(hql.toString(), this.getRecordStart(), this.getPageSize(), "id", true, maps);
            try {
                if (objList != null && objList.size() > 0) {
                    for (int i = 0 ; i < objList.size() ; i++) {
                        BaseReferenceDef db_obj = (BaseReferenceDef)objList.get(i);
                        String       rowArray[] = new String[3];
                        rowArray[0] = Common.get(db_obj.getId());
                        rowArray[1] = Common.get(db_obj.getReferenceId());
                        rowArray[2] = Common.get(db_obj.getReferenceDesc());
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

    public String getReferenceId() {
        return checkGet(referenceId);
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = checkSet(referenceId);
    }

    public String getReferenceDesc() {
        return checkGet(referenceDesc);
    }

    public void setReferenceDesc(String referenceDesc) {
        this.referenceDesc = checkSet(referenceDesc);
    }

    public String getQ_referenceId() {
        return checkGet(q_referenceId);
    }

    public void setQ_referenceId(String q_referenceId) {
        this.q_referenceId = checkSet(q_referenceId);
    }

    public String getQ_referenceDesc() {
        return checkGet(q_referenceDesc);
    }

    public void setQ_referenceDesc(String q_referenceDesc) {
        this.q_referenceDesc = checkSet(q_referenceDesc);
    }

}
