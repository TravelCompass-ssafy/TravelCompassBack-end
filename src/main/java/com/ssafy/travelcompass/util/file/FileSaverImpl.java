package com.ssafy.travelcompass.util.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaverImpl implements FileSaver {

	@Value("${image.upload.dir}")
    private String uploadDir;
	
	@Override
	public String profileSave(MultipartFile file) throws IllegalStateException, IOException {
		String realPath = uploadDir + File.separator + "profile";
		String today = new SimpleDateFormat("yyMMdd").format(new Date());
		String saveFolder = realPath + File.separator + today;
		File folder = new File(saveFolder);
		
		System.out.println("fl:" + folder);
		
		// 디렉토리가 존재하지 않으면 생성
	    if (!folder.exists()) {
	    	System.out.println("키킥");
	        folder.mkdirs();
	    }
		
		String ext = file.getOriginalFilename().split("\\.")[1];
		String uuid = UUID.randomUUID().toString();
		
		String newFileName = uuid + "." + ext;
		
		File savedFile = new File(folder, newFileName);
				
		file.transferTo(savedFile);
		
		return "/images/profile/" + today + "/" + newFileName;
	}
	

	@Override
	public void profileRemove(String profilePath) {
		if(profilePath == null || profilePath.equals("/images/profile/basicProfile.jpg")) return;
		// /images/ 경로 제거
        if (profilePath.startsWith("/images/")) {
        	profilePath = profilePath.substring("/images/".length());
        }
        
        Path filePath = Paths.get(uploadDir, profilePath);
        File file = filePath.toFile();
        
        if(file.exists()) {
        	file.delete();
        }
	}


}
