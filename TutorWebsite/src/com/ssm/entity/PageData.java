package com.ssm.entity;

public class PageData {
	private int currentPage;		//当前页
	private int pageSize;			//每页的记录条数
	private int startIndex;			//查询记录时的开始位置
	//private int endIndex;			//查询记录时的结束位置
	//private int pageCount;			//总的页数
	//private int totalCount;			//总共的记录条数
	
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
	
	/*public int getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(int endIndex) {
		this.setEndIndex
	}*/
	
	/*public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		if(this.pageSize == 0){			//默认一页显示6条记录
			this.pageSize = 6;
		}
		if(this.currentPage == 0){
			this.currentPage = 1;		//默认显示第一页
		}
		
		//计算总页数  
        if(totalCount>0){  
            int tPage = totalCount / this.pageSize;//总记录数除以页面大小计算总页数  
            if (totalCount > tPage * this.pageSize) {//有余数,总页数加1  
                tPage += 1;  
            }  
            this.pageCount = tPage;  
              
        }else{//总记录数等于0  
            this.currentPage = 1;  
            this.startIndex = 0;  
            this.pageCount = 0;  
        }  
        int startRow =(this.currentPage-1)*this.pageSize;  
        this.startIndex = startRow;
	}*/
}
