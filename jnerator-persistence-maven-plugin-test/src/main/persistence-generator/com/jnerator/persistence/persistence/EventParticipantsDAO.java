package com.jnerator.persistence.persistence;

import java.util.List;
import java.sql.Timestamp;

import com.jnerator.persistence.persistence.pojo.EventParticipants;
/**
 * <p>Generic DAO layer for EventParticipantss</p>
 * <p>Generated at Mon May 02 23:14:50 ART 2011</p>
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public interface EventParticipantsDAO extends GenericDAO<EventParticipants,Integer> {

	/*
	 * TODO : Add specific businesses daos here.
	 * These methods will be overwrited if you re-generate this interface.
	 * You might want to extend this interface and to change the dao factory to return 
	 * an instance of the new implemenation in buildEventParticipantsDAO()
	 */
	  	 
	/**
	 * Find EventParticipants by tenantsId
	 */
	public List<EventParticipants> findByTenantsId(Integer tenantsId);

	/**
	 * Find EventParticipants by eventsDefinitionId
	 */
	public List<EventParticipants> findByEventsDefinitionId(Integer eventsDefinitionId);

	/**
	 * Find EventParticipants by jobCategoriesId
	 */
	public List<EventParticipants> findByJobCategoriesId(Integer jobCategoriesId);

	/**
	 * Find EventParticipants by revisionStatus
	 */
	public List<EventParticipants> findByRevisionStatus(String revisionStatus);

	/**
	 * Find EventParticipants by revisionStatusDate
	 */
	public List<EventParticipants> findByRevisionStatusDate(Timestamp revisionStatusDate);

	/**
	 * Find EventParticipants by version
	 */
	public List<EventParticipants> findByVersion(Integer version);

}