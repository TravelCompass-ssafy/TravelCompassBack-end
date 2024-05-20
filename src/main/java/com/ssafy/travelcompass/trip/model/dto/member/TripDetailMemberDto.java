package com.ssafy.travelcompass.trip.model.dto.member;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TripDetailMemberDto {
	int tripDetailMemberId;
	int tripDetailId;
	int userId;
	boolean starCheck;
}
