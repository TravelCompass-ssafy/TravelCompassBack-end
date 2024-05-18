package com.ssafy.travelcompass.review.model.dto;

import lombok.Data;

@Data
public class ReviewImageFileDto {
	int reviewImageFileId;
	int tripReviewId;
	String path;
}
