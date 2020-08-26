package com.dev.startproject.library.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class LibraySecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("securityDataSource")
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// use jdbc authentication ... oh yeah!!!		
//		auth.jdbcAuthentication()
//				.dataSource(securityDataSource)
//				.withDefaultSchema()
//				.withUser(User.withUsername("admin")
//						.password("admin")
//						.roles("USER"));
		auth.jdbcAuthentication().dataSource(securityDataSource);
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
//			.antMatchers("/employees/showForm*").hasAnyRole("MANAGER", "ADMIN")
//			.antMatchers("/employees/save*").hasAnyRole("MANAGER", "ADMIN")
//			.antMatchers("/employees/delete").hasRole("ADMIN")
//			.antMatchers("/employees/**").hasRole("EMPLOYEE")
			.antMatchers("/register/showRegistrationForm").permitAll();
//			.antMatchers("/resources/**")
//			.and()
//			.formLogin()
//				.loginPage("/showMyLoginPage")
//				.loginProcessingUrl("/authenticateTheUser")
//				.permitAll()
//			.and()
//			.logout().permitAll()
//			.and()
//			.exceptionHandling().accessDeniedPage("/access-denied");
		
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
