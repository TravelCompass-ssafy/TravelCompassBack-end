package com.ssafy.travelcompass.review.model.dto.comment;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewCommentDto {
	private int reviewCommentId;
	private int tripReviewId;
	private int parentReviewCommentId;
	private int userId;
	private String content;
	private LocalDateTime createdAt;
}
