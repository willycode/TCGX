package com.kangdainfo.common.model.bo;

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
@Table(name = "BASE_CENTER_ZONE")
public class BaseCenterZone extends BaseModel implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2105733238721648329L;
    private Integer id;
    private Short   zoneId;   // 精舍所在區域流水號
    private String  zoneName; // 精舍所在區域名稱
    private String  zoneDesc; // 精舍所在區域名稱的說明

    public BaseCenterZone() {
    }

    public BaseCenterZone(Integer id, Short zoneId, String zoneName, String zoneDesc,
            String createId, String createDate, String createTime,
            String updateId, String updateDate, String updateTime,
            String updateIp, String updateUnitShortName) {

        super(createId, createDate, createTime, updateId, updateDate, updateTime,
                updateIp, updateUnitShortName);

        this.id                    = id;
        this.zoneId                = zoneId;
        this.zoneName              = zoneName;
        this.zoneDesc              = zoneDesc;
        this.createId              = createId;
        this.createDate            = createDate;
        this.createTime            = createTime;
        this.updateId              = updateId;
        this.updateDate            = updateDate;
        this.updateTime            = updateTime;
        this.updateIp              = updateIp;
        this.updateUnitShortName = updateUnitShortName;
    }

    @Id
    @Column(name = "Id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "id", sequenceName = "BASE_CENTER_ZONE_SEQ")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "zoneId")
    public Short getZoneId() {
        return zoneId;
    }

    public void setZoneId(Short zoneId) {
        this.zoneId = zoneId;
    }

    @Column(name = "zoneName" ,length = 20)
    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    @Column(name = "zoneDesc" ,length = 50)
    public String getZoneDesc() {
        return zoneDesc;
    }

    public void setZoneDesc(String zoneDesc) {
        this.zoneDesc = zoneDesc;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("BaseCenterZone [id = ");
        sb.append(id);
        sb.append(", zoneId = ");
        sb.append(zoneId);
        sb.append(", zoneName = ");
        sb.append(zoneName);
        sb.append(", zoneDesc = ");
        sb.append(zoneDesc);
        sb.append(", createId = ");
        sb.append(createId);
        sb.append(", createDate = ");
        sb.append(createDate);
        sb.append(", createTime = ");
        sb.append(createTime);
        sb.append(", updateId = ");
        sb.append(updateId);
        sb.append(", updateDate = ");
        sb.append(updateDate);
        sb.append(", updateTime = ");
        sb.append(updateTime);
        sb.append(", updateIp = ");
        sb.append(updateIp);
        sb.append(", updateUnitShortName = ");
        sb.append(updateUnitShortName);
        sb.append("]");
        return sb.toString();
    }
}
