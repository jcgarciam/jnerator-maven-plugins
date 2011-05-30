package com.jnerator.persistence.persistence.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Generated at Mon May 30 20:34:57 ART 2011
 *
 * @author Salto-db Generator -v1.0.16- forked as jnerator-persistence-maven-plugin / EJB3 + Hibernate DAO
 */
public final class HibernateUtil {

	private static SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		} catch (Throwable ex) {

			throw new ExceptionInInitializerError(ex);
		}
	}

	private HibernateUtil() {

	}

	/**
	 * Returns the SessionFactory used for this static class.
	 * 
	 * @return SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
