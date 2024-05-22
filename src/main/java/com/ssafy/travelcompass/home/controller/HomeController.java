package com.ssafy.travelcompass.home.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.travelcompass.home.model.service.HomeService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/home")
@RequiredArgsConstructor
public class HomeController {
	private final HomeService homeService;
	
	@GetMapping("/plan-view")
	public ResponseEntity<?> getBestPlanView() {
		return ResponseEntity.status(HttpStatus.OK).body(homeService.getBestPlanView());
	}

	@GetMapping("/trip-recent")
	public ResponseEntity<?> getRecentTrip() {
		return ResponseEntity.status(HttpStatus.OK).body(homeService.getRecentTrip());
	}
}
