package com.ssafy.travelcompass.user.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.travelcompass.auth.model.service.AuthService;
import com.ssafy.travelcompass.exception.custom.InvalidPassword;
import com.ssafy.travelcompass.user.model.dto.RequestUpdateIntroduction;
import com.ssafy.travelcompass.user.model.dto.RequestUpdateNickName;
import com.ssafy.travelcompass.user.model.dto.UserInfoDto;
import com.ssafy.travelcompass.user.model.mapper.UserMapper;
import com.ssafy.travelcompass.util.encrypt.EncryptHelper;
import com.ssafy.travelcompass.util.file.FileSaver;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

	private final AuthService authService;
	private final UserMapper userMapper;
	private final EncryptHelper encryptHelper;
	private final FileSaver fileSaver;

	@Override
	public void updatePassword(Map<String, Object> map) throws Exception {
		UserInfoDto userInfoDto = userMapper.findUserByUserId((int) map.get("userId"));
		
		if(encryptHelper.isMatch((String) map.get("currentPassword"), userInfoDto.getPassword())) {
			map.put("newPassword", encryptHelper.encrypt((String)map.get("newPassword")));
			userMapper.updatePassword(map);
		}
		else {
			throw new InvalidPassword();
		}
	}

	@Override
	public void updateNickName(int userId, RequestUpdateNickName requestUpdateNickName) throws Exception {
		Map<String, Object> map = new HashMap<>();
		
		authService.isNickNameExists(requestUpdateNickName.getNickName());
		
		map.put("userId", userId);
		map.put("newNickName", requestUpdateNickName.getNickName());
		userMapper.updateNickName(map);
	}

	@Override
	public void updateIntroduction(int userId, RequestUpdateIntroduction requestUpdateIntroduction) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("userId", userId);
		map.put("newIntroduction", requestUpdateIntroduction.getIntroduction());
		userMapper.updateIntroduction(map);
	}

	@Override
	public String updateProfile(int userId, MultipartFile file) throws Exception {
		String savePath = fileSaver.profileSave(file);
		
		String profilePath = userMapper.findProfileByUserId(userId);
		
		fileSaver.profileRemove(profilePath);
		
		Map<String, Object> map = new HashMap<>();
		map.put("userId", userId);
		map.put("savePath", savePath);
		userMapper.updateProfile(map);
		
		System.out.println(savePath);
		return savePath;
	}
	
}
