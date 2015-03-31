package com.dream.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.beust.jcommander.internal.Maps;
import com.dream.dao.UserDao;
import com.dream.entity.Role;
import com.dream.entity.User;
import com.dream.service.PasswordHelper;
import com.dream.service.RoleService;
import com.dream.service.UserService;
import com.dream.vo.UserVo;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleService roleService;
	@Autowired
    private PasswordHelper passwordHelper;
	/* 根据帐号名获取角色的字符
	 * @see com.dream.service.UserService#findRoles(java.lang.String)
	 */
	public Set<String> findRoles(String username) {
		User user=userDao.findByUsername(username);
		UserVo userVo=userDao.findOne(user.getId());
		Set<String> setRoles=new HashSet<String>();
		for(Role role:userVo.getListRole()){
			setRoles.add(role.getRole());
		}
        return setRoles;
	}
	/*
	 * 根据帐号名获取角权限的字符串
	 * @see com.dream.service.UserService#findPermissions(java.lang.String)
	 */
	public Set<String> findPermissions(String username) {
		User user=userDao.findByUsername(username);
		List<Role> roles=userDao.findOne(user.getId()).getListRole();
		long[] ids=new long[roles.size()];
		for(int i=0;i<roles.size();i++){
			ids[i]=roles.get(i).getId();
		}
		return	roleService.findPermissions(ids);
	}

	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}
	public List<UserVo> findAllAccount() {
		return userDao.findAll();
	}
	public void userSave(User user, long[] roleIds) {
		 passwordHelper.encryptPassword(user);
		userDao.createUser(user);
		for(long roleId:roleIds){
			Map<String,Long> map=Maps.newHashMap();
			map.put("userId", user.getId());
			map.put("roleId", roleId);
			userDao.userAndroleRelation(map);
		}
	}
	//2015-03-16 先删除关系，然后在维护
	public void userUpdate(User user, long[] roleIds) {
		// TODO Auto-generated method stub
		
	}

}
