package com.reactSpring.trailer.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactSpring.trailer.conf.PropertiesTrailerAPI;
import com.reactSpring.trailer.proxy.model.DiscoverMovies;
import com.reactSpring.trailer.proxy.model.MovieAPI;
import com.reactSpring.trailer.proxy.model.MovieSearch;
import com.reactSpring.trailer.proxy.model.Recommendation;

@Service
public class ProxyTrailerService {
	
	@Autowired
	PropertiesTrailerAPI propertiesTrailerAPI;
	
	@Autowired
	ProxyTrailer proxyTrailer;
	
	public DiscoverMovies discoverMovie() {
		return proxyTrailer.discoverMovie(propertiesTrailerAPI.getApiKey());
	}
	
	public MovieAPI getMovie(Long id) {
		return proxyTrailer.getMovie(id, propertiesTrailerAPI.getApiKey());
	}
	
	public Recommendation recommendationMovies(Long id) {
		return proxyTrailer.recommendationMovies(id, propertiesTrailerAPI.getApiKey());
	}
	
	public MovieSearch searchMovies(String text) {
		return proxyTrailer.searchMovies(text, propertiesTrailerAPI.getApiKey());
	}
}
