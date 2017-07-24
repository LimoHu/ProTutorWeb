package com.ssm.entity;

public class TutorQuery {
	private int currentPage;		//当前页
	private int pageSize;			//每页的记录条数
	private int startIndex;			//查询记录时的开始位置
	private String teachtype;			
	private String sex;
	private String identity;
	
	public String getTeachtype() {
		return teachtype;
	}
	public void setTeachtype(String teachtype) {
		this.teachtype = teachtype;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		this.startIndex = (currentPage-1)*this.pageSize;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize; 
		this.startIndex = (this.currentPage-1)*this.pageSize;
	}
	
	public int getStartIndex() {
		return startIndex;
	}
	
	public void setStartIndex(int startIndex) {
		this.startIndex = (this.currentPage-1)*this.pageSize;
	}
}
