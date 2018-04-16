package com.dunght.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dunght.shop.entity.User;
import com.dunght.shop.repository.UserRepository;
import com.dunght.shop.service.UserService;
import com.dunght.shop.specification.UserSpecification;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Page<User> filterUser(Pageable pageable, Long roleId, String input) throws Exception {
		// TODO Auto-generated method stub
		return userRepository.findAll(new UserSpecification(roleId, input), pageable);
	}

	@Override
	public User getDetailUser(Long id) throws Exception {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

}
