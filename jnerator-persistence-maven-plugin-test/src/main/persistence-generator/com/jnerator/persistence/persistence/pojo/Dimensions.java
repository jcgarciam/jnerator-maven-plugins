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
 * <p>Pojo mapping TABLE dimensions</p>
 * <p></p>
 *
 * <p>Generated at Mon May 02 23:14:50 ART 2011</p>
 * @author Salto-db Generator v1.0.16 / EJB3
 * 
 */
@Entity
@Table(name = "dimensions", catalog = "e360db")
@SuppressWarnings("serial")
public class Dimensions implements Serializable {

	/**
	 * Attribute id.
	 */
	private Integer id;
	
	/**
	 * Attribute tenants
	 */
	 private Tenants tenants;	

	/**
	 * Attribute description.
	 */
	private String description;
	
	/**
	 * Attribute active.
	 */
	private Boolean active;
	
	/**
	 * Attribute jobCategories
	 */
	 private JobCategories jobCategories;	

	/**
	 * Attribute version.
	 */
	private Integer version;
	
	/**
	 * List of Competencies
	 */
	private List<Competencies> competenciess = null;

	
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
	 * @return description
	 */
	@Basic
	@Column(name = "description", length = 100)
		public String getDescription() {
		return description;
	}

	/**
	 * @param description new value for description 
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * Get the list of Competencies
	 */
	 @OneToMany(mappedBy="dimensions")
	 public List<Competencies> getCompetenciess() {
	 	return this.competenciess;
	 }
	 
	/**
	 * Set the list of Competencies
	 */
	 public void setCompetenciess(List<Competencies> competenciess) {
	 	this.competenciess = competenciess;
	 }


}