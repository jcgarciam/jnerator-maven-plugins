package com.jnerator.persistence.persistence;

import java.util.List;
import java.sql.Timestamp;

import com.jnerator.persistence.persistence.pojo.Contact;
/**
 * <p>Generic DAO layer for Contacts</p>
 * <p>Generated at Mon May 30 20:34:57 ART 2011</p>
 *
 * @author Salto-db Generator -v1.0.16- forked as jnerator-persistence-maven-plugin / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public interface ContactDAO extends GenericDAO<Contact,Long> {

	/*
	 * TODO : Add specific businesses daos here.
	 * These methods will be overwrited if you re-generate this interface.
	 * You might want to extend this interface and to change the dao factory to return 
	 * an instance of the new implemenation in buildContactDAO()
	 */
	  	 
	/**
	 * Find Contact by birthDate
	 */
	public List<Contact> findByBirthDate(Timestamp birthDate);

	/**
	 * Find Contact by lastName
	 */
	public List<Contact> findByLastName(String lastName);

	/**
	 * Find Contact by name
	 */
	public List<Contact> findByName(String name);

}