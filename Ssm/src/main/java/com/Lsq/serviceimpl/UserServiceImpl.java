package com.Lsq.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Lsq.dao.UserMapper;
import com.Lsq.dto.User;
import com.Lsq.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private @Autowired(required = false) UserMapper user;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return user.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(User record) {
		return user.insert(record);
	}

	@Override
	public int insertSelective(User record) {
		return user.insertSelective(record);
	}

	@Override
	public User selectByPrimaryKey(Integer id) {
		return user.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		return user.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKey(User record) {
		return user.updateByPrimaryKey(record);
	}

	@Override
	public List<User> userList() {
		return user.userList();
	}

}
