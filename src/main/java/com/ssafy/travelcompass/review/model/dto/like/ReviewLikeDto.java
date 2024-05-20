package com.ssafy.travelcompass.review.model.dto.like;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewLikeDto {
	private int reviewLikeId;
	private int tripReviewId;
	private int userId;
}
