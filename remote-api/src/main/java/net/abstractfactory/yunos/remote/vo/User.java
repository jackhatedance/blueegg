package net.abstractfactory.yunos.remote.vo;

import java.io.Serializable;

/**
 * 
 * 
 * @author jack
 * 
 */
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1l;

	private String id;
	private String password;
	private String email;
	private String firstName;
	private String lastName;

	public User() {
	}

	public User(String id, String password, String email, String firstName,
			String lastName) {
		this.id = id;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
