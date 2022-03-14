package com.hb.sky.base.container;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 属性配置
 *
 * @author Mr.huang
 * @date 2022/3/11
 */
@Component
public class SkyApplicationProperties {

    /**
     * spring环境
     */
    private static Environment springEnv;

    public SkyApplicationProperties(Environment environment) {
        springEnv = environment;
    }


}
