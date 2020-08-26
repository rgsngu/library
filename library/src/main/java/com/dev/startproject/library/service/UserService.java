package com.dev.startproject.library.service;

import java.util.List;

import com.dev.startproject.library.Model.Registration;

//import java.util.List;

//import com.dev.startproject.library.Model.Registration;
import com.dev.startproject.library.user.RegistrationUserDual;

public interface UserService {
	
//	public List<Registration> findAll();

//	public Registration findById(int theId);

	public void save(RegistrationUserDual registrationDual);

	public boolean isEmailPresent(String email);

	public Registration findById(int theId);

	public void deleteById(int theId);

	public List<Registration> findAll();

//	public void deletebyId(int theId);
}
