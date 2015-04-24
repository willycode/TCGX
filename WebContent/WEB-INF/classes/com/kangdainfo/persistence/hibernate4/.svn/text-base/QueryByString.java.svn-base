package com.kangdainfo.persistence.hibernate4;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;

public class QueryByString extends BaseQuery {

	public int loadCount(final String queryString) {
        Query query = getSessionFactory().getCurrentSession().createQuery("select count(*) " + queryString);    	
    	Number number = (Number) query.uniqueResult();
    	if(number!=null) {
    		return number.intValue();
    	}
    	return 0;
    }
	public int loadCount(final String queryString, final Map<String, Object> maps) {
        Query query = getSessionFactory().getCurrentSession().createQuery("select count(*) " + queryString);
        if (maps!=null) {
        	for (String key: query.getNamedParameters()) {
        		Object value = maps.get(key);
        		if (null != value) {
        			query.setParameter(key, value);
        		}	
        	}
        }
    	Number number = (Number) query.uniqueResult();
    	if(number!=null) {
    		return number.intValue();
    	}
    	return 0;
	}
	
    public List load(final String queryString) {
        Query query = getSessionFactory().getCurrentSession().createQuery(queryString);
        return query.list();
    }


    public List load(final String queryString, final int startAt, final int size) {
        Query query = getSessionFactory().getCurrentSession().createQuery(queryString);
        query.setFirstResult(startAt);
        query.setMaxResults(size);
        return query.list();
    }
    public List load(final String queryString, final int startAt,
            final int size, final String orderBy, final boolean isAscending) {
        HQL hql = new HQL(queryString);
        hql = hql.appendOrderBy(orderBy, isAscending);
        Query query = getSessionFactory().getCurrentSession().createQuery(hql.toString());
        query.setFirstResult(startAt);
        query.setMaxResults(size);
        return query.list();
    }

    public List load(final String queryString, final Map<String, Object> maps) {
        Query query = getSessionFactory().getCurrentSession().createQuery(queryString);
        if (maps!=null) {
        	for (String key: query.getNamedParameters()) {
        		Object value = maps.get(key);
        		if (null != value) {
        			query.setParameter(key, value);
        		}	
        	}
        }
        return query.list();
    }
    public List load(final String queryString, final int startAt, final int size, final Map<String, Object> maps) {
        Query query = getSessionFactory().getCurrentSession().createQuery(queryString);
        query.setFirstResult(startAt);
        query.setMaxResults(size);
        if (maps!=null) {
        	for (String key: query.getNamedParameters()) {
        		Object value = maps.get(key);
        		if (null != value) {
        			query.setParameter(key, value);
        		}	
        	}
        }
        return query.list();
    }
    public List load(final String queryString, final int startAt,
            final int size, final String orderBy, final boolean isAscending, final Map<String, Object> maps) {
    	HQL hql = new HQL(queryString);
        hql = hql.appendOrderBy(orderBy, isAscending);
        Query query = getSessionFactory().getCurrentSession().createQuery(hql.toString());
        query.setFirstResult(startAt);
        query.setMaxResults(size);
        if (maps!=null) {
        	for (String key: query.getNamedParameters()) {
        		Object value = maps.get(key);
        		if (null != value) {
        			query.setParameter(key, value);
        		}	
        	}
        }
        return query.list();
    }
}
