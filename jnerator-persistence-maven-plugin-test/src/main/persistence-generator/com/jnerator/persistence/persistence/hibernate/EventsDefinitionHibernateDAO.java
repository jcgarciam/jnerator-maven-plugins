package com.jnerator.persistence.persistence.hibernate;

import java.util.List;
import java.sql.Timestamp;

import com.jnerator.persistence.persistence.pojo.EventsDefinition;
import com.jnerator.persistence.persistence.EventsDefinitionDAO;

import org.hibernate.criterion.Restrictions;

/**
 * <p>Hibernate DAO layer for EventsDefinitions</p>
 * <p>Generated at Mon May 02 23:14:48 ART 2011</p>
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public class EventsDefinitionHibernateDAO extends
		AbstractHibernateDAO<EventsDefinition, Integer> implements
		EventsDefinitionDAO {

	/**
	 * Find EventsDefinition by tenantsId
	 */
	@SuppressWarnings("unchecked")
	public List<EventsDefinition> findByTenantsId(Integer tenantsId) {
		return findByCriteria(Restrictions.eq("tenants.tenantsId", tenantsId));
	}
	
	/**
	 * Find EventsDefinition by projectType
	 */
	public List<EventsDefinition> findByProjectType(String projectType) {
		return findByCriteria(Restrictions.eq("projectType", projectType));
	}
	
	/**
	 * Find EventsDefinition by companyName
	 */
	public List<EventsDefinition> findByCompanyName(String companyName) {
		return findByCriteria(Restrictions.eq("companyName", companyName));
	}
	
	/**
	 * Find EventsDefinition by eventName
	 */
	public List<EventsDefinition> findByEventName(String eventName) {
		return findByCriteria(Restrictions.eq("eventName", eventName));
	}
	
	/**
	 * Find EventsDefinition by contactPhone
	 */
	public List<EventsDefinition> findByContactPhone(String contactPhone) {
		return findByCriteria(Restrictions.eq("contactPhone", contactPhone));
	}
	
	/**
	 * Find EventsDefinition by contactEmail
	 */
	public List<EventsDefinition> findByContactEmail(String contactEmail) {
		return findByCriteria(Restrictions.eq("contactEmail", contactEmail));
	}
	
	/**
	 * Find EventsDefinition by companyManagerName
	 */
	public List<EventsDefinition> findByCompanyManagerName(String companyManagerName) {
		return findByCriteria(Restrictions.eq("companyManagerName", companyManagerName));
	}
	
	/**
	 * Find EventsDefinition by companyManagerEmail
	 */
	public List<EventsDefinition> findByCompanyManagerEmail(String companyManagerEmail) {
		return findByCriteria(Restrictions.eq("companyManagerEmail", companyManagerEmail));
	}
	
	/**
	 * Find EventsDefinition by eventStart
	 */
	public List<EventsDefinition> findByEventStart(Timestamp eventStart) {
		return findByCriteria(Restrictions.eq("eventStart", eventStart));
	}
	
	/**
	 * Find EventsDefinition by eventEnd
	 */
	public List<EventsDefinition> findByEventEnd(Timestamp eventEnd) {
		return findByCriteria(Restrictions.eq("eventEnd", eventEnd));
	}
	
	/**
	 * Find EventsDefinition by delegateTemplateCreation
	 */
	public List<EventsDefinition> findByDelegateTemplateCreation(Boolean delegateTemplateCreation) {
		return findByCriteria(Restrictions.eq("delegateTemplateCreation", delegateTemplateCreation));
	}
	
	/**
	 * Find EventsDefinition by delegatePersonName
	 */
	public List<EventsDefinition> findByDelegatePersonName(String delegatePersonName) {
		return findByCriteria(Restrictions.eq("delegatePersonName", delegatePersonName));
	}
	
	/**
	 * Find EventsDefinition by delegatePersonPhone
	 */
	public List<EventsDefinition> findByDelegatePersonPhone(String delegatePersonPhone) {
		return findByCriteria(Restrictions.eq("delegatePersonPhone", delegatePersonPhone));
	}
	
	/**
	 * Find EventsDefinition by participantsQuantity
	 */
	public List<EventsDefinition> findByParticipantsQuantity(Integer participantsQuantity) {
		return findByCriteria(Restrictions.eq("participantsQuantity", participantsQuantity));
	}
	
	/**
	 * Find EventsDefinition by usersProfileId
	 */
	@SuppressWarnings("unchecked")
	public List<EventsDefinition> findByUsersProfileId(Integer usersProfileId) {
		return findByCriteria(Restrictions.eq("usersProfile.usersProfileId", usersProfileId));
	}
	
	/**
	 * Find EventsDefinition by comments
	 */
	public List<EventsDefinition> findByComments(String comments) {
		return findByCriteria(Restrictions.eq("comments", comments));
	}
	
	/**
	 * Find EventsDefinition by version
	 */
	public List<EventsDefinition> findByVersion(Integer version) {
		return findByCriteria(Restrictions.eq("version", version));
	}
	

}
