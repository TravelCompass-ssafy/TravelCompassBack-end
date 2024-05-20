package com.ssafy.travelcompass.review.model.service.image;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.travelcompass.review.model.mapper.ReviewImageFileMapper;
import com.ssafy.travelcompass.util.file.FileSaver;

import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor
public class ReviewImageFileServiceImpl implements ReviewImageFileService {

	private final ReviewImageFileMapper reviewImageFileMapper;
	private final FileSaver fileSaver;

	@Override
	public void saveImage(int tripReviewId, List<MultipartFile> reviewImageList) throws Exception {
		List<String> reviewImagePaths =  fileSaver.reviewImageSave(reviewImageList);
		
		for(String reviewImagePath : reviewImagePaths) {
			Map<String, Object> map = new HashMap<>();
			
			map.put("tripReviewId", tripReviewId);
			map.put("path", reviewImagePath);
			
			reviewImageFileMapper.addImageByTripReviewId(map);
		}
	}
}
