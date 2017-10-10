package com.jinkor.controller;

import java.io.File;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jinkor.model.upload.UploadDTO;


@Controller
@RequestMapping("/fileLoad")
public class FileLoadController {

	private static final Logger logger = LoggerFactory.getLogger(FileLoadController.class);
	
	@RequestMapping("/toLoadPage")
	public String toPage() {
		return "index";
	}
	
	@RequestMapping("upload")
	@ResponseBody
	public UploadDTO upload(@RequestParam("filedata") MultipartFile file) {
		if (file.isEmpty()) {
			return UploadDTO.uploadfileNameIsNull();
		}
		//获取文件名
		String fileName = file.getOriginalFilename();
		logger.info("上传文件名为：{}",  fileName);
		
		//文件后缀名
		String suffixName = fileName.substring(fileName.lastIndexOf("."));
		logger.info("上传的后缀名为: {}", suffixName);
		
		//文件上传路径
		String filePath = "D:/springboot/fileupload/";
		
		//解决文件名字重复被替换问题
		fileName = UUID.randomUUID() + suffixName;
		logger.info("文件最终生成名：{}", fileName);
		
		File dest = new File(filePath + fileName);
		
		// 检查是否存在目录
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdirs();
		}
	
		try {
			file.transferTo(dest);
			return UploadDTO.uploadSuccess();
		} catch (Exception e) {
			logger.info("上传失败");
		}
		return UploadDTO.uploadFaild();
	}
}
