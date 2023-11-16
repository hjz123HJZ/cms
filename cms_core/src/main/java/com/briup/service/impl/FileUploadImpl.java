package com.briup.service.impl;

import com.briup.service.FileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Auther: dmc(hjz)
 * @Date: 2023/11/16-11-16-11:33
 * @Description：com.briup.service.impl
 */
@Slf4j
public class FileUploadImpl implements FileUploadService {
    @Override
    public String upload(@RequestPart MultipartFile file) throws IOException {
        //使用sl4fj打印日志,接收数据，包括文件
        log.info("接收参数 {}", file);
        String originalFilename = file.getOriginalFilename();
        System.out.println("originalFilename = " + originalFilename);
        byte[] bytes = originalFilename.getBytes();
        long size = file.getSize();
        log.info("文件内容的大小 {}", size);
        log.info("文件内容的字节数组 {}", bytes);
        //保存文件
        //相对路径 不行
        String path = "D:\\IDEA\\workplace\\cms\\cms_core\\file";
        //名字唯一处理
        String newFilename = getNewFilename(originalFilename);
        File file1 = new File(path, newFilename);
        if (file1.getParentFile().exists()) {
            file1.getParentFile().mkdirs();
        }
        file.transferTo(file1);

        return "http://localhost:80/file/" + newFilename;
    }

    //名字唯一处理，利用的是UUID处理
    private static String getNewFilename(String originalFilename) {
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
        String filename = UUID.randomUUID().toString() + substring;
        String newFilename = filename.replaceAll("-", "");
        return newFilename;
    }
}
