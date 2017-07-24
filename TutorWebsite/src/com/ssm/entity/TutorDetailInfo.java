package com.ssm.entity;

public class TutorDetailInfo {
	private int userId;
	private String realname;
	private String phonenumber;
	private String sex;
	private String identity;
	private String try_teachtime;
	private int try_price;
	private String try_rule;
	private String teachtype;
	private int teachexperience;
	private String teachtime;
	private String introduction;
	
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getTeachtime() {
		return teachtime;
	}
	public void setTeachtime(String teachtime) {
		this.teachtime = teachtime;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getTry_teachtime() {
		return try_teachtime;
	}
	public void setTry_teachtime(String try_teachtime) {
		this.try_teachtime = try_teachtime;
	}
	public int getTry_price() {
		return try_price;
	}
	public void setTry_price(int try_price) {
		this.try_price = try_price;
	}
	public String getTry_rule() {
		return try_rule;
	}
	public void setTry_rule(String try_rule) {
		this.try_rule = try_rule;
	}
	public String getTeachtype() {
		return teachtype;
	}
	public void setTeachtype(String teachtype) {
		this.teachtype = teachtype;
	}
	public int getTeachexperience() {
		return teachexperience;
	}
	public void setTeachexperience(int teachexperience) {
		this.teachexperience = teachexperience;
	}
}
