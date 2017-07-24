package com.ssm.mapper;

import java.util.List;
import java.util.Map;

import com.ssm.entity.CommentPage;
import com.ssm.entity.ShareComment;

public interface ShareCommentMapper {
	int insertCommentInfo(ShareComment shareComment);
	List<Map<String, String>>selectCommentList(CommentPage commentPage);
	int getCommentTotal(int shareId);
}
