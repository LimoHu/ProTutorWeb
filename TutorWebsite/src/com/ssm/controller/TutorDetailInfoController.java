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
import com.ssm.entity.TutorDetailInfo;
import com.ssm.entity.TutorQuery;
import com.ssm.service.TutorDetailInfoService;

@Controller
@RequestMapping("/TutorDetailInfo")
public class TutorDetailInfoController {
	
	@Autowired
	TutorDetailInfoService tutorDetailInfoService;
	
	/**
	 * 添加详细的家教信息
	 * @param tutorDetailInfo
	 * @return
	 */
	@RequestMapping(value="/addDetail",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> AddTutorDetail(TutorDetailInfo tutorDetailInfo){
		String statusCode;
		HashMap<String, String> data = new HashMap<String, String>();
		int result =tutorDetailInfoService.AddTutorDetailInfo(tutorDetailInfo);
		
		if(result != 1){
			statusCode = "0001";		//插入数据失败
		}else{
			statusCode = "0000";		//插入数据成功，返回该条数据的id
		}
		
		CommonMethod CM=new CommonMethod();
		Map<String, Object> resulMap =CM.HandleData(statusCode, data);
		
		return resulMap;
	}
	
	/**
	 * 获取家教详细信息列表
	 * @return
	 */
	@RequestMapping(value="/tutorDetailInfoList",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> GetTutorDetailInfoList(PageData pageData){
		
		Map<String, Object> resulMap = new HashMap<String, Object>();
		try {
			List<Map<String, String>> result = tutorDetailInfoService.SelectTutorDetailInfoList(pageData);
			int totalNum = tutorDetailInfoService.GetTotalNumber();
			
			for (Map<String, String> map : result) {
				String[] teachtype = map.get("teachtype").split(",");
				String teachTypeChanged = "";
				
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
				map.put("teachtype", teachTypeChanged.substring(1));
			}
			
			CommonMethod CM=new CommonMethod();
			resulMap =CM.HandlePageData(totalNum, result ,pageData.getPageSize());
		} catch (Exception e) {
			resulMap.put("code", "00001");
		}
		return resulMap;
	}
	
	/**
	 * 获取优质家教详细信息列表前四条
	 * @return
	 */
	@RequestMapping(value="/tutorDetailInfoFour",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> GetFourTutorDetailInfo(){
		
		Map<String, Object> resulMap = new HashMap<String, Object>();
		
		try {
			List<Map<String, String>> result = tutorDetailInfoService.SelectFourTutorDetailInfo();
		    CommonMethod CM=new CommonMethod();
			resulMap =CM.HandleDataList("0000", result);
		} catch (Exception e) {
			resulMap.put("code", "0001");
		}
		return resulMap;
	}
	
	/**
	 * 获取单条家教详细信息
	 * @return
	 */
	@RequestMapping(value="/tutorDetail",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> GetSingleTutorDetailInfo(int userId){
		
		Map<String, Object> resulMap = new HashMap<String, Object>();
		
		try {
			Map<String, String> result = tutorDetailInfoService.SelectSingleTutorDetailInfo(userId);
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
	 * 添加详细的家教信息
	 * @param tutorDetailInfo
	 * @return
	 */
	@RequestMapping(value="/updateDetail",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> UpdateTutorDetail(TutorDetailInfo tutorDetailInfo){
		Map<String, Object> resulMap = new HashMap<String, Object>(); 
		try {
			tutorDetailInfoService.UpdateTutorDetailInfo(tutorDetailInfo);
			resulMap.put("code", "0000");
		} catch (Exception e) {
			resulMap.put("code", "0001");
		}
		return resulMap;
	}
	
	/**
	 * 获取家教详细信息列表
	 * @return
	 */
	@RequestMapping(value="/queryTutorInfoList",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> QueryTutorDetailInfoList(TutorQuery tutorQuery){
		
		Map<String, Object> resulMap = new HashMap<String, Object>();
		try {
			List<Map<String, String>> result = tutorDetailInfoService.QueryTutorInfoList(tutorQuery);
			int totalNum = tutorDetailInfoService.QueryTotalNumber(tutorQuery);
			
			for (Map<String, String> map : result) {
				String[] teachtype = map.get("teachtype").split(",");
				String teachTypeChanged = "";
				
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
				map.put("teachtype", teachTypeChanged.substring(1));
			}
			
			CommonMethod CM=new CommonMethod();
			resulMap =CM.HandlePageData(totalNum, result ,tutorQuery.getPageSize());
		} catch (Exception e) {
			resulMap.put("code", "0001");
		}
		return resulMap;
	}
}
