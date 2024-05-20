package com.ssafy.travelcompass.review.model.service.image;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface ReviewImageFileService {

	public void saveImage(int tripReviewId, List<MultipartFile> reviewImageList) throws Exception;
}
