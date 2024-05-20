package com.ssafy.travelcompass.review.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.travelcompass.review.model.dto.review.RequestWriteReview;
import com.ssafy.travelcompass.review.model.service.review.ReviewService;
import com.ssafy.travelcompass.util.jwt.JWTUtil;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/review")
@RequiredArgsConstructor
public class ReviewController {
	
	private final ReviewService reviewService;
	private final JWTUtil jwtUtil;
	
	@PostMapping
	public ResponseEntity<?> writeReview(@ModelAttribute RequestWriteReview requestWriteReview,
										 HttpServletRequest request) throws Exception {
		int userId = jwtUtil.getUserId(request.getHeader("Authorization"));
		requestWriteReview.setUserId(userId);
		
		reviewService.writeReview(requestWriteReview);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();	
	}
}
