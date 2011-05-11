package com.jnerator.persistence.persistence;

import java.util.List;
import java.sql.Timestamp;

import com.jnerator.persistence.persistence.pojo.EventParticipantsRespondents;
/**
 * <p>Generic DAO layer for EventParticipantsRespondentss</p>
 * <p>Generated at Mon May 02 23:14:49 ART 2011</p>
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public interface EventParticipantsRespondentsDAO extends GenericDAO<EventParticipantsRespondents,Integer> {

	/*
	 * TODO : Add specific businesses daos here.
	 * These methods will be overwrited if you re-generate this interface.
	 * You might want to extend this interface and to change the dao factory to return 
	 * an instance of the new implemenation in buildEventParticipantsRespondentsDAO()
	 */
	  	 
	/**
	 * Find EventParticipantsRespondents by eventParticipantsDetailId
	 */
	public List<EventParticipantsRespondents> findByEventParticipantsDetailId(Integer eventParticipantsDetailId);

	/**
	 * Find EventParticipantsRespondents by name
	 */
	public List<EventParticipantsRespondents> findByName(String name);

	/**
	 * Find EventParticipantsRespondents by lastname
	 */
	public List<EventParticipantsRespondents> findByLastname(String lastname);

	/**
	 * Find EventParticipantsRespondents by email
	 */
	public List<EventParticipantsRespondents> findByEmail(String email);

	/**
	 * Find EventParticipantsRespondents by relationsId
	 */
	public List<EventParticipantsRespondents> findByRelationsId(Integer relationsId);

	/**
	 * Find EventParticipantsRespondents by approvalStatus
	 */
	public List<EventParticipantsRespondents> findByApprovalStatus(String approvalStatus);

	/**
	 * Find EventParticipantsRespondents by approvalDate
	 */
	public List<EventParticipantsRespondents> findByApprovalDate(Timestamp approvalDate);

	/**
	 * Find EventParticipantsRespondents by version
	 */
	public List<EventParticipantsRespondents> findByVersion(Integer version);

}