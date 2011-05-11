package com.jnerator.persistence.persistence;

import java.util.List;
import java.sql.Timestamp;

import com.jnerator.persistence.persistence.pojo.EventParticipantsDetail;
/**
 * <p>Generic DAO layer for EventParticipantsDetails</p>
 * <p>Generated at Mon May 02 23:14:50 ART 2011</p>
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public interface EventParticipantsDetailDAO extends GenericDAO<EventParticipantsDetail,Integer> {

	/*
	 * TODO : Add specific businesses daos here.
	 * These methods will be overwrited if you re-generate this interface.
	 * You might want to extend this interface and to change the dao factory to return 
	 * an instance of the new implemenation in buildEventParticipantsDetailDAO()
	 */
	  	 
	/**
	 * Find EventParticipantsDetail by eventParticipantsId
	 */
	public List<EventParticipantsDetail> findByEventParticipantsId(Integer eventParticipantsId);

	/**
	 * Find EventParticipantsDetail by name
	 */
	public List<EventParticipantsDetail> findByName(String name);

	/**
	 * Find EventParticipantsDetail by lastname
	 */
	public List<EventParticipantsDetail> findByLastname(String lastname);

	/**
	 * Find EventParticipantsDetail by email
	 */
	public List<EventParticipantsDetail> findByEmail(String email);

	/**
	 * Find EventParticipantsDetail by version
	 */
	public List<EventParticipantsDetail> findByVersion(Integer version);

}