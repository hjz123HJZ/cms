package com.briup.config;

import com.briup.service.FileUploadService;
import com.briup.service.impl.FileUploadImpl;
import com.briup.service.impl.FileUploadImpl2;
import com.briup.util.QiniuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: dmc(hjz)
 * @Date: 2023/11/16-11-16-11:44
 * @Description：com.briup.config
 */
@Configuration
public class UploadFileConfig {
    // 按照指定条件放到容器中
    // upload:
    //  method: local/

//    private QiniuUtil qiniuUtil;
    @ConditionalOnProperty(prefix = "upload",name = "method",havingValue = "local")
    @Bean
    public FileUploadService localFileImpl(){
        return new FileUploadImpl();
    }


    @ConditionalOnProperty(prefix = "upload",name = "method",havingValue = "qiniu")
    @Bean
    public FileUploadService qiniuFileImpl(){
        return new FileUploadImpl2();
    }
}
