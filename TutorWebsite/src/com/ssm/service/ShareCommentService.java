package com.ssm.service;

import java.util.List;
import java.util.Map;

import com.ssm.entity.CommentPage;
import com.ssm.entity.ShareComment;

public interface ShareCommentService {
	public abstract int InsertCommentInfo(ShareComment shareComment);
	public abstract List<Map<String, String>>SelectCommentList(CommentPage commentPage);
	public abstract int GetCommentTotal(int shareId);
}
