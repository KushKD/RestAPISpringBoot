package com.kushkumardhawan.rest.webservices.restfulwebservices.Exception;

import java.util.Date;

public class ExceptionResponse {
	
	//TimeStamp  --When the Exception Happened
	//MEssage    --MEssage for Exceptin
	//Details   --
	
	private Date timeStamp;
	private String messages;
	private String Details;
	
	public ExceptionResponse(Date timeStamp, String messages, String details) {
		super();
		this.timeStamp = timeStamp;
		this.messages = messages;
		Details = details;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getMessages() {
		return messages;
	}
	public void setMessages(String messages) {
		this.messages = messages;
	}
	public String getDetails() {
		return Details;
	}
	public void setDetails(String details) {
		Details = details;
	}
	@Override
	public String toString() {
		return "ExceptionResponse [timeStamp=" + timeStamp + ", messages=" + messages + ", Details=" + Details + "]";
	}
	
	
	

}
