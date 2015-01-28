package com.dream.service;

import java.util.Set;


public interface RoleService {
	public Set<String> findRoles(long[] roleIds);
	public Set<String> findPermissions(long[] roleIds);
}
