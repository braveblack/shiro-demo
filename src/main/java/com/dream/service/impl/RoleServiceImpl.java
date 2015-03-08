package com.dream.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dream.dao.RoleDao;
import com.dream.entity.Resource;
import com.dream.entity.Role;
import com.dream.service.ResourceService;
import com.dream.service.RoleService;
import com.dream.util.StringUtil;
import com.dream.vo.RoleVo;
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
			RoleVo roleVo=roleDao.findOne(roleId);
				if(roleVo.getRole()!=null){
					roles.add(roleVo.getRole());
				}
			}
		return roles;
	}
	public Set<String> findPermissions(long[] roleIds) {
		Set<String> permissions=new HashSet<String>();
		for(long roleId:roleIds){
			RoleVo roleVo=roleDao.findOne(roleId);
				for(Resource resource:roleVo.getListResources()){
					if(!(resource.getPermission()==null||"null".equals(resource.getPermission())))
					permissions.add(resource.getPermission());
				}
		}
	    return permissions;
	}
	
}
