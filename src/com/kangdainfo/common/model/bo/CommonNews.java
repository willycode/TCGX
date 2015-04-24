package com.kangdainfo.common.model.bo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * CommonNews generated by hbm2java
 */
@Entity
@Table(name = "COMMON_NEWS")
public class CommonNews extends BaseModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1735198435069297292L;
	private Integer id;
	private CommonCode commonCode;
	private String subject;
	private String content;
	private String startDate;
	private String endDate;
	private String isHtml;
	private String isOpen;
	private String itemPicture1;
	private String itemPicture2;
	private String itemPicture3;
	private String itemPicture4;
	private String itemPicture5;
	private String itemPicture6;
	private String itemPicture7;
	private String itemPicture8;
	private String itemPicture9;
	private String itemPicture10;
	private Set<CommonNewsLog> commonNewslogs = new HashSet<CommonNewsLog>(0);

	public CommonNews() {
	}

	public CommonNews(Integer id) {
		this.id = id;
	}

	public CommonNews(Integer id, CommonCode commonCode, String subject,
			String content, String startDate, String endDate, String isHtml,
			String isOpen, String itemPicture1, String itemPicture2,
			String itemPicture3, String itemPicture4, String itemPicture5,
			String itemPicture6, String itemPicture7, String itemPicture8,
			String itemPicture9, String itemPicture10, String editId,
			String editDate, String editTime, Set<CommonNewsLog> commonNewslogs) {
		this.id = id;
		this.commonCode = commonCode;
		this.subject = subject;
		this.content = content;
		this.startDate = startDate;
		this.endDate = endDate;
		this.isHtml = isHtml;
		this.isOpen = isOpen;
		this.itemPicture1 = itemPicture1;
		this.itemPicture2 = itemPicture2;
		this.itemPicture3 = itemPicture3;
		this.itemPicture4 = itemPicture4;
		this.itemPicture5 = itemPicture5;
		this.itemPicture6 = itemPicture6;
		this.itemPicture7 = itemPicture7;
		this.itemPicture8 = itemPicture8;
		this.itemPicture9 = itemPicture9;
		this.itemPicture10 = itemPicture10;
		this.commonNewslogs = commonNewslogs;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	@SequenceGenerator(name="id", sequenceName = "COMMON_NEWS_SEQ")		
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "masterId")
	public CommonCode getCommonCode() {
		return this.commonCode;
	}

	public void setCommonCode(CommonCode commonCode) {
		this.commonCode = commonCode;
	}

	@Column(name = "subject", length = 50)
	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Column(name = "content", length = 1000)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "startDate", length = 7)
	public String getStartDate() {
		return this.startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	@Column(name = "endDate", length = 7)
	public String getEndDate() {
		return this.endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Column(name = "isHTML", length = 1)
	public String getIsHtml() {
		return this.isHtml;
	}

	public void setIsHtml(String isHtml) {
		this.isHtml = isHtml;
	}

	@Column(name = "isOpen", length = 1)
	public String getIsOpen() {
		return this.isOpen;
	}

	public void setIsOpen(String isOpen) {
		this.isOpen = isOpen;
	}

	@Column(name = "itemPicture1", length = 300)
	public String getItemPicture1() {
		return this.itemPicture1;
	}

	public void setItemPicture1(String itemPicture1) {
		this.itemPicture1 = itemPicture1;
	}

	@Column(name = "itemPicture2", length = 300)
	public String getItemPicture2() {
		return this.itemPicture2;
	}

	public void setItemPicture2(String itemPicture2) {
		this.itemPicture2 = itemPicture2;
	}

	@Column(name = "itemPicture3", length = 300)
	public String getItemPicture3() {
		return this.itemPicture3;
	}

	public void setItemPicture3(String itemPicture3) {
		this.itemPicture3 = itemPicture3;
	}

	@Column(name = "itemPicture4", length = 300)
	public String getItemPicture4() {
		return this.itemPicture4;
	}

	public void setItemPicture4(String itemPicture4) {
		this.itemPicture4 = itemPicture4;
	}

	@Column(name = "itemPicture5", length = 300)
	public String getItemPicture5() {
		return this.itemPicture5;
	}

	public void setItemPicture5(String itemPicture5) {
		this.itemPicture5 = itemPicture5;
	}

	@Column(name = "itemPicture6", length = 300)
	public String getItemPicture6() {
		return this.itemPicture6;
	}

	public void setItemPicture6(String itemPicture6) {
		this.itemPicture6 = itemPicture6;
	}

	@Column(name = "itemPicture7", length = 300)
	public String getItemPicture7() {
		return this.itemPicture7;
	}

	public void setItemPicture7(String itemPicture7) {
		this.itemPicture7 = itemPicture7;
	}

	@Column(name = "itemPicture8", length = 300)
	public String getItemPicture8() {
		return this.itemPicture8;
	}

	public void setItemPicture8(String itemPicture8) {
		this.itemPicture8 = itemPicture8;
	}

	@Column(name = "itemPicture9", length = 300)
	public String getItemPicture9() {
		return this.itemPicture9;
	}

	public void setItemPicture9(String itemPicture9) {
		this.itemPicture9 = itemPicture9;
	}

	@Column(name = "itemPicture10", length = 300)
	public String getItemPicture10() {
		return this.itemPicture10;
	}

	public void setItemPicture10(String itemPicture10) {
		this.itemPicture10 = itemPicture10;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "commonNews")
	public Set<CommonNewsLog> getCommonNewslogs() {
		return this.commonNewslogs;
	}

	public void setCommonNewslogs(Set<CommonNewsLog> commonNewslogs) {
		this.commonNewslogs = commonNewslogs;
	}

}
