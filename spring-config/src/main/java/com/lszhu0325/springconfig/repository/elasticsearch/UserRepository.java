package com.lszhu0325.springconfig.repository.elasticsearch;

import com.lszhu0325.springconfig.entity.elasticsearch.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Create by lenovo on 2020/4/10
 */
public interface UserRepository extends ElasticsearchRepository<User, Long> {
}
