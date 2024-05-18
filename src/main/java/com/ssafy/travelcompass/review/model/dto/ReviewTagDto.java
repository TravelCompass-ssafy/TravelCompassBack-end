package com.ssafy.travelcompass.review.model.dto;

import lombok.Data;

@Data
public class ReviewTagDto {
	int reviewTagId;
	int tripReviewId;
	String tag;
}
