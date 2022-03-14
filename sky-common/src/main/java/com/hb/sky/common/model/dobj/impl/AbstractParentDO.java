package com.hb.sky.common.model.dobj.impl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hb.sky.common.model.dobj.IBaseDO;
import com.hb.sky.common.model.dobj.IParentDO;

/**
 * 父子关系模型
 *
 * @author Mr.huang
 * @date 2022/3/11
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class AbstractParentDO extends AbstractBaseDO implements IBaseDO, IParentDO {

    /**
     * 父级id
     */
    private Long parentId;

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
}
