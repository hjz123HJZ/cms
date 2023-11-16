package com.briup.mp.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: dmc(hjz)
 * @Date: 2023/11/14-11-14-16:21
 * @Description：com.briup.mp.config
 */
@Configuration
public class MybatisPlusConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
//1 创建MybatisPlusInterceptor拦截器对象
        MybatisPlusInterceptor mpInterceptor = new
                MybatisPlusInterceptor();
//2 添加分页拦截器
        mpInterceptor.addInnerInterceptor(new
                PaginationInnerInterceptor());
        return mpInterceptor;
    }
}
