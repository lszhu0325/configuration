package com.lszhu0325.springcloudinstrantiation1.controller;

import com.lszhu0325.springcloudinstrantiation1.rpc.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by lenovo on 2020/4/10
 */
@RestController
@RequestMapping(value = "/productController")
public class ProductController {

    @Autowired
    ConsumerService consumerService;

    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    public Object sendMessage() {
        String message = "product-1 接收到了消息...";
        System.out.println(message);
        return message;
    }

    @RequestMapping(value = "/consumerSendMessageTest", method = RequestMethod.POST)
    public Object consumerSendMessageTest() {
        while (true) {
            System.out.println(consumerService.fetchMessage());
        }
    }
}
