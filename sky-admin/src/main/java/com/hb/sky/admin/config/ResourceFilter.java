package com.hb.sky.admin.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * 资源处理
 *
 * @author Mr.huang
 * @date 2022/2/28
 */
@Slf4j
public class ResourceFilter extends OncePerRequestFilter {

    /**
     * 文本资源类型集合
     */
    private static final List<String> TEXT_TYPES = Arrays.asList("html", "js", "css", "json");

    /**
     * 媒体资源类型集合
     */
    private static final List<String> MEDIA_TYPES = Arrays.asList("gif", "png");

    /**
     * web页面根目录
     */
    private static final String WEB_ROOT_URI = "/skyadmin";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String requestUri = request.getRequestURI();
        requestUri = disposeUri(requestUri);
        if (!requestUri.startsWith(WEB_ROOT_URI)) {
            chain.doFilter(request, response);
            return;
        }
        ResourcesHandler resourcesHandler = getResourcesStrategy(requestUri);
        resourcesHandler.render(requestUri, response);
    }

    /**
     * 处理uri
     *
     * @param requestUri 原始的uri
     * @return 处理后的uri
     */
    private String disposeUri(String requestUri) {
        if ("/".equals(requestUri)) {
            requestUri = WEB_ROOT_URI + "/index.html";
        }
        return requestUri;
    }

    /**
     * 获取资源处理器
     *
     * @param requestUri 请求uri
     * @return 资源处理器
     */
    private ResourcesHandler getResourcesStrategy(String requestUri) {
        ResourcesHandler resourcesHandler = null;
        String suffix = requestUri.substring(requestUri.lastIndexOf(".") + 1);
        if (TEXT_TYPES.contains(suffix)) {
            resourcesHandler = new TextResourcesHandler();
        } else if (MEDIA_TYPES.contains(suffix)) {
            resourcesHandler = new MediaResourcesHandler();
        } else {
            throw new RuntimeException("NoResourcesHandler");
        }
        return resourcesHandler;
    }

    /**
     * 资源处理接口
     */
    interface ResourcesHandler {

        /**
         * 渲染页面
         *
         * @param requestUri 请求uri
         * @param response   响应
         */
        void render(String requestUri, HttpServletResponse response) throws IOException;
    }

    /**
     * 文本资源处理器
     */
    class TextResourcesHandler implements ResourcesHandler {


        @Override
        public void render(String requestUri, HttpServletResponse response) throws IOException {
            ClassPathResource classPathResource = new ClassPathResource(requestUri);
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(FileUtils.readFileToString(classPathResource.getFile(), "UTF-8"));
        }
    }

    /**
     * 媒体资源处理器
     */
    class MediaResourcesHandler implements ResourcesHandler {

        @Override
        public void render(String requestUri, HttpServletResponse response) throws IOException {
            ClassPathResource classPathResource = new ClassPathResource(requestUri);
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(FileUtils.readFileToByteArray(classPathResource.getFile()));
        }
    }

}
