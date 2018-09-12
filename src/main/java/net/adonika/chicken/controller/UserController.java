package net.adonika.chicken.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class.getName());

	@GetMapping("/login")
	public String login(String error, String logout) {
		return "user/login";
	}
	
	@GetMapping("/denied")
	public String denied() {
		return "user/denied";
	}
}
