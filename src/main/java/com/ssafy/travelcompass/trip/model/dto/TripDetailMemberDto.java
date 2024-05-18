package com.ssafy.travelcompass.trip.model.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TripDetailMemberDto {
	int tripDetailMemberId;
	int tripDetailId;
	int userId;
	boolean starCheck;
}
