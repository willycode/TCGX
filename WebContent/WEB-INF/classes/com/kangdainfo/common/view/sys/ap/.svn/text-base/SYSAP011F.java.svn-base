package com.kangdainfo.common.view.sys.ap;

import java.util.HashMap;
import java.util.Map;

import com.kangdainfo.ServiceGetter;
import com.kangdainfo.common.model.bo.CommonCode;
import com.kangdainfo.common.model.bo.CommonCodeKind;
import com.kangdainfo.common.model.bo.CommonDepartment;
import com.kangdainfo.common.model.bo.CommonGroup;
import com.kangdainfo.common.model.bo.CommonUser;
import com.kangdainfo.common.model.bo.CommonUserGroup;
import com.kangdainfo.common.util.Common;
import com.kangdainfo.common.util.Database;
import com.kangdainfo.common.util.Datetime;
import com.kangdainfo.common.util.SuperBean;
import com.kangdainfo.common.util.View;
import com.kangdainfo.persistence.PersistenceServiceGetter;
import com.kangdainfo.persistence.hibernate4.query.params.QueryParam;
import com.kangdainfo.persistence.hibernate4.query.params.QueryParams;

/**
*<br>程式目的：帳號維護作業
*<br>程式代號：sysap001f
*<br>程式日期：0960915
*<br>程式作者：clive.chang
*<br>--------------------------------------------------------
*<br>修改作者　　修改日期　　　修改目的
*<br>--------------------------------------------------------
*/

