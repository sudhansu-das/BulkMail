package org.msg.controllers;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApacheMailController {

	@GetMapping("sendTextmail")
	public String sendMail() throws EmailException
	{
			  
		  Email email = new SimpleEmail();
		  email.setHostName("smtp.googlemail.com");
		  email.setSmtpPort(465);
		  email.setAuthenticator(new DefaultAuthenticator("sudhakardash07@gmail.com","Sudha@1980"));
		  email.setSSLOnConnect(true);
		  email.setFrom("sudhakardash07@gmail.com");
		  email.setSubject("TestMail");
		  email.setMsg("This is a test mail ... :-)");
		  email.addTo("dash_sudhansu08@yahoo.com");
		  email.send();
		return "success";
	}
	
	@GetMapping("sendAttachment")
	public String sendMailHtmlFormatted() throws EmailException, MalformedURLException
	{
	 String htmlEmailTemplate = "<img src=\"http://www.apache.org/images/feather.gif\">";

	  // define you base URL to resolve relative resource locations
	  URL url = new URL("http://www.apache.org");

	  // create the email message
	  ImageHtmlEmail email = new ImageHtmlEmail();
	  email.setDataSourceResolver(new DataSourceUrlResolver(url));
	  email.setHostName("smtp.googlemail.com");
	  email.setSmtpPort(465);
	  email.setAuthenticator(new DefaultAuthenticator("sudhakardash07@gmail.com","Sudha@1980"));
	  email.setSSLOnConnect(true);
	  email.addTo("dash_sudhansu08@yahoo.com", "dashssd@gmail.com");
	  email.setFrom("sudhakardash07@gmail.com");
	  email.setSubject("Test email with inline image");	  
	  // set the html message
	  email.setHtmlMsg(htmlEmailTemplate);
	  // set the alternative message
	  email.setTextMsg("Your email client does not support HTML messages");
	   email.send();
	   return "success";
	}
}
