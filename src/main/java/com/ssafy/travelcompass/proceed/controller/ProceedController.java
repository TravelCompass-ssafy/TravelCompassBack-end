package com.ssafy.travelcompass.proceed.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.travelcompass.proceed.model.service.ProceedService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/proceed")
@RequiredArgsConstructor
public class ProceedController {
	private final ProceedService proceedService;
	
	@GetMapping
	public ResponseEntity<?> getProceedList() {
		return null;
	}
}
