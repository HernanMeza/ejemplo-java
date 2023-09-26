package com.ntt.app.vo.entity;

import java.sql.Timestamp;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * The Class PhoneEntity.
 */
@Entity
public class PhoneEntity {

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /** The number. */
    private String number;
    
    /** The citycode. */
    private String citycode;
    
    /** The contrycode. */
    private String contrycode;

    /** The created. */
    private Timestamp created;
    
    /** The modified. */
    private Timestamp modified;
    
    /** The last login. */
    private Timestamp lastLogin;
    
    /** The user entity. */
    @ManyToOne
    @JoinColumn(name = "userEntity_id")
    private UserEntity userEntity;

	/**
	 * Instantiates a new phone entity.
	 *
	 * @param number the number
	 * @param citycode the citycode
	 * @param contrycode the contrycode
	 * @param userEntity the user entity
	 */
	public PhoneEntity(String number, String citycode, String contrycode, UserEntity userEntity) {
		this.number = number;
		this.citycode = citycode;
		this.contrycode = contrycode;
		this.userEntity = userEntity;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(UUID id) {
		this.id = id;
	}

	/**
	 * Gets the number.
	 *
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * Sets the number.
	 *
	 * @param number the new number
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * Gets the citycode.
	 *
	 * @return the citycode
	 */
	public String getCitycode() {
		return citycode;
	}

	/**
	 * Sets the citycode.
	 *
	 * @param citycode the new citycode
	 */
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	/**
	 * Gets the contrycode.
	 *
	 * @return the contrycode
	 */
	public String getContrycode() {
		return contrycode;
	}

	/**
	 * Sets the contrycode.
	 *
	 * @param contrycode the new contrycode
	 */
	public void setContrycode(String contrycode) {
		this.contrycode = contrycode;
	}

	/**
	 * Gets the user entity.
	 *
	 * @return the user entity
	 */
	public UserEntity getUserEntity() {
		return userEntity;
	}

	/**
	 * Sets the user entity.
	 *
	 * @param userEntity the new user entity
	 */
	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	/**
	 * Gets the created.
	 *
	 * @return the created
	 */
	public Timestamp getCreated() {
		return created;
	}

	/**
	 * Sets the created.
	 *
	 * @param created the new created
	 */
	public void setCreated(Timestamp created) {
		this.created = created;
	}

	/**
	 * Gets the modified.
	 *
	 * @return the modified
	 */
	public Timestamp getModified() {
		return modified;
	}

	/**
	 * Sets the modified.
	 *
	 * @param modified the new modified
	 */
	public void setModified(Timestamp modified) {
		this.modified = modified;
	}

	/**
	 * Gets the last login.
	 *
	 * @return the last login
	 */
	public Timestamp getLastLogin() {
		return lastLogin;
	}

	/**
	 * Sets the last login.
	 *
	 * @param lastLogin the new last login
	 */
	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}
}
