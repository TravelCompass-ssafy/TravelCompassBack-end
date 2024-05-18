package com.ssafy.travelcompass.user.model.dto;

import java.time.LocalDate;

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
public class UserInfoDto {
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
}
