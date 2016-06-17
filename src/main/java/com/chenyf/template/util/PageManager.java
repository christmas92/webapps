package com.chenyf.template.util;

import java.util.List;

public class PageManager<T> {
	private int pageRecords = 10;  //每页记录数
	private int sliderWidth = 5;  //页码长度
	
	private int currentPage = 0;   //当前页
	//private int totalPages = 0;    //总页数
    private int totalRecords = 0;  // 总数据数
    
    //private int pageStartRow = 0;  // 每页的起始数
    //private int pageEndRow = 0;    // 每页显示数据的终止数
    //private boolean hasNextPage = false; // 是否有下一页
    //private boolean hasPreviousPage = false; // 是否有前一页
	private List<T> records;       // 记录
	
	public PageManager() {
	}
	
	public int getCurrentPage() {
		if(currentPage<=0){
			return 1;
		}else if (currentPage < getTotalPages()) {
			return currentPage;
		}else {
			return getTotalPages();
		}
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public int getTotalPages() {
		return (int)Math.ceil((double)totalRecords / pageRecords);
	}
	
/*	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}*/
	public int getPageRecords() {
		return pageRecords;
	}
	public void setPageRecords(int pageRecords) {
		this.pageRecords = pageRecords;
	}
	public int getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
	public int getPageStartRow() {
		return (getCurrentPage() - 1) * pageRecords;
	}
	/*public void setPageStartRow(int pageStartRow) {
		this.pageStartRow = pageStartRow;
	}*/
	/*
	public int getPageEndRow() {
		return pageEndRow;
	}
	public void setPageEndRow(int pageEndRow) {
		this.pageEndRow = pageEndRow;
	}*/
	public boolean isHasNextPage() {
		if(getCurrentPage() == getTotalPages()){
			return false;
		}else {
			return true;
		}
	}
	/*public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}*/
	public boolean isHasPreviousPage() {
		if(getCurrentPage() == 1){
			return false;
		}else{
			return true;
		}
	}
	/*public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}*/
	public List<T> getRecords() {
		return records;
	}
	public void setRecords(List<T> records) {
		this.records = records;
	}
	
	public int[] getSlider()
	{
		int pages = getTotalPages();
	    if ((pages < 1) || (sliderWidth < 1)) {
	      return new int[0];
	    }
	    if (sliderWidth > pages) {
	    	sliderWidth = pages;
	    }
	    int[] slider = new int[sliderWidth];
	    int first = getCurrentPage() - (sliderWidth - 1) / 2;
	    if (first < 1) {
	      first = 1;
	    }
	    if (first + sliderWidth - 1 > pages) {
	      first = pages - sliderWidth + 1;
	    }
	    for (int i = 0; i < sliderWidth; i++) {
	      slider[i] = (first + i);
	    }
	    return slider;
	}
	
}
