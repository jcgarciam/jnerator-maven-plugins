package com.jnerator.persistence.persistence.hibernate;

import java.util.List;
import java.sql.Timestamp;

import com.jnerator.persistence.persistence.pojo.Relations;
import com.jnerator.persistence.persistence.RelationsDAO;

import org.hibernate.criterion.Restrictions;

/**
 * <p>Hibernate DAO layer for Relationss</p>
 * <p>Generated at Mon May 02 23:14:50 ART 2011</p>
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public class RelationsHibernateDAO extends
		AbstractHibernateDAO<Relations, Integer> implements
		RelationsDAO {

	/**
	 * Find Relations by tenantsId
	 */
	@SuppressWarnings("unchecked")
	public List<Relations> findByTenantsId(Integer tenantsId) {
		return findByCriteria(Restrictions.eq("tenants.tenantsId", tenantsId));
	}
	
	/**
	 * Find Relations by description
	 */
	public List<Relations> findByDescription(String description) {
		return findByCriteria(Restrictions.eq("description", description));
	}
	
	/**
	 * Find Relations by active
	 */
	public List<Relations> findByActive(Boolean active) {
		return findByCriteria(Restrictions.eq("active", active));
	}
	
	/**
	 * Find Relations by version
	 */
	public List<Relations> findByVersion(Integer version) {
		return findByCriteria(Restrictions.eq("version", version));
	}
	

}
