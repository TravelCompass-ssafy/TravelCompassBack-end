package com.ssafy.travelcompass.attraction.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.travelcompass.attraction.model.dto.AttractionInfoDto;
import com.ssafy.travelcompass.attraction.model.dto.GugunDto;
import com.ssafy.travelcompass.attraction.model.dto.SidoDto;
import com.ssafy.travelcompass.attraction.model.service.AttractionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/attraction")
@RequiredArgsConstructor
public class AttractionController {
	
	private final AttractionService attractionService;
	
	@GetMapping("/sido")
	public ResponseEntity<List<SidoDto>> getSidoList() {
		return new ResponseEntity<List<SidoDto>>(attractionService.getSidoList(), HttpStatus.OK);
	}
	
	@GetMapping("/gugun")
	public ResponseEntity<List<GugunDto>> getGugunList(@RequestParam("sido-code") int sidoCode) {
		return new ResponseEntity<List<GugunDto>>(attractionService.getGugunList(sidoCode), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<AttractionInfoDto>> getAttractionList(@RequestParam("sido-code") int sidoCode, @RequestParam("gugun-code") int gugunCode, @RequestParam("keyword") String keyword) {
		return new ResponseEntity<List<AttractionInfoDto>>(attractionService.getAttractionList(sidoCode, gugunCode, keyword), HttpStatus.OK);
	}
}
