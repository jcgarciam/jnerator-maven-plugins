package com.jnerator.persistence.persistence;

import java.util.List;
import java.sql.Timestamp;

import com.jnerator.persistence.persistence.pojo.Address;
/**
 * <p>Generic DAO layer for Addresss</p>
 * <p>Generated at Mon May 30 20:34:57 ART 2011</p>
 *
 * @author Salto-db Generator -v1.0.16- forked as jnerator-persistence-maven-plugin / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public interface AddressDAO extends GenericDAO<Address,Long> {

	/*
	 * TODO : Add specific businesses daos here.
	 * These methods will be overwrited if you re-generate this interface.
	 * You might want to extend this interface and to change the dao factory to return 
	 * an instance of the new implemenation in buildAddressDAO()
	 */
	  	 
	/**
	 * Find Address by line1
	 */
	public List<Address> findByLine1(String line1);

	/**
	 * Find Address by line2
	 */
	public List<Address> findByLine2(String line2);

	/**
	 * Find Address by contactId
	 */
	public List<Address> findByContactId(Long contactId);

}