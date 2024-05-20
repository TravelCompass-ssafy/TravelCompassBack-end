package com.ssafy.travelcompass.review.model.dto.tag;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewTagDto {
	int reviewTagId;
	int tripReviewId;
	String tag;
}
