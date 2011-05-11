package com.jnerator.persistence.persistence.hibernate;

import java.util.List;
import java.sql.Timestamp;

import com.jnerator.persistence.persistence.pojo.Tenants;
import com.jnerator.persistence.persistence.TenantsDAO;

import org.hibernate.criterion.Restrictions;

/**
 * <p>Hibernate DAO layer for Tenantss</p>
 * <p>Generated at Mon May 02 23:14:48 ART 2011</p>
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public class TenantsHibernateDAO extends
		AbstractHibernateDAO<Tenants, Integer> implements
		TenantsDAO {

	/**
	 * Find Tenants by name
	 */
	public List<Tenants> findByName(String name) {
		return findByCriteria(Restrictions.eq("name", name));
	}
	
	/**
	 * Find Tenants by address
	 */
	public List<Tenants> findByAddress(String address) {
		return findByCriteria(Restrictions.eq("address", address));
	}
	
	/**
	 * Find Tenants by website
	 */
	public List<Tenants> findByWebsite(String website) {
		return findByCriteria(Restrictions.eq("website", website));
	}
	
	/**
	 * Find Tenants by primaryContactName
	 */
	public List<Tenants> findByPrimaryContactName(String primaryContactName) {
		return findByCriteria(Restrictions.eq("primaryContactName", primaryContactName));
	}
	
	/**
	 * Find Tenants by primaryContactPhone
	 */
	public List<Tenants> findByPrimaryContactPhone(String primaryContactPhone) {
		return findByCriteria(Restrictions.eq("primaryContactPhone", primaryContactPhone));
	}
	
	/**
	 * Find Tenants by version
	 */
	public List<Tenants> findByVersion(Integer version) {
		return findByCriteria(Restrictions.eq("version", version));
	}
	

}
