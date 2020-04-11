package com.lszhu0325.springcloudinstrantiation1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by lenovo on 2020/4/11
 */
@RestController
@RequestMapping(value = "/configController")
public class ConfigController {

    @Value("${config.version}")
    String version;

    @RequestMapping(value = "/getConfigVersion", method = RequestMethod.POST)
    public String getConfigVersion() {
        System.out.println("配置版本是否更新...");
        return version;
    }
}
