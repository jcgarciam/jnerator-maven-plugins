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
 * <p>Pojo mapping TABLE event_dashboard</p>
 * <p></p>
 *
 * <p>Generated at Mon May 02 23:14:49 ART 2011</p>
 * @author Salto-db Generator v1.0.16 / EJB3
 * 
 */
@Entity
@Table(name = "event_dashboard", catalog = "e360db")
@SuppressWarnings("serial")
public class EventDashboard implements Serializable {

	/**
	 * Attribute uid.
	 */
	private String uid;
	
	/**
	 * Attribute eventsDefinition
	 */
	 private EventsDefinition eventsDefinition;	

	/**
	 * Attribute eventParticipantsDetail
	 */
	 private EventParticipantsDetail eventParticipantsDetail;	

	/**
	 * Attribute eventParticipantsRespondents
	 */
	 private EventParticipantsRespondents eventParticipantsRespondents;	

	/**
	 * Attribute participantType.
	 */
	private String participantType;
	
	/**
	 * Attribute lastLogin.
	 */
	private Timestamp lastLogin;
	
	/**
	 * Attribute status.
	 */
	private String status;
	
	/**
	 * Attribute statusDate.
	 */
	private Timestamp statusDate;
	
	/**
	 * Attribute id.
	 */
	private Integer id;
	
	
	/**
	 * <p>UUID() 
	 * </p>
	 * @return uid
	 */
	@Basic
	@Column(name = "uid", length = 32)
		public String getUid() {
		return uid;
	}

	/**
	 * @param uid new value for uid 
	 */
	public void setUid(String uid) {
		this.uid = uid;
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
	 * get eventParticipantsDetail
	 */
	@ManyToOne
	@JoinColumn(name = "event_participants_detail_id")
	public EventParticipantsDetail getEventParticipantsDetail() {
		return this.eventParticipantsDetail;
	}
	
	/**
	 * set eventParticipantsDetail
	 */
	public void setEventParticipantsDetail(EventParticipantsDetail eventParticipantsDetail) {
		this.eventParticipantsDetail = eventParticipantsDetail;
	}

	/**
	 * get eventParticipantsRespondents
	 */
	@ManyToOne
	@JoinColumn(name = "event_participants_respondents_id")
	public EventParticipantsRespondents getEventParticipantsRespondents() {
		return this.eventParticipantsRespondents;
	}
	
	/**
	 * set eventParticipantsRespondents
	 */
	public void setEventParticipantsRespondents(EventParticipantsRespondents eventParticipantsRespondents) {
		this.eventParticipantsRespondents = eventParticipantsRespondents;
	}

	/**
	 * <p>Participant or Respondant flag 
	 * </p>
	 * @return participantType
	 */
	@Basic
	@Column(name = "participant_type", length = 2)
		public String getParticipantType() {
		return participantType;
	}

	/**
	 * @param participantType new value for participantType 
	 */
	public void setParticipantType(String participantType) {
		this.participantType = participantType;
	}
	
	/**
	 * <p> 
	 * </p>
	 * @return lastLogin
	 */
	@Basic
	@Column(name = "last_login")
		public Timestamp getLastLogin() {
		return lastLogin;
	}

	/**
	 * @param lastLogin new value for lastLogin 
	 */
	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	/**
	 * <p>Editing
Finished
Blocked 
	 * </p>
	 * @return status
	 */
	@Basic
	@Column(name = "status", length = 2)
		public String getStatus() {
		return status;
	}

	/**
	 * @param status new value for status 
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * <p> 
	 * </p>
	 * @return statusDate
	 */
	@Basic
	@Column(name = "status_date")
		public Timestamp getStatusDate() {
		return statusDate;
	}

	/**
	 * @param statusDate new value for statusDate 
	 */
	public void setStatusDate(Timestamp statusDate) {
		this.statusDate = statusDate;
	}
	
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
	


}