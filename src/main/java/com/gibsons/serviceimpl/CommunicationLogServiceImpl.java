package com.gibsons.serviceimpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

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

			communicationLog.setUser(userDetailsService.getUserDetails(communicationLogDTO.getUserName()));
			java.util.Date date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(communicationLogDTO.getSentTime());
			communicationLog.setSentTime(date);
			communicationLogRepository.save(communicationLog);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public CommunicationLogDTO getAllConversation(CommunicationLogDTO conversationDto) {
		List<CommunicationLog> communicationLogs = null;
		CommunicationLogDTO dto = null;
		try {

			communicationLogs = communicationLogRepository.findAllByOrderBySentTimeAsc();
			dto = convertToDto(communicationLogs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	private CommunicationLogDTO convertToDto(List<CommunicationLog> communicationLogs) {
		CommunicationLogDTO communicationLogDTO = new CommunicationLogDTO();
		final List<CommunicationLogDTO> userOneList = new ArrayList<CommunicationLogDTO>();
		final List<CommunicationLogDTO> userTwoList = new ArrayList<CommunicationLogDTO>();

		communicationLogs.forEach(new Consumer<CommunicationLog>() {
			@Override
			public void accept(CommunicationLog post) {
				CommunicationLogDTO dto = new CommunicationLogDTO();
				dto.setId(post.getId());
				dto.setMessage(post.getMessage());
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				String strDate = dateFormat.format(post.getSentTime());
				dto.setSentTime(strDate);
				dto.setUserName(post.getUser().getUserName());
				if (post.getUser().getUserName().equalsIgnoreCase("harshal")) {
					userOneList.add(dto);
				} else {
					userTwoList.add(dto);
				}
			}
		});
		communicationLogDTO.setUserListOne(userOneList);
		communicationLogDTO.setUserListTwo(userTwoList);

		return communicationLogDTO;
	}

}
