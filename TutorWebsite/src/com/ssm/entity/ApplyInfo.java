package com.ssm.entity;

public class ApplyInfo {
	private int recruitId;
	private int userId;
	private String applyStatus;
	
	public String getApplyStatus() {
		return applyStatus;
	}
	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}
	public int getRecruitId() {
		return recruitId;
	}
	public void setRecruitId(int recruitId) {
		this.recruitId = recruitId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
