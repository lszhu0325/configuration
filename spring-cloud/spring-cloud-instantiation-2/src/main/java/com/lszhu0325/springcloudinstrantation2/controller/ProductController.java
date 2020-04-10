package com.lszhu0325.springcloudinstrantation2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by lenovo on 2020/4/10
 */
@RestController
@RequestMapping(value = "/productController")
public class ProductController {

    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    public Object sendMessage() {
        String message = "product-2 接收到了消息...";
        System.out.println(message);
        return message;
    }
}
