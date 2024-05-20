package com.ssafy.travelcompass.review.model.dto.comment;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ReviewCommentDto {
	int reviewCommentId;
	int tripReviewId;
	int parentReviewCommentId;
	int userId;
	String content;
	LocalDateTime createdAt;
}
