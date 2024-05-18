package com.ssafy.travelcompass.user.model.mapper;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.travelcompass.user.model.dto.UserInfoDto;

@Mapper
public interface UserMapper {

	void updatePassword(Map<String, Object> map) throws SQLException;

	UserInfoDto findUserByUserId(int userId) throws SQLException;

	void updateNickName(Map<String, Object> map) throws SQLException;

	void updateIntroduction(Map<String, Object> map) throws SQLException;

	String findProfileByUserId(int userId) throws SQLException;

	void updateProfile(Map<String, Object> map) throws SQLException;

}
