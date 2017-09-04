package org.cic.template.intercept;

import org.cic.template.web.login.LoginUserVo;

public interface IAuthorizationService {

	/**
	 * 取得登入者資料
	 * @param sessionId
	 * @param mId
	 * @return
	 * @throws Exception
	 */
	public LoginUserVo getLoginUser(String sessionId, String mId) throws Exception;
}
