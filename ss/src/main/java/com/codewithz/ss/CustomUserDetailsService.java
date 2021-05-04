package com.codewithz.ss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codewithz.ss.model.User;
import com.codewithz.ss.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService
{
	@Autowired
	UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User u=repository.findByUsername(username);
		
		if(u==null)
		{
			throw new UsernameNotFoundException("User is not found");
		}
		
		return new CustomUserDetails(u);
	}
	
	
	

}
