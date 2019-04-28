package com.gibsons.serviceimpl;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gibsons.dto.ConversationDto;
import com.gibsons.entity.Conversation;
import com.gibsons.repository.ConversationRepository;
import com.gibsons.service.ConversationService;


@Service("conversationService")
public class ConversationServiceImpl  implements ConversationService{

	@Autowired
	@Qualifier("conversationRepository")
	private ConversationRepository conversationRepository;
	
	@Override
	public void saveData(ConversationDto conversationDto) {
		
		try {
			Conversation conversation = new Conversation();
			conversation.setMessage(conversationDto.getMessage());
			conversation.setUserName(conversationDto.getUserName());
			java.util.Date date=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(conversationDto.getSentTime());
			conversation.setSentTime(date);
			conversationRepository.save(conversation);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ConversationDto getAllConversation(ConversationDto conversationDto) {
		List<Conversation> conversations = null;
		ConversationDto dto = null; 
		try {
			
			conversations =	conversationRepository.findAllByOrderBySentTimeAsc();
			dto = convertToDto(conversations);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	private ConversationDto convertToDto(List<Conversation> conversations) {
		ConversationDto conversationDto = new ConversationDto();
		List<ConversationDto> userOneList = new ArrayList<>();
		List<ConversationDto> userTwoList = new ArrayList<>();
		
		conversations.forEach(post->{
			ConversationDto dto = new ConversationDto();
			dto.setId(post.getId());
			dto.setMessage(post.getMessage());
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
			String strDate = dateFormat.format(post.getSentTime());  
			dto.setSentTime(strDate);
			dto.setUserName(post.getUserName());
			if(post.getUserName().equalsIgnoreCase("harshal")){
				userOneList.add(dto);	
			}else {
				userTwoList.add(dto);
			}
		});
		conversationDto.setUserListOne(userOneList);
		conversationDto.setUserListTwo(userTwoList);
		
		return conversationDto;
	}

}
