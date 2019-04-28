package com.gibsons.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gibsons.dto.ConversationDto;
import com.gibsons.dto.UserDetailsDto;
import com.gibsons.entity.Conversation;
import com.gibsons.service.ConversationService;

@RestController
@RequestMapping("api/conversation")
public class ConversationController {

	@Autowired
	@Qualifier("conversationService")
	private ConversationService conversationService;
	
	@PostMapping("/savemessage")
	public ResponseEntity<?> userInfo(@RequestBody ConversationDto conversationDto) {
		conversationService.saveData(conversationDto);
		return new ResponseEntity<>(HttpStatus.OK);
    }
	
	
	@PostMapping("/getconversation")
	public ConversationDto getConversation(@RequestBody ConversationDto conversationDto) {
		return conversationService.getAllConversation(conversationDto);
    }
}
