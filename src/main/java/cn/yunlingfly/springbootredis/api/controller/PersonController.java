package cn.yunlingfly.springbootredis.api.controller;

import cn.yunlingfly.springbootredis.api.service.IPersonService;
import cn.yunlingfly.springbootredis.domain.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {
    @Autowired
    IPersonService personService;

    @RequestMapping(value = "/addOne")
    public String addOne(@RequestBody PersonEntity p) {
        return personService.insertOne(p);
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public PersonEntity findById(@PathVariable String id) {
        return personService.findById(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void update(@RequestBody PersonEntity personEntity) {
        personService.update(personEntity);
    }

    @RequestMapping(value = "/delete/{id}")
    public void delete(@PathVariable String id) {
        personService.delete(id);
    }

    @RequestMapping(value = "/test")
    public void test() {
        personService.test();
    }
}
