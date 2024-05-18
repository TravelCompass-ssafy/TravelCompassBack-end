package com.ssafy.travelcompass.trip.model.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TripPlanDto {
	int tripPlanId;
	int tripDetailId;
	LocalDate tripDate;
}
