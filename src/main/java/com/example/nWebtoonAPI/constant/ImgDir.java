package com.example.nWebtoonAPI.constant;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class ImgDir {
	public static final String IMG_PATH = "/Users/zunza/nWebtoonAPI/images/cartoons/";

	public static void createFolder(String dirPath) {
		File Folder = new File(dirPath);
		Folder.mkdirs();
	}

	public static String saveImgFile(MultipartFile img, String filePath) throws IOException {

		String fileName = img.getOriginalFilename();
		UUID uuid = UUID.randomUUID();
		String resFileName = uuid + "_" + fileName;
		img.transferTo(new File(filePath + resFileName));

		return resFileName;
	}
}
