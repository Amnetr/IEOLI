package com.ieoli.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ieoli.dao.UserEntityMapper;
import com.ieoli.entity.UserEntity;
import com.ieoli.service.UserService;
@Service("userservice")
public class UserEntityImpl implements UserService {
	
	@Resource
	private UserEntityMapper userMapper;

	@Override
	public UserEntity getUserByID(int id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateUser(UserEntity user) {
		// TODO Auto-generated method stub
		userMapper.updateByPrimaryKeySelective(user);
	}

}
