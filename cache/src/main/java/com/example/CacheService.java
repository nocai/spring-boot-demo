package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther: liujun10
 * @date: 2018/6/29 09:27
 * @version: 1.0
 */
@Service
public class CacheService {
    private static final Logger logger = LoggerFactory.getLogger(CacheService.class);
    private final Map<String, String> enties = new HashMap<>();

    @Autowired
    private CacheManager cacheManager;

    @Cacheable(cacheNames = "t")
    public String get(String id) {
        long time = System.currentTimeMillis();
        logger.info("The cacheManager is " + this.cacheManager);

        logger.info("Get value by id = {}, the time is {}", id, time);

        return "Get value by id = " + id + ", the value is " + enties.get(id);
    }

    @CacheEvict(cacheNames = "t")
    public String delete(String id) {
        return this.enties.remove(id);
    }

    @CachePut(cacheNames = "t", key = "#id")
    public String save(String id, String value) {
        logger.info("save value. id = {}, value = {}", id, value);
        this.enties.put(id, value);
        return value;
    }

    @CachePut(cacheNames = "t", key = "#id")
    public String update(String id, String value) {
        return enties.put(id, value);
    }
}
