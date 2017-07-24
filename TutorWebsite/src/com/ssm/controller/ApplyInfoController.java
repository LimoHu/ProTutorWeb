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
import com.ssm.entity.ApplyInfo;
import com.ssm.service.ApplyInfoService;

@Controller
@RequestMapping("/Apply")
public class ApplyInfoController {
	
	@Autowired ApplyInfoService applyInfoService;
	@RequestMapping(value="/insertApplyInfo",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> InsertApplyInfo(ApplyInfo applyInfo){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			int total = applyInfoService.CheckApplyed(applyInfo);
			if(total == 0){
				applyInfoService.InsertApplyInfo(applyInfo);
				resultMap.put("code","0000");
			}else{
				resultMap.put("code","0002");			//表示已预约
			}
		} catch (Exception e) {
			// TODO: handle exception
			resultMap.put("code","0001");
		}
		
		return resultMap;
	}
	
	@RequestMapping(value="/applyInfoList",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> GetApplyInfoList(int recruitId){
		String statusCode;
		Map<String, Object> resulMap = new HashMap<String, Object>();
		
		try {
			List<Map<String, String>> result =applyInfoService.SelectApplyInfoList(recruitId);
			statusCode = "0000";	
			CommonMethod CM=new CommonMethod();
			resulMap =CM.HandleDataList(statusCode, result);
		} catch (Exception e) {
			resulMap.put("code", "0001");
		}
		
		return resulMap;
	}
	
	@RequestMapping(value="/chooseApplicant",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> ChooseApplyInfo(int applyId){
		Map<String, Object> resulMap = new HashMap<String, Object>();
		try {
			applyInfoService.ChooseApplicant(applyId);
			resulMap.put("code", "0000");
		} catch (Exception e) {
			resulMap.put("code", "0001");
		}
		return resulMap;
	}
	
	@RequestMapping(value="/applyList",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> GetApplyList(int userId){
		Map<String, Object> resulMap = new HashMap<String, Object>();
		
		try {
			List<Map<String, String>> result =applyInfoService.SelectApplyList(userId);
			CommonMethod CM=new CommonMethod();
			resulMap =CM.HandleDataList("0000", result);
		} catch (Exception e) {
			resulMap.put("code", "0001");
		}
		return resulMap;
	}
}
