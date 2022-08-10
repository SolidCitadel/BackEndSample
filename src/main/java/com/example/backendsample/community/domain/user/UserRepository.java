package com.example.backendsample.community.domain.user;

import java.util.List;

public interface UserRepository {

	User save(User user);

	User findById(String id);

	List<User> findAll();

	void update(String userId, User updateParam);

	void clearStore();

}
