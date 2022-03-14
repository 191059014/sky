package com.hb.sky.log.support.filter;

import com.hb.sky.log.support.util.LogSupportUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * traceId的http处理过滤器
 *
 * @version v0.1, 2020/7/9 14:34, create by huangbiao.
 */
public class TraceIdHttpFilter extends OncePerRequestFilter {

    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TraceIdHttpFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String traceId = request.getHeader(LogSupportUtils.TRACE_ID);
        if (StringUtils.isEmpty(traceId)) {
            traceId = LogSupportUtils.generateTraceId();
        }
        MDC.put(LogSupportUtils.TRACE_ID, traceId);
        LOGGER.info("set traceId：{}", traceId);
        chain.doFilter(request, response);
    }

}

    