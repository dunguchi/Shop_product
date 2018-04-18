package com.dunght.shop.controller.systems;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.dunght.shop.utils.PathViewConstant;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String indexHome() {
		return PathViewConstant.PathFontend.INDEX_HOME;
	}
}
