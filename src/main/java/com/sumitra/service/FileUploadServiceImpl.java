package com.sumitra.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadServiceImpl implements FileUploadService {

	public boolean uploadImage(MultipartFile image, String folderName) {
		boolean uploaded = false ;
		File uploadFolder = new File(UPLOAD_DIR + File.separator + folderName);
		if(!uploadFolder.exists())
		{
		uploadFolder.mkdirs(); //multiple file create and there path .
		}
		File uploadFile = new File(uploadFolder.getPath() + File.separator + image.getOriginalFilename());
		try {
		image.transferTo(uploadFile);
		uploaded = true ;
		} catch (IllegalStateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return uploaded;
	}
	}
	
	

	


