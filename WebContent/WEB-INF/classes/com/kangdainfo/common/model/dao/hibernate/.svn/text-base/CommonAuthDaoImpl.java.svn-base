package com.kangdainfo.common.model.dao.hibernate;

import com.kangdainfo.ServiceGetter;
import com.kangdainfo.common.model.bo.CommonAuth;
import com.kangdainfo.common.model.bo.CommonDtree;
import com.kangdainfo.common.model.bo.CommonGroup;
import com.kangdainfo.common.model.bo.CommonUserGroup;
import com.kangdainfo.common.model.bo.CommonUserRole;
import com.kangdainfo.common.model.dao.CommonAuthDao;
import com.kangdainfo.common.util.Common;
import com.kangdainfo.common.util.Datetime;
import com.kangdainfo.common.util.Validate;
import com.kangdainfo.persistence.hibernate4.BaseDaoImpl;
import com.kangdainfo.persistence.hibernate4.query.params.QueryParam;
import com.kangdainfo.persistence.hibernate4.query.params.QueryParams;

public class CommonAuthDaoImpl extends BaseDaoImpl implements CommonAuthDao {
	
    public void saveCommonAuth(CommonAuth obj) {
    	save(obj);
    }

    public void updateCommonAuth(CommonAuth obj) {
	    update(obj);
    }

    public void saveOrUpdateCommonAuth(CommonAuth obj) {
        saveOrUpdate(obj);
    }
	
	public void deleteCommonAuth(CommonAuth obj) {
		delete(obj);
    }
    
    public void deleteCommonAuth(int id) {
	    delete(CommonAuth.class,id);
    }    
    
    public CommonAuth loadCommonAuth(int id) {
    	return (CommonAuth) load(CommonAuth.class,id);
    }
    
	public CommonAuth getCommonAuth(String groupID, String treeId) {
		QueryParams q = new QueryParams();
		q.add(new QueryParam("and","commonGroup.id","=",groupID));
		q.add(new QueryParam("and","commonDtree.id","=",treeId));
		java.util.List list = this.loadObjectsByParams(CommonAuth.class, q);
		if (list!=null && list.size()>0) {
			return (CommonAuth) list.get(0);
		}
		return null;
	}
	
	public CommonAuth getCommonAuth(CommonUserRole userRole, String treeId) {
		if (userRole!=null && treeId!=null) {
			Integer[] gids = null;		
			String hql = "from " + CommonUserGroup.class.getCanonicalName() + " where commonUser.id=" + userRole.getId();
			java.util.List list =  load(hql);
			if (list!=null && list.size()>0) {
				gids = new Integer[list.size()];
				for (int i=0; i<list.size(); i++) {
					CommonUserGroup g = (CommonUserGroup) list.get(i);
					gids[i] = g.getCommonGroup().getId();			
				}
			}
			if (gids!=null && gids.length>0) {
				QueryParams q = new QueryParams();
				q.add(new QueryParam("and","commonGroup.id","in",gids));
				q.add(new QueryParam("and","commonDtree.id","=",treeId));
				list = this.loadObjectsByParams(CommonAuth.class, q, "auth", false);
				if (list!=null && list.size()>0) {
					return (CommonAuth) list.get(0);
				}				
			}			
		}
		return null;
	}	
	
	
	public void updateAuth(String optype, String groupId, String[] treeId, String authType, String editId) throws Exception {
		if (optype!=null && optype.length()>0) {
			int i = 0;
			if("add".equals(optype) && treeId!=null && treeId.length>0){				
				for (i=0; i<treeId.length; i++) {					
					CommonAuth objAuth = getCommonAuth(groupId, treeId[i]);
					if (objAuth==null) objAuth = new CommonAuth();
					CommonGroup objGroup = new CommonGroup();
					objGroup.setId(Integer.parseInt(groupId));					
					objAuth.setCommonGroup(objGroup);
					CommonDtree tree = new CommonDtree();
					tree.setId(Long.parseLong(treeId[i]));
					objAuth.setCommonDtree(tree);
					objAuth.setAuth(Integer.parseInt(authType));
					objAuth.setEditId(editId);
					objAuth.setEditDate(Datetime.getYYYMMDD());
					objAuth.setEditTime(Datetime.getHHMMSS());
					this.saveOrUpdateCommonAuth(objAuth);					
				}
			}else if("remove".equals(optype) && treeId!=null && treeId.length>0){				
				for (i=0; i<treeId.length; i++) {
					CommonAuth objAuth = getCommonAuth(groupId, treeId[i]);
					deleteCommonAuth(objAuth);				
				}
			}
		}		
	}

