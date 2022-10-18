package com.example.springcache.address;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
public class AddressRepository {

	private static final Map<String, String> store = new HashMap<>();

	public void insert(String userId, String address) {
		store.put(userId, address);
	}

//	@Cacheable("addresses")
//	@CacheEvict(value = "addresses", allEntries = true)
	@CachePut("addresses")
	public String findByUserId(String userId) {
		sleep();
		return store.get(userId);
	}

	private void sleep() {
		try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
