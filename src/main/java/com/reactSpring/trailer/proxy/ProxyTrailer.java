package com.reactSpring.trailer.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.reactSpring.trailer.proxy.model.DiscoverMovies;
import com.reactSpring.trailer.proxy.model.MovieAPI;
import com.reactSpring.trailer.proxy.model.Recommendation;

@FeignClient( name = "api.themoviedb.org", url = "api.themoviedb.org/3")
public interface ProxyTrailer {
	
	final String TOKEN = "api_key=YOUR_API_KEY";
	final String AND_TOKEN = "&" + TOKEN;
	
	@GetMapping(value = "discover/movie?language=fr&sort_by=popularity.desc&include_adult=false&append_to_response=images" + AND_TOKEN)
	public DiscoverMovies discoverMovie();
	
	@GetMapping(value = "movie/{id}?language=fr&append_to_response=videos&include_adult=false" + AND_TOKEN)
	public MovieAPI getMovie(@PathVariable("id") Long id);
	
	@GetMapping(value = "/movie/{id}/recommendations?include_adult=false&language=fr" + AND_TOKEN)
	public Recommendation recommendationMovies(@PathVariable Long id);
}
