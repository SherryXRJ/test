package edu.sherry.demo.testcustomer.controller;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import redis.clients.jedis.ShardedJedis;

import javax.annotation.Resource;


@RestController
@RequestMapping("/testCustomer")
public class TestCustomerController {

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

    @GetMapping("/publish")
    @ResponseBody
    public String publish(){
        jmsTemplate.send("queue", session -> session.createTextMessage("test"));
        return "success";
    }
}
