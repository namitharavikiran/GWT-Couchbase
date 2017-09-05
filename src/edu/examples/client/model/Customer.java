package edu.examples.client.model;

import java.io.Serializable;

public class Customer implements Serializable {
	
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private Long cas;
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getCas() {
		return cas;
	}
	public void setCas(Long cas) {
		this.cas = cas;
	}

	  
	}