package edu.sherry.demo.testcustomer.controller;

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


@RestController
@RequestMapping("/testCustomer")
public class TestCustomerController {

    //  queue
    private final String DESINATION_TEST_QUEUE = "sherry.queue.test";

    //  topic
    private final String DESINATION_TEST_TOPIC = "sherry.topic.test";


    @Resource(name = "shardedJedis")
    private ShardedJedis shardedJedis;

    @Resource(name = "restTemplate")
    private RestTemplate restTemplate;

    @Resource(name = "jmsTemplate")
    private JmsTemplate jmsTemplate;

    @GetMapping("/get")
    public String get() {
        return shardedJedis.get("k1");
    }

}
