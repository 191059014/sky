package com.hb.sky.common.model.dobj.impl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hb.sky.common.model.dobj.IBaseDO;
import com.hb.sky.common.model.dobj.IParentDO;
import com.hb.sky.common.model.dobj.ITenantDO;

/**
 * 数据模型超类
 *
 * @version v0.1, 2021-09-12 13:24:32, create by Mr.Huang.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public abstract class AbstractParentTenantDO extends AbstractBaseDO implements IBaseDO, IParentDO, ITenantDO {

    /**
     * 父级id
     */
    private Long parentId;

    /**
     * 租户ID
     */
    private Long tenantId;

    /**
     * 获取父级id
     */
    @Override
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父级id
     *
     * @param parentId 父级id
     */
    @Override
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Override
    public Long getTenantId() {
        return tenantId;
    }

    @Override
    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

}
