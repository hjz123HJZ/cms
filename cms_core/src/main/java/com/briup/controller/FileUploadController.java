package com.briup.controller;

import com.briup.config.UploadFileConfig;
import com.briup.service.FileUploadService;
import com.briup.util.Result;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Auther: dmc(hjz)
 * @Date: 2023/11/16-11-16-14:12
 * @Description：com.briup.controller
 */
@ApiOperation("文件上传")
@RestController
@RequestMapping("/upload")
@RequiredArgsConstructor
public class FileUploadController {
    private final UploadFileConfig uploadFileConfig;
    @PostMapping("/local")
    public Result upload(@RequestPart MultipartFile file) throws Exception {
        FileUploadService fileUploadService = uploadFileConfig.localFileImpl();
        String path = fileUploadService.upload(file);
        return Result.success(path);
    }
    @PostMapping("/oss")
    public Result ossupload(@RequestPart MultipartFile file) throws Exception{
        FileUploadService fileUploadService = uploadFileConfig.qiniuFileImpl();
        String path = fileUploadService.upload(file);
        return Result.success(path);
    }
}
