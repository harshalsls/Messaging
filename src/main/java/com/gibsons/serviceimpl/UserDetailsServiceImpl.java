package com.gibsons.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gibsons.dto.UserDetailsDto;
import com.gibsons.entity.UserDetails;
import com.gibsons.repository.UserDetailsRepository;
import com.gibsons.service.UserDetailsService;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{

	
	@Autowired
	@Qualifier("userDetailsRepository")
	private UserDetailsRepository userDetailsRepository;
	
	@Override
	public UserDetailsDto userInfo(String userName) {
		
		UserDetails userDetails = null;
		
		UserDetailsDto userDetailsDto = new UserDetailsDto();
		try {
			userDetails =	userDetailsRepository.findByUserName(userName);
			
			userDetailsDto.setId(userDetails.getId());
			userDetailsDto.setAddress(userDetails.getAddress());
			userDetailsDto.setFirstName(userDetails.getFirstName());
			userDetailsDto.setLastName(userDetails.getLastName());
			userDetailsDto.setUserName(userDetails.getUserName());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userDetailsDto;
	}

}
