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
 * <p>Pojo mapping TABLE event_participants_detail</p>
 * <p></p>
 *
 * <p>Generated at Mon May 02 23:14:49 ART 2011</p>
 * @author Salto-db Generator v1.0.16 / EJB3
 * 
 */
@Entity
@Table(name = "event_participants_detail", catalog = "e360db")
@SuppressWarnings("serial")
public class EventParticipantsDetail implements Serializable {

	/**
	 * Attribute id.
	 */
	private Integer id;
	
	/**
	 * Attribute eventParticipants
	 */
	 private EventParticipants eventParticipants;	

	/**
	 * Attribute name.
	 */
	private String name;
	
	/**
	 * Attribute lastname.
	 */
	private String lastname;
	
	/**
	 * Attribute email.
	 */
	private String email;
	
	/**
	 * Attribute version.
	 */
	private Integer version;
	
	/**
	 * List of EventDashboard
	 */
	private List<EventDashboard> eventDashboards = null;

	/**
	 * List of EventParticipantsRespondents
	 */
	private List<EventParticipantsRespondents> eventParticipantsRespondentss = null;

	
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
	 * @return name
	 */
	@Basic
	@Column(name = "name", length = 50)
		public String getName() {
		return name;
	}

	/**
	 * @param name new value for name 
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * <p> 
	 * </p>
	 * @return lastname
	 */
	@Basic
	@Column(name = "lastname", length = 50)
		public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname new value for lastname 
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	/**
	 * <p> 
	 * </p>
	 * @return email
	 */
	@Basic
	@Column(name = "email", length = 30)
		public String getEmail() {
		return email;
	}

	/**
	 * @param email new value for email 
	 */
	public void setEmail(String email) {
		this.email = email;
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
	 * Get the list of EventDashboard
	 */
	 @OneToMany(mappedBy="eventParticipantsDetail")
	 public List<EventDashboard> getEventDashboards() {
	 	return this.eventDashboards;
	 }
	 
	/**
	 * Set the list of EventDashboard
	 */
	 public void setEventDashboards(List<EventDashboard> eventDashboards) {
	 	this.eventDashboards = eventDashboards;
	 }
	/**
	 * Get the list of EventParticipantsRespondents
	 */
	 @OneToMany(mappedBy="eventParticipantsDetail")
	 public List<EventParticipantsRespondents> getEventParticipantsRespondentss() {
	 	return this.eventParticipantsRespondentss;
	 }
	 
	/**
	 * Set the list of EventParticipantsRespondents
	 */
	 public void setEventParticipantsRespondentss(List<EventParticipantsRespondents> eventParticipantsRespondentss) {
	 	this.eventParticipantsRespondentss = eventParticipantsRespondentss;
	 }


}