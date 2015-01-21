package com.dream.dao;

import java.util.List;

import com.dream.entity.User;

public interface UserDao {
	public User createUser(User user);
    public int updateUser(User user);
    public void deleteUser(Long userId);

    public User findOne(Long userId);

    public List<User> findAll();

    public User findByUsername(String username);
}
