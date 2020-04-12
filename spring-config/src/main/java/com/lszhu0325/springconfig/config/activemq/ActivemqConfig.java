package com.lszhu0325.springconfig.config.activemq;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * Create by lenovo on 2020/4/12
 */
@Configuration
@Slf4j
public class ActivemqConfig {
    public final static String TOPIC = "spring.topic.test";
    public final static String QUEUE = "spring.queue.test";

    @Bean(value = "spring.queue.test")
    public Queue queue() {
        return new ActiveMQQueue(QUEUE);
    }

    @Bean(value = "spring.topic.test")
    public Topic topic() {
        return new ActiveMQTopic(TOPIC);

    }

    /**
     * topic模式监听器
     * @param activeMQConnectionFactory
     * @return
     */
    @SuppressWarnings({"all"}) // 此处不知道为什么提示注入失败, 但是运行时成功, 故添加此注解
    @Bean
    public JmsListenerContainerFactory jmsListenerContainerFactoryTopic(ConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(activeMQConnectionFactory);
        return bean;
    }

    /**
     * queue模式监听器
     * @param activeMQConnectionFactory
     * @return
     */
    @SuppressWarnings({"all"}) // 此处不知道为什么提示注入失败, 但是运行时成功, 故添加此注解
    @Bean
    public JmsListenerContainerFactory jmsListenerContainerFactoryQueue(ConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setConnectionFactory(activeMQConnectionFactory);
        return bean;
    }
}
