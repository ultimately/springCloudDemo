package com.levlin.controller;

import com.levlin.config.RabbitConfig;
import com.levlin.model.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.AbstractJavaTypeMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @Author: levlin
 * @Date: 2018/8/27
 * @version: 1.0
 * @Description:
 */
@RestController
@RequestMapping("/api")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final RabbitTemplate rabbitTemplate;


    public UserController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping(value = "/sendUserMessageDamo")
    public void sendUserMessageDamo() {
        Users users = new Users();
        users.setId(1);
        users.setCnname("2");
        users.setMobilePhone("3");
        users.setUsername("4");
        this.rabbitTemplate.convertAndSend(RabbitConfig.REGISTER_DELAY_EXCHANGE,
                RabbitConfig.DELAY_ROUTING_KEY, users, message -> {
            // TODO 第一句是可要可不要,根据自己需要自行处理
            message.getMessageProperties().setHeader(AbstractJavaTypeMapper.DEFAULT_CONTENT_CLASSID_FIELD_NAME,
                    Users.class.getName());
            // TODO 如果配置了 params.put("x-message-ttl", 5 * 1000);
            // TODO 那么这一句也可以省略,具体根据业务需要是声明 Queue 的时候就指定好延迟时间还是在发送自己控制时间
            message.getMessageProperties().setExpiration(5 * 10000 + "");
            return message;
        });
        log.info("[发送时间1] - [{}]", LocalDateTime.now());
    }

    @GetMapping(value = "/sendUserMessage")
    public void sendUserMessage() {
        Users users = new Users();
        users.setId(1);
        users.setCnname("2");
        users.setMobilePhone("3");
        users.setUsername("4");
        this.rabbitTemplate.convertAndSend(RabbitConfig.REGISTER_QUEUE_NAME,users);
        log.info("[发送时间1] - [{}]", LocalDateTime.now());
    }
}
