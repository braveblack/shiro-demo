package com.dream.dao;

import java.util.List;

import com.dream.entity.Role;

public interface RoleDao {
		public Role createRole(Role role);
	    public int updateRole(Role role);
	    public void deleteRole(Long roleId);

	    public Role findOne(Long roleId);
	    public List<Role> findAll();
}
