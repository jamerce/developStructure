/*
 * 
 */
package org.cic.template.web.onlineapply;

/**
 * 
 * @author kait
 *
 */
public class LogDetailVo {
	
	private Long id;
	private String nvno; //報名主鍵
	private String msg;
	
	public String getNvno() {
		return nvno;
	}
	public void setNvno(String nvno) {
		this.nvno = nvno;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
