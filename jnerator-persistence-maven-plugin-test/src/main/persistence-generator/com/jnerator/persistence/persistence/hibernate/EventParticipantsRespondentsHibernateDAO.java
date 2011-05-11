package com.jnerator.persistence.persistence.hibernate;

import java.util.List;
import java.sql.Timestamp;

import com.jnerator.persistence.persistence.pojo.EventParticipantsRespondents;
import com.jnerator.persistence.persistence.EventParticipantsRespondentsDAO;

import org.hibernate.criterion.Restrictions;

/**
 * <p>Hibernate DAO layer for EventParticipantsRespondentss</p>
 * <p>Generated at Mon May 02 23:14:49 ART 2011</p>
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public class EventParticipantsRespondentsHibernateDAO extends
		AbstractHibernateDAO<EventParticipantsRespondents, Integer> implements
		EventParticipantsRespondentsDAO {

	/**
	 * Find EventParticipantsRespondents by eventParticipantsDetailId
	 */
	@SuppressWarnings("unchecked")
	public List<EventParticipantsRespondents> findByEventParticipantsDetailId(Integer eventParticipantsDetailId) {
		return findByCriteria(Restrictions.eq("eventParticipantsDetail.eventParticipantsDetailId", eventParticipantsDetailId));
	}
	
	/**
	 * Find EventParticipantsRespondents by name
	 */
	public List<EventParticipantsRespondents> findByName(String name) {
		return findByCriteria(Restrictions.eq("name", name));
	}
	
	/**
	 * Find EventParticipantsRespondents by lastname
	 */
	public List<EventParticipantsRespondents> findByLastname(String lastname) {
		return findByCriteria(Restrictions.eq("lastname", lastname));
	}
	
	/**
	 * Find EventParticipantsRespondents by email
	 */
	public List<EventParticipantsRespondents> findByEmail(String email) {
		return findByCriteria(Restrictions.eq("email", email));
	}
	
	/**
	 * Find EventParticipantsRespondents by relationsId
	 */
	@SuppressWarnings("unchecked")
	public List<EventParticipantsRespondents> findByRelationsId(Integer relationsId) {
		return findByCriteria(Restrictions.eq("relations.relationsId", relationsId));
	}
	
	/**
	 * Find EventParticipantsRespondents by approvalStatus
	 */
	public List<EventParticipantsRespondents> findByApprovalStatus(String approvalStatus) {
		return findByCriteria(Restrictions.eq("approvalStatus", approvalStatus));
	}
	
	/**
	 * Find EventParticipantsRespondents by approvalDate
	 */
	public List<EventParticipantsRespondents> findByApprovalDate(Timestamp approvalDate) {
		return findByCriteria(Restrictions.eq("approvalDate", approvalDate));
	}
	
	/**
	 * Find EventParticipantsRespondents by version
	 */
	public List<EventParticipantsRespondents> findByVersion(Integer version) {
		return findByCriteria(Restrictions.eq("version", version));
	}
	

}
