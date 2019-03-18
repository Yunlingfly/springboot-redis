package cn.yunlingfly.springbootredis.api.service.impl;

import cn.yunlingfly.springbootredis.api.service.IPersonService;
import cn.yunlingfly.springbootredis.domain.PersonEntity;
import cn.yunlingfly.springbootredis.infra.mapper.IPersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "persons")
public class PersonServiceImpl implements IPersonService {
    @Autowired
    IPersonMapper personMapper;

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Override
    public String insertOne(PersonEntity personEntity) {
        int i = personMapper.insert(personEntity);
        if (i != 0) return "success";
        else return "false";
    }

    @Cacheable(key = "#id")
    @Override
    public PersonEntity findById(String id) {
        System.out.println("findById");
        System.out.println(personMapper.findById(id));
        return personMapper.findById(id);
    }

    @CachePut(key = "#personEntity.id")
    @Override
    public PersonEntity update(PersonEntity personEntity) {
        System.out.println("updateById");
        personMapper.updateById(personEntity);
        return personMapper.findById(personEntity.getId());
    }

    @CacheEvict(key = "#id", allEntries = true)
    @Override
    public void delete(String id) {
        personMapper.deleteById(id);
    }

    @Override
    public void test() {
        //操作String类型的数据
        ValueOperations<String, String> valueStr = redisTemplate.opsForValue();
        //存储一条数据
        // 使用api操作，类似直接在redis上操作SET GET
        valueStr.set("yunlingfly", "芸灵fly");
        //获取一条数据并输出
        String goodsName = valueStr.get("yunlingfly");
        System.out.println(goodsName);
    }
}
