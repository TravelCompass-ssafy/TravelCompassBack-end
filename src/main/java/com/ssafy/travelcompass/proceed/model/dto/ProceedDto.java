package com.ssafy.travelcompass.proceed.model.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ProceedDto {
	int tripDetailId;
	int userId;
	
	String imagePath;
	String sidoName;
	String title;
	LocalDate startDate;
	LocalDate endDate;
	String nickname;
}
