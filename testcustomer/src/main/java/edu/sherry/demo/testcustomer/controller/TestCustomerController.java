package edu.sherry.demo.testcustomer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping("/get")
    public String get() {
        return shardedJedis.get("k1");
    }
}
