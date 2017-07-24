package com.ssm.serviceImpl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.entity.CommentPage;
import com.ssm.entity.ShareComment;
import com.ssm.mapper.ShareCommentMapper;
import com.ssm.service.ShareCommentService;

@Service("ShareCommentService")
public class ShareCommentServiceImpl implements ShareCommentService {
	
static Logger logging = Logger.getLogger(ApplyInfoImpl.class.getName());
	
	@Autowired
	ShareCommentMapper shareCommentMapper;

	@Override
	public int InsertCommentInfo(ShareComment shareComment) {
		// TODO Auto-generated method stub
		return shareCommentMapper.insertCommentInfo(shareComment);
	}

	@Override
	public List<Map<String, String>> SelectCommentList(CommentPage commentPage) {
		// TODO Auto-generated method stub
		return shareCommentMapper.selectCommentList(commentPage);
	}

	@Override
	public int GetCommentTotal(int shareId) {
		// TODO Auto-generated method stub
		return shareCommentMapper.getCommentTotal(shareId);
	} 
}
