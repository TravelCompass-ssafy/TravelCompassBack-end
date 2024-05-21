package com.ssafy.travelcompass.trip.controller;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.travelcompass.trip.model.dto.member.TripDetailMemberDto;
import com.ssafy.travelcompass.trip.model.dto.trip.TripDetailDto;
import com.ssafy.travelcompass.trip.model.service.member.MemberService;
import com.ssafy.travelcompass.trip.model.service.trip.TripService;
import com.ssafy.travelcompass.util.jwt.JWTUtil;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/trip")
@RequiredArgsConstructor
public class TripController {
	private final TripService tripService;
	private final MemberService memberService;
	private final JWTUtil jwtUtil;
	
	@GetMapping
	public ResponseEntity<?> getTripList(@RequestParam(required = false) LocalDate date, @RequestParam(required = false) int sidoCode, @RequestParam(required = false) String keyword) {
		return ResponseEntity.status(HttpStatus.OK).body(tripService.getTripDetailList(date, sidoCode, keyword));
	}
	
	@GetMapping("/{tripDetailId}")
	public ResponseEntity<?> getTripDetail(@PathVariable int tripDetailId) {
		return ResponseEntity.status(HttpStatus.OK).body(tripService.getTripDetail(tripDetailId));
	}
	
	@PostMapping
	public ResponseEntity<?> registTrip(@RequestBody TripDetailDto tripDetailDto) throws Exception {
		tripService.registTripDetail(tripDetailDto);
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping("/checkjoinable")
	public ResponseEntity<?> checkJoinAble(@RequestParam(required = true) int userId, @RequestParam(required = true) LocalDate startDate, @RequestParam(required = true) LocalDate endDate) {
		tripService.getDuplicationTripId(userId, startDate, endDate);
		return ResponseEntity.status(HttpStatus.OK).body(tripService.getDuplicationTripId(userId, startDate, endDate));
	}
	
	// Member
	@PostMapping("/{trip-id}")
	public ResponseEntity<?> registMember(@RequestBody TripDetailMemberDto tripDetailMemberDto,
										  HttpServletRequest request) throws Exception {
		int userId = jwtUtil.getUserId(request.getHeader("Authorization"));
		tripDetailMemberDto.setUserId(userId);
		memberService.regist(tripDetailMemberDto);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
