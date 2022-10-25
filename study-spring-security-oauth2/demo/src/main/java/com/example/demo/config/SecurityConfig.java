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
//				.authorizeRequests(Customizer.withDefaults())
				.authorizeRequests(a -> a
						.antMatchers("/loginPage").permitAll()
						.anyRequest().authenticated()
				)
//				.formLogin(Customizer.withDefaults())
//				.oauth2Login(Customizer.withDefaults())
				.oauth2Login(oauth2 -> oauth2
						.loginPage("/loginPage")
				)
//				.apply(customSecurityConfigurer)
//				.and()
				.build();
	}
}
