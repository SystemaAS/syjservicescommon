package no.systema.jservices.common.mail;

import java.util.Properties;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * GMail interface 
 * 
 * @author Fredrik Möller
 * @date Sep 29, 2016
 */
public class GMail {
	private MailSender mailSender = null;

	/**
	 * Sendmail from {@link GMailProperties.MAIL_USERNAME}
	 * 
	 * @param to
	 * @param subject
	 * @param msg
	 */
	public void sendMail(String to, String subject, String msg) {
		mailSender = mailSender();
		SimpleMailMessage message = new SimpleMailMessage();

		message.setTo(to);
		message.setSubject(subject);
		message.setText(msg);
		mailSender.send(message);
	}

	
	private JavaMailSender mailSender() {
		JavaMailSenderImpl sender = new JavaMailSenderImpl();

		Properties properties = new Properties();
		properties.put("mail.smtp.auth", GMailProperties.MAIL_SMTP_AUTH);
		properties.put("mail.smtp.timeout", GMailProperties.MAIL_SMTP_TIMEOUT);
		properties.put("mail.smtp.connectiontimeout", GMailProperties.MAIL_SMTP_CONNECTIONTIMEOUT);
		properties.put("mail.smtp.starttls.enable", GMailProperties.MAIL_SMTP_STARTTLS_ENABLE);
		properties.put("mail.debug", GMailProperties.MAIL_DEBUG);

		sender.setJavaMailProperties(properties);
		sender.setHost(GMailProperties.MAIL_HOST);
		sender.setPort(GMailProperties.MAIL_PORT);
		sender.setProtocol(GMailProperties.MAIL_PROTOCOL);
		sender.setUsername(GMailProperties.MAIL_USERNAME);
		sender.setPassword(GMailProperties.MAIL_PASSWORD);

		return sender;
	}	
	
	
}
