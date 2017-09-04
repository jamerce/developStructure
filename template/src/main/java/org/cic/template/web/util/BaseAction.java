package org.cic.template.web.util;

import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.cic.template.utils.ConstantValue;
import org.cic.template.web.login.LoginUserVo;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 程式所屬主要目錄代碼
	 */
	public String mainCatalogId;
	/**
	 * 程式所屬主要目錄名稱
	 */
	public String mainCatalogName;
	
	/**
	 * programId - 程式代碼
	 */
	public String programId;
	/**
	 * programName - 程式中文名稱
	 */
	public String programName;
	
	/**
	 * 分頁物件
	 */
	private PagingVo pagingVo = new PagingVo();
	
	/**
	 * 下載檔案物件
	 */
	public InputStream dwFileInputStream;
	/**
	 * 下載檔案名稱
	 */
	public String dwFileName;
	
	/**
	 * 回傳的json map
	 */
	public Map<String , String> jsonResultMap; 
	
	public BaseAction() {
	}
	
	protected HttpSession getSession(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		return session;
	}
	
	/**
	 * 取得登入者資料
	 * @return
	 */
	public LoginUserVo getLoginUserVo(){
		return (LoginUserVo)this.getSession().getAttribute(ConstantValue.SESSION_MEMBER);
	}
	
	public void addActionError(String anErrorMessage) {		
		super.addActionError(this.filterExtraMsg(anErrorMessage));
    }
	
	private String filterExtraMsg(String msg){
		String returnMsg = msg.replaceAll("java.lang.Exception:", "");
		return returnMsg;
	}

	public PagingVo getPagingVo() {
		return pagingVo;
	}

	public void setPagingVo(PagingVo pagingVo) {
		this.pagingVo = pagingVo;
	}

	public InputStream getDwFileInputStream() {
		return dwFileInputStream;
	}

	public void setDwFileInputStream(InputStream dwFileInputStream) {
		this.dwFileInputStream = dwFileInputStream;
	}

	public String getDwFileName() {
		return dwFileName;
	}

	public void setDwFileName(String dwFileName) {
		this.dwFileName = dwFileName;
	}

	public Map<String, String> getJsonResultMap() {
		return jsonResultMap;
	}

	public void setJsonResultMap(Map<String, String> jsonResultMap) {
		this.jsonResultMap = jsonResultMap;
	}

	public String getProgramId() {
		return programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getMainCatalogId() {
    	return mainCatalogId;
    }

	public void setMainCatalogId(String mainCatalogId) {
    	this.mainCatalogId = mainCatalogId;
    }

	public String getMainCatalogName() {
    	return mainCatalogName;
    }

	public void setMainCatalogName(String mainCatalogName) {
    	this.mainCatalogName = mainCatalogName;
    }

}
