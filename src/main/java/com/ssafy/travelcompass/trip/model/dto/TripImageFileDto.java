package com.ssafy.travelcompass.trip.model.dto;

import lombok.Data;

@Data
public class TripImageFileDto {
	int tripImageFileId;
	int tripDetailId;
	String path;
}
