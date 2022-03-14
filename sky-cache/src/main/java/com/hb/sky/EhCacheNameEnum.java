package com.hb.sky;

import lombok.Getter;

/**
 * ehcache名称枚举类
 *
 * @author Mr.huang
 * @date 2022/3/13
 */
@Getter
public enum EhCacheNameEnum {

    /**
     * 全局配置缓存
     */
    GLOBAL_CONFIG("globalConfigCache", "全局配置缓存");

    /**
     * 缓存名称
     */
    private String name;

    /**
     * 秒数
     */
    private String desc;

    EhCacheNameEnum(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

}
