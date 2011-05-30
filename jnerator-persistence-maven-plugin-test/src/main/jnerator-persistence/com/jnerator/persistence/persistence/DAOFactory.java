package com.jnerator.persistence.persistence;

import com.jnerator.persistence.persistence.hibernate.HibernateDAOFactory;

/**
 * Generated at Mon May 30 20:34:57 ART 2011
 *
 * @see http://www.hibernate.org/328.html
 * @author Salto-db Generator -v1.0.16- forked as jnerator-persistence-maven-plugin / EJB3 + Hibernate DAO
 */

public abstract class DAOFactory {

	private static final DAOFactory HIBERNATE = new HibernateDAOFactory();

    /**
     * Default factory implementation
     */
	public static final DAOFactory DEFAULT = HIBERNATE;
	
	
	public abstract ContactDAO buildContactDAO();
	
	public abstract AddressDAO buildAddressDAO();
	
}
