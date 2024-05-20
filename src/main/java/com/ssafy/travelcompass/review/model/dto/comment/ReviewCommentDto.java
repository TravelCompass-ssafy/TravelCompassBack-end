package com.ssafy.travelcompass.review.model.dto.comment;

import java.time.LocalDateTime;
import java.util.List;

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
	private int userId; // 작성자 userId
	private String content;
	private LocalDateTime createdAt;
	
	private String userName; // 작성자 이름
	private String profile; // 프로필 이미지 경로
	
	private List<ReviewCommentDto> replies;
	private int replyCnt;
	
}
