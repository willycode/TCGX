package com.kangdainfo.common.model.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * 共用取號檔<br>
 * @author shark
 */
@Entity
@Table(name = "COMMON_SEQ")
public class CommonSeq implements Serializable {
	
	private static final long serialVersionUID = 1941620348083125971L;
	private String id;
	private Long seqNo;
    private String editId;
    private String editDate;
    private String editTime;

	@Id
	@Column(name = "id", unique = true, nullable = false)    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "seqNo", nullable = false)
	public Long getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Long seqNo) {
		this.seqNo = seqNo;
	}

	@Column(name = "editId", length = 50)
	public String getEditId() {
		return this.editId;
	}

	public void setEditId(String editId) {
		this.editId = editId;
	}

	@Column(name = "editDate", length = 7)
	public String getEditDate() {
		return this.editDate;
	}

	public void setEditDate(String editDate) {
		this.editDate = editDate;
	}

	@Column(name = "editTime", length = 6)
	public String getEditTime() {
		return this.editTime;
	}

	public void setEditTime(String editTime) {
		this.editTime = editTime;
	}

	public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof CommonSeq) ) return false;
        CommonSeq castOther = (CommonSeq) other;
        return new EqualsBuilder()
            .append(this.getId(), castOther.getId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getId())
            .toHashCode();
    }    

}
