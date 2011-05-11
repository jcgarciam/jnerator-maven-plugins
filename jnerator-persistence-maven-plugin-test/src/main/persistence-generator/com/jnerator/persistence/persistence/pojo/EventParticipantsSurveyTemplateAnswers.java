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
 * <p>Pojo mapping TABLE event_participants_survey_template_answers</p>
 * <p></p>
 *
 * <p>Generated at Mon May 02 23:14:50 ART 2011</p>
 * @author Salto-db Generator v1.0.16 / EJB3
 * 
 */
@Entity
@Table(name = "event_participants_survey_template_answers", catalog = "e360db")
@SuppressWarnings("serial")
public class EventParticipantsSurveyTemplateAnswers implements Serializable {

	/**
	 * Attribute id.
	 */
	private Integer id;
	
	/**
	 * Attribute eventParticipantsSurveyTemplate
	 */
	 private EventParticipantsSurveyTemplate eventParticipantsSurveyTemplate;	

	/**
	 * Attribute longAnswer.
	 */
	private String longAnswer;
	
	/**
	 * Attribute code.
	 */
	private String code;
	
	/**
	 * Attribute value.
	 */
	private Double value;
	
	
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
	 * get eventParticipantsSurveyTemplate
	 */
	@ManyToOne
	@JoinColumn(name = "event_participants_survey_template_id")
	public EventParticipantsSurveyTemplate getEventParticipantsSurveyTemplate() {
		return this.eventParticipantsSurveyTemplate;
	}
	
	/**
	 * set eventParticipantsSurveyTemplate
	 */
	public void setEventParticipantsSurveyTemplate(EventParticipantsSurveyTemplate eventParticipantsSurveyTemplate) {
		this.eventParticipantsSurveyTemplate = eventParticipantsSurveyTemplate;
	}

	/**
	 * <p> 
	 * </p>
	 * @return longAnswer
	 */
	@Basic
	@Column(name = "long_answer", length = 50)
		public String getLongAnswer() {
		return longAnswer;
	}

	/**
	 * @param longAnswer new value for longAnswer 
	 */
	public void setLongAnswer(String longAnswer) {
		this.longAnswer = longAnswer;
	}
	
	/**
	 * <p> 
	 * </p>
	 * @return code
	 */
	@Basic
	@Column(name = "code", length = 5)
		public String getCode() {
		return code;
	}

	/**
	 * @param code new value for code 
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * <p> 
	 * </p>
	 * @return value
	 */
	@Basic
	@Column(name = "value")
		public Double getValue() {
		return value;
	}

	/**
	 * @param value new value for value 
	 */
	public void setValue(Double value) {
		this.value = value;
	}
	


}