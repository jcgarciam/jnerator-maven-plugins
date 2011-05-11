package com.jnerator.persistence.persistence.pojo;

import java.util.List;
import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.persistence.Embeddable;

/**
 * <p>Pojo mapping TABLE event_participants_survey_template</p>
 * <p></p>
 *
 * <p>Generated at Mon May 02 23:14:48 ART 2011</p>
 * @author Salto-db Generator v1.0.16 / EJB3
 * 
 */
@Entity
@Table(name = "event_participants_survey_template", catalog = "e360db")
@SuppressWarnings("serial")
public class EventParticipantsSurveyTemplate implements Serializable {

	/**
	 * Attribute id.
	 */
	private Integer id;
	
	/**
	 * Attribute eventParticipants
	 */
	 private EventParticipants eventParticipants;	

	/**
	 * Attribute question.
	 */
	private String question;
	
	/**
	 * Attribute answerType.
	 */
	private String answerType;
	
	/**
	 * Attribute allowComment.
	 */
	private Byte allowComment;
	
	/**
	 * List of EventParticipantsSurveyTemplateAnswers
	 */
	private List<EventParticipantsSurveyTemplateAnswers> eventParticipantsSurveyTemplateAnswerss = null;

	
	/**
	 * <p> 
	 * </p>
	 * @return id
	 */
	@Basic
	@Id
	@GeneratedValue
	@Column(name = "id")
		public Integer getId() {
		return id;
	}

	/**
	 * @param id new value for id 
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * get eventParticipants
	 */
	@ManyToOne
	@JoinColumn(name = "event_participants_id")
	public EventParticipants getEventParticipants() {
		return this.eventParticipants;
	}
	
	/**
	 * set eventParticipants
	 */
	public void setEventParticipants(EventParticipants eventParticipants) {
		this.eventParticipants = eventParticipants;
	}

	/**
	 * <p> 
	 * </p>
	 * @return question
	 */
	@Basic
	@Column(name = "question", length = 300)
		public String getQuestion() {
		return question;
	}

	/**
	 * @param question new value for question 
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	
	/**
	 * <p> 
	 * </p>
	 * @return answerType
	 */
	@Basic
	@Column(name = "answer_type", length = 8)
		public String getAnswerType() {
		return answerType;
	}

	/**
	 * @param answerType new value for answerType 
	 */
	public void setAnswerType(String answerType) {
		this.answerType = answerType;
	}
	
	/**
	 * <p> 
	 * </p>
	 * @return allowComment
	 */
	@Basic
	@Column(name = "allow_comment")
		public Byte getAllowComment() {
		return allowComment;
	}

	/**
	 * @param allowComment new value for allowComment 
	 */
	public void setAllowComment(Byte allowComment) {
		this.allowComment = allowComment;
	}
	
	/**
	 * Get the list of EventParticipantsSurveyTemplateAnswers
	 */
	 @OneToMany(mappedBy="eventParticipantsSurveyTemplate")
	 public List<EventParticipantsSurveyTemplateAnswers> getEventParticipantsSurveyTemplateAnswerss() {
	 	return this.eventParticipantsSurveyTemplateAnswerss;
	 }
	 
	/**
	 * Set the list of EventParticipantsSurveyTemplateAnswers
	 */
	 public void setEventParticipantsSurveyTemplateAnswerss(List<EventParticipantsSurveyTemplateAnswers> eventParticipantsSurveyTemplateAnswerss) {
	 	this.eventParticipantsSurveyTemplateAnswerss = eventParticipantsSurveyTemplateAnswerss;
	 }


}