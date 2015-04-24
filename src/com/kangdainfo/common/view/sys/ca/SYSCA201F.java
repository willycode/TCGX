package com.kangdainfo.common.view.sys.ca;

import java.util.ArrayList;

import com.kangdainfo.ServiceGetter;
import com.kangdainfo.common.model.bo.CommonCatalog;
import com.kangdainfo.common.model.bo.CommonCode;
import com.kangdainfo.common.model.bo.CommonCodeKind;
import com.kangdainfo.common.util.Common;
import com.kangdainfo.common.util.SuperBean;
import com.kangdainfo.common.util.View;

public class SYSCA201F extends SuperBean {
	private String id;
	
	private String catalogId;
	private String codeKindId;
	private String codeKindName;
	private String memoLabel;
	private String codeLabelCon1;
	private String codeLabelCon2;
	private String codeLabelCon3;
	
	private String qry_catalogId;
	private String qry_codeKindId;
	private String qry_codeKindName;
	
	@Override
	public ArrayList doQueryAll() throws Exception {
		java.util.ArrayList<String[]> arrList = new java.util.ArrayList<String[]>();
		java.util.Map<String, Object> maps = new java.util.HashMap<String, Object>();
		
		StringBuffer hql = new StringBuffer();
		
		hql.append("from CommonCodeKind where 1=1");
		if(!"".equals(getQry_catalogId())){
			hql.append(" and commonCatalog.id = :catalogId");
			maps.put("catalogId", Common.getInteger(qry_catalogId));
		}
		if(!"".equals(getQry_codeKindId())){
			hql.append(" and codeKindId = :codeKindId");
			maps.put("codeKindId", qry_codeKindId);
		}
		if(!"".equals(getQry_codeKindName())){
			hql.append(" and codeKindName like :codeKindName");
			maps.put("codeKindName", "%" + qry_codeKindName + "%");
		}
		System.out.println("SYSCA201F 查詢語法 == " + hql.toString());
		System.out.println("SYSCA201F maps == " + maps);
		this.processCurrentPageAttribute(ServiceGetter.getInstance().getCommonService().loadCount(hql.toString(), maps));
		if(getTotalRecord() > 0){
			if(getState().indexOf("query") < 0){
				ServiceGetter.getInstance().getCommonService().clear();
			}
			
			java.util.List objList = ServiceGetter.getInstance().getCommonService().load(hql.toString(), this.getRecordStart(), this.getPageSize(), maps);
			if(objList != null && objList.size() > 0){	
				for(Object obj : objList){
					CommonCodeKind o = (CommonCodeKind)obj;
					String[] rowArray = new String[4];
					rowArray[0] = Common.get(o.getId());
					rowArray[1] = Common.get(o.getCommonCatalog() != null ? o.getCommonCatalog().getCatalogName():"");
					rowArray[2] = Common.get(o.getCodeKindId());
					rowArray[3] = Common.get(o.getCodeKindName());
					arrList.add(rowArray);
				}
			}
		}
		return arrList;
	}

	@Override
	public Object doQueryOne() throws Exception {
		SYSCA201F obj = this;
		CommonCodeKind c = (CommonCodeKind)View.getObject("from CommonCodeKind where id = " + Common.getInteger(getId()));
		if(c != null){
			obj.setCatalogId(Common.get(c.getCommonCatalog() != null ? c.getCommonCatalog().getId() : ""));
			obj.setCodeKindId(Common.get(c.getCodeKindId()));
			obj.setCodeKindName(Common.get(c.getCodeKindName()));
			
		}
		return obj;
	}
	
	protected String[][] getInsertCheckSQL(){	
		String[][] checkSQLArray = new String[1][4];
	 	checkSQLArray[0][0]="select count(*) from CommonCodeKind where codeKindId=" + Common.sqlChar(getCodeKindId());
		checkSQLArray[0][1]=">";
		checkSQLArray[0][2]="0";
		checkSQLArray[0][3]="該筆類別編號已重複，請重新輸入！";
		return checkSQLArray;
	}	
	
