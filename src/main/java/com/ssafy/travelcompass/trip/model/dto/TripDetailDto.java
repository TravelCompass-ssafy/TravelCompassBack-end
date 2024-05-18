package com.ssafy.travelcompass.trip.model.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TripDetailDto {
	int tripDetailId;
	int userId;
	String title;
	String content;
	LocalDate startDate;
	LocalDate endDate;
	int maxCapacity;
	int view;
	LocalDateTime createdAt;
	int sidoCode;
}
