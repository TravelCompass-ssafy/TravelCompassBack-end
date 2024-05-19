package com.ssafy.travelcompass.chat.service;

import java.util.List;

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

	@Override
	public List<ChatDto> getChatsByTripDetailId(Long tripDetailId, int offset, int size) throws Exception{
        return chatMapper.getChatsByTripDetailId(tripDetailId, offset, size);
	}

	@Override
	public int countChatsByTripDetailId(Long tripDetailId) throws Exception {
        return chatMapper.countChatsByTripDetailId(tripDetailId);

	}

}
