package com.nik.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//UserDetailsService is a Core interface which loads user-specific data. 

public class CustomUserDetailsService implements UserDetailsService {

	private static List<User> dummyUsers = new ArrayList<>();

	public CustomUserDetailsService() {
		 //if you dont want to use any encoder then uncomment the bellow two lines
		 dummyUsers.add(new User("john", "{noop}secret", "USER"));
		 dummyUsers.add(new User("admin", "{noop}supersecret", "ADMIN"));
		// if you want use the default encoder
		//dummyUsers.add(new User("john", "secret", "USER"));
		//dummyUsers.add(new User("admin", "supersecret", "ADMIN"));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = dummyUsers.stream().filter(u -> u.getName().equals(username)).findAny();

		if (!user.isPresent()) {
			throw new UsernameNotFoundException("User not found :" + username);
		}

		return mapUserDetails(user.get());
	}

	private UserDetails mapUserDetails(User user) {

		// uncomment if there is no encoder

		return org.springframework.security.core.userdetails.User.withUsername(user.getName())
				.password(user.getPassword()).roles(user.getRole()).build();

//		return org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder().username(user.getName())
//				.password(user.getPassword()).roles(user.getRole()).build();

	}
}
