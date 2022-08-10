package com.example.backendsample.community.domain.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class MemoryPostRepository implements PostRepository{
	private static final Map<Long, Post> store = new HashMap<>();
	private static Long sequence = 0L;

	@Override
	public Post save(Post post) {
		post.setId(++sequence);
		store.put(post.getId(), post);
		return post;
	}

	@Override
	public Post findById(Long id) {
		return store.get(id);
	}

	@Override
	public List<Post> findAll() {
		return new ArrayList<>(store.values());
	}

	@Override
	public void update(Long postId, Post updateParam) {
		Post post = findById(postId);
		post.setContent(updateParam.getContent());
		post.setAuthorId(updateParam.getAuthorId());
		post.setTitle(updateParam.getTitle());
	}

	@Override
	public void clearStore() {
		store.clear();
	}
}
