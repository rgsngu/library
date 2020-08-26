package com.dev.startproject.library.service;

//import java.time.LocalDate;
import java.util.Date;
import java.util.List;
//import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dev.startproject.library.Dao.UserRepository;
import com.dev.startproject.library.Model.Registration;
import com.dev.startproject.library.user.RegistrationUserDual;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository theuserRepository) {
		// TODO Auto-generated constructor stub
		userRepository=theuserRepository;
	}
	
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	
	@Override
	public void save(RegistrationUserDual registrationDual) {
		// TODO Auto-generated method stub
		Registration reg = new Registration();
		System.out.println("Insude the save method ");
			reg.setCrtDt(new Date());
			reg.setConfirmationToken(UUID.randomUUID().toString());
			reg.setDob(registrationDual.getDob());
			reg.setEmail(registrationDual.getEmail());
			reg.setEmail(registrationDual.getEmail());
			reg.setFirstName(registrationDual.getFn());
			reg.setLastName(registrationDual.getLn());
			reg.setEnabled(registrationDual.getAct());
			reg.setPassword(passwordEncoder.encode(registrationDual.getPassword()));
			userRepository.save(reg);
				
	}

	@Override
	public boolean isEmailPresent(String email) {
		// TODO Auto-generated method stub
		Optional<Registration> result = userRepository.findByEmail(email);
		if(result.isPresent()) {
			System.out.println(result.get());
			return true;
			}
		return false;
	}

	@Override
	public Registration findById(int theId) {
		// TODO Auto-generated method stub	
		Optional<Registration> reg = userRepository.findById(theId);
		Registration re=null;
		if(reg.isPresent()) {
			re = reg.get();
		}
		else {
			throw new RuntimeException("Did not find User id - 	"+theId);
		}
		return re;
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		findById(theId);
		userRepository.deleteById(theId);
		
	}

	@Override
	public List<Registration> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

}
