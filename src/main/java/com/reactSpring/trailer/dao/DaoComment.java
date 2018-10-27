package com.reactSpring.trailer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reactSpring.trailer.model.Comment;

public interface DaoComment extends JpaRepository<Comment, Long>{

}
