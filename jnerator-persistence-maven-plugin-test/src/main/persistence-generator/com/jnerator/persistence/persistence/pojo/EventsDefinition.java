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
 * <p>Pojo mapping TABLE events_definition</p>
 * <p></p>
 *
 * <p>Generated at Mon May 02 23:14:48 ART 2011</p>
 * @author Salto-db Generator v1.0.16 / EJB3
 * 
 */
@Entity
@Table(name = "events_definition", catalog = "e360db")
@SuppressWarnings("serial")
public class EventsDefinition implements Serializable {

	/**
	 * Attribute id.
	 */
	private Integer id;
	
	/**
	 * Attribute tenants
	 */
	 private Tenants tenants;	

	/**
	 * Attribute projectType.
	 */
	private String projectType;
	
	/**
	 * Attribute companyName.
	 */
	private String companyName;
	
	/**
	 * Attribute eventName.
	 */
	private String eventName;
	
	/**
	 * Attribute contactPhone.
	 */
	private String contactPhone;
	
	/**
	 * Attribute contactEmail.
	 */
	private String contactEmail;
	
	/**
	 * Attribute companyManagerName.
	 */
	private String companyManagerName;
	
	/**
	 * Attribute companyManagerEmail.
	 */
	private String companyManagerEmail;
	
	/**
	 * Attribute eventStart.
	 */
	private Timestamp eventStart;
	
	/**
	 * Attribute eventEnd.
	 */
	private Timestamp eventEnd;
	
	/**
	 * Attribute delegateTemplateCreation.
	 */
	private Boolean delegateTemplateCreation;
	
	/**
	 * Attribute delegatePersonName.
	 */
	private String delegatePersonName;
	
	/**
	 * Attribute delegatePersonPhone.
	 */
	private String delegatePersonPhone;
	
	/**
	 * Attribute participantsQuantity.
	 */
	private Integer participantsQuantity;
	
	/**
	 * Attribute usersProfile
	 */
	 private UsersProfile usersProfile;	

	/**
	 * Attribute comments.
	 */
	private String comments;
	
	/**
	 * Attribute version.
	 */
	private Integer version;
	
	/**
	 * List of EventDashboard
	 */
	private List<EventDashboard> eventDashboards = null;

	/**
	 * List of EventParticipants
	 */
	private List<EventParticipants> eventParticipantss = null;

	
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
	 * <p> 
	 * </p>
	 * @return projectType
	 */
	@Basic
	@Column(name = "project_type", length = 5)
		public String getProjectType() {
		return projectType;
	}

	/**
	 * @param projectType new value for projectType 
	 */
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	
	/**
	 * <p> 
	 * </p>
	 * @return companyName
	 */
	@Basic
	@Column(name = "company_name", length = 100)
		public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName new value for companyName 
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	/**
	 * <p> 
	 * </p>
	 * @return eventName
	 */
	@Basic
	@Column(name = "event_name", length = 100)
		public String getEventName() {
		return eventName;
	}

	/**
	 * @param eventName new value for eventName 
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	/**
	 * <p> 
	 * </p>
	 * @return contactPhone
	 */
	@Basic
	@Column(name = "contact_phone", length = 15)
		public String getContactPhone() {
		return contactPhone;
	}

	/**
	 * @param contactPhone new value for contactPhone 
	 */
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	
	/**
	 * <p> 
	 * </p>
	 * @return contactEmail
	 */
	@Basic
	@Column(name = "contact_email", length = 30)
		public String getContactEmail() {
		return contactEmail;
	}

	/**
	 * @param contactEmail new value for contactEmail 
	 */
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	
	/**
	 * <p> 
	 * </p>
	 * @return companyManagerName
	 */
	@Basic
	@Column(name = "company_manager_name", length = 50)
		public String getCompanyManagerName() {
		return companyManagerName;
	}

	/**
	 * @param companyManagerName new value for companyManagerName 
	 */
	public void setCompanyManagerName(String companyManagerName) {
		this.companyManagerName = companyManagerName;
	}
	
