package com.kangdainfo.common.view.sys.ap;

import com.kangdainfo.ServiceGetter;


import com.kangdainfo.common.model.bo.CommonUnlimitIp;
import com.kangdainfo.common.util.Common;
import com.kangdainfo.common.util.Datetime;
import com.kangdainfo.common.util.SuperBean;
import com.kangdainfo.common.util.View;


/**
*<br>程式目的：機關代碼維護作業_CPA版本
*<br>程式代號：sysca002f_cpa
*<br>程式日期：0980811
*<br>程式作者：shark
*<br>--------------------------------------------------------
*<br>修改作者　　修改日期　　　修改目的
*<br>--------------------------------------------------------
*/

public class  SYSAP104F extends SuperBean{


String id;
String startIp;
String endIp;//不受限制網段
String ipMemo;//說明


String q_ip;
@Override
public void doCreate() throws Exception {
	CommonUnlimitIp obj = new CommonUnlimitIp();
	
	obj.setIpMemo(ipMemo);
	obj.setStartIp(startIp);
	obj.setEndIp(endIp);
	obj.setCreateId(createId);
	obj.setCreateDate(createDate);
	obj.setCreateTime(createTime);
	obj.setUpdateId(updateId);
    obj.setUpdateDate(updateDate);
	obj.setUpdateTime(updateTime);
	obj.setUpdateIp(updateIp);
	obj.setUpdateUnitShortName(updateUnitShortName);
	
	ServiceGetter.getInstance().getCommonService().save(obj);
	setId(obj.getId().toString());
}


@Override
public void doUpdate() throws Exception {
	CommonUnlimitIp obj = (CommonUnlimitIp) View.getObject(" from CommonUnlimitIp where id=" + Common.get(getId()));
	obj.setIpMemo(ipMemo);
	obj.setStartIp(startIp);
	obj.setEndIp(endIp);	
	obj.setUpdateId(updateId);
    obj.setUpdateDate(updateDate);
	obj.setUpdateTime(updateTime);
	obj.setUpdateIp(updateIp);
	obj.setUpdateUnitShortName(updateUnitShortName);	
	ServiceGetter.getInstance().getCommonService().save(obj);
	setId(obj.getId().toString());
}


@Override
public void doDelete() throws Exception {
	ServiceGetter.getInstance().getCommonService().delete(CommonUnlimitIp.class, Common.getInt(id));
}


/**
 * <br>
 * <br>目的：依主鍵查詢單一資料
 * <br>參數：無
 * <br>傳回：傳回本物件
*/
@Override
public SYSAP104F  doQueryOne() throws Exception {
	SYSAP104F obj = this;
	CommonUnlimitIp c = (CommonUnlimitIp)ServiceGetter.getInstance().getCommonService().load(CommonUnlimitIp.class,Integer.parseInt(getId()));
	if (c!=null) {
		
	    obj.setIpMemo(c.getIpMemo());
		obj.setStartIp(c.getStartIp());
		obj.setEndIp(c.getEndIp());
		obj.setCreateId(c.getCreateId());
		obj.setCreateDate(c.getCreateDate());
		obj.setCreateTime(c.getCreateTime());
		obj.setUpdateId(c.getUpdateId());
		obj.setUpdateDate(c.getUpdateDate());
		obj.setUpdateTime(c.getUpdateTime());
		obj.setUpdateIp(c.getUpdateIp());
		obj.setUpdateUnitShortName(c.getUpdateUnitShortName());
	} else throw new Exception("查無該筆資料！");
	return obj;
}


@Override
public java.util.ArrayList<String[]> doQueryAll() throws Exception {		
	StringBuilder sb = new StringBuilder(300).append("from CommonUnlimitIp where 1=1 ");
	java.util.ArrayList<String[]> arrList = new java.util.ArrayList<String[]>();
	
	if (!"".equals(getQ_ip()))
		sb.append(" and ip like ").append(Common.sqlChar("%"+getQ_ip()+"%"));					
	
	
   
	System.out.println(sb.toString());
	java.util.Map<String, String> map=new java.util.HashMap<String, String>();
	

	this.processCurrentPageAttribute(ServiceGetter.getInstance().getCommonService().loadCount(sb.toString()));
	if (getTotalRecord() > 0) {
		if (getState().indexOf("query")<0) 
			ServiceGetter.getInstance().getCommonService().clear();				
		java.util.List objList = ServiceGetter.getInstance().getCommonService().load(sb.toString(), this.getRecordStart(), this.getPageSize());		
		try {
			if (objList!=null && objList.size()>0) {
				for (int i=0; i<objList.size(); i++) {
					CommonUnlimitIp o = (CommonUnlimitIp) objList.get(i);						
					String rowArray[]=new String[3];	
					rowArray[0]=Common.get(o.getId());
					rowArray[1]=Common.get(o.getStartIp()+"~"+o.getEndIp());
				
					rowArray[2]=Common.get(o.getIpMemo());
					
					
				
					arrList.add(rowArray);					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	return arrList;
}
	

	


	public String getId() {
		return checkGet(id);
	}


	public void setId(String id) {
		this.id = checkSet(id);
	}




	public String getStartIp() {
		return checkGet(startIp);
	}


	public void setStartIp(String startIp) {
		this.startIp = checkSet(startIp);
	}


	public String getEndIp() {
		return checkGet(endIp);
	}


	public void setEndIp(String endIp) {
		this.endIp = checkSet(endIp);
	}


	public String getIpMemo() {
		return checkGet(ipMemo);
	}


	public void setIpMemo(String ipMemo) {
		this.ipMemo = checkSet(ipMemo);
	}


	


	public String getQ_ip() {
		return checkGet(q_ip);
	}


	public void setQ_ip(String q_ip) {
		this.q_ip = checkSet(q_ip);
	}	
	
}


