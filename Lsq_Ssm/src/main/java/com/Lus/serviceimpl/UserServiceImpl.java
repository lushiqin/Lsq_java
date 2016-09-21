package com.Lus.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Lus.dao.UserDao;
import com.Lus.model.User;
import com.Lus.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private @Autowired UserDao userdao;

	@Override
	public int userInsert(User user) {
		return userdao.userInsert(user);
	}

	@Override
	public int userDelete(int userId) {
		return userdao.userDelete(userId);
	}

	@Override
	public int userUpdate(User user) {
		return userdao.userUpdate(user);
	}

	@Override
	public User userSelect(int userId) {
		return userdao.userSelect(userId);
	}

	@Override
	public List<User> userList() {
		return userdao.userList();
	}

}
