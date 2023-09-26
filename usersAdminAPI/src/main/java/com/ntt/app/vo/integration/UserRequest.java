package com.ntt.app.vo.integration;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * The Class UserRequest.
 */
public class UserRequest {
    
    /** The name. */
    @NotBlank(message = "Nombre no informado")
    private String name;
    
    /** The email. */
    @NotBlank(message = "Email no informado")
    private String email;
    
    /** The password. */
    @NotBlank(message = "Password no informado")
    private String password;
    
    /** The phones. */
    @NotNull
    private List<Phone> phones;

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
	public List<Phone> getPhones() {
		return phones;
	}

	/**
	 * Sets the phones.
	 *
	 * @param phones the new phones
	 */
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
    
}
