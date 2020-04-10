package com.lszhu0325.springconfig.controller.id;

import com.lszhu0325.springconfig.utils.Id.IdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by lenovo on 2020/4/9
 */
@RestController
@RequestMapping(value = "/idGeneratorController")
public class IdGeneratorController {

    @Autowired
    @Qualifier(value = "snowflakeIdGeneratorUtil")
    IdGeneratorUtil idGeneratorUtil;

    @RequestMapping(value = "/idGeneratorTest", method = RequestMethod.POST)
    public void idGeneratorTest() {
        for (int i = 0; i < 10; i++) {
            System.out.println(idGeneratorUtil.nextId());
        }
    }
}
