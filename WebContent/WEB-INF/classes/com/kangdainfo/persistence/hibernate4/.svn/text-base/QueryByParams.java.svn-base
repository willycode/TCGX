package com.kangdainfo.persistence.hibernate4;

import java.util.List;

import org.hibernate.Query;

import com.kangdainfo.persistence.hibernate4.query.params.QueryHelper;
import com.kangdainfo.persistence.hibernate4.query.params.QueryParams;


public class QueryByParams extends BaseQuery {

	public int loadObjectsCountByParams(final Class objClass, final QueryParams params) {
		Query query = QueryHelper.createCountQuery(getSessionFactory().getCurrentSession(),objClass, params);
		return ((Number)query.uniqueResult()).intValue();
	}
	
	public List loadObjectsByParams(final Class objClass, final QueryParams params) {
		Query query = QueryHelper.createQuery(getSessionFactory().getCurrentSession(), objClass, params);
		return query.list();
	}
	    
	public List loadObjectsByParams(final Class objClass, final QueryParams params, final String orderBy, final boolean isAscending) {
		Query query = QueryHelper.createQuery(getSessionFactory().getCurrentSession(), objClass,params, orderBy, isAscending);
		return query.list();
	}
	    
	public List loadObjectsByParams(final Class objClass, final QueryParams params, final int startAt, 
			final int size, final String orderBy, final boolean isAscending) {
		Query query = QueryHelper.createQuery(getSessionFactory().getCurrentSession(), objClass, params, startAt, size, orderBy, isAscending);
		return query.list();
	}


		
}
