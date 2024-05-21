package com.ssafy.travelcompass.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.travelcompass.auth.model.dto.RequestEmailAuthNumber;
import com.ssafy.travelcompass.auth.model.dto.RequestEmailVerification;
import com.ssafy.travelcompass.auth.model.dto.RequestNewPassword;
import com.ssafy.travelcompass.auth.model.dto.RequestResetPassword;
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
import org.springframework.web.bind.annotation.PatchMapping;
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
		System.out.println("인증 번호:" + requestEmailVerification);
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
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		try {
			UserDto loginUser = authService.login(userDto);
			System.out.println(loginUser);
			if(loginUser != null) {
				String accessToken = jwtUtil.createAccessToken(loginUser.getUserId());
				String refreshToken = jwtUtil.createRefreshToken(loginUser.getUserId());
				
				System.out.println(accessToken);
				System.out.println(refreshToken);
				authService.saveRefreshToken(loginUser.getUserId(), refreshToken);
				
				resultMap.put("userInfo", loginUser);
				resultMap.put("access-token", accessToken);
				resultMap.put("refresh-token", refreshToken);				
				
				status = HttpStatus.CREATED;
			}
			else {
				resultMap.put("message", "아이디 또는 패스워드를 확인해 주세요.");
				status = HttpStatus.UNAUTHORIZED;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return ResponseEntity.status(status).body(resultMap);
	}
	
	@GetMapping("/info/{user-id}")
	public ResponseEntity<?> getInfo(@PathVariable("user-id") int userId, HttpServletRequest request){
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		
		if(jwtUtil.checkToken(request.getHeader("Authorization"))) {
			try {
				UserDto userDto = authService.userInfo(userId);
				resultMap.put("userInfo", userDto);
				status = HttpStatus.OK;
			} catch(Exception e) {
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		}
		else {
			status = HttpStatus.UNAUTHORIZED;
		}
		
		return ResponseEntity.status(status).body(resultMap);
	}
	
	@GetMapping("/logout/{user-id}")
	public ResponseEntity<?> removeToken(@PathVariable("user-id") int userId) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		
		try {
			authService.deleteRefreshToken(userId);
			status = HttpStatus.OK;
		} catch (Exception e) {
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return ResponseEntity.status(status).body(resultMap);
	}
	
	@PostMapping("/refresh")
	public ResponseEntity<?> refreshToken(@RequestBody UserDto userDto, HttpServletRequest request) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		String token = request.getHeader("refreshToken");
		
		if(jwtUtil.checkToken(token)) {
			if(token.equals(authService.getRefreshToken(userDto.getUserId()))) {
				String newAccessToken = jwtUtil.createAccessToken(userDto.getUserId());
				resultMap.put("access-token", newAccessToken);
				status = HttpStatus.CREATED;
			}
		}
		else {
			status = HttpStatus.UNAUTHORIZED;
		}
		
		return ResponseEntity.status(status).body(resultMap);
	}
	
	@GetMapping("/email/find")
	public ResponseEntity<?> findEmail(@RequestParam("nickName") String nickName, @RequestParam("birthday") String birthDay) throws Exception {
		
		String email = authService.findEmail(nickName, birthDay);
		
		Map<String, String> resultMap = new HashMap<>();
		resultMap.put("email", email);
		
		return ResponseEntity.status(HttpStatus.OK).body(resultMap);
	}
	
	@PatchMapping("/resetPassword")
	public ResponseEntity<?> resetPassword(@RequestBody RequestResetPassword requestResetPassword) throws Exception {
		authService.resetPassword(requestResetPassword);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
