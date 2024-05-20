package com.ssafy.travelcompass.trip.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.travelcompass.trip.model.dto.member.TripDetailMemberDto;
import com.ssafy.travelcompass.trip.model.dto.trip.TripDetailDto;
import com.ssafy.travelcompass.trip.model.service.member.MemberService;
import com.ssafy.travelcompass.trip.model.service.trip.TripService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/trip")
@RequiredArgsConstructor
public class TripController {
	private final TripService tripService;
	private final MemberService memberService;
	
	@GetMapping
	public ResponseEntity<?> getTripList() {
		return null;
	}
	
	@PostMapping
	public ResponseEntity<?> registTrip(@RequestBody TripDetailDto tripDetailDto) {
		tripService.registTripDetail(tripDetailDto);
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	// Member
	@PostMapping("/{trip-id}")
	public ResponseEntity<?> registMember(@RequestBody TripDetailMemberDto tripDetailMemberDto) throws Exception {
		memberService.regist(tripDetailMemberDto);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
