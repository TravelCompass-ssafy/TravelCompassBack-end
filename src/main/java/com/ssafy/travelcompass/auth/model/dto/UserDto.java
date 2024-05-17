package com.ssafy.travelcompass.auth.model.dto;

import java.time.LocalDate;

import com.ssafy.travelcompass.util.encrypt.EncryptHelper;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDto {
	int userId;
	String email;
	String password;
	String username;
	String nickname;
	String gender;
	LocalDate birthday;
	int totalStar;
	int totalStartCount;
	String refreshToken;
	String profile;
	
	public UserDto(int userId, String email, String password, String username, String nickname, String gender,
			LocalDate birthday, int totalStar, int totalStartCount, String refreshToken, String profile) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.username = username;
		this.nickname = nickname;
		this.gender = gender;
		this.birthday = birthday;
		this.totalStar = totalStar;
		this.totalStartCount = totalStartCount;
		this.refreshToken = refreshToken;
		this.profile = profile;
	}
	
	public void encryptPassword(EncryptHelper encryptHelper) {
		this.password = encryptHelper.encrypt(this.password);
	}
}
