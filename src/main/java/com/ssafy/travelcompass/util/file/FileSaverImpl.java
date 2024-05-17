package com.ssafy.travelcompass.util.file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletContext;

@Component
public class FileSaverImpl implements FileSaver {

	@Override
	public String profileSave(MultipartFile file, ServletContext servletContext) throws IllegalStateException, IOException {
		String realPath = servletContext.getRealPath("/WEB-INF/img/profile");
		String today = new SimpleDateFormat("yyMMdd").format(new Date());
		String saveFolder = realPath + File.separator + today;
		File folder = new File(saveFolder);
		String ext = file.getOriginalFilename().split("\\.")[1];
		String uuid = UUID.randomUUID().toString();
		file.transferTo(new File(folder, uuid + "." + ext));
		
		return saveFolder + "\\" + uuid + "." + ext;
	}


}
