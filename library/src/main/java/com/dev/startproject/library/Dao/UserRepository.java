package com.dev.startproject.library.Dao;

//import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.startproject.library.Model.Registration;


public interface UserRepository extends JpaRepository<Registration, Integer>{
	public Optional<Registration> findByEmail(String email);
}
