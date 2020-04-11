package com.lszhu0325.springcloudconfig1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by lenovo on 2020/4/11
 */
@RestController
@RequestMapping(value = "/configController")
public class ConfigController {

    @RequestMapping(value = "/helloWorld")
    public Object helloWorld() {
        String message = "welcome to spring-cloud-config-1";
        System.out.println(message);
        return message;
    }
}
