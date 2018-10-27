package com.reactSpring.trailer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.reactSpring.trailer.model.User;

public interface DaoUser extends JpaRepository<User, Long>{
	public User findByLogin(String login);
}
