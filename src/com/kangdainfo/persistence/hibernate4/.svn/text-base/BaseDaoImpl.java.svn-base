package com.kangdainfo.persistence.hibernate4;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kangdainfo.persistence.BaseDao;
import com.kangdainfo.persistence.hibernate4.query.params.QueryParams;


public class BaseDaoImpl extends BaseQuery implements BaseDao {

	protected Logger logger = Logger.getLogger(this.getClass());

	private QueryByString queryByString;
	private QueryAll queryAll;
	private QueryByFieldName queryByFieldName;
	private QueryByParameterList queryByParameterList;
	private QueryByParams queryByParams;

	public BaseDaoImpl() {
		queryByString = new QueryByString();
		queryAll = new QueryAll();
		queryByFieldName = new QueryByFieldName();
		queryByParameterList = new QueryByParameterList();
		queryByParams = new QueryByParams();
		queryByParameterList.setQueryAll(queryAll);
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
		queryByString.setSessionFactory(sessionFactory);
		queryAll.setSessionFactory(sessionFactory);
		queryByFieldName.setSessionFactory(sessionFactory);
		queryByParameterList.setSessionFactory(sessionFactory);
		queryByParams.setSessionFactory(sessionFactory);
	}

    public Object load(Class c, int id) { return getSessionFactory().getCurrentSession().get(c,new Integer(id)); }
    public Object load(Class c, long id) { return getSessionFactory().getCurrentSession().get(c,new Long(id)); }
    public Object load(Class c, String id) { return getSessionFactory().getCurrentSession().get(c,id); }
    
	public void save(Object obj) {
		getSessionFactory().getCurrentSession().save(obj);
	}
	public void save(Collection collection) {
		if (collection!=null && collection.size()>0) {
			for (Object bean : collection) {
				getSessionFactory().getCurrentSession().save(bean);
			}			
		}
	}	
	public void saveBatch(Collection list) {
		save(list);
	}
	public void saveBatch(List list, int batchSize) {
		for(int i=0; i < list.size(); i++) {
			getSessionFactory().getCurrentSession().save(list.get(i));
			if(i%batchSize==0 || i==list.size()-1){
				getSessionFactory().getCurrentSession().flush();
				getSessionFactory().getCurrentSession().clear();
			}		
		}
	}	
	public void updateBatch(Collection collection) {
		if (collection!=null && collection.size()>0) {
			for (Object bean : collection) {
				getSessionFactory().getCurrentSession().update(bean);
			}			
		}
	}
	public void saveOrUpdateAll(Collection list) {
		if (list!=null && list.size()>0) {
			for (Object bean : list) {
				getSessionFactory().getCurrentSession().saveOrUpdate(bean);
			}
		}
	}

	public void update(Object obj) { getSessionFactory().getCurrentSession().update(obj); }
	public void saveOrUpdate(Object obj) { getSessionFactory().getCurrentSession().saveOrUpdate(obj); }
	public void delete(Object obj) { getSessionFactory().getCurrentSession().delete(obj); }

	public void delete(Class c, int id) {
		Object obj = load(c,id);
		getSessionFactory().getCurrentSession().delete(obj);
	}
	public void delete(Class c, long id) {
		Object obj = load(c,id);
		getSessionFactory().getCurrentSession().delete(obj);
	}	
	
	public void deleteAll(Class c) {
		List list = loadAll(c);
		if (list!=null && list.size()>0) {
			Session session = this.getSessionFactory().getCurrentSession();
			for (Object obj : list) {
				session.delete(obj);
			}			
		}		
	}
	
	public int updateBulk(UpdateBulkParams updateBulkParams) {
		String sql = updateBulkParams.toString();
		return bulkUpdate(sql);
	}
	
	public int bulkUpdate(String sql) {
		Query queryObject = getSessionFactory().getCurrentSession().createQuery(sql);
		return queryObject.executeUpdate();
	}


	public int loadCount(String queryString) { return queryByString.loadCount(queryString); }
	public int loadCount(String queryString, Map<String, Object> maps) { return queryByString.loadCount(queryString, maps); }
    public List load(String queryString) { return queryByString.load(queryString); }
    public List load(String queryString, int startAt, int size) { return queryByString.load(queryString, startAt, size); }
	public List load(String queryString, int startAt, int size, String orderBy, boolean isAscending) { return queryByString.load(queryString, startAt, size, orderBy, isAscending); }
	public List load(String queryString, Map<String, Object> maps) { return queryByString.load(queryString, maps); }
    public List load(String queryString, int startAt, int size, Map<String, Object> maps) { return queryByString.load(queryString, startAt, size, maps); }
	public List load(String queryString, int startAt, int size, String orderBy, boolean isAscending, Map<String, Object> maps) { return queryByString.load(queryString, startAt, size, orderBy, isAscending, maps); }

	public int loadAllCount(Class c) { return queryAll.loadAllCount(c); }
	public List loadAll(Class c) { return queryAll.loadAll(c); }
    public List loadAll(Class c, String orderBy, boolean isAscending) { return queryAll.loadAll(c, orderBy, isAscending); }
	public List loadAll(Class c, int startAt, int size, String orderBy, boolean isAscending) { return queryAll.loadAll(c, startAt, size, orderBy, isAscending); }


