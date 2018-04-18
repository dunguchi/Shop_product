package com.dunght.shop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dunght.shop.entity.User;
import com.dunght.shop.service.UserService;

@Controller
@RequestMapping("/manage")
public class ManageUserController {
	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public String getAllUser(Model model, Pageable pageable,
			@RequestParam(required = false, value = "input") String input,
			@RequestParam(required = false, value = "roleId") Long roleId) {
		Page<User> list = null;
		try {
			list = userService.filterUser(pageable, roleId, input);
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", e);
		}
		model.addAttribute("list_user", list);
		return "manage-user";
	}

	@GetMapping("/users/{id}")
	public String getDetailUser(@PathVariable Long id, Model model) {
		User user = null;
		try {
			user = userService.getDetailUser(id);
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", e);
		}
		model.addAttribute("user", user);
		return "user-detail";
	}
}
