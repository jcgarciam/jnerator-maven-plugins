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
 * <p>Pojo mapping TABLE Contact</p>
 * <p></p>
 *
 * <p>Generated at Mon May 30 20:34:57 ART 2011</p>
 * @author Salto-db Generator -v1.0.16- forked as jnerator-persistence-maven-plugin / EJB3
 * 
 */
@Entity
@Table(name = "Contact", catalog = "demo")
@SuppressWarnings("serial")
public class Contact implements Serializable {

	/**
	 * Attribute id.
	 */
	private Long id;
	
	/**
	 * Attribute birthDate.
	 */
	private Timestamp birthDate;
	
	/**
	 * Attribute lastName.
	 */
	private String lastName;
	
	/**
	 * Attribute name.
	 */
	private String name;
	
	/**
	 * List of Address
	 */
	private List<Address> addresss = null;

	
	/**
	 * <p> 
	 * </p>
	 * @return id
	 */
	@Basic
	@Id
	@GeneratedValue
	@Column(name = "id")
		public Long getId() {
		return id;
	}

	/**
	 * @param id new value for id 
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * <p> 
	 * </p>
	 * @return birthDate
	 */
	@Basic
	@Column(name = "birth_date")
		public Timestamp getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate new value for birthDate 
	 */
	public void setBirthDate(Timestamp birthDate) {
		this.birthDate = birthDate;
	}
	
	/**
	 * <p> 
	 * </p>
	 * @return lastName
	 */
	@Basic
	@Column(name = "last_name", length = 25)
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
	 * @return name
	 */
	@Basic
	@Column(name = "name", length = 25)
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
	 * Get the list of Address
	 */
	 @OneToMany(mappedBy="contact")
	 public List<Address> getAddresss() {
	 	return this.addresss;
	 }
	 
	/**
	 * Set the list of Address
	 */
	 public void setAddresss(List<Address> addresss) {
	 	this.addresss = addresss;
	 }


}