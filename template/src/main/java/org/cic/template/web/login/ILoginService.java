/*
 * 公司內部測試用的
 */
package org.cic.template.web.login;

import org.cic.template.exception.TrsException;

public interface ILoginService {

	//MemberEntity loginService(String loginId) throws TrsException;
	
	/**
	 * 取得登入使用者之身份種類(例如SM、PM、LM)
	 * @param UserId
	 * @return	String
	 * @throws TrsException
	 */
	public String getUserType(String UserId) throws TrsException;
}
