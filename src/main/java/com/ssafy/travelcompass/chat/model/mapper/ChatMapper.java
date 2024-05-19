package com.ssafy.travelcompass.chat.model.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.travelcompass.chat.model.dto.ChatDto;

@Mapper
public interface ChatMapper {

	void saveChat(ChatDto chat) throws SQLException;

}
