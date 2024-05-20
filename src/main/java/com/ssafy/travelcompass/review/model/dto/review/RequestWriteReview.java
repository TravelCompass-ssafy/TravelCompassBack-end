package com.ssafy.travelcompass.review.model.dto.review;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestWriteReview {

	private int tripReviewId;
	private int contentId;
	private int tripDetailId;
	private List<MultipartFile> reviewImageList;
	private String content;
	private List<String> reviewTagList;
	private int star;
	
	private int userId;
}
