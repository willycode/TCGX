package com.kangdainfo.common.view.sys.ca;

import com.kangdainfo.ServiceGetter;
import com.kangdainfo.common.model.bo.CommonCodeKind;
import com.kangdainfo.common.util.Common;
import com.kangdainfo.common.util.SuperBean;
import com.kangdainfo.common.util.View;


/**
 * 共用代碼檔維護作業
 * 
 * TABLE = CommonCodeKind 
 * @author clive.chang 
 *
 */
public class SYSCA003F extends SuperBean {
	String id;
    String codeKindId;
    String codeKindName;

	public String getId(){ return checkGet(id); }
	public void setId(String s){ id=checkSet(s); }	
	public String getCodeKindName(){ return checkGet(codeKindName); }
	public void setCodeKindName(String s){ codeKindName=checkSet(s); }		
	public String getCodeKindId() {		return checkGet(codeKindId);	}
	public void setCodeKindId(String codeKindId) {		this.codeKindId = checkSet(codeKindId);	}

	String codeLabelCon1;
	String codeLabelCon2;
	String codeLabelCon3;
	String memoLabel;
	String codeMaxLen;
	
	public String getCodeLabelCon1() {	return checkGet(codeLabelCon1);	}
	public void setCodeLabelCon1(String codeLabelCon1) {this.codeLabelCon1 = checkSet(codeLabelCon1);	}
	public String getCodeLabelCon2() {return checkGet(codeLabelCon2);	}
	public void setCodeLabelCon2(String codeLabelCon2) {this.codeLabelCon2 = checkSet(codeLabelCon2);	}
	public String getCodeLabelCon3() {return checkGet(codeLabelCon3);	}
	public void setCodeLabelCon3(String codeLabelCon3) {this.codeLabelCon3 = checkSet(codeLabelCon3);	}
	public String getMemoLabel() {return checkGet(memoLabel);	}
	public void setMemoLabel(String s) {this.memoLabel = checkSet(s);	}
	public String getCodeMaxLen() {		return checkGet(codeMaxLen);	}
	public void setCodeMaxLen(String codeMaxLen) {		this.codeMaxLen = checkSet(codeMaxLen);	}
		
    String q_codeKindId;
    String q_codeKindName;

	public String getQ_codeKindId() {		return checkGet(q_codeKindId);	}
	public void setQ_codeKindId(String q_codeKindId) {		this.q_codeKindId = checkSet(q_codeKindId);	}
	public String getQ_codeKindName() {		return checkGet(q_codeKindName);	}
	public void setQ_codeKindName(String q_codeKindName) {		this.q_codeKindName = checkSet(q_codeKindName);	}

	String popId;
	String popCodeName;
	String popCode;
	String popKind;
	String js;
	String conField;
	String engName;
	String preWord;
	String preCon1;
	String preCon2;
	String preCon3;	
	public String getPopId(){ return checkGet(popId); }
	public void setPopId(String s){ popId=checkSet(s); }
	public String getPopCodeName(){ return checkGet(popCodeName); }
	public void setPopCodeName(String s){ popCodeName=checkSet(s); }
	public String getPopCode(){ return checkGet(popCode); }
	public void setPopCode(String s){ popCode=checkSet(s); }
	public String getPopKind(){ return checkGet(popKind); }
	public void setPopKind(String s){ popKind=checkSet(s); }
	public String getJs(){ return checkGet(js); }
	public void setJs(String s){ js=checkSet(s); }
	public String getConField(){ return checkGet(conField); }
	public void setConField(String s){ conField=checkSet(s); }
	public String getEngName(){ return checkGet(engName); }
	public void setEngName(String s){ engName=checkSet(s); }
	public String getPreWord(){ return checkGet(preWord); }
	public void setPreWord(String s){ preWord=checkSet(s); }
	public String getPreCon1(){ return checkGet(preCon1); }
	public void setPreCon1(String s){ preCon1=checkSet(s); }
	public String getPreCon2(){ return checkGet(preCon2); }
	public void setPreCon2(String s){ preCon2=checkSet(s); }
	public String getPreCon3(){ return checkGet(preCon3); }
	public void setPreCon3(String s){ preCon3=checkSet(s); }
	
	protected String[][] getInsertCheckSQL(){	
		String[][] checkSQLArray = new String[1][4];
	 	checkSQLArray[0][0]="select count(*) from CommonCodeKind where codeKindId="+Common.sqlChar(getCodeKindId());
		checkSQLArray[0][1]=">";
		checkSQLArray[0][2]="0";
		checkSQLArray[0][3]="該筆代碼已重複，請重新輸入！";
		return checkSQLArray;
	}	
	
	@Override
	public void doCreate() throws Exception {					
		CommonCodeKind obj = new CommonCodeKind();	
		obj.setCodeKindId(getCodeKindId());
		obj.setCodeKindName(getCodeKindName());
		obj.setCodeLabelCon1(getCodeLabelCon1());
		obj.setCodeLabelCon2(getCodeLabelCon2());
		obj.setCodeLabelCon3(getCodeLabelCon3());
		obj.setMemoLabel(getMemoLabel());
		obj.setCodeMaxLen(Common.getInt(getCodeMaxLen()));

		obj.setCreateId(createId);
		obj.setCreateDate(createDate);
		obj.setCreateTime(createTime);
		obj.setUpdateId(updateId);
	    obj.setUpdateDate(updateDate);
		obj.setUpdateTime(updateTime);
		obj.setUpdateIp(updateIp);
		obj.setUpdateUnitShortName(updateUnitShortName);
		
		ServiceGetter.getInstance().getCommonService().getCommonCodeDao().save(obj);
		setId((obj.getId().toString()));			
	}
	