	public int loadCount(Class c, String fieldName, Object fieldValue) { return queryByFieldName.loadCount(c, fieldName, fieldValue) ; }
	public List load(Class c, String fieldName, Object fieldValue){ return queryByFieldName.load(c, fieldName, fieldValue) ; }
	public List load(Class c, String fieldName, Object fieldValue, String orderBy, boolean isAscending) { return queryByFieldName.load(c, fieldName, fieldValue, orderBy, isAscending) ; }
	public List load(Class c, String fieldName, Object fieldValue, int startAt, int size, String orderBy, boolean isAscending) { return queryByFieldName.load(c, fieldName, fieldValue, startAt, size, orderBy, isAscending) ; }
	public Integer loadMaximumByFieldName(Class c, String fieldName) { return queryByFieldName.loadMaximumByFieldName(c, fieldName) ; }
	public List loadDistinctByFieldName(Class c, String fieldName) { return queryByFieldName.loadDistinctByFieldName(c, fieldName) ; }


	public int loadCount(Class c, String fieldName, Object fieldValue[], boolean inFieldValue) { return queryByParameterList.loadCount(c, fieldName, fieldValue, inFieldValue) ;}
    public List load(Class c, String fieldName, Object fieldValue[], boolean inFieldValue) { return queryByParameterList.load(c, fieldName, fieldValue, inFieldValue) ;}
	public List load(Class c, String fieldName, Object fieldValue[], boolean inFieldValue,String orderBy, boolean isAscending) { return queryByParameterList.load(c, fieldName, fieldValue, inFieldValue, orderBy, isAscending) ;}
    public List load(Class c, String fieldName, Object fieldValue[], boolean inFieldValue, String customizedOrderBy) {return queryByParameterList.load(c, fieldName, fieldValue, inFieldValue, customizedOrderBy); }
	public List load(Class c, String fieldName, Object fieldValue[], boolean inFieldValue, int startAt, int size, String orderBy, boolean isAscending) { return queryByParameterList.load(c, fieldName, fieldValue, inFieldValue, startAt, size, orderBy, isAscending); }
	public List load(Class c, String fieldName, Object fieldValue[], boolean inFieldValue, int startAt, int size, String customizedOrderBy)	 { return queryByParameterList.load(c, fieldName, fieldValue, inFieldValue, startAt, size, customizedOrderBy); }

	public int loadObjectsCountByParams(Class objClass, QueryParams params) { return queryByParams.loadObjectsCountByParams(objClass, params);}
    public List loadObjectsByParams(Class objClass, QueryParams params) { return queryByParams.loadObjectsByParams(objClass, params);}
    public List loadObjectsByParams(Class objClass, QueryParams params,String orderBy, boolean isAscending) { return queryByParams.loadObjectsByParams(objClass, params, orderBy, isAscending);}
	public List loadObjectsByParams(Class objClass, QueryParams params, int startAt, int size, String orderBy, boolean isAscending) { return queryByParams.loadObjectsByParams(objClass, params, startAt, size, orderBy, isAscending);}

	public int bulkUpdate(final String queryString, final Object... values) throws Exception {
		Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				queryObject.setParameter(i, values[i]);
			}
		}
		return queryObject.executeUpdate();
	}	



    public Object getObject(String sql) {
        try {
        	List list = this.load(sql, 0, 1);
        	if (list!=null && list.size()>0) {
        		return list.get(0);
        	}
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    	return null;
    }   
    public Object getObject(String hql, Object[] paramArrayOfObject) {
        try {        	
        	List list = find(hql, paramArrayOfObject);
        	if (list!=null && list.size()>0) {
        		return list.get(0);
        	}
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    	return null;
    }      

    public Object[] getObjects(String sql) {
        try {
        	List list = this.load(sql, 0, 1);
        	if (list!=null && list.size()>0) {
        		return (Object[])list.get(0);
        	}
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    	return null;
    } 
    
    public Object[] getObjects(String hql, Object[] paramArrayOfObject) {
        try {
        	List list = find(hql, paramArrayOfObject);
        	if (list!=null && list.size()>0) {
        		return (Object[])list.get(0);
        	}
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    	return null;
    }     
    
    
	public void update(String sql, Object[] o) {
		try {
			this.bulkUpdate(sql, o);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}	
	
	public void deleteAndSave(java.util.Collection delList, java.util.Collection saveList) throws Exception {
		if (delList!=null && delList.size()>0) {
			for (Object bean : delList) {
				getSessionFactory().getCurrentSession().delete(bean);
			}
			this.getSessionFactory().getCurrentSession().flush();
			this.getSessionFactory().getCurrentSession().clear();			
		}
		if (saveList!=null && saveList.size()>0) this.save(saveList);
	}
	
	public void deleteAndSave(String delSQL, java.util.Collection saveList) throws Exception {
		bulkUpdate(delSQL);
		if (saveList!=null && saveList.size()>0) this.save(saveList);		
	}	
	
	public void deleteBatch(java.util.Collection delList) {
		if (delList!=null && delList.size()>0) {
			Session session = this.getSessionFactory().getCurrentSession();
			for (Object obj : delList) {
				session.delete(obj);
			}			
		}		
	}
	
	public void bulkUpdate(String[] arrSQL) throws Exception {
		if (arrSQL!=null && arrSQL.length>0) {
			for (String sql : arrSQL) {
				bulkUpdate(sql);
			}
		}
	}    
	
	public List find(String queryString, Object... values) {
		Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				queryObject.setParameter(i, values[i]);
			}
		}
		return queryObject.list();
	}

	public void clear() {this.getSessionFactory().getCurrentSession().clear();}
	public void flush() {this.getSessionFactory().getCurrentSession().flush();}	
	
}
