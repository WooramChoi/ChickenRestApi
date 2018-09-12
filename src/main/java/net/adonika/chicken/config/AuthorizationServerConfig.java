package net.adonika.chicken.config;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	public DataSource dataSource;

	@Value("${security.oauth2.resource.id}")
	private String resourceId;

	private int accessTokenValiditySeconds = 3600;
	private int refreshTokenValiditySeconds = 10000;
	
	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private SecretKeyProvider keyProvider;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints
			.authenticationManager(authenticationManager)
			.tokenServices(tokenServices())
			.tokenStore(tokenStore())
			.accessTokenConverter(accessTokenConverter());
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer
			.tokenKeyAccess("isAnonymous() || hasAuthority('ROLE_TRUSTED_CLIENT')")
			.checkTokenAccess("hasAuthority('ROLE_TRUSTED_CLIENT')");
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.jdbc(dataSource)
//		clients.inMemory()
			.withClient("normal-app")
		        .authorizedGrantTypes("authorization_code", "implicit")
		        .authorities("ROLE_CLIENT")
		        .scopes("read", "write")
		        .resourceIds(resourceId)
		        .accessTokenValiditySeconds(accessTokenValiditySeconds)
		        .refreshTokenValiditySeconds(refreshTokenValiditySeconds)
		        .and()
		    .withClient("trusted-app")
		        .authorizedGrantTypes("client_credentials", "password", "refresh_token")
		        .authorities("ROLE_TRUSTED_CLIENT")
		        .scopes("read", "write")
		        .resourceIds(resourceId)
		        .accessTokenValiditySeconds(accessTokenValiditySeconds)
		        .refreshTokenValiditySeconds(refreshTokenValiditySeconds)
		        .secret(passwordEncoder.encode("secret"))
		        .and()
		    .withClient("register-app")
		        .authorizedGrantTypes("client_credentials")
		        .authorities("ROLE_REGISTER")
		        .scopes("read")
		        .resourceIds(resourceId)
		        .secret(passwordEncoder.encode("secret"))
		    .and()
		        .withClient("my-client-with-registered-redirect")
		        .authorizedGrantTypes("authorization_code")
		        .authorities("ROLE_CLIENT")
		        .scopes("read", "trust")
		        .resourceIds("oauth2-resource")
		        .redirectUris("http://anywhere?key=value");
	}

	@Bean
	public TokenStore tokenStore() {
		return new JdbcTokenStore(dataSource);
//		return new JwtTokenStore(accessTokenConverter());
	}

	@Bean
	public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
		DataSourceInitializer initializer = new DataSourceInitializer();
		initializer.setDataSource(dataSource);
		initializer.setDatabasePopulator(databasePopulator());
		return initializer;
	}
	
	@Value("classpath:schema.sql")
	private Resource schemaScript;

	private DatabasePopulator databasePopulator() {
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(schemaScript);
		return populator;
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		try {
			converter.setSigningKey(keyProvider.getKey());
		} catch (URISyntaxException | KeyStoreException | NoSuchAlgorithmException | IOException | UnrecoverableKeyException | CertificateException e) {
			e.printStackTrace();
		}

		return converter;
	}
	
	@Bean
	@Primary
	public DefaultTokenServices tokenServices() {
		DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
		defaultTokenServices.setTokenStore(tokenStore());
		defaultTokenServices.setSupportRefreshToken(true);
		defaultTokenServices.setTokenEnhancer(accessTokenConverter());
		return defaultTokenServices;
	}

}
