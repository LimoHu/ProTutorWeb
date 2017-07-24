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
import com.ssm.entity.ShareInfo;
import com.ssm.entity.ShareInfoQuery;
import com.ssm.service.ShareInfoService;

@Controller
@RequestMapping("/ShareInfo")
public class ShareInfoController {
	
	@Autowired ShareInfoService shareInfoService;
	
	@RequestMapping(value="/insertShareInfo",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> InsertShareInfo(ShareInfo shareInfo){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		try {
			shareInfoService.InsertShareInfo(shareInfo);
			resultMap.put("code", "0000");
		} catch (Exception e) {
			// TODO: handle exception
			resultMap.put("code", "0001");
		}
		return resultMap;
	}
	
	@RequestMapping(value="/shareInfoList",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> GetShareInfoList(ShareInfoQuery shareInfoQuery){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		try {
			List<Map<String, String>> result = shareInfoService.SelectShareInfoList(shareInfoQuery);
			int totalNum = shareInfoService.GetShareInfoTotal();
			CommonMethod CM=new CommonMethod();
			resultMap =CM.HandlePageData(totalNum, result,shareInfoQuery.getPageSize());
		} catch (Exception e) {
			// TODO: handle exception
			resultMap.put("code", "0001");
		}
		return resultMap;
	}
	
	@RequestMapping(value="/shareInfoSingle",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> GetshareInfoSingle(int shareId){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		try {
			Map<String, String> result = shareInfoService.SelectSingleShareInfo(shareId);
			CommonMethod CM=new CommonMethod();
			resultMap =CM.HandleData("0000",result);
		} catch (Exception e) {
			// TODO: handle exception
			resultMap.put("code", "0001");
		}
		return resultMap;
	}
}
