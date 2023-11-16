package com.briup.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: dmc(hjz)
 * @Date: 2023/11/15-11-15-20:54
 * @Description：com.briup.config
 */
@Configuration
public class MybatisPlusConfig {
    /**
     * mybatis-plus分页插件
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
//1 创建MybatisPlusInterceptor拦截器对象
        MybatisPlusInterceptor interceptor = new
                MybatisPlusInterceptor();
//2 添加分页拦截器
        interceptor.addInnerInterceptor(new
                PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
}