	@Override
	public void doUpdate() throws Exception {
		CommonCodeKind obj = (CommonCodeKind) View.getObject("from CommonCodeKind where id=" + Common.getInt(getId()));
		obj.setCodeKindId(getCodeKindId());
		obj.setCodeKindName(getCodeKindName());
		obj.setCodeLabelCon1(getCodeLabelCon1());
		obj.setCodeLabelCon2(getCodeLabelCon2());
		obj.setCodeLabelCon3(getCodeLabelCon3());
		obj.setMemoLabel(getMemoLabel());
		obj.setCodeMaxLen(Common.getInt(getCodeMaxLen()));

		obj.setUpdateId(updateId);
	    obj.setUpdateDate(updateDate);
		obj.setUpdateTime(updateTime);
		obj.setUpdateIp(updateIp);
		obj.setUpdateUnitShortName(updateUnitShortName);

		ServiceGetter.getInstance().getCommonService().getCommonCodeDao().update(obj);
	}	

	@Override
	public void doDelete() throws Exception {		
		ServiceGetter.getInstance().getCommonService().getCommonCodeDao().delete(CommonCodeKind.class, Common.getInt(getId()));
	}

	@Override
	public SYSCA003F doQueryOne() throws Exception {	 
		SYSCA003F obj = this;		
		CommonCodeKind c = (CommonCodeKind)ServiceGetter.getInstance().getCommonService().getCommonCodeDao().load(CommonCodeKind.class, Common.getInt(getId()));
		if (c!=null) {
			obj.setCodeKindId(c.getCodeKindId());
			obj.setCodeKindName(c.getCodeKindName());
			obj.setCodeLabelCon1(c.getCodeLabelCon1());
			obj.setCodeLabelCon2(c.getCodeLabelCon2());
			obj.setCodeLabelCon3(c.getCodeLabelCon3());
			obj.setMemoLabel(c.getMemoLabel());	
			obj.setCodeMaxLen(Common.get(c.getCodeMaxLen()));	
//			obj.setEditID(c.getEditId());
//			obj.setEditDate(c.getEditDate());
//			obj.setEditTime(c.getEditTime());
		} else throw new Exception("查無資料");		
		return obj;
	}
	
	
	@Override
	public java.util.ArrayList<String[]> doQueryAll() throws Exception {		
		StringBuilder sb = new StringBuilder(300).append("from CommonCodeKind where 1=1 ");
		java.util.ArrayList<String[]> arrList = new java.util.ArrayList<String[]>();
		if (!"".equals(getQ_codeKindId()))
			sb.append(" and codeKindId like ").append(Common.sqlChar(getQ_codeKindId()+"%"));					
		if (!"".equals(getQ_codeKindName()))
			sb.append(" and codeKindName like ").append(Common.sqlChar(getQ_codeKindName()+"%"));
		if (!"".equals(getCodeLabelCon1()))
			sb.append(" and codeCon3 like ").append(Common.sqlChar(getCodeLabelCon1()+"%"));		
		if (!"".equals(getCodeLabelCon2()))
			sb.append(" and codeCon2 like ").append(Common.sqlChar(getCodeLabelCon2()+"%"));
		if (!"".equals(getCodeLabelCon3()))
			sb.append(" and codeCon3 like ").append(Common.sqlChar(getCodeLabelCon3()+"%"));		
		
		this.processCurrentPageAttribute(ServiceGetter.getInstance().getCommonService().getCommonCodeDao().loadCount(sb.toString()));
		if (getTotalRecord() > 0) {
			//if (getState().indexOf("query")<0) 
				//ServiceGetter.getInstance().getCommonService().getCommonCodeDao().getHibernateTemplate().clear();			
			java.util.List objList = ServiceGetter.getInstance().getCommonService().getCommonCodeDao().load(sb.toString(), this.getRecordStart(), this.getPageSize());		
			try {
				if (objList!=null && objList.size()>0) {
					for (int i=0; i<objList.size(); i++) {
						CommonCodeKind o = (CommonCodeKind) objList.get(i);						
						String rowArray[]=new String[8];	
						rowArray[0]=Common.get(o.getId());
						rowArray[1]=Common.get(o.getCodeKindId());
						rowArray[2]=Common.get(o.getCodeKindName());
						rowArray[3]=Common.get(o.getCodeLabelCon1());
						rowArray[4]=Common.get(o.getCodeLabelCon1());
						rowArray[5]=Common.get(o.getCodeLabelCon1());
						rowArray[6]=Common.get(o.getMemoLabel());
						rowArray[7]=Common.get(o.getCodeMaxLen());
						arrList.add(rowArray);					
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		return arrList;
	}
}
