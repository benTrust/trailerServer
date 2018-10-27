package com.reactSpring.trailer.util;

import org.springframework.security.core.context.SecurityContextHolder;

import com.reactSpring.trailer.model.User;

public class Utils {
	public static boolean isNull(String s) {
		if(s == null) {
			return true;
		}
		
		return s.isEmpty();
	}
	
	public static boolean isNotNull(String s) {
		return !isNull(s);
	}
	
	public static User getUser() {
		return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
}
