package com.ssafy.travelcompass.review.model.dto.review;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TripReviewDto {
	int tripReviewId;
	int userId;
	int contentId;
	int tripDetailId;
	String content;
	int star;
	LocalDateTime createdAt;
	
	int nickname; // 작성자 이름
	int attractionTitle; // 관광지 이름
	List<String> reviewImageList; // 리뷰 이미지 리스트
	int likeCount; // 좋아요 갯수
	boolean likeCheck; // 좋아요 체크 여부
	List<String> reviewTagList; // 태그 리스트
}
