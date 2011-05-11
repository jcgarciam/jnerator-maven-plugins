package com.jnerator.persistence.persistence;

import java.util.List;
import java.sql.Timestamp;

import com.jnerator.persistence.persistence.pojo.Dimensions;
/**
 * <p>Generic DAO layer for Dimensionss</p>
 * <p>Generated at Mon May 02 23:14:50 ART 2011</p>
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public interface DimensionsDAO extends GenericDAO<Dimensions,Integer> {

	/*
	 * TODO : Add specific businesses daos here.
	 * These methods will be overwrited if you re-generate this interface.
	 * You might want to extend this interface and to change the dao factory to return 
	 * an instance of the new implemenation in buildDimensionsDAO()
	 */
	  	 
	/**
	 * Find Dimensions by tenantsId
	 */
	public List<Dimensions> findByTenantsId(Integer tenantsId);

	/**
	 * Find Dimensions by description
	 */
	public List<Dimensions> findByDescription(String description);

	/**
	 * Find Dimensions by active
	 */
	public List<Dimensions> findByActive(Boolean active);

	/**
	 * Find Dimensions by jobCategoriesId
	 */
	public List<Dimensions> findByJobCategoriesId(Integer jobCategoriesId);

	/**
	 * Find Dimensions by version
	 */
	public List<Dimensions> findByVersion(Integer version);

}