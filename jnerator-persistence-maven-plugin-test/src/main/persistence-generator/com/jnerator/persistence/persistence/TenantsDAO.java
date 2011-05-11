package com.jnerator.persistence.persistence;

import java.util.List;
import java.sql.Timestamp;

import com.jnerator.persistence.persistence.pojo.Tenants;
/**
 * <p>Generic DAO layer for Tenantss</p>
 * <p>Generated at Mon May 02 23:14:48 ART 2011</p>
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public interface TenantsDAO extends GenericDAO<Tenants,Integer> {

	/*
	 * TODO : Add specific businesses daos here.
	 * These methods will be overwrited if you re-generate this interface.
	 * You might want to extend this interface and to change the dao factory to return 
	 * an instance of the new implemenation in buildTenantsDAO()
	 */
	  	 
	/**
	 * Find Tenants by name
	 */
	public List<Tenants> findByName(String name);

	/**
	 * Find Tenants by address
	 */
	public List<Tenants> findByAddress(String address);

	/**
	 * Find Tenants by website
	 */
	public List<Tenants> findByWebsite(String website);

	/**
	 * Find Tenants by primaryContactName
	 */
	public List<Tenants> findByPrimaryContactName(String primaryContactName);

	/**
	 * Find Tenants by primaryContactPhone
	 */
	public List<Tenants> findByPrimaryContactPhone(String primaryContactPhone);

	/**
	 * Find Tenants by version
	 */
	public List<Tenants> findByVersion(Integer version);

}