package com.ssm.serviceImpl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.entity.PageData;
import com.ssm.entity.User;
import com.ssm.mapper.UserMapper;
import com.ssm.service.UserService;

@Service("UserService")
public class UserServiceImpl implements UserService {
	static Logger logging = Logger.getLogger(UserServiceImpl.class.getName());
	
	@Autowired
	UserMapper userMapper;
	/**
	 * 用户注册
	 */
	
	@Override
	public int InsertUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.insertRegistorInfo(user);
	}
	
	/**
	 * 用户登录
	 */
	@Override
	public Map<String, String> selectLoginUserInfo(User user) {
		// TODO Auto-generated method stub
		return userMapper.selectLoginUserInfo(user);
	}

	@Override
	public List<Map<String, String>> SelectUserList(PageData pageData) {
		// TODO Auto-generated method stub
		return userMapper.selectUserList(pageData);
	}

	@Override
	public int GetUserTotal() {
		// TODO Auto-generated method stub
		return userMapper.selectUserTotal();
	}

	@Override
	public int DeleteUserInfo(int userId) {
		// TODO Auto-generated method stub
		return userMapper.deleteUser(userId);
	}

	@Override
	public int DisableUserInfo(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateUserStatus(user);
	}

	@Override
	public Map<String, String> selectStudentInfo(int userId) {
		// TODO Auto-generated method stub
		return userMapper.selectStudentInfo(userId);
	}

	@Override
	public Map<String, String> selectTutorInfo(int userId) {
		// TODO Auto-generated method stub
		return userMapper.selectTutorInfo(userId);
	}

	@Override
	public int UpdateUserInfo(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateUserInfo(user);
	}

}
