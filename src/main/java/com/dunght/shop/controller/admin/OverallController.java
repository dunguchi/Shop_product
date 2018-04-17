package com.dunght.shop.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author DungHo
 *
 */
@Controller
public class OverallController {
	private final Logger log = LoggerFactory.getLogger(OverallController.class);
	
	@GetMapping("/login")
	public String loginPage() {
		log.info("login page ");
		return "login/login-system";
	}
	
	@GetMapping("/")
	public String index() {
		log.info("index page ");
		return "admin/index";
	}
}
