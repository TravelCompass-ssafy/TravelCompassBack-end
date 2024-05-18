package com.ssafy.travelcompass.auth.model.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.travelcompass.auth.model.dto.EmailAuthNumberDto;
import com.ssafy.travelcompass.auth.model.dto.RequestEmailAuthNumber;
import com.ssafy.travelcompass.auth.model.dto.RequestEmailVerification;
import com.ssafy.travelcompass.auth.model.dto.RequestNewPassword;
import com.ssafy.travelcompass.auth.model.dto.UserDto;
import com.ssafy.travelcompass.auth.model.mapper.AuthMapper;
import com.ssafy.travelcompass.exception.custom.EmailExistsException;
import com.ssafy.travelcompass.exception.custom.InvalidEmailAuthTokenException;
import com.ssafy.travelcompass.exception.custom.LoginFailedException;
import com.ssafy.travelcompass.exception.custom.NickNameExistsException;
import com.ssafy.travelcompass.exception.custom.UserNotFoundException;
import com.ssafy.travelcompass.util.encrypt.EncryptHelper;
import com.ssafy.travelcompass.util.jwt.JWTUtil;
import com.ssafy.travelcompass.util.mail.MailSender;

import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
	
	private final AuthMapper authMapper;
	private final MailSender mailSender;
	private final EncryptHelper encryptHelper;
	private final JWTUtil jwtUtil;

	@Override
	public void signUp(UserDto requestSignUp) throws Exception {
		requestSignUp.encryptPassword(encryptHelper);
		authMapper.signUp(requestSignUp);
	}

	@Override
	public void newPassword(RequestNewPassword requestNewPassword) throws Exception {
		UserDto user = authMapper.findByEmail(requestNewPassword.getEmail());
		if(user == null) {
			throw new UserNotFoundException();
		}
		else {
			String password = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 10);
			
			Map<String, String> param = new HashMap<>();
			param.put("password", password);
			param.put("email", requestNewPassword.getEmail());
			
			authMapper.newPasswordByEmail(param);
			
			mailSender.sendNewPassword(requestNewPassword.getEmail(), password);
		}
	}
	
	@Override
	public int emailAuthNumber(RequestEmailAuthNumber requestEmailAuthToken) throws Exception {
		String authNum = mailSender.sendEmailAuth(requestEmailAuthToken.getEmail());
		
		EmailAuthNumberDto emailAuthNumber = new EmailAuthNumberDto();
		emailAuthNumber.setAuthNum(authNum);
		authMapper.insertAuthToken(emailAuthNumber);
		
		return emailAuthNumber.getEmailAuthNumberId();
	}


	@Override
	public void emailVerify(RequestEmailVerification requestEmailVerification) throws Exception {
		String authNum = authMapper.findAuthNumberById(requestEmailVerification.getEmailAuthNumberId());
		System.out.println("authNum," + authNum);
		System.out.println("2" + requestEmailVerification.getAuthNumber());
		if(authNum == null || !requestEmailVerification.getAuthNumber().equals(authNum)) {
			throw new InvalidEmailAuthTokenException();
		}
	}

	@Override
	public void isEmailExists(String email) throws Exception {
		if(!authMapper.isEmailExists(email)) {
			throw new EmailExistsException();
		}
	}

	@Override
	public void isNickNameExists(String nickName) throws Exception {
		if(!authMapper.isNickNameExists(nickName)) {
			throw new NickNameExistsException();
		}
	}

	@Override
	public UserDto login(UserDto userDto) throws Exception {
		UserDto result = authMapper.login(userDto);
		if(encryptHelper.isMatch(userDto.getPassword(), result.getPassword())) {
			result.setPassword(null);
			return result;
		}
		else {
			return null;
		}

	} 
	
	@Override
	public void saveRefreshToken(int userId, String refreshToken) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("userId", userId);
		map.put("token", refreshToken);
		authMapper.saveRefreshToken(map);
	}

	@Override
	public UserDto userInfo(int userId) throws Exception {
		return authMapper.userInfo(userId);
	}

	@Override
	public void deleteRefreshToken(int userId) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("userId", userId);
		map.put("token", null);
		authMapper.deleteRefreshToken(map);
	}

	@Override
	public Object getRefreshToken(int userId) throws Exception {
		return authMapper.getRefreshToken(userId);
	}
}
