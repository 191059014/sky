package com.hb.sky.common.container;

import com.hb.sky.common.model.vo.DropdownVO;
import org.springframework.util.CollectionUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 下拉框容器注册
 *
 * @author Mr.huang
 * @date 2022/3/13
 */
public class DropdownRegister {

    /**
     * 下拉框容器
     */
    private static final Map<String, List<DropdownVO>> MAPS = new ConcurrentHashMap<>();

    /**
     * 注册
     *
     * @param id    下拉框标识
     * @param name  名称
     * @param value 值
     */
    public static void register(String id, String name, Object value) {
        List<DropdownVO> list = MAPS.get(id);
        if (CollectionUtils.isEmpty(list)) {
            list = new LinkedList<>();
            MAPS.put(id, list);
        }
        list.add(new DropdownVO(name, value));
    }

    /**
     * 通过标识获取下拉框列表
     *
     * @param id 标识
     * @return 下拉框列表
     */
    public static List<DropdownVO> get(String id) {
        return MAPS.get(id);
    }

}