	public CommonAuth[] getPermission(String groupID) throws Exception {
		if (groupID!=null && Validate.checkInt(groupID)) {
			String hql = "from " + CommonAuth.class.getCanonicalName() + " where commonGroup.id=" + groupID + " order by commonDtree.sorted, commonDtree.id ";
			java.util.List list = load(hql);
			if (list!=null && list.size()>0) {
				CommonAuth[] objList = new CommonAuth[list.size()];
				for (int i=0; i<list.size(); i++){
					objList[i] = (CommonAuth) list.get(i);
				}
				return objList;
			}
		}
		return null;
	}	
	
	/**
	 * key = 功能代號<br>
	 * obj[0] = 權限 - int 型態<br>
	 * obj[1] = 功能選單物件 - CommonDtree<br> 
	 * @param sysId
	 * @param userRole
	 * @return
	 * @throws Exception
	 */
	public java.util.Map<String, Object[]> getPermissionMap(String sysId, CommonUserRole userRole) throws Exception {		
		CommonAuth[] auth = getPermission(sysId, userRole);
		return getPermissionMap(auth);
	}
	
	/**
	 * key = 功能代號<br>
	 * obj[0] = 權限 - int 型態<br>
	 * obj[1] = 功能選單物件 - CommonDtree<br> 
	 * @param sysId
	 * @param userRole
	 * @return
	 * @throws Exception
	 */	
	public java.util.Map<String, Object[]> getPermissionMap(CommonAuth[] auth) throws Exception {
		if (auth!=null && auth.length>0) {
			java.util.Map<String, Object[]> h = new java.util.HashMap<String, Object[]>();
			for (int i=0; i<auth.length; i++) {
				CommonAuth authObj = auth[i];				
				CommonDtree dtree = authObj.getCommonDtree();	
				String key = Common.get(dtree.getBtnRead());
				if (!"".equals(key)) {
					Object[] o = new Object[2];
					o[0] = authObj.getAuth();
					o[1] = dtree;					
					h.put(key, o);
				}
			}
			return h;
		}	
		return null;
	}	
	
	public CommonAuth[] getPermission(String sysId, CommonUserRole userRole) throws Exception {
		if (userRole!=null && userRole.getId()!=null) {
			if (userRole.isUserLevel()) {
				StringBuilder sb = new StringBuilder().append("-99");		
				String hql = "from " + CommonUserGroup.class.getCanonicalName() + " where commonUser.id=" + userRole.getId();
				java.util.List list =  load(hql);
				if (list!=null && list.size()>0) {
					for (int i=0; i<list.size(); i++) {
						CommonUserGroup g = (CommonUserGroup) list.get(i);
						sb.append(",").append(g.getCommonGroup().getId());			
					}
				}				
				hql = "from " + CommonAuth.class.getCanonicalName() + " where commonDtree.sysid=" + Common.getInt(sysId) + " and commonGroup.id in (" + sb.toString() + ") order by commonDtree.sorted, commonDtree.id ";
				list = load(hql);
				if (list!=null && list.size()>0) {
					java.util.Map<Long, CommonAuth> h = new java.util.LinkedHashMap<Long, CommonAuth>();				
					for (int i=0; i<list.size(); i++){					
						CommonAuth auth = (CommonAuth) list.get(i);
						
						CommonAuth authed = h.get(auth.getCommonDtree().getId());
						if (authed==null) {
							h.put(auth.getCommonDtree().getId(), auth);
						} else if (auth.getAuth()>authed.getAuth()) {
							h.put(auth.getCommonDtree().getId(), auth);
						}
					}
					if (h!=null && h.size()>0) {
						return h.values().toArray(new CommonAuth[0]);					
					}						
				}				
			} else {				
				java.util.List list = load("from " + CommonDtree.class.getCanonicalName() + " where sysid = " + Common.getInt(sysId) + " order by sorted, pid, id");				
				if (list!=null && list.size()>0) {					
					CommonAuth[] auths = new CommonAuth[list.size()];
					for (int i=0; i<list.size(); i++) { 	
						CommonAuth auth = new CommonAuth();
						auth.setAuth(2);
						auth.setCommonDtree((CommonDtree) list.get(i));	
						auths[i] = auth;							
					}
					return auths;
				}			
			}
		}
		return null;
	}	
	
	
	public CommonDtree[] getPermissionCommonDtree(CommonAuth[] permission) throws Exception {
		if (permission!=null && permission.length>0) {
			java.util.Map<String, CommonDtree> h = this.getPermissionCommonDtreeMap(permission);
			if (h!=null && h.size()>0) {
				return h.values().toArray(new CommonDtree[0]);			
			}
		}
		return null;
	}
	
