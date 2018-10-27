package com.reactSpring.trailer.proxy.model;

import java.io.Serializable;
import java.util.List;

public class MovieSearch implements Serializable{
	private static final long serialVersionUID = -3326154348171136737L;
	
	private List<MovieAPI> results;

	public MovieSearch() {
	}

	public List<MovieAPI> getResults() {
		return results;
	}

	public void setResults(List<MovieAPI> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "Recommendation [results=" + results + "]";
	}
}
