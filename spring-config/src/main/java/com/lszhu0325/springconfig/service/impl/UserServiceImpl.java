package com.lszhu0325.springconfig.service.impl;

import com.lszhu0325.springconfig.entity.User;
import com.lszhu0325.springconfig.mapper.UserMapper;
import com.lszhu0325.springconfig.request.User.UserRequest;
import com.lszhu0325.springconfig.response.userResponse.UserResponse;
import com.lszhu0325.springconfig.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by lenovo on 2020/4/9
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public Object findById(UserRequest userRequest) {
        log.info("mybatis测试");
        User user = userMapper.findById(userRequest.getId());
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setPassword(user.getPassword());
        log.info("mybatis测试结束");
        return response;
    }
}
