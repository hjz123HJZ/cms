package com.briup;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Auther: dmc(hjz)
 * @Date: 2023/11/14-11-14-10:55
 * @Description：com.briup.cms
 */
@SpringBootApplication
@MapperScan("com.briup.dao")
public class CmsCoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(CmsCoreApplication.class, args);
    }
}
