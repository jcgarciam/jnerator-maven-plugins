package com.jnerator.persistence.persistence.hibernate;

import java.util.List;
import java.sql.Timestamp;

import com.jnerator.persistence.persistence.pojo.Competencies;
import com.jnerator.persistence.persistence.CompetenciesDAO;

import org.hibernate.criterion.Restrictions;

/**
 * <p>Hibernate DAO layer for Competenciess</p>
 * <p>Generated at Mon May 02 23:14:49 ART 2011</p>
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public class CompetenciesHibernateDAO extends
		AbstractHibernateDAO<Competencies, Integer> implements
		CompetenciesDAO {

	/**
	 * Find Competencies by tenantsId
	 */
	@SuppressWarnings("unchecked")
	public List<Competencies> findByTenantsId(Integer tenantsId) {
		return findByCriteria(Restrictions.eq("tenants.tenantsId", tenantsId));
	}
	
	/**
	 * Find Competencies by description
	 */
	public List<Competencies> findByDescription(String description) {
		return findByCriteria(Restrictions.eq("description", description));
	}
	
	/**
	 * Find Competencies by active
	 */
	public List<Competencies> findByActive(Boolean active) {
		return findByCriteria(Restrictions.eq("active", active));
	}
	
	/**
	 * Find Competencies by dimensionId
	 */
	@SuppressWarnings("unchecked")
	public List<Competencies> findByDimensionId(Integer dimensionId) {
		return findByCriteria(Restrictions.eq("dimensions.dimensionId", dimensionId));
	}
	
	/**
	 * Find Competencies by version
	 */
	public List<Competencies> findByVersion(Integer version) {
		return findByCriteria(Restrictions.eq("version", version));
	}
	

}
