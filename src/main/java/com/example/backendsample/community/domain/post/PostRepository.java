package com.example.backendsample.community.domain.post;

import java.util.List;

public interface PostRepository {

	Post save(Post post);

	Post findById(Long id);

	List<Post> findAll();

	void update(Long postId, Post updateParam);

	void clearStore();

}
