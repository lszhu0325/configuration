package com.lszhu0325.springconfig.service.impl;

import com.lszhu0325.springconfig.rpc.activemq.JMSProducer;
import com.lszhu0325.springconfig.service.ActivemqService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * Create by lenovo on 2020/4/12
 */
@Service
public class ActivemqServiceImpl implements ActivemqService {

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    @Autowired
    private JMSProducer jmsProducer;

    @Override
    public boolean sendMessage() {
        Destination destination = new ActiveMQQueue("spring.queue.test");
        for (int i = 0; i < 10 ; i++) {
            jmsProducer.sendMessage(queue, "spring.queue.test ------" + i);
            jmsProducer.sendMessage(topic, "spring.topic.test ------" + i);
        }
        return true;
    }
}
