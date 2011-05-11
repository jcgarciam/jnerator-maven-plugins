package com.jnerator.persistence.persistence.hibernate;

import java.util.List;
import java.sql.Timestamp;

import com.jnerator.persistence.persistence.pojo.Dimensions;
import com.jnerator.persistence.persistence.DimensionsDAO;

import org.hibernate.criterion.Restrictions;

/**
 * <p>Hibernate DAO layer for Dimensionss</p>
 * <p>Generated at Mon May 02 23:14:50 ART 2011</p>
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public class DimensionsHibernateDAO extends
		AbstractHibernateDAO<Dimensions, Integer> implements
		DimensionsDAO {

	/**
	 * Find Dimensions by tenantsId
	 */
	@SuppressWarnings("unchecked")
	public List<Dimensions> findByTenantsId(Integer tenantsId) {
		return findByCriteria(Restrictions.eq("tenants.tenantsId", tenantsId));
	}
	
	/**
	 * Find Dimensions by description
	 */
	public List<Dimensions> findByDescription(String description) {
		return findByCriteria(Restrictions.eq("description", description));
	}
	
	/**
	 * Find Dimensions by active
	 */
	public List<Dimensions> findByActive(Boolean active) {
		return findByCriteria(Restrictions.eq("active", active));
	}
	
	/**
	 * Find Dimensions by jobCategoriesId
	 */
	@SuppressWarnings("unchecked")
	public List<Dimensions> findByJobCategoriesId(Integer jobCategoriesId) {
		return findByCriteria(Restrictions.eq("jobCategories.jobCategoriesId", jobCategoriesId));
	}
	
	/**
	 * Find Dimensions by version
	 */
	public List<Dimensions> findByVersion(Integer version) {
		return findByCriteria(Restrictions.eq("version", version));
	}
	

}
