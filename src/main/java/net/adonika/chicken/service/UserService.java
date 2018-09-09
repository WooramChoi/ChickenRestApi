package net.adonika.chicken.service;

import net.adonika.chicken.api.entity.User;
import net.adonika.chicken.api.model.UserVO;

public interface UserService {
	
	public User getUser(int seqUser);
	
	public UserVO getSessionUser();
}
