package com.cognixia.jump.service;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognixia.jump.model.User;
import com.cognixia.jump.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository repo;
	
	//@Override
	// public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// only look for a user with username = user1 and password = pw123
		
		//if( !username.equals("user1") ) {//}
		
		//return new User("user1", "pw123", Arrays.asList( new SimpleGrantedAuthority("ROLE_USER") ));
	//}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> user = repo.findByUsername(username);
		
		// execption will only throw if username is not found
		if(user.isEmpty()) {
			throw new UsernameNotFoundException("User with username " + username + "not found");
		}
		
		// as long as the user is found we return object as a userdetails one,
		// userdetails will have only the necessary info for Spring security
		return new MyUserDetails( user.get());
}
	
	
	
	
	
	
	
	
	
	
	
}

