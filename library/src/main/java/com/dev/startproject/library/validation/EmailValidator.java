package com.dev.startproject.library.validation;

import com.dev.startproject.library.Model.Registration;
import com.dev.startproject.library.exception.ResourceNotFoundException;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.dev.startproject.library.Dao.UserRepository;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {
	
	@Autowired
	private UserRepository userRepository;
	
	private Pattern pattern;
	
	private Matcher matcher;
	
	private static final String EMAIL_PATTERN="";

	@Override
	public boolean isValid(final String email, final ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
//		pattern = Pattern.compile(EMAIL_PATTERN);
		if(email==null)
			return false;
//		matcher = pattern.matcher(email);
//		
//		return matcher.matches();
//		if(email != null) {
//			try {
//				Optional<Registration> reg = Optional.ofNullable(userRepository.findByEmail(email).orElseThrow(
//						()-> new ResourceNotFoundException("This email id is valid "+email)));
//			} catch (ResourceNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
		return true;
	}
}
