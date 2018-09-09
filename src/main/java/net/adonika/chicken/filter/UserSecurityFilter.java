package net.adonika.chicken.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

public class UserSecurityFilter extends GenericFilterBean {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//TODO 접속하는 그룹 정보에 접근 권한(가입 여부) 확인
		//TODO api 접근 권한 확인 >> 본인의 것인지, 아니면 해당 엔티티에 대한 CRUD 권한이 있는지
		if(SecurityContextHolder.getContext().getAuthentication() != null) {
			// 모든 요청에 대해서 이곳으로 들어오게됨.
			// 1. URL 판별
			// 2. 로그인 대상 판별
			// 3. 로그인 대상의 권한 판별
		}
		
		chain.doFilter(request, response);
	}

}
