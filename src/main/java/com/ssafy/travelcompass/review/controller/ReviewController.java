package com.ssafy.travelcompass.review.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.travelcompass.review.model.dto.TripReviewDto;
import com.ssafy.travelcompass.review.model.service.ReviewService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/review")
@RequiredArgsConstructor
public class ReviewController {
	
	private final ReviewService reviewService;
	
	@GetMapping
	public ResponseEntity<List<TripReviewDto>> getReviewList(@RequestParam("search-type") String searchType, @RequestParam("search-keyword") String searchKeyword) {
		return new ResponseEntity<List<TripReviewDto>>(reviewService.getReviewList(searchType, searchKeyword), HttpStatus.OK);
	}
	
}
