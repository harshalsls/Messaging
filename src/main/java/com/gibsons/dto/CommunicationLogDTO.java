package com.gibsons.dto;

import java.util.Date;
import java.util.List;

public class CommunicationLogDTO {

	private Long id;
	private Long userId;
	private String userName;
	private String message;
	private String userFirstName;
	private String userLastName;
	private String sentTime;
	private Date messageSentTime;
	private List<CommunicationLogDTO> userListOne;
	private List<CommunicationLogDTO> userListTwo;

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

	public List<CommunicationLogDTO> getUserListOne() {
		return userListOne;
	}

	public void setUserListOne(List<CommunicationLogDTO> userListOne) {
		this.userListOne = userListOne;
	}

	public List<CommunicationLogDTO> getUserListTwo() {
		return userListTwo;
	}

	public void setUserListTwo(List<CommunicationLogDTO> userListTwo) {
		this.userListTwo = userListTwo;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getMessageSentTime() {
		return messageSentTime;
	}

	public void setMessageSentTime(Date messageSentTime) {
		this.messageSentTime = messageSentTime;
	}

}
