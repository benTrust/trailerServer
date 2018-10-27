package com.reactSpring.trailer.proxy.model;

import java.io.Serializable;
import java.util.Date;

public class MovieAPI implements Serializable{
	private static final long serialVersionUID = 4541324913687316169L;
	
	private Long id;
	private String title;
	private String poster_path;
	private String overview;
	private Date release_date;
	private Videos videos;
	
	public MovieAPI() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPoster_path() {
		return poster_path;
	}

	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public Date getRelease_date() {
		return release_date;
	}

	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}

	public Videos getVideos() {
		return videos;
	}

	public void setVideos(Videos videos) {
		this.videos = videos;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", poster_path=" + poster_path + ", overview=" + overview
				+ ", release_date=" + release_date + ", videos=" + videos + "]";
	}
	
}
