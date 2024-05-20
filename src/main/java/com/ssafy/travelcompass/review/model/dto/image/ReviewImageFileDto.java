package com.ssafy.travelcompass.review.model.dto.image;

import lombok.Data;

@Data
public class ReviewImageFileDto {
	int reviewImageFileId;
	int tripReviewId;
	String path;
}
