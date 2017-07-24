package com.ssm.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.common.CommonMethod;
import com.ssm.entity.User;
import com.ssm.service.UserService;

@Controller
@RequestMapping("/RegisterPage")
public class RegisterController {
	/**
	 * 用户注册
	 */
	@Autowired UserService userService;
	@RequestMapping(value="/register",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> Register(User user)throws Exception{
		String statusCode;
		HashMap<String, String> data = new HashMap<String, String>();
		int result =userService.InsertUser(user);
		
		if(result != 1){
			statusCode = "0001";		//插入数据失败
		}else{
			statusCode = "0000";		//插入数据成功，返回该条数据的id
			data.put("id", String.valueOf(user.getUserId()));
		}
		
		CommonMethod CM=new CommonMethod();
		Map<String, Object> resulMap =CM.HandleData(statusCode, data);
		
		return resulMap;
	}

}

