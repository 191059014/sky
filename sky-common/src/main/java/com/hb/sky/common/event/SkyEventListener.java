package com.hb.sky.common.event;

import java.util.EventListener;

/**
 * 事件监听器
 *
 * @author Mr.huang
 * @date 2022/3/12
 */
public interface SkyEventListener extends EventListener {

    /**
     * 处理事件
     *
     * @param event 事件
     */
    void handleEvent(SkyEvent event);

}
