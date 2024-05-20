package com.ssafy.travelcompass.trip.model.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.travelcompass.trip.model.dto.member.TripDetailMemberDto;

@Mapper
public interface MemberMapper {

	boolean isMemberExistsByUserId(int userId) throws SQLException;

	void regist(TripDetailMemberDto tripDetailMemberDto) throws Exception;

}
