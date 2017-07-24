package com.ssm.mapper;

import java.util.List;
import java.util.Map;

import com.ssm.entity.PageData;
import com.ssm.entity.User;

public interface UserMapper {
	
    int insertRegistorInfo(User user);    //用户注册
    Map<String, String> selectLoginUserInfo(User user);     //用户登录
    List<Map<String, String>> selectUserList(PageData pageData);
    int selectUserTotal();
    int deleteUser(int userId);
    int updateUserStatus(User user);
    Map<String, String> selectStudentInfo(int userId);
    Map<String, String> selectTutorInfo(int userId);
    int updateUserInfo(User user);
}