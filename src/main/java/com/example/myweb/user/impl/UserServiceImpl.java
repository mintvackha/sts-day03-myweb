package com.example.myweb.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myweb.user.UserService;
import com.example.myweb.user.UserVO;

@Service("userService")
public abstract class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDao;

	@Override
	public UserVO getOne(UserVO vo) {
		return userDao.findById(vo);
	}

	@Override
	public List<UserVO> getList(UserVO vo) {
		System.out.println(">>> getList ...");
		return userDao.selectAll();
	}

	@Override
	public void insert(UserVO vo) {
		userDao.insert(vo);
	}

	@Override
	public void update(UserVO vo) {
		userDao.update(vo);
	}

	@Override
	public void delete(UserVO vo) {
		userDao.delete(vo);
	}
}