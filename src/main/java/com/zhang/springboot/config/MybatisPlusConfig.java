package com.zhang.springboot.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zhangxinrun(OS - > zhang)
 * @Date 2021/4/25 23:30
 * @Version 1.0
 * @Description mybatisPlus配置
 */
@Configuration
@MapperScan("com.zhang.springboot.business")
public class MybatisPlusConfig {

    /**
     * 分页插件，自动识别数据库类型
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
