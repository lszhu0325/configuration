package com.lszhu0325.springconfig.service;

import com.lszhu0325.springconfig.entity.elasticsearch.User;

/**
 * Create by lenovo on 2020/4/10
 */
public interface UserServiceElasticsearch {

    /**
     * 保存用户
     * @return
     */
    User save(User user);

    /**
     * 查询用户
     * @param user
     * @return
     */
    User findById(User user);
}
