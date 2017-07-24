package com.ssm.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.common.CommonMethod;
import com.ssm.entity.PageData;
import com.ssm.entity.User;
import com.ssm.service.UserService;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

@Controller
@RequestMapping("/User")
public class UserController {
	
	@Autowired
	UserService userService;
	
	/**
	 * 用户注册
	 */
	
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
			data.put("userId", String.valueOf(user.getUserId()));
		}
		
		CommonMethod CM=new CommonMethod();
		Map<String, Object> resulMap =CM.HandleData(statusCode, data);
		
		return resulMap;
	}
	
	/**
	 * 用户登录
	 */
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> Login(User user){
		Map<String, Object> resulMap = new HashMap<String, Object>(); 
		try {
			Map<String, String> result = userService.selectLoginUserInfo(user);
			if(result == null){
				resulMap.put("code", "0002");
			}else{
				CommonMethod CM = new CommonMethod();
				resulMap = CM.HandleData("0000", result);
			}
		} catch (Exception e) {
			resulMap.put("code", "0001");
		}
		return resulMap;
	}
	
	/**
	 * 用户列表
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> GetUserList(PageData pageData){
		Map<String, Object> resulMap = new HashMap<String, Object>(); 
		try {
			List<Map<String, String>> result = userService.SelectUserList(pageData);
			int totalNum = userService.GetUserTotal();
			CommonMethod CM=new CommonMethod();
			resulMap =CM.HandlePageData(totalNum, result,pageData.getPageSize());
		} catch (Exception e) {
			resulMap.put("code", "0001");
		}
		return resulMap;
	}
	
	/**
	 * 删除用户
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> DeleteUser(int userId){
		Map<String, Object> resulMap = new HashMap<String, Object>(); 
		try {
			userService.DeleteUserInfo(userId);
			resulMap.put("code", "0000");
		} catch (Exception e) {
			resulMap.put("code", "0001");
		}
		return resulMap;
	}
	
	/**
	 * 禁用用户
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/disable",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> DisableUser(User user){
		Map<String, Object> resulMap = new HashMap<String, Object>(); 
		try {
			userService.DisableUserInfo(user);
			resulMap.put("code", "0000");
		} catch (Exception e) {
			resulMap.put("code", "0001");
		}
		return resulMap;
	}
	
	/**
	 * 学员用户个人信息
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/studentInfo",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> GetStudentInfo(int userId){
		Map<String, Object> resulMap = new HashMap<String, Object>(); 
		try {
			Map<String, String> result = userService.selectStudentInfo(userId);
			CommonMethod CM = new CommonMethod();
			resulMap = CM.HandleData("0000", result);
		} catch (Exception e) {
			resulMap.put("code", "0001");
		}
		return resulMap;
	}
	
	/**
	 * 家教用户个人信息
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/tutorInfo",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> GetUserInfo(int userId){
		Map<String, Object> resulMap = new HashMap<String, Object>(); 
		try {
			Map<String, String> result = userService.selectTutorInfo(userId);
			List<String> teachtime = Arrays.asList(result.get("teachtime").split(","));
			String[] teachtype = result.get("teachtype").split(",");
			String teachTypeChanged = "";
			
			List<HashMap<String, String>> reTimeList = new ArrayList<HashMap<String, String>>();
			for(int i=0;i<3;i++){
				HashMap<String, String> timeHashMap =new HashMap<String, String>();
				String[] timeArr = new String[7];
				if(i==0){
					timeHashMap.put("timesolt", "M");
					timeArr = new String[]{"Mon-M","Tue-M","Wen-M","Thu-M","Fri-M","Sat-M","Sun-M"};
				}else if(i==1){
					timeHashMap.put("timesolt", "A");
					timeArr = new String[]{"Mon-A","Tue-A","Wen-A","Thu-A","Fri-A","Sat-A","Sun-A"};
				}else{
					timeHashMap.put("timesolt", "N");
					timeArr = new String[]{"Mon-N","Tue-N","Wen-N","Thu-N","Fri-N","Sat-N","Sun-N"};
				}
				
				for(int m=0;m < timeArr.length;m++){
					if(teachtime.contains(timeArr[m])){
						timeHashMap.put(timeArr[m].split("-")[0], "1");
					}else{
						timeHashMap.put(timeArr[m].split("-")[0], "0");
					}
				}
				reTimeList.add(timeHashMap);
			}
			
			result.remove("teachtime");
			result.remove("teachtype");
			
			for (String type : teachtype) {
				if(type.equals("1")){
					teachTypeChanged += ",学前教育";
				}else if(type.equals("2")){
					teachTypeChanged += ",小学家教";
				}else if(type.equals("3")){
					teachTypeChanged += ",初中家教";
				}else if(type.equals("4")){
					teachTypeChanged += ",高中家教";
				}else if(type.equals("5")){
					teachTypeChanged += ",外语家教";
				}else if(type.equals("6")){
					teachTypeChanged += ",特长家教";
				}else{
					teachTypeChanged += "";
				}
			}
			
			result.put("teachtype", teachTypeChanged.substring(1));
			
			CommonMethod CM = new CommonMethod();
			resulMap = CM.HandleDataObjedt(result,"teachtime",reTimeList);
		} catch (Exception e) {
			resulMap.put("code", "0001");
		}
		return resulMap;
	}
	
	/**
	 * 修改用户基本信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object>UpdateInfo(User user)throws Exception{
		Map<String, Object> resulMap = new HashMap<String, Object>(); 
		try {
			userService.UpdateUserInfo(user);
			resulMap.put("code", "0000");
		} catch (Exception e) {
			// TODO: handle exception
			resulMap.put("code", "0001");
		}
		
		return resulMap;
	}
}
