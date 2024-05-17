package com.ssafy.travelcompass.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.travelcompass.auth.model.dto.RequestEmailAuthNumber;
import com.ssafy.travelcompass.auth.model.dto.RequestEmailVerification;
import com.ssafy.travelcompass.auth.model.dto.RequestNewPassword;
import com.ssafy.travelcompass.auth.model.dto.UserDto;
import com.ssafy.travelcompass.auth.model.service.AuthService;
import com.ssafy.travelcompass.util.jwt.JWTUtil;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
	
	private final AuthService authService;
	private final JWTUtil jwtUtil;
	
	@GetMapping("/emailCheck")
	public ResponseEntity<?> emailCheck(@RequestParam("email") String email) throws Exception {
		authService.isEmailExists(email);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@GetMapping("/nickNameCheck")
	public ResponseEntity<?> nickNameCheck(@RequestParam("nickName") String nickName) throws Exception {
		authService.isNickNameExists(nickName);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); 
	}

	@PostMapping("/email/auth")
	public ResponseEntity<?> emailAuthNumber(@RequestBody RequestEmailAuthNumber requestEmailAuthNumber) throws Exception {		
		int emailAuthNumberId = authService.emailAuthNumber(requestEmailAuthNumber);
		
		Map<String, Integer> response = new HashMap<>();
		response.put("emailAuthNumberId", emailAuthNumberId);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping("/email/verification")
	public ResponseEntity<?> emailVerify(@ModelAttribute RequestEmailVerification requestEmailVerification) throws Exception {
		
		System.out.println(requestEmailVerification.toString());
		authService.emailVerify(requestEmailVerification);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PostMapping("/sign-up")
	public ResponseEntity<?> signUp(@RequestBody UserDto requestSignUp) throws Exception {
		authService.signUp(requestSignUp);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PutMapping("/newPassword")
	public ResponseEntity<?> newPassword(@RequestBody RequestNewPassword requestNewPassword) throws Exception {
		authService.newPassword(requestNewPassword);
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserDto userDto) throws Exception {		
		Map<String, Object> tokens = authService.login(userDto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(tokens);
	}
	
	
}
