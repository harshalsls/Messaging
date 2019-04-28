package com.gibsons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gibsons.dto.UserDetailsDto;
import com.gibsons.service.UserDetailsService;

@RestController("api/userdetails")
public class UserDetailsController {
	
	@Autowired
	@Qualifier("userDetailsService")
	private UserDetailsService userDetailsService;
	
	
	@GetMapping("/userinfo")
	public ResponseEntity<UserDetailsDto> userInfo(@RequestBody UserDetailsDto userDetailsDto) {
		userDetailsDto = userDetailsService.userInfo(userDetailsDto.getUserName());
		return new ResponseEntity<>(HttpStatus.OK);
    }
	

}
