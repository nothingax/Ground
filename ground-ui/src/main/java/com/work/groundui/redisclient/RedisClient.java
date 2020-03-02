package com.work.groundui.redisclient;


import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface RedisClient {

    // /**
    //  * 执行脚本
    //  */
    // Object eval(String script, List<String> keys, List<String> args);

    /**
     * get
     */
    <T> T get(String key);

    /**
     * set
     */
    void set(String key, Object value);

    /**
     * set
     */
    void set(String key, Object value, long expireTime, TimeUnit timeUnit);

    /**
     * setNX
     */
    Boolean setNX(String key, Object value);

    /**
     * 设置过期时间
     */
    Boolean expire(String key, long time, TimeUnit type);

    /**
     * 移除过期时间
     */
    Boolean persist(String key);

    /**
     * 增加
     */
    Long increment(String key, long number);

    /**
     * 增加
     */
    Double increment(String key, double number);

    /**
     * 删除
     */
    Boolean delete(String key);


    /**
     * 查询列表
     */
    List smembers(String key);

    /**
     * 批量获取
     */
    List pipeGet(List<String> keyList);

    Long sadd(String key, Object... member);

    Set<String> sinter(String... var1);

    Set<String> sunion(String... var1);

    List pipeMgetHash(Set<String> keys, String... fields);

    Long srem(String key, Object... member);
    // ==========================hash========================

    void hset(String key, String hashKey, Object value);

    void hsetAll(String key, Map<String, Object> map);

    Boolean hsetNX(String key, String hashKey, Object value);

    Object hget(String key, String hashKey);

    Map hgetAll(String key);
}
