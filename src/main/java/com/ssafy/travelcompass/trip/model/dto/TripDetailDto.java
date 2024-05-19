package com.ssafy.travelcompass.trip.model.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.ssafy.travelcompass.attraction.model.dto.AttractionInfoDto;

import lombok.Data;

@Data
public class TripDetailDto {
	int tripDetailId;
	int userId;
	String userNickname;
	String title;
	String content;
	LocalDate startDate;
	LocalDate endDate;
	int maxCapacity;
	int view;
	LocalDateTime createdAt;
	int sidoCode;
	List<String> imageFileList;
	List<AttractionInfoDto> attractionInfoList;
	List<TripDetailCommentDto> tripDetailCommentList;
}
