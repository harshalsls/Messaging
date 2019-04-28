package com.gibsons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gibsons.entity.UserDetails;

@Repository("userDetailsRepository")
public interface UserDetailsRepository extends JpaRepository<UserDetails,Long> {

	public UserDetails findByUserName(String userName);
	
}
