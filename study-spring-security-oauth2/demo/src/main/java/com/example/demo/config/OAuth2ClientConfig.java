package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.ClientRegistrations;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

@Configuration
public class OAuth2ClientConfig {

	@Bean
	public ClientRegistrationRepository clientRegistrationRepository() {
		return new InMemoryClientRegistrationRepository(keycloakClientRegistration());
	}

	private ClientRegistration keycloakClientRegistration() {
		return ClientRegistrations.fromIssuerLocation("http://localhost:8080/auth/realms/oauth2")
				.registrationId("keycloak")
				.clientId("oauth2-client-app")
				.clientSecret("be688300-8171-4399-b40e-544ad0cc3ccd")
				.redirectUri("http://localhost:8081/login/oauth2/code/keycloak")
				.issuerUri("http://localhost:8080/auth/realms/oauth2")
				.build();
	}
}
