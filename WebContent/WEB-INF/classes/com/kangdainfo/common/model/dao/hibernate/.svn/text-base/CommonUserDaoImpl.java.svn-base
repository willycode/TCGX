package com.kangdainfo.common.model.dao.hibernate;

import com.kangdainfo.common.model.bo.CommonGroup;
import com.kangdainfo.common.model.bo.CommonUser;
import com.kangdainfo.common.model.bo.CommonUserGroup;
import com.kangdainfo.common.model.bo.CommonUserRole;
import com.kangdainfo.common.model.dao.CommonUserDao;
import com.kangdainfo.common.util.Common;
import com.kangdainfo.common.util.Validate;
import com.kangdainfo.common.util.View;
import com.kangdainfo.persistence.hibernate4.BaseDaoImpl;

public class CommonUserDaoImpl extends BaseDaoImpl implements CommonUserDao {
	
    public void saveCommonUser(CommonUser obj) {
    	save(obj);
    }

    public void updateCommonUser(CommonUser obj) {
	    update(obj);
    }

    public void saveOrUpdateCommonUser(CommonUser obj) {
        saveOrUpdate(obj);
    }
	
	public void deleteCommonUser(CommonUser obj) {
		delete(CommonUserRole.class,obj.getId());
		delete(obj);
    }
    
    public void deleteCommonUser(int id) {
		String hql = "from CommonUserGroup where commonUser.id=" + id;
		java.util.List list = this.load(hql);
		if (list!=null && list.size()>0) {
			this.deleteBatch(list);		
		}
    	delete(CommonUserRole.class,id);
	    delete(CommonUser.class,id);
    }  
    
    public CommonUser loadCommonUser(int id) {
    	return (CommonUser) load(CommonUser.class,id);
    }
    
	public CommonUser getCommonUserByUserId(String userId) {
		if (Validate.checkSpecialChar(userId)==false) {
			String hql = "from CommonUser where userId=" + Common.sqlChar(userId);			
			return (CommonUser) getObject(hql);
		}
		return null;
	}    

	public CommonUser saveOrGetVerifiedUser(String userId, String userPwd) throws Exception {
		if (Validate.checkSpecialChar(userId)==false && Validate.checkSpecialChar(userPwd)==false) {			
			String hql = "from CommonUser where userId=" + Common.sqlChar(userId) + 
				" and userPwd=" + Common.sqlChar(Common.getDigestString(userPwd,"SHA-1")) + " and (isStop is null or isStop!='Y') ";			
			CommonUser user = (CommonUser) getObject(hql);
			if (user!=null) return user;
//			
//			else {
//				com.kangdainfo.tbgv.util.FdaAdUtil adUtil = new com.kangdainfo.tbgv.util.FdaAdUtil(userId, userPwd);				
//				if (adUtil.isConnected() && adUtil.getFdaUser()!=null) {
//					hql = "from CommonUser where userId=" + Common.sqlChar(userId);
//					user = (CommonUser) getObject(hql);					
//					CommonDepartment objDept = (CommonDepartment) getObject("from CommonDepartment where fullCode=" + Common.sqlChar(Common.formatRearZero(adUtil.getFdaUser().getDeptNo(),10)));
//					if (user==null) {
//						if (objDept!=null) {
//							user = new CommonUser();
//							user.setUserId(adUtil.getFdaUser().getUserAccount());
//							user.setUserName(adUtil.getFdaUser().getUserName());
//							user.setCommonDepartment(objDept);
//							user.setUserPwd(Common.getDigestString(userPwd,"SHA-1"));
//							user.setUserEmail(adUtil.getFdaUser().getUserEmail());
//							user.setUpdateId("SYS");
//							user.setUpdateDate(Datetime.getYYYMMDD());
//							user.setUpdateTime(Datetime.getHHMMSS());				
//							user.setRoleId(1);
//							user.setIsStop("Y");
//							saveCommonUser(user,null);
//							return user;
//						}						
//					} else {
//						/**
//						if (objDept!=null && user.getCommonDepartment()!=null && user.getCommonDepartment().getId().intValue()!=objDept.getId().intValue()) {							
//							user.setCommonDepartment(objDept);
//							update(user);
//						}
//						**/
//						return user;
//					}
//				}
//			}
		}
		return null;
	}

