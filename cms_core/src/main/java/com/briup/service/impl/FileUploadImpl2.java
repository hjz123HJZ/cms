package com.briup.service.impl;

import com.briup.service.FileUploadService;
import com.briup.util.QiniuUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Auther: dmc(hjz)
 * @Date: 2023/11/16-11-16-11:46
 * @Description：com.briup.service.impl
 */
public class FileUploadImpl2 implements FileUploadService {
//    QiniuUtil qiniuUtil;
//    public FileUploadImpl2(QiniuUtil qiniuUtil){
//        this.qiniuUtil = qiniuUtil;
//    }
    @Override
    public String upload(MultipartFile file) throws Exception {
        String url = QiniuUtil.fileToOSS(file);
        return url;
    }
}
