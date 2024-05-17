package com.ssafy.travelcompass.attraction.model.dto;

import lombok.Data;

@Data
public class AttractionInfoDto {
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
}
