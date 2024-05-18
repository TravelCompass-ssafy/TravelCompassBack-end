package com.ssafy.travelcompass.share.model.service;

import java.util.List;

import com.ssafy.travelcompass.share.model.dto.TripShareDto;

public interface ShareService {

	List<TripShareDto> getShareList(String type, String key);

}
