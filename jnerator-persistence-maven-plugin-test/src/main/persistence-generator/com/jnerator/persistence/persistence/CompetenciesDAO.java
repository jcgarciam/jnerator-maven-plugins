package com.jnerator.persistence.persistence;

import java.util.List;
import java.sql.Timestamp;

import com.jnerator.persistence.persistence.pojo.Competencies;
/**
 * <p>Generic DAO layer for Competenciess</p>
 * <p>Generated at Mon May 02 23:14:49 ART 2011</p>
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public interface CompetenciesDAO extends GenericDAO<Competencies,Integer> {

	/*
	 * TODO : Add specific businesses daos here.
	 * These methods will be overwrited if you re-generate this interface.
	 * You might want to extend this interface and to change the dao factory to return 
	 * an instance of the new implemenation in buildCompetenciesDAO()
	 */
	  	 
	/**
	 * Find Competencies by tenantsId
	 */
	public List<Competencies> findByTenantsId(Integer tenantsId);

	/**
	 * Find Competencies by description
	 */
	public List<Competencies> findByDescription(String description);

	/**
	 * Find Competencies by active
	 */
	public List<Competencies> findByActive(Boolean active);

	/**
	 * Find Competencies by dimensionId
	 */
	public List<Competencies> findByDimensionId(Integer dimensionId);

	/**
	 * Find Competencies by version
	 */
	public List<Competencies> findByVersion(Integer version);

}