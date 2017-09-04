package org.cic.template.web.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class PagingVo implements Serializable{
	private List<?> dataList;
	
	private int total; // 總筆數
	
	private int number;

	private int size=10; //default 1

	private int start;

	private int end;

	private int totalPage;
	
	public PagingVo() {
	}

	public PagingVo(int size) {
		this.size = size;
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;

		if(number > 0){
			int start = (number - 1) * size;
			int end = start + size;
			this.start = start;
			this.end = end;
		}else{
			int start = number * size;
			int end = start + size;
			this.start = start;
			this.end = end;
		}
	}

	public int getSize() {
		return size;
	}

	public int getStart() {
		if(number == 0){
			start = number * size;
		}
		return start;
	}

	public int getEnd() {
		if(number == 0){
			end = size;
		}
		return end;
	}


	public List<?> getDataList() {
		return dataList;
	}


	public void setDataList(List<?> dataList) {
		this.dataList = dataList;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
		
		if(total > 0){
			int totalPage = (int)Math.floor(total/size);
			if(total % size != 0){
				totalPage ++;
			}
			this.totalPage = totalPage;
		}
		
		// if total's value > 0, set number of default value is 1 
		if(this.number == 0 && this.total > 0){
			this.number = 1;
		}

	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List getPageList(){
		List pageList = null;
		
		if(total > 0){
			/*int totalPage = (int)Math.floor(total/size);
			if(total % size != 0){
				totalPage ++;
			}*/
			pageList = new ArrayList();
			for(int i=0; i< this.totalPage; i++){
				pageList.add(i+1);
			}
		}else{
			pageList = new ArrayList();
			pageList.add(0);
		}
		return pageList;
	}


	public int getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	public void setSize(int size) {
		this.size = size;
		
		this.setNumber(this.number);
	}
	
	
}
