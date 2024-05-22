package com.ssafy.travelcompass.review.model.service.image;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.travelcompass.review.model.dto.image.ReviewImageFileDto;
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

	@Override
	public List<ReviewImageFileDto> findByTripReviewId(int tripReviewId) throws Exception {
		List<ReviewImageFileDto> reviewImages = reviewImageFileMapper.findByTripReviewId(tripReviewId);
		return reviewImages;
	}

	@Override
	public void deleteReviewImageByReviewId(int tripReviewId) throws Exception {
		List<ReviewImageFileDto> images = findByTripReviewId(tripReviewId);
		
		List<String> imagePathList = images.stream()
				.map(ReviewImageFileDto::getPath)
				.collect(Collectors.toList());
		
		fileSaver.reviewImageRemove(imagePathList);
		
		reviewImageFileMapper.deleteByReviewId(tripReviewId);
	}

	@Override
	public void updateImage(int tripReviewId, List<MultipartFile> reviewImageList) throws Exception {
		deleteReviewImageByReviewId(tripReviewId);
	
		saveImage(tripReviewId, reviewImageList);
	}
}
