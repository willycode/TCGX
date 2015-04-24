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
@Table(name = "BASE_CHAN_CAT_DEF")
public class BaseChanCatDef extends BaseModel implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2105733238721648329L;
    private Integer id;
    private String  chanCatId;          // 禪修班代碼
    private String  chanCatName;        // 禪修班名稱
    private String  chanCatEngName;     // 禪修班英文名稱
    private String  chanCatBookSeq;     // 指定教材序號
    private String  chanCatBookName;    // 指定教材名稱
    private String  chanCatBookEngName; // 指定教材英文名稱

    public BaseChanCatDef() {
    }

    public BaseChanCatDef(Integer id,
            String chanCatId,      String chanCatName,     String chanCatEngName,
            String chanCatBookSeq, String chanCatBookName, String chanCatBookEngName,
            String createId,       String createDate,      String createTime,
            String updateId,       String updateDate,      String updateTime,
            String updateIp,       String updateUnitShortName) {

        super(createId, createDate, createTime, updateId, updateDate, updateTime,
                updateIp, updateUnitShortName);

        this.id                  = id;
        this.chanCatId           = chanCatId;
        this.chanCatName         = chanCatName;
        this.chanCatEngName      = chanCatEngName;
        this.chanCatBookSeq      = chanCatBookSeq;
        this.chanCatBookName     = chanCatBookName;
        this.chanCatBookEngName  = chanCatBookEngName;
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
    @SequenceGenerator(name = "id", sequenceName = "BASE_CHAN_CAT_DEF_SEQ")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "chanCatId", length = 5)
    public String getChanCatId() {
        return chanCatId;
    }

    public void setChanCatId(String chanCatId) {
        this.chanCatId = chanCatId;
    }

    @Column(name = "chanCatName", length = 10)
    public String getChanCatName() {
        return chanCatName;
    }

    public void setChanCatName(String chanCatName) {
        this.chanCatName = chanCatName;
    }

    @Column(name = "chanCatEngName", length = 50)
    public String getChanCatEngName() {
        return chanCatEngName;
    }

    public void setChanCatEngName(String chanCatEngName) {
        this.chanCatEngName = chanCatEngName;
    }

    @Column(name = "chanCatBookSeq", length = 5)
    public String getChanCatBookSeq() {
        return chanCatBookSeq;
    }

    public void setChanCatBookSeq(String chanCatBookSeq) {
        this.chanCatBookSeq = chanCatBookSeq;
    }

    @Column(name = "chanCatBookName", length = 20)
    public String getChanCatBookName() {
        return chanCatBookName;
    }

    public void setChanCatBookName(String chanCatBookName) {
        this.chanCatBookName = chanCatBookName;
    }

    @Column(name = "chanCatBookEngName", length = 50)
    public String getChanCatBookEngName() {
        return chanCatBookEngName;
    }

    public void setChanCatBookEngName(String chanCatBookEngName) {
        this.chanCatBookEngName = chanCatBookEngName;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("BaseChanCatDef [id = ");
        sb.append(id);
        sb.append(", chanCatId = ");
        sb.append(chanCatId);
        sb.append(", chanCatName = ");
        sb.append(chanCatName);
        sb.append(", chanCatEngName = ");
        sb.append(chanCatEngName);
        sb.append(", chanCatBookSeq = ");
        sb.append(chanCatBookSeq);
        sb.append(", chanCatBookName = ");
        sb.append(chanCatBookName);
        sb.append(", chanCatBookEngName = ");
        sb.append(chanCatBookEngName);
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
