package com.ssafy.travelcompass.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.travelcompass.user.model.dto.RequestUpdateIntroduction;
import com.ssafy.travelcompass.user.model.dto.RequestUpdateNickName;
import com.ssafy.travelcompass.user.model.dto.RequestUpdatePassword;
import com.ssafy.travelcompass.user.service.UserService;
import com.ssafy.travelcompass.util.jwt.JWTUtil;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

	private final UserService userService;
	private final JWTUtil jwtUtil;
	private final ServletContext servletContext;
	
	@PatchMapping("/password")
	public ResponseEntity<?> updatePassword(@RequestBody RequestUpdatePassword requestUpdatePassword, 
											HttpServletRequest request) throws Exception {
		int userId = jwtUtil.getUserId(request.getHeader("Authorization"));
		
		Map<String, Object> map = new HashMap<>();
		map.put("userId", userId);
		map.put("currentPassword", requestUpdatePassword.getCurrentPassword());
		map.put("newPassword", requestUpdatePassword.getNewPassword());
		
		userService.updatePassword(map);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PatchMapping("/nickName")
	public ResponseEntity<?> updateNickName(@RequestBody RequestUpdateNickName requestUpdateNickName,
											HttpServletRequest request) throws Exception {
		int userId = jwtUtil.getUserId(request.getHeader("Authorization"));
		
		userService.updateNickName(userId, requestUpdateNickName);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PatchMapping("/introduction")
	public ResponseEntity<?> updateIntroduction(@RequestBody RequestUpdateIntroduction requestUpdateIntroduction,
												HttpServletRequest request) throws Exception {
		int userId = jwtUtil.getUserId(request.getHeader("Authorization"));
		
		userService.updateIntroduction(userId, requestUpdateIntroduction);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PostMapping("/profile")
	public ResponseEntity<?> updateImage(@RequestParam("file") MultipartFile file,
										HttpServletRequest request) throws Exception {
		log.info(servletContext.getRealPath("/hi"));
		
		int userId = jwtUtil.getUserId(request.getHeader("Authorization"));
		
		String savePath = userService.updateProfile(userId, file);
		
		Map<String, String> resultMap = new HashMap<>();
		resultMap.put("savePath", savePath);
		
		return ResponseEntity.status(HttpStatus.OK).body(resultMap);
	}
}
