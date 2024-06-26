package com.ssafy.travelcompass.trip.controller;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.travelcompass.trip.model.dto.member.TripDetailMemberDto;
import com.ssafy.travelcompass.trip.model.dto.trip.TripDetailDto;
import com.ssafy.travelcompass.trip.model.dto.trip.TripDetailImageDto;
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
	
	@GetMapping("/share")
	public ResponseEntity<?> getShareList(@RequestParam(required = false) LocalDate date, @RequestParam(required = false) int sidoCode, @RequestParam(required = false) String keyword) {
		return ResponseEntity.status(HttpStatus.OK).body(tripService.getShareList(date, sidoCode, keyword));
	}
	
	@GetMapping("/{tripDetailId}")
	public ResponseEntity<?> getTripDetail(@PathVariable int tripDetailId) {
		return ResponseEntity.status(HttpStatus.OK).body(tripService.getTripDetail(tripDetailId));
	}
	
	@GetMapping("/proceed/{userId}")
	public ResponseEntity<?> getProceedTrip(@PathVariable int userId) {
		TripDetailDto proceedTrip = tripService.getProceedTrip(userId);

		return ResponseEntity.status(HttpStatus.OK).body(proceedTrip);
	}
	
	@DeleteMapping("/{tripDetailId}")
	public ResponseEntity<?> deleteTripDetail(@PathVariable int tripDetailId) {
		tripService.deleteTripDetail(tripDetailId);

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PostMapping
	public ResponseEntity<?> registTrip(@ModelAttribute TripDetailDto tripDetailDto) throws Exception {
		tripDetailDto.convertJsonToList();
		
		tripService.registTripDetail(tripDetailDto);
		
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping("/checkjoinable")
	public ResponseEntity<?> checkJoinAble(@RequestParam(required = true) int userId, @RequestParam(required = true) LocalDate startDate, @RequestParam(required = true) LocalDate endDate) {
		tripService.getDuplicationTripId(userId, startDate, endDate);
		return ResponseEntity.status(HttpStatus.OK).body(tripService.getDuplicationTripId(userId, startDate, endDate));
	}
	
	@PutMapping("/view/{tripDetailId}")
	public ResponseEntity<?> upCountView(@PathVariable int tripDetailId) {
		System.out.println(tripDetailId);
		tripService.upCountViewI(tripDetailId);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
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
	
	@PutMapping
	public ResponseEntity<?> updateTripDetail(@RequestBody TripDetailDto tripDetailDto) {
		System.out.println(tripDetailDto);
		tripService.updateTripDetail(tripDetailDto);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
