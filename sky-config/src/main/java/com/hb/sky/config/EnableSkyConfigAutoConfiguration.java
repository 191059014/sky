package com.hb.sky.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 自动装配
 *
 * @author Mr.huang
 * @date 2022/2/25
 */
@Configuration
@ComponentScan(basePackages = "com.hb.sky.config")
@MapperScan(basePackages = "com.hb.sky.config.dao.mapper")
public class EnableSkyConfigAutoConfiguration {


}
