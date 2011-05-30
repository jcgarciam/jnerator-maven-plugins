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
 * <p>Pojo mapping TABLE Address</p>
 * <p></p>
 *
 * <p>Generated at Mon May 30 20:34:57 ART 2011</p>
 * @author Salto-db Generator -v1.0.16- forked as jnerator-persistence-maven-plugin / EJB3
 * 
 */
@Entity
@Table(name = "Address", catalog = "demo")
@SuppressWarnings("serial")
public class Address implements Serializable {

	/**
	 * Attribute id.
	 */
	private Long id;
	
	/**
	 * Attribute line1.
	 */
	private String line1;
	
	/**
	 * Attribute line2.
	 */
	private String line2;
	
	/**
	 * Attribute contact
	 */
	 private Contact contact;	

	
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
	 * @return line1
	 */
	@Basic
	@Column(name = "line1", length = 100)
		public String getLine1() {
		return line1;
	}

	/**
	 * @param line1 new value for line1 
	 */
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	
	/**
	 * <p> 
	 * </p>
	 * @return line2
	 */
	@Basic
	@Column(name = "line2", length = 100)
		public String getLine2() {
		return line2;
	}

	/**
	 * @param line2 new value for line2 
	 */
	public void setLine2(String line2) {
		this.line2 = line2;
	}
	
	/**
	 * get contact
	 */
	@ManyToOne
	@JoinColumn(name = "contact_id")
	public Contact getContact() {
		return this.contact;
	}
	
	/**
	 * set contact
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}



}