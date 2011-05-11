package com.jnerator.persistence.persistence.hibernate;

import java.util.List;
import java.sql.Timestamp;

import com.jnerator.persistence.persistence.pojo.UsersProfile;
import com.jnerator.persistence.persistence.UsersProfileDAO;

import org.hibernate.criterion.Restrictions;

/**
 * <p>Hibernate DAO layer for UsersProfiles</p>
 * <p>Generated at Mon May 02 23:14:50 ART 2011</p>
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public class UsersProfileHibernateDAO extends
		AbstractHibernateDAO<UsersProfile, Integer> implements
		UsersProfileDAO {

	/**
	 * Find UsersProfile by tenantsId
	 */
	@SuppressWarnings("unchecked")
	public List<UsersProfile> findByTenantsId(Integer tenantsId) {
		return findByCriteria(Restrictions.eq("tenants.tenantsId", tenantsId));
	}
	
	/**
	 * Find UsersProfile by loginId
	 */
	public List<UsersProfile> findByLoginId(String loginId) {
		return findByCriteria(Restrictions.eq("loginId", loginId));
	}
	
	/**
	 * Find UsersProfile by passwd
	 */
	public List<UsersProfile> findByPasswd(String passwd) {
		return findByCriteria(Restrictions.eq("passwd", passwd));
	}
	
	/**
	 * Find UsersProfile by salt
	 */
	public List<UsersProfile> findBySalt(String salt) {
		return findByCriteria(Restrictions.eq("salt", salt));
	}
	
	/**
	 * Find UsersProfile by name
	 */
	public List<UsersProfile> findByName(String name) {
		return findByCriteria(Restrictions.eq("name", name));
	}
	
	/**
	 * Find UsersProfile by lastName
	 */
	public List<UsersProfile> findByLastName(String lastName) {
		return findByCriteria(Restrictions.eq("lastName", lastName));
	}
	
	/**
	 * Find UsersProfile by createdDate
	 */
	public List<UsersProfile> findByCreatedDate(Timestamp createdDate) {
		return findByCriteria(Restrictions.eq("createdDate", createdDate));
	}
	
	/**
	 * Find UsersProfile by expiredDate
	 */
	public List<UsersProfile> findByExpiredDate(Timestamp expiredDate) {
		return findByCriteria(Restrictions.eq("expiredDate", expiredDate));
	}
	
	/**
	 * Find UsersProfile by active
	 */
	public List<UsersProfile> findByActive(Boolean active) {
		return findByCriteria(Restrictions.eq("active", active));
	}
	
	/**
	 * Find UsersProfile by version
	 */
	public List<UsersProfile> findByVersion(Integer version) {
		return findByCriteria(Restrictions.eq("version", version));
	}
	

}
