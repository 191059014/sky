package com.hb.sky.admin;

import com.hb.sky.admin.config.ResourceFilter;
import com.hb.sky.common.util.FilterUtils;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 自动装配
 *
 * @author Mr.huang
 * @date 2022/2/25
 */
@Configuration
@ComponentScan(basePackages = "com.hb.sky.admin")
public class EnableSkyAdminAutoConfiguration {

    /**
     * 资源处理器
     */
    @Bean
    public FilterRegistrationBean resourceFilter() {
        return FilterUtils.build(new ResourceFilter(), "resourceFilter", 5000, "/*");
    }

}
