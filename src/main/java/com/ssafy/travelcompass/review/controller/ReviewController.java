package com.ssafy.travelcompass.review.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.travelcompass.review.model.dto.comment.RequestComment;
import com.ssafy.travelcompass.review.model.dto.comment.ReviewCommentDto;
import com.ssafy.travelcompass.review.model.dto.like.ReviewLikeDto;
import com.ssafy.travelcompass.review.model.dto.review.RequestWriteReview;
import com.ssafy.travelcompass.review.model.dto.review.TripReviewDto;
import com.ssafy.travelcompass.review.model.service.comment.ReviewCommentService;
import com.ssafy.travelcompass.review.model.service.like.ReviewLikeService;
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
	private final ReviewLikeService reviewLikeService;
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
	public ResponseEntity<?> getReviews(@RequestParam("page") int page, 
										@RequestParam("size") int size,
										@RequestParam(required = false) String keyword,
										@RequestParam(required = false) String category) throws Exception {
		
		int offset = page * size;
		List<TripReviewDto> result = reviewService.getReviews(offset, size, keyword, category);
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	@GetMapping("{trip-detail-id}")
	public ResponseEntity<?> getReviewsByTripDetailId(@PathVariable("trip-detail-id") int tripDetailId) throws Exception {
		
		List<TripReviewDto> result = reviewService.getReviewsByTripDetailId(tripDetailId);
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	@GetMapping("{trip-review-id}/comment")
	public ResponseEntity<?> getComments(@PathVariable("trip-review-id") int tripReviewId,
										 @RequestParam("page") int page, 
										 @RequestParam("size") int size) throws Exception {
		
		int offset = page * size;
		System.out.println(offset);
		List<ReviewCommentDto> result = reviewCommentService.getCommentsByTripReviewId(tripReviewId, offset, size);
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	@PostMapping("{trip-review-id}/comment")
	public ResponseEntity<?> writeComment(@PathVariable("trip-review-id") int tripReviewId,
										  @RequestBody RequestComment requestComment,
										  HttpServletRequest request) throws Exception {
		int userId = jwtUtil.getUserId(request.getHeader("Authorization"));
		
		ReviewCommentDto comment = ReviewCommentDto.builder()
									.userId(userId)
									.tripReviewId(tripReviewId)
									.content(requestComment.getContent())
									.build();
		
		ReviewCommentDto result = reviewCommentService.writeComment(comment);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}
	
	@PostMapping("{trip-review-id}/comment/{review-comment-id}/reply")
	public ResponseEntity<?> writeCommentReply(@PathVariable("trip-review-id") int tripReviewId,
											   @PathVariable("review-comment-id") int reviewCommentId,
											   @RequestBody RequestComment requestComment,
											   HttpServletRequest request) throws Exception {
		int userId = jwtUtil.getUserId(request.getHeader("Authorization"));
		
		ReviewCommentDto reply = ReviewCommentDto.builder()
				.tripReviewId(tripReviewId)
				.parentReviewCommentId(reviewCommentId)
				.userId(userId)
				.content(requestComment.getContent())
				.build();
		
		ReviewCommentDto result = reviewCommentService.writeCommentReply(reply);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}
	
	@PatchMapping("{trip-review-id}/like")
	public ResponseEntity<?> toggleLike(@PathVariable("trip-review-id") int tripReviewId,
										HttpServletRequest request) throws Exception {
		int userId = jwtUtil.getUserId(request.getHeader("Authorization"));
		
		ReviewLikeDto like = ReviewLikeDto.builder()
						.tripReviewId(tripReviewId)
						.userId(userId)
						.build();
		
		reviewLikeService.toggleLike(like);
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
