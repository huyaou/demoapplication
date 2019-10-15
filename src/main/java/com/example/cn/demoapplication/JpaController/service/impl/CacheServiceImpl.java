package com.example.cn.demoapplication.JpaController.service.impl;

import com.example.cn.demoapplication.JpaController.service.ICacheService;
import com.example.cn.demoapplication.common.User;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;


@Service
/**
 * 缓存的对象必须实现序列化接口
 *
 * 统一配置缓存的value为users
 * 如果方法上指定了缓存名，则使用定义的
 * 没有，则使用配置的
 */
@CacheConfig(cacheNames = {"users"})
public class CacheServiceImpl implements ICacheService {

    /**
     * 测试缓存
     * value 缓存的名称 可定义多个 {"key1", "key2"}
     * key 缓存的key
     * condition 缓存的条件 可以为空 返回true或false
     * unless 否定缓存 当条件结果为true时 不会缓存
     * @param uid
     * @return
     */
    @Override
    @Cacheable(value = "users", key = "#uid")
    public Integer testCache(Integer uid) {
        System.out.println("执行方法体..." + uid);
        return uid;
    }

    /**
     * key 清空指定的缓存
     * allEntries = true 清空所有的缓存
     * beforeInvocation = true 在调用方法前清空缓存
     * @param uid
     */
    @Override
    @CacheEvict(value = "users", key = "#uid")
    public void delete(Integer uid) {
        System.out.println("删除uid：" + uid + " 的缓存...");
    }

    /**
     * 与@Cacheable类似，但是会把方法的返回值放入缓存中，主要用于新增和修改方法
     * @param uid
     * @return
     */
    @Override
    @CachePut(value = "users", key = "#uid")
    public Integer save(Integer uid) {
        System.out.println("保存uid:" + uid + " 的缓存...");
        return uid;
    }

    @Override
    @CachePut(value = "users", key = "#user.name+#user.uid")
    public Object saveUser(User user) {
        System.out.println("保存对象到缓存..." + user.getName());
        return user;
    }

    /**
     * 以name和uid作为key
     * 结果为null时，不存入缓存
     * @param name
     * @param uid
     * @return
     */
    @Override
    @Cacheable(value = "users", key = "#name+#uid",unless = "#result==null")
    public User queryUserByName(String name, Integer uid) {
        System.out.println("查询缓存中'" + name + "'的缓存...");
        return new User();
    }

    /**
     * @Caching 是Cacheable、CachePut、CacheEvict的组合注解
     * 可以同时实现组合功能
     * @return
     */
    @Caching(cacheable = {@Cacheable(key = "")},
                put = {@CachePut(key = "")},
                evict = {@CacheEvict(key = "")})
    public Object testCaching() {
        return null;
    }
}
