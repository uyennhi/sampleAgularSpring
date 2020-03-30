package com.magrabbit.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.cors.CorsConfiguration;

/**
 * Authorization Server Configuration
 * 
 * @author Chiem Lam Mai
 * @since 16-09-2019
 */
@Configuration
@EnableAuthorizationServer
@Order(2)
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	private static final String CLIEN_ID = "mclam";
	private static final String CLIENT_SECRET = "$2a$10$hPTzzKOwZcYdDM2rSNPWwOkioBUYCMhwkvmuhf8Z/GREcYXYFOKPa";
	private static final int THIRTY_MINUTES = 30 * 60;
	private static final int ONE_WEEK = 7 * 24 * 60 * 60;

	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;

	/**
	 * Method help translating OAuth authentication information (in both directions)
	 */
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey("mclam");
		return converter;
	}

	/**
	 * Jwt token store
	 */
	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

	/**
	 * Configure that defines the client details service
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {

		configurer.inMemory().withClient(CLIEN_ID).secret(CLIENT_SECRET)
				.authorizedGrantTypes("password", "refresh_token")
				.scopes("read", "write", "trust")
				.accessTokenValiditySeconds(THIRTY_MINUTES)
				.refreshTokenValiditySeconds(ONE_WEEK);
	}

	/**
	 * Method used to service requests for access tokens
	 */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) {

		Map<String, CorsConfiguration> corsConfigMap = new HashMap<>();
		CorsConfiguration config = new CorsConfiguration();
		config.applyPermitDefaultValues();
		corsConfigMap.put("/oauth/token", config);
		endpoints.getFrameworkEndpointHandlerMapping().setCorsConfigurations(corsConfigMap);

		endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager)
				.accessTokenConverter(accessTokenConverter());
	}
}