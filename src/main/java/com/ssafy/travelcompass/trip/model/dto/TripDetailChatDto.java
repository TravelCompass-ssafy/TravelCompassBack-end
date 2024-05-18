package com.ssafy.travelcompass.trip.model.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TripDetailChatDto {
	int tripDetailChatId;
	int tripDetailId;
	int userId;
	String message;
	LocalDateTime createAt;
}
