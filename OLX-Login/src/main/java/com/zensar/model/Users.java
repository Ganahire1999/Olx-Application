package com.zensar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Users 
{
	@SequenceGenerator(name = "useridgen", allocationSize = 1, initialValue = 4)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "useridgen")
	private int id;
	
	private String username;
	private String password;
	private String roles;
	private boolean active;
	private String firstname;
	private String lastname;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", roles=" + roles
				+ ", active=" + active + ", firstname=" + firstname + ", lastname=" + lastname + "]";
				
	}
	public boolean getActive() {
		// TODO Auto-generated method stub
		return true;
	}
}
