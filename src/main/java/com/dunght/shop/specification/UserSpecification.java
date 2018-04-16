package com.dunght.shop.specification;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.dunght.shop.entity.Role;
import com.dunght.shop.entity.User;

public class UserSpecification implements Specification<User> {
	private Long roleId;
	private String input;

	/**
	 * @param roleId
	 * @param input
	 */
	public UserSpecification(Long roleId, String input) {
		super();
		this.roleId = roleId;
		this.input = input;
	}

	@Override
	public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		// TODO Auto-generated method stub
		Predicate predicate = cb.conjunction();

		if (input != null) {
			if (!input.isEmpty()) {
				predicate = cb.and(predicate, cb.like(root.<String>get("username"), '%' + input + '%'));
				predicate = cb.or(predicate, cb.like(root.<String>get("email"), '%' + input + '%'));
				predicate = cb.or(predicate, cb.like(root.<String>get("fullName"), '%' + input + '%'));
				return predicate;
			}
		}
		if (roleId != null) {
			predicate = cb.and(predicate, cb.isMember(new Role(roleId), root.<List<Role>>get("roles")));
		}
		return predicate;
	}

}
