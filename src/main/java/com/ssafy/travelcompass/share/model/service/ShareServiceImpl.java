package com.ssafy.travelcompass.share.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.travelcompass.share.model.dto.TripShareDto;
import com.ssafy.travelcompass.share.model.mapper.ShareMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShareServiceImpl implements ShareService {
	private final ShareMapper shareMapper;

	@Override
	public List<TripShareDto> getShareList(String type, String key) {
		List<TripShareDto> tripShareDto = shareMapper.getTripShareList(type, key);
		
		return tripShareDto;
	}
}
