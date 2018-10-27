package com.reactSpring.trailer.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.reactSpring.trailer.core.ServiceUser;
import com.reactSpring.trailer.model.User;
import com.reactSpring.trailer.noPersistent.UserUser;

@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RestController
public class UserRest {
	
	@Autowired
	ServiceUser serviceUser;
	
	@GetMapping(value = "/user/{login}")
	public User getUser(@PathVariable String login) {
		return serviceUser.getUser(login);
	}
	
	@PostMapping(value = "/signUp")
	public void newUser(@RequestBody UserUser userUser) {
		User user = new User(userUser.getLogin(), userUser.getPassword());
		serviceUser.newUser(user);
	}
}
