package com.dream.service;

import java.util.List;
import java.util.Set;

import com.dream.entity.User;
import com.dream.vo.UserVo;

public interface UserService {

	public Set<String> findRoles(String username);

	public Set<String> findPermissions(String username);

	public User findByUsername(String username);

	public List<UserVo> findAllAccount();

}
