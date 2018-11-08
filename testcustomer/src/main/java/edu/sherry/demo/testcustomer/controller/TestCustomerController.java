package edu.sherry.demo.testcustomer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.ShardedJedis;

import javax.annotation.Resource;


@RestController
@RequestMapping("/testCustomer")
public class TestCustomerController {

    @Resource(name = "ShardedJedis")
    private ShardedJedis shardedJedis;

    @GetMapping("/get")
    public String get() {
        return shardedJedis.get("k1");
    }
}
