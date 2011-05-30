package com.jnerator.persistence.persistence.hibernate;

import com.jnerator.persistence.persistence.DAOFactory;
import com.jnerator.persistence.persistence.ContactDAO;
import com.jnerator.persistence.persistence.AddressDAO;

/**
 * Generated at Mon May 30 20:34:57 ART 2011
 *
 * @see http://www.hibernate.org/43.html
 * @author Salto-db Generator -v1.0.16- forked as jnerator-persistence-maven-plugin / EJB3 + Hibernate DAO
 */
public class HibernateDAOFactory extends DAOFactory {

	/* (non-Javadoc)
	 * @see com.jnerator.persistence.persistence.DAOFactory#buildContactDAO()
	 */
	@Override
	public ContactDAO buildContactDAO() {
		return new ContactHibernateDAO();
	}
	
	/* (non-Javadoc)
	 * @see com.jnerator.persistence.persistence.DAOFactory#buildAddressDAO()
	 */
	@Override
	public AddressDAO buildAddressDAO() {
		return new AddressHibernateDAO();
	}
	
}
