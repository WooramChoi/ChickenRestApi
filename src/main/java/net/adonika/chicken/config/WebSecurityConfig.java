package net.adonika.chicken.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import net.adonika.chicken.filter.UserSecurityFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userService;
	
	@Bean
	  public BCryptPasswordEncoder bCryptPasswordEncoder() {
	      return new BCryptPasswordEncoder();
	  }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO api를 기준으로 제작되어야함
		// 권한이 없는 행위에 대해 요청된 헤더에 따라 text/html, appication/json으로 구분해서 응답해줘야할텐데..
		http
			.csrf().disable()	// CSRF: Spring이 유효한(반복되지 않는) Form 요청인지를 검증하기 위해 만드는 임시 키값
        	.authorizeRequests()
            .antMatchers("/", "/css/**", "/fonts/**", "/js/**", "/favicon.ico").permitAll()
            .antMatchers(HttpMethod.OPTIONS).permitAll()
            .antMatchers("/api/browser/index.html**").hasAuthority("ROLE_ADMIN")
            .antMatchers("/userGroups/**").hasAuthority("ROLE_USER")
            .anyRequest().authenticated()
            .and()
            .addFilterAfter(new UserSecurityFilter(), BasicAuthenticationFilter.class)
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
            .and()
        .exceptionHandling().accessDeniedPage("/user/denied")
        ;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	

}
