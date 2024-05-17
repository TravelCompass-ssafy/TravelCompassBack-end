package com.ssafy.travelcompass.auth.model.mapper;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.travelcompass.auth.model.dto.EmailAuthNumberDto;
import com.ssafy.travelcompass.auth.model.dto.UserDto;

@Mapper
public interface AuthMapper {
	void signUp(UserDto requestSignUp) throws SQLException;

	UserDto findByEmail(String email) throws SQLException;

	void newPasswordByEmail(Map<String, String> param) throws SQLException;

	int insertAuthToken(EmailAuthNumberDto emailAuthNumber) throws SQLException;

	String findAuthNumberById(int emailAuthNumberId) throws SQLException;

	boolean isEmailExists(String email) throws SQLException;

	boolean isNickNameExists(String nickName) throws SQLException;

	UserDto login(UserDto userDto) throws SQLException;

	void saveRefreshToken(Map<String, Object> map) throws SQLException;
}
