package com.ssafy.travelcompass.chat.service;

import java.util.List;

import com.ssafy.travelcompass.chat.model.dto.ChatDto;

public interface ChatService {

	void saveChat(ChatDto chat) throws Exception;

	List<ChatDto> getChatsByTripDetailId(Long tripDetailId, int offset, int size) throws Exception;
	int countChatsByTripDetailId(Long tripDetailId) throws Exception;

}
