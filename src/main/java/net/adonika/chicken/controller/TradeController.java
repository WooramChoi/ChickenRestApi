package net.adonika.chicken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/trade")
public class TradeController {

	@GetMapping("/list")
	public String tradeList() {
		return "trade/list";
	}
}