	/**
	 * <p> 
	 * </p>
	 * @return companyManagerEmail
	 */
	@Basic
	@Column(name = "company_manager_email", length = 30)
		public String getCompanyManagerEmail() {
		return companyManagerEmail;
	}

	/**
	 * @param companyManagerEmail new value for companyManagerEmail 
	 */
	public void setCompanyManagerEmail(String companyManagerEmail) {
		this.companyManagerEmail = companyManagerEmail;
	}
	
	/**
	 * <p> 
	 * </p>
	 * @return eventStart
	 */
	@Basic
	@Column(name = "event_start")
		public Timestamp getEventStart() {
		return eventStart;
	}

	/**
	 * @param eventStart new value for eventStart 
	 */
	public void setEventStart(Timestamp eventStart) {
		this.eventStart = eventStart;
	}
	
	/**
	 * <p> 
	 * </p>
	 * @return eventEnd
	 */
	@Basic
	@Column(name = "event_end")
		public Timestamp getEventEnd() {
		return eventEnd;
	}

	/**
	 * @param eventEnd new value for eventEnd 
	 */
	public void setEventEnd(Timestamp eventEnd) {
		this.eventEnd = eventEnd;
	}
	
	/**
	 * <p> 
	 * </p>
	 * @return delegateTemplateCreation
	 */
	@Basic
	@Column(name = "delegate_template_creation")
		public Boolean getDelegateTemplateCreation() {
		return delegateTemplateCreation;
	}

	/**
	 * @param delegateTemplateCreation new value for delegateTemplateCreation 
	 */
	public void setDelegateTemplateCreation(Boolean delegateTemplateCreation) {
		this.delegateTemplateCreation = delegateTemplateCreation;
	}
	
	/**
	 * <p> 
	 * </p>
	 * @return delegatePersonName
	 */
	@Basic
	@Column(name = "delegate_person_name", length = 50)
		public String getDelegatePersonName() {
		return delegatePersonName;
	}

	/**
	 * @param delegatePersonName new value for delegatePersonName 
	 */
	public void setDelegatePersonName(String delegatePersonName) {
		this.delegatePersonName = delegatePersonName;
	}
	
	/**
	 * <p> 
	 * </p>
	 * @return delegatePersonPhone
	 */
	@Basic
	@Column(name = "delegate_person_phone", length = 15)
		public String getDelegatePersonPhone() {
		return delegatePersonPhone;
	}

	/**
	 * @param delegatePersonPhone new value for delegatePersonPhone 
	 */
	public void setDelegatePersonPhone(String delegatePersonPhone) {
		this.delegatePersonPhone = delegatePersonPhone;
	}
	
	/**
	 * <p> 
	 * </p>
	 * @return participantsQuantity
	 */
	@Basic
	@Column(name = "participants_quantity")
		public Integer getParticipantsQuantity() {
		return participantsQuantity;
	}

	/**
	 * @param participantsQuantity new value for participantsQuantity 
	 */
	public void setParticipantsQuantity(Integer participantsQuantity) {
		this.participantsQuantity = participantsQuantity;
	}
	
	/**
	 * get usersProfile
	 */
	@ManyToOne
	@JoinColumn(name = "users_profile_id")
	public UsersProfile getUsersProfile() {
		return this.usersProfile;
	}
	
	/**
	 * set usersProfile
	 */
	public void setUsersProfile(UsersProfile usersProfile) {
		this.usersProfile = usersProfile;
	}

	/**
	 * <p> 
	 * </p>
	 * @return comments
	 */
	@Basic
	@Column(name = "comments", length = 500)
		public String getComments() {
		return comments;
	}

	/**
	 * @param comments new value for comments 
	 */
	public void setComments(String comments) {
		this.comments = comments;
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
	 @OneToMany(mappedBy="eventsDefinition")
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
	 * Get the list of EventParticipants
	 */
	 @OneToMany(mappedBy="eventsDefinition")
	 public List<EventParticipants> getEventParticipantss() {
	 	return this.eventParticipantss;
	 }
	 
	/**
	 * Set the list of EventParticipants
	 */
	 public void setEventParticipantss(List<EventParticipants> eventParticipantss) {
	 	this.eventParticipantss = eventParticipantss;
	 }


}