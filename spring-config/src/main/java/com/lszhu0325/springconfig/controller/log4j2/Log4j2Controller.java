package com.lszhu0325.springconfig.controller.log4j2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by lenovo on 2020/4/8
 */
@RestController
@RequestMapping(value = "/log4j2Controller")
public class Log4j2Controller {

    private static final Logger logger = LoggerFactory.getLogger(Log4j2Controller.class);

    @RequestMapping(value = "/helloWorld", method = RequestMethod.POST)
    public String helloWorld() {
        logger.error("测试log4j2日志配置是否成功");
        return "welcome to Log4j2";
    }
}
