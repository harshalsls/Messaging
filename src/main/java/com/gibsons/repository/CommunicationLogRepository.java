package com.gibsons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gibsons.entity.CommunicationLog;

@Repository("conversationRepository")
public interface CommunicationLogRepository extends JpaRepository<CommunicationLog, Long> {

	public List<CommunicationLog> findAllByOrderBySentTimeAsc();
}
