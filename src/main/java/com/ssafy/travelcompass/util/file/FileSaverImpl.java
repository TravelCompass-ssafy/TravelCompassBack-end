package com.ssafy.travelcompass.util.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
				
		// 디렉토리가 존재하지 않으면 생성
	    if (!folder.exists()) {
	        folder.mkdirs();
	    }
		
		String ext = file.getOriginalFilename().split("\\.")[1];
		String uuid = UUID.randomUUID().toString();
		
		String newFileName = uuid + "." + ext;
		
		File savedFile = new File(folder, newFileName);
				
		file.transferTo(savedFile);
		
		return "/img/profile/" + today + "/" + newFileName;
	}
	

	@Override
	public void profileRemove(String profilePath) {
		if(profilePath == null || profilePath.equals("/img/profile/basicProfile.jpg")) return;
		// /images/ 경로 제거
        if (profilePath.startsWith("/img/")) {
        	profilePath = profilePath.substring("/img/".length());
        }
        
        Path filePath = Paths.get(uploadDir, profilePath);
        File file = filePath.toFile();
        
        if(file.exists()) {
        	file.delete();
        }
	}


	@Override
	public List<String> reviewImageSave(List<MultipartFile> reviewImageList) throws IllegalStateException, IOException {
		String realPath = uploadDir + File.separator + "review";
		String today = new SimpleDateFormat("yyMMdd").format(new Date());
		String saveFolder = realPath + File.separator + today;
		File folder = new File(saveFolder);
				
		// 디렉토리가 존재하지 않으면 생성
	    if (!folder.exists()) {
	        folder.mkdirs();
	    }
	    
	    List<String> imagePaths = new ArrayList<>();
	    for(MultipartFile file: reviewImageList) {
	    	String ext = file.getOriginalFilename().split("\\.")[1];
			String uuid = UUID.randomUUID().toString();
			String newFileName = uuid + "." + ext;
			File savedFile = new File(folder, newFileName);
			
			file.transferTo(savedFile);
			
			imagePaths.add("/img/review/" + today + "/" + newFileName);
	    }
		
		return imagePaths;
	}


	@Override
	public String tripDetailSave(MultipartFile image) throws IllegalStateException, IOException {
		String realPath = uploadDir + File.separator + "trip";
		String today = new SimpleDateFormat("yyMMdd").format(new Date());
		String saveFolder = realPath + File.separator + today;
		File folder = new File(saveFolder);
				
		// 디렉토리가 존재하지 않으면 생성
	    if (!folder.exists()) {
	        folder.mkdirs();
	    }
		
		String ext = image.getOriginalFilename().split("\\.")[1];
		String uuid = UUID.randomUUID().toString();
		
		String newFileName = uuid + "." + ext;
		
		File savedFile = new File(folder, newFileName);
				
		image.transferTo(savedFile);
		
		return "/img/trip/" + today + "/" + newFileName;
		
	}


	@Override
	public void reviewImageRemove(List<String> reviewImagePathList) {
		if(reviewImagePathList == null) return;
		for(String reviewImagePath: reviewImagePathList) {
			if (reviewImagePath.startsWith("/img/")) {
				reviewImagePath = reviewImagePath.substring("/img/".length());
	        }
	        
	        Path filePath = Paths.get(uploadDir, reviewImagePath);
	        File file = filePath.toFile();
	        
	        if(file.exists()) {
	        	file.delete();
	        }
		}
	}


}
