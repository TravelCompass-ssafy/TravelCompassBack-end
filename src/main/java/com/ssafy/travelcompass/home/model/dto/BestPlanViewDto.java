package com.ssafy.travelcompass.home.model.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BestPlanViewDto {
	private int tripDetailId;
	private String imagePath;
	private String sidoName;
	private String title;
	private LocalDate startDate;
	private LocalDate endDate;
	private String nickname;
	private int maxCapacity;
	private int view;
	private LocalDate createdAt;
	private int createdTime;
}
