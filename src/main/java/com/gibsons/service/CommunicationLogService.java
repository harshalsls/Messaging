package com.gibsons.service;

import com.gibsons.dto.CommunicationLogDTO;

public interface CommunicationLogService {

	public void saveData(CommunicationLogDTO communicationLogDTO);

	public CommunicationLogDTO getAllConversation(CommunicationLogDTO communicationLogDTO);

}
