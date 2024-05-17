package com.ssafy.travelcompass.auth.model.service;

import java.util.Map;

import com.ssafy.travelcompass.auth.model.dto.RequestEmailAuthNumber;
import com.ssafy.travelcompass.auth.model.dto.RequestEmailVerification;
import com.ssafy.travelcompass.auth.model.dto.RequestNewPassword;
import com.ssafy.travelcompass.auth.model.dto.UserDto;

public interface AuthService {
	void signUp(UserDto requestSignUp) throws Exception;

	void newPassword(RequestNewPassword requestNewPassword) throws Exception;

	int emailAuthNumber(RequestEmailAuthNumber requestEmailAuthToken) throws Exception;

	void emailVerify(RequestEmailVerification requestEmailVerification) throws Exception;

	void isEmailExists(String email) throws Exception;

	void isNickNameExists(String nickName) throws Exception;

	Map<String, Object> login(UserDto userDto) throws Exception;

	void saveRefreshToken(int userId, String refreshToken) throws Exception;
}

