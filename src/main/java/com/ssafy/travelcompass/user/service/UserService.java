package com.ssafy.travelcompass.user.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.travelcompass.user.model.dto.RequestUpdateIntroduction;
import com.ssafy.travelcompass.user.model.dto.RequestUpdateNickName;
import com.ssafy.travelcompass.user.model.dto.UserInfoDto;

public interface UserService {

	void updatePassword(Map<String, Object> map) throws Exception;

	void updateNickName(int userId, RequestUpdateNickName requestUpdateNickName) throws Exception;

	void updateIntroduction(int userId, RequestUpdateIntroduction requestUpdateIntroduction) throws Exception;

	String updateProfile(int userId, MultipartFile file) throws Exception;

	UserInfoDto findByUserId(int userId) throws Exception;

}
