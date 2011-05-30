package com.jnerator.persistence.persistence.hibernate;

import java.util.List;
import java.sql.Timestamp;

import com.jnerator.persistence.persistence.pojo.Contact;
import com.jnerator.persistence.persistence.ContactDAO;

import org.hibernate.criterion.Restrictions;

/**
 * <p>Hibernate DAO layer for Contacts</p>
 * <p>Generated at Mon May 30 20:34:57 ART 2011</p>
 *
 * @author Salto-db Generator -v1.0.16- forked as jnerator-persistence-maven-plugin / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public class ContactHibernateDAO extends
		AbstractHibernateDAO<Contact, Long> implements
		ContactDAO {

	/**
	 * Find Contact by birthDate
	 */
	public List<Contact> findByBirthDate(Timestamp birthDate) {
		return findByCriteria(Restrictions.eq("birthDate", birthDate));
	}
	
	/**
	 * Find Contact by lastName
	 */
	public List<Contact> findByLastName(String lastName) {
		return findByCriteria(Restrictions.eq("lastName", lastName));
	}
	
	/**
	 * Find Contact by name
	 */
	public List<Contact> findByName(String name) {
		return findByCriteria(Restrictions.eq("name", name));
	}
	

}
