package com.kangdainfo.common.view.sys.ap;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.kangdainfo.ServiceGetter;



import com.kangdainfo.common.model.bo.CommonConfig;
import com.kangdainfo.common.model.bo.CommonUnlimitIp;
import com.kangdainfo.common.model.bo.CommonUser;
import com.kangdainfo.common.util.Common;
import com.kangdainfo.common.util.Datetime;
import com.kangdainfo.common.util.SuperBean;
import com.kangdainfo.common.util.View;
import com.kangdainfo.util.DateUtil;


/**
*<br>程式目的：機關代碼維護作業_CPA版本
*<br>程式代號：sysca002f_cpa
*<br>程式日期：0980811
*<br>程式作者：shark
*<br>--------------------------------------------------------
*<br>修改作者　　修改日期　　　修改目的
*<br>--------------------------------------------------------
*/

public class  SYSAP005F extends SuperBean{


String id;
String centerId,centerShortName;//精舍
String userId,userName;//帳號、姓名
String fds[];
public String[] getFds() {		return fds;	}
public void setFds(String[] fds) {		this.fds = fds;	}


@Override
public void doCreate() throws Exception {
	
}


@Override
public void doUpdate() throws Exception {
	
	
	String tId = "";
	boolean flag = true;
	
	System.out.println(getId());
	if(!"".equals(Common.get(getId())))
	{
		tId=getId();
		setId("");
	}
	else if(getFds()!=null && getFds().length>0){
		System.out.println("xxx");
		for(int i=0;i<getFds().length;i++){
			String[] tIdFileNames = getFds()[i].length()>0?getFds()[i].split(","):new String[0];
			if(tIdFileNames.length>0){
				if(flag){
					tId += Common.get(tIdFileNames[0]);
					flag = false;
				}else{
					tId += ","+Common.get(tIdFileNames[0]);
				}
			}
		}
	}
	System.out.println(getFds().length);
	if(tId.length()>0){
		java.util.List uList = ServiceGetter.getInstance().getCommonService().load("from CommonUser where id in ("+tId+")");
		if(uList!=null && uList.size()>0){
			java.util.Iterator it = uList.iterator();
			while(it.hasNext()){
				CommonUser d = (CommonUser)it.next();
				d.setPasswordErrorTimes(0);
			//	d.setLastLoginTime("NULL");
				
			}
			ServiceGetter.getInstance().getCommonService().saveOrUpdateAll(uList);
			//ServiceGetter.getInstance().getCommonService().save(uList);
		}
	}
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
@Override
public SYSAP005F  doQueryOne() throws Exception {
	SYSAP005F obj = this;
	CommonUser c = (CommonUser)ServiceGetter.getInstance().getCommonService().load(CommonUser.class,Integer.parseInt(getId()));
	if (c!=null) {
		obj.setCenterShortName(c.getCommonDepartment().getUnitShortName());
		obj.setCenterId(c.getCommonDepartment().getUnitId());
		obj.setUserId(c.getUserId());
		
		obj.setUserName(c.getUserName());
	} else throw new Exception("查無該筆資料！");
	return obj;
}


@Override
public java.util.ArrayList<String[]> doQueryAll() throws Exception {		
	CommonConfig commonConfig = (CommonConfig)View.getObject("from CommonConfig where id = 1 ");
	Map<String, Object> maps = new HashMap<String, Object>();
	Date nowDate = Datetime.dateFlipMin(new Date(),Integer.parseInt(commonConfig.getField2()));

	// "+Common.sqlChar(Common.get(nowDate))+"
	//+commonConfig.getField1()
	StringBuilder sb = new StringBuilder(300).append("from CommonUser where lastPasswordErrorTime <= :lastPasswordErrorTime and passwordErrorTimes >= :passwordErrorTimes ");
	maps.put("lastPasswordErrorTime", nowDate); 
	maps.put("passwordErrorTimes", Integer.parseInt(commonConfig.getField1())); 
	
	java.util.ArrayList<String[]> arrList = new java.util.ArrayList<String[]>();
	
	if (!"".equals(getCenterId()))
	{
		sb.append(" and commonDepartment.unitId = :unitId ");
		maps.put("unitId", getCenterId()); 
	}
	if (!"".equals(getUserName()))
	{
		sb.append(" and userName like :userName ");
		maps.put("userName", "%" + getUserName() + "%");  
	}
   
	System.out.println(sb.toString());
	java.util.Map<String, String> map=new java.util.HashMap<String, String>();
	

	this.processCurrentPageAttribute(ServiceGetter.getInstance().getCommonService().getCommonUserDao().loadCount(sb.toString(), maps));
	if (getTotalRecord() > 0) {
		if (getState().indexOf("query")<0) 
			ServiceGetter.getInstance().getCommonService().clear();				
		java.util.List objList = ServiceGetter.getInstance().getCommonService().getCommonUserDao().load(sb.toString(), this.getRecordStart(), this.getPageSize(), "userId", true, maps);	
		try {
			if (objList!=null && objList.size()>0) {
				for (int i=0; i<objList.size(); i++) {
					CommonUser o = (CommonUser) objList.get(i);	
					
					String rowArray[]=new String[8];	
					rowArray[0]=Common.get(o.getId());
					rowArray[1]=Common.get(o.getCommonDepartment().getUnitId());
				
					rowArray[2]=Common.get(o.getCommonDepartment().getUnitShortName());
					rowArray[3]=Common.get(o.getUserId());
					rowArray[4]=Common.get(o.getUserName());
					rowArray[5]=Common.get(o.getLastPasswordErrorTime());
					rowArray[6]=Common.get(o.getPasswordErrorTimes());
					arrList.add(rowArray);					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	return arrList;
}
	

public static String getCheckboxQuerylist(boolean primaryArray[], boolean displayArray[], String[] arrAlign,
		ArrayList objList, String queryAllFlag, String checkboxName, boolean linkArray[], String target, String className, int column, boolean disable, boolean checkHtml) {
	int i, counter=0;
	boolean trFlag = false, targetFlag = false;

	StringBuilder sb = new StringBuilder();
	if (objList!=null && objList.size()>0) {
		java.util.Iterator it=objList.iterator();
		while(it.hasNext()) {
			String[] rowArray = (String[])it.next();
			counter++;

			sb.append(" <tr class='highLight' >");
			StringBuilder v = new StringBuilder().append("");
			for(i=0;i<primaryArray.length;i++){
				if (primaryArray[i]) {
					if (trFlag) {
						v.append(",'").append(rowArray[i]).append("'");
					} else {
						v.append("'").append(rowArray[i]).append("'");
					trFlag = true;
					}
				}
			}

			String dc = ""; 
		
			if(column >= 0 && column < displayArray.length){
				if(( disable && Common.get(rowArray[column]).length() > 0) ||
				   (!disable && Common.get(rowArray[column]).equals(""))){
					dc = "disabled";
				}
			}
			//顯示TD
			if (className!=null && !"".equals(Common.get(className))) {
				sb.append(" <td class='listTD' >").append("<input type='checkbox' ").append(dc).append(" class='").append(className).append("' id=\"").append(checkboxName).append("\" name=\"").append(checkboxName).append("\" value=\"").append(v.toString().replaceAll("'", "")).append("\"></td>\n");
			} else {
				sb.append(" <td class='listTD' >").append("<input type='checkbox' ").append(dc).append(" id=\"").append(checkboxName).append("\" name=\"").append(checkboxName).append("\" value=\"").append(v.toString().replaceAll("'", "")).append("\"></td>\n");
			}				
			targetFlag = false;
			for(i=0;i<displayArray.length;i++){
				if (displayArray[i]) {
					if (targetFlag==false && target!=null && !"".equals(Common.get(target))) {
						v.append(",'").append(target).append("'");
						targetFlag = true;
					}

					if (arrAlign!=null && arrAlign.length>0) {
						sb.append(" <td class='listTD' style=\"text-align:").append(arrAlign[i]).append("\">"); //.append(Common.get(rowArray[i])).append("</td>\n");
					} else {
						sb.append(" <td class='listTD' >");
					}
					if (linkArray!=null && linkArray[i]) {
						sb.append("<a href='#' class='sLink2' onClick=\"queryOne(").append(v).append(",").append(i).append(")\"");
						//if (target!=null && !"".equals(Common.get(target))) sb.append(" target=\"").append(target).append("\"");
						sb.append(">").append(checkHtml?Common.checkGet(rowArray[i]):Common.get(rowArray[i])).append("</a>");
					} else sb.append(checkHtml?Common.checkGet(rowArray[i]):Common.get(rowArray[i]));
					
					sb.append("</td>\n");
				}
			}
			sb.append("<td>");
			sb.append("<center>");
			sb.append("<input class='toolbar_default' type='button' name='btn_").append("' value='").append("解       除").append("' onClick='").append("aclear(").append(rowArray[0]).append(")'>");
			sb.append("</center>");
			sb.append("</td>");
			sb.append("</tr>\n");
			
			trFlag = false;
		}
	} else {
		if ("true".equals(queryAllFlag)) sb.append(" <tr class='highLight' ><td class='listTD' colspan='100'>查無資料，請您重新輸入查詢條件！</td></tr>");
	}
	return sb.toString();
}


	public String getId() {
		return checkGet(id);
	}


	public void setId(String id) {
		this.id = checkSet(id);
	}


	


	


	public String getCenterId() {
		return checkGet(centerId);
	}


	public void setCenterId(String centerId) {
		this.centerId = checkSet(centerId);
	}


	public String getCenterShortName() {
		return checkGet(centerShortName);
	}


	public void setCenterShortName(String centerShortName) {
		this.centerShortName = checkSet(centerShortName);
	}


	public String getUserId() {
		return checkGet(userId);
	}


	public void setUserId(String userId) {
		this.userId = checkSet(userId);
	}


	public String getUserName() {
		return checkGet(userName);
	}


	public void setUserName(String userName) {
		this.userName = checkSet(userName);
	}



	
}


