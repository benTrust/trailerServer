package com.reactSpring.trailer.noPersistent;

import java.io.Serializable;

public class CommentUser implements Serializable{
	private static final long serialVersionUID = 1160124144551343553L;
	
	private String content;
	private Long idParent;
	
	public CommentUser() {
	}
	@Override
	public String toString() {
		return "CommentUser [content=" + content + ", idParent=" + idParent + "]";
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getIdParent() {
		return idParent;
	}
	public void setIdParent(Long idParent) {
		this.idParent = idParent;
	}
	
}
