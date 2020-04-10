package com.lszhu0325.springcloudinstrantation3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class SpringCloudInstantiation3Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudInstantiation3Application.class, args);
    }

}
