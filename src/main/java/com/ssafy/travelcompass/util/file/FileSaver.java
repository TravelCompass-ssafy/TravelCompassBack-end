package com.ssafy.travelcompass.util.file;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface FileSaver {

	String profileSave(MultipartFile file) throws IllegalStateException, IOException;

	void profileRemove(String profilePath);

	List<String> reviewImageSave(List<MultipartFile> reviewImageList) throws IllegalStateException, IOException;

	String tripDetailSave(MultipartFile image) throws IllegalStateException, IOException;
}
