package org.cic.template.email;

import java.util.Map;

public interface IMailService {

	/**
	 * 
	 * @param contentMap
	 */
	void sendNotificationMail(Map<String, Object> contentMap);
	
	/**
	 * 
	 * @return
	 */
	boolean send();
}
