package com.jnerator.persistence.persistence;

import java.util.List;
import java.sql.Timestamp;

import com.jnerator.persistence.persistence.pojo.JobCategories;
/**
 * <p>Generic DAO layer for JobCategoriess</p>
 * <p>Generated at Mon May 02 23:14:49 ART 2011</p>
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public interface JobCategoriesDAO extends GenericDAO<JobCategories,Integer> {

	/*
	 * TODO : Add specific businesses daos here.
	 * These methods will be overwrited if you re-generate this interface.
	 * You might want to extend this interface and to change the dao factory to return 
	 * an instance of the new implemenation in buildJobCategoriesDAO()
	 */
	  	 
	/**
	 * Find JobCategories by tenantsId
	 */
	public List<JobCategories> findByTenantsId(Integer tenantsId);

	/**
	 * Find JobCategories by description
	 */
	public List<JobCategories> findByDescription(String description);

	/**
	 * Find JobCategories by active
	 */
	public List<JobCategories> findByActive(Boolean active);

	/**
	 * Find JobCategories by version
	 */
	public List<JobCategories> findByVersion(Integer version);

}