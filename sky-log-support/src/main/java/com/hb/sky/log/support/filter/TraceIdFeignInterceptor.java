package com.hb.sky.log.support.filter;

import com.hb.sky.log.support.util.LogSupportUtils;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * TraceId的Feign处理
 *
 * @version v0.1, 2020/7/9 15:27, create by huangbiao.
 */
public class TraceIdFeignInterceptor implements RequestInterceptor {

    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TraceIdFeignInterceptor.class);

    @Override
    public void apply(RequestTemplate requestTemplate) {
        String traceId = MDC.get(LogSupportUtils.TRACE_ID);
        LOGGER.info("set traceId：{}", traceId);
        requestTemplate.header(LogSupportUtils.TRACE_ID, traceId);
    }

}

    