	public java.util.Map<String, CommonDtree> getPermissionCommonDtreeMap(CommonAuth[] permission) throws Exception {
		if (permission!=null && permission.length>0) {
			java.util.Map<String, CommonDtree> h = new java.util.LinkedHashMap<String, CommonDtree>();			
			for (int i=0; i<permission.length; i++) {
				CommonDtree dt = permission[i].getCommonDtree();
				h.put(dt.getId().toString(), dt);				
			}
			return h;
		}
		return null;
	}
	
	public CommonDtree[] getPermissionCommonDtree(Integer groupID) throws Exception {
		if (groupID!=null) {
			CommonAuth[] objList = getPermission(groupID.toString());
			if (objList!=null && objList.length>0) {
				CommonDtree[] objDtree = new CommonDtree[objList.length];
				for (int i=0; i<objList.length; i++){
					objDtree[i] = objList[i].getCommonDtree();
				}
				return objDtree;
			}
		}
		return null;
	}	
	
	public CommonDtree[] getPermissionCommonDtree(String sysId, CommonUserRole userRole) throws Exception {
		return getPermissionCommonDtree(getPermission(sysId, userRole));
	}	
	
	public java.util.Map<String, CommonDtree> getPermissionCommonDtreeMap(String sysId, CommonUserRole userRole) throws Exception {
		return getPermissionCommonDtreeMap(getPermission(sysId, userRole));
	}

	public String buildCheckBoxTree(String treeID, String treeName, String checkboxName, String checkboxPrefix, String jsFunctionName, String sysId, String groupID, CommonUserRole userRole, boolean bIncludeAll, boolean bUrl, boolean bRootCheckBox) throws Exception {
		CommonAuth[] p = null;
		
		StringBuilder sb = new StringBuilder(1024).append("");
		if (Common.get(treeName).equals("")) treeName = "功能選單";
		
		//建立根節點
		sb.append(treeID).append(".add(");					
		sb.append(sysId).append(",-1,'");		
		if (bRootCheckBox) {
			sb.append("<input type=checkbox id=").append(checkboxPrefix).append(sysId).append(" name=").append(checkboxName).append(" class=checkbox onclick=");
			sb.append(jsFunctionName).append("(this,\"").append(treeName).append("\") value=").append(sysId).append(">");			
		}		
		sb.append(treeName).append("'");
		if (bUrl) sb.append(",'dTreeForm.jsp?sid=").append(sysId).append("&fid=-1'");
		sb.append(");\n");

		CommonDtree[] dt = null;		
		if (bIncludeAll) {
			if (userRole!=null) {
				if (userRole.getRoleId()!=null && userRole.getRoleId()>2) dt = ServiceGetter.getInstance().getCommonService().getCommonDtreeDao().getAllNode(Integer.parseInt(sysId));
				else if (userRole.getId()!=null) dt = this.getPermissionCommonDtree(sysId, userRole);
			} else {
				dt = ServiceGetter.getInstance().getCommonService().getCommonDtreeDao().getAllNode(Integer.parseInt(sysId));
			}			
		} else {
			if (groupID!=null && !"".equals(Common.get(groupID))) {
				p = getPermission(groupID);
				dt = getPermissionCommonDtree(p);
			}
		}
		
		//id, pid, name, url, title, target, icon, iconOpen, open
		if (dt!=null && dt.length>0) {
			for (int i=0; i<dt.length; i++) {
				sb.append(treeID).append(".add(");	
				sb.append(dt[i].getId()).append(",");
				
				if (dt[i].getPid()!=null) sb.append(dt[i].getPid()).append(",");
				else sb.append(sysId).append(",");
				
				boolean isAuthorize = false;
				String cssClass = "";
				if (p!=null && p.length>0) {
					for(int j=0;j<p.length;j++){
						if(p[j].getCommonDtree().getId().equals(dt[i].getId())) {
							isAuthorize = true;
							cssClass = "\"auth" + p[j].getAuth() + "\"";
							break;
						}	
					}					
				}				
				sb.append("'<input type=checkbox id=").append(checkboxPrefix).append(dt[i].getId()).append(" name=").append(checkboxName).append(" class=checkbox onclick=").append(jsFunctionName).append("(this,\"").append(Common.escapeJavaScript(dt[i].getName())).append("\") value=").append(dt[i].getId()).append(">");
				if (isAuthorize) sb.append("<span class=").append(cssClass).append(">").append(Common.escapeJavaScript(dt[i].getName())).append("</span>");
				else sb.append(dt[i].getName());				
				sb.append("',");

				if (bUrl) sb.append("'").append("dTreeForm.jsp?sid=").append(dt[i].getId()).append("&fid=").append(dt[i].getPid()).append("'");
				else sb.append("''");

				sb.append(");\n");
			}
			return sb.toString();
		}		
		
		return sb.toString();
	}
	
