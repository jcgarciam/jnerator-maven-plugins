package com.jnerator.persistence.persistence;

import java.util.List;
import java.sql.Timestamp;

import com.jnerator.persistence.persistence.pojo.EventParticipantsSurveyTemplate;
/**
 * <p>Generic DAO layer for EventParticipantsSurveyTemplates</p>
 * <p>Generated at Mon May 02 23:14:49 ART 2011</p>
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public interface EventParticipantsSurveyTemplateDAO extends GenericDAO<EventParticipantsSurveyTemplate,Integer> {

	/*
	 * TODO : Add specific businesses daos here.
	 * These methods will be overwrited if you re-generate this interface.
	 * You might want to extend this interface and to change the dao factory to return 
	 * an instance of the new implemenation in buildEventParticipantsSurveyTemplateDAO()
	 */
	  	 
	/**
	 * Find EventParticipantsSurveyTemplate by eventParticipantsId
	 */
	public List<EventParticipantsSurveyTemplate> findByEventParticipantsId(Integer eventParticipantsId);

	/**
	 * Find EventParticipantsSurveyTemplate by question
	 */
	public List<EventParticipantsSurveyTemplate> findByQuestion(String question);

	/**
	 * Find EventParticipantsSurveyTemplate by answerType
	 */
	public List<EventParticipantsSurveyTemplate> findByAnswerType(String answerType);

	/**
	 * Find EventParticipantsSurveyTemplate by allowComment
	 */
	public List<EventParticipantsSurveyTemplate> findByAllowComment(Byte allowComment);

}