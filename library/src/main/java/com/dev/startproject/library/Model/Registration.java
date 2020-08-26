package com.dev.startproject.library.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class Registration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userid;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="birthday")
	private Date dob;
	
	@Column(name="password")
	private String password;
	
	@Column(name="enabled")
	private Boolean enabled;
	
	@Column(name = "confirmation_token")
	private String confirmationToken;
	
	@Column(name="email")
	private String email;
	
	@Column(name="crt_dt")
	private Date crtDt;
	
	public Registration() {
		// TODO Auto-generated constructor stub
	}

	public Registration(String firstName, String lastName, Date dob, String password, Boolean enabled,
			String confirmationToken, String email,Date crtDt) {
//		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.password = password;
		this.enabled = enabled;
		this.confirmationToken = confirmationToken;
		this.email = email;
		this.crtDt = crtDt;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
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

	
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getConfirmationToken() {
		return confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCrtDt() {
		return crtDt;
	}

	public void setCrtDt(Date date) {
		this.crtDt = date;
	}
	
	
	
}
