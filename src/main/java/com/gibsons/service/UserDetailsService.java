package com.gibsons.service;

import com.gibsons.dto.UserDetailsDto;
import com.gibsons.entity.UserDetails;

public interface UserDetailsService {

	public UserDetailsDto userInfo(String userName);

	UserDetails getUserDetails(String userName);

}
