package com.ssafy.travelcompass.share.model.dto;

import java.util.List;

import com.ssafy.travelcompass.trip.model.dto.TripDetailDto;

import lombok.Data;

@Data
public class TripShareDto {
	int tripShareId;
	String title;
	String content;
	int view;
	int tripDetailId;
	TripDetailDto tripDetail;
	List<TripShareCommentDto> tripShareCommentList;
	List<TripShareLikeDto> tripShareLikeList;
	List<TripShareTagDto> tripShareTagList;
}
