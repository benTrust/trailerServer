package com.reactSpring.trailer.core;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactSpring.trailer.dao.DaoComment;
import com.reactSpring.trailer.exception.BadRequestException;
import com.reactSpring.trailer.exception.NotFoundException;
import com.reactSpring.trailer.model.Comment;
import com.reactSpring.trailer.model.Movie;
import com.reactSpring.trailer.model.User;
import com.reactSpring.trailer.noPersistent.CommentUser;
import com.reactSpring.trailer.util.Utils;

@Service
public class ServiceComment {
	
	@Autowired
	DaoComment daoComment;
	
	@Autowired
	ServiceUser serviceUser;
	
	@Autowired
	ServiceMovie serviceMovie;
	
	public Comment getComment(Long id) {
		if(id == null) {
			throw new BadRequestException("L'identifiant du commentaire doit être renseigné");
		}
		Optional<Comment> optComment = daoComment.findById(id);
		if(!optComment.isPresent()) {
			throw new NotFoundException(String.format("Le commentaire d'identifiant [%d] n'existe pas", id));
		}
		return optComment.get();
	}
	
	public Comment newComment(Long idExternal, CommentUser commentUser) {
		controlComment(commentUser);
		User user = serviceUser.getUser(Utils.getUser().getLogin());
		Movie movie = serviceMovie.loadOrCreateMovie(idExternal);
		Comment comment = new Comment();
		comment.setContent(commentUser.getContent());
		comment.setUser(user);
		comment.setDate(new Date());
		Long idCommentParent = commentUser.getIdParent();
		if(idCommentParent != null) {
			Comment commentParent = getComment(idCommentParent);
			comment.setParentComment(commentParent);
		}else {
			//If comment c1 in c2 so movie is in c1.c2.movie else :
			comment.setMovie(movie);
		}
		comment = daoComment.save(comment);
		return comment;
	}
	
	private void controlComment(CommentUser commentUser) {
		if(commentUser == null) {
			throw new BadRequestException("L'objet commentaire doit être renseigné");
		}
		if(Utils.isNull(commentUser.getContent())) {
			throw new BadRequestException("Un commentaire doit être renseigné");
		}
	}
}
