package com.dev.startproject.library.user;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.dev.startproject.library.validation.FieldMatch;
import com.dev.startproject.library.validation.ValidEmail;

@FieldMatch.List({
	@FieldMatch(first = "password",second = "matchpassword",message = "The password field must match")
})
public class RegistrationUserDual {
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String fn;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String ln;
	
//	@NotNull(message = "is required")
//	@Size(min = 1, message = "is required")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	
	@NotNull(message = "is required")
	@Size(min = 8, max=24, message = "is required")
	private String password;
	
	@NotNull(message = "is required")
	@Size(min = 8, max=24, message = "is required")
	private String matchpassword;
	
	@NotNull(message = "is required")
//	@Size(min = 1, message = "is required")
	private Boolean act;
	
	@ValidEmail
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String email;
	
	public RegistrationUserDual() {
		// TODO Auto-generated constructor stub
	}

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public String getLn() {
		return ln;
	}

	public void setLn(String ln) {
		this.ln = ln;
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

	public String getMatchpassword() {
		return matchpassword;
	}

	public void setMatchpassword(String matchpassword) {
		this.matchpassword = matchpassword;
	}

	public Boolean getAct() {
		return act;
	}

	public void setAct(Boolean act) {
		this.act = act;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
