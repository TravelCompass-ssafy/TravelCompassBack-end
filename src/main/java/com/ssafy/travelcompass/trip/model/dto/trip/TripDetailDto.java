package com.ssafy.travelcompass.trip.model.dto.trip;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.ssafy.travelcompass.attraction.model.dto.AttractionInfoDto;
import com.ssafy.travelcompass.trip.model.dto.member.TripDetailMemberDto;
import com.ssafy.travelcompass.trip.model.dto.plan.TripPlanAttractionDto;

import lombok.Data;

@Data
public class TripDetailDto {
	int tripDetailId;
	int userId;

	String imagePath;
	String sidoName;
	String title;
	LocalDate startDate;
	LocalDate endDate;
	String nickname;
	int maxCapacity;
	int view;
	LocalDateTime createdAt;
	int createTime;

	String content;
	int sidoCode;

	List<TripDetailMemberDto> memberList;
	List<List<TripPlanAttractionDto>> tripPlanAttractionList;
}
