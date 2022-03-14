package com.hb.sky.config.dao.dobj;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.hb.sky.common.model.dobj.impl.AbstractBaseDO;

/**
 * 全局配置表数据模型
 *
 * @version v0.1, 2022-03-13 11:37:23, create by Mr.Huang.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class GlobalConfigDO extends AbstractBaseDO {

    /**
     * 系统名称
     */
    private String systemName;

    /**
     * 分组名称
     */
    private String groupName;

    /**
     * 配置标识
     */
    private String configKey;

    /**
     * 配置内容
     */
    private String configValue;

    /**
     * 备注
     */
    private String remark;

    /**
     * 有效状态
     */
    private Integer status;

}
