package com.jnerator.persistence.persistence;

import java.util.List;
import java.sql.Timestamp;

import com.jnerator.persistence.persistence.pojo.EventDashboard;
/**
 * <p>Generic DAO layer for EventDashboards</p>
 * <p>Generated at Mon May 02 23:14:49 ART 2011</p>
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public interface EventDashboardDAO extends GenericDAO<EventDashboard,Integer> {

	/*
	 * TODO : Add specific businesses daos here.
	 * These methods will be overwrited if you re-generate this interface.
	 * You might want to extend this interface and to change the dao factory to return 
	 * an instance of the new implemenation in buildEventDashboardDAO()
	 */
	  	 
	/**
	 * Find EventDashboard by uid
	 */
	public List<EventDashboard> findByUid(String uid);

	/**
	 * Find EventDashboard by eventsDefinitionId
	 */
	public List<EventDashboard> findByEventsDefinitionId(Integer eventsDefinitionId);

	/**
	 * Find EventDashboard by eventParticipantsDetailId
	 */
	public List<EventDashboard> findByEventParticipantsDetailId(Integer eventParticipantsDetailId);

	/**
	 * Find EventDashboard by eventParticipantsRespondentsId
	 */
	public List<EventDashboard> findByEventParticipantsRespondentsId(Integer eventParticipantsRespondentsId);

	/**
	 * Find EventDashboard by participantType
	 */
	public List<EventDashboard> findByParticipantType(String participantType);

	/**
	 * Find EventDashboard by lastLogin
	 */
	public List<EventDashboard> findByLastLogin(Timestamp lastLogin);

	/**
	 * Find EventDashboard by status
	 */
	public List<EventDashboard> findByStatus(String status);

	/**
	 * Find EventDashboard by statusDate
	 */
	public List<EventDashboard> findByStatusDate(Timestamp statusDate);

}