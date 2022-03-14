package com.hb.sky.log.support.filter;

import com.alibaba.dubbo.rpc.*;
import com.hb.sky.log.support.util.LogSupportUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.util.StringUtils;

/**
 * traceId的dubbo处理方式
 *
 * @version v0.1, 2020/7/9 15:16, create by huangbiao.
 */
public class TraceIdDubboFilter implements Filter {

    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TraceIdDubboFilter.class);

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        RpcContext rpcContext = RpcContext.getContext();
        String traceId = "";
        if (rpcContext.isConsumerSide()) {
            traceId = MDC.get(LogSupportUtils.TRACE_ID);
            RpcContext.getContext().setAttachment(LogSupportUtils.TRACE_ID, traceId);
            LOGGER.info("set consumer traceId：{}", traceId);
        }
        if (rpcContext.isProviderSide()) {
            traceId = RpcContext.getContext().getAttachment(LogSupportUtils.TRACE_ID);
            if (StringUtils.isEmpty(traceId)) {
                traceId = LogSupportUtils.generateTraceId();
            }
            MDC.put("traceId", traceId);
            LOGGER.info("set provider traceId：{}", traceId);
        }
        return invoker.invoke(invocation);
    }
}

    