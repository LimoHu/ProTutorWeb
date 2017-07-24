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
import com.ssm.entity.CommentPage;
import com.ssm.entity.PageData;
import com.ssm.entity.ShareComment;
import com.ssm.entity.ShareInfo;
import com.ssm.service.ShareCommentService;

@Controller
@RequestMapping("/ShareComment")
public class ShareCommentController {
	
	@Autowired ShareCommentService shareCommentService;
	
	@RequestMapping(value="/insertComment",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> InsertCommentInfo(ShareComment shareComment){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		try {
			shareCommentService.InsertCommentInfo(shareComment);
			resultMap.put("code", "0000");
		} catch (Exception e) {
			// TODO: handle exception
			resultMap.put("code", "0001");
		}
		return resultMap;
	}
	
	@RequestMapping(value="/commentList",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> GetShareCommentList(CommentPage commentPage){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		try {
			List<Map<String, String>> result = shareCommentService.SelectCommentList(commentPage);
			int totalNum = shareCommentService.GetCommentTotal(commentPage.getShareId());
			CommonMethod CM=new CommonMethod();
			resultMap =CM.HandlePageData(totalNum, result,commentPage.getPageSize());
		} catch (Exception e) {
			// TODO: handle exception
			resultMap.put("code", "0001");
		}
		return resultMap;
	}
	
}
