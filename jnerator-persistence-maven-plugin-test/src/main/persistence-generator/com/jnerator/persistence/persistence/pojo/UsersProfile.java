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
 * <p>Pojo mapping TABLE users_profile</p>
 * <p></p>
 *
 * <p>Generated at Mon May 02 23:14:50 ART 2011</p>
 * @author Salto-db Generator v1.0.16 / EJB3
 * 
 */
@Entity
@Table(name = "users_profile", catalog = "e360db")
@SuppressWarnings("serial")
public class UsersProfile implements Serializable {

	/**
	 * Attribute id.
	 */
	private Integer id;
	
	/**
	 * Attribute tenants
	 */
	 private Tenants tenants;	

	/**
	 * Attribute loginId.
	 */
	private String loginId;
	
	/**
	 * Attribute passwd.
	 */
	private String passwd;
	
	/**
	 * Attribute salt.
	 */
	private String salt;
	
	/**
	 * Attribute name.
	 */
	private String name;
	
	/**
	 * Attribute lastName.
	 */
	private String lastName;
	
	/**
	 * Attribute createdDate.
	 */
	private Timestamp createdDate;
	
	/**
	 * Attribute expiredDate.
	 */
	private Timestamp expiredDate;
	
	/**
	 * Attribute active.
	 */
	private Boolean active;
	
	/**
	 * Attribute version.
	 */
	private Integer version;
	
	/**
	 * List of EventsDefinition
	 */
	private List<EventsDefinition> eventsDefinitions = null;

	
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
	 * @return loginId
	 */
	@Basic
	@Column(name = "login_id", length = 50)
		public String getLoginId() {
		return loginId;
	}

	/**
	 * @param loginId new value for loginId 
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	
	/**
	 * <p> 
	 * </p>
	 * @return passwd
	 */
	@Basic
	@Column(name = "passwd", length = 40)
		public String getPasswd() {
		return passwd;
	}

	/**
	 * @param passwd new value for passwd 
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	/**
	 * <p> 
	 * </p>
	 * @return salt
	 */
	@Basic
	@Column(name = "salt", length = 40)
		public String getSalt() {
		return salt;
	}

	/**
	 * @param salt new value for salt 
	 */
	public void setSalt(String salt) {
		this.salt = salt;
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
	 * @return lastName
	 */
	@Basic
	@Column(name = "last_name", length = 50)
		public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName new value for lastName 
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * <p> 
	 * </p>
	 * @return createdDate
	 */
	@Basic
	@Column(name = "created_date")
		public Timestamp getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate new value for createdDate 
	 */
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	
	/**
	 * <p> 
	 * </p>
	 * @return expiredDate
	 */
	@Basic
	@Column(name = "expired_date")
		public Timestamp getExpiredDate() {
		return expiredDate;
	}

	/**
	 * @param expiredDate new value for expiredDate 
	 */
	public void setExpiredDate(Timestamp expiredDate) {
		this.expiredDate = expiredDate;
	}
	
	/**
	 * <p> 
	 * </p>
	 * @return active
	 */
	@Basic
	@Column(name = "active")
		public Boolean getActive() {
		return active;
	}

	/**
	 * @param active new value for active 
	 */
	public void setActive(Boolean active) {
		this.active = active;
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
	 * Get the list of EventsDefinition
	 */
	 @OneToMany(mappedBy="usersProfile")
	 public List<EventsDefinition> getEventsDefinitions() {
	 	return this.eventsDefinitions;
	 }
	 
	/**
	 * Set the list of EventsDefinition
	 */
	 public void setEventsDefinitions(List<EventsDefinition> eventsDefinitions) {
	 	this.eventsDefinitions = eventsDefinitions;
	 }


}