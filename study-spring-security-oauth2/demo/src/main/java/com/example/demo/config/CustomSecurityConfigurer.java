package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomSecurityConfigurer extends AbstractHttpConfigurer<CustomSecurityConfigurer, HttpSecurity> {

	@Override
	public void init(HttpSecurity builder) throws Exception {
		super.init(builder);
		log.info("init CustomSecurityConfigurer");
	}

	@Override
	public void configure(HttpSecurity builder) throws Exception {
		super.configure(builder);
		log.info("init configure");
	}
}
