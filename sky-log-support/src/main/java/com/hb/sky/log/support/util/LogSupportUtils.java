package com.hb.sky.log.support.util;

import java.util.UUID;

/**
 * 工具类
 *
 * @author Mr.huang
 * @date 2022/3/10
 */
public class LogSupportUtils {

    /**
     * traceId名称
     */
    public static final String TRACE_ID = "traceId";

    /**
     * 生成trace_id
     *
     * @return trace_id
     */
    public static String generateTraceId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
