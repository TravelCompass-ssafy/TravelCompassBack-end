package com.ssafy.travelcompass.util.file;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface FileSaver {

	String profileSave(MultipartFile file) throws IllegalStateException, IOException;

	void profileRemove(String profilePath);
}
