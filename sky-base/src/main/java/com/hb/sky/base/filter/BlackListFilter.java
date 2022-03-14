package com.hb.sky.base.filter;

import com.hb.sky.EhCacheNameEnum;
import com.hb.sky.base.container.SkyApplicationContext;
import com.hb.sky.cache.template.SkyEhcacheTemplate;
import com.hb.sky.common.constant.ErrorCode;
import com.hb.sky.common.standard.Result;
import com.hb.sky.common.util.IpUtils;
import com.hb.sky.common.util.ServletUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * 黑名单拦截
 *
 * @version v0.1, 2021/9/21 16:36, create by huangbiao.
 */
public class BlackListFilter extends OncePerRequestFilter {

    private static final String ALLOW_ORIGINS = "sky.base.blackList.allowOrigins";
    private static final String NOT_ALLOW_IPS = "sky.base.blackList.notAllowIps";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        SkyEhcacheTemplate skyEhcacheTemplate = SkyApplicationContext.getBean(SkyEhcacheTemplate.class);
        // 校验源
        String allowOrigins = skyEhcacheTemplate.getString(EhCacheNameEnum.GLOBAL_CONFIG.getName(), ALLOW_ORIGINS);
        if (StringUtils.isNotBlank(allowOrigins)) {
            String[] allowOriginArr = allowOrigins.split(",");
            List<String> list = Arrays.asList(allowOriginArr);
            if (!list.contains(request.getRemoteHost())) {
                ServletUtils.writeJson(response, Result.fail(ErrorCode.INVALID_ORIGIN));
                return;
            }
        }
        // 校验ip
        String notAllowIps = skyEhcacheTemplate.getString(EhCacheNameEnum.GLOBAL_CONFIG.getName(), NOT_ALLOW_IPS);
        if (StringUtils.isNotBlank(notAllowIps)) {
            String[] notAllowIpArr = notAllowIps.split(",");
            List<String> list = Arrays.asList(notAllowIpArr);
            if (list.contains(IpUtils.getIpAddress(request))) {
                ServletUtils.writeJson(response, Result.fail(ErrorCode.INVALID_ORIGIN));
                return;
            }
        }
        // 最终放行
        chain.doFilter(request, response);
    }

}
