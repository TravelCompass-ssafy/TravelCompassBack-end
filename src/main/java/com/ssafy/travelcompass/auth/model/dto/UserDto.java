package com.ssafy.travelcompass.auth.model.dto;

import lombok.Data;

@Data
public class UserDto {
	int userId;
	String email;
	String password;
	String username;
	String nickname;
	String gender;
	String birthday;
	int total_star;
	int total_start_count;
	String refresh_token;
}
