package org.msg.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	@Autowired
    private JavaMailSender javaMailSender;
	
	public String sendMail(String to,String from,String body,String subject)
	{
		SimpleMailMessage msg= new SimpleMailMessage();
		msg.setTo(to);
		msg.setFrom(Objects.requireNonNull(from));
		msg.setSubject(subject);
		msg.setText(body);
		javaMailSender.send(msg);
		return "success";
	}
	public String sendMail(String to,String from,String body,String subject,String cc[])
	{
		SimpleMailMessage msg= new SimpleMailMessage();
		msg.setTo(to);
		msg.setFrom(Objects.requireNonNull(from));
		msg.setSubject(subject);
		msg.setText(body);
		msg.setCc(cc);
		javaMailSender.send(msg);
		return "success";
	}
}
