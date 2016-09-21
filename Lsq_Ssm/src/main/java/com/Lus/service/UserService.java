package com.Lus.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.Lus.model.User;

public interface UserService {
	
	public int userInsert(User user);

	public int userDelete(int userId);

	public int userUpdate(User user);

	public User userSelect(int userId);

	public List<User> userList();
}
