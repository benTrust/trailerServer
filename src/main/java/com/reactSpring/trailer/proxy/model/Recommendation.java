package com.reactSpring.trailer.proxy.model;

import java.io.Serializable;
import java.util.List;

public class Recommendation implements Serializable{
	private static final long serialVersionUID = 5642494303673658332L;
	
	private List<MovieAPI> results;

	public Recommendation() {
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
