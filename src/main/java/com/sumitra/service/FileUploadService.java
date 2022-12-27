package com.sumitra.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

	public static final String UPLOAD_DIR = "C:\\Users\\DELL\\Documents\\mediserve";
	public boolean uploadImage (MultipartFile image , String folderName);

}
