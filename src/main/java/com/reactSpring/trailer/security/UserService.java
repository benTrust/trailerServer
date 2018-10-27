package com.reactSpring.trailer.security;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.reactSpring.trailer.dao.DaoUser;
import com.reactSpring.trailer.model.User;

public class UserService implements UserDetailsService {
	
	@Autowired
	DaoUser daoUser;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Objects.requireNonNull(username);
		User user = daoUser.findByLogin(username);
		
		if(user == null) {
        	throw new UsernameNotFoundException(String.format("Utilisateur %s n'existe pas", username));
        }
		
		return user;
	}

}
