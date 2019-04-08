package com.illusory.i.shop.service.redis.api;

/**
 * @author illusory
 * @version 1.0.0
 * @date 2019/4/8
 */
public interface RedisService {
    /**
     * 设置缓存
     */
    void set(String key, Object value);

    /**
     * 设置缓存
     *
     * @param seconds 超时时间
     */
    void set(String key, Object value, int seconds);

    /**
     * 删除缓存
     *
     * @param key
     */
    void del(String key);

    /**
     * 获取缓存
     */
    Object get(String key);
}