	public String buildCheckBoxTree(String treeID, String treeName, String checkboxName, String checkboxPrefix, String jsFunctionName, String sysId, CommonUserRole userRole, boolean bIncludeAll, boolean bUrl, boolean bRootCheckBox) throws Exception {
		CommonAuth[] p = null;
		
		StringBuilder sb = new StringBuilder(1024).append("");
		if (Common.get(treeName).equals("")) treeName = "功能選單";
		
		//建立根節點
		sb.append(treeID).append(".add(");					
		sb.append(sysId).append(",-1,'");		
		if (bRootCheckBox) {
			sb.append("<input type=checkbox id=").append(checkboxPrefix).append(sysId).append(" name=").append(checkboxName).append(" class=checkbox onclick=");
			sb.append(jsFunctionName).append("(this,\"").append(treeName).append("\") value=").append(sysId).append(">");			
		}		
		sb.append(treeName).append("'");
		if (bUrl) sb.append(",'dTreeForm.jsp?sid=").append(sysId).append("&fid=-1'");
		sb.append(");\n");

		CommonDtree[] dt = null;
		
		if (bIncludeAll) dt = ServiceGetter.getInstance().getCommonService().getCommonDtreeDao().getAllNode(Integer.parseInt(sysId));
		else if (userRole!=null && userRole.getId()!=null) {	
			p = this.getPermission(sysId, userRole);
			dt = getPermissionCommonDtree(p);			
		}
		
		//id, pid, name, url, title, target, icon, iconOpen, open
		if (dt!=null && dt.length>0) {
			for (int i=0; i<dt.length; i++) {
				sb.append(treeID).append(".add(");	
				sb.append(dt[i].getId()).append(",");
				
				if (dt[i].getPid()!=null) sb.append(dt[i].getPid()).append(",");
				else sb.append(sysId).append(",");
				
				boolean isAuthorize = false;
				String cssClass = "";
				if (p!=null && p.length>0) {
					for(int j=0;j<p.length;j++){
						if(p[j].getCommonDtree().getId().equals(dt[i].getId())) {
							isAuthorize = true;
							cssClass = "\"auth" + p[j].getAuth() + "\"";
							break;
						}	
					}					
				}				
				sb.append("'<input type=checkbox id=").append(checkboxPrefix).append(dt[i].getId()).append(" name=").append(checkboxName).append(" class=checkbox onclick=").append(jsFunctionName).append("(this,\"").append(Common.escapeJavaScript(dt[i].getName())).append("\") value=").append(dt[i].getId()).append(">");
				if (isAuthorize) sb.append("<span class=").append(cssClass).append(">").append(Common.escapeJavaScript(dt[i].getName())).append("</span>");
				else sb.append(dt[i].getName());				
				sb.append("',");

				if (bUrl) sb.append("'").append("dTreeForm.jsp?sid=").append(dt[i].getId()).append("&fid=").append(dt[i].getPid()).append("'");
				else sb.append("''");

				sb.append(");\n");
			}
			return sb.toString();
		}		
		
		return sb.toString();
	}
	

