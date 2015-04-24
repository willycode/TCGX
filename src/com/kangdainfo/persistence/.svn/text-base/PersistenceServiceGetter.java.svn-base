package com.kangdainfo.persistence;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;

public class PersistenceServiceGetter {

    private static PersistenceServiceGetter instance;

    public PersistenceServiceGetter() {
        if(PersistenceServiceGetter.instance != null) {
            throw new RuntimeException(
                    this.getClass().getName()
                            + "is designed to be a Singleton, the instance already exist:"
                            + PersistenceServiceGetter.instance);
        }
        PersistenceServiceGetter.instance = this;
    }
    

    public static PersistenceServiceGetter getInstance() {
        return instance;
    }    
    
    private JdbcTemplate jdbcTemplate;
    private BaseDao baseDao;
    private DataSource dataSource;
    private SessionFactory sessionFactory;
    
	public JdbcTemplate getJdbcTemplate() { return jdbcTemplate; }
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }
	public BaseDao getBaseDao() { return baseDao; }
	public void setBaseDao(BaseDao baseDao) { this.baseDao = baseDao; }
	public DataSource getDataSource() { return dataSource; }
	public void setDataSource(DataSource dataSource) { this.dataSource = dataSource; }	
	public SessionFactory getSessionFactory() {	return sessionFactory;}
	public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}    

}
