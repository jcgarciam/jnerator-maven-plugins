package com.jnerator.persistence.persistence.hibernate;

import java.util.List;
import java.sql.Timestamp;

import com.jnerator.persistence.persistence.pojo.EventParticipants;
import com.jnerator.persistence.persistence.EventParticipantsDAO;

import org.hibernate.criterion.Restrictions;

/**
 * <p>Hibernate DAO layer for EventParticipantss</p>
 * <p>Generated at Mon May 02 23:14:50 ART 2011</p>
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public class EventParticipantsHibernateDAO extends
		AbstractHibernateDAO<EventParticipants, Integer> implements
		EventParticipantsDAO {

	/**
	 * Find EventParticipants by tenantsId
	 */
	@SuppressWarnings("unchecked")
	public List<EventParticipants> findByTenantsId(Integer tenantsId) {
		return findByCriteria(Restrictions.eq("tenants.tenantsId", tenantsId));
	}
	
	/**
	 * Find EventParticipants by eventsDefinitionId
	 */
	@SuppressWarnings("unchecked")
	public List<EventParticipants> findByEventsDefinitionId(Integer eventsDefinitionId) {
		return findByCriteria(Restrictions.eq("eventsDefinition.eventsDefinitionId", eventsDefinitionId));
	}
	
	/**
	 * Find EventParticipants by jobCategoriesId
	 */
	@SuppressWarnings("unchecked")
	public List<EventParticipants> findByJobCategoriesId(Integer jobCategoriesId) {
		return findByCriteria(Restrictions.eq("jobCategories.jobCategoriesId", jobCategoriesId));
	}
	
	/**
	 * Find EventParticipants by revisionStatus
	 */
	public List<EventParticipants> findByRevisionStatus(String revisionStatus) {
		return findByCriteria(Restrictions.eq("revisionStatus", revisionStatus));
	}
	
	/**
	 * Find EventParticipants by revisionStatusDate
	 */
	public List<EventParticipants> findByRevisionStatusDate(Timestamp revisionStatusDate) {
		return findByCriteria(Restrictions.eq("revisionStatusDate", revisionStatusDate));
	}
	
	/**
	 * Find EventParticipants by version
	 */
	public List<EventParticipants> findByVersion(Integer version) {
		return findByCriteria(Restrictions.eq("version", version));
	}
	

}
