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
@Table(name = "BASE_REFERENCE_DEF")
public class BaseReferenceDef extends BaseModel implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2105733238721648329L;
    private Integer id;
    private String  referenceId;   // 來精舍之原因代碼
    private String  referenceDesc; // 來精舍之原因說明

    public BaseReferenceDef() {
    }

    public BaseReferenceDef(Integer id, String referenceId, String referenceDesc,
            String createId, String createDate, String createTime,
            String updateId, String updateDate, String updateTime,
            String updateIp, String updateUnitShortName) {

        super(createId, createDate, createTime, updateId, updateDate, updateTime,
                updateIp, updateUnitShortName);

        this.id                  = id;
        this.referenceId         = referenceId;
        this.referenceDesc       = referenceDesc;
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
    @SequenceGenerator(name = "id", sequenceName = "BASE_REFERENCE_DEF_SEQ")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "referenceId", length = 5)
    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    @Column(name = "referenceDesc", length = 20)
    public String getReferenceDesc() {
        return referenceDesc;
    }

    public void setReferenceDesc(String referenceDesc) {
        this.referenceDesc = referenceDesc;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("BaseReferenceDef [id = ");
        sb.append(id);
        sb.append(", referenceId = ");
        sb.append(referenceId);
        sb.append(", referenceDesc = ");
        sb.append(referenceDesc);
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
