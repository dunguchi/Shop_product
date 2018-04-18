package com.dunght.shop.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.dunght.shop.utils.PathViewConstant;

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
		return PathViewConstant.PathBackend.LOGIN_ADMIN;
	}
	
	@GetMapping("/admin")
	public String index() {
		log.info("index page ");
		return PathViewConstant.PathBackend.INDEX_ADMIN;
	}
	
    @GetMapping("/403")
    public String accessDenied() {
        return "403";
    }
}
