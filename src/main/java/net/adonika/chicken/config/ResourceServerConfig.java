package net.adonika.chicken.config;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.AntPathMatcher;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{
	
	private static final Logger logger = LoggerFactory.getLogger(ResourceServerConfig.class.getName());
	
	@Value("${security.oauth2.resource.id}")
	private String resourceId;
	
	@Value("${spring.data.rest.base-path}")
	private String restBasePath;
	
	@Autowired
	private DefaultTokenServices tokenServices;
	
	@Autowired
	private TokenStore tokenStore;

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources
			.resourceId(resourceId)
			.tokenServices(tokenServices)
			.tokenStore(tokenStore);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.requestMatcher(new OAuthRequestedMatcher())
			.anonymous().disable()
			.authorizeRequests()
			.antMatchers(HttpMethod.OPTIONS).permitAll()
			.antMatchers(String.format("%1$s/**", restBasePath)).hasAnyAuthority("ROLE_USER","ROLE_ADMIN")
			.antMatchers(String.format("%1$s/users/register", restBasePath)).hasAuthority("ROLE_REGISTER");
	}
	
	private class OAuthRequestedMatcher implements RequestMatcher {
		
		//private static final Logger logger = LoggerFactory.getLogger(OAuthRequestedMatcher.class.getName());
		
		@Override
		public boolean matches(HttpServletRequest request) {
			String auth = request.getHeader("Authorization");
			
			logger.debug("requestUrl: {}", request.getRequestURI());
			if(request.getRequestURI().startsWith("/api/browser/index.html")) {
				return false;
			}
			
			AntPathMatcher antPathMatcher = new AntPathMatcher();
			boolean isRestBasePath = antPathMatcher.match(String.format("%1$s/**", restBasePath), request.getRequestURI());
			
			boolean haveOauth2Token = (auth!=null) && auth.startsWith("Bearer");
			boolean haveAccessToken = request.getParameter("access_token")!=null;
			logger.debug("isRestBasePath? {}", String.valueOf(isRestBasePath));
			logger.debug("or haveOauth2Token? {}", String.valueOf(haveOauth2Token));
			logger.debug("or haveAccessToken? {}", String.valueOf(haveAccessToken));
			return isRestBasePath || haveOauth2Token || haveAccessToken;
		}
		
	}

}
