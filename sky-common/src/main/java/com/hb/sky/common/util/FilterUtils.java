package com.hb.sky.common.util;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

import javax.servlet.Filter;

/**
 * filter工具类
 *
 * @version v0.1, 2021/9/3 23:45, create by huangbiao.
 */
@Slf4j
public class FilterUtils {

    /**
     * the constant logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(FilterUtils.class);

    /**
     * 构建简单的filter
     *
     * @param filter      具体的filter
     * @param urlPatterns 拦截路径
     * @param order       顺序
     * @return FilterRegistrationBean
     */
    public static FilterRegistrationBean build(Filter filter, int order, String... urlPatterns) {
        // 过滤器名称
        String classSimpleName = filter.getClass().getSimpleName();
        String filterName = classSimpleName.substring(0, 1).toLowerCase() + classSimpleName.substring(1);
        return build(filter, filterName, order, urlPatterns);
    }

    /**
     * 构建简单的filter
     *
     * @param filter      具体的filter对象
     * @param filterName  过滤器名称
     * @param urlPatterns 拦截路径
     * @param order       顺序
     * @return FilterRegistrationBean
     */
    public static FilterRegistrationBean build(Filter filter, String filterName, int order, String... urlPatterns) {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(filter);
        // 过滤器名称
        registration.setName(filterName);
        // 是否自动注册
        registration.setEnabled(true);
        // 拦截顺序
        registration.setOrder(order);
        // 拦截url
        registration.addUrlPatterns(urlPatterns);
        LOGGER.info("{} register complete, urlPatterns: [{}], order: {}", filterName, urlPatterns, order);
        return registration;
    }

}