public class  SYSAP011F extends SuperBean{


String id;
String userId;
String userSSN;
String userPWD;
String userName;
String groupId;
String deptId;
String deptIdFullCode;
String deptIdName;
String userTitle;
String userTitleName;
String userTitleCodeId;
String userTel;
String userMobile;
String userFax;
String userEmail;
String takeJobDate;
String isStop;
String roleId;
String memo;
String userNewPWD; 
String chkUserNewPWD;
String userBirthday;
String isMaster;

String q_userId;
String q_userName;
String q_groupId;
String q_deptId;
String q_deptIdFullCode;
String q_deptIdName;
String q_userTitle;
String q_userTitleName;
String q_userTitleCodeId;
String q_userEmail;
String q_isStop;
String q_roleId;

public String getId(){ return checkGet(id); }
public void setId(String s){ id=checkSet(s); }
public String getUserId(){ return checkGet(userId); }
public void setUserId(String s){ userId=checkSet(s); }
public String getUserSSN(){ return checkGet(userSSN); }
public void setUserSSN(String s){ userSSN=checkSet(s); }
public String getUserPWD(){ return get(userPWD); }
public void setUserPWD(String s){ userPWD=get(s); }
public String getUserName(){ return checkGet(userName); }
public void setUserName(String s){ userName=checkSet(s); }
public String getGroupId(){ return checkGet(groupId); }
public void setGroupId(String s){ groupId=checkSet(s); }
public String getDeptId(){ return checkGet(deptId); }
public void setDeptId(String s){ deptId=checkSet(s); }
public String getDeptIdFullCode(){ return checkGet(deptIdFullCode); }
public void setDeptIdFullCode(String s){ deptIdFullCode=checkSet(s); }
public String getDeptIdName(){ return checkGet(deptIdName); }
public void setDeptIdName(String s){ deptIdName=checkSet(s); }
public String getUserTitle(){ return checkGet(userTitle); }
public void setUserTitle(String s){ userTitle=checkSet(s); }
public String getUserTitleName(){ return checkGet(userTitleName); }
public void setUserTitleName(String s){ userTitleName=checkSet(s); }
public String getUserTitleCodeId(){ return checkGet(userTitleCodeId); }
public void setUserTitleCodeId(String s){ userTitleCodeId=checkSet(s); }
public String getUserTel(){ return checkGet(userTel); }
public void setUserTel(String s){ userTel=checkSet(s); }
public String getUserMobile(){ return checkGet(userMobile); }
public void setUserMobile(String s){ userMobile=checkSet(s); }
public String getUserFax(){ return checkGet(userFax); }
public void setUserFax(String s){ userFax=checkSet(s); }
public String getUserEmail(){ return checkGet(userEmail); }
public void setUserEmail(String s){ userEmail=checkSet(s); }
public String getTakeJobDate(){ return checkGet(takeJobDate); }
public void setTakeJobDate(String s){ takeJobDate=checkSet(s); }
public String getIsStop(){ return checkGet(isStop); }
public void setIsStop(String s){ isStop=checkSet(s); }
public String getRoleId(){ return checkGet(roleId); }
public void setRoleId(String s){ roleId=checkSet(s); }
public String getMemo(){ return checkGet(memo); }
public void setMemo(String s){ memo=checkSet(s); }
public String getUserNewPWD() {	return checkGet(userNewPWD);}
public void setUserNewPWD(String userNewPWD) {this.userNewPWD = checkSet(userNewPWD); }
public String getChkUserNewPWD() { return checkGet(chkUserNewPWD); }
public void setChkUserNewPWD(String chkUserNewPWD) { this.chkUserNewPWD = checkSet(chkUserNewPWD); }
public String getUserBirthday() { return checkGet(userBirthday); }
public void setUserBirthday(String userBirthday) { this.userBirthday = checkSet(userBirthday); }
public String getIsMaster() {return checkGet(isMaster);}
public void setIsMaster(String isMaster) {this.isMaster = checkSet(isMaster);}

public String getQ_userId(){ return checkGet(q_userId); }
public void setQ_userId(String s){ q_userId=checkSet(s); }
public String getQ_userName(){ return checkGet(q_userName); }
public void setQ_userName(String s){ q_userName=checkSet(s); }
public String getQ_groupId(){ return checkGet(q_groupId); }
public void setQ_groupId(String s){ q_groupId=checkSet(s); }
public String getQ_deptId(){ return checkGet(q_deptId); }
public void setQ_deptId(String s){ q_deptId=checkSet(s); }
public String getQ_deptIdFullCode(){ return checkGet(q_deptIdFullCode); }
public void setQ_deptIdFullCode(String s){ q_deptIdFullCode=checkSet(s); }
public String getQ_deptIdName(){ return checkGet(q_deptIdName); }
public void setQ_deptIdName(String s){ q_deptIdName=checkSet(s); }
public String getQ_userTitle(){ return checkGet(q_userTitle); }
public void setQ_userTitle(String s){ q_userTitle=checkSet(s); }
public String getQ_userTitleName(){ return checkGet(q_userTitleName); }
public void setQ_userTitleName(String s){ q_userTitleName=checkSet(s); }
public String getQ_userTitleCodeId(){ return checkGet(q_userTitleCodeId); }
public void setQ_userTitleCodeId(String s){ q_userTitleCodeId=checkSet(s); }
public String getQ_userEmail(){ return checkGet(q_userEmail); }
public void setQ_userEmail(String s){ q_userEmail=checkSet(s); }
public String getQ_isStop(){ return checkGet(q_isStop); }
public void setQ_isStop(String s){ q_isStop=checkSet(s); }
public String getQ_roleId(){ return checkGet(q_roleId); }
public void setQ_roleId(String s){ q_roleId=checkSet(s); }

String isMgr, q_isMgr;
public String getIsMgr() {return checkGet(isMgr);}
public void setIsMgr(String s) {this.isMgr = checkSet(s);}
public String getQ_isMgr() {return checkGet(q_isMgr);}
public void setQ_isMgr(String s) {q_isMgr = checkSet(s);}

String[] groupIds, q_groupIds;
public String[] getGroupIds() {return groupIds;}
public void setGroupIds(String[] groupIds) {this.groupIds = groupIds;}
public String[] getQ_groupIds() {return q_groupIds;}
public void setQ_groupIds(String[] ids) {q_groupIds = ids;}

String isDeptManager;
String q_isDeptManager;
public String getIsDeptManager() {return checkGet(isDeptManager);}
public void setIsDeptManager(String s) {this.q_isDeptManager = checkSet(s);}
public String getQ_isDeptManager() {return checkGet(isDeptManager);}
public void setQ_isDeptManager(String s) {this.q_isDeptManager = checkSet(s);}

@Override
public void doCreate() throws Exception {
	CommonUser obj = (CommonUser) View.getObject("from CommonUser where userId=" + Common.sqlChar(userId));
	if (obj!=null) {
		throw new Exception("新增失敗，帳號重覆");
	} else {
		obj = new CommonUser();		
		obj.setUserId(userId);
		obj.setUserSsn(userSSN);
		if (!"".equals(getUserPWD())) obj.setUserPwd(Common.getDigestString(getUserPWD(),"SHA-1"));
		//法師密碼
		if(Boolean.valueOf(getIsMaster())){
			String masterPassword = View.getLookupField("select masterPassword from CtMasterInfo where masterId = " + Common.sqlChar(getUserId()));
			if(!"".equals(masterPassword)){
				obj.setUserPwd(masterPassword);
			}
		}
		obj.setUserName(userName);
		
		//TODO 單位主管要另外處理
		if ("Y".equals(getIsMgr()) || Common.get(getRoleId()).equals("3")) obj.setRoleId(3);
		else obj.setRoleId(1);	
		//obj.setRoleId(Common.getInteger(roleId));
		obj.setUserTel(userTel);
		obj.setUserMobile(userMobile);
		obj.setUserFax(userFax);
		obj.setUserEmail(userEmail);
		obj.setTakeJobDate(takeJobDate);
		obj.setIsStop(isStop);	
		obj.setIsDeptManager(isDeptManager);
		obj.setMemo(memo);
		obj.setUserBirthday(Datetime.getDateFromRocDateString(getUserBirthday()));
		obj.setIsMaster(Boolean.valueOf(isMaster)); //法師身分
		obj.setCreateId(createId);
		obj.setCreateDate(createDate);
		obj.setCreateTime(createTime);
		obj.setUpdateId(updateId);
	    obj.setUpdateDate(updateDate);
		obj.setUpdateTime(updateTime);
		obj.setUpdateIp(updateIp);
		obj.setUpdateUnitShortName(updateUnitShortName);
		CommonDepartment dept = new CommonDepartment();
		dept.setId(Common.getInt(deptId));
		obj.setCommonDepartment(dept);
		if (!"".equals(getUserTitle())) {
			CommonCode code = new CommonCode();
			code.setId(Common.getInt(userTitle));
			obj.setCommonCode(code);			
		}		
		if (!"".equals(getGroupId())) {
			CommonGroup group = new CommonGroup();
			group.setId(Common.getInt(groupId));	
			obj.setCommonGroup(group);				
		}

		boolean isAllowLoginAtCT = false;
		if ("Y".equals(getIsMgr()))isAllowLoginAtCT = true;
		CommonGroup cg = null;
		int [] gids = null;
		if (this.getGroupIds()!=null && this.getGroupIds().length>0) {
			gids = new int[this.getGroupIds().length];
			for (int i=0; i<this.getGroupIds().length; i++) {
				gids[i] = Common.getInt(getGroupIds()[i]);
				
				//如果角色中有unlimited，則setAllowLoginAtCT(true)
				if (!isAllowLoginAtCT)
				{
					cg = (CommonGroup) ServiceGetter.getInstance().getCommonService().getCommonUserDao().getObject("from CommonGroup where id="+gids[i]);
					if(null!=cg && cg.getUnlimitUse()){
						isAllowLoginAtCT = true;
					}
				}
				

				//先查該GROUP
				cg = (CommonGroup) ServiceGetter.getInstance().getCommonService().getCommonUserDao().getObject("from CommonGroup where id="+gids[i]);
				if (cg.getTopManager()) {
					obj.setRoleId(2);
					//找出該精舍擁有此角色的CommonUserGroup
					java.util.List list = ServiceGetter.getInstance().getCommonService().load("from CommonUserGroup where commonGroup.id="+gids[i]+"and commonUser.commonDepartment.id="+deptId);
					
					if (!list.isEmpty() && list.size()>0)
						ServiceGetter.getInstance().getCommonService().deleteBatch(list);	
						
				}
			}
		}
		obj.setAllowLoginAtCT(isAllowLoginAtCT);

		ServiceGetter.getInstance().getCommonService().getCommonUserDao().saveCommonUser(obj, gids);
		
		setId(obj.getId().toString());
		/**TBGV : 一個USER可以屬於多個Group, 所以改寫了一下
		ServiceGetter.getInstance().getCommonService().getCommonUserDao().saveCommonUser(obj);
		setId(obj.getId().toString());
		
		CommonUserRole role = new CommonUserRole();
		role.setRoleId(obj.getRoleId());
		role.setId(obj.getId());
		role.setCommonGroup(group);
		role.setCommonUser(obj);
		ServiceGetter.getInstance().getCommonService().getCommonUserRoleDao().saveCommonUserRole(role);
		**/				

	}
}


@Override
public void doUpdate() throws Exception {
	CommonUser obj = (CommonUser) View.getObject("from CommonUser where id=" + Common.getInt(getId()));	
	
	if(obj != null){
	obj.setUserId(userId);
	obj.setUserSsn(userSSN);
	if (!"".equals(getUserPWD())) obj.setUserPwd(Common.getDigestString(getUserPWD(),"SHA-1"));
	obj.setUserName(userName);
	
	//TODO 單位主管要另外處理
	if ("Y".equals(getIsMgr()) || Common.get(getRoleId()).equals("3")) obj.setRoleId(3);
	else obj.setRoleId(1);
	//obj.setRoleId(Common.getInteger(roleId));	
	obj.setUserTel(userTel);
	obj.setUserMobile(userMobile);
	obj.setUserFax(userFax);
	obj.setUserEmail(userEmail);
	obj.setTakeJobDate(takeJobDate);
	obj.setIsStop(isStop);
	obj.setIsDeptManager(isDeptManager);
	obj.setMemo(memo);
	obj.setUserBirthday(Datetime.getDateFromRocDateString(userBirthday));
	obj.setIsMaster(Boolean.valueOf(isMaster)); //法師身分
	obj.setUpdateId(updateId);
    obj.setUpdateDate(updateDate);
	obj.setUpdateTime(updateTime);
	obj.setUpdateIp(updateIp);
	obj.setUpdateUnitShortName(updateUnitShortName);
	CommonDepartment dept = new CommonDepartment();
	dept.setId(Common.getInt(deptId));
	obj.setCommonDepartment(dept);

	if (!"".equals(getUserTitle())) {
		CommonCode code = new CommonCode();
		code.setId(Common.getInt(userTitle));
		obj.setCommonCode(code);		
	} else obj.setCommonCode(null);
	
	if (!"".equals(getGroupId())) {
		CommonGroup group = new CommonGroup();
		group.setId(Common.getInt(groupId));	
		obj.setCommonGroup(group);				
	} else obj.setCommonGroup(null);


	boolean isAllowLoginAtCT = false;
	if ("Y".equals(getIsMgr()))isAllowLoginAtCT = true;
	CommonGroup cg = null;
	int [] gids = null;
	if (this.getGroupIds()!=null && this.getGroupIds().length>0) {
		gids = new int[this.getGroupIds().length];
		for (int i=0; i<this.getGroupIds().length; i++) {
			gids[i] = Common.getInt(getGroupIds()[i]);
			if (!isAllowLoginAtCT)
			{
				cg = (CommonGroup) ServiceGetter.getInstance().getCommonService().getCommonUserDao().getObject("from CommonGroup where id="+gids[i]);
				if(null!=cg && cg.getUnlimitUse()){
					isAllowLoginAtCT = true;
				}
				
				
				//TODO
				cg = (CommonGroup) ServiceGetter.getInstance().getCommonService().getCommonUserDao().getObject("from CommonGroup where id="+gids[i]);
				if (cg.getTopManager()) {
					obj.setRoleId(2);
					//找出該精舍擁有此角色的CommonUserGroup
					java.util.List list = ServiceGetter.getInstance().getCommonService().load("from CommonUserGroup where commonGroup.id="+gids[i]+"and commonUser.commonDepartment.id="+deptId);
					
					if (!list.isEmpty() && list.size()>0)
						ServiceGetter.getInstance().getCommonService().deleteBatch(list);	
						
				}
				
			}
		}
	}
	obj.setAllowLoginAtCT(isAllowLoginAtCT);

	ServiceGetter.getInstance().getCommonService().getCommonUserDao().updateCommonUser(obj, gids);
	}else{
		throw new Exception("發生未預期的錯誤,請重新操作！");
	}
	
	/** TBGV : 一個USER可以屬於多個Group, 所以改寫了一下
	ServiceGetter.getInstance().getCommonService().getCommonUserDao().updateCommonUser(obj);

	boolean isUpdate = true;
	CommonUserRole role = (CommonUserRole) View.getObject("from CommonUserRole where id=" + obj.getId());
	if (role==null) {
		role = new CommonUserRole();
		role.setId(obj.getId());
		role.setCommonUser(obj);
		isUpdate = false;
	}
	role.setCommonGroup(obj.getCommonGroup());	
	if (isUpdate) ServiceGetter.getInstance().getCommonService().getCommonUserRoleDao().updateCommonUserRole(role);
	else ServiceGetter.getInstance().getCommonService().getCommonUserRoleDao().saveCommonUserRole(role);
	**/
}

@Override
public void doDelete() throws Exception {
	ServiceGetter.getInstance().getCommonService().getCommonUserDao().deleteCommonUser(Common.getInt(getId()));	
	/**
	CommonUserRole role = (CommonUserRole) View.getObject("from " + CommonUserRole.class.getCanonicalName() + " where id=" + getId());
	if (role!=null) ServiceGetter.getInstance().getCommonService().getCommonUserDao().delete(role);
		
	CommonUser c = (CommonUser)View.getObject("from CommonUser where id=" + getId());
	if (c!=null) ServiceGetter.getInstance().getCommonService().getCommonUserDao().deleteCommonUser(c);
	**/	
}


/**
 * <br>
 * <br>目的：依主鍵查詢單一資料
 * <br>參數：無
 * <br>傳回：傳回本物件
*/

public SYSAP011F  doQueryOne() throws Exception {
	SYSAP011F obj = this;
	CommonUser c = (CommonUser)ServiceGetter.getInstance().getCommonService().getCommonUserDao().load(CommonUser.class,Integer.parseInt(getId()));
	if (c!=null) {
        obj.setId(c.getId().toString());
        obj.setUserId(c.getUserId());
        obj.setUserSSN(c.getUserSsn());
        //obj.setUserPWD(c.getUserPwd());
        obj.setUserPWD("");
        obj.setUserName(c.getUserName());
      //obj.setRoleId(Common.get(c.getRoleId()));
        obj.setUserTel(c.getUserTel());
        obj.setUserMobile(c.getUserMobile());
        obj.setUserFax(c.getUserFax());
        obj.setUserEmail(c.getUserEmail());
        obj.setTakeJobDate(c.getTakeJobDate());
        obj.setIsStop(c.getIsStop());
        obj.setMemo(c.getMemo());
        obj.setUserBirthday(Datetime.getRocDateFromDate(c.getUserBirthday()));
        obj.setIsMaster(String.valueOf(c.getIsMaster())); //法師身分
        obj.setCreateId(c.getCreateId());
		obj.setCreateDate(c.getCreateDate());
		obj.setCreateTime(c.getCreateTime());
		obj.setUpdateId(c.getUpdateId());
		obj.setUpdateDate(c.getUpdateDate());
		obj.setUpdateTime(c.getUpdateTime());
		obj.setUpdateIp(c.getUpdateIp());
		obj.setUpdateUnitShortName(c.getUpdateUnitShortName());
        obj.setDeptId(c.getCommonDepartment()!=null?c.getCommonDepartment().getId().toString():"");
        obj.setDeptIdFullCode(c.getCommonDepartment()!=null?c.getCommonDepartment().getFullCode():"");
        obj.setDeptIdName(c.getCommonDepartment()!=null?c.getCommonDepartment().getFullName():"");
        if (c.getCommonCode()!=null) {
            obj.setUserTitle(c.getCommonCode().getId().toString());
            obj.setUserTitleCodeId(c.getCommonCode().getCodeId());
            obj.setUserTitleName(c.getCommonCode().getCodeName());
        } else {
        	obj.setUserTitle("");
            obj.setUserTitleCodeId("");
            obj.setUserTitleName("");        	
        }
        if (c.getRoleId()!=null && c.getRoleId()>2) obj.setIsMgr("Y");
        else obj.setIsMgr("N");
        obj.setGroupId(c.getCommonGroup()!=null?c.getCommonGroup().getId().toString():"");
        
		String hql = "from CommonUserGroup where commonUser.id=" + c.getId();
		java.util.List list = ServiceGetter.getInstance().getCommonService().load(hql);		
		if (list!=null && list.size()>0) {
			this.groupIds = new String[list.size()];
			for (int i=0; i<list.size(); i++) {
				CommonUserGroup g = (CommonUserGroup) list.get(i);
				groupIds[i] = g.getCommonGroup().getId().toString();
			}
		} else {
			obj.setGroupIds(null);
		}
        
    
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
		java.util.ArrayList<String[]> arrList = new java.util.ArrayList<String[]>();
/*		QueryParams q = new QueryParams();
		if (!"".equals(getQ_userId()))
			q.add(new QueryParam("and","userId","=",getQ_userId()));
		if (!"".equals(getQ_userName()))
			q.add(new QueryParam("and","userName","like",getQ_userName()));
		if (!"".equals(getQ_groupId()))
			q.add(new QueryParam("and","commonGroup.id","=",Common.getInteger(getQ_groupId())));
		if (getQ_groupIds()!=null && getQ_groupIds().length>0) {		
			QueryParams g = new QueryParams();
			g.add(new QueryParam("and","commonGroup.id","in",getQ_groupIds()));
			java.util.List list = ServiceGetter.getInstance().getCommonService().loadObjectsByParams(CommonUserGroup.class, g);	
			if (list!=null && list.size()>0) {			
				Integer[] ids = new Integer[list.size()];
				for (int i=0; i<list.size(); i++) {
					CommonUserGroup group = (CommonUserGroup) list.get(i);
					ids[i] = group.getCommonUser().getId();
				}
				q.add(new QueryParam("and","id","in",ids));
			} else {
				q.add(new QueryParam("and","id","=",new Integer(-1)));
			}			
			//q.add(new QueryParam("and","commonGroup.id","in",getQ_groupIds()));
		}
		if (!"".equals(getQ_deptId()))
			q.add(new QueryParam("and","commonDepartment.id","=",Common.getInteger(getQ_deptId())));
		if (!"".equals(getQ_userTitle()))
			q.add(new QueryParam("and","commonCode.id","=",Common.getInt(getQ_userTitle())));
		if (!"".equals(getQ_userEmail()))
			q.add(new QueryParam("and","userEmail","=",getQ_userEmail()));
		if (!"".equals(getQ_isStop()))
			q.add(new QueryParam("and","isStop","=",getQ_isStop()));
		if (!"".equals(getQ_roleId()))
			q.add(new QueryParam("and","roleId","=",Common.getInteger(getQ_roleId())));
		
		if ("Y".equals(getQ_isMgr()))
			q.add(new QueryParam("and","roleId","=",new Integer(3)));
		if ("N".equals(getQ_isMgr()))
			q.add(new QueryParam("and","roleId","!=",new Integer(3)));		
*/
		Map<String, Object> maps = new HashMap<String, Object>();
		
		StringBuffer sb = new StringBuffer();
		sb.append("from CommonUser where 1=1 ");
		if (!"".equals(getQ_userId()))
			sb.append(" and userId = ").append(Common.sqlChar(getQ_userId()));
		if (!"".equals(getQ_userName())) {
			sb.append(" and userName like :userName ");
			
			System.out.println(q_userName);
			System.out.println(checkGetReverse(getQ_userName(), true));
			System.out.println(getQ_userName());
			maps.put("userName", "%" + checkGetReverse(getQ_userName(), false) + "%");  //Add Ay Apple Su 20140620 或以下寫法
//			maps.put("userName", "%" + q_userName + "%");  //Add Ay Apple Su 20140620
		}
		
		if (!"".equals(getQ_groupId()))
			sb.append("commonGroup.id = ").append(Common.sqlChar(getQ_groupId()));
		if (getQ_groupIds()!=null && getQ_groupIds().length>0) {		
			QueryParams g = new QueryParams();
			g.add(new QueryParam("and","commonGroup.id","in",getQ_groupIds()));
			java.util.List list = ServiceGetter.getInstance().getCommonService().loadObjectsByParams(CommonUserGroup.class, g);	
			if (list!=null && list.size()>0) {		
				StringBuffer sb2 = new StringBuffer().append("-1");
				for (int i=0; i<list.size(); i++) {
					CommonUserGroup group = (CommonUserGroup) list.get(i);
					sb2.append(",").append(group.getCommonUser().getId());
				}				
				sb.append(" and id in(").append(sb2.toString()).append(")");
			} else {
				sb.append(" and id=-1");
			}
		}
		if (!"".equals(getQ_deptId()))
			sb.append( " and commonDepartment.id=").append(Common.sqlChar(getQ_deptId()));
		if (!"".equals(getQ_userTitle()))
			sb.append(" and commonCode.id = ").append(Common.sqlChar(getQ_userTitle()));
		if (!"".equals(getQ_userEmail()))
			sb.append(" and userEmail like ").append(Common.sqlChar(getQ_userEmail()));
		if (!"".equals(getQ_isStop()))
			sb.append(" and isStop = ").append(Common.sqlChar(getQ_isStop()));
		if (!"".equals(getQ_roleId()))
			sb.append(" and roleId = ").append(Common.getInteger(getQ_roleId()));
		if (!"".equals(getQ_isDeptManager())) {
			if ("Y".equals(getQ_isDeptManager())) sb.append(" and isDeptManager=").append(Common.sqlChar(getQ_isDeptManager()));
			else sb.append(" and (isDeptManager is null or isDeptManager!='Y') ");
		}
		if ("Y".equals(getQ_isMgr()))
			sb.append(" and roleId = 3");
		if ("N".equals(getQ_isMgr()))
			sb.append(" and roleId!=3");		

		this.processCurrentPageAttribute(ServiceGetter.getInstance().getCommonService().getCommonUserDao().loadCount(sb.toString(), maps));//Modify Ay Apple Su 20140620
		if (getTotalRecord() > 0) {
			if (getState().indexOf("query")<0) 
				ServiceGetter.getInstance().getCommonService().getCommonUserDao().clear();
			
			java.util.List objList = ServiceGetter.getInstance().getCommonService().getCommonUserDao().load(sb.toString(), this.getRecordStart(), this.getPageSize(), "userId", true, maps);//Modify Ay Apple Su 20140620
			if (objList != null && objList.size() > 0) {
				java.util.Iterator it = objList.iterator();
				while (it.hasNext()) {
					CommonUser o = (CommonUser) it.next();					
					
					String rowArray[] = new String[7];
					rowArray[0] = Common.get(o.getId());
					rowArray[1] = Common.get(o.getUserId());
					rowArray[2] = Common.get(o.getUserName());
					rowArray[3] = Common.get(o.getCommonCode()!=null?o.getCommonCode().getCodeName():""); //Common.get(o.getCommonGroup()!=null?o.getCommonGroup().getGroupName():"");					
					rowArray[4] = Common.get(o.getCommonDepartment()!=null?o.getCommonDepartment().getDepartment():"");
					rowArray[5] = Common.get(o.getUserTel());
					rowArray[6] = (o.getRoleId()!=null && o.getRoleId()>2)?"Y":"N";
					//rowArray[6] = View.getRoleName(Common.get(o.getRoleId())); //(o.getRoleId()!=null && o.getRoleId()>2)?"Y":"N";
					arrList.add(rowArray);					
				}
			}
		}
		return arrList;
	}

	public void doUpdatePeraonal() throws Exception {		
		CommonUser obj = (CommonUser)ServiceGetter.getInstance().getCommonService().getCommonUserDao().load(CommonUser.class,Integer.parseInt(getId()));
		if (obj!=null) {
			if(!obj.getUserPwd().equals(Common.getDigestString(getUserPWD(), "SHA-1"))){
				this.setErrorMsg("原密碼輸入有誤，請重新確認!");				
			}
			else{
				obj.setUserSsn(userSSN);
				if (!"".equals(getUserNewPWD()) && getUserNewPWD().length()>0) obj.setUserPwd(Common.getDigestString(userNewPWD,"SHA-1"));
				obj.setUserName(userName);
				obj.setUserBirthday(Datetime.getDateFromRocDateString(userBirthday));
				/**
				if (!"".equals(getDeptId())) {
					CommonDepartment dept = new CommonDepartment();
					dept.setId(Common.getInt(deptId));
					obj.setCommonDepartment(dept);					
				}
				**/
				if (!"".equals(getUserTitle())) {
					CommonCode code = new CommonCode();
					code.setId(Common.getInt(getUserTitle()));
					obj.setCommonCode(code);				
				}
				obj.setUserTel(userTel);
				obj.setUserMobile(userMobile);
				obj.setUserFax(userFax);
				obj.setUserEmail(userEmail);
				obj.setTakeJobDate(takeJobDate);
	
				obj.setMemo(memo);

				obj.setUpdateId(updateId);
			    obj.setUpdateDate(updateDate);
				obj.setUpdateTime(updateTime);
				obj.setUpdateIp(updateIp);
				obj.setUpdateUnitShortName(updateUnitShortName);
				
				ServiceGetter.getInstance().getCommonService().getCommonUserDao().updateCommonUser(obj);
				this.setStateUpdateSuccess();
				this.setErrorMsg("修改完成");
			}
		} else {
			throw new Exception("查無資料");			
		}
	}	
	
	public void importUsersData() throws Exception{
		Database db = new Database(PersistenceServiceGetter.getInstance().getJdbcTemplate().getDataSource().getConnection());
		try {
			int maxTitleCode = Common.getInt(View.getObject("select max(codeId) from CommonCode where commonCodeKind.codeKindId='TIT' "));
			java.util.Map<String, CommonCode> codeMap = new java.util.HashMap<String, CommonCode>();
			java.util.Map<String, CommonDepartment> deptMap = new java.util.HashMap<String, CommonDepartment>();
			
			CommonCodeKind tMaster = null;
			java.util.List list = ServiceGetter.getInstance().getCommonService().load("from CommonCode where commonCodeKind.codeKindId='TIT' ");
			if (list!=null && list.size()>0) {
				for (Object o : list) {
					CommonCode obj = (CommonCode) o;
					codeMap.put(obj.getCodeName(), obj);
					
					tMaster = obj.getCommonCodeKind();
				}
			}
			
			list = ServiceGetter.getInstance().getCommonService().load("from CommonDepartment ");
			if (list!=null && list.size()>0) {
				for (Object o : list) {
					CommonDepartment obj = (CommonDepartment) o;
					deptMap.put(obj.getDepartment(), obj);
				}
			}
			
			CommonGroup commonGroup = (CommonGroup) View.getObject("from CommonGroup order by id desc");
			
			java.util.ArrayList<CommonUser> saveList = new java.util.ArrayList<CommonUser>();
			java.util.ArrayList<CommonCode> codeList = new java.util.ArrayList<CommonCode>();
			java.sql.ResultSet rs = db.querySQL("select deptName, userId, userName, titleName, userEmail from KCCC_USERS",null);
			while (rs.next()) {
				String dName = Common.get(rs.getObject("deptName"));
				String tName = Common.get(rs.getObject("titleName"));
				
				CommonCode t = codeMap.get(tName);
				if (t==null) {
					t = new CommonCode();
					t.setCommonCodeKind(tMaster);
					t.setCodeId(Common.formatFrontZero(String.valueOf(++maxTitleCode), 2));
					t.setCodeName(tName);
					codeList.add(t);
					
					codeMap.put(tName, t);
				}
				
				CommonDepartment d = deptMap.get(dName);
				if (d==null) {
					throw new Exception("查無機關：" + dName);
				}
				
				
				CommonUser u = new CommonUser();
				u.setUserId(Common.get(rs.getObject("userId")));
				u.setUserName(Common.get(rs.getObject("userName")));
				u.setCommonCode(t);
				u.setCommonDepartment(d);
				u.setUserPwd(Common.getDigestString("666666","SHA-1"));
				u.setUserEmail(Common.get(rs.getObject("userEmail")));
				u.setRoleId(1);
				u.setCommonGroup(commonGroup);
				u.setIsStop("N");
				u.setIsDeptManager("N");
				u.setIsAdministrator("N");
				
				saveList.add(u);
								
			}
			
			ServiceGetter.getInstance().getCommonService().save(codeList);
			ServiceGetter.getInstance().getCommonService().save(saveList);
			
			this.setErrorMsg("資料匯入完成");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeAll();
		}
		
	}
	
	
	public java.util.ArrayList<String[]> doQueryOnlineUser() throws Exception {
		java.util.ArrayList<String[]> arrList = new java.util.ArrayList<String[]>();
		java.util.Map<String, CommonUser> h = ServiceGetter.getInstance().getMyServletContext().getOnlistUserMap();
		if (h!=null && h.size()>0) {
			for (String key : h.keySet()) {
				//使用者帳號、登入IP 位址、登入時間、登入狀態(登入成功、失敗)等等
				CommonUser o = (CommonUser) h.get(key);
				String rowArray[] = new String[6];
				rowArray[0] = Common.get(o.getSessionId());
				rowArray[1] = Common.get(o.getUserId());
				rowArray[2] = Common.get(o.getUserName());
				rowArray[3] = Common.get(o.getUserIP());					
				rowArray[4] = Common.formatHHMMSS(o.getLoginTime());
				rowArray[5] = "成功";		
				arrList.add(rowArray);
			}
		}
		return arrList;
	}
	
	
	
	
}


