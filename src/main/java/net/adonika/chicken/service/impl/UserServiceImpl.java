package net.adonika.chicken.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import net.adonika.chicken.api.entity.User;
import net.adonika.chicken.api.model.UserVO;
import net.adonika.chicken.api.repository.UserRepository;
import net.adonika.chicken.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User getUser(int seqUser) {
		return userRepository.getOne(seqUser);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByStrId(username);
		if(user == null) {
			logger.warn("LOGIN FAILED: USER NOT FOUND {}", username);
			throw new UsernameNotFoundException("User Not Found");
		}
		logger.info("LOGIN TRY: {}", username);
		return new UserVO(user);
	}

	@Override
	public UserVO getSessionUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication == null) {
			return null;
		}
		Object principal = authentication.getPrincipal();
		if(principal == null) {
			return null;
		}
		return (UserVO) principal;
	}

}
