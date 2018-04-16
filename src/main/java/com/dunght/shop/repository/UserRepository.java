package com.dunght.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dunght.shop.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
