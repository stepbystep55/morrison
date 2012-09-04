package com.ippoippo.morrison.aop;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ResourceBundle;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Aspect
public class ExceptionLogger {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	//private static ResourceBundle trackingBundle = ResourceBundle.getBundle("tracking");

	/**
	 * コントローラー用エラーログを出力します。
	 * @param joinPoint
	 * @param e
	 * @throws Throwable
	 */
	@AfterThrowing(pointcut="execution(public * com.ippoippo.morrison.controller..*(..))", throwing = "e")
	public void contollerLogging(JoinPoint joinPoint, Throwable e) throws Throwable {
		logging(joinPoint, e);
	}
	
	/**
	 * JOB用エラーログを出力します。
	 * @param joinPoint
	 * @param e
	 * @throws Throwable
	 */
	@AfterThrowing(pointcut="execution(public * com.ippoippo.morrison.job..*(..))", throwing = "e")
	public void jobLogging(JoinPoint joinPoint, Throwable e) throws Throwable {
		logging(joinPoint, e);
	}

	private void logging(JoinPoint joinPoint, Throwable e) throws Throwable {
		logger.error(e.toString(), e);
		//sendAlertMail(e);
		throw e;
	}
	
/*
	private void sendAlertMail(Throwable e) {
		try {
			String[] mailToList = trackingBundle.getString("alert_mail_to").split(",");
			
			SimpleMailMessage mail = new SimpleMailMessage();
			mail.setTo(mailToList);
			mail.setSubject(trackingBundle.getString("alert_mail_subject"));
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String text = sw.toString();
			pw.close();
			sw.close();
			mail.setText(text);
			mail.setFrom(trackingBundle.getString("alert_mail_from"));
			mail.setReplyTo(trackingBundle.getString("alert_mail_reply_to"));
			
			JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
			mailSender.setHost(trackingBundle.getString("mail_host"));
			mailSender.send(mail);
		
		} catch(Exception eInSendAlertMail) {
			logger.error("AlertMailException" , eInSendAlertMail);
		}
	}
	*/
}
