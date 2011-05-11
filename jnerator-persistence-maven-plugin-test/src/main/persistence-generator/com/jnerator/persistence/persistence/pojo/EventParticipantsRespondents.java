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
 * <p>Pojo mapping TABLE event_participants_respondents</p>
 * <p></p>
 *
 * <p>Generated at Mon May 02 23:14:49 ART 2011</p>
 * @author Salto-db Generator v1.0.16 / EJB3
 * 
 */
@Entity
@Table(name = "event_participants_respondents", catalog = "e360db")
@SuppressWarnings("serial")
public class EventParticipantsRespondents implements Serializable {

	/**
	 * Attribute id.
	 */
	private Integer id;
	
	/**
	 * Attribute eventParticipantsDetail
	 */
	 private EventParticipantsDetail eventParticipantsDetail;	

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
	 * Attribute relations
	 */
	 private Relations relations;	

	/**
	 * Attribute approvalStatus.
	 */
	private String approvalStatus;
	
	/**
	 * Attribute approvalDate.
	 */
	private Timestamp approvalDate;
	
	/**
	 * Attribute version.
	 */
	private Integer version;
	
	/**
	 * List of EventDashboard
	 */
	private List<EventDashboard> eventDashboards = null;

	
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
	 * get relations
	 */
	@ManyToOne
	@JoinColumn(name = "relations_id")
	public Relations getRelations() {
		return this.relations;
	}
	
	/**
	 * set relations
	 */
	public void setRelations(Relations relations) {
		this.relations = relations;
	}

	/**
	 * <p>REL=RELEASE FOR FILLING SURVEY
APR=APPROVED READY TO BE RELEASED
FRA=FOR REVIEW BY APPROVAL 
	 * </p>
	 * @return approvalStatus
	 */
	@Basic
	@Column(name = "approval_status", length = 4)
		public String getApprovalStatus() {
		return approvalStatus;
	}

	/**
	 * @param approvalStatus new value for approvalStatus 
	 */
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	
	/**
	 * <p> 
	 * </p>
	 * @return approvalDate
	 */
	@Basic
	@Column(name = "approval_date")
		public Timestamp getApprovalDate() {
		return approvalDate;
	}

	/**
	 * @param approvalDate new value for approvalDate 
	 */
	public void setApprovalDate(Timestamp approvalDate) {
		this.approvalDate = approvalDate;
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
	 @OneToMany(mappedBy="eventParticipantsRespondents")
	 public List<EventDashboard> getEventDashboards() {
	 	return this.eventDashboards;
	 }
	 
	/**
	 * Set the list of EventDashboard
	 */
	 public void setEventDashboards(List<EventDashboard> eventDashboards) {
	 	this.eventDashboards = eventDashboards;
	 }


}