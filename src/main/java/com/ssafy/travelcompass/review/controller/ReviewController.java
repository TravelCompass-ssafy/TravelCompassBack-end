package com.ssafy.travelcompass.review.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.travelcompass.review.model.dto.review.TripReviewDto;
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
	public ResponseEntity<?> writeReview(@RequestBody TripReviewDto requestTripReview,
										 HttpServletRequest request) throws Exception {
		int userId = jwtUtil.getUserId(request.getHeader("Authorization"));
		requestTripReview.setUserId(userId);
		
		reviewService.writeReview(requestTripReview);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();	
	}
}
