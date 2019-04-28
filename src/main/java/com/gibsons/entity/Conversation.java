package com.gibsons.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "conversation")
public class Conversation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	@Column(name = "id", length =  11, nullable = false)
	private Long id;
	@Column(name = "user_name", length = 20, nullable = false)
	private String userName;
	@Column(name = "message", length = 5000, nullable = true)
	private String message;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date sentTime;
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
	public Date getSentTime() {
		return sentTime;
	}
	public void setSentTime(Date sentTime) {
		this.sentTime = sentTime;
	}
	
	
	
}
