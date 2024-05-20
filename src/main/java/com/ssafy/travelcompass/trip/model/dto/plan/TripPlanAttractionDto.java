package com.ssafy.travelcompass.trip.model.dto.plan;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TripPlanAttractionDto {
	int contentId;
	int contentTypeId;
	String title;
	String addr1;
	String addr2;
	String zipcode;
	String tel;
	String firstImage;
	String firstImage2;
	int readCount;
	int sidoCode;
	int gugunCode;
	String latitude;
	String longitude;
	String mlevel;
	
	LocalDate tripDate;
	int activityOrder;
}
