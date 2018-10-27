package com.reactSpring.trailer.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactSpring.trailer.dao.DaoMovie;
import com.reactSpring.trailer.exception.BadRequestException;
import com.reactSpring.trailer.exception.NotFoundException;
import com.reactSpring.trailer.model.Movie;
import com.reactSpring.trailer.noPersistent.GlobalMovie;
import com.reactSpring.trailer.proxy.ProxyTrailer;
import com.reactSpring.trailer.proxy.model.DiscoverMovies;
import com.reactSpring.trailer.proxy.model.MovieAPI;
import com.reactSpring.trailer.proxy.model.MovieSearch;
import com.reactSpring.trailer.proxy.model.Recommendation;
import com.reactSpring.trailer.util.Utils;

import feign.FeignException;

@Service
public class ServiceMovie {
	
	@Autowired
	ProxyTrailer proxyTrailer;
	
	@Autowired
	DaoMovie daoMovie;
	
	private void controlMovieExterne(Long idExternal) {
		if(idExternal == null) {
			throw new BadRequestException("Le film d'identifiant externe doit être renseigné");
		}
		MovieAPI movieAPI = proxyTrailer.getMovie(idExternal);
		if(movieAPI == null) {
			throw new NotFoundException(String.format("Le film d'identifiant externe [%d] n'existe pas", idExternal));
		}
	}
	
	public Movie loadOrCreateMovie(Long idExternal) {
		controlMovieExterne(idExternal);
		Movie movie = daoMovie.findByExternalRef(idExternal);
		if(movie == null) {
			movie = createMovie(idExternal);
		}
		return movie;
	}
	
	private Movie createMovie(Long idExternal) {
		Movie movie = new Movie();
		movie.setExternalRef(idExternal);
		movie = daoMovie.save(movie);
		return movie;
	}
	
	public GlobalMovie getMovie(Long idExternal) {
		if(idExternal == null) {
			throw new BadRequestException("Le film d'identifiant externe doit être renseigné");
		}
		MovieAPI movieAPI = null; 
		try {
			movieAPI = proxyTrailer.getMovie(idExternal);
		}catch(FeignException e) {
			if(e.status() == 404) {
				throw new NotFoundException(String.format("Le film externe d'identifiant [%d] n'existe pas", idExternal));
			}
		}
		Movie movie = daoMovie.findByExternalRef(movieAPI.getId());
		return new GlobalMovie(movie, movieAPI);
	}
	
	public Recommendation recommendationMovies(Long idExternal) {
		if(idExternal == null) {
			throw new BadRequestException("Le film d'identifiant externe doit être renseigné");
		}
		Recommendation recommendation = null;
		try {
			recommendation = proxyTrailer.recommendationMovies(idExternal);
		}catch(FeignException e) {
			if(e.status() == 404) {
				throw new NotFoundException(String.format("Le film externe d'identifiant [%d] n'existe pas", idExternal));
			}
		}
		return recommendation;
	}
	
	public MovieSearch searchMovies(String text) {
		if(Utils.isNull(text)) {
			throw new BadRequestException("Le text doit ête renseigné");
		}
		return proxyTrailer.searchMovies(text);
	}
	
	public DiscoverMovies discoverMovie() {
		return proxyTrailer.discoverMovie();
	}
}
