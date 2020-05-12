package cn.segema.cloud.filecenter.controller;

import java.math.BigDecimal;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import cn.segema.cloud.filecenter.domain.Filecenter;
import cn.segema.cloud.filecenter.repository.FilecenterRepository;
import cn.segema.cloud.filecenter.util.FileUtil;

/**
 * 文件中心接口
 */
@Controller
@RequestMapping(value = "/filecenter")
public class FilecenterController {
	@Autowired
	private FilecenterRepository filecenterRepository;
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${filecenter.local.directory}")
	private String filecenterLocalDirectory;
	
	

	@RequestMapping(value="/uploadfile", method = RequestMethod.GET)
    public String uploadFile() {
        //跳转到 templates 目录下的 uploadimg.html
        return "uploadfile";
    }

    //处理文件上传
    @RequestMapping(value="/uploadfile", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile file,
            HttpServletRequest request) {
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        System.out.println("fileName-->" + fileName);
        System.out.println("getContentType-->" + contentType);
        //String filePath = request.getSession().getServletContext().getRealPath("imgupload/");
        String filePath = filecenterLocalDirectory;
        
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
            
            Filecenter filecenter = new Filecenter();
            filecenter.setFileId(UUID.randomUUID().toString());
            filecenter.setFileName(fileName);
            filecenter.setFileType(contentType);
            filecenter.setRelativePath(fileName);
            filecenter.setSuffix(fileName.substring(fileName.lastIndexOf(".")));
            filecenter.setAbsolutePath(filePath+fileName);
            filecenter.setTotalSize(new BigDecimal(file.getSize()));
            filecenter.setFileContent(file.getBytes());
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "uploadimg success";
    }

}
