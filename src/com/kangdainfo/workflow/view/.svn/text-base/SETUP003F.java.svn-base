package com.kangdainfo.workflow.view;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import org.joda.time.DateTime;

import com.kangdainfo.ServiceGetter;
import com.kangdainfo.common.model.bo.CommonUser;
import com.kangdainfo.common.model.bo.CommonUserGroup;
import com.kangdainfo.common.util.Common;
import com.kangdainfo.common.util.Datetime;
import com.kangdainfo.common.util.SuperBean;
import com.kangdainfo.common.util.View;
import com.kangdainfo.workflow.model.bo.FramePath;
import com.kangdainfo.workflow.model.bo.WorkFlow;

/**
*<br>程式目的：顯示待辦統計
*<br>程式代號：sysap003f
*<br>程式日期：1030808
*<br>程式作者：KangDa
*<br>--------------------------------------------------------
*<br>修改作者　　修改日期　　　修改目的
*<br>--------------------------------------------------------
*/

public class SETUP003F extends SuperBean{


String id;

String q_taskName;
String q_taskChName;

@Override
public void doCreate() throws Exception {	
}


@Override
public void doUpdate() throws Exception {
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

public SETUP003F  doQueryOne() throws Exception {
	return null;
}


/**
 * <br>
 * <br>目的：依查詢欄位查詢多筆資料
 * <br>參數：無
 * <br>傳回：傳回ArrayList
*/

	public java.util.ArrayList<String[]> doQueryAll() throws Exception {
		java.util.ArrayList<String[]> arrList = new java.util.ArrayList<String[]>();
		Map<String, Object> maps = new HashMap<String, Object>();
		
		StringBuffer sb = new StringBuffer();
		sb.append("from CaseNode where endtime is null ");
		CommonUser user = ServiceGetter.getInstance().getAuthenticationService().getCurrentUser();
		if(user!=null){		
			String groupStr ="";
			java.util.List<CommonUserGroup> groupList = ServiceGetter.getInstance().getCommonService().load(" from CommonUserGroup where commonUser.id="+Common.getLong(user.getId()));
			if(groupList!=null && groupList.size()>0){
				for(CommonUserGroup dtl : groupList)
				{
					if(groupStr !="") groupStr +=",";
					groupStr += Common.sqlChar(Common.get(dtl.getCommonGroup().getId()));
				}
			}
			sb.append(" and ( userId = ").append(Common.sqlChar(user.getUserId()));
			if(!"".equals(groupStr))			
				sb.append(" or userId in (").append(groupStr).append(") )");
			else
				sb.append(")");
			sb.append(" and deptcode = ").append(Common.sqlChar(user.getCommonDepartment().getDepartmentCode()));
		}
		user = null;		
		this.processCurrentPageAttribute(ServiceGetter.getInstance().getCommonService().loadCount(sb.toString(), maps));
		if (getTotalRecord() > 0) {
			if (getState().indexOf("query")<0) 
				ServiceGetter.getInstance().getCommonService().getCommonUserDao().clear();
			String hql = "select projectcode,taskname,taskchname,count(*)"+sb.toString()+" group by projectcode,taskname,taskchname";
			
			java.util.List objList = ServiceGetter.getInstance().getCommonService().load(hql, this.getRecordStart(), this.getPageSize(),  maps);
			if (objList != null && objList.size() > 0) {				
				java.util.Iterator it = objList.iterator();
				for (int i=0; i<objList.size(); i++) 
		    	{
					Object x[] = (Object[])objList.get(i);						
					
					String rowArray[] = new String[3];
					rowArray[0] = Common.get(x[1]);
					rowArray[1] = Common.get(x[2]+"("+x[1]+")");
					rowArray[2] = Common.get(x[3]);
					arrList.add(rowArray);					
				}
			}
		}
		return arrList;
	}
	
	public String getId(){ return checkGet(id); }
	public void setId(String s){ id=checkSet(s); }

	public String getQ_taskName(){ return checkGet(q_taskName); }
	public void setQ_taskName(String s){ q_taskName=checkSet(s); }
	public String getQ_taskChName(){ return checkGet(q_taskChName); }
	public void setQ_taskChName(String s){ q_taskChName=checkSet(s); }

}


