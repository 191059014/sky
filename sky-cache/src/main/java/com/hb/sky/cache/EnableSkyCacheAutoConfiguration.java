package com.hb.sky.cache;


import com.hb.sky.cache.template.SkyEhcacheTemplate;
import com.hb.sky.cache.template.SkyRedisTemplate;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.RedisConnectionFactory;

/**
 * 自动装配
 *
 * @author Mr.huang
 * @date 2022/2/25
 */
@Slf4j
@Configuration
public class EnableSkyCacheAutoConfiguration {

    /**
     * 资源处理器
     */
    @SneakyThrows
    @Bean
    public SkyEhcacheTemplate ehCacheManager() {
        ClassPathResource classPathResource = new ClassPathResource("/ehcache.xml");
        net.sf.ehcache.CacheManager cacheManager = net.sf.ehcache.CacheManager.create(classPathResource.getInputStream());
        SkyEhcacheTemplate skyEhcacheTemplate = new SkyEhcacheTemplate(cacheManager);
        log.info("SkyEhcacheTemplate is Created");
        return skyEhcacheTemplate;
    }

    /**
     * redis
     */
    @Bean
    @ConditionalOnExpression("${sky.cache.redis.enabled:false}")
    public SkyRedisTemplate redisCacheService(RedisConnectionFactory connectionFactory) {
        SkyRedisTemplate skyRedisTemplate = new SkyRedisTemplate(connectionFactory);
        log.info("SkyRedisTemplate is Created");
        return skyRedisTemplate;
    }

}
