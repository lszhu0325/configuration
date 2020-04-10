package com.lszhu0325.springconfig.service;

import com.lszhu0325.springconfig.request.User.UserRequest;

/**
 * Create by lenovo on 2020/4/9
 */
public interface UserServiceMabatis {

    /**
     * 查询用户
     * @param userRequest
     * @return
     */
    public Object findById(UserRequest userRequest);
}
