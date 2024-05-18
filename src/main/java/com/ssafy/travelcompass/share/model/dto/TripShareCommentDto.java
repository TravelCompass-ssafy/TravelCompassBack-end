package com.ssafy.travelcompass.share.model.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TripShareCommentDto {
	int tripShareCommentId;
	int tripShareId;
	int parentTripShareCommentId;
	int userId;
	String content;
	LocalDateTime createAt;
}
