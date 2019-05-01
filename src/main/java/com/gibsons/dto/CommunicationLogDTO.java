package com.gibsons.dto;

import java.util.List;

public class CommunicationLogDTO {

	private Long id;
	private String userName;
	private String message;
	private String sentTime;
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

}
