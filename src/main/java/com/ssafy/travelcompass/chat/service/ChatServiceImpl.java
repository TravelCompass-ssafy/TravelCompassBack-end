package com.ssafy.travelcompass.chat.service;

import org.springframework.stereotype.Service;

import com.ssafy.travelcompass.chat.model.dto.ChatDto;
import com.ssafy.travelcompass.chat.model.mapper.ChatMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {
	
	private final ChatMapper chatMapper;
	
	@Override
	public void saveChat(ChatDto chat) throws Exception {
		chatMapper.saveChat(chat);
	}

}
