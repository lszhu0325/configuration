package com.lszhu0325.springconfig.controller.activemq;

import com.lszhu0325.springconfig.service.ActivemqService;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by lenovo on 2020/4/12
 */
@RestController
@Slf4j
@RequestMapping(value = "/activemqController")
public class ActivemqController {

    @Autowired
    private ActivemqService activemqService;

    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    public Object sendMessage() {
        return activemqService.sendMessage();
    }
}
