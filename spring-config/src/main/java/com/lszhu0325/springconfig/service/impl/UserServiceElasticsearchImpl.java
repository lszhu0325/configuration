package com.lszhu0325.springconfig.service.impl;

import com.lszhu0325.springconfig.entity.elasticsearch.User;
import com.lszhu0325.springconfig.repository.elasticsearch.UserRepository;
import com.lszhu0325.springconfig.service.UserServiceElasticsearch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Create by lenovo on 2020/4/10
 */
@Service
@Slf4j
public class UserServiceElasticsearchImpl implements UserServiceElasticsearch {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User save(User user) {
        log.info("elasticsearch测试开始");
        User user1 = userRepository.save(user);
        log.info("elasticsearch测试结束");
        return user1;
    }

    @Override
    public User findById(User user) {
        log.info("elasticsearch查询用户开始");
        Optional<User> optional = userRepository.findById(user.getId());
        log.info("elasticsearch查询用户结束");
        return optional.get();
    }
}
