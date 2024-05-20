package com.ssafy.travelcompass.trip.model.mapper;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.travelcompass.trip.model.dto.member.TripDetailMemberDto;

@Mapper
public interface MemberMapper {

	boolean isMemberExistsByUserId(int userId) throws SQLException;

	void regist(TripDetailMemberDto tripDetailMemberDto) throws Exception;

	TripDetailMemberDto findByUserId(int userId) throws Exception;

	boolean isMemberExistsByUserIdAndTripDetailId(Map<String, Object> map);

}
