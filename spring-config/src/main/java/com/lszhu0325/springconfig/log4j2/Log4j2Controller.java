package com.lszhu0325.springconfig.log4j2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by lenovo on 2020/4/8
 */
@RestController
@RequestMapping(value = "/log4j2Controller")
public class Log4j2Controller {

    @RequestMapping(value = "/helloWorld", method = RequestMethod.POST)
    public String helloWorld() {
        return "welcome to SpringBoot";
    }
}
