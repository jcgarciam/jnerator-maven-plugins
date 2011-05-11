package com.jnerator.persistence.persistence.hibernate;

import java.util.List;
import java.sql.Timestamp;

import com.jnerator.persistence.persistence.pojo.Behaviors;
import com.jnerator.persistence.persistence.BehaviorsDAO;

import org.hibernate.criterion.Restrictions;

/**
 * <p>Hibernate DAO layer for Behaviorss</p>
 * <p>Generated at Mon May 02 23:14:50 ART 2011</p>
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public class BehaviorsHibernateDAO extends
		AbstractHibernateDAO<Behaviors, Integer> implements
		BehaviorsDAO {

	/**
	 * Find Behaviors by tenantsId
	 */
	@SuppressWarnings("unchecked")
	public List<Behaviors> findByTenantsId(Integer tenantsId) {
		return findByCriteria(Restrictions.eq("tenants.tenantsId", tenantsId));
	}
	
	/**
	 * Find Behaviors by description
	 */
	public List<Behaviors> findByDescription(String description) {
		return findByCriteria(Restrictions.eq("description", description));
	}
	
	/**
	 * Find Behaviors by active
	 */
	public List<Behaviors> findByActive(Boolean active) {
		return findByCriteria(Restrictions.eq("active", active));
	}
	
	/**
	 * Find Behaviors by competenciesId
	 */
	@SuppressWarnings("unchecked")
	public List<Behaviors> findByCompetenciesId(Integer competenciesId) {
		return findByCriteria(Restrictions.eq("competencies.competenciesId", competenciesId));
	}
	
	/**
	 * Find Behaviors by version
	 */
	public List<Behaviors> findByVersion(Integer version) {
		return findByCriteria(Restrictions.eq("version", version));
	}
	

}
