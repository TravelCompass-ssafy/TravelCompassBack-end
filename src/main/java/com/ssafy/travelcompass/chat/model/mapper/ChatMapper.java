package com.ssafy.travelcompass.chat.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.travelcompass.chat.model.dto.ChatDto;

@Mapper
public interface ChatMapper {

	
	void saveChat(ChatDto chat) throws SQLException;

	List<ChatDto> getChatsByTripDetailId(Long tripDetailId, int offset, int size) throws SQLException;

	int countChatsByTripDetailId(Long tripDetailId) throws SQLException;

}
