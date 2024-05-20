package com.ssafy.travelcompass.review.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.travelcompass.review.model.dto.comment.ReviewCommentDto;
import com.ssafy.travelcompass.review.model.dto.review.RequestWriteReview;
import com.ssafy.travelcompass.review.model.dto.review.TripReviewDto;
import com.ssafy.travelcompass.review.model.service.comment.ReviewCommentService;
import com.ssafy.travelcompass.review.model.service.review.ReviewService;
import com.ssafy.travelcompass.util.jwt.JWTUtil;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/review")
@RequiredArgsConstructor
public class ReviewController {
	
	private final ReviewService reviewService;
	private final ReviewCommentService reviewCommentService;
	private final JWTUtil jwtUtil;
	
	@PostMapping
	public ResponseEntity<?> writeReview(@ModelAttribute RequestWriteReview requestWriteReview,
										 HttpServletRequest request) throws Exception {
		int userId = jwtUtil.getUserId(request.getHeader("Authorization"));
		requestWriteReview.setUserId(userId);
		
		reviewService.writeReview(requestWriteReview);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();	
	}
	
	@GetMapping
	public ResponseEntity<?> getReviews(@RequestParam("page") int page, @RequestParam("size") int size) throws Exception {
		
		int offset = page * size;
		List<TripReviewDto> result = reviewService.getReviews(offset, size);
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	@GetMapping("{trip-review-id}")
	public ResponseEntity<?> getComments(@PathVariable("trip-review-id") int tripReviewId,
										 @RequestParam("page") int page, 
										 @RequestParam("size") int size) throws Exception {
		int offset = page * size;
		List<ReviewCommentDto> result = reviewCommentService.getCommentsByTripReviewId(tripReviewId, offset, size);
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
}
