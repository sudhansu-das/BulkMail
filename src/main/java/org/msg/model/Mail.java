package org.msg.model;

import java.io.Serializable;

public class Mail implements Serializable 
{
/**
	* Mail Service Implementation
 */
	private static final long serialVersionUID = 1L;
private String to;
private String from;
private String body;
private String cc[];
private String subject;

public Mail()
{
	
}
public Mail(String to, String from, String body, String[] cc, String subject) {
	super();
	this.to = to;
	this.from = from;
	this.body = body;
	this.cc = cc;
	this.subject = subject;
}



public String getTo() {
	return to;
}

public void setTo(String to) {
	this.to = to;
}

public String getFrom() {
	return from;
}

public void setFrom(String from) {
	this.from = from;
}

public String getBody() {
	return body;
}

public void setBody(String body) {
	this.body = body;
}
public String[] getCc() {
	return cc;
}
public void setCc(String[] cc) {
	this.cc = cc;
}
public String getSubject() {
	return subject;
}

public void setSubject(String subject) {
	this.subject = subject;
}

@Override
public String toString() {
	return "Mail [to=" + to + ", from=" + from + ", body=" + body + ", cc=" + cc + ", subject=" + subject + "]";
}
}
