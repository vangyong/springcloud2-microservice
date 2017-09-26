package cn.segema.cloud.filecenter.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import feign.Feign;

public class UploadService {
	
//	@Value("${commons.file.upload-url}")
//	private String HTTP_FILE_UPLOAD_URL;//此处配置上传文件接口的域名(http(s)://XXXXX.XXXXX.XX)
//
//	public String uploadFile(MultipartFile file, String usage, boolean sync){
//	FileUploadResource fileUploadResource = Feign.builder()
//			.encoder(new FeignSpringFormEncoder())
//			.target(FileUploadResource.class, HTTP_FILE_UPLOAD_URL);
//	return fileUploadResource.fileUpload(file, usage, sync);
//	}

}
