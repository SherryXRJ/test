package edu.sherry.demo.testcustomer.controller;

import edu.sherry.demo.common.entry.MessageEntry;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import redis.clients.jedis.ShardedJedis;

import javax.annotation.Resource;
import javax.jms.*;
import java.util.Random;


@RestController
@RequestMapping("/testCustomer")
public class TestCustomerController {

    @Resource(name = "shardedJedis")
    private ShardedJedis shardedJedis;

    @Resource(name = "restTemplate")
    private RestTemplate restTemplate;

    @Resource(name = "jmsTemplate")
    private JmsTemplate jmsTemplate;

    @Resource(name = "rabbitTemplate")
    private RabbitTemplate rabbitTemplate;

    @Resource(name = "rpcExchange")
    private DirectExchange rpcExchange;

    @GetMapping("/get")
    public String get() {
        return shardedJedis.get("k1");
    }

    @GetMapping("/rabbitmqRpc")
    @ResponseBody
    public MessageEntry rabbitmqRpc() {
        return (MessageEntry) rabbitTemplate.convertSendAndReceive(rpcExchange.getName(), "rpc", new Random().nextInt(100));
    }
}
