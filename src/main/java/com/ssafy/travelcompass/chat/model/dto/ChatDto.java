package com.ssafy.travelcompass.chat.model.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatDto {

	private int tripDetailChatId;
	private int tripDetailId;
	private int userId;
	private String message;
	private LocalDateTime createdAt;
	private String nickName;
	private String profile;
}
