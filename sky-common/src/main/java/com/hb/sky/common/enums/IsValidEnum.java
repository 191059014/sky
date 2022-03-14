package com.hb.sky.common.enums;

import lombok.Getter;

/**
 * 逻辑删除状态枚举
 *
 * @author Mr.huang
 * @date 2022/3/13
 */
@Getter
public enum IsValidEnum {

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

    IsValidEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

}
