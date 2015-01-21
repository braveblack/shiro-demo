package com.dream.service.impl;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.dream.entity.User;
import com.dream.service.UserService;

@Component
public class UserServiceImpl implements UserService {

	public Set<String> findRoles(String username) {
		return null;
	}

	public Set<String> findPermissions(String username) {
		return null;
	}

	public User findByUsername(String username) {
		return null;
	}

}
