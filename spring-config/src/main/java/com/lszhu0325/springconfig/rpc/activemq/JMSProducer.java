package com.lszhu0325.springconfig.rpc.activemq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * Create by lenovo on 2020/4/12
 */
@Service
@Slf4j
public class JMSProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(Destination destination, String message) {
        log.info("activemq发送消息...");
        jmsTemplate.convertAndSend(destination, message);
    }
}
