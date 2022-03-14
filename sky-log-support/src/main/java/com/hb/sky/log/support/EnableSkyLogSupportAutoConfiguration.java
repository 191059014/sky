package com.hb.sky.log.support;

import com.hb.sky.common.util.FilterUtils;
import com.hb.sky.log.support.filter.TraceIdFeignInterceptor;
import com.hb.sky.log.support.filter.TraceIdHttpFilter;
import feign.RequestInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自动装配
 *
 * @author Mr.huang
 * @date 2022/2/25
 */
@Configuration
public class EnableSkyLogSupportAutoConfiguration {

    @Bean
    @ConditionalOnExpression("${sky.log.support.traceid.http:true}")
    public FilterRegistrationBean traceIdHttpFilter() {
        return FilterUtils.build(new TraceIdHttpFilter(), -10000, "/*");
    }

    @Bean
    @ConditionalOnExpression("${sky.log.support.traceid.feign:false}")
    public RequestInterceptor traceIdFeignInterceptor() {
        return new TraceIdFeignInterceptor();
    }

}