	public String buildAuthorizeMenu(String treeID, String treeName, String sysId, CommonUserRole userRole) {
		return buildAuthorizeMenu(treeID, treeName, sysId, userRole, null);
		/**
		try {
			StringBuilder sb = new StringBuilder(1024);	
			if (Common.get(treeName).equals("")) treeName = "功能選單";			
			//建立根節點
			sb.append(treeID).append(".add(");					
			sb.append(sysId).append(",-1,'").append(treeName).append("');\n");
			
			CommonDtree[] dt = null;			
			if (userRole!=null && userRole.getRoleId()>=3) {				
				dt = ServiceGetter.getInstance().getCommonService().getCommonDtreeDao().getAllNode(Integer.parseInt(sysId));				
			} else if (userRole!=null){
				//dt = getPermissionCommonDtree(getPermission(""+GBGTRole.getCommonGroup().getId()));				
				//dt = getPermissionCommonDtree(userRole.getCommonGroup().getId());
				dt = getPermissionCommonDtree(sysId, userRole);
			}
			
			//id, pid, name, url, title, target, icon, iconOpen, open
			if (dt!=null && dt.length>0) {
				for (int i=0; i<dt.length; i++) {
					sb.append(treeID).append(".add(").append(dt[i].getId()).append(",");
					
					if (dt[i].getPid()!=null) sb.append(dt[i].getPid()).append(",");
					else sb.append(sysId).append(",");
					
					sb.append(Common.sqlChar(dt[i].getName())).append(",'");										
					if (Common.get(dt[i].getUrl()).indexOf('?')!=-1) {
						sb.append(Common.get(dt[i].getUrl())).append("&progID=").append(dt[i].getId());
					} else {
						sb.append(Common.get(dt[i].getUrl())).append("?progID=").append(dt[i].getId());
					}
					sb.append("',");					
					
					sb.append(Common.sqlChar(dt[i].getTitle())).append(",");
					sb.append(Common.sqlChar(dt[i].getTarget())).append(",");
					sb.append(Common.sqlChar(dt[i].getIcon())).append(",");
					sb.append(Common.sqlChar(dt[i].getIconOpen()));
					sb.append(Common.get(dt[i].getOpened()).equals("Y")?",true":"");
					sb.append(");\n");
				}				
			}
			if (userRole!=null && userRole.getRoleId()>=3) {
				sb.append(treeID).append(".add(-1024," + sysId + ",'系統名稱、程式維護','dTreeFrame.jsp?progID=X');\n");
			}			
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
		**/
	}		
	public String buildAuthorizeMenu(String treeID, String treeName, String sysId, CommonUserRole userRole, String fixedLink) {	
		return buildAuthorizeMenu(treeID, treeName, sysId, userRole, fixedLink, null);
	}
	
