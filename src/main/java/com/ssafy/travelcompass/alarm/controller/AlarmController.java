package com.ssafy.travelcompass.alarm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.ssafy.travelcompass.alarm.model.dto.RequestJoinTrip;
import com.ssafy.travelcompass.alarm.model.service.NotificationService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sse")
public class AlarmController {

	private final NotificationService notificationService;
	
	@GetMapping(value="/connect/{userId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public ResponseEntity<SseEmitter> connect(@PathVariable int userId) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(notificationService.connect(userId));
	}
	
	@PostMapping("/joinTrip/trip/{trip-detail-id}")
	public void notifyJoinTrip(@PathVariable("trip-detail-id") int tripDetailId) throws Exception {
		System.out.println("우우우:" + tripDetailId);
		notificationService.notifyJoinTrip(tripDetailId);
	}
}
