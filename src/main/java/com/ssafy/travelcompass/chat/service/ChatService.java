package com.ssafy.travelcompass.chat.service;

import com.ssafy.travelcompass.chat.model.dto.ChatDto;

public interface ChatService {

	void saveChat(ChatDto chat) throws Exception;

}
