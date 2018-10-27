package com.reactSpring.trailer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reactSpring.trailer.model.Movie;

public interface DaoMovie extends JpaRepository<Movie, Long>{
	public Movie findByExternalRef(Long externalRef);
}
