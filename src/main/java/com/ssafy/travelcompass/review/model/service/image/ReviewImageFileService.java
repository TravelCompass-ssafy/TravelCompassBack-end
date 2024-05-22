package com.ssafy.travelcompass.review.model.service.image;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.travelcompass.review.model.dto.image.ReviewImageFileDto;

public interface ReviewImageFileService {

	public void saveImage(int tripReviewId, List<MultipartFile> reviewImageList) throws Exception;

	public List<ReviewImageFileDto> findByTripReviewId(int tripReviewId) throws Exception;

	public void deleteReviewImageByReviewId(int tripReviewId) throws Exception;

	public void updateImage(int tripReviewId, List<MultipartFile> reviewImageList) throws Exception;
}
