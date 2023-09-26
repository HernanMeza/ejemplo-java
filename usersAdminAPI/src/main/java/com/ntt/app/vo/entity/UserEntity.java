package com.ntt.app.vo.entity;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

/**
 * The Class UserEntity.
 */
@Entity
public class UserEntity {

	/** The id. */
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

    /** The name. */
    private String name;
    
    /** The email. */
    private String email;
    
    /** The password. */
    private String password;

    /** The phones. */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userEntity")
    private List<PhoneEntity> phones;

    /** The created. */
    private Timestamp created;
    
    /** The modified. */
    private Timestamp modified;
    
    /** The last login. */
    private Timestamp lastLogin;
    
    /** The usuario activo. */
    private boolean usuarioActivo;
    
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
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Gets the phones.
	 *
	 * @return the phones
	 */
	public List<PhoneEntity> getPhones() {
		return phones;
	}

	/**
	 * Sets the phones.
	 *
	 * @param phones the new phones
	 */
	public void setPhones(List<PhoneEntity> phones) {
		this.phones = phones;
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
	 * @param latLogin the new last login
	 */
	public void setLastLogin(Timestamp latLogin) {
		this.lastLogin = latLogin;
	}

	/**
	 * Checks if is usuario activo.
	 *
	 * @return true, if is usuario activo
	 */
	public boolean isUsuarioActivo() {
		return usuarioActivo;
	}

	/**
	 * Sets the usuario activo.
	 *
	 * @param usuaroActivo the new usuario activo
	 */
	public void setUsuarioActivo(boolean usuaroActivo) {
		this.usuarioActivo = usuaroActivo;
	}
    
}
