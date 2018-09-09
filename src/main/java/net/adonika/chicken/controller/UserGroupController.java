package net.adonika.chicken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userGroups")
public class UserGroupController {

	@GetMapping("/{seqUserGroup}")
	public String userGroup(@PathVariable("seqUserGroup") int seqUserGroup, Model model) {
		model.addAttribute("seqUserGroup", seqUserGroup);
		return "userGroup/index";
	}
}
