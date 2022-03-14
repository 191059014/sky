package com.hb.sky.cache.template;

import com.hb.sky.common.util.ObjectUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * redis缓存
 *
 * @author Mr.huang
 * @date 2022/3/10
 */
@Slf4j
public class SkyRedisTemplate extends StringRedisTemplate {

    public SkyRedisTemplate(RedisConnectionFactory connectionFactory) {
        super(connectionFactory);
    }

    /**
     * 获取缓存
     *
     * @param key 缓存key
     * @return 缓存值
     */
    public Object get(String key) {
        return opsForValue().get(key);
    }

    /**
     * 获取缓存
     *
     * @param key 缓存key
     * @return 缓存值
     */
    public String getString(String key) {
        return ObjectUtils.toString(get(key));
    }

    /**
     * 获取缓存
     *
     * @param key 缓存key
     * @return 缓存值
     */
    public Integer getInteger(String key) {
        return ObjectUtils.toInteger(get(key));
    }

    /**
     * 获取缓存
     *
     * @param key 缓存key
     * @return 缓存值
     */
    public Long getLong(String key) {
        return ObjectUtils.toLong(get(key));
    }

}
