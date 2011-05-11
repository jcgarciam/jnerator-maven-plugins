package com.jnerator.persistence.persistence.hibernate;

import java.util.List;
import java.sql.Timestamp;

import com.jnerator.persistence.persistence.pojo.EventParticipantsSurveyTemplate;
import com.jnerator.persistence.persistence.EventParticipantsSurveyTemplateDAO;

import org.hibernate.criterion.Restrictions;

/**
 * <p>Hibernate DAO layer for EventParticipantsSurveyTemplates</p>
 * <p>Generated at Mon May 02 23:14:49 ART 2011</p>
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public class EventParticipantsSurveyTemplateHibernateDAO extends
		AbstractHibernateDAO<EventParticipantsSurveyTemplate, Integer> implements
		EventParticipantsSurveyTemplateDAO {

	/**
	 * Find EventParticipantsSurveyTemplate by eventParticipantsId
	 */
	@SuppressWarnings("unchecked")
	public List<EventParticipantsSurveyTemplate> findByEventParticipantsId(Integer eventParticipantsId) {
		return findByCriteria(Restrictions.eq("eventParticipants.eventParticipantsId", eventParticipantsId));
	}
	
	/**
	 * Find EventParticipantsSurveyTemplate by question
	 */
	public List<EventParticipantsSurveyTemplate> findByQuestion(String question) {
		return findByCriteria(Restrictions.eq("question", question));
	}
	
	/**
	 * Find EventParticipantsSurveyTemplate by answerType
	 */
	public List<EventParticipantsSurveyTemplate> findByAnswerType(String answerType) {
		return findByCriteria(Restrictions.eq("answerType", answerType));
	}
	
	/**
	 * Find EventParticipantsSurveyTemplate by allowComment
	 */
	public List<EventParticipantsSurveyTemplate> findByAllowComment(Byte allowComment) {
		return findByCriteria(Restrictions.eq("allowComment", allowComment));
	}
	

}
