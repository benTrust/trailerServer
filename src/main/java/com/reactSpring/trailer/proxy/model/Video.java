package com.reactSpring.trailer.proxy.model;

import java.io.Serializable;

public class Video  implements Serializable{
	private static final long serialVersionUID = -3242756261921939201L;
	
	private String id;
	private String name;
	private String key;
	
	public Video() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", name=" + name + ", key=" + key + "]";
	}
	
}