	@Override
	public void doCreate() throws Exception {
		CommonCatalog parent = (CommonCatalog)View.getObject("from CommonCatalog where id = " + Common.getInt(getCatalogId()));
		if(parent != null){
			CommonCodeKind obj = new CommonCodeKind();
			obj.setCommonCatalog(parent);
			obj.setCodeKindId(codeKindId);
			obj.setCodeKindName(codeKindName);
			
			obj.setCreateId(createId);
			obj.setCreateDate(createDate);
			obj.setCreateTime(createTime);
			obj.setUpdateId(updateId);
		    obj.setUpdateDate(updateDate);
			obj.setUpdateTime(updateTime);
			obj.setUpdateIp(updateIp);
			obj.setUpdateUnitShortName(updateUnitShortName);
			
			ServiceGetter.getInstance().getCommonService().save(obj);
			setId(Common.get(obj.getId()));
		}
		else {
			throw new Exception("查無類別種類物件，請查明!!");
		}
	}

	public String[][] getUpdateCheckSQL(){	
		String[][] checkSQLArray = new String[1][4];
	 	checkSQLArray[0][0]="select count(*) from CommonCodeKind where id != " + Common.getInt(getId())
	 						+ " and codeKindId =" + Common.sqlChar(getCodeKindId());
		checkSQLArray[0][1]=">";
		checkSQLArray[0][2]="0";
		checkSQLArray[0][3]="該筆類別編號已重複，請重新輸入！";
		return checkSQLArray;
	}	
	
	@Override
	public void doUpdate() throws Exception {
		CommonCodeKind obj = (CommonCodeKind)View.getObject("from CommonCodeKind where id = " + Common.getInt(getId()));
		if(obj != null){
			obj.setCodeKindId(codeKindId);
			obj.setCodeKindName(codeKindName);
			
			obj.setUpdateId(updateId);
			obj.setUpdateDate(updateDate);
			obj.setUpdateTime(updateTime);
			obj.setUpdateIp(updateIp);
			obj.setUpdateUnitShortName(updateUnitShortName);
	
			ServiceGetter.getInstance().getCommonService().update(obj);
		}
	}
	
	@Override
	public void doDelete() throws Exception {
		CommonCodeKind obj = (CommonCodeKind)View.getObject("from CommonCodeKind where id = " + Common.getInteger(getId()));
		if(obj != null){
			ServiceGetter.getInstance().getCommonService().delete(obj);
		}
	}

	public String getId() {
		return checkGet(id);
	}

	public void setId(String id) {
		this.id = checkSet(id);
	}

	public String getCatalogId() {
		return checkGet(catalogId);
	}

	public void setCatalogId(String catalogId) {
		this.catalogId = checkSet(catalogId);
	}

	public String getCodeKindId() {
		return checkGet(codeKindId);
	}

	public void setCodeKindId(String codeKindId) {
		this.codeKindId = checkSet(codeKindId);
	}

	public String getCodeKindName() {
		return checkGet(codeKindName);
	}

	public void setCodeKindName(String codeKindName) {
		this.codeKindName = checkSet(codeKindName);
	}

	public String getMemoLabel() {
		return checkGet(memoLabel);
	}

	public void setMemoLabel(String memoLabel) {
		this.memoLabel = checkSet(memoLabel);
	}

	public String getCodeLabelCon1() {
		return checkGet(codeLabelCon1);
	}

	public void setCodeLabelCon1(String codeLabelCon1) {
		this.codeLabelCon1 = checkSet(codeLabelCon1);
	}

	public String getCodeLabelCon2() {
		return checkGet(codeLabelCon2);
	}

	public void setCodeLabelCon2(String codeLabelCon2) {
		this.codeLabelCon2 = checkSet(codeLabelCon2);
	}

	public String getCodeLabelCon3() {
		return checkGet(codeLabelCon3);
	}

	public void setCodeLabelCon3(String codeLabelCon3) {
		this.codeLabelCon3 = checkSet(codeLabelCon3);
	}

	public String getQry_catalogId() {
		return checkGet(qry_catalogId);
	}

	public void setQry_catalogId(String qryCatalogId) {
		qry_catalogId = checkSet(qryCatalogId);
	}

	public String getQry_codeKindId() {
		return checkGet(qry_codeKindId);
	}

	public void setQry_codeKindId(String qryCodeKindId) {
		qry_codeKindId = checkSet(qryCodeKindId);
	}

	public String getQry_codeKindName() {
		return checkGet(qry_codeKindName);
	}

	public void setQry_codeKindName(String qryCodeKindName) {
		qry_codeKindName = checkSet(qryCodeKindName);
	}


	
}
