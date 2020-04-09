package com.lszhu0325.springconfig.controller.redis;

import com.lszhu0325.springconfig.utils.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by lenovo on 2020/4/9
 */
@RestController
@RequestMapping(value = "/redisController")
public class RedisController {

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping(value = "/helloWorld", method = RequestMethod.POST)
    public String helloWorld() {
        redisUtils.set("key1", "value1");
        System.out.println(redisUtils.get("key1"));
        return "welcome to redisLettuce";
    }
}
