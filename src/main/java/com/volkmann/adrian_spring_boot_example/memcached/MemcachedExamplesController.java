package com.volkmann.adrian_spring_boot_example.memcached;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.spy.memcached.MemcachedClient;

@RestController
public class MemcachedExamplesController {
	
	private static final int EXPIRATION = 60; // 1 min

	@Autowired
	MemcachedClient memcached;

	@PostMapping(value = "/createCache")
	public void createCache(@RequestBody CreateCacheModel createCache) {
		memcached.set(createCache.getKey(), EXPIRATION, createCache.getValue());
	}

	@GetMapping(value = "/readCache")
	public Integer readCache(@RequestParam String key) {

		String readed = (String) memcached.get(key);

		if (readed != null) {
			return Integer.valueOf(readed);
		}

		return null;
	}
}
