package com.hb.sky.cache.template;

import lombok.extern.slf4j.Slf4j;
import net.sf.ehcache.CacheManager;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.util.Assert;

/**
 * 本地缓存
 *
 * @author Mr.huang
 * @date 2022/3/10
 */
@Slf4j
public class SkyEhcacheTemplate extends EhCacheCacheManager {

    public SkyEhcacheTemplate(CacheManager cacheManager) {
        super(cacheManager);
    }

    /**
     * 放入缓存值
     *
     * @param cacheName 缓存名称
     * @param key       键
     * @param value     值
     */
    public void put(String cacheName, Object key, Object value) {
        Cache cache = getCache(cacheName);
        Assert.isTrue(cache != null, "CacheNotExist, cacheName: " + cacheName);
        cache.put(key, value);
    }

    /**
     * 获取缓存
     *
     * @param cacheName 缓存名称
     * @param key       缓存key
     * @return 缓存值
     */
    public <T> T getObject(String cacheName, Object key, Class<T> clazz) {
        Cache cache = getCache(cacheName);
        return cache == null ? null : cache.get(key, clazz);
    }

    /**
     * 获取缓存
     *
     * @param cacheName 缓存名称
     * @param key       缓存key
     * @return 缓存值
     */
    public String getString(String cacheName, Object key) {
        Cache cache = getCache(cacheName);
        return cache == null ? null : cache.get(key, String.class);
    }

}
