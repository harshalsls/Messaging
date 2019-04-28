package com.gibsons.service;

import java.util.List;

import com.gibsons.dto.ConversationDto;
import com.gibsons.entity.Conversation;

public interface ConversationService {
	
	public void saveData(ConversationDto conversationDto);
	
	public ConversationDto getAllConversation(ConversationDto conversationDto);

}
