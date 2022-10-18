package com.example.springcache;

import com.example.springcache.address.AddressRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.event.EventListener;
import org.springframework.util.StopWatch;

@EnableCaching
@SpringBootApplication
public class SpringCacheApplication {

	@Autowired
	private AddressRepository addressRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringCacheApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void runApp() {
		addressRepository.insert("user1", "서울");
		addressRepository.insert("user2", "평양");
		final StopWatch stopWatch = new StopWatch();

		stopWatch.start();
		System.out.println(addressRepository.findByUserId("user1"));
		System.out.println(addressRepository.findByUserId("user2"));

		System.out.println(addressRepository.findByUserId("user1"));
		System.out.println(addressRepository.findByUserId("user2"));
		stopWatch.stop();

		System.out.println("time = " + stopWatch.getTotalTimeSeconds());
	}

}
