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
import com.ssm.entity.CollectInfo;
import com.ssm.service.CollectInfoService;

@Controller
@RequestMapping("/Collect")
public class CollectInfoController {
	
	@Autowired CollectInfoService collectInfoService;
	
	@RequestMapping(value="/insertCollectInfo",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> InsertCollectInfo(CollectInfo collectInfo){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		try {
			collectInfoService.InsertCollectInfo(collectInfo);
			resultMap.put("code", "0000");
		} catch (Exception e) {
			// TODO: handle exception
			resultMap.put("code", "0001");
		}
		return resultMap;
	}
	
	@RequestMapping(value="/checkCollected",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> CheckCollectedInfo(CollectInfo collectInfo){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		try {
			Map<String, String> result = collectInfoService.CheckCollectedInfo(collectInfo);
			CommonMethod CM = new CommonMethod();
			resultMap = CM.HandleData("0000", result);
		} catch (Exception e) {
			// TODO: handle exception
			resultMap.put("code", "0001");
		}
		return resultMap;
	}
	
	@RequestMapping(value="/collectList",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> SelectCollectList(int userId){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		try {
			List<Map<String, String>> result = collectInfoService.SelectCollectList(userId);
			CommonMethod CM = new CommonMethod();
			resultMap = CM.HandleDataList("0000", result);
		} catch (Exception e) {
			// TODO: handle exception
			resultMap.put("code", "0001");
		}
		return resultMap;
	}
	
	
}
