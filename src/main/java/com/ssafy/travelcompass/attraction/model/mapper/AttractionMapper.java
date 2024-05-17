package com.ssafy.travelcompass.attraction.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.travelcompass.attraction.model.dto.SidoDto;
import com.ssafy.travelcompass.attraction.model.dto.AttractionInfoDto;
import com.ssafy.travelcompass.attraction.model.dto.GugunDto;

@Mapper
public interface AttractionMapper {
	List<SidoDto> getSidoList();
	List<GugunDto> getGugunList(int sidoCode);
	List<AttractionInfoDto> getAttractionList(int sidoCode, int gugunCode, String keyword);
}
