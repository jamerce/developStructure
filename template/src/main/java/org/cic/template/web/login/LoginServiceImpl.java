package org.cic.template.web.login;

import org.cic.template.exception.TrsException;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements ILoginService {

	/**
	 * @see ILoginService#getUserType(String)
	 * 
	 */
	@Override
	public String getUserType(String UserId) throws TrsException{
		String userType = UserId.substring(0, 2);
		
		return userType;
		
	}
	
}
