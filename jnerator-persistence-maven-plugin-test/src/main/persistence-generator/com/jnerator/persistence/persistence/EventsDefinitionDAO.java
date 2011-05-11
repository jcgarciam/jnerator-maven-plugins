package com.jnerator.persistence.persistence;

import java.util.List;
import java.sql.Timestamp;

import com.jnerator.persistence.persistence.pojo.EventsDefinition;
/**
 * <p>Generic DAO layer for EventsDefinitions</p>
 * <p>Generated at Mon May 02 23:14:48 ART 2011</p>
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public interface EventsDefinitionDAO extends GenericDAO<EventsDefinition,Integer> {

	/*
	 * TODO : Add specific businesses daos here.
	 * These methods will be overwrited if you re-generate this interface.
	 * You might want to extend this interface and to change the dao factory to return 
	 * an instance of the new implemenation in buildEventsDefinitionDAO()
	 */
	  	 
	/**
	 * Find EventsDefinition by tenantsId
	 */
	public List<EventsDefinition> findByTenantsId(Integer tenantsId);

	/**
	 * Find EventsDefinition by projectType
	 */
	public List<EventsDefinition> findByProjectType(String projectType);

	/**
	 * Find EventsDefinition by companyName
	 */
	public List<EventsDefinition> findByCompanyName(String companyName);

	/**
	 * Find EventsDefinition by eventName
	 */
	public List<EventsDefinition> findByEventName(String eventName);

	/**
	 * Find EventsDefinition by contactPhone
	 */
	public List<EventsDefinition> findByContactPhone(String contactPhone);

	/**
	 * Find EventsDefinition by contactEmail
	 */
	public List<EventsDefinition> findByContactEmail(String contactEmail);

	/**
	 * Find EventsDefinition by companyManagerName
	 */
	public List<EventsDefinition> findByCompanyManagerName(String companyManagerName);

	/**
	 * Find EventsDefinition by companyManagerEmail
	 */
	public List<EventsDefinition> findByCompanyManagerEmail(String companyManagerEmail);

	/**
	 * Find EventsDefinition by eventStart
	 */
	public List<EventsDefinition> findByEventStart(Timestamp eventStart);

	/**
	 * Find EventsDefinition by eventEnd
	 */
	public List<EventsDefinition> findByEventEnd(Timestamp eventEnd);

	/**
	 * Find EventsDefinition by delegateTemplateCreation
	 */
	public List<EventsDefinition> findByDelegateTemplateCreation(Boolean delegateTemplateCreation);

	/**
	 * Find EventsDefinition by delegatePersonName
	 */
	public List<EventsDefinition> findByDelegatePersonName(String delegatePersonName);

	/**
	 * Find EventsDefinition by delegatePersonPhone
	 */
	public List<EventsDefinition> findByDelegatePersonPhone(String delegatePersonPhone);

	/**
	 * Find EventsDefinition by participantsQuantity
	 */
	public List<EventsDefinition> findByParticipantsQuantity(Integer participantsQuantity);

	/**
	 * Find EventsDefinition by usersProfileId
	 */
	public List<EventsDefinition> findByUsersProfileId(Integer usersProfileId);

	/**
	 * Find EventsDefinition by comments
	 */
	public List<EventsDefinition> findByComments(String comments);

	/**
	 * Find EventsDefinition by version
	 */
	public List<EventsDefinition> findByVersion(Integer version);

}