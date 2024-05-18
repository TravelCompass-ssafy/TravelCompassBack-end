package com.ssafy.travelcompass.share.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.travelcompass.share.model.dto.TripShareCommentDto;
import com.ssafy.travelcompass.share.model.dto.TripShareDto;
import com.ssafy.travelcompass.share.model.dto.TripShareLikeDto;
import com.ssafy.travelcompass.share.model.dto.TripShareTagDto;

@Mapper
public interface ShareMapper {
	List<TripShareDto> getTripShareList(String type, String key);
	TripShareDto getTripShare(int tripShareId);
	List<TripShareCommentDto> getTripShareCommentList(int tripShareId);
	List<TripShareLikeDto> getTripShareLikeList(int tripShareId);
	List<TripShareTagDto> getTripShareTagList(int tripShareId);
}
