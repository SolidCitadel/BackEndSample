package com.example.backendsample.community.domain.post;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Post {
	private Long id;
	private String title;
	private String content;
	private String authorId;

	public Post(){

	}

	public Post(String title, String content, String authorId){
		this.title = title;
		this.content = content;
		this.authorId = authorId;
	}
}
