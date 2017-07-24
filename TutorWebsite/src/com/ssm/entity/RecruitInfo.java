package com.ssm.entity;

public class RecruitInfo {
	
	private int recruitId;
	private String tutorSex;
	private String turtorType;
	private int pay;
	private int recruitNumber;
	private String location;
	private String classType;
	private String detail;
	private int userId;
	private String recruitStatus;
	private String school;
	private String grade;
	private String mark;
	private String feature;
	
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature ==null ? null : feature.trim();
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	
	
	public String getRecruitStatus() {
		return recruitStatus;
	}
	public void setRecruitStatus(String recruitStatus) {
		this.recruitStatus = recruitStatus;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getId() {
		return recruitId;
	}
	public void setId(int id) {
		this.recruitId = id;
	}
	public String getTutorSex() {
		return tutorSex;
	}
	public void setTutorSex(String tutorSex) {
		this.tutorSex = tutorSex;
	}
	public String getTurtorType() {
		return turtorType;
	}
	public void setTurtorType(String turtorType) {
		this.turtorType = turtorType;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public int getRecruitNumber() {
		return recruitNumber;
	}
	public void setRecruitNumber(int recruitNumber) {
		this.recruitNumber = recruitNumber;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getClassType() {
		return classType;
	}
	public void setClassType(String classType) {
		this.classType = classType;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail == null ? null : detail.trim();
	}
	
}

