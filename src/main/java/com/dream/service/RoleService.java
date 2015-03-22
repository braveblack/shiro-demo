package com.dream.service;

import java.util.List;
import java.util.Set;

import com.dream.entity.Role;


public interface RoleService {
	public Set<String> findRoles(long[] roleIds);
	public Set<String> findPermissions(long[] roleIds);
	public List<Role> findAll();
}
