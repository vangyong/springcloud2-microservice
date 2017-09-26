package cn.segema.cloud.filecenter.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import cn.segema.cloud.filecenter.config.FeignMultipartSupportConfig;

@FeignClient(name = "microservice-openAccount",configuration = FeignMultipartSupportConfig.class)
public interface OpenAccountFeignClient {
	
	 @RequestMapping(method = RequestMethod.POST, value = "/uploadIdCard",
			 		produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
			 		consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	    public ResponseEntity<?> uploadIdCard(@RequestPart(value = "file") MultipartFile file);

}
