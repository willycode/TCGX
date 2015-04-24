package com.kangdainfo.common.view.sys.ap;

import com.kangdainfo.ServiceGetter;

import com.kangdainfo.common.model.bo.CommonConfig;

import com.kangdainfo.common.util.Common;
import com.kangdainfo.common.util.Datetime;
import com.kangdainfo.common.util.SuperBean;
import com.kangdainfo.common.util.View;
import com.kangdainfo.web.listener.MyServletContext;

/**
*<br>程式目的：機關代碼維護作業_CPA版本
*<br>程式代號：sysca002f_cpa
*<br>程式日期：0980811
*<br>程式作者：shark
*<br>--------------------------------------------------------
*<br>修改作者　　修改日期　　　修改目的
*<br>--------------------------------------------------------
*/

public class  SYSAP103F extends SuperBean{


String id;
String field1;//連續失敗次數
String field2;//帳號自動解除
String field3;//是否發送EMAIL










@Override
public void doCreate() throws Exception {

}


@Override
public void doUpdate() throws Exception {
	
	
	CommonConfig obj = (CommonConfig) ServiceGetter.getInstance().getCommonService().load(CommonConfig.class, getId());
    obj.setField1(getField1());
    obj.setField2(getField2());
    obj.setField3(getField3());

	obj.setUpdateId(updateId);
    obj.setUpdateDate(updateDate);
	obj.setUpdateTime(updateTime);
	obj.setUpdateIp(updateIp);
	obj.setUpdateUnitShortName(updateUnitShortName);

	ServiceGetter.getInstance().getCommonService().save(obj);
	
}


@Override
public void doDelete() throws Exception {
	
}


/**
 * <br>
 * <br>目的：依主鍵查詢單一資料
 * <br>參數：無
 * <br>傳回：傳回本物件
*/

public SYSAP103F  doQueryOne() throws Exception {
	SYSAP103F obj = this;
	CommonConfig c = (CommonConfig) ServiceGetter.getInstance().getCommonService().load(CommonConfig.class, getId());
	if (c!=null) {
		    obj.setField1(c.getField1());
		    obj.setField2(c.getField2());
		    obj.setField3(c.getField3());
	//        obj.setCreateId(c.getCreateId());
	//		obj.setCreateDate(c.getCreateDate());
	//		obj.setCreateTime(c.getCreateTime());
			obj.setUpdateId(c.getUpdateId());
			obj.setUpdateDate(c.getUpdateDate());
			obj.setUpdateTime(c.getUpdateTime());
			obj.setUpdateIp(c.getUpdateIp());
			obj.setUpdateUnitShortName(c.getUpdateUnitShortName());
		   
	} else throw new Exception("查無該筆資料！");
	return obj;
}


/**
 * <br>
 * <br>目的：依查詢欄位查詢多筆資料
 * <br>參數：無
 * <br>傳回：傳回ArrayList
*/

	public java.util.ArrayList<String[]> doQueryAll() throws Exception {
		
		return null;
	}
	

	public void doImportProcess() {
		
	}


	public String getId() {
		return checkGet(id);
	}


	public void setId(String id) {
		this.id = checkSet(id);
	}


	public String getField1() {
		return checkGet(field1);
	}


	public void setField1(String field1) {
		this.field1 = checkSet(field1);
	}


	public String getField2() {
		return checkGet(field2);
	}


	public void setField2(String field2) {
		this.field2 = checkSet(field2);
	}


	public String getField3() {
		return checkGet(field3);
	}


	public void setField3(String field3) {
		this.field3 = checkSet(field3);
	}



	
}


