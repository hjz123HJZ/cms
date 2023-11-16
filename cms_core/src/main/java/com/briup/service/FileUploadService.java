package com.briup.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Auther: dmc(hjz)
 * @Date: 2023/11/16-11-16-11:29
 * @Description：com.briup.service
 */
public interface FileUploadService {
    String upload(MultipartFile file) throws Exception;
}
