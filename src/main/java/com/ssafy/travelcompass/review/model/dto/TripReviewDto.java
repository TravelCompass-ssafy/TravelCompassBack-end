package com.ssafy.travelcompass.review.model.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class TripReviewDto {
	int tripReviewId;
	int userId;
	int contentId;
	int tripDetailId;
	String content;
	int star;
	LocalDateTime createdAt;
	List<ReviewCommentDto> reviewCommentList;
	List<ReviewImageFileDto> reviewImageFileList;
	List<ReviewLikeDto> reviewLikeList;
	List<ReviewTagDto> reviewTagList;
}
