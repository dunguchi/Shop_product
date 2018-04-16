package com.dunght.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dunght.shop.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByRoleName(String name);
}
