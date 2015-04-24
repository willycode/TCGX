package com.kangdainfo.persistence.hibernate4;

import java.util.List;

import org.hibernate.Query;

public class QueryAll extends BaseQuery {

    public int loadAllCount(final Class<?> c) {
        HQL hql = new HQL(getQueryString(c));
        hql = hql.appendSelectCount();
        Query query = getSessionFactory().getCurrentSession().createQuery(hql.toString());        
        Number number = (Number) query.uniqueResult();
    	if(number!=null) {
    		return number.intValue();
    	}
    	return 0;
    }
    
    public List<?> loadAll(Class<?> c) {
    	return loadAll(c,null,null,null,null);
	} 

    public List<?> loadAll(Class<?> c, String orderBy, Boolean isAscending) {
    	return loadAll(c,null,null,orderBy,isAscending);
    }
    public List<?> loadAll(final Class<?> c, 
    		final Integer startAt, final Integer size, final String orderBy, final Boolean isAscending) {
        StringBuffer sb = new StringBuffer(getQueryString(c));
        if(orderBy!=null) {
        	String orderByString = getOrderByString("obj",orderBy,isAscending);
        	sb.append(orderByString);
        }
        Query query = getSessionFactory().getCurrentSession().createQuery(sb.toString());
        if(startAt!=null && size!=null) {
        	query.setFirstResult(startAt);
        	query.setMaxResults(size);
        }
        return query.list();
    }

    private String getQueryString(Class<?> c) {
    	return "from "+c.getName()+" obj";
    }

    
}
