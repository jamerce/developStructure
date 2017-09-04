package org.cic.template.web.login;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.cic.template.utils.ConstantValue;
import org.cic.template.web.util.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author kait
 *
 */
public class LoginAction extends BaseAction  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(LoginAction.class);
	
	private String loginId;
	private String result;
	
	private String isLogout;
	
	@Autowired
	private ILoginService loginService;
	
	public String doLogin()throws Exception{
		
		LoginUserVo loginVo = this.simuLogin();
		
		try{
			/*MemberEntity memberEntity = loginService.loginService(loginId);
			if(memberEntity != null){

				loginVo = new LoginUserVo();
				
				loginVo.setMemberId(memberEntity.getmId());
				loginVo.setMemberName((String)memberEntity.getmCname());
				loginVo.setEmail((String)memberEntity.getmEmail());
				loginVo.setConTel((String)memberEntity.getmContel());
				loginVo.setConMobile((String)memberEntity.getmMob());
				loginVo.setAddress((String)memberEntity.getmAddr());
				loginVo.setFaxNo((String)memberEntity.getmFax());
				loginVo.setAssignteacher(memberEntity.getmAssignteacher());
				loginVo.setCompany((String)memberEntity.getmCompany()); //公司名稱
				loginVo.setCompanyDeptName((String)memberEntity.getmDepartment()); // 部門
				loginVo.setSchoolId(memberEntity.getmSid() == null? "": memberEntity.getmSid().trim());
				String schoolName = memberEntity.getSchool() == null? "": memberEntity.getSchool().getsName();
				loginVo.setSchoolName(schoolName); //學校名稱
				loginVo.setDeptId(memberEntity.getmDid() == null? "": memberEntity.getmDid().trim());
				String deptName = memberEntity.getDepartment() == null? "": memberEntity.getDepartment().getdName();
				loginVo.setDeptName(deptName); //系所名稱
				loginVo.setCheckNo((String)memberEntity.getmCheckno()); //公司統編
				loginVo.setCheckTitle((String)memberEntity.getmChecktitle()); //發票抬頭
				String unino = memberEntity.getSchool() == null? "": (String)memberEntity.getSchool().getsUnino(); //統編
				loginVo.setUserUnino(unino);
				loginVo.setUserType(memberEntity.getmId().substring(0, 2));
				loginVo.setCheckConfirm(memberEntity.getmConfirm());
				
				HttpServletRequest request = ServletActionContext.getRequest();
				HttpSession session = request.getSession();
				
				session.setAttribute(ConstantValue.SESSION_MEMBER, loginVo);
				
				result = "loginSuccess";
			} else {
				result = "loginFail";
			}
			
			*/
			List<TreeMap<String, Object>> menuList = this.compbineMenu();
			
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			
			session.setAttribute(ConstantValue.SESSION_MEMBER, loginVo);
			session.setAttribute(ConstantValue.MENU, menuList);
			
			this.jsonResultMap = new HashMap<String, String>();
			this.jsonResultMap.put("isSuccess", "Y");
			
		} catch(Exception e){
			log.error(e);
			
			this.jsonResultMap = new HashMap<String, String>();
			this.jsonResultMap.put("isSuccess", "N");
			this.jsonResultMap.put("msg", e.toString());
			
		} finally{
			
		}
		
		return SUCCESS;
	}
	
	private List<TreeMap<String, Object>> compbineMenu(){
		
		List<Map<String, String>> subNodeList = new ArrayList<Map<String, String>>();
		
		Map<String, String> subNodeInfo = new HashMap<String, String>();
		subNodeInfo.put("nodeName", "線上報名");
		subNodeInfo.put("url", "/onlineapply/init.action");
		subNodeList.add(subNodeInfo);
		
		subNodeInfo = new HashMap<String, String>();
		subNodeInfo.put("nodeName", "線上報名2");
		subNodeInfo.put("url", "/onlineapply/init2.action");
		subNodeList.add(subNodeInfo);
		
		TreeMap<String, Object> mainNodeInfo = new TreeMap<String, Object>();
		mainNodeInfo.put("nodeName", "線上報名功能");
		mainNodeInfo.put("subNodeList", subNodeList);
		
		List<TreeMap<String, Object>> menuList = new ArrayList<TreeMap<String, Object>> ();
		menuList.add(mainNodeInfo);
		
		return menuList;
	}
	
	/**
	 * 
	 * @return
	 */
	private LoginUserVo simuLogin(){
		
		LoginUserVo loginVo = new LoginUserVo();
		
		loginVo.setMemberId("ADMIN");
		loginVo.setMemberName("管理者");
		loginVo.setCompanyDeptName("資訊室");
		loginVo.setEmail("ADMIN@GMAIL.COM");
		loginVo.setConTel("04222222");
		loginVo.setMobile("0910090636");
		
		return loginVo;
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doLogout() throws Exception{
		
		try{
			@SuppressWarnings("rawtypes")
			Enumeration enumer = this.getSession().getAttributeNames();
			while(enumer.hasMoreElements()){
				String attrname = (String)enumer.nextElement();
				
				this.getSession().removeAttribute(attrname);
			}
			
		} catch(Exception e){
			log.error(e);
		}
		
		return SUCCESS;
	}

	public String ajaxLogout() throws Exception{
		
		try{
			@SuppressWarnings("rawtypes")
			Enumeration enumer = this.getSession().getAttributeNames();
			while(enumer.hasMoreElements()){
				String attrname = (String)enumer.nextElement();
				
				this.getSession().removeAttribute(attrname);
			}
			isLogout = "Y";
			
		} catch(Exception e){
			log.error(e);
			isLogout = "N";
		}
		
		return SUCCESS;
	}

	public String getLoginId() {
		return loginId;
	}


	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}


	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}


	public ILoginService getLoginService() {
		return loginService;
	}


	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}

	public String getIsLogout() {
		return isLogout;
	}

	public void setIsLogout(String isLogout) {
		this.isLogout = isLogout;
	}

	
	
}