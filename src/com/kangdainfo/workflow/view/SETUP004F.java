package com.kangdainfo.workflow.view;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import com.kangdainfo.workflow.model.bo.CaseNode;
import com.kangdainfo.workflow.model.bo.FramePath;
import com.kangdainfo.workflow.model.bo.WorkFlow;

/**
*<br>程式目的：顯示待辦清單(需求未確認尚未實作)
*<br>程式代號：setup004f
*<br>程式日期：1030808
*<br>程式作者：
*<br>--------------------------------------------------------
*<br>修改作者　　修改日期　　　修改目的
*<br>--------------------------------------------------------
*/

public class SETUP004F extends SuperBean{


String id;
String q_taskName;
String q_taskChName;

String fds[];
public String[] getFds(){return fds;	}
public void setFds(String[] s){ fds = s;}

javax.servlet.ServletRequest httpRequest;
public javax.servlet.ServletRequest getHttpRequest() {return httpRequest;}
public void setHttpRequest(javax.servlet.ServletRequest r) {this.httpRequest = r;}

@Override
public void doCreate() throws Exception {	
}


@Override
public void doUpdate() throws Exception {
	String[] fds = getFds();
	if(fds!=null && fds.length>0){
		StringBuffer sb = new StringBuffer();
		sb.append("-1");
		for(String rid : fds){
			
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

public SETUP004F  doQueryOne() throws Exception {	
	SETUP004F obj = this;
	return obj;
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
		sb.append("from CaseNode where 1=1 ");
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
			//sb.append(" and deptcode = ").append(Common.sqlChar(user.getCommonDepartment().getDepartmentCode()));
		}
		user = null;
		if (!"".equals(getQ_taskName())) {
			sb.append(" and taskName = ").append(Common.sqlChar(getQ_taskName()));
		}		
		this.processCurrentPageAttribute(ServiceGetter.getInstance().getCommonService().loadCount(sb.toString(), maps));
		if (getTotalRecord() > 0) {
			if (getState().indexOf("query")<0) 
				ServiceGetter.getInstance().getCommonService().getCommonUserDao().clear();
			
			java.util.List objList = ServiceGetter.getInstance().getCommonService().load(sb.toString(), this.getRecordStart(), this.getPageSize(), "id", true,  maps);
			if (objList != null && objList.size() > 0) {
				//java.util.Map<String, String> wfMap = Common.getCommonCodeMap("WF");
				java.util.Iterator it = objList.iterator();
				while (it.hasNext()) {
					CaseNode o = (CaseNode) it.next();					
					
					String rowArray[] = new String[5];
					rowArray[0] = Common.get(o.getId());
					rowArray[1] = Common.get(o.getInitCaseNo());
					rowArray[2] = Common.get(o.getBeginTime());
					rowArray[3] = Common.get(o.getId());
					StringBuilder sb2 = new StringBuilder();
                    
					String sql ="select status,'('+status+')'+name from WorkFlow where parent.taskName="+Common.sqlChar(o.getTaskName());
					
	            	List list = ServiceGetter.getInstance().getCommonService().load(sql);
	            	if (list!=null && list.size()>0) {
	            		sb2.append("<select class=\"field_Q\">");
	            		for (int i=0; i<list.size(); i++) {
	            			Object[] obj = (Object[])list.get(i);
	                        String id = Common.get(obj[0]);
	                        String name = Common.get(obj[1]);	                        
	                        sb2.append("<option value='").append(id).append("' ");	                        
	                        if (Common.get(name).length()>60) sb.append(">").append(name.substring(0,60)).append("..</option>\n");
	                        else sb2.append(">").append(name).append("</option>\n");	                        
	            		}
	            		sb2.append("</select>&nbsp;");
                        sb2.append("<input type=\"button\" class=\"field_Q\" name=\"subConfirm_"+o.getId()+"\" value=\"執行\">");
	            	}else{
	            		sb2.append("無流程資料!");
	            	}				
					rowArray[4] = Common.get(sb2.toString());
					arrList.add(rowArray);					
				}
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
				//顯示TR
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
				//依照column判斷，disable為true代表有值時disable CheckBox，disable為false代表無值時disable CheckBox。
				String dc = ""; 
				if(column >= 0 && column < displayArray.length){
					if(( disable && Common.get(rowArray[column]).length() > 0) ||
					   (!disable && Common.get(rowArray[column]).equals(""))){
						dc = "disabled";
					}
				}							
				targetFlag = false;
				for(i=0;i<displayArray.length;i++){
					if(i==0) sb.append(" <td class='listTD' >").append(counter).append(".</td>\n");
					else if(i==3){
						//顯示TD
						if (className!=null && !"".equals(Common.get(className))) {
							sb.append(" <td class='listTD' >").append("<input type='checkbox' ").append(dc).append(" class='").append(className).append("' id=\"").append(checkboxName).append("\" name=\"").append(checkboxName).append("\" value=\"").append(v.toString().replaceAll("'", "")).append("\"></td>\n");
						} else {
							sb.append(" <td class='listTD' >").append("<input type='checkbox' ").append(dc).append(" id=\"").append(checkboxName).append("\" name=\"").append(checkboxName).append("\" value=\"").append(v.toString().replaceAll("'", "")).append("\"></td>\n");
						}
					}
					else{
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
				}
				sb.append("</tr>\n");
				trFlag = false;
			}
    	} else {
    		if ("true".equals(queryAllFlag)) sb.append(" <tr class='highLight' ><td class='listTD' colspan='100'>查無資料，請您重新輸入查詢條件！</td></tr>");
    	}
		return sb.toString();
    }
	
	public String getId(){ return checkGet(id); }
	public void setId(String s){ id=checkSet(s); }
	public String getQ_taskName(){ return checkGet(q_taskName); }
	public void setQ_taskName(String s){ q_taskName=checkSet(s); }
	public String getQ_taskChName(){ return checkGet(q_taskChName); }
	public void setQ_taskChName(String s){ q_taskChName=checkSet(s); }

}


