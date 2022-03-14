package com.hb.sky.common.model.dobj;

/**
 * 父子关系
 *
 * @version v0.1, 2020/9/16 9:44, create by huangbiao.
 */
public interface IParentDO {

    /**
     * 获取父级id
     */
    Long getParentId();

    /**
     * 设置父级id
     */
    void setParentId(Long parentId);

}
