package com.jnerator.persistence.persistence.hibernate;

import java.util.List;
import java.sql.Timestamp;

import com.jnerator.persistence.persistence.pojo.JobCategories;
import com.jnerator.persistence.persistence.JobCategoriesDAO;

import org.hibernate.criterion.Restrictions;

/**
 * <p>Hibernate DAO layer for JobCategoriess</p>
 * <p>Generated at Mon May 02 23:14:49 ART 2011</p>
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public class JobCategoriesHibernateDAO extends
		AbstractHibernateDAO<JobCategories, Integer> implements
		JobCategoriesDAO {

	/**
	 * Find JobCategories by tenantsId
	 */
	@SuppressWarnings("unchecked")
	public List<JobCategories> findByTenantsId(Integer tenantsId) {
		return findByCriteria(Restrictions.eq("tenants.tenantsId", tenantsId));
	}
	
	/**
	 * Find JobCategories by description
	 */
	public List<JobCategories> findByDescription(String description) {
		return findByCriteria(Restrictions.eq("description", description));
	}
	
	/**
	 * Find JobCategories by active
	 */
	public List<JobCategories> findByActive(Boolean active) {
		return findByCriteria(Restrictions.eq("active", active));
	}
	
	/**
	 * Find JobCategories by version
	 */
	public List<JobCategories> findByVersion(Integer version) {
		return findByCriteria(Restrictions.eq("version", version));
	}
	

}
