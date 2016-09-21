package com.Lus.dao;

import java.util.List;

import com.Lus.model.User;

public interface UserDao {

	public int userInsert(User user);

	public int userDelete(int userId);

	public int userUpdate(User user);

	public User userSelect(int userId);

	public List<User> userList();
}
