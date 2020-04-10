package com.lszhu0325.springconfig.controller.elasticsearch;

import com.lszhu0325.springconfig.entity.elasticsearch.User;
import com.lszhu0325.springconfig.service.UserServiceElasticsearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by lenovo on 2020/4/10
 */
@RestController
@RequestMapping(value = "/elasticsearchController")
public class elasticsearchController {

    @Autowired
    private UserServiceElasticsearch userServiceElasticsearch;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Object save(@RequestBody User user) {
       return userServiceElasticsearch.save(user);
    }

    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    public Object findById(@RequestBody User user) {
        return userServiceElasticsearch.findById(user);
    }
}
