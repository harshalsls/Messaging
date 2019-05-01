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

import com.gibsons.dto.CommunicationLogDTO;
import com.gibsons.service.CommunicationLogService;

@RestController
@RequestMapping("api/communicationlog")
public class CommunicationLogController {

	@Autowired
	@Qualifier("conversationService")
	private CommunicationLogService communicationLogService;

	@PostMapping("/savemessage")
	public ResponseEntity<?> userInfo(@RequestBody CommunicationLogDTO communicationLogDTO) {
		communicationLogService.saveData(communicationLogDTO);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@PostMapping("/getcommunicationlog")
	public List<CommunicationLogDTO> getConversation(@RequestBody CommunicationLogDTO communicationLogDTO) {
		return communicationLogService.getAllConversation(communicationLogDTO);
	}
}
