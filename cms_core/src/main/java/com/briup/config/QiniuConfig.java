package com.briup.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Auther: dmc(hjz)
 * @Date: 2023/11/16-11-16-11:50
 * @Description：com.briup.config
 */
@Data
@Component

public class QiniuConfig {
    /**
     * OSS Access key
     */
    private String accessKey;
    /**
     * OSS Secret key
     */
    private String secretKey;
    /**
     * bucketName
     */
    private String bucket;
    /**
     * url地址,用于拼接 文件上传成功后回显的url
     */
    private String baseUrl;
}
