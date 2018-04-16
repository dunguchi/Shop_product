package com.dunght.shop.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.dunght.shop.entity.Role;
import com.dunght.shop.entity.User;
import com.dunght.shop.repository.RoleRepository;
import com.dunght.shop.repository.UserRepository;

@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
 	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {

		// Roles dump database
		if (roleRepository.findByRoleName("ROLE_ADMIN") == null) {
			roleRepository.save(new Role("ROLE_ADMIN"));
		}

		if (roleRepository.findByRoleName("ROLE_MEMBER") == null) {
			roleRepository.save(new Role("ROLE_MEMBER"));
		}

		// User account dump database
		if (userRepository.findByUsername("admin") == null) {
			User adminht = new User();
			adminht.setUsername("admin");
			adminht.setEmail("admin@gmail.com");
			adminht.setAvatarUrl(
					"http://res.cloudinary.com/dunguchi/image/upload/v1522921943/yd1ce55ukoda5lz4tf8s.jpg");
			adminht.setFullName("Admin System");
			adminht.setIsActive(true);
			adminht.setPassword(passwordEncoder.encode("12345678"));
			List<Role> roles = new ArrayList<Role>();
			roles.add(roleRepository.findByRoleName("ROLE_ADMIN"));
			adminht.setRoles(roles);
			userRepository.save(adminht);
		}

		// Member account
		if (userRepository.findByUsername("member") == null) {
			User user = new User();
			user.setUsername("member");
			user.setEmail("member@gmail.com");
			user.setAvatarUrl("http://res.cloudinary.com/dunguchi/image/upload/v1522921943/yd1ce55ukoda5lz4tf8s.jpg");
			user.setFullName("Member System");
			user.setIsActive(true);
			user.setPassword(passwordEncoder.encode("12345678"));
			List<Role> roles = new ArrayList<Role>();
			roles.add(roleRepository.findByRoleName("ROLE_MEMBER"));
			user.setRoles(roles);
			userRepository.save(user);
		}

	}
}
