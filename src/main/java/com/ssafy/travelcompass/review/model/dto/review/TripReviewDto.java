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
	private int tripReviewId;
	private int userId;
	private int contentId;
	private int tripDetailId;
	private String content;
	private int star;
	private LocalDateTime createdAt;
	
	private int nickname; // 작성자 이름
	private int attractionTitle; // 관광지 이름
	private List<String> reviewImageList; // 리뷰 이미지 리스트
	private int likeCount; // 좋아요 갯수
	private boolean likeCheck; // 좋아요 체크 여부
	private List<String> reviewTagList; // 태그 리스트
}
