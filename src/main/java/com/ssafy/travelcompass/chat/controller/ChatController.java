package com.ssafy.travelcompass.chat.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.travelcompass.chat.model.dto.ChatDto;
import com.ssafy.travelcompass.chat.service.ChatService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chat")
public class ChatController {
	
	private final ChatService chatService;

	@GetMapping("/{tripDetailId}")
	public List<ChatDto> getChats(@PathVariable Long tripDetailId,
									@RequestParam("page") int page,
									@RequestParam("size") int size) throws Exception {
		int offset = page * size;
		return chatService.getChatsByTripDetailId(tripDetailId, offset, size);
	}
}
