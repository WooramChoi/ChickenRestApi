package net.adonika.chicken.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class OAuth2ResourceServerConfig extends GlobalMethodSecurityConfiguration{
	
	@Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        return new OAuth2MethodSecurityExpressionHandler();
    }
	
	@Primary
	@Bean
	public RemoteTokenServices tokenService() {
	    RemoteTokenServices tokenService = new RemoteTokenServices();
	    tokenService.setCheckTokenEndpointUrl("http://localhost:8080/spring-security-oauth-server/oauth/check_token");
	    tokenService.setClientId("fooClientIdPassword");
	    tokenService.setClientSecret("secret");
	    return tokenService;
	}

}
