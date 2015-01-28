package com.dream.service.impl;

import java.util.Collections;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dream.dao.UserDao;
import com.dream.entity.User;
import com.dream.service.ResourceService;
import com.dream.service.RoleService;
import com.dream.service.UserService;
import com.dream.util.StringUtil;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleService roleService;
	/* 根据帐号名获取角色的字符
	 * @see com.dream.service.UserService#findRoles(java.lang.String)
	 */
	public Set<String> findRoles(String username) {
		StringUtil stringUtil=new StringUtil();
		User user=userDao.findByUsername(username);
		if(user == null) {
            return Collections.EMPTY_SET;
        }
        return roleService.findRoles(stringUtil.stringToLong(user.getRoleIds(), ","));
	}
	/*
	 * 根据帐号名获取角权限的字符串
	 * @see com.dream.service.UserService#findPermissions(java.lang.String)
	 */
	public Set<String> findPermissions(String username) {
		StringUtil stringUtil=new StringUtil();
		User user=userDao.findByUsername(username);
		if(user==null){
			return Collections.EMPTY_SET;
		}
		return	roleService.findPermissions(stringUtil.stringToLong(user.getRoleIds(), ","));
	}

	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

}
