package com.jnerator.persistence.persistence;

import java.util.List;
import java.sql.Timestamp;

import com.jnerator.persistence.persistence.pojo.UsersProfile;
/**
 * <p>Generic DAO layer for UsersProfiles</p>
 * <p>Generated at Mon May 02 23:14:50 ART 2011</p>
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public interface UsersProfileDAO extends GenericDAO<UsersProfile,Integer> {

	/*
	 * TODO : Add specific businesses daos here.
	 * These methods will be overwrited if you re-generate this interface.
	 * You might want to extend this interface and to change the dao factory to return 
	 * an instance of the new implemenation in buildUsersProfileDAO()
	 */
	  	 
	/**
	 * Find UsersProfile by tenantsId
	 */
	public List<UsersProfile> findByTenantsId(Integer tenantsId);

	/**
	 * Find UsersProfile by loginId
	 */
	public List<UsersProfile> findByLoginId(String loginId);

	/**
	 * Find UsersProfile by passwd
	 */
	public List<UsersProfile> findByPasswd(String passwd);

	/**
	 * Find UsersProfile by salt
	 */
	public List<UsersProfile> findBySalt(String salt);

	/**
	 * Find UsersProfile by name
	 */
	public List<UsersProfile> findByName(String name);

	/**
	 * Find UsersProfile by lastName
	 */
	public List<UsersProfile> findByLastName(String lastName);

	/**
	 * Find UsersProfile by createdDate
	 */
	public List<UsersProfile> findByCreatedDate(Timestamp createdDate);

	/**
	 * Find UsersProfile by expiredDate
	 */
	public List<UsersProfile> findByExpiredDate(Timestamp expiredDate);

	/**
	 * Find UsersProfile by active
	 */
	public List<UsersProfile> findByActive(Boolean active);

	/**
	 * Find UsersProfile by version
	 */
	public List<UsersProfile> findByVersion(Integer version);

}