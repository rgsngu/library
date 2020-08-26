package com.dev.startproject.library.controller;

import java.util.List;

import javax.validation.Valid;

//import javax.validation.Valid;

//import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import com.dev.springboot.thymeleafdemo.entity.Employee;
import com.dev.startproject.library.Model.Registration;
import com.dev.startproject.library.service.UserService;
import com.dev.startproject.library.user.RegistrationUserDual;

@Controller
@RequestMapping("/register")
public class RegistrationController {

//	@Autowired
	private UserService theUserService;

	@Autowired
	public RegistrationController(UserService theUserService) {
		this.theUserService = theUserService;
	}
	
	@GetMapping("/showRegistrationForm")
	public String listOfRegistration(Model model) {
		List<Registration> reg = theUserService.findAll();
		model.addAttribute("registration",reg);
		
		return "register/list";
	}

//	@GetMapping("/showRegistrationForm")
//	public String showMyLoginPage(Model theModel) {
//
//		theModel.addAttribute("registrationUser", new RegistrationUserDual());
//
//		return "/register/sign-up";
//	}

	@PostMapping("/save")
	public String saveNewUser(@Valid @ModelAttribute("registrationUser") RegistrationUserDual theRegistrationUser,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "/register/sign-up";
		}
		if (theUserService.isEmailPresent(theRegistrationUser.getEmail())) {
			model.addAttribute("exist", true);
			return "/register/sign-up";
		}
		theUserService.save(theRegistrationUser);

		return "/register/success";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("userId") int theId, Model theModel) {

		Registration theEmployee = theUserService.findById(theId);

		theModel.addAttribute("employee", theEmployee);

		return "/register/sign-up";
	}

	public String deleteCurrentUser(@RequestParam("userId") int theId, Model theModel) {
		theUserService.deleteById(theId);
		return "/register/list";
	}
}
