package com.ssm.entity;

public class ShareInfoQuery {
	private int currentPage;		//当前页
	private int pageSize;			//每页的记录条数
	private int startIndex;			//查询记录时的开始位置
	private int userId;			
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
