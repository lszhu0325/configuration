package com.lszhu0325.springcloudinstrantiation1.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Create by lenovo on 2020/4/10
 */
@FeignClient(value = "consumer", path = "/consumer")
public interface ConsumerService {

    @RequestMapping(value = "/consumerController/sendMessage", method = RequestMethod.POST)
    String fetchMessage();
}
