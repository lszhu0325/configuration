package com.lszhu0325.springconfig.log4j2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by lenovo on 2020/4/8
 */
@Slf4j
@RestController
@RequestMapping(value = "/log4j2LombokController")
public class Log4j2LombokController {

    @RequestMapping(value = "/helloWorld", method = RequestMethod.POST)
    public String helloWorld() {
        log.error("log4j2 with lombok 的测试");
        return "welcome to Log4j2 with lombok";
    }
}
