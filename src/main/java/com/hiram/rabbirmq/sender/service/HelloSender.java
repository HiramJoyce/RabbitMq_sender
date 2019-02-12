package com.hiram.rabbirmq.sender.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloSender {

    private final AmqpTemplate template;

    @Autowired
    public HelloSender(AmqpTemplate template) {
        this.template = template;
    }

    public void send() {
        /**
         * Direct模式
         */
//        template.convertAndSend("queue", "hello, rabbit~");
        /**
         * Topic模式
         */
//        template.convertAndSend("exchange", "topic.message", "hello, rabbit~");
        /**
         * Fanout模式
         */
        template.convertAndSend("fanoutExchange", "", "hello, rabbit~");    // 第二个参数会被忽略
    }
}
