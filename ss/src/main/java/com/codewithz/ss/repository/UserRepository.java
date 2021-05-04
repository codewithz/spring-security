package com.codewithz.ss.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithz.ss.model.User;

public interface UserRepository extends JpaRepository<User, Long> 
{
	
	User findByUsername(String username);

}
