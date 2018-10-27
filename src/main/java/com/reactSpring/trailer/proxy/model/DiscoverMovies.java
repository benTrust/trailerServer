package com.reactSpring.trailer.proxy.model;

import java.io.Serializable;
import java.util.List;

public class DiscoverMovies implements Serializable{
	private static final long serialVersionUID = -5681959836876248632L;
	
	private List<MovieAPI> results;

	public DiscoverMovies() {
	}

	public List<MovieAPI> getResults() {
		return results;
	}

	public void setResults(List<MovieAPI> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "DiscoverMovies [results=" + results + "]";
	}
	
}
