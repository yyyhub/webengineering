package cn.yyy.pojo;

import java.util.ArrayList;
import java.util.List;

public class PageBean<T> {
	private int pageIndex = 1;
	private int totalPages = 1;
	private int pageSize = 4;
	private int totalRecords = 0;
	private boolean isHavePrePage = false;
	private boolean isHaveNextPage = false;
	
	private List<T> pageDatas = new ArrayList<T>();

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		if (totalRecords < 0)
			throw new RuntimeException();
		this.totalRecords = totalRecords;
		
		this.totalPages = this.totalRecords/this.pageSize;
		if (this.totalRecords%this.pageSize!=0)
			this.totalPages++;
		if (this.pageIndex > 1)
			this.isHavePrePage = true;
		else
			this.isHavePrePage = false;
		if (this.pageIndex < this.totalPages)
			this.isHaveNextPage = true;
		else
			this.isHaveNextPage = false;
	}

	public boolean isHavePrePage() {
		return isHavePrePage;
	}

	public void setHavePrePage(boolean isHavePrePage) {
		this.isHavePrePage = isHavePrePage;
	}

	public boolean isHaveNextPage() {
		return isHaveNextPage;
	}

	public void setHaveNextPage(boolean isHaveNextPage) {
		this.isHaveNextPage = isHaveNextPage;
	}

	public List<T> getPageDatas() {
		return pageDatas;
	}

	public void setPageDatas(List<T> pageDatas) {
		this.pageDatas = pageDatas;
	}
	
	
}
