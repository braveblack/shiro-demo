package com.dream.service;

import java.util.Set;

import com.dream.entity.User;

public interface UserService {

	public Set<String> findRoles(String username);

	public Set<String> findPermissions(String username);

	public User findByUsername(String username);

}
