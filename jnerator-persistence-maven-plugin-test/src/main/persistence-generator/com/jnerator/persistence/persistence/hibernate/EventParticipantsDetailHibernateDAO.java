package com.jnerator.persistence.persistence.hibernate;

import java.util.List;
import java.sql.Timestamp;

import com.jnerator.persistence.persistence.pojo.EventParticipantsDetail;
import com.jnerator.persistence.persistence.EventParticipantsDetailDAO;

import org.hibernate.criterion.Restrictions;

/**
 * <p>Hibernate DAO layer for EventParticipantsDetails</p>
 * <p>Generated at Mon May 02 23:14:50 ART 2011</p>
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public class EventParticipantsDetailHibernateDAO extends
		AbstractHibernateDAO<EventParticipantsDetail, Integer> implements
		EventParticipantsDetailDAO {

	/**
	 * Find EventParticipantsDetail by eventParticipantsId
	 */
	@SuppressWarnings("unchecked")
	public List<EventParticipantsDetail> findByEventParticipantsId(Integer eventParticipantsId) {
		return findByCriteria(Restrictions.eq("eventParticipants.eventParticipantsId", eventParticipantsId));
	}
	
	/**
	 * Find EventParticipantsDetail by name
	 */
	public List<EventParticipantsDetail> findByName(String name) {
		return findByCriteria(Restrictions.eq("name", name));
	}
	
	/**
	 * Find EventParticipantsDetail by lastname
	 */
	public List<EventParticipantsDetail> findByLastname(String lastname) {
		return findByCriteria(Restrictions.eq("lastname", lastname));
	}
	
	/**
	 * Find EventParticipantsDetail by email
	 */
	public List<EventParticipantsDetail> findByEmail(String email) {
		return findByCriteria(Restrictions.eq("email", email));
	}
	
	/**
	 * Find EventParticipantsDetail by version
	 */
	public List<EventParticipantsDetail> findByVersion(Integer version) {
		return findByCriteria(Restrictions.eq("version", version));
	}
	

}
