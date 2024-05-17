package com.ssafy.travelcompass.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.travelcompass.auth.model.dto.UserDto;
import com.ssafy.travelcompass.auth.model.service.AuthService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	private AuthService authService;
	
	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	@GetMapping("")
	public List<UserDto> getUser() {
		return authService.getUser();
	}

}
