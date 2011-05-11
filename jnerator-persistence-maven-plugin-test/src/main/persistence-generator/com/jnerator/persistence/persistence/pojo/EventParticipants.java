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
 * <p>Pojo mapping TABLE event_participants</p>
 * <p></p>
 *
 * <p>Generated at Mon May 02 23:14:50 ART 2011</p>
 * @author Salto-db Generator v1.0.16 / EJB3
 * 
 */
@Entity
@Table(name = "event_participants", catalog = "e360db")
@SuppressWarnings("serial")
public class EventParticipants implements Serializable {

	/**
	 * Attribute id.
	 */
	private Integer id;
	
	/**
	 * Attribute tenants
	 */
	 private Tenants tenants;	

	/**
	 * Attribute eventsDefinition
	 */
	 private EventsDefinition eventsDefinition;	

	/**
	 * Attribute jobCategories
	 */
	 private JobCategories jobCategories;	

	/**
	 * Attribute revisionStatus.
	 */
	private String revisionStatus;
	
	/**
	 * Attribute revisionStatusDate.
	 */
	private Timestamp revisionStatusDate;
	
	/**
	 * Attribute version.
	 */
	private Integer version;
	
	/**
	 * List of EventParticipantsDetail
	 */
	private List<EventParticipantsDetail> eventParticipantsDetails = null;

	/**
	 * List of EventParticipantsSurveyTemplate
	 */
	private List<EventParticipantsSurveyTemplate> eventParticipantsSurveyTemplates = null;

	
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
	 * get tenants
	 */
	@ManyToOne
	@JoinColumn(name = "tenants_id")
	public Tenants getTenants() {
		return this.tenants;
	}
	
	/**
	 * set tenants
	 */
	public void setTenants(Tenants tenants) {
		this.tenants = tenants;
	}

	/**
	 * get eventsDefinition
	 */
	@ManyToOne
	@JoinColumn(name = "events_definition_id")
	public EventsDefinition getEventsDefinition() {
		return this.eventsDefinition;
	}
	
	/**
	 * set eventsDefinition
	 */
	public void setEventsDefinition(EventsDefinition eventsDefinition) {
		this.eventsDefinition = eventsDefinition;
	}

	/**
	 * get jobCategories
	 */
	@ManyToOne
	@JoinColumn(name = "job_categories_id")
	public JobCategories getJobCategories() {
		return this.jobCategories;
	}
	
	/**
	 * set jobCategories
	 */
	public void setJobCategories(JobCategories jobCategories) {
		this.jobCategories = jobCategories;
	}

	/**
	 * <p>REL = RELEASED TO PARTICIPANTS TO FILL THE SURVEY
FOR=FOR REVIEWING
INP=IN PROGRESS 
	 * </p>
	 * @return revisionStatus
	 */
	@Basic
	@Column(name = "revision_status", length = 4)
		public String getRevisionStatus() {
		return revisionStatus;
	}

	/**
	 * @param revisionStatus new value for revisionStatus 
	 */
	public void setRevisionStatus(String revisionStatus) {
		this.revisionStatus = revisionStatus;
	}
	
	/**
	 * <p> 
	 * </p>
	 * @return revisionStatusDate
	 */
	@Basic
	@Column(name = "revision_status_date")
		public Timestamp getRevisionStatusDate() {
		return revisionStatusDate;
	}

	/**
	 * @param revisionStatusDate new value for revisionStatusDate 
	 */
	public void setRevisionStatusDate(Timestamp revisionStatusDate) {
		this.revisionStatusDate = revisionStatusDate;
	}
	
	/**
	 * <p> 
	 * </p>
	 * @return version
	 */
	@Basic
	@Column(name = "version")
		public Integer getVersion() {
		return version;
	}

	/**
	 * @param version new value for version 
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	/**
	 * Get the list of EventParticipantsDetail
	 */
	 @OneToMany(mappedBy="eventParticipants")
	 public List<EventParticipantsDetail> getEventParticipantsDetails() {
	 	return this.eventParticipantsDetails;
	 }
	 
	/**
	 * Set the list of EventParticipantsDetail
	 */
	 public void setEventParticipantsDetails(List<EventParticipantsDetail> eventParticipantsDetails) {
	 	this.eventParticipantsDetails = eventParticipantsDetails;
	 }
	/**
	 * Get the list of EventParticipantsSurveyTemplate
	 */
	 @OneToMany(mappedBy="eventParticipants")
	 public List<EventParticipantsSurveyTemplate> getEventParticipantsSurveyTemplates() {
	 	return this.eventParticipantsSurveyTemplates;
	 }
	 
	/**
	 * Set the list of EventParticipantsSurveyTemplate
	 */
	 public void setEventParticipantsSurveyTemplates(List<EventParticipantsSurveyTemplate> eventParticipantsSurveyTemplates) {
	 	this.eventParticipantsSurveyTemplates = eventParticipantsSurveyTemplates;
	 }


}