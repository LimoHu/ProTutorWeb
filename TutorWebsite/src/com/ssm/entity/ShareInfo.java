package com.ssm.entity;

public class ShareInfo {
	private int shareId;
	private String shareinfo;
	private int userId;
	private String shareTime;
	
	
	public String getShareTime() {
		return shareTime;
	}
	public void setShareTime(String shareTime) {
		this.shareTime = shareTime;
	}
	public int getShareId() {
		return shareId;
	}
	public void setShareId(int shareId) {
		this.shareId = shareId;
	}
	public String getShareinfo() {
		return shareinfo;
	}
	public void setShareinfo(String shareinfo) {
		this.shareinfo = shareinfo;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
