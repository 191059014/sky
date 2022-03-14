package com.hb.sky.common.model.dobj.impl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hb.sky.common.model.dobj.IBaseDO;
import com.hb.sky.common.model.dobj.ITenantDO;

/**
 * 数据模型超类
 *
 * @version v0.1, 2021-09-12 13:24:32, create by Mr.Huang.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public abstract class AbstractTenantDO extends AbstractBaseDO implements IBaseDO, ITenantDO {

    /**
     * 租户ID
     */
    private Long tenantId;

    @Override
    public Long getTenantId() {
        return tenantId;
    }

    @Override
    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

}
