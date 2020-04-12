package com.lszhu0325.springconfig.rpc.activemq;

import com.lszhu0325.springconfig.config.activemq.ActivemqConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Create by lenovo on 2020/4/12
 */
@Component
@Slf4j
public class JMSConsumer {

    @JmsListener(destination = ActivemqConfig.QUEUE, containerFactory = "jmsListenerContainerFactoryQueue")
    public void receiveQueueMessage(String message) {
        log.info("activemq接收消息: " + ActivemqConfig.QUEUE + "------" + message);
    }

    @JmsListener(destination = ActivemqConfig.TOPIC, containerFactory = "jmsListenerContainerFactoryTopic")
    public void receiveTopicMessage(String message) {
        log.info("activemq接收消息" + ActivemqConfig.TOPIC + "------" + message);
    }
}
