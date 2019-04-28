package com.gibsons.dto;

import java.util.Date;
import java.util.List;


public class ConversationDto {
	
	private Long id;
	private String userName;
	private String message;
	private String sentTime;
	private List<ConversationDto> userListOne;
	private List<ConversationDto> userListTwo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSentTime() {
		return sentTime;
	}
	public void setSentTime(String sentTime) {
		this.sentTime = sentTime;
	}
	public List<ConversationDto> getUserListOne() {
		return userListOne;
	}
	public void setUserListOne(List<ConversationDto> userListOne) {
		this.userListOne = userListOne;
	}
	public List<ConversationDto> getUserListTwo() {
		return userListTwo;
	}
	public void setUserListTwo(List<ConversationDto> userListTwo) {
		this.userListTwo = userListTwo;
	}
	
	

}
