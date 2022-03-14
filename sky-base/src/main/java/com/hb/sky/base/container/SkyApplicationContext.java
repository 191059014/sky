package com.hb.sky.base.container;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 上下文
 *
 * @version v0.1, 2021/9/21 18:08, create by huangbiao.
 */
@Component
public class SkyApplicationContext implements ApplicationContextAware {

    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SkyApplicationContext.class);

    /**
     * spring上下文
     */
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SkyApplicationContext.applicationContext == null) {
            LOGGER.info("set applicationContext complete");
            SkyApplicationContext.applicationContext = applicationContext;
        }
    }

    /**
     * 获取spring上下文
     *
     * @return applicationContext
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 通过class获取Bean
     *
     * @param clazz bean的class
     * @param <T>   bean类型
     * @return bean对象
     */
    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    /**
     * 通过name,以及class返回指定的Bean
     *
     * @param name  bean名称
     * @param clazz bean的class
     * @param <T>   bean类型
     * @return bean对象
     */
    public static <T> T getBean(String name, Class<T> clazz) {
        return applicationContext.getBean(name, clazz);
    }

    /**
     * 通过class获取Bean集合
     *
     * @param clazz bean的class
     * @param <T>   bean类型
     * @return bean对象
     */
    public static <T> Map<String, T> getBeansOfType(Class<T> clazz) {
        return applicationContext.getBeansOfType(clazz);
    }

}
