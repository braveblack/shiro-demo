package com.dream.dao;

import java.util.List;
import java.util.Map;

import com.dream.entity.User;
import com.dream.vo.UserVo;

public interface UserDao {
	public long createUser(User user);
    public int updateUser(User user);
    public void deleteUser(Long userId);

    public UserVo findOne(Long userId);

    public List<UserVo> findAll();

    public User findByUsername(String username);
	public void userAndroleRelation(Map map);
}
