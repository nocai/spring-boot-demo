package com.example;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @auther: liujun10
 * @date: 2018/6/29 09:26
 * @version: 1.0
 */
@RestController
public class CacheController {
    @Resource
    private CacheService cacheService;

    @GetMapping("/{id}")
    public String get(@PathVariable("id") String id) {
        return this.cacheService.get(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") String id) {
        return this.cacheService.delete(id);
    }

    @PostMapping("/{id}")
    public String add(@PathVariable String id, String value) {
        return this.cacheService.save(id, value);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable String id, String value) {
        return this.cacheService.update(id, value);
    }
}
