package com.gibsons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gibsons.entity.Conversation;

@Repository("conversationRepository")
public interface ConversationRepository extends JpaRepository<Conversation, Long> {

	public List<Conversation> findAllByOrderBySentTimeAsc();
}
