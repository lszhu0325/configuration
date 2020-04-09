package com.lszhu0325.springconfig.utils.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Create by lenovo on 2020/4/8
 */
@Component
@Slf4j
public class RedisUtils {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private void printException(Exception e) {
        log.error("redis缓存服务器连异常");
        e.printStackTrace();
    }

    /**
     * 写入缓存
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key, String value) {
        boolean result = false;
        try {
            ValueOperations<String, Object> opertions = redisTemplate.opsForValue();
            opertions.set(key, value);
            result = true;
        } catch (Exception e) {
            printException(e);
        }
        return result;
    }

    /**
     * 设置时效时间
     * @param key
     * @param expireTime
     * @param timeUnit
     * @return
     */
    public boolean expire(String key, long expireTime, TimeUnit timeUnit) {
        return redisTemplate.expire(key, expireTime, timeUnit);
    }

    /**
     * 读取异常
     * @param key
     * @return
     */
    public Object get(String key) {
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        return operations.get(key);
    }

    /**
     * hash添加
     * @param key
     * @param hashKey
     * @param value
     * @return
     */
    public boolean hashSet(String key, Object hashKey, Object value) {
        boolean result = false;
        try {
            HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
            hash.put(key, hashKey, value);
            result = true;
        } catch (Exception e) {
            printException(e);
        }
        return result;
    }

    /**
     * hash获取
     * @param key
     * @param hashKey
     * @return
     */
    public Object hashGet(String key, Object hashKey) {
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        return hash.get(key, hashKey);
    }

    /**
     * list添加
     * @param key
     * @param value
     * @return
     */
    public boolean listPush(String key, Object value) {
        boolean result = false;
        try {
            ListOperations<String, Object> list = redisTemplate.opsForList();
            list.rightPush(key, value);
            result = true;
        } catch (Exception e) {
            printException(e);
        }
        return result;
    }

    /**
     * 从列表左侧弹出一个元素
     * @param key
     * @return
     */
    public Object listPop(String key) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        return list.leftPop(key);
    }

    /**
     * 列表获取
     * @param key
     * @param start
     * @param end
     * @return
     */
    public List<Object> listRange(String key, long start, long end) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        return list.range(key, start, end);
    }

    /**
     * set添加
     * @param key
     * @param value
     * @return
     */
    public boolean setAdd(String key, Object value) {
        boolean result = false;
        try {
            SetOperations<String, Object> set = redisTemplate.opsForSet();
            set.add(key, value);
            result = true;
        } catch (Exception e) {
            printException(e);
        }
        return result;
    }

    /**
     * 集合获取
     * @param key
     * @return
     */
    public Set<Object> setMembers(String key) {
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        return set.members(key);
    }

    /**
     * 有序集合添加
     * @param key
     * @param value
     * @param score
     * @return
     */
    public boolean zSetAdd(String key, Object value, double score) {
        boolean result = false;
        try {
            ZSetOperations<String, Object> zSet = redisTemplate.opsForZSet();
            zSet.add(key, value, score);
            result = true;
        } catch (Exception e) {
            printException(e);
        }
        return result;
    }

    /**
     * 有序集合获取
     * @param key
     * @param min
     * @param max
     * @return
     */
    public Set<Object> zSetRangeByScore(String key, double min, double max) {
        ZSetOperations<String, Object> zSet = redisTemplate.opsForZSet();
        return zSet.rangeByScore(key, min, max);
    }

    /**
     * 删除key
     * @param key
     * @return
     */
    public boolean delete(String key) {
        boolean result = false;
        try {
            result = redisTemplate.delete(key);
        } catch (Exception e) {
            printException(e);
        }
        return result;

    }

    /**
     * 批量删除key
     * @param keys
     * @return
     */
    public long delete(Collection<String> keys) {
        long result = 0L;
        try {
            result = redisTemplate.delete(keys);
        } catch (Exception e) {
            printException(e);
        }
        return result;
    }




}
