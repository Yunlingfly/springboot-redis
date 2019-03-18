package cn.yunlingfly.springbootredis.api.service;

import cn.yunlingfly.springbootredis.domain.PersonEntity;

public interface IPersonService {
    String insertOne(PersonEntity personEntity);

    PersonEntity findById(String id);

    PersonEntity update(PersonEntity personEntity);

    void delete(String id);

    void test();
}
