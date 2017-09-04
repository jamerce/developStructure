/*
 * 2014/11/24:變更SMTP SERVER FROM ORAP TO ORAP1
 * modified by Jessica,refer to WF:0120141100089
 */
package org.cic.template.email;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 * 
 * @author kait
 *
 */
public class MailServiceImpl {
	
	private static Log log = LogFactory.getLog(MailServiceImpl.class);
	
	/**
	 * 寄發mail的基本參數值
	 */
	public final String MAIL_FROM = "From";
	public final String MAIL_TO = "TO";
	public final String MAIL_CC = "CC";
	public final String MAIL_SUBJECT = "MailSubject";
	public final String MAIL_BODYCONTENT = "MailBodyContent";
	public final String MAIL_TEMPLATE_LOCATE = "Mailtemplatelocate";
	
	private JavaMailSender mailSender;
	private String[] mailTo;
	private String[] mailCc;
	private String mailFrom;
	private String mailSubject;
	private String mailtemplate;

	private HashMap<String, Object> mailBodyContent;
	private VelocityEngine velocityEngine;

	public void sendNotificationMail(Map<String, Object> contentMap) {
		this.init(contentMap);
		this.send();
	}

	@SuppressWarnings("unchecked")
    private void init(Map<String, Object> contentMap) {
		
		this.mailFrom = "hylin@cic.narl.org.tw";
		
		mailTo = (String[]) contentMap.get("TO");
		if(mailTo == null){
			mailTo = new String[]{};
		}
		mailCc = (String[]) contentMap.get("CC");
		if(mailCc == null){
			mailCc = new String[]{};
		}
		if((String) contentMap.get("From") != null){
			this.mailFrom = (String) contentMap.get("From");
		}
		mailSubject = (String) contentMap.get("MailSubject");
		mailBodyContent = (HashMap<String, Object>) contentMap.get("MailBodyContent");
		mailtemplate = (String) contentMap.get("Mailtemplatelocate");
		
		log.info("===========================");
		log.info("mailFrom="+mailFrom);
		log.info("mailTo=" + (mailTo != null ?Arrays.toString(mailTo) : null));
		log.info("mailCc=" + (mailCc != null ?Arrays.toString(mailCc) : null));
		log.info("mailSubject=" + mailSubject);
		log.info("mailtemplate=" + mailtemplate);
		log.info("===========================");
	}

	/**
	 * 
	 * @return
	 */
	public boolean send() {
		Properties props = new Properties();
		String smtphost = "orap1.cic.org.tw";
		
		props.put("mail.smtp.host", smtphost);
		Session s = Session.getInstance(props, null);
		MimeMessage message = new MimeMessage(s);
		try {
			InternetAddress from = new InternetAddress(mailFrom);// 寄件者
			message.setFrom(from);
			for (int i = 0; i < mailTo.length; i++) {
				InternetAddress to = new InternetAddress(mailTo[i]);
				message.addRecipient(Message.RecipientType.TO, to); // 收件者
			}
			for (int i = 0; i < mailCc.length; i++) {
				InternetAddress cc = new InternetAddress(mailCc[i]);
				message.addRecipient(Message.RecipientType.CC, cc); // 副本收件者
			}

			String body = VelocityEngineUtils.mergeTemplateIntoString(
					velocityEngine, mailtemplate, "UTF-8",
					mailBodyContent);
			
			log.info(body);
			
			message.setSubject(MimeUtility.encodeWord(mailSubject, "UTF-8", "B"));
			message.setSentDate(new Date());
			message.setContent(body, "text/html; charset=UTF-8");
			Transport.send(message);
			
			log.info("[MailService.java]--Success to mail" );
			
			return true;
		} catch (Exception e) {
			
			log.error("[MailService.java]--<sendMail>" + e.toString());
			return false;
		}
	}
	
	/*private void send() {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage,
						true, "UTF-8");

				message.setTo(mailTo);
				
				if(mailCc != null){
					message.setCc(mailCc);
				}

				message.setFrom(mailFrom);
				message.setSubject(mailSubject);

				System.out.println("message" + message.toString());
				
				String body = VelocityEngineUtils.mergeTemplateIntoString(
						velocityEngine, mailtemplate, "UTF-8",
						mailBodyContent);

				log.info("body={}" + body);

				message.setText(body, true);
			}
		};

		mailSender.send(preparator);

		log.info("Sent e-mail to '{}'." + (mailTo != null ?Arrays.toString(mailTo) : null));
	}*/

	public String[] getMailTo() {
		return mailTo;
	}

	public void setMailTo(String[] mailTo) {
		this.mailTo = mailTo;
	}

	public String getMailFrom() {
		return mailFrom;
	}

	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}

	public String getMailSubject() {
		return mailSubject;
	}

	public void setMailSubject(String mailSubject) {
		this.mailSubject = mailSubject;
	}

	public HashMap<String, Object> getMailBodyContent() {
		return mailBodyContent;
	}

	public void setMailBodyContent(HashMap<String, Object> mailBodyContent) {
		this.mailBodyContent = mailBodyContent;
	}

	public JavaMailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public VelocityEngine getVelocityEngine() {
		return velocityEngine;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	public String getMailtemplate() {
		return mailtemplate;
	}

	public void setMailtemplate(String mailtemplate) {
		this.mailtemplate = mailtemplate;
	}
}
