package com.jnerator.persistence.persistence;

import java.util.List;
import java.sql.Timestamp;

import com.jnerator.persistence.persistence.pojo.EventParticipantsSurveyTemplateAnswers;
/**
 * <p>Generic DAO layer for EventParticipantsSurveyTemplateAnswerss</p>
 * <p>Generated at Mon May 02 23:14:50 ART 2011</p>
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public interface EventParticipantsSurveyTemplateAnswersDAO extends GenericDAO<EventParticipantsSurveyTemplateAnswers,Integer> {

	/*
	 * TODO : Add specific businesses daos here.
	 * These methods will be overwrited if you re-generate this interface.
	 * You might want to extend this interface and to change the dao factory to return 
	 * an instance of the new implemenation in buildEventParticipantsSurveyTemplateAnswersDAO()
	 */
	  	 
	/**
	 * Find EventParticipantsSurveyTemplateAnswers by eventParticipantsSurveyTemplateId
	 */
	public List<EventParticipantsSurveyTemplateAnswers> findByEventParticipantsSurveyTemplateId(Integer eventParticipantsSurveyTemplateId);

	/**
	 * Find EventParticipantsSurveyTemplateAnswers by longAnswer
	 */
	public List<EventParticipantsSurveyTemplateAnswers> findByLongAnswer(String longAnswer);

	/**
	 * Find EventParticipantsSurveyTemplateAnswers by code
	 */
	public List<EventParticipantsSurveyTemplateAnswers> findByCode(String code);

	/**
	 * Find EventParticipantsSurveyTemplateAnswers by value
	 */
	public List<EventParticipantsSurveyTemplateAnswers> findByValue(Double value);

}