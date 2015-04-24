package com.kangdainfo.ctis.model.bo;

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
@Table(name = "CENTER_USAGE")
public class CenterUsage extends BaseModel implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2105733238721648329L;
    private Integer id;
    private String  usageDate;      // 精舍之使用日期
    private String  usageTime;      // 精舍之使用時間
    private String  unitId;         // 使用精舍之單位代號
    private String  unitShortName;  // 使用精舍之單位簡稱
    private String  centerMemberId; // 使用精舍之精舍學員代號
    private String  aliasName;      // 使用精舍之精舍學員化名
    private String  usageNote;      // 精舍之使用說明

    public CenterUsage() {
    }

    public CenterUsage(Integer id, String usageDate,  String usageTime,
            String unitId,         String unitShortName,
            String centerMemberId, String aliasName,  String usageNote,
            String createId,       String createDate, String createTime,
            String updateId,       String updateDate, String updateTime,
            String updateIp,       String updateUnitShortName) {

        super(createId, createDate, createTime, updateId, updateDate, updateTime,
                updateIp, updateUnitShortName);

        this.id                  = id;
        this.usageDate           = usageDate;
        this.usageTime           = usageTime;
        this.unitId              = unitId;
        this.unitShortName       = unitShortName;
        this.centerMemberId      = centerMemberId;
        this.aliasName           = aliasName;
        this.usageNote           = usageNote;
        this.createId            = createId;
        this.createDate          = createDate;
        this.createTime          = createTime;
        this.updateId            = updateId;
        this.updateDate          = updateDate;
        this.updateTime          = updateTime;
        this.updateIp            = updateIp;
        this.updateUnitShortName = updateUnitShortName;
    }

    @Id
    @Column(name = "Id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "id", sequenceName = "CENTER_USAGE_SEQ")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "usageDate" ,length = 7)
    public String getUsageDate() {
        return usageDate;
    }

    public void setUsageDate(String usageDate) {
        this.usageDate = usageDate;
    }

    @Column(name = "usageTime" ,length = 6)
    public String getUsageTime() {
        return usageTime;
    }

    public void setUsageTime(String usageTime) {
        this.usageTime = usageTime;
    }

    @Column(name = "unitId" ,length = 4)
    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    @Column(name = "unitShortName" ,length = 10)
    public String getUnitShortName() {
        return unitShortName;
    }

    public void setUnitShortName(String unitShortName) {
        this.unitShortName = unitShortName;
    }

    @Column(name = "centerMemberId" ,length = 11)
    public String getCenterMemberId() {
        return centerMemberId;
    }

    public void setCenterMemberId(String centerMemberId) {
        this.centerMemberId = centerMemberId;
    }

    @Column(name = "aliasName" ,length = 60)
    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    @Column(name = "usageNote" ,length = 500)
    public String getUsageNote() {
        return usageNote;
    }

    public void setUsageNote(String usageNote) {
        this.usageNote = usageNote;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("CenterUsage [id = ");
        sb.append(id);
        sb.append(", usageDate = ");
        sb.append(usageDate);
        sb.append(", usageTime = ");
        sb.append(usageTime);
        sb.append(", unitId = ");
        sb.append(unitId);
        sb.append(", unitShortName = ");
        sb.append(unitShortName);
        sb.append(", centerMemberId = ");
        sb.append(centerMemberId);
        sb.append(", aliasName = ");
        sb.append(aliasName);
        sb.append(", usageNote = ");
        sb.append(usageNote);
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
