package com.ssafy.travelcompass.trip.model.dto.member;


import lombok.Data;

@Data
public class TripDetailMemberDto {
	int tripDetailMemberId;
	int tripDetailId;
	int userId;
	boolean starCheck;
	String nickName;
	String title; // 여행 이름
}
