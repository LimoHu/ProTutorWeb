package com.ssm.service;

import java.util.List;
import java.util.Map;

import com.ssm.entity.PageData;
import com.ssm.entity.User;

public interface UserService {

	//创建查询用户列表
	public abstract int InsertUser(User user);
	public abstract Map<String, String> selectLoginUserInfo(User user);
	public abstract List<Map<String, String>> SelectUserList(PageData pageData);
	public abstract int GetUserTotal();
	public abstract int DeleteUserInfo(int userId);
	public abstract int DisableUserInfo(User user);
	public abstract Map<String, String> selectStudentInfo(int userId);
	public abstract Map<String, String> selectTutorInfo(int userId);
	public abstract int UpdateUserInfo(User user);

}
