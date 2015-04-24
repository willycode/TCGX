package com.kangdainfo.persistence.hibernate4;

import java.util.List;

import org.hibernate.Query;

public class QueryByFieldName extends BaseQuery {

	public int loadCount(final Class c, final String fieldName, final Object fieldValue) {
		HQL hql = new HQL(getQueryString(c,fieldName));
		hql = hql.appendSelectCount();
		Query query = this.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		setQuery(query,fieldName,fieldValue);
		return ((Number) query.uniqueResult()).intValue();
	}

	public List load(final Class c, final String fieldName, final Object fieldValue) {
		return load(c,fieldName,fieldValue,null,null,null,null);
	}

	public List load(final Class c, final String fieldName, final Object fieldValue,
			final String orderBy, final boolean isAscending) {

		return load(c,fieldName,fieldValue,null,null,orderBy,isAscending);
	}

	public List load(final Class c, final String fieldName, final Object fieldValue,
			final Integer startAt, final Integer size, final String orderBy, final Boolean isAscending) {

		StringBuilder sb = new StringBuilder(getQueryString(c,fieldName));
		if(orderBy!=null) {
			String orderByString = getOrderByString("obj",orderBy,isAscending);
			sb.append(orderByString);
		}
		Query query = getSessionFactory().getCurrentSession().createQuery(sb.toString());
		setQuery(query,fieldName,fieldValue);
		if(startAt!=null && size!=null) {
			query.setFirstResult(startAt);
			query.setMaxResults(size);
		}
		return query.list();
	}
	private String getQueryString(Class c, String fieldName) {
		return "from "+c.getName()+" obj where obj."+fieldName+" = :"+fieldName+" ";
	}


	public Integer loadMaximumByFieldName(final Class c, final String fieldName) {
		HQL hql = new HQL("select max(obj."+fieldName+") from "+c.getName()+" obj");
		Query query = getSessionFactory().getCurrentSession().createQuery(hql.toString());
		return ((Number) query.uniqueResult()).intValue();
	} 
	
	public List loadDistinctByFieldName(final Class c, final String fieldName) {
		HQL hql = new HQL("select distinct(obj."+fieldName+") from "+c.getName()+" obj");
		Query query = getSessionFactory().getCurrentSession().createQuery(hql.toString());
		return query.list();
	}    


}
