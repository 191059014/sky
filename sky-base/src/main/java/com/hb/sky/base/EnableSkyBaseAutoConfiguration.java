package com.hb.sky.base;

import com.hb.sky.base.filter.BlackListFilter;
import com.hb.sky.base.filter.CustomCorsFilter;
import com.hb.sky.base.filter.RequestFrequencyLimitFilter;
import com.hb.sky.common.util.FilterUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
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
@ComponentScan(basePackages = "com.hb.sky.base")
public class EnableSkyBaseAutoConfiguration {

    @Bean
    @ConditionalOnExpression("${sky.base.filter.blackList:false}")
    public FilterRegistrationBean blackListFilter() {
        return FilterUtils.build(new BlackListFilter(), -9500, "/*");
    }

    @Bean
    @ConditionalOnExpression("${sky.base.filter.requestFrequencyLimit:false}")
    public FilterRegistrationBean requestFrequencyLimitFilter() {
        return FilterUtils.build(new RequestFrequencyLimitFilter(), -9000, "/*");
    }

    @Bean
    @ConditionalOnExpression("${sky.base.filter.cors:false}")
    public FilterRegistrationBean customCorsFilter() {
        return FilterUtils.build(new CustomCorsFilter(), -8500, "/*");
    }

}
