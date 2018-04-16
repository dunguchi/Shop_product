package com.dunght.shop.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dunght.shop.entity.User;


public interface UserService {
	Page<User> filterUser(Pageable pageable, Long roleId, String input) throws Exception;
}
