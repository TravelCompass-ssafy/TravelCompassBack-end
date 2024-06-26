package com.ssafy.travelcompass.auth.model.dto;

import java.time.LocalDate;

import com.ssafy.travelcompass.util.encrypt.EncryptHelper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
	int totalStarCount;
	String refreshToken;
	String profile;
	
	public void encryptPassword(EncryptHelper encryptHelper) {
		this.password = encryptHelper.encrypt(this.password);
	}
}
