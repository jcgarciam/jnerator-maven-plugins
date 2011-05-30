package com.jnerator.persistence.persistence.hibernate;

import java.util.List;
import java.sql.Timestamp;

import com.jnerator.persistence.persistence.pojo.Address;
import com.jnerator.persistence.persistence.AddressDAO;

import org.hibernate.criterion.Restrictions;

/**
 * <p>Hibernate DAO layer for Addresss</p>
 * <p>Generated at Mon May 30 20:34:57 ART 2011</p>
 *
 * @author Salto-db Generator -v1.0.16- forked as jnerator-persistence-maven-plugin / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public class AddressHibernateDAO extends
		AbstractHibernateDAO<Address, Long> implements
		AddressDAO {

	/**
	 * Find Address by line1
	 */
	public List<Address> findByLine1(String line1) {
		return findByCriteria(Restrictions.eq("line1", line1));
	}
	
	/**
	 * Find Address by line2
	 */
	public List<Address> findByLine2(String line2) {
		return findByCriteria(Restrictions.eq("line2", line2));
	}
	
	/**
	 * Find Address by contactId
	 */
	@SuppressWarnings("unchecked")
	public List<Address> findByContactId(Long contactId) {
		return findByCriteria(Restrictions.eq("contact.contactId", contactId));
	}
	

}
