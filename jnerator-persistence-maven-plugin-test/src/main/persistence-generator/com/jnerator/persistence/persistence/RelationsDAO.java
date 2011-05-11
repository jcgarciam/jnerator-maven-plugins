package com.jnerator.persistence.persistence;

import java.util.List;
import java.sql.Timestamp;

import com.jnerator.persistence.persistence.pojo.Relations;
/**
 * <p>Generic DAO layer for Relationss</p>
 * <p>Generated at Mon May 02 23:14:50 ART 2011</p>
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public interface RelationsDAO extends GenericDAO<Relations,Integer> {

	/*
	 * TODO : Add specific businesses daos here.
	 * These methods will be overwrited if you re-generate this interface.
	 * You might want to extend this interface and to change the dao factory to return 
	 * an instance of the new implemenation in buildRelationsDAO()
	 */
	  	 
	/**
	 * Find Relations by tenantsId
	 */
	public List<Relations> findByTenantsId(Integer tenantsId);

	/**
	 * Find Relations by description
	 */
	public List<Relations> findByDescription(String description);

	/**
	 * Find Relations by active
	 */
	public List<Relations> findByActive(Boolean active);

	/**
	 * Find Relations by version
	 */
	public List<Relations> findByVersion(Integer version);

}