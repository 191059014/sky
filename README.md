# sky基础平台
基础框架平台，整合了一些适用、好用的小工具，为搭建项目提高效率。
## sky-common 常用工具类模块
- com.hb.unic.util.util.BigDecimalUtils
- com.hb.unic.util.util.CloneUtils
- com.hb.unic.util.util.CompressUtils
- com.hb.unic.util.util.DateUtils
- com.hb.unic.util.util.EnumUtils
- com.hb.unic.util.util.GroovyUtils
- com.hb.unic.util.util.HexByteArrUtils
- com.hb.unic.util.util.OkHttpUtils
- com.hb.unic.util.util.PageUtils
- com.hb.unic.util.util.RandomUtils
- com.hb.unic.util.util.ReflectUtils
- com.hb.unic.util.util.StrUtils
- com.hb.unic.util.util.UuidUtils
- com.hb.unic.util.util.YamlUtils
## sky-base 基础模块
- spring的工具类SpringUtils，可以获取所有bean实例
- 标准全局异常StandardRuntimeException
- 公共响应模型ResponseData，以及生成ResponseData的工具类ResponseUtils
- 基于spring注解@Async的异步调用接口IServiceExecutorService
- 基于javaconfig，扫描路径为“classpath*:config/service-*-config.yml”全局配置类GlobalProperties
- 基于xml，扫描路径为“classpath*:config/service-*-config.yml”下的所有配置信息

## sky-configcenter 配置中心模块

## sky-cache 缓存模块
### 标准缓存操作接口ICacheService
- 默认的本地缓存工具类DefaultLocalCacheServiceImpl
- 基于redis的缓存工具类RedisCacheServiceImpl  
其中：
- 开启默认的本地缓存配置：sky.cache.local.default.enabled，默认false
- 开启redis的缓存配置：sky.cache.redis.enabled，默认false

## sky-log-support 日志支持
- 开启http调用的traceId处理配置：sky.log.support.traceid.http，默认true
- 开启feign调用的traceId处理配置：sky.log.support.traceid.feign，默认false
