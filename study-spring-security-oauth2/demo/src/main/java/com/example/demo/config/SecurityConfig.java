package com.example.demo.config;

import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig {

	private final CustomSecurityConfigurer customSecurityConfigurer;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.authorizeRequests(a -> a
						.anyRequest().authenticated()
				)
				.formLogin(Customizer.withDefaults())
				.apply(customSecurityConfigurer)
				.and()
				.build();
	}
}
