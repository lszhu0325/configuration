package com.lszhu0325.springconfig.mapper;

import com.lszhu0325.springconfig.entity.mybatis.User;
import org.springframework.stereotype.Repository;

/**
 * Create by lenovo on 2020/4/9
 */
@Repository
public interface UserMapper {

    User findById(int id);
}
