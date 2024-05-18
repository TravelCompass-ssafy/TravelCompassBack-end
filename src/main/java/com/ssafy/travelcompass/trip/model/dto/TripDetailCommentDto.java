package com.ssafy.travelcompass.trip.model.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TripDetailCommentDto {
	int tripDetailCommentId;
	int tripDetailId;
	int parentId;
	int userId;
	String content;
	LocalDateTime createAt;
}
