/**
 * 
 */
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


/**
 * @author ADMIN
 *
 */
@Entity
@Table(name = "user_details")
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	@Column(name = "id", length =  11, nullable = false)
	private Long id;
	@Column(name = "user_name", length = 20, nullable = false)
	private String userName;
	@Column(name = "first_name", length = 20, nullable = false)
	private String firstName;
	@Column(name = "last_name", length = 20, nullable = false)
	private String lastName;
	@Column(name = "address", length = 200, nullable = false)
	private String address;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createdOn;
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	

}
