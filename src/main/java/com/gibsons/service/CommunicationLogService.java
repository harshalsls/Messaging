package com.gibsons.service;

import java.util.List;

import com.gibsons.dto.CommunicationLogDTO;

public interface CommunicationLogService {

	public void saveData(CommunicationLogDTO communicationLogDTO);

	public List<CommunicationLogDTO> getAllConversation(CommunicationLogDTO communicationLogDTO);

}
