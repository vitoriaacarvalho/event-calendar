package com.vits.EventCalendar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmailNotificationService {
	@Autowired
	private JavaMailSender mailSender;

	public void sendEmail(List<String> toEmail, String subject, String body) {
		for (String receiver : toEmail) {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(receiver);
			message.setSubject(subject);
			message.setText(body);
			mailSender.send(message);
		}
	}

}
