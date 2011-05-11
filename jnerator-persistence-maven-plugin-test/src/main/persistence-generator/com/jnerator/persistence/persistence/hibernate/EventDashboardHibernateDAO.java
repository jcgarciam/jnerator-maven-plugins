package com.jnerator.persistence.persistence.hibernate;

import java.util.List;
import java.sql.Timestamp;

import com.jnerator.persistence.persistence.pojo.EventDashboard;
import com.jnerator.persistence.persistence.EventDashboardDAO;

import org.hibernate.criterion.Restrictions;

/**
 * <p>Hibernate DAO layer for EventDashboards</p>
 * <p>Generated at Mon May 02 23:14:49 ART 2011</p>
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public class EventDashboardHibernateDAO extends
		AbstractHibernateDAO<EventDashboard, Integer> implements
		EventDashboardDAO {

	/**
	 * Find EventDashboard by uid
	 */
	public List<EventDashboard> findByUid(String uid) {
		return findByCriteria(Restrictions.eq("uid", uid));
	}
	
	/**
	 * Find EventDashboard by eventsDefinitionId
	 */
	@SuppressWarnings("unchecked")
	public List<EventDashboard> findByEventsDefinitionId(Integer eventsDefinitionId) {
		return findByCriteria(Restrictions.eq("eventsDefinition.eventsDefinitionId", eventsDefinitionId));
	}
	
	/**
	 * Find EventDashboard by eventParticipantsDetailId
	 */
	@SuppressWarnings("unchecked")
	public List<EventDashboard> findByEventParticipantsDetailId(Integer eventParticipantsDetailId) {
		return findByCriteria(Restrictions.eq("eventParticipantsDetail.eventParticipantsDetailId", eventParticipantsDetailId));
	}
	
	/**
	 * Find EventDashboard by eventParticipantsRespondentsId
	 */
	@SuppressWarnings("unchecked")
	public List<EventDashboard> findByEventParticipantsRespondentsId(Integer eventParticipantsRespondentsId) {
		return findByCriteria(Restrictions.eq("eventParticipantsRespondents.eventParticipantsRespondentsId", eventParticipantsRespondentsId));
	}
	
	/**
	 * Find EventDashboard by participantType
	 */
	public List<EventDashboard> findByParticipantType(String participantType) {
		return findByCriteria(Restrictions.eq("participantType", participantType));
	}
	
	/**
	 * Find EventDashboard by lastLogin
	 */
	public List<EventDashboard> findByLastLogin(Timestamp lastLogin) {
		return findByCriteria(Restrictions.eq("lastLogin", lastLogin));
	}
	
	/**
	 * Find EventDashboard by status
	 */
	public List<EventDashboard> findByStatus(String status) {
		return findByCriteria(Restrictions.eq("status", status));
	}
	
	/**
	 * Find EventDashboard by statusDate
	 */
	public List<EventDashboard> findByStatusDate(Timestamp statusDate) {
		return findByCriteria(Restrictions.eq("statusDate", statusDate));
	}
	

}