	public String buildAuthorizeMenu(String treeID, String treeName, String sysId, CommonUserRole userRole, String fixedLink, String loc) {
		try {
			CommonAuth[] p = null;
			
			//取得該語系全部名稱			
			getLanguageMap(loc);			
			
			StringBuilder sb = new StringBuilder(1024);	
			if (Common.get(treeName).equals("")) treeName = "功能選單";			
			//建立根節點
			sb.append(treeID).append(".add(");					
			sb.append(sysId).append(",-1,'").append(treeName).append("');\n");
			
			CommonDtree[] dt = null;			
			if (userRole!=null && userRole.getRoleId()>=3) {				
				dt = ServiceGetter.getInstance().getCommonService().getCommonDtreeDao().getAllNode(Integer.parseInt(sysId));				
			} else if (userRole!=null){
				p = getPermission(sysId, userRole);
				dt = this.getPermissionCommonDtree(p); //getPermissionCommonDtree(sysId, userRole);
			}
			String name="";
			//id, pid, name, url, title, target, icon, iconOpen, open
			if (dt!=null && dt.length>0) {
				for (int i=0; i<dt.length; i++) {
                    //當語系代碼為中文取原Dtree名稱；其餘取DtreeLanguage裡的名稱
					if(!"zh_TW".equals(Common.get(loc)) && !"".equals(Common.get(dt[i].getId())))
						name = dtreeLanguageName(Common.get(dt[i].getId()),dt[i].getName());           
					else	                       
						name = Common.get(dt[i].getName());
					
					sb.append(treeID).append(".add(").append(dt[i].getId()).append(",");
					
					if (dt[i].getPid()!=null) sb.append(dt[i].getPid()).append(",");
					else sb.append(sysId).append(",");
					//sb.append(Common.sqlChar(name)).append(",'");
					
					if (!"".equals(Common.get(fixedLink))) {
						boolean isAuthorize = false;
						String cssClass = "";
						if (p!=null && p.length>0) {
							for(int j=0;j<p.length;j++){
								if(p[j].getCommonDtree().getId().equals(dt[i].getId())) {
									isAuthorize = true;
									cssClass = "\"auth" + p[j].getAuth() + "\"";
									break;
								}	
							}					
						}						
						if (isAuthorize) sb.append("'<span class=").append(cssClass).append(">").append(Common.get(name)).append("</span>','");
						else sb.append(Common.sqlChar(name)).append(",'");
						if (!"".equals(Common.get(fixedLink))) {
							if (Common.get(fixedLink).indexOf('?')!=-1) {
								sb.append(Common.get(fixedLink)).append("&progID=").append(dt[i].getId());
							} else {
								sb.append(Common.get(fixedLink)).append("?progID=").append(dt[i].getId());
							}							
						}							
					} else {
						sb.append(Common.sqlChar(name)).append(",'");
						if (Common.get(dt[i].getUrl()).indexOf('?')!=-1) {
							sb.append(Common.get(dt[i].getUrl())).append("&progID=").append(dt[i].getId());
						} else {
							sb.append(Common.get(dt[i].getUrl())).append("?progID=").append(dt[i].getId());
						}						
					}
					sb.append("',");					
					
					sb.append(Common.sqlChar(dt[i].getTitle())).append(",");
					sb.append(Common.sqlChar(dt[i].getTarget())).append(",");
					sb.append(Common.sqlChar(dt[i].getIcon())).append(",");
					sb.append(Common.sqlChar(dt[i].getIconOpen()));
					sb.append(Common.get(dt[i].getOpened()).equals("Y")?",true":"");
					sb.append(");\n");
				}				
			}
			if ("".equals(Common.get(fixedLink)) && userRole!=null && userRole.getRoleId()>=3) {
				sb.append(treeID).append(".add(-1024," + sysId + ",'系統名稱、程式維護','dTreeFrame.jsp?progID=X');\n");
			}			
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}	
	
	public String buildAuthorizeMenu(String treeID, String treeName, String sysId, String groupID, String isAdmin) {
		CommonGroup g = new CommonGroup();
		g.setId(Integer.parseInt(groupID));
		
		CommonUserRole r = new CommonUserRole();
		r.setCommonGroup(g);
		
		if (isAdmin!=null && isAdmin.equals("Y")) r.setRoleId(3);			
		else r.setRoleId(1);

		return buildAuthorizeMenu(treeID, treeName, sysId, r);
	}
	
	java.util.Map<String, String> locMap = null;
	//先一次把該語系代碼的名稱取出來  
	public void getLanguageMap(String languageKind) 	
	{
		locMap = new java.util.HashMap<String,String>();   
		java.util.List list = ServiceGetter.getInstance().getCommonService().load("select commonDtree.id,name from CommonDtreeLocName where codeId="+Common.sqlChar(languageKind));   
		if (list!=null && list.size()>0)   
		{		   
			for (int i=0; i<list.size(); i++)	   
			{		   
				Object[] o = (Object[]) list.get(i);		   
				locMap.put(Common.get(o[0]), Common.get(o[1]));		   
			}   
		}	   
		list.clear();
	}
	
	public String dtreeLanguageName(String treeID, String dtreeName)
	{
		String name = dtreeName;
		if(locMap != null){
			if(locMap.get(treeID)!=null){
				name = locMap.get(treeID);
			}
		}						
		return name;
	}
	    

}
