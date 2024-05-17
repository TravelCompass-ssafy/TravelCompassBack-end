package com.ssafy.travelcompass.util.file;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletContext;

public interface FileSaver {

	String profileSave(MultipartFile file, ServletContext servletContext) throws IllegalStateException, IOException;
}
