package cn.segema.cloud.filecenter.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@FeignClient("microservice-fileserver")
public interface FileServerService {

	@RequestMapping(value = "/file", method = RequestMethod.POST)
	public String fileUpload(@RequestParam("file") MultipartFile multipartFile,
							@RequestParam(value = "usage", required = false) String usage,
							@RequestParam(value = "sync", required = false, defaultValue = "false") boolean sync);

}
