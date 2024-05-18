package com.ssafy.travelcompass.share.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.travelcompass.share.model.dto.TripShareDto;
import com.ssafy.travelcompass.share.model.service.ShareService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/share")
@RequiredArgsConstructor
public class ShareController {
	
	private final ShareService shareService;
	
	@GetMapping
	public ResponseEntity<List<TripShareDto>> getShareList(@RequestParam("type") String type, @RequestParam("key") String key) {
		return new ResponseEntity<List<TripShareDto>>(shareService.getShareList(type, key), HttpStatus.OK);
	}
}
