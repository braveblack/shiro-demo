package com.dream.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dream.dao.RoleDao;
import com.dream.entity.Role;
import com.dream.service.ResourceService;
import com.dream.service.RoleService;
import com.dream.util.StringUtil;
@Component
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private ResourceService resourceService;
	/*
	 * 根据角色的id获取角色表示符列表
	 * @see com.dream.service.RoleService#findRoles(java.lang.Long[])
	 */
	public Set<String> findRoles(long[] roleIds) {
		Set<String> roles=new HashSet<String>();
		for(long roleId:roleIds){
			Role role=roleDao.findOne(roleId);
			if(role!=null){
				roles.add(role.getRole());
			}
		}
		return roles;
	}
	public Set<String> findPermissions(long[] roleIds) {
		StringUtil stringUtil=new StringUtil();
		Set<Long> resourceIds=new HashSet<Long>();
		for(long roleId:roleIds){
			Role role=roleDao.findOne(roleId);
			if(role!=null){
				resourceIds.addAll(stringUtil.StringToList(role.getResourceIds(),","));
			}
		}
	    return resourceService.findPermissions(resourceIds);
	}
	
}
