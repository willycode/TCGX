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
@Table(name = "BASE_COUNTRY_DEF")
public class BaseCountryDef extends BaseModel implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2105733238721648329L;
    private Integer id;
    private String  countryId;          // 各國之英文國名簡稱
    private String  countryChineseName; // 各國之中文國名
    private String  countryEnglishName; // 各國之英文國名
    private String  countryTelCode;     // 各國之國家電信代碼

    public BaseCountryDef() {
    }

    public BaseCountryDef(Integer id, String countryId, String countryChineseName,
            String countryEnglishName, String countryTelCode,
            String createId, String createDate, String createTime,
            String updateId, String updateDate, String updateTime,
            String updateIp, String updateUnitShortName) {

        super(createId, createDate, createTime, updateId, updateDate, updateTime,
                updateIp, updateUnitShortName);

        this.id                  = id;
        this.countryId           = countryId;
        this.countryChineseName  = countryChineseName;
        this.countryEnglishName  = countryEnglishName;
        this.countryTelCode      = countryTelCode;
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
    @SequenceGenerator(name = "id", sequenceName = "BASE_COUNTRY_DEF_SEQ")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "countryId", length = 5)
    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    @Column(name = "countryChineseName", length = 20)
    public String getCountryChineseName() {
        return countryChineseName;
    }

    public void setCountryChineseName(String countryChineseName) {
        this.countryChineseName = countryChineseName;
    }

    @Column(name = "countryEnglishName", length = 30)
    public String getCountryEnglishName() {
        return countryEnglishName;
    }

    public void setCountryEnglishName(String countryEnglishName) {
        this.countryEnglishName = countryEnglishName;
    }

    @Column(name = "countryTelCode", length = 3)
    public String getCountryTelCode() {
        return countryTelCode;
    }

    public void setCountryTelCode(String countryTelCode) {
        this.countryTelCode = countryTelCode;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("BaseCountryDef [id = ");
        sb.append(id);
        sb.append(", countryId = ");
        sb.append(countryId);
        sb.append(", countryChineseName = ");
        sb.append(countryChineseName);
        sb.append(", countryEnglishName = ");
        sb.append(countryEnglishName);
        sb.append(", countryTelCode = ");
        sb.append(countryTelCode);
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
