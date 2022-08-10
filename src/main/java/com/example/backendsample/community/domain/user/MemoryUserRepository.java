package com.example.backendsample.community.domain.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class MemoryUserRepository implements UserRepository {

	private static final Map<String, User> store = new HashMap<>();

	@Override
	public User save(User user) {
		if (!store.containsKey(user.getId())) {
			store.put(user.getId(), user);
		}else{
			log.warn("duplicate userId :" + user.getId());
		}
		return user;
	}

	@Override
	public User findById(String id) {
		return store.get(id);
	}

	@Override
	public List<User> findAll() {
		return new ArrayList<>(store.values());
	}

	@Override
	public void update(String userId, User updateParam) {
		User user = findById(userId);
		user.setName(updateParam.getName());
		user.setPw(updateParam.getPw());
	}

	@Override
	public void clearStore() {
		store.clear();
	}
}
