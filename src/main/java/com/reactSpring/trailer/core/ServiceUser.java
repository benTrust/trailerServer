package com.reactSpring.trailer.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.reactSpring.trailer.dao.DaoUser;
import com.reactSpring.trailer.exception.BadRequestException;
import com.reactSpring.trailer.exception.ExistException;
import com.reactSpring.trailer.exception.NotFoundException;
import com.reactSpring.trailer.model.User;
import com.reactSpring.trailer.util.Utils;

@Service
public class ServiceUser {
	
	@Autowired
	DaoUser daoUser;
	
	public User getUser(String login) {
		if(Utils.isNull(login)) {
			throw new BadRequestException("L'identifiant de l'utilisateur doit être renseigné");
		}
		User user = daoUser.findByLogin(login);
		if(user == null) {
			throw new NotFoundException(String.format("L'utilisateur d'identifiant [%s] n'existe pas", login));
		}
		return user;
	}
	
	public User newUser(User user) {
		if(Utils.isNull(user.getLogin())) {
			throw new BadRequestException("L'identifiant de l'utilisateur doit être renseigné");
		}
		if(Utils.isNull(user.getPassword())) {
			throw new BadRequestException("Le mot de passe de l'utilisateur doit être renseigné");
		}
		User userInBDD = daoUser.findByLogin(user.getLogin());
		if(userInBDD != null) {
			throw new ExistException(String.format("L'identifiant [%s] existe déjà", user.getLogin()));
		}
		
		user.setId(null);
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		user = daoUser.save(user);
		return user;
	}
}
