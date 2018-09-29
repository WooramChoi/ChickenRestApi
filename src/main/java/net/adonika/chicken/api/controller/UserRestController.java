package net.adonika.chicken.api.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

	@GetMapping({"/users", "/me"})
	public Principal users(Principal principal) {
		return principal;
	}
}
