package com.reactSpring.trailer.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reactSpring.trailer.core.ServiceComment;
import com.reactSpring.trailer.core.ServiceMovie;
import com.reactSpring.trailer.model.Comment;
import com.reactSpring.trailer.model.Movie;
import com.reactSpring.trailer.noPersistent.CommentUser;
import com.reactSpring.trailer.noPersistent.GlobalMovie;
import com.reactSpring.trailer.proxy.model.DiscoverMovies;
import com.reactSpring.trailer.proxy.model.MovieSearch;
import com.reactSpring.trailer.proxy.model.Recommendation;

@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RestController
public class MovieRest {
	
	@Autowired
	ServiceMovie serviceMovie;
	
	@Autowired
	ServiceComment serviceComment;
	
	@GetMapping(value = "/discoverMovie")
	public DiscoverMovies discoverMovie() {
		return serviceMovie.discoverMovie();
	}
	
	@GetMapping(value = "/movie/{id}")
	public GlobalMovie getMovie(@PathVariable Long id) {
		return serviceMovie.getMovie(id);
	}
	
	@PostMapping(value = "/movie/{idExternal}/comment")
	public GlobalMovie newComment(@PathVariable Long idExternal, @RequestBody CommentUser commentUser) {
		Comment commentAdd = serviceComment.newComment(idExternal, commentUser);
		Movie movieComment = commentAdd.getMovie();
		if(movieComment == null) {
			movieComment = commentAdd.getParentComment().getMovie();
		}
		return serviceMovie.getMovie(movieComment.getExternalRef());
	}
	
	@GetMapping(value = "/movie/{id}/recommendations")
	public Recommendation recommendationMovies(@PathVariable Long id) {
		return serviceMovie.recommendationMovies(id);
	}
	
	@GetMapping(value = "/searchMovie")
	public MovieSearch searchMovies(@RequestParam String text) {
		return serviceMovie.searchMovies(text);
	}
}
