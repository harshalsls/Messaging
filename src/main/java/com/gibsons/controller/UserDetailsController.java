package com.gibsons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gibsons.dto.UserDetailsDto;
import com.gibsons.service.UserDetailsService;

@RestController
@RequestMapping("/api/userdetails")
public class UserDetailsController {
	
	
	@Autowired
	@Qualifier("userDetailsService")
	private UserDetailsService userDetailsService;
	
	
	@PostMapping("/userinfo")
	public UserDetailsDto userInfo(@RequestBody UserDetailsDto userDetailsDto) {
		userDetailsDto = userDetailsService.userInfo(userDetailsDto.getUserName());
		return userDetailsDto;
    }
	

}
