package com.hb.sky.config.enums;

import lombok.Getter;

/**
 * 配置是否有效状态枚举
 *
 * @author Mr.huang
 * @date 2022/3/13
 */
@Getter
public enum ConfigStatusEnum {

    /**
     * 有效
     */
    VALID(1, "有效"),

    /**
     * 无效
     */
    INVALID(0, "无效");

    private Integer value;
    private String desc;

    ConfigStatusEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

}
