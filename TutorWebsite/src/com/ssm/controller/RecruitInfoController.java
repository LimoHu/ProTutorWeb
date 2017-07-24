package com.ssm.controller;


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
import com.ssm.entity.RecruitInfo;
import com.ssm.entity.RecruitQuery;
import com.ssm.service.RecruitInfoService;


@Controller
@RequestMapping("/RecruitInfo")
 
public class RecruitInfoController {
	
	
	/**
	 * 添加发布的家教招聘信息
	 */
	@Autowired 
	RecruitInfoService recruitInfoService;
	
	@RequestMapping(value="/insertRecruitInfo", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> InsertRecruitInfo(RecruitInfo recruitInfo){
		String statusCode;
		int result = recruitInfoService.InsertRecruitInfo(recruitInfo);
		HashMap<String, String> data = new HashMap<String, String>();
		
		if(result != 1){
			statusCode = "0001";		//插入数据失败
		}else{
			statusCode = "0000";		//插入数据成功
		}
		
		CommonMethod CM=new CommonMethod();
		Map<String, Object> resulMap =CM.HandleData(statusCode, data);
		
		return resulMap;
	}
	
	/**
	 * 获取招聘信息列表
	 * @return
	 */
	@RequestMapping(value="/recruitInfoList",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> GetRecruitInfoList(PageData pageData){
		
		Map<String, Object> resulMap = new HashMap<String, Object>();
		try {
			List<Map<String, String>> result = recruitInfoService.SelectRecruitInfoList(pageData);
			int totalNum = recruitInfoService.GetTotalNumber();
			CommonMethod CM=new CommonMethod();
			resulMap =CM.HandlePageData(totalNum, result,pageData.getPageSize());
		} catch (Exception e) {
			resulMap.put("code", "00001");
		}
		return resulMap;
	}
	
	/**
	 * 获取家教急聘前三条
	 * @return
	 */
	@RequestMapping(value="/recruitInfoThree",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> GetThreeRecruitInfo(){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		try {
			List<Map<String, String>> result = recruitInfoService.SelectThreeRecruitInfo();
			CommonMethod CM=new CommonMethod();
			resultMap =CM.HandleDataList("0000", result);
		} catch (Exception e) {
			// TODO: handle exception
			resultMap.put("code", "0001");
		}
		 
		 
		return resultMap;
	}
	
	/**
	 * 获取家教最新消息招聘前十条
	 * @return
	 */
	@RequestMapping(value="/recruitInfoTen",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> GetTenRecruitInfo(){
		List<Map<String, String>> result = recruitInfoService.SelectTenRecruitInfo();
		
		 String statusCode = "0000";
		 CommonMethod CM=new CommonMethod();
		 Map<String, Object> resulMap =CM.HandleDataList(statusCode, result);
		 
		return resulMap;
	}
	
	/**
	 * 获取单条家教招聘信息详情
	 * @return
	 */
	@RequestMapping(value="/recruitDetailInfo",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> GetSingleRecruitInfo(int recruitId){
		Map<String, String> result = recruitInfoService.SelectSingleRecruitInfo(recruitId);
		
		 String statusCode = "0000";
		 CommonMethod CM=new CommonMethod();
		 Map<String, Object> resulMap = CM.HandleData(statusCode, result);
		 
		return resulMap;
	}
	
	/**
	 * 家教老师在线预约招聘家长
	 * @return
	 */
	@RequestMapping(value="/updateRecruitInfo",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> UpdatesRecruitInfo(int recruitId){
		Map<String, Object> resulMap = new HashMap<String, Object>();
		try {
			Map<String, String> result = recruitInfoService.SelectSingleRecruitInfo(recruitId);
			CommonMethod CM=new CommonMethod();
			resulMap =CM.HandleData("0000", result);
		} catch (Exception e) {
			// TODO: handle exception
			resulMap.put("code", "0001");
		}
		return resulMap;
	}
	
	/**
	 * 获取招聘信息列表----管理者
	 * @return
	 */
	@RequestMapping(value="/infoList",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> GetInfoList(PageData pageData){
		
		Map<String, Object> resulMap = new HashMap<String, Object>();
		try {
			List<Map<String, String>> result = recruitInfoService.SelectInfoList(pageData);
			int totalNum = recruitInfoService.GetTotalNumber();
			CommonMethod CM=new CommonMethod();
			resulMap =CM.HandlePageData(totalNum, result,pageData.getPageSize());
		} catch (Exception e) {
			resulMap.put("code", "00001");
		}
		return resulMap;
	}
	
	/**
	 * 删除单条家教招聘信息详情
	 * @return
	 */
	@RequestMapping(value="/deletInfo",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> DeleteRecruitInfo(int recruitId){
		
		Map<String, Object> resulMap = new HashMap<String, Object>(); 
		try {
			recruitInfoService.DeleteRecruitInfo(recruitId);
			resulMap.put("code", "0000");
		} catch (Exception e) {
			resulMap.put("code", "0001");
		}
		return resulMap;
	}
	
	/**
	 * 课程类型分析数据
	 * @return
	 */
	@RequestMapping(value="/classType",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> GetClassTypeAnalyseData(){
		
		Map<String, Object> resulMap = new HashMap<String, Object>(); 
		try {
			List<Map<String, String>> result = recruitInfoService.SelectClassTypeAnalyse();
		    CommonMethod CM=new CommonMethod();
			resulMap =CM.HandleDataList("0000", result);
		} catch (Exception e) {
			resulMap.put("code", "0001");
		}
		return resulMap;
	}
	
	/**
	 * 学员成绩分析数据
	 * @return
	 */
	@RequestMapping(value="/mark",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> GetMarkAnalyseData(){
		
		Map<String, Object> resulMap = new HashMap<String, Object>(); 
		try {
			List<Map<String, String>> result = recruitInfoService.SelectMarkAnalyse();
		    CommonMethod CM=new CommonMethod();
		    resulMap =CM.HandleDataList("0000", result);
		} catch (Exception e) {
			resulMap.put("code", "0001");
		}
		return resulMap;
	}
	
	/**
	 * 获取招聘信息列表
	 * @return
	 */
	@RequestMapping(value="/queryRecruitInfoList",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> QueryRecruitInfoList(RecruitQuery recruitQuery){
		
		Map<String, Object> resulMap = new HashMap<String, Object>();
		try {
			List<Map<String, String>> result = recruitInfoService.QueryRecruitInfoList(recruitQuery);
			int totalNum = recruitInfoService.QueryRecruitNumber(recruitQuery);
			CommonMethod CM=new CommonMethod();
			resulMap =CM.HandlePageData(totalNum, result,recruitQuery.getPageSize());
		} catch (Exception e) {
			resulMap.put("code", "00001");
		}
		return resulMap;
	}
	
	/**
	 * 获取招聘信息列表
	 * @return
	 */
	@RequestMapping(value="/recruitSample",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> QueryRecruitSample(int userId){
		
		Map<String, Object> resulMap = new HashMap<String, Object>();
		try {
			List<Map<String, String>> result = recruitInfoService.SelectRecruiSample(userId);
			CommonMethod CM=new CommonMethod();
			resulMap =CM.HandleDataList("0000", result);
		} catch (Exception e) {
			resulMap.put("code", "00001");
		}
		return resulMap;
	}
	
}
