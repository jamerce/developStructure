package org.cic.template.persistent.mybatis;

/**
 * 分頁物件
 * @author kait
 *
 */
public class PageModel {

	private Integer startNum; 
	private Integer endNum;
	private Integer offset;
	private Integer fetech;
	
	public Integer getStartNum() {
		return startNum;
	}
	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}
	public Integer getEndNum() {
		return endNum;
	}
	public void setEndNum(Integer endNum) {
		this.endNum = endNum;
	}
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getFetech() {
		return fetech;
	}
	public void setFetech(Integer fetech) {
		this.fetech = fetech;
	}
	
	
}
