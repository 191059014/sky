package com.hb.sky.base.filter;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.RateLimiter;
import com.hb.sky.common.constant.ErrorCode;
import com.hb.sky.common.standard.Result;
import com.hb.sky.common.util.IpUtils;
import com.hb.sky.common.util.ServletUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * 请求频率限制，3秒钟达到10访问，意味着访问太频繁
 *
 * @version v0.1, 2021/9/19 23:00, create by huangbiao.
 */
@Slf4j
public class RequestFrequencyLimitFilter extends OncePerRequestFilter {

    /**
     * 限流器
     */
    private final LoadingCache<String, RateLimiter> rateLimiters = CacheBuilder.newBuilder()
            .maximumSize(10000)
            .expireAfterWrite(1, TimeUnit.DAYS)
            .build(new CacheLoader<String, RateLimiter>() {
                @Override
                public RateLimiter load(String key) throws Exception {
                    return RateLimiter.create(5);
                }
            });

    @SneakyThrows
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) {
        String ipAddress = IpUtils.getIpAddress(request);
        RateLimiter rateLimiter = rateLimiters.get(ipAddress);
        double rate = rateLimiter.getRate();
        log.info("Uri: {}, Method: {}, Frequency: {}", request.getRequestURI(), request.getMethod(), rate);
        if (!rateLimiter.tryAcquire()) {
            ServletUtils.writeJson(response, Result.fail(ErrorCode.REQUEST_TOO_FREQUENTLY, rate));
            return;
        }
        chain.doFilter(request, response);
    }

}
