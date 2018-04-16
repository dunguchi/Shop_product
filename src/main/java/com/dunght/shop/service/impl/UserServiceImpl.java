package com.dunght.shop.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dunght.shop.entity.User;
import com.dunght.shop.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public Page<User> filterUser(Pageable pageable, Long roleId, String input) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
