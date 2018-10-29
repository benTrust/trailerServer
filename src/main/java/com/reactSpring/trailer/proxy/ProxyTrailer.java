package com.reactSpring.trailer.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.reactSpring.trailer.proxy.model.DiscoverMovies;
import com.reactSpring.trailer.proxy.model.MovieAPI;
import com.reactSpring.trailer.proxy.model.MovieSearch;
import com.reactSpring.trailer.proxy.model.Recommendation;

@FeignClient( name = "api.themoviedb.org", url = "api.themoviedb.org/3")
public interface ProxyTrailer {
	
	@GetMapping(value = "discover/movie?language=fr&sort_by=popularity.desc&include_adult=false&append_to_response=images")
	public DiscoverMovies discoverMovie(@RequestParam String api_key);
	
	@GetMapping(value = "movie/{id}?language=fr&append_to_response=videos&include_adult=false")
	public MovieAPI getMovie(@PathVariable("id") Long id, @RequestParam String api_key);
	
	@GetMapping(value = "/movie/{id}/recommendations?include_adult=false&language=fr")
	public Recommendation recommendationMovies(@PathVariable Long id, @RequestParam String api_key);
	
	@GetMapping(value = "/search/movie?language=fr&include_adult=false&query={text}")
	public MovieSearch searchMovies(@PathVariable String text, @RequestParam String api_key);
}
