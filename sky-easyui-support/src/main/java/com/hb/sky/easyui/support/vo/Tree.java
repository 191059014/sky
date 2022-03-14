package com.hb.sky.easyui.support.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 树形结构
 *
 * @author Mr.huang
 * @date 2022/3/14
 */
@Data
public class Tree {

    /**
     * 节点的 id
     */
    private Integer id;

    /**
     * 要显示的节点文本
     */
    private String text;

    /**
     * 节点状态，'open' 或 'closed'，默认是 'open'
     */
    private String state = "closed";

    /**
     * 指示节点是否被选中
     */
    private boolean checked = false;

    /**
     * 图标
     */
    private String iconCls;

    /**
     * 给一个节点添加的自定义属性
     */
    private Map<String, Object> attributes = new LinkedHashMap<>();

    /**
     * 子节点
     */
    private List<Tree> children = new ArrayList<>();

}
