package com.reactSpring.trailer.proxy.model;

import java.io.Serializable;
import java.util.List;

public class Videos implements Serializable{
	private static final long serialVersionUID = -8537607333271147047L;
	
	private List<Video> results;
	
	public Videos() {
	}

	public List<Video> getResults() {
		return results;
	}

	public void setResults(List<Video> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "Videos [results=" + results + "]";
	}
	
	

}
