package com.jnerator.persistence.persistence.hibernate;

import java.util.List;
import java.sql.Timestamp;

import com.jnerator.persistence.persistence.pojo.EventParticipantsSurveyTemplateAnswers;
import com.jnerator.persistence.persistence.EventParticipantsSurveyTemplateAnswersDAO;

import org.hibernate.criterion.Restrictions;

/**
 * <p>Hibernate DAO layer for EventParticipantsSurveyTemplateAnswerss</p>
 * <p>Generated at Mon May 02 23:14:50 ART 2011</p>
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public class EventParticipantsSurveyTemplateAnswersHibernateDAO extends
		AbstractHibernateDAO<EventParticipantsSurveyTemplateAnswers, Integer> implements
		EventParticipantsSurveyTemplateAnswersDAO {

	/**
	 * Find EventParticipantsSurveyTemplateAnswers by eventParticipantsSurveyTemplateId
	 */
	@SuppressWarnings("unchecked")
	public List<EventParticipantsSurveyTemplateAnswers> findByEventParticipantsSurveyTemplateId(Integer eventParticipantsSurveyTemplateId) {
		return findByCriteria(Restrictions.eq("eventParticipantsSurveyTemplate.eventParticipantsSurveyTemplateId", eventParticipantsSurveyTemplateId));
	}
	
	/**
	 * Find EventParticipantsSurveyTemplateAnswers by longAnswer
	 */
	public List<EventParticipantsSurveyTemplateAnswers> findByLongAnswer(String longAnswer) {
		return findByCriteria(Restrictions.eq("longAnswer", longAnswer));
	}
	
	/**
	 * Find EventParticipantsSurveyTemplateAnswers by code
	 */
	public List<EventParticipantsSurveyTemplateAnswers> findByCode(String code) {
		return findByCriteria(Restrictions.eq("code", code));
	}
	
	/**
	 * Find EventParticipantsSurveyTemplateAnswers by value
	 */
	public List<EventParticipantsSurveyTemplateAnswers> findByValue(Double value) {
		return findByCriteria(Restrictions.eq("value", value));
	}
	

}
