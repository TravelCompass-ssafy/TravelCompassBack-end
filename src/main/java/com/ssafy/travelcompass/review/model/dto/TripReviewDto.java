package com.ssafy.travelcompass.review.model.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class TripReviewDto {
	int tripReviewId;
	int userId;
	int nickname;
	int attractionTitle;
	LocalDateTime createdAt;
	List<String> reviewImageList;
	String content;
	int star;
	int likeCount;
	boolean likeCheck;
	List<String> reviewTagList;
	String commentNickname;
	String commentContent;
}
