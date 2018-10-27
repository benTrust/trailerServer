package com.reactSpring.trailer.noPersistent;

import com.reactSpring.trailer.model.Movie;
import com.reactSpring.trailer.proxy.model.MovieAPI;

public class GlobalMovie {
	Movie movie;
	MovieAPI movieAPI;
	public GlobalMovie(Movie movie, MovieAPI movieAPI) {
		this.movie = movie;
		this.movieAPI = movieAPI;
	}
	public GlobalMovie() {
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public MovieAPI getMovieAPI() {
		return movieAPI;
	}
	public void setMovieAPI(MovieAPI movieAPI) {
		this.movieAPI = movieAPI;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((movie == null) ? 0 : movie.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GlobalMovie other = (GlobalMovie) obj;
		if (movie == null) {
			if (other.movie != null)
				return false;
		} else if (!movie.equals(other.movie))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "GlobalMovie [movie=" + movie + ", movieAPI=" + movieAPI + "]";
	}
	
}
