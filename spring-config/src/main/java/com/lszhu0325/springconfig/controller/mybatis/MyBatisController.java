package com.lszhu0325.springconfig.controller.mybatis;

import com.lszhu0325.springconfig.request.User.UserRequest;
import com.lszhu0325.springconfig.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by lenovo on 2020/4/9
 */
@RestController
@RequestMapping(value = "/myBatisController")
public class MyBatisController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    public Object findById(@RequestBody UserRequest userRequest) {
        return userService.findById(userRequest);
    }
}
