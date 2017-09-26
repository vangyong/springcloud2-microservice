package cn.segema.cloud.filecenter.service;

import org.springframework.web.multipart.MultipartFile;

import feign.Param;
import feign.RequestLine;

public interface FileUploadResource {

	@RequestLine("POST /file")
	String fileUpload(@Param("file") MultipartFile file, @Param("usage") String usage, @Param("sync") boolean sync);
}
