package com.scinter.www.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scinter.www.dao.UserMapper;
import com.scinter.www.model.User;
import com.scinter.www.model.UserExample;

@Service
public class UserMapperImpl implements UserMapper {

	@Autowired
	private UserMapper userMapper;

	@Override
	public int countByExample(UserExample example) {
		return userMapper.countByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer userId) {
		return userMapper.deleteByPrimaryKey(userId);
	}

	@Override
	public int insert(User user) {
		return userMapper.insert(user);
	}

	@Override
	public int insertSelective(User record) {
		return userMapper.insertSelective(record);
	}

	@Override
	public List<User> selectByExample(UserExample example) {
		
		return userMapper.selectByExample(example);
	}

	@Override
	public User selectByPrimaryKey(Integer userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		return userMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(User record) {
		return userMapper.updateByPrimaryKey(record);
	}

	@Override
	public User selectForloginLowerCase(User record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User selectForlogin(User record) {
		// TODO Auto-generated method stub
		return null;
	}

}