	public void saveCommonUser(CommonUser obj, int[] groupIds) throws Exception {
		if (obj!=null) {
			save(obj);
			
			CommonUserRole role = new CommonUserRole();
			role.setId(obj.getId());
			role.setRoleId(obj.getRoleId());
			role.setCommonUser(obj);			
			role.setCommonGroup(obj.getCommonGroup());
			save(role);
			
			if (groupIds!=null && groupIds.length>0) {
				
				for (int i=0; i<groupIds.length; i++) {
					CommonUserGroup userGroup = new CommonUserGroup();
					userGroup.setCommonUser(obj);
					
					CommonGroup group = new CommonGroup();
					group.setId(groupIds[i]);
					
					userGroup.setCommonGroup(group);
					userGroup.setUpdateId(obj.getUpdateId());
					userGroup.setUpdateDate(obj.getUpdateDate());
					userGroup.setUpdateTime(obj.getUpdateTime());
					userGroup.setUpdateIp(obj.getUpdateIp());
					userGroup.setUpdateUnitShortName(obj.getUpdateUnitShortName());
					userGroup.setCreateId(obj.getCreateId());
					userGroup.setCreateDate(obj.getCreateDate());
					userGroup.setCreateTime(obj.getCreateTime());
					
					save(userGroup);
				}
			}
		}
	}

	public void updateCommonUser(CommonUser obj, int[] groupIds) throws Exception {
		if (obj!=null && obj.getId()!=null) {
			update(obj);
			
			boolean isUpdate = true;
			CommonUserRole role = (CommonUserRole) View.getObject("from CommonUserRole where id=" + obj.getId());
			if (role==null) {
				role = new CommonUserRole();
				role.setId(obj.getId());
				role.setCommonUser(obj);
				isUpdate = false;
			}
			role.setRoleId(obj.getRoleId());
			role.setCommonGroup(obj.getCommonGroup());	
			if (isUpdate) update(role);
			else save(role);
			
			if (groupIds!=null && groupIds.length>0) {
							
				java.util.Map<Integer, String> h = new java.util.HashMap<Integer,String>();
				String hql = "from CommonUserGroup where commonUser.id=" + obj.getId();
				java.util.List list = this.load(hql);				
				if (list!=null && list.size()>0) {
					for (int i=0; i<list.size(); i++) {
						CommonUserGroup g = (CommonUserGroup) list.get(i);
						h.put(g.getCommonGroup().getId(), "Y");
					}
				}
				
				StringBuilder sb = new StringBuilder().append("-99");
				for (int i=0; i<groupIds.length; i++) {
					sb.append(",").append(groupIds[i]);					
					if (!h.containsKey(groupIds[i])) {
						h.put(groupIds[i], "Y");
						
						CommonUserGroup userGroup = new CommonUserGroup();
						userGroup.setCommonUser(obj);
						
						CommonGroup group = new CommonGroup();
						group.setId(groupIds[i]);
						
						userGroup.setCommonGroup(group);
						userGroup.setUpdateId(obj.getUpdateId());
						userGroup.setUpdateDate(obj.getUpdateDate());
						userGroup.setUpdateTime(obj.getUpdateTime());
						userGroup.setUpdateIp(obj.getUpdateIp());
						userGroup.setUpdateUnitShortName(obj.getUpdateUnitShortName());						
						save(userGroup);						
					}
				}
				if (!sb.toString().equals("-99")) {
					hql = "from CommonUserGroup where commonUser.id=" + obj.getId() + " and commonGroup.id not in (" + sb.toString() + ") ";
					list = this.load(hql);	
					if (list!=null && list.size()>0) {
						this.deleteBatch(list);							
					}					
				}
			} else {
				String hql = "from CommonUserGroup where commonUser.id=" + obj.getId();
				java.util.List list = this.load(hql);	
				if (list!=null && list.size()>0) this.deleteBatch(list);
			}
		}		
	}

}
