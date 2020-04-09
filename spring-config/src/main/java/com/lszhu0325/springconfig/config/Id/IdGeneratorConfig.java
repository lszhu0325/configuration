package com.lszhu0325.springconfig.config.Id;

import com.lszhu0325.springconfig.utils.Id.IdGeneratorUtil;
import com.lszhu0325.springconfig.utils.Id.SnowflakeIdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Create by lenovo on 2020/4/9
 */
@Configuration
public class IdGeneratorConfig {

    @Value("${idGenerator.snowflakeIdGenerator.workerId}")
    private long workerId;

    @Value("${idGenerator.snowflakeIdGenerator.dataCenterid}")
    private long dataCenterId;

    @Bean(value = "snowflakeIdGeneratorUtil")
    public IdGeneratorUtil snowflakeIdGeneratorUtil() {
        return new SnowflakeIdGeneratorUtil(workerId, dataCenterId);
    }

}
