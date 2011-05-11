package com.jnerator.persistence.persistence;

import java.util.List;
import java.sql.Timestamp;

import com.jnerator.persistence.persistence.pojo.Behaviors;
/**
 * <p>Generic DAO layer for Behaviorss</p>
 * <p>Generated at Mon May 02 23:14:50 ART 2011</p>
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public interface BehaviorsDAO extends GenericDAO<Behaviors,Integer> {

	/*
	 * TODO : Add specific businesses daos here.
	 * These methods will be overwrited if you re-generate this interface.
	 * You might want to extend this interface and to change the dao factory to return 
	 * an instance of the new implemenation in buildBehaviorsDAO()
	 */
	  	 
	/**
	 * Find Behaviors by tenantsId
	 */
	public List<Behaviors> findByTenantsId(Integer tenantsId);

	/**
	 * Find Behaviors by description
	 */
	public List<Behaviors> findByDescription(String description);

	/**
	 * Find Behaviors by active
	 */
	public List<Behaviors> findByActive(Boolean active);

	/**
	 * Find Behaviors by competenciesId
	 */
	public List<Behaviors> findByCompetenciesId(Integer competenciesId);

	/**
	 * Find Behaviors by version
	 */
	public List<Behaviors> findByVersion(Integer version);

}