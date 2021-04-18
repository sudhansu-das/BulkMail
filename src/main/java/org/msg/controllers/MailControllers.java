package org.msg.controllers;

import java.io.IOException;
import java.util.Map;

import org.msg.service.MailService;
import org.msg.util.ReadFileCsv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bulkmessegeing")
public class MailControllers 
{

	@Autowired
	private MailService mailService;
	
	@Autowired
	private ReadFileCsv file;
	@GetMapping("sendmail")
	public ResponseEntity<String> sendEmail() throws IOException
	{
	Map<String,String> con=	file.getAllMailList();
	
	con.forEach((x,y)->mailService.sendMail(x, "sudhakardash07@gmail.com", y, "my Mail for testing"));
		
		
		return ResponseEntity.ok("success");
		
	}
}
