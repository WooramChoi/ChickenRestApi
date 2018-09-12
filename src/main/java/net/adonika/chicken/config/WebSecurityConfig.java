package net.adonika.chicken.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
//@EnableOAuth2Sso
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class.getName());
	
	@Autowired
	@Qualifier("userService")
	private UserDetailsService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(userService)
			.passwordEncoder(passwordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()	// CSRF: Spring이 유효한(반복되지 않는) Form 요청인지를 검증하기 위해 만드는 임시 키값
        	.authorizeRequests()
            .antMatchers("/api/browser/index.html**").hasAuthority("ROLE_ADMIN")
            .antMatchers("/userGroups/**").hasAuthority("ROLE_USER")
            .antMatchers("/", "/**").permitAll()
            .antMatchers(HttpMethod.OPTIONS).permitAll()
            .anyRequest().authenticated()
            .and()
            //.addFilterAfter(new UserSecurityFilter(), BasicAuthenticationFilter.class)
        .formLogin().defaultSuccessUrl("/")
            .loginPage("/user/login")
            .usernameParameter("strId")
            .passwordParameter("strPass")
            .permitAll()
            .and()
        .logout()
        	.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
        	.logoutSuccessUrl("/user/login?logout")
            .permitAll()
        ;
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

}
