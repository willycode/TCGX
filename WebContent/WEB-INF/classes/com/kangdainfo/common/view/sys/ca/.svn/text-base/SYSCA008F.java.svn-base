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
import com.kangdainfo.common.model.bo.BaseCenterZone;

import com.kangdainfo.util.DateUtil;

/**
*<br>程式目的：精舍所在區域資料維護作業
*<br>程式代號：SYSCA008F
*<br>程式日期：103.08.29
*<br>程式作者：David Chiu
*<br>--------------------------------------------------------
*<br>修改作者　　修改日期　　　修改目的
*<br>--------------------------------------------------------
*/
public class SYSCA008F extends SuperBean {
    private String id;
    private String zoneId;   // 精舍所在區域流水號
    private String zoneName; // 精舍所在區域名稱
    private String zoneDesc; // 精舍所在區域名稱說明

    private String q_zoneId;
    private String q_zoneName;

    @Override
    public void doCreate() throws Exception {
        BaseCenterZone db_obj = new BaseCenterZone();
        db_obj.setZoneId    (Short.parseShort(zoneId));
        db_obj.setZoneName  (zoneName);
        db_obj.setZoneDesc  (zoneDesc);
        db_obj.setCreateId  (createId);
        db_obj.setCreateDate(createDate);
        db_obj.setCreateTime(createTime);
        ServiceGetter.getInstance().getCommonService().save(db_obj);
        setId(db_obj.getId().toString());
    }

    @Override
    public void doUpdate() throws Exception {
        BaseCenterZone db_obj = (BaseCenterZone)View.getObject(" From BaseCenterZone Where id = " + Common.getInt(getId()));
        db_obj.setZoneId    (Short.parseShort(zoneId));
        db_obj.setZoneName  (zoneName);
        db_obj.setZoneDesc  (zoneDesc);
        db_obj.setUpdateId  (updateId);
        db_obj.setUpdateDate(updateDate);
        db_obj.setUpdateTime(updateTime);
        db_obj.setUpdateIp  (updateIp);
        db_obj.setUpdateUnitShortName(updateUnitShortName);
        ServiceGetter.getInstance().getCommonService().save(db_obj);
        setId(db_obj.getId().toString());
    }

    @Override
    public void doDelete() throws Exception {
        ServiceGetter.getInstance().getCommonService().delete(BaseCenterZone.class, Common.getInt(getId()));
    }

    /**
     * <br>
     * <br>目的：依主鍵查詢單一資料
     * <br>參數：無
     * <br>傳回：傳回本物件
    */
    @Override
    public SYSCA008F doQueryOne() throws Exception {
        SYSCA008F querybean_obj = this;
        BaseCenterZone   db_rec = (BaseCenterZone)ServiceGetter.getInstance().getCommonService().load(BaseCenterZone.class, Integer.parseInt(getId()));
        if (db_rec != null) {
            querybean_obj.setZoneId    (Short.toString(db_rec.getZoneId()));
            querybean_obj.setZoneName  (db_rec.getZoneName());
            querybean_obj.setZoneDesc  (db_rec.getZoneDesc());
            querybean_obj.setCreateId  (db_rec.getCreateId());
            querybean_obj.setCreateDate(db_rec.getCreateDate());
            querybean_obj.setCreateTime(db_rec.getCreateTime());
            querybean_obj.setUpdateId  (db_rec.getUpdateId());
            querybean_obj.setUpdateDate(db_rec.getUpdateDate());
            querybean_obj.setUpdateTime(db_rec.getUpdateTime());
            querybean_obj.setUpdateIp  (db_rec.getUpdateIp());
            querybean_obj.setUpdateUnitShortName(db_rec.getUpdateUnitShortName());
        } else throw new Exception("查無該筆資料！");
            return querybean_obj;
    }

    @Override
    public java.util.ArrayList<String[]> doQueryAll() throws Exception {
        java.util.ArrayList<String[]> arrList = new java.util.ArrayList<String[]>();
        StringBuilder hql = new StringBuilder().append("From BaseCenterZone Where 1=1");
        Map<String, Object> maps = new HashMap<String, Object>();

        if (!"".equals(getQ_zoneId())) {
            hql.append(" and zoneId = :zoneId ");
            maps.put("zoneId", Short.parseShort(q_zoneId));
        }

        if (!"".equals(getQ_zoneName())) {
            hql.append(" and zoneName like :zoneName ");
            maps.put("zoneName", "%" + q_zoneName + "%");
        }

        this.processCurrentPageAttribute(ServiceGetter.getInstance().getCommonService().getCommonUserDao().loadCount(hql.toString(), maps));

        if (getTotalRecord() > 0) {
            if (getState().indexOf("query") < 0)
                ServiceGetter.getInstance().getCommonService().clear();

            java.util.List objList = ServiceGetter.getInstance().getCommonService().getCommonUserDao().load(hql.toString(), this.getRecordStart(), this.getPageSize(), "id", true, maps);
            try {
                if (objList != null && objList.size() > 0) {
                    for (int i = 0 ; i < objList.size() ; i++) {
                        BaseCenterZone db_obj = (BaseCenterZone)objList.get(i);
                        String     rowArray[] = new String[4];
                        rowArray[0] = Common.get(db_obj.getId());
                        rowArray[1] = Common.get(db_obj.getZoneId());
                        rowArray[2] = Common.get(db_obj.getZoneName());
                        rowArray[3] = Common.get(db_obj.getZoneDesc());
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

    public String getZoneId() {
        return checkGet(zoneId);
    }

    public void setZoneId(String zoneId) {
        this.zoneId = checkSet(zoneId);
    }

    public String getZoneName() {
        return checkGet(zoneName);
    }

    public void setZoneName(String zoneName) {
        this.zoneName = checkSet(zoneName);
    }

    public String getZoneDesc() {
        return checkGet(zoneDesc);
    }

    public void setZoneDesc(String zoneDesc) {
        this.zoneDesc = checkSet(zoneDesc);
    }

    public String getQ_zoneId() {
        return checkGet(q_zoneId);
    }

    public void setQ_zoneId(String q_zoneId) {
        this.q_zoneId = checkSet(q_zoneId);
    }

    public String getQ_zoneName() {
        return checkGet(q_zoneName);
    }

    public void setQ_zoneName(String q_zoneName) {
        this.q_zoneName = checkSet(q_zoneName);
    }

}
