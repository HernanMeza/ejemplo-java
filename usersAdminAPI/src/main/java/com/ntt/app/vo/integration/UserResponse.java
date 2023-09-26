package com.ntt.app.vo.integration;

import java.sql.Timestamp;

/**
 * The Class UserResponse.
 */
public class UserResponse {

	/** The message. */
	private String message;

    /** The created. */
    private Timestamp created;
    
    /** The modified. */
    private Timestamp modified;
    
    /** The last login. */
    private Timestamp lastLogin;
    
    /** The usuario activo. */
    private boolean usuarioActivo;
	
	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
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
	 * @param usuarioActivo the new usuario activo
	 */
	public void setUsuarioActivo(boolean usuarioActivo) {
		this.usuarioActivo = usuarioActivo;
	}
}
