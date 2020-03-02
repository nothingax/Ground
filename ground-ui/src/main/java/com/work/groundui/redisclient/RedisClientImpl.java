package com.work.groundui.redisclient;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component("redisClient")
public class RedisClientImpl implements RedisClient {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    // @Override
    // public Object eval(String script, List<String> keys, List<String> args) {
    //      TODO
    //     return null;
    // }

    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void set(String key, Object value, long expireTime, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, expireTime, timeUnit);
    }

    @Override
    public Boolean setNX(String key, Object value) {
        return redisTemplate.opsForValue().setIfAbsent(key, value);
    }

    @Override
    public Boolean expire(String key, long time, TimeUnit timeUnit) {
        return redisTemplate.boundValueOps(key).expire(time, timeUnit);
    }

    @Override
    public Boolean persist(String key) {
        return redisTemplate.boundValueOps(key).persist();
    }

    @Override
    public Long increment(String key, long number) {
        return redisTemplate.opsForValue().increment(key, number);
    }

    @Override
    public Double increment(String key, double number) {
        return redisTemplate.opsForValue().increment(key, number);
    }

    @Override
    public Boolean delete(String key) {
        return redisTemplate.delete(key);
    }

    @Override
    public List smembers(String key) {
        // TODO
        return null;
    }

    @Override
    public List pipeGet(List<String> keyList) {
        // TODO
        return null;
    }

    @Override
    public Long sadd(String key, Object... member) {
        // TODO
        return null;
    }

    @Override
    public Set<String> sinter(String... keys) {
        return null;
    }

    @Override
    public Set<String> sunion(String... var1) {
        return null;
    }

    @Override
    public List pipeMgetHash(Set<String> keys, String... fields) {
        return null;
    }

    @Override
    public Long srem(String key, Object... member) {
        return null;
    }

    @Override
    public void hset(String key, String hashKey, Object value) {
        redisTemplate.opsForHash().put(key, hashKey, value);
    }

    @Override
    public void hsetAll(String key, Map<String, Object> map) {
        redisTemplate.opsForHash().putAll(key, map);
    }

    @Override
    public Boolean hsetNX(String key, String hashKey, Object value) {
        return redisTemplate.opsForHash().putIfAbsent(key, hashKey, value);
    }

    @Override
    public Object hget(String key, String hashKey) {
        return redisTemplate.opsForHash().get(key, hashKey);
    }

    @Override
    public Map hgetAll(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

}
