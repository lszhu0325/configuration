package com.lszhu0325.springcloudinstrantation2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class SpringCloudInstantiation2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudInstantiation2Application.class, args);
    }

}
