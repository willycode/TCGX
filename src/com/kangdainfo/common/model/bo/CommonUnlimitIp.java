package com.kangdainfo.common.model.bo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "COMMON_UNLIMIT_IP")
public class CommonUnlimitIp extends BaseModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 177493335576045304L;
	/**
	 * 
	 */
	
	private Integer id;
	private String startIp;
	private String endIp;
	private String ipMemo;

	public CommonUnlimitIp() {
	}
	public CommonUnlimitIp(Integer id) {
		this.id = id;
		
	}

	public CommonUnlimitIp(String endIp,String startIp,String updateUnitShortName,String updateIp,String updateTime,String updateDate,String updateId,String ipMemo,String ip,String createTime,String createDate,String createId,String editTime,String editDate,String editIp,String editId,Integer id
			) {
		this.ipMemo=ipMemo;
		this.id = id;
		this.endIp=endIp;
		this.startIp=startIp;
		this.updateId=updateId;
		this.updateDate=updateDate;
		this.updateTime=updateTime;
		this.updateIp=updateIp;
		this.updateUnitShortName=updateUnitShortName;
		this.createId=createId;
		this.createDate=createDate;
		this.createTime=createTime;

	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@SequenceGenerator(name="id", sequenceName = "COMMON_UNLIMIT_IP_SEQ")	
	@Column(name = "id", unique = true, nullable = false)
		public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "startIp", length = 40)
	public String getStartIp() {
		return startIp;
	}


	public void setStartIp(String startIp) {
		this.startIp = startIp;
	}
	@Column(name = "endIp", length = 40)
	public String getEndIp() {
		return endIp;
	}


	public void setEndIp(String endIp) {
		this.endIp = endIp;
	}
	@Column(name = "ip_Memo", length = 200)
	public String getIpMemo() {
		return ipMemo;
	}


	public void setIpMemo(String ipMemo) {
		this.ipMemo = ipMemo;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CommonUnlimitIp [id=");
		builder.append(id);
		builder.append(", startIp=");
		builder.append(startIp);
		builder.append(", endIp=");
		builder.append(endIp);
		builder.append(", ipMemo=");
		builder.append(ipMemo);
		builder.append(", createId=");
		builder.append(createId);
		builder.append(", createDate=");
		builder.append(createDate);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", updateId=");
		builder.append(updateId);
		builder.append(", updateDate=");
		builder.append(updateDate);
		builder.append(", updateTime=");
		builder.append(updateTime);
		builder.append(", updateIp=");
		builder.append(updateIp);
		builder.append(", updateUnitShortName=");
		builder.append(updateUnitShortName);
		builder.append("]");
		return builder.toString();
	}

	

}
