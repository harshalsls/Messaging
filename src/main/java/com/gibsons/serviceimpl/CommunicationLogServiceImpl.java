package com.gibsons.serviceimpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gibsons.dto.CommunicationLogDTO;
import com.gibsons.entity.CommunicationLog;
import com.gibsons.repository.CommunicationLogRepository;
import com.gibsons.service.CommunicationLogService;
import com.gibsons.service.UserDetailsService;

@Service("conversationService")
public class CommunicationLogServiceImpl implements CommunicationLogService {

	@Autowired
	@Qualifier("conversationRepository")
	private CommunicationLogRepository communicationLogRepository;

	@Autowired
	@Qualifier("userDetailsService")
	UserDetailsService userDetailsService;

	@Override
	public void saveData(CommunicationLogDTO communicationLogDTO) {

		try {
			CommunicationLog communicationLog = new CommunicationLog();
			communicationLog.setMessage(communicationLogDTO.getMessage());
			communicationLog.setSentTime(communicationLogDTO.getMessageSentTime());
			communicationLog.setUser(userDetailsService.getUserDetails(communicationLogDTO.getUserName()));
			communicationLogRepository.save(communicationLog);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<CommunicationLogDTO> getAllConversation(CommunicationLogDTO conversationDto) {
		List<CommunicationLog> communicationLogs = null;
		List<CommunicationLogDTO> communicationLogDTOs = new ArrayList<CommunicationLogDTO>();

		try {

			communicationLogs = communicationLogRepository.findAllByOrderBySentTimeAsc();

			for (CommunicationLog communicationLog : communicationLogs) {
				CommunicationLogDTO communicationLogDTO = new CommunicationLogDTO();
				communicationLogDTO.setMessage(communicationLog.getMessage());
				communicationLogDTO.setUserName(communicationLog.getUser().getUserName());
				communicationLogDTO.setUserFirstName(communicationLog.getUser().getFirstName());
				communicationLogDTO.setUserLastName(communicationLog.getUser().getLastName());
				communicationLogDTO.setUserId(communicationLog.getUser().getId());

				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				String strDate = dateFormat.format(communicationLog.getSentTime());
				communicationLogDTO.setSentTime(strDate);

				communicationLogDTOs.add(communicationLogDTO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return communicationLogDTOs;
	}

}
