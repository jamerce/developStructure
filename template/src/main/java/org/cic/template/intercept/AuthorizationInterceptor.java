package org.cic.template.intercept;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.cic.template.utils.ConstantValue;
import org.cic.template.web.login.LoginUserVo;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * 
 * Authorization Interceptor-驗証是否有登入用的攔截器
 * @author kait
 *
 */
public class AuthorizationInterceptor extends AbstractInterceptor {
	
	private static final Logger log = Logger.getLogger(AuthorizationInterceptor.class);
	
	private static final long serialVersionUID = 1L;
	
	private IAuthorizationService authorizationService;

	private final String NO_LOGIN = "noLogin";
	private final String NO_PERMISSION = "noPermission";
	
	/**
	 * @param actionInvocation
	 * @return String
	 * @throws Exception
	 */
	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		log.debug("intercept start");
		
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
		
		LoginUserVo loginVo = (LoginUserVo) session.get(ConstantValue.SESSION_MEMBER);
		
		if(null != loginVo){ //已登入

			if(this.checkFunctionPermission(loginVo)){
				return actionInvocation.invoke();
				
			} else {
				actionInvocation.getInvocationContext().getValueStack().set("statusResult", NO_PERMISSION);
				return "handle";
			}
			
		} else { //未登入處理
			
			String requestUrl = request.getRequestURL().toString();
			log.debug("==>requestUrl:" + requestUrl);

			request.setAttribute(ConstantValue.REDIRECTED_URL, requestUrl);
			actionInvocation.getInvocationContext().getValueStack().set("statusResult", NO_LOGIN);
			return "handle";
		}
	}

	/**
	 * check登入者的功能權限
	 * @param loginVo
	 * @return
	 */
	private boolean checkFunctionPermission(LoginUserVo loginVo){
		boolean isCheck = true;

		//報名系統系統，一定是PM的角色才可以使用
		/*if(!loginVo.getUserType().equals("PM") ){
			isCheck = false;
		} else if(loginVo.getUserType().equals("PM") && !loginVo.getCheckConfirm().equals("Y")){
			isCheck = false;
		}*/
		
		return isCheck;
	}
	
	public IAuthorizationService getAuthorizationService() {
		return authorizationService;
	}

	public void setAuthorizationService(IAuthorizationService authorizationService) {
		this.authorizationService = authorizationService;
	}

}
