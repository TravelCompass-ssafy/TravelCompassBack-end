package com.ssafy.travelcompass.attraction.model.service;

import java.util.List;

import com.ssafy.travelcompass.attraction.model.dto.SidoDto;
import com.ssafy.travelcompass.attraction.model.dto.AttractionInfoDto;
import com.ssafy.travelcompass.attraction.model.dto.GugunDto;

public interface AttractionService {
	List<SidoDto> getSidoList();
	List<GugunDto> getGugunList(int sidoCode);
	List<AttractionInfoDto> getAttractionList(int sidoCode, int gugunCode, String keyword);
}
