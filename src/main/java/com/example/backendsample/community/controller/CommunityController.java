package com.example.backendsample.community.controller;

import com.example.backendsample.community.domain.post.Post;
import com.example.backendsample.community.domain.post.PostRepository;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/community")
@RequiredArgsConstructor
public class CommunityController {

	private final PostRepository postRepository;

	@GetMapping
	public List<Post> posts(){
		return postRepository.findAll();
	}

	@PostMapping("/add")
	public Post addPost(@RequestBody Post post){
		postRepository.save(post);
		return post;
	}

	@PostConstruct
	public void init() {
		postRepository.save(new Post("testA", "Sample Content", "1"));
		postRepository.save(new Post("testB", "Sample Content", "2"));
	}
}
