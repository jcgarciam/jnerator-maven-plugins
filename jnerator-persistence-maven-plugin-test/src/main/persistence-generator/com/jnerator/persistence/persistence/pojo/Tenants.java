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
 * <p>Pojo mapping TABLE tenants</p>
 * <p></p>
 *
 * <p>Generated at Mon May 02 23:14:48 ART 2011</p>
 * @author Salto-db Generator v1.0.16 / EJB3
 * 
 */
@Entity
@Table(name = "tenants", catalog = "e360db")
@SuppressWarnings("serial")
public class Tenants implements Serializable {

	/**
	 * Attribute id.
	 */
	private Integer id;
	
	/**
	 * Attribute name.
	 */
	private String name;
	
	/**
	 * Attribute address.
	 */
	private String address;
	
	/**
	 * Attribute website.
	 */
	private String website;
	
	/**
	 * Attribute primaryContactName.
	 */
	private String primaryContactName;
	
	/**
	 * Attribute primaryContactPhone.
	 */
	private String primaryContactPhone;
	
	/**
	 * Attribute version.
	 */
	private Integer version;
	
	/**
	 * List of Behaviors
	 */
	private List<Behaviors> behaviorss = null;

	/**
	 * List of Competencies
	 */
	private List<Competencies> competenciess = null;

	/**
	 * List of Dimensions
	 */
	private List<Dimensions> dimensionss = null;

	/**
	 * List of EventParticipants
	 */
	private List<EventParticipants> eventParticipantss = null;

	/**
	 * List of EventsDefinition
	 */
	private List<EventsDefinition> eventsDefinitions = null;

	/**
	 * List of JobCategories
	 */
	private List<JobCategories> jobCategoriess = null;

	/**
	 * List of Relations
	 */
	private List<Relations> relationss = null;

	/**
	 * List of UsersProfile
	 */
	private List<UsersProfile> usersProfiles = null;

	
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
	 * <p> 
	 * </p>
	 * @return name
	 */
	@Basic
	@Column(name = "name", length = 100)
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
	 * @return address
	 */
	@Basic
	@Column(name = "address", length = 50)
		public String getAddress() {
		return address;
	}

	/**
	 * @param address new value for address 
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * <p> 
	 * </p>
	 * @return website
	 */
	@Basic
	@Column(name = "website", length = 50)
		public String getWebsite() {
		return website;
	}

	/**
	 * @param website new value for website 
	 */
	public void setWebsite(String website) {
		this.website = website;
	}
	
	/**
	 * <p> 
	 * </p>
	 * @return primaryContactName
	 */
	@Basic
	@Column(name = "primary_contact_name", length = 50)
		public String getPrimaryContactName() {
		return primaryContactName;
	}

	/**
	 * @param primaryContactName new value for primaryContactName 
	 */
	public void setPrimaryContactName(String primaryContactName) {
		this.primaryContactName = primaryContactName;
	}
	
	/**
	 * <p> 
	 * </p>
	 * @return primaryContactPhone
	 */
	@Basic
	@Column(name = "primary_contact_phone", length = 15)
		public String getPrimaryContactPhone() {
		return primaryContactPhone;
	}

	/**
	 * @param primaryContactPhone new value for primaryContactPhone 
	 */
	public void setPrimaryContactPhone(String primaryContactPhone) {
		this.primaryContactPhone = primaryContactPhone;
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
	 * Get the list of Behaviors
	 */
	 @OneToMany(mappedBy="tenants")
	 public List<Behaviors> getBehaviorss() {
	 	return this.behaviorss;
	 }
	 
	/**
	 * Set the list of Behaviors
	 */
	 public void setBehaviorss(List<Behaviors> behaviorss) {
	 	this.behaviorss = behaviorss;
	 }
	/**
	 * Get the list of Competencies
	 */
	 @OneToMany(mappedBy="tenants")
	 public List<Competencies> getCompetenciess() {
	 	return this.competenciess;
	 }
	 
	/**
	 * Set the list of Competencies
	 */
	 public void setCompetenciess(List<Competencies> competenciess) {
	 	this.competenciess = competenciess;
	 }
	/**
	 * Get the list of Dimensions
	 */
	 @OneToMany(mappedBy="tenants")
	 public List<Dimensions> getDimensionss() {
	 	return this.dimensionss;
	 }
	 
	/**
	 * Set the list of Dimensions
	 */
	 public void setDimensionss(List<Dimensions> dimensionss) {
	 	this.dimensionss = dimensionss;
	 }
	/**
	 * Get the list of EventParticipants
	 */
	 @OneToMany(mappedBy="tenants")
	 public List<EventParticipants> getEventParticipantss() {
	 	return this.eventParticipantss;
	 }
	 
	/**
	 * Set the list of EventParticipants
	 */
	 public void setEventParticipantss(List<EventParticipants> eventParticipantss) {
	 	this.eventParticipantss = eventParticipantss;
	 }
	/**
	 * Get the list of EventsDefinition
	 */
	 @OneToMany(mappedBy="tenants")
	 public List<EventsDefinition> getEventsDefinitions() {
	 	return this.eventsDefinitions;
	 }
	 
	/**
	 * Set the list of EventsDefinition
	 */
	 public void setEventsDefinitions(List<EventsDefinition> eventsDefinitions) {
	 	this.eventsDefinitions = eventsDefinitions;
	 }
	/**
	 * Get the list of JobCategories
	 */
	 @OneToMany(mappedBy="tenants")
	 public List<JobCategories> getJobCategoriess() {
	 	return this.jobCategoriess;
	 }
	 
	/**
	 * Set the list of JobCategories
	 */
	 public void setJobCategoriess(List<JobCategories> jobCategoriess) {
	 	this.jobCategoriess = jobCategoriess;
	 }
	/**
	 * Get the list of Relations
	 */
	 @OneToMany(mappedBy="tenants")
	 public List<Relations> getRelationss() {
	 	return this.relationss;
	 }
	 
	/**
	 * Set the list of Relations
	 */
	 public void setRelationss(List<Relations> relationss) {
	 	this.relationss = relationss;
	 }
	/**
	 * Get the list of UsersProfile
	 */
	 @OneToMany(mappedBy="tenants")
	 public List<UsersProfile> getUsersProfiles() {
	 	return this.usersProfiles;
	 }
	 
	/**
	 * Set the list of UsersProfile
	 */
	 public void setUsersProfiles(List<UsersProfile> usersProfiles) {
	 	this.usersProfiles = usersProfiles;
	 }


}