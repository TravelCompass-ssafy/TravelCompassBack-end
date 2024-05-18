package com.ssafy.travelcompass.trip.model.dto;

import lombok.Data;

@Data
public class TripActivityDto {
	int tripActivityId;
	int tripPlanId;
	int contentId;
	int activityOrder;
}
