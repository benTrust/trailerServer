package com.reactSpring.trailer.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie {
	
	@Id
	@GeneratedValue
	private Long id;
	private Long externalRef;
	@OneToMany(mappedBy = "movie")
	private List<Comment> comments;
	
	public Movie() {
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getExternalRef() {
		return externalRef;
	}
	public void setExternalRef(Long externalRef) {
		this.externalRef = externalRef;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Movie other = (Movie) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", externalRef=" + externalRef + ", comments=" + comments + "]";
	}
	
	public void addComment(Comment comment) {
		if(comments == null) {
			comments = new ArrayList<Comment>();
		}
		comments.add(comment);
	}
	
}